package calc;

import org.oorsprong.websamples.ArrayOftCountryCodeAndName;
import org.oorsprong.websamples.TCurrency;
import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.tempuri.*;

public class Calc {

    public void getCalculatorService() {
        CalculatorSoap calculatorSoap = new Calculator().getCalculatorSoap();
        int add = calculatorSoap.add(5, 6);
        int sub = calculatorSoap.subtract(4, 3);
        int mul = calculatorSoap.multiply(2, 2);
        int div = calculatorSoap.divide(10, 2);
        System.out.println("Add:" + add + ", Sub:" + sub + ", Mul:" + mul + ", Div:" + div);
    }

    public void getCountryInfo(){
        CountryInfoServiceSoapType countryInfoServiceSoapType = new CountryInfoService().getCountryInfoServiceSoap();
        ArrayOftCountryCodeAndName listOfCountryCodeAndName = countryInfoServiceSoapType.listOfCountryNamesByName();
        String countryName = countryInfoServiceSoapType.countryISOCode(listOfCountryCodeAndName.getTCountryCodeAndName().get(0).getSISOCode());
        String name = countryInfoServiceSoapType.countryName("India");
        System.out.println("countryName:"+countryName+", Name:"+name);

    }

}

