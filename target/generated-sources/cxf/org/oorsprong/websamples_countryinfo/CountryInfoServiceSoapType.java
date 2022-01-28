package org.oorsprong.websamples_countryinfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2022-01-28T14:41:36.085Z
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", name = "CountryInfoServiceSoapType")
@XmlSeeAlso({org.oorsprong.websamples.ObjectFactory.class})
public interface CountryInfoServiceSoapType {

    /**
     * Returns a struct with all the stored country information. Pass the ISO country code
     */
    @WebMethod(operationName = "FullCountryInfo")
    @RequestWrapper(localName = "FullCountryInfo", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.FullCountryInfo")
    @ResponseWrapper(localName = "FullCountryInfoResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.FullCountryInfoResponse")
    @WebResult(name = "FullCountryInfoResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.TCountryInfo fullCountryInfo(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Returns a link to a picture of the country flag
     */
    @WebMethod(operationName = "CountryFlag")
    @RequestWrapper(localName = "CountryFlag", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryFlag")
    @ResponseWrapper(localName = "CountryFlagResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryFlagResponse")
    @WebResult(name = "CountryFlagResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String countryFlag(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Searches the database for a country by the passed ISO country code
     */
    @WebMethod(operationName = "CountryName")
    @RequestWrapper(localName = "CountryName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryName")
    @ResponseWrapper(localName = "CountryNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryNameResponse")
    @WebResult(name = "CountryNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String countryName(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Returns the currency ISO code and name for the passed country ISO code
     */
    @WebMethod(operationName = "CountryCurrency")
    @RequestWrapper(localName = "CountryCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryCurrency")
    @ResponseWrapper(localName = "CountryCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryCurrencyResponse")
    @WebResult(name = "CountryCurrencyResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.TCurrency countryCurrency(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Returns a list of all stored counties ordered by ISO code
     */
    @WebMethod(operationName = "ListOfCountryNamesByCode")
    @RequestWrapper(localName = "ListOfCountryNamesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesByCode")
    @ResponseWrapper(localName = "ListOfCountryNamesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesByCodeResponse")
    @WebResult(name = "ListOfCountryNamesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCountryCodeAndName listOfCountryNamesByCode()
;

    /**
     * Returns a list of currencies ordered by name.
     */
    @WebMethod(operationName = "ListOfCurrenciesByName")
    @RequestWrapper(localName = "ListOfCurrenciesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCurrenciesByName")
    @ResponseWrapper(localName = "ListOfCurrenciesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCurrenciesByNameResponse")
    @WebResult(name = "ListOfCurrenciesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCurrency listOfCurrenciesByName()
;

    /**
     * Returns the internation phone code for the passed ISO country code
     */
    @WebMethod(operationName = "CountryIntPhoneCode")
    @RequestWrapper(localName = "CountryIntPhoneCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryIntPhoneCode")
    @ResponseWrapper(localName = "CountryIntPhoneCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryIntPhoneCodeResponse")
    @WebResult(name = "CountryIntPhoneCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String countryIntPhoneCode(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Returns the name of the currency (if found)
     */
    @WebMethod(operationName = "CurrencyName")
    @RequestWrapper(localName = "CurrencyName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CurrencyName")
    @ResponseWrapper(localName = "CurrencyNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CurrencyNameResponse")
    @WebResult(name = "CurrencyNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String currencyName(

        @WebParam(name = "sCurrencyISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCurrencyISOCode
    );

    /**
     * Returns a list of currencies ordered by code.
     */
    @WebMethod(operationName = "ListOfCurrenciesByCode")
    @RequestWrapper(localName = "ListOfCurrenciesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCurrenciesByCode")
    @ResponseWrapper(localName = "ListOfCurrenciesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCurrenciesByCodeResponse")
    @WebResult(name = "ListOfCurrenciesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCurrency listOfCurrenciesByCode()
;

    /**
     * Returns an array of languages ordered by code
     */
    @WebMethod(operationName = "ListOfLanguagesByCode")
    @RequestWrapper(localName = "ListOfLanguagesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfLanguagesByCode")
    @ResponseWrapper(localName = "ListOfLanguagesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfLanguagesByCodeResponse")
    @WebResult(name = "ListOfLanguagesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftLanguage listOfLanguagesByCode()
;

    /**
     * Find a language ISO code based on the passed language name
     */
    @WebMethod(operationName = "LanguageISOCode")
    @RequestWrapper(localName = "LanguageISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.LanguageISOCode")
    @ResponseWrapper(localName = "LanguageISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.LanguageISOCodeResponse")
    @WebResult(name = "LanguageISOCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String languageISOCode(

        @WebParam(name = "sLanguageName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sLanguageName
    );

    /**
     * Returns the  name of the captial city for the passed country code
     */
    @WebMethod(operationName = "CapitalCity")
    @RequestWrapper(localName = "CapitalCity", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CapitalCity")
    @ResponseWrapper(localName = "CapitalCityResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CapitalCityResponse")
    @WebResult(name = "CapitalCityResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String capitalCity(

        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryISOCode
    );

    /**
     * Returns an array of languages ordered by name
     */
    @WebMethod(operationName = "ListOfLanguagesByName")
    @RequestWrapper(localName = "ListOfLanguagesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfLanguagesByName")
    @ResponseWrapper(localName = "ListOfLanguagesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfLanguagesByNameResponse")
    @WebResult(name = "ListOfLanguagesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftLanguage listOfLanguagesByName()
;

    /**
     * Returns a list of all stored counties grouped per continent
     */
    @WebMethod(operationName = "ListOfCountryNamesGroupedByContinent")
    @RequestWrapper(localName = "ListOfCountryNamesGroupedByContinent", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesGroupedByContinent")
    @ResponseWrapper(localName = "ListOfCountryNamesGroupedByContinentResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesGroupedByContinentResponse")
    @WebResult(name = "ListOfCountryNamesGroupedByContinentResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCountryCodeAndNameGroupedByContinent listOfCountryNamesGroupedByContinent()
;

    /**
     * Returns a list of all stored counties ordered by country name
     */
    @WebMethod(operationName = "ListOfCountryNamesByName")
    @RequestWrapper(localName = "ListOfCountryNamesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesByName")
    @ResponseWrapper(localName = "ListOfCountryNamesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfCountryNamesByNameResponse")
    @WebResult(name = "ListOfCountryNamesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCountryCodeAndName listOfCountryNamesByName()
;

    /**
     * Returns a list of continents ordered by name.
     */
    @WebMethod(operationName = "ListOfContinentsByName")
    @RequestWrapper(localName = "ListOfContinentsByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfContinentsByName")
    @ResponseWrapper(localName = "ListOfContinentsByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfContinentsByNameResponse")
    @WebResult(name = "ListOfContinentsByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftContinent listOfContinentsByName()
;

    /**
     * Find a language name based on the passed ISO language code
     */
    @WebMethod(operationName = "LanguageName")
    @RequestWrapper(localName = "LanguageName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.LanguageName")
    @ResponseWrapper(localName = "LanguageNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.LanguageNameResponse")
    @WebResult(name = "LanguageNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String languageName(

        @WebParam(name = "sISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sISOCode
    );

    /**
     * Returns a list of continents ordered by code.
     */
    @WebMethod(operationName = "ListOfContinentsByCode")
    @RequestWrapper(localName = "ListOfContinentsByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfContinentsByCode")
    @ResponseWrapper(localName = "ListOfContinentsByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.ListOfContinentsByCodeResponse")
    @WebResult(name = "ListOfContinentsByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftContinent listOfContinentsByCode()
;

    /**
     * Returns a list of all countries that use the same currency code. Pass a ISO currency code
     */
    @WebMethod(operationName = "CountriesUsingCurrency")
    @RequestWrapper(localName = "CountriesUsingCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountriesUsingCurrency")
    @ResponseWrapper(localName = "CountriesUsingCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountriesUsingCurrencyResponse")
    @WebResult(name = "CountriesUsingCurrencyResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCountryCodeAndName countriesUsingCurrency(

        @WebParam(name = "sISOCurrencyCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sISOCurrencyCode
    );

    /**
     * This function tries to found a country based on the passed country name.
     */
    @WebMethod(operationName = "CountryISOCode")
    @RequestWrapper(localName = "CountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryISOCode")
    @ResponseWrapper(localName = "CountryISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.CountryISOCodeResponse")
    @WebResult(name = "CountryISOCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public java.lang.String countryISOCode(

        @WebParam(name = "sCountryName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        java.lang.String sCountryName
    );

    /**
     * Returns an array with all countries and all the language information stored
     */
    @WebMethod(operationName = "FullCountryInfoAllCountries")
    @RequestWrapper(localName = "FullCountryInfoAllCountries", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.FullCountryInfoAllCountries")
    @ResponseWrapper(localName = "FullCountryInfoAllCountriesResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "org.oorsprong.websamples.FullCountryInfoAllCountriesResponse")
    @WebResult(name = "FullCountryInfoAllCountriesResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    public org.oorsprong.websamples.ArrayOftCountryInfo fullCountryInfoAllCountries()
;
}
