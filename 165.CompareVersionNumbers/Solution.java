public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");

    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
        Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
        Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
        int compare = v1.compareTo(v2);
        if (compare != 0) {
            return compare;
        }
    }

    return 0;
}
/*mine
public int compareVersion(String version1, String version2) {
        //Assume version1 and version2 strings are valid.
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int i = 0;
        for(i = 0; i < parts1.length && i < parts2.length; i++) {
            if(Integer.parseInt(parts1[i]) < Integer.parseInt(parts2[i])) {
                return -1;
            } else if(Integer.parseInt(parts1[i]) > Integer.parseInt(parts2[i])) {
                return 1;
            }
        }
        if(parts1.length == parts2.length) return 0;
        
        String[] remain = parts1.length > parts2.length ? parts1 : parts2;
        while(i < remain.length) {
            if(Integer.parseInt(remain[i]) > 0) return remain == parts1 ? 1 : -1;
            i++;
        }
        
        return 0;
    }*/