/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class Search {
    String searchTerms;
    Filter filter;
    
    
    Search(String searchTerms, String filterCompanyName, int filterDistance, String filterZipCode){
        this.searchTerms = searchTerms;
        if(!filterCompanyName.equals("") || filterDistance != 0 || !filterZipCode.equals("")){
             filter = new Filter(filterCompanyName, filterDistance, filterZipCode);
        }
    }
    
    public String getSearchTerms(){
        return searchTerms;
    }
    
    public void setSearchTerms(String searchTerms){
        this.searchTerms = searchTerms;
    }
    
    public String getCompanyNameFilter(){
        return filter.getCompanyName();
    }
    
    public int getDistanceFilter(){
        return filter.getDistance();
    }
    
    public String getZipCodeFilter(){
        return filter.getZipCode();
    }
}
