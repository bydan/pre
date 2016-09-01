/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.RetencionInvenConstantesFunciones;
import com.bydan.erp.nomina.util.RetencionInvenParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RetencionInvenParameterGeneral;
import com.bydan.erp.nomina.business.entity.RetencionInven;
import com.bydan.erp.nomina.business.logic.RetencionInvenLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class RetencionInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RetencionInvenLogic.class);
	
	protected RetencionInvenDataAccess retencioninvenDataAccess; 	
	protected RetencionInven retencioninven;
	protected List<RetencionInven> retencioninvens;
	protected Object retencioninvenObject;	
	protected List<Object> retencioninvensObject;
	
	public static ClassValidator<RetencionInven> retencioninvenValidator = new ClassValidator<RetencionInven>(RetencionInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RetencionInvenLogicAdditional retencioninvenLogicAdditional=null;
	
	public RetencionInvenLogicAdditional getRetencionInvenLogicAdditional() {
		return this.retencioninvenLogicAdditional;
	}
	
	public void setRetencionInvenLogicAdditional(RetencionInvenLogicAdditional retencioninvenLogicAdditional) {
		try {
			this.retencioninvenLogicAdditional=retencioninvenLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  RetencionInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.retencioninvenDataAccess = new RetencionInvenDataAccess();
			
			this.retencioninvens= new ArrayList<RetencionInven>();
			this.retencioninven= new RetencionInven();
			
			this.retencioninvenObject=new Object();
			this.retencioninvensObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.retencioninvenDataAccess.setConnexionType(this.connexionType);
			this.retencioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RetencionInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.retencioninvenDataAccess = new RetencionInvenDataAccess();
			this.retencioninvens= new ArrayList<RetencionInven>();
			this.retencioninven= new RetencionInven();
			this.retencioninvenObject=new Object();
			this.retencioninvensObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.retencioninvenDataAccess.setConnexionType(this.connexionType);
			this.retencioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RetencionInven getRetencionInven() throws Exception {	
		RetencionInvenLogicAdditional.checkRetencionInvenToGet(retencioninven,this.datosCliente,this.arrDatoGeneral);
		RetencionInvenLogicAdditional.updateRetencionInvenToGet(retencioninven,this.arrDatoGeneral);
		
		return retencioninven;
	}
		
	public void setRetencionInven(RetencionInven newRetencionInven) {
		this.retencioninven = newRetencionInven;
	}
	
	public RetencionInvenDataAccess getRetencionInvenDataAccess() {
		return retencioninvenDataAccess;
	}
	
	public void setRetencionInvenDataAccess(RetencionInvenDataAccess newretencioninvenDataAccess) {
		this.retencioninvenDataAccess = newretencioninvenDataAccess;
	}
	
	public List<RetencionInven> getRetencionInvens() throws Exception {		
		this.quitarRetencionInvensNulos();
		
		RetencionInvenLogicAdditional.checkRetencionInvenToGets(retencioninvens,this.datosCliente,this.arrDatoGeneral);
		
		for (RetencionInven retencioninvenLocal: retencioninvens ) {
			RetencionInvenLogicAdditional.updateRetencionInvenToGet(retencioninvenLocal,this.arrDatoGeneral);
		}
		
		return retencioninvens;
	}
	
	public void setRetencionInvens(List<RetencionInven> newRetencionInvens) {
		this.retencioninvens = newRetencionInvens;
	}
	
	public Object getRetencionInvenObject() {	
		this.retencioninvenObject=this.retencioninvenDataAccess.getEntityObject();
		return this.retencioninvenObject;
	}
		
	public void setRetencionInvenObject(Object newRetencionInvenObject) {
		this.retencioninvenObject = newRetencionInvenObject;
	}
	
	public List<Object> getRetencionInvensObject() {		
		this.retencioninvensObject=this.retencioninvenDataAccess.getEntitiesObject();
		return this.retencioninvensObject;
	}
		
	public void setRetencionInvensObject(List<Object> newRetencionInvensObject) {
		this.retencioninvensObject = newRetencionInvensObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.retencioninvenDataAccess!=null) {
			this.retencioninvenDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			retencioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			retencioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			retencioninven=retencioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			retencioninven=retencioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			retencioninven=retencioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			retencioninven=retencioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		retencioninven = new  RetencionInven();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =retencioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=retencioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =retencioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=retencioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =retencioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencioninven = new  RetencionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=retencioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		retencioninven = new  RetencionInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninven=retencioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		retencioninven = new  RetencionInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninven=retencioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencioninvens = new  ArrayList<RetencionInven>();
		  		  
        try {
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRetencionInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		retencioninvens = new  ArrayList<RetencionInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getTodosRetencionInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosRetencionInvens(String sFinalQuery,Pagination pagination)throws Exception {
		retencioninvens = new  ArrayList<RetencionInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRetencionInven(retencioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRetencionInven(RetencionInven retencioninven) throws Exception {
		Boolean estaValidado=false;
		
		if(retencioninven.getIsNew() || retencioninven.getIsChanged()) { 
			this.invalidValues = retencioninvenValidator.getInvalidValues(retencioninven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(retencioninven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRetencionInven(List<RetencionInven> RetencionInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RetencionInven retencioninvenLocal:retencioninvens) {				
			estaValidadoObjeto=this.validarGuardarRetencionInven(retencioninvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRetencionInven(List<RetencionInven> RetencionInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRetencionInven(retencioninvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRetencionInven(RetencionInven RetencionInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRetencionInven(retencioninven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RetencionInven retencioninven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+retencioninven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RetencionInvenConstantesFunciones.getRetencionInvenLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"retencioninven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RetencionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RetencionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRetencionInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-saveRetencionInvenWithConnection");connexion.begin();			
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSave(this.retencioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RetencionInvenLogicAdditional.updateRetencionInvenToSave(this.retencioninven,this.arrDatoGeneral);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.retencioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRetencionInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRetencionInven(this.retencioninven)) {
				RetencionInvenDataAccess.save(this.retencioninven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSaveAfter(this.retencioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRetencionInven();
			
			connexion.commit();			
			
			if(this.retencioninven.getIsDeleted()) {
				this.retencioninven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRetencionInven()throws Exception {	
		try {	
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSave(this.retencioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RetencionInvenLogicAdditional.updateRetencionInvenToSave(this.retencioninven,this.arrDatoGeneral);
			
			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.retencioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRetencionInven(this.retencioninven)) {			
				RetencionInvenDataAccess.save(this.retencioninven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.retencioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSaveAfter(this.retencioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.retencioninven.getIsDeleted()) {
				this.retencioninven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRetencionInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-saveRetencionInvensWithConnection");connexion.begin();			
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSaves(retencioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRetencionInvens();
			
			Boolean validadoTodosRetencionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RetencionInven retencioninvenLocal:retencioninvens) {		
				if(retencioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RetencionInvenLogicAdditional.updateRetencionInvenToSave(retencioninvenLocal,this.arrDatoGeneral);
	        	
				RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),retencioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRetencionInven(retencioninvenLocal)) {
					RetencionInvenDataAccess.save(retencioninvenLocal, connexion);				
				} else {
					validadoTodosRetencionInven=false;
				}
			}
			
			if(!validadoTodosRetencionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSavesAfter(retencioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRetencionInvens();
			
			connexion.commit();		
			
			this.quitarRetencionInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRetencionInvens()throws Exception {				
		 try {	
			RetencionInvenLogicAdditional.checkRetencionInvenToSaves(retencioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRetencionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RetencionInven retencioninvenLocal:retencioninvens) {				
				if(retencioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RetencionInvenLogicAdditional.updateRetencionInvenToSave(retencioninvenLocal,this.arrDatoGeneral);
	        	
				RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),retencioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRetencionInven(retencioninvenLocal)) {				
					RetencionInvenDataAccess.save(retencioninvenLocal, connexion);				
				} else {
					validadoTodosRetencionInven=false;
				}
			}
			
			if(!validadoTodosRetencionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RetencionInvenLogicAdditional.checkRetencionInvenToSavesAfter(retencioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRetencionInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionInvenParameterReturnGeneral procesarAccionRetencionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionInven> retencioninvens,RetencionInvenParameterReturnGeneral retencioninvenParameterGeneral)throws Exception {
		 try {	
			RetencionInvenParameterReturnGeneral retencioninvenReturnGeneral=new RetencionInvenParameterReturnGeneral();
	
			RetencionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencioninvens,retencioninvenParameterGeneral,retencioninvenReturnGeneral);
			
			return retencioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionInvenParameterReturnGeneral procesarAccionRetencionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionInven> retencioninvens,RetencionInvenParameterReturnGeneral retencioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-procesarAccionRetencionInvensWithConnection");connexion.begin();			
			
			RetencionInvenParameterReturnGeneral retencioninvenReturnGeneral=new RetencionInvenParameterReturnGeneral();
	
			RetencionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencioninvens,retencioninvenParameterGeneral,retencioninvenReturnGeneral);
			
			this.connexion.commit();
			
			return retencioninvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RetencionInvenParameterReturnGeneral procesarEventosRetencionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RetencionInven> retencioninvens,RetencionInven retencioninven,RetencionInvenParameterReturnGeneral retencioninvenParameterGeneral,Boolean isEsNuevoRetencionInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			RetencionInvenParameterReturnGeneral retencioninvenReturnGeneral=new RetencionInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				retencioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RetencionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,retencioninvens,retencioninven,retencioninvenParameterGeneral,retencioninvenReturnGeneral,isEsNuevoRetencionInven,clases);
			
			return retencioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RetencionInvenParameterReturnGeneral procesarEventosRetencionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RetencionInven> retencioninvens,RetencionInven retencioninven,RetencionInvenParameterReturnGeneral retencioninvenParameterGeneral,Boolean isEsNuevoRetencionInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-procesarEventosRetencionInvensWithConnection");connexion.begin();			
			
			RetencionInvenParameterReturnGeneral retencioninvenReturnGeneral=new RetencionInvenParameterReturnGeneral();
	
			retencioninvenReturnGeneral.setRetencionInven(retencioninven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				retencioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RetencionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,retencioninvens,retencioninven,retencioninvenParameterGeneral,retencioninvenReturnGeneral,isEsNuevoRetencionInven,clases);
			
			this.connexion.commit();
			
			return retencioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RetencionInvenParameterReturnGeneral procesarImportacionRetencionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RetencionInvenParameterReturnGeneral retencioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-procesarImportacionRetencionInvensWithConnection");connexion.begin();			
			
			RetencionInvenParameterReturnGeneral retencioninvenReturnGeneral=new RetencionInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.retencioninvens=new ArrayList<RetencionInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.retencioninven=new RetencionInven();
				
				
				if(conColumnasBase) {this.retencioninven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.retencioninven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.retencioninven.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencioninven.setbase_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencioninven.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencioninven.setnumero_retencion(arrColumnas[iColumn++]);
				
				this.retencioninvens.add(this.retencioninven);
			}
			
			this.saveRetencionInvens();
			
			this.connexion.commit();
			
			retencioninvenReturnGeneral.setConRetornoEstaProcesado(true);
			retencioninvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return retencioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRetencionInvensEliminados() throws Exception {				
		
		List<RetencionInven> retencioninvensAux= new ArrayList<RetencionInven>();
		
		for(RetencionInven retencioninven:retencioninvens) {
			if(!retencioninven.getIsDeleted()) {
				retencioninvensAux.add(retencioninven);
			}
		}
		
		retencioninvens=retencioninvensAux;
	}
	
	public void quitarRetencionInvensNulos() throws Exception {				
		
		List<RetencionInven> retencioninvensAux= new ArrayList<RetencionInven>();
		
		for(RetencionInven retencioninven : this.retencioninvens) {
			if(retencioninven==null) {
				retencioninvensAux.add(retencioninven);
			}
		}
		
		//this.retencioninvens=retencioninvensAux;
		
		this.retencioninvens.removeAll(retencioninvensAux);
	}
	
	public void getSetVersionRowRetencionInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(retencioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((retencioninven.getIsDeleted() || (retencioninven.getIsChanged()&&!retencioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=retencioninvenDataAccess.getSetVersionRowRetencionInven(connexion,retencioninven.getId());
				
				if(!retencioninven.getVersionRow().equals(timestamp)) {	
					retencioninven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				retencioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRetencionInven()throws Exception {	
		
		if(retencioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((retencioninven.getIsDeleted() || (retencioninven.getIsChanged()&&!retencioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=retencioninvenDataAccess.getSetVersionRowRetencionInven(connexion,retencioninven.getId());
			
			try {							
				if(!retencioninven.getVersionRow().equals(timestamp)) {	
					retencioninven.setVersionRow(timestamp);
				}
				
				retencioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRetencionInvensWithConnection()throws Exception {	
		if(retencioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RetencionInven retencioninvenAux:retencioninvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(retencioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(retencioninvenAux.getIsDeleted() || (retencioninvenAux.getIsChanged()&&!retencioninvenAux.getIsNew())) {
						
						timestamp=retencioninvenDataAccess.getSetVersionRowRetencionInven(connexion,retencioninvenAux.getId());
						
						if(!retencioninven.getVersionRow().equals(timestamp)) {	
							retencioninvenAux.setVersionRow(timestamp);
						}
								
						retencioninvenAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRetencionInvens()throws Exception {	
		if(retencioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RetencionInven retencioninvenAux:retencioninvens) {
					if(retencioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(retencioninvenAux.getIsDeleted() || (retencioninvenAux.getIsChanged()&&!retencioninvenAux.getIsNew())) {
						
						timestamp=retencioninvenDataAccess.getSetVersionRowRetencionInven(connexion,retencioninvenAux.getId());
						
						if(!retencioninvenAux.getVersionRow().equals(timestamp)) {	
							retencioninvenAux.setVersionRow(timestamp);
						}
						
													
						retencioninvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RetencionInvenParameterReturnGeneral cargarCombosLoteForeignKeyRetencionInvenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCompra,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		RetencionInvenParameterReturnGeneral  retencioninvenReturnGeneral =new RetencionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyRetencionInvenWithConnection");connexion.begin();
			
			retencioninvenReturnGeneral =new RetencionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			retencioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			retencioninvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			retencioninvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			retencioninvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			retencioninvenReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			//tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			retencioninvenReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			retencioninvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			retencioninvenReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			retencioninvenReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return retencioninvenReturnGeneral;
	}
	
	public RetencionInvenParameterReturnGeneral cargarCombosLoteForeignKeyRetencionInven(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCompra,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		RetencionInvenParameterReturnGeneral  retencioninvenReturnGeneral =new RetencionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			retencioninvenReturnGeneral =new RetencionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			retencioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			retencioninvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			retencioninvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			retencioninvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			retencioninvenReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			//tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			retencioninvenReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			retencioninvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			retencioninvenReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			retencioninvenReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return retencioninvenReturnGeneral;
	}
	
	
	public void deepLoad(RetencionInven retencioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RetencionInvenLogicAdditional.updateRetencionInvenToGet(retencioninven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
		retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
		retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
		retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
		retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
		retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
		retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
		retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
		retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencioninven.getEmpresa(),isDeep,deepLoadType,clases);
				
		retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(retencioninven.getSucursal(),isDeep,deepLoadType,clases);
				
		retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(retencioninven.getEjercicio(),isDeep,deepLoadType,clases);
				
		retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(retencioninven.getPeriodo(),isDeep,deepLoadType,clases);
				
		retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(retencioninven.getCompra(),isDeep,deepLoadType,clases);
				
		retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(retencioninven.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(retencioninven.getCuentaContable(),isDeep,deepLoadType,clases);
				
		retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(retencioninven.getAnio(),isDeep,deepLoadType,clases);
				
		retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(retencioninven.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(retencioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(retencioninven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(retencioninven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(retencioninven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(retencioninven.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(retencioninven.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(retencioninven.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(retencioninven.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(retencioninven.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setEmpresa(retencioninvenDataAccess.getEmpresa(connexion,retencioninven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(retencioninven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setSucursal(retencioninvenDataAccess.getSucursal(connexion,retencioninven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(retencioninven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setEjercicio(retencioninvenDataAccess.getEjercicio(connexion,retencioninven));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(retencioninven.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setPeriodo(retencioninvenDataAccess.getPeriodo(connexion,retencioninven));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(retencioninven.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setCompra(retencioninvenDataAccess.getCompra(connexion,retencioninven));
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(retencioninven.getCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setTipoRetencion(retencioninvenDataAccess.getTipoRetencion(connexion,retencioninven));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(retencioninven.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setCuentaContable(retencioninvenDataAccess.getCuentaContable(connexion,retencioninven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(retencioninven.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setAnio(retencioninvenDataAccess.getAnio(connexion,retencioninven));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(retencioninven.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencioninven.setMes(retencioninvenDataAccess.getMes(connexion,retencioninven));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(retencioninven.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RetencionInven retencioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RetencionInvenLogicAdditional.updateRetencionInvenToSave(retencioninven,this.arrDatoGeneral);
			
RetencionInvenDataAccess.save(retencioninven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(retencioninven.getEmpresa(),connexion);

		SucursalDataAccess.save(retencioninven.getSucursal(),connexion);

		EjercicioDataAccess.save(retencioninven.getEjercicio(),connexion);

		PeriodoDataAccess.save(retencioninven.getPeriodo(),connexion);

		CompraDataAccess.save(retencioninven.getCompra(),connexion);

		TipoRetencionDataAccess.save(retencioninven.getTipoRetencion(),connexion);

		CuentaContableDataAccess.save(retencioninven.getCuentaContable(),connexion);

		AnioDataAccess.save(retencioninven.getAnio(),connexion);

		MesDataAccess.save(retencioninven.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(retencioninven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(retencioninven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(retencioninven.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(retencioninven.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(retencioninven.getCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(retencioninven.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(retencioninven.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(retencioninven.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(retencioninven.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(retencioninven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencioninven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(retencioninven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(retencioninven.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(retencioninven.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(retencioninven.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(retencioninven.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(retencioninven.getPeriodo(),isDeep,deepLoadType,clases);
				

		CompraDataAccess.save(retencioninven.getCompra(),connexion);
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(retencioninven.getCompra(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(retencioninven.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(retencioninven.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(retencioninven.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(retencioninven.getCuentaContable(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(retencioninven.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(retencioninven.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(retencioninven.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(retencioninven.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(retencioninven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(retencioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(retencioninven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(retencioninven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(retencioninven.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(retencioninven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(retencioninven.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(retencioninven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(retencioninven.getCompra(),connexion);
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepSave(retencioninven.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(retencioninven.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(retencioninven.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(retencioninven.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(retencioninven.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(retencioninven.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(retencioninven.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(retencioninven.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(retencioninven.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RetencionInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(retencioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(retencioninven);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.retencioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RetencionInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(retencioninvens!=null) {
				for(RetencionInven retencioninven:retencioninvens) {
					this.deepLoad(retencioninven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(retencioninvens);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(retencioninvens!=null) {
				for(RetencionInven retencioninven:retencioninvens) {
					this.deepLoad(retencioninven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(retencioninvens);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(RetencionInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(retencioninven,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(RetencionInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(retencioninvens!=null) {
				for(RetencionInven retencioninven:retencioninvens) {
					this.deepSave(retencioninven,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(retencioninvens!=null) {
				for(RetencionInven retencioninven:retencioninvens) {
					this.deepSave(retencioninven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRetencionInvensFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RetencionInvenConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RetencionInvenConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,RetencionInvenConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdCompra(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,RetencionInvenConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,RetencionInvenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,RetencionInvenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RetencionInvenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RetencionInvenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RetencionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RetencionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RetencionInvenConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RetencionInvenConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RetencionInvenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RetencionInvenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RetencionInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RetencionInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionInvensFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,RetencionInvenConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionInvensFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,RetencionInvenConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			RetencionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(this.retencioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RetencionInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RetencionInven retencioninven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RetencionInvenConstantesFunciones.ISCONAUDITORIA) {
				if(retencioninven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionInvenDataAccess.TABLENAME, retencioninven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RetencionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RetencionInvenLogic.registrarAuditoriaDetallesRetencionInven(connexion,retencioninven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(retencioninven.getIsDeleted()) {
					/*if(!retencioninven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RetencionInvenDataAccess.TABLENAME, retencioninven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RetencionInvenLogic.registrarAuditoriaDetallesRetencionInven(connexion,retencioninven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionInvenDataAccess.TABLENAME, retencioninven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(retencioninven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionInvenDataAccess.TABLENAME, retencioninven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RetencionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RetencionInvenLogic.registrarAuditoriaDetallesRetencionInven(connexion,retencioninven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRetencionInven(Connexion connexion,RetencionInven retencioninven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(retencioninven.getIsNew()||!retencioninven.getid_empresa().equals(retencioninven.getRetencionInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_empresa().toString();
				}
				if(retencioninven.getid_empresa()!=null)
				{
					strValorNuevo=retencioninven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_sucursal().equals(retencioninven.getRetencionInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_sucursal().toString();
				}
				if(retencioninven.getid_sucursal()!=null)
				{
					strValorNuevo=retencioninven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_ejercicio().equals(retencioninven.getRetencionInvenOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_ejercicio()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_ejercicio().toString();
				}
				if(retencioninven.getid_ejercicio()!=null)
				{
					strValorNuevo=retencioninven.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_periodo().equals(retencioninven.getRetencionInvenOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_periodo()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_periodo().toString();
				}
				if(retencioninven.getid_periodo()!=null)
				{
					strValorNuevo=retencioninven.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_compra().equals(retencioninven.getRetencionInvenOriginal().getid_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_compra()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_compra().toString();
				}
				if(retencioninven.getid_compra()!=null)
				{
					strValorNuevo=retencioninven.getid_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_tipo_retencion().equals(retencioninven.getRetencionInvenOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_tipo_retencion().toString();
				}
				if(retencioninven.getid_tipo_retencion()!=null)
				{
					strValorNuevo=retencioninven.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getporcentaje().equals(retencioninven.getRetencionInvenOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getporcentaje()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getporcentaje().toString();
				}
				if(retencioninven.getporcentaje()!=null)
				{
					strValorNuevo=retencioninven.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getbase_imponible().equals(retencioninven.getRetencionInvenOriginal().getbase_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getbase_imponible()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getbase_imponible().toString();
				}
				if(retencioninven.getbase_imponible()!=null)
				{
					strValorNuevo=retencioninven.getbase_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.BASEIMPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getretencion().equals(retencioninven.getRetencionInvenOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getretencion()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getretencion().toString();
				}
				if(retencioninven.getretencion()!=null)
				{
					strValorNuevo=retencioninven.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getnumero_retencion().equals(retencioninven.getRetencionInvenOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getnumero_retencion()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getnumero_retencion();
				}
				if(retencioninven.getnumero_retencion()!=null)
				{
					strValorNuevo=retencioninven.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_cuenta_contable().equals(retencioninven.getRetencionInvenOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_cuenta_contable().toString();
				}
				if(retencioninven.getid_cuenta_contable()!=null)
				{
					strValorNuevo=retencioninven.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_anio().equals(retencioninven.getRetencionInvenOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_anio()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_anio().toString();
				}
				if(retencioninven.getid_anio()!=null)
				{
					strValorNuevo=retencioninven.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getid_mes().equals(retencioninven.getRetencionInvenOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getid_mes()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getid_mes().toString();
				}
				if(retencioninven.getid_mes()!=null)
				{
					strValorNuevo=retencioninven.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getnumero_serie_retencion().equals(retencioninven.getRetencionInvenOriginal().getnumero_serie_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getnumero_serie_retencion()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getnumero_serie_retencion().toString();
				}
				if(retencioninven.getnumero_serie_retencion()!=null)
				{
					strValorNuevo=retencioninven.getnumero_serie_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.NUMEROSERIERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencioninven.getIsNew()||!retencioninven.getcodigo().equals(retencioninven.getRetencionInvenOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencioninven.getRetencionInvenOriginal().getcodigo()!=null)
				{
					strValorActual=retencioninven.getRetencionInvenOriginal().getcodigo();
				}
				if(retencioninven.getcodigo()!=null)
				{
					strValorNuevo=retencioninven.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionInvenConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRetencionInvenRelacionesWithConnection(RetencionInven retencioninven) throws Exception {

		if(!retencioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRetencionInvenRelacionesBase(retencioninven,true);
		}
	}

	public void saveRetencionInvenRelaciones(RetencionInven retencioninven)throws Exception {

		if(!retencioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRetencionInvenRelacionesBase(retencioninven,false);
		}
	}

	public void saveRetencionInvenRelacionesBase(RetencionInven retencioninven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RetencionInven-saveRelacionesWithConnection");}
	

			this.setRetencionInven(retencioninven);

			if(RetencionInvenLogicAdditional.validarSaveRelaciones(retencioninven,this)) {

				RetencionInvenLogicAdditional.updateRelacionesToSave(retencioninven,this);

				if((retencioninven.getIsNew()||retencioninven.getIsChanged())&&!retencioninven.getIsDeleted()) {
					this.saveRetencionInven();
					this.saveRetencionInvenRelacionesDetalles();

				} else if(retencioninven.getIsDeleted()) {
					this.saveRetencionInvenRelacionesDetalles();
					this.saveRetencionInven();
				}

				RetencionInvenLogicAdditional.updateRelacionesToSaveAfter(retencioninven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRetencionInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RetencionInvenConstantesFunciones.getClassesForeignKeysOfRetencionInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RetencionInvenConstantesFunciones.getClassesRelationshipsOfRetencionInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
