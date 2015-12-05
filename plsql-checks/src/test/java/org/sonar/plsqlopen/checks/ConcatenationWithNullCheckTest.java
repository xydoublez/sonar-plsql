/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plsqlopen.checks;

import java.util.Collection;

import org.junit.Test;
import org.sonar.plsqlopen.AnalyzerMessage;

public class ConcatenationWithNullCheckTest extends BaseCheckTest {
    
    @Test
    public void test() {
        Collection<AnalyzerMessage> messages = scanFile("concatenation_with_null.sql", new ConcatenationWithNullCheck());
        final String message = "Review this concatenation with NULL value.";
        AnalyzerMessagesVerifier.verify(messages)
            .next().startsAt(2, 15).endsAt(2, 19).withMessage(message)
            .next().startsAt(3, 15).endsAt(3, 17).withMessage(message)
            .noMore();
    }

}
