package br.com.ismael.foo.operator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ismael.exception.UnsuportedMathOperationException;
import br.com.ismael.request.converters.NumberTreatment;

@RestController
public class average {

	@RequestMapping(value="/average/{numberOne}/{numberTwo}/{numberThree}/{numberFour}", method=RequestMethod.GET)
	public Double averages(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo , @PathVariable("numberThree") String numberThree , @PathVariable("numberFour") String numberFour) throws Exception {
		if(!NumberTreatment.isNumeric(numberOne) || !NumberTreatment.isNumeric(numberTwo)){
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double average = ((NumberTreatment.convertToDouble(numberOne) + NumberTreatment.convertToDouble(numberTwo) + NumberTreatment.convertToDouble(numberThree) + NumberTreatment.convertToDouble(numberFour)) / 4);
		return average;
	}

	
}
