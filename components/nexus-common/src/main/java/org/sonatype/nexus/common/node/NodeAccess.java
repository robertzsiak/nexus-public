/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.common.node;

import java.security.cert.Certificate;
import java.util.Set;

import javax.annotation.Nullable;

import org.sonatype.goodies.lifecycle.Lifecycle;

/**
 * Provides access to node details.
 * 
 * @since 3.1
 */
public interface NodeAccess
    extends Lifecycle
{
  /**
   * Returns the local-node certificate.
   */
  Certificate getCertificate();

  /**
   * Returns the local-node fingerprint.
   *
   * This is the SHA1 of the certificate.
   */
  String getFingerprint();

  /**
   * Returns the local-node identifier.
   * <p/>
   * ID is based on certificate fingerprint digest encoded with "-" every 8 characters for better human readability while
   * remaining terse:
   * <p/>
   * <pre>05F4743F-A7565846-43FDF9D0-577BE4FB-079289C6</pre>
   */
  String getId();

  /**
   * Returns true if the node is clustered.
   */
  boolean isClustered();

  /**
   * Returns identifiers of clustered nodes.
   */
  Set<String> getMemberIds();

  /**
   * Is this a newly created node?
   *
   * @since 3.3
   */
  boolean isFreshNode();

  /**
   * Is this the oldest node in the cluster?
   *
   * @since 3.3
   */
  boolean isOldestNode();

  /**
   * Marks the node with the matching nodeId with the given friendly name
   *
   * @since 3.6
   *
   * @param nodeId identifier of the node to mark
   * @param friendlyName node's friendly name
   */
  void setFriendlyName(String nodeId, String friendlyName);

  /**
   * Retrieves the friendly name of the node with the specified nodeId
   *
   * @since 3.6
   *
   * @param nodeId identifier of the marked node
   * @return node's friendly name
   */
  @Nullable
  String getFriendlyName(String nodeId);
}
