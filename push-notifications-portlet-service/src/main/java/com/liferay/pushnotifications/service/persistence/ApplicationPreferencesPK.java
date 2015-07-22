package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Bruno Farache
 * @generated
 */
public class ApplicationPreferencesPK implements Comparable<ApplicationPreferencesPK>,
    Serializable {
    public long applicationPreferenceId;
    public long applicationId;

    public ApplicationPreferencesPK() {
    }

    public ApplicationPreferencesPK(long applicationPreferenceId,
        long applicationId) {
        this.applicationPreferenceId = applicationPreferenceId;
        this.applicationId = applicationId;
    }

    public long getApplicationPreferenceId() {
        return applicationPreferenceId;
    }

    public void setApplicationPreferenceId(long applicationPreferenceId) {
        this.applicationPreferenceId = applicationPreferenceId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public int compareTo(ApplicationPreferencesPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (applicationPreferenceId < pk.applicationPreferenceId) {
            value = -1;
        } else if (applicationPreferenceId > pk.applicationPreferenceId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (applicationId < pk.applicationId) {
            value = -1;
        } else if (applicationId > pk.applicationId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApplicationPreferencesPK)) {
            return false;
        }

        ApplicationPreferencesPK pk = (ApplicationPreferencesPK) obj;

        if ((applicationPreferenceId == pk.applicationPreferenceId) &&
                (applicationId == pk.applicationId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(applicationPreferenceId) +
        String.valueOf(applicationId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("applicationPreferenceId");
        sb.append(StringPool.EQUAL);
        sb.append(applicationPreferenceId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("applicationId");
        sb.append(StringPool.EQUAL);
        sb.append(applicationId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
