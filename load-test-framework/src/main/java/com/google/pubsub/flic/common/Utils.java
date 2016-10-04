// Copyright 2016 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////
package com.google.pubsub.flic.common;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.nio.charset.Charset;
import java.util.Arrays;

/** A collection of common methods/enums/constants. */
public class Utils {

  /**
   * Creates a string message of a certain size.
   */
  public static String createMessage(int msgSize) {
    byte[] payloadArray = new byte[msgSize];
    Arrays.fill(payloadArray, (byte) 'A');
    return new String(payloadArray, Charset.forName("UTF-8"));
  }

  /**
   * A validator that makes sure the parameter is an integer that is greater than 0.
   */
  public static class GreaterThanZeroValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
      try {
        int n = Integer.parseInt(value);
        if (n > 0) return;
        throw new NumberFormatException();
      } catch (NumberFormatException e) {
        throw new ParameterException(
            "Parameter " + name + " should be an int greater than 0 (found " + value + ")");
      }
    }
  }
}
