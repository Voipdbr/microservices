package br.com.ismael.foo.operator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ismael.exception.UnsuportedMathOperationException;
import br.com.ismael.request.converters.NumberTreatment;

@RestController
public class squareroot {

	@RequestMapping(value="/squareroot/{numberOne}", method=RequestMethod.GET)
	public Double squareroots(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!NumberTreatment.isNumeric(numberOne)){
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double squareroot = (Double) Math.sqrt(NumberTreatment.convertToDouble(numberOne));
		return squareroot;
	}
	
}
