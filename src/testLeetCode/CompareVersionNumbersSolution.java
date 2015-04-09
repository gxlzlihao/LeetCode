package testLeetCode;

public class CompareVersionNumbersSolution {
	public int compareVersion(String version1, String version2) {
        int res = 0;
        int comma1 = version1.indexOf(".");
        int comma2 = version2.indexOf(".");
        if ( comma1 == -1 || comma2 == -1 || comma1 == version1.length() - 1 || comma2 == version2.length() - 1 ) {
        	if ( ( comma1 == -1 && comma2 == -1 ) || 
        			( comma1 == version1.length() - 1 && comma2 == -1 ) || 
        			( comma1 == -1 && comma2 == version2.length() - 1 ) || 
        			( comma1 == version1.length() - 1 && comma2 == version2.length() - 1 ) ) {
        		// both versions have no second level
        		if ( comma1 == -1 ) version1 = version1 + ".0";
        		else if ( comma1 == version1.length() - 1 ) version1 = version1 + "0";
        		else version1 = version1;
        		if ( comma2 == -1 ) version2 = version2 + ".0";
        		else if ( comma2 == version2.length() - 1 ) version2 = version2 + "0";
        		else version2 = version2;
        		
        		long currentLevelVersion1 = Long.parseLong( version1.substring( 0, version1.indexOf(".") ), 10 );
        		long currentLevelVersion2 = Long.parseLong( version2.substring( 0, version2.indexOf(".") ), 10 );
        		if ( currentLevelVersion1 > currentLevelVersion2 ) res = 1;
        		else if ( currentLevelVersion1 < currentLevelVersion2 ) res = -1;
        		else res = 0;
        	} else if ( comma1 == -1 || comma1 == version1.length() - 1 ) {
        		// the first version has no second level, but the second version has second level
        		if ( comma1 == -1 ) version1 = version1 + ".0";
        		else if ( comma1 == version1.length() - 1 ) version1 = version1 + "0";
        		else version1 = version1;
        		long currentLevelVersion1 = Long.parseLong( version1.substring( 0, version1.indexOf(".") ), 10 );
        		long currentLevelVersion2 = Long.parseLong( version2.substring( 0, version2.indexOf(".") ), 10 );
        		if ( currentLevelVersion1 > currentLevelVersion2 ) res = 1;
        		else if ( currentLevelVersion1 < currentLevelVersion2 ) res = -1;
        		else if ( isZero( version2.substring( comma2 + 1 ) ) ) res = 0;
        		else res = -1;
        	} else {
        		// the second version has no second level, but the first version has second level
        		if ( comma2 == -1 ) version2 = version2 + ".0";
        		else if ( comma2 == version2.length() - 1 ) version2 = version2 + "0";
        		else version2 = version2;
        		long currentLevelVersion1 = Long.parseLong( version1.substring( 0, version1.indexOf(".") ), 10 );
        		long currentLevelVersion2 = Long.parseLong( version2.substring( 0, version2.indexOf(".") ), 10 );
        		if ( currentLevelVersion1 > currentLevelVersion2 ) res = 1;
        		else if ( currentLevelVersion1 < currentLevelVersion2 ) res = -1;
        		else if ( isZero( version1.substring( comma1 + 1 ) ) ) res = 0;
        		else res = 1;
        	}
        } else {
        	long currentLevelVersion1 = Long.parseLong( version1.substring( 0, comma1 ), 10 );
        	long currentLevelVersion2 = Long.parseLong( version2.substring( 0, comma2 ), 10 );
        	if ( currentLevelVersion1 > currentLevelVersion2 ) res = 1;
        	else if ( currentLevelVersion1 < currentLevelVersion2 ) res = -1;
        	else {
        		res = compareVersion( version1.substring( comma1 + 1, version1.length() ), version2.substring( comma2 + 1, version2.length() ) );
        	}
        }
        return res;
    }
	
	private boolean isZero( String version ) {
		for ( char chr : version.toCharArray() )
			if ( chr != '.' && chr != '0' ) return false;
		return true;
	}
}
