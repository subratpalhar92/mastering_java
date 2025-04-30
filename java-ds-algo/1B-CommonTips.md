# Common Pointers While Manipulating Data In Java

## String -to- Interger -to- int -to- Interger -to- String conversion
```
    int pmtv = Integer.parseInt("123");         /** parseInt        STR->PMTV */

    Integer wrppr = Integer.valueOf(str);       /** valueOf         STR->WRPER */

    new Integer(789)intValue();                 /** intValue        WRPER ->int O|R you can directly assign */

    new Integer(123);  Integer.valueOf(123)     /** new Integer     int->INTGR O|R you can directly assign */

    Integer.toString(123);  new Integer(1415).toString();   /** toString    WRPER|PMTV->STR  */

    NumberFormatException
```


## Operations On String
```
Common Operation
    length()            isEmpty();
    toLowerCase()       toUpperCase()       trim()
    str1.concat(str2)   csvStr.split(",")

    "example".substring(2) /** ample */
    "example".substring(1, 4); // "xam"
    "apple".replace('p', 'b') /** also works with string arguments */
    


Helps In Algorithm
    charAt(0)       "Programming".indexOf("gram") /** 4 */      lastIndexOf("a")

```

## BIT Twidling & HASH
```

```


## JAVA TRICKS
```
```




