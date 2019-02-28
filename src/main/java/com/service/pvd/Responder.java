package com.service.pvd;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@RestController
class Responder {
    @GetMapping("/respond")
        public String all() {
		String head = "<h1>Simple REST application - Java - Spring Boot</h1>";
		String endNote = "<p>end<p>";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.");

		long epoch = System.currentTimeMillis();
		String dateTimeStr = sdf.format(new Date(epoch));
		String dateTimeP = "<p>Date/Time: " + dateTimeStr + "</p>";
		String epochP = "<p>Epoch: " + Long.toString(epoch) + "</p>";

		// read environment variables for delay time in ms.
		Map<String, String> env = System.getenv();
		String delay = env.get("DELAY");

                String response = head + dateTimeP + epochP + endNote + " Delay (ms): " + delay;
                return response;
        }
}
