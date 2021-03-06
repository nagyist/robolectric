package org.robolectric.android;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.TestRunners;
import org.robolectric.res.ResName;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TestRunners.SelfTest.class)
public class ResourceTableFactoryIntegrationTest {
  @Test
  public void shouldIncludeStyleableAttributesThatDoNotHaveACorrespondingEntryInAttrClass() throws Exception {
    // This covers a corner case in Framework resources where an attribute is mentioned in a styleable array, e.g: R.styleable.Toolbar_buttonGravity but there is no corresponding R.attr.buttonGravity
    assertThat(RuntimeEnvironment.getSystemResourceTable().getResourceId(new ResName("android", "attr", "buttonGravity"))).isGreaterThan(0);
  }
}
