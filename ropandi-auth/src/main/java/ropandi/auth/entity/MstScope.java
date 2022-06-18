/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ropandi.auth.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
@Entity
@Table(name = "mst_scope")
@XmlRootElement
public class MstScope implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MstScopePK mstScopePK;
    @Column(name = "value")
    private String value;

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mstScopePK != null ? mstScopePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstScope)) {
            return false;
        }
        MstScope other = (MstScope) object;
        if ((this.mstScopePK == null && other.mstScopePK != null) || (this.mstScopePK != null && !this.mstScopePK.equals(other.mstScopePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MstScope[ mstScopePK=" + mstScopePK + " ]";
    }
    
}
