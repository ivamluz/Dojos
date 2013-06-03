package br.com.cit.dojo.diamond;

public class DiamondBuilder {
    public final char ROOT_LETTER = 'A';
    public final char FINAL_LETTER = 'Z';
    
    public String build(char letter) throws IllegalArgumentException {
        letter = Character.toUpperCase(letter);
        
        validateLetter(letter);
        
        String diamond = "";
        
        if (letter == ROOT_LETTER) {
            diamond = String.valueOf(letter);
        }
        else {
            diamond += openDiamond(letter) + closeDiamond(letter);
        }
            
        return diamond;
    }
    
    protected void validateLetter(char letter) throws IllegalArgumentException {
        if (letter < ROOT_LETTER || letter > FINAL_LETTER) {
            throw new IllegalArgumentException("'letter' parameter should be a char between 'A' and 'Z'.");
        }
    }
    
    protected String openDiamond(char letter) {
        String diamond = "";
        
        for (char currentLetter = ROOT_LETTER; currentLetter <= letter; currentLetter++) {
            if (currentLetter == ROOT_LETTER) {
                diamond += getSpaces(getNumberOfSpacesBeforeRootLetter(letter)) + ROOT_LETTER + String.format("%n");
            }
            else {
                diamond += getSpaces(getDistanceBetweenLetters(currentLetter, letter)) + currentLetter + getSpaces(getNumberOfSpacesBetweenLetter(currentLetter)) + currentLetter + String.format("%n");
            }
        }
        
        return diamond;
    }
    
    protected String closeDiamond(char letter) {
        String diamond = "";
        
        for (char currentLetter = (char)(letter - 1); currentLetter >= ROOT_LETTER; currentLetter--) {
            if (currentLetter == ROOT_LETTER) {
                diamond += getSpaces(getNumberOfSpacesBeforeRootLetter(letter)) + ROOT_LETTER;
            }
            else {
                diamond += getSpaces(getDistanceBetweenLetters(currentLetter, letter)) + currentLetter + getSpaces(getNumberOfSpacesBetweenLetter(currentLetter)) + currentLetter + String.format("%n");
            }
        }
        
        return diamond;
    }
    
    protected int distanceToRootLetter(char letter) {
        return getDistanceBetweenLetters(letter, ROOT_LETTER);
    }
    
    protected int getDistanceBetweenLetters(char firstLetter, char secondLetter) {
        return Math.abs(firstLetter - secondLetter);
    }
    
    protected int getNumberOfSpacesBetweenLetter(char letter) {
        int spaces = 0;
        
        int distance = this.distanceToRootLetter(letter);
        if (distance > 0) {
            spaces = (distance * 2) - 1;
        }
        
        return spaces;
    }
    
    protected int getNumberOfSpacesBeforeRootLetter(char letter) {
        return distanceToRootLetter(letter);
    }
    
    protected String getSpaces(int numberOfSpaces) {
        return new String(new char[numberOfSpaces]).replace("\0", " ");
    }
}
