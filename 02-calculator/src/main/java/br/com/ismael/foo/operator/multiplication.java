package br.com.ismael.foo.operator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ismael.exception.UnsuportedMathOperationException;
import br.com.ismael.request.converters.NumberTreatment;

@RestController
public class multiplication {

	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplications(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberTreatment.isNumeric(numberOne) || !NumberTreatment.isNumeric(numberTwo)){
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double multiplication = (NumberTreatment.convertToDouble(numberOne) * NumberTreatment.convertToDouble(numberTwo));
		return multiplication;
	}
	
}
