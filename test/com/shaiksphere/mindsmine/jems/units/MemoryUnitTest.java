/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.mindsmine.jems.units;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class MemoryUnitTest {
    private final double DELTA = 1e-15;

    private final double KIBI_BYTE  = 1024.0;
    private final double KILO_BYTE  = 1000.0;
    private final double MEBI_BYTE  = 1048576.0;
    private final double MEGA_BYTE  = 1000000.0;
    private final double GIBI_BYTE  = 1073741824.0;
    private final double GIGA_BYTE  = 1000000000.0;
    private final double TEBI_BYTE  = 1099511627776.0;
    private final double TERA_BYTE  = 1000000000000.0;
    private final double PEBI_BYTE  = 1125899906842624.0;
    private final double PETA_BYTE  = 1000000000000000.0;
    private final double EXBI_BYTE  = 1152921504606846976.0;
    private final double EXA_BYTE   = 1000000000000000000.0;
    private final double ZEBI_BYTE  = 1180591620717411303424.0;
    private final double ZETTA_BYTE = 1000000000000000000000.0;
    private final double YOBI_BYTE  = 1208925819614629174706176.0;
    //                                12345678901234567890123456
    private final double YOTTA_BYTE = 1000000000000000000000000.0;
    private final double RANDOM     = 1000000000000000000000000000.0;

    @Test
    public void kibibyteTest() {
        assertEquals(KIBI_BYTE, MemoryUnit.KIBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void mebibyteTest() {
        assertEquals(MEBI_BYTE, MemoryUnit.MEBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void gibibyteTest() {
        assertEquals(GIBI_BYTE, MemoryUnit.GIBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void tebibyteTest() {
        assertEquals(TEBI_BYTE, MemoryUnit.TEBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void pebibyteTest() {
        assertEquals(PEBI_BYTE, MemoryUnit.PEBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void exbibyteTest() {
        assertEquals(EXBI_BYTE, MemoryUnit.EXBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void zebibyteTest() {
        assertEquals(ZEBI_BYTE, MemoryUnit.ZEBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void yobibyteTest() {
        assertEquals(YOBI_BYTE, MemoryUnit.YOBI_BYTE.getByteValue(), DELTA);
    }

    @Test
    public void extractKilobyteTest() {
        assertEquals(MemoryUnit.KIBI_BYTE, MemoryUnit.extract(KILO_BYTE));
    }

    @Test
    public void extractKibibyteTest() {
        assertEquals(MemoryUnit.KIBI_BYTE, MemoryUnit.extract(KIBI_BYTE));
    }

    @Test
    public void extractMegabyteTest() {
        assertEquals(MemoryUnit.MEBI_BYTE, MemoryUnit.extract(MEGA_BYTE));
    }

    @Test
    public void extractMebibyteTest() {
        assertEquals(MemoryUnit.MEBI_BYTE, MemoryUnit.extract(MEBI_BYTE));
    }

    @Test
    public void extractGigabyteTest() {
        assertEquals(MemoryUnit.GIBI_BYTE, MemoryUnit.extract(GIGA_BYTE));
    }

    @Test
    public void extractGibibyteTest() {
        assertEquals(MemoryUnit.GIBI_BYTE, MemoryUnit.extract(GIBI_BYTE));
    }

    @Test
    public void extractTerabyteTest() {
        assertEquals(MemoryUnit.TEBI_BYTE, MemoryUnit.extract(TERA_BYTE));
    }

    @Test
    public void extractTebibyteTest() {
        assertEquals(MemoryUnit.TEBI_BYTE, MemoryUnit.extract(TEBI_BYTE));
    }

    @Test
    public void extractPetabyteTest() {
        assertEquals(MemoryUnit.PEBI_BYTE, MemoryUnit.extract(PETA_BYTE));
    }

    @Test
    public void extractPebibyteTest() {
        assertEquals(MemoryUnit.PEBI_BYTE, MemoryUnit.extract(PEBI_BYTE));
    }

    @Test
    public void extractExabyteTest() {
        assertEquals(MemoryUnit.EXBI_BYTE, MemoryUnit.extract(EXA_BYTE));
    }

    @Test
    public void extractExbibyteTest() {
        assertEquals(MemoryUnit.EXBI_BYTE, MemoryUnit.extract(EXBI_BYTE));
    }

    @Test
    public void extractZettabyteTest() {
        assertEquals(MemoryUnit.ZEBI_BYTE, MemoryUnit.extract(ZETTA_BYTE));
    }

    @Test
    public void extractZebibyteTest() {
        assertEquals(MemoryUnit.ZEBI_BYTE, MemoryUnit.extract(ZEBI_BYTE));
    }

    @Test
    public void extractYottabyteTest() {
        assertEquals(MemoryUnit.YOBI_BYTE, MemoryUnit.extract(YOTTA_BYTE));
    }

    @Test
    public void extractYobibyteTest() {
//        DecimalFormat decimalFormat = new DecimalFormat("#");
//        decimalFormat.setMaximumFractionDigits(0);
//        System.out.println("Formatted   = " + decimalFormat.format(MemoryUnit.YOBI_BYTE.getByteValue()));
//        System.out.println("Unformatted = 1208925819614629174706176.0");
        assertEquals(MemoryUnit.YOBI_BYTE, MemoryUnit.extract(YOBI_BYTE));
    }

    @Test
    public void extractRandomTest() {
        assertEquals(MemoryUnit.YOBI_BYTE, MemoryUnit.extract(RANDOM));
    }
}
