package org.emamotor.heapstats.quickstart.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @see http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
@WebServlet("/run")
public class DeadLockServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final AtomicInteger alphonseLastThreadNum = new AtomicInteger(0);
    private static final AtomicInteger gastonLastThreadNum   = new AtomicInteger(0);

    private static final Logger LOGGER = LoggerFactory.getLogger(DeadLockServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        throw new UnsupportedOperationException("GET method is not supported");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);
            }
        }, "alphonse-thread-" + alphonseLastThreadNum.incrementAndGet()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        }, "gaston-thread-" + gastonLastThreadNum.incrementAndGet()).start();

    }

    static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            LOGGER.info("{}: {} " + "has bowed to me!", name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            LOGGER.info("{}: {} " + "has bowed back to me!", name, bower.getName());
        }
    }

}