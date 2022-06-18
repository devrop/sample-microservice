/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ropandi.auth.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ropandi.auth.entity.MstCredential.MstCredentialBuilder;

/**
 *
 * @author ropandi
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class MstScopePK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;
    @Basic(optional = false)
    @Column(name = "scope_id")
    private String scopeId;

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        hash += (scopeId != null ? scopeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstScopePK)) {
            return false;
        }
        MstScopePK other = (MstScopePK) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        if ((this.scopeId == null && other.scopeId != null) || (this.scopeId != null && !this.scopeId.equals(other.scopeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MstScopePK[ clientId=" + clientId + ", scopeId=" + scopeId + " ]";
    }
    
}
