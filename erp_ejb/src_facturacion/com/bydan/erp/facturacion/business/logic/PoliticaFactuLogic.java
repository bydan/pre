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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.PoliticaFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.PoliticaFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PoliticaFactuParameterGeneral;
import com.bydan.erp.facturacion.business.entity.PoliticaFactu;
import com.bydan.erp.facturacion.business.logic.PoliticaFactuLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class PoliticaFactuLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PoliticaFactuLogic.class);
	
	protected PoliticaFactuDataAccess politicafactuDataAccess; 	
	protected PoliticaFactu politicafactu;
	protected List<PoliticaFactu> politicafactus;
	protected Object politicafactuObject;	
	protected List<Object> politicafactusObject;
	
	public static ClassValidator<PoliticaFactu> politicafactuValidator = new ClassValidator<PoliticaFactu>(PoliticaFactu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PoliticaFactuLogicAdditional politicafactuLogicAdditional=null;
	
	public PoliticaFactuLogicAdditional getPoliticaFactuLogicAdditional() {
		return this.politicafactuLogicAdditional;
	}
	
	public void setPoliticaFactuLogicAdditional(PoliticaFactuLogicAdditional politicafactuLogicAdditional) {
		try {
			this.politicafactuLogicAdditional=politicafactuLogicAdditional;
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
	
	
	
	
	public  PoliticaFactuLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.politicafactuDataAccess = new PoliticaFactuDataAccess();
			
			this.politicafactus= new ArrayList<PoliticaFactu>();
			this.politicafactu= new PoliticaFactu();
			
			this.politicafactuObject=new Object();
			this.politicafactusObject=new ArrayList<Object>();
				
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
			
			this.politicafactuDataAccess.setConnexionType(this.connexionType);
			this.politicafactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PoliticaFactuLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.politicafactuDataAccess = new PoliticaFactuDataAccess();
			this.politicafactus= new ArrayList<PoliticaFactu>();
			this.politicafactu= new PoliticaFactu();
			this.politicafactuObject=new Object();
			this.politicafactusObject=new ArrayList<Object>();
			
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
			
			this.politicafactuDataAccess.setConnexionType(this.connexionType);
			this.politicafactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PoliticaFactu getPoliticaFactu() throws Exception {	
		PoliticaFactuLogicAdditional.checkPoliticaFactuToGet(politicafactu,this.datosCliente,this.arrDatoGeneral);
		PoliticaFactuLogicAdditional.updatePoliticaFactuToGet(politicafactu,this.arrDatoGeneral);
		
		return politicafactu;
	}
		
	public void setPoliticaFactu(PoliticaFactu newPoliticaFactu) {
		this.politicafactu = newPoliticaFactu;
	}
	
	public PoliticaFactuDataAccess getPoliticaFactuDataAccess() {
		return politicafactuDataAccess;
	}
	
	public void setPoliticaFactuDataAccess(PoliticaFactuDataAccess newpoliticafactuDataAccess) {
		this.politicafactuDataAccess = newpoliticafactuDataAccess;
	}
	
	public List<PoliticaFactu> getPoliticaFactus() throws Exception {		
		this.quitarPoliticaFactusNulos();
		
		PoliticaFactuLogicAdditional.checkPoliticaFactuToGets(politicafactus,this.datosCliente,this.arrDatoGeneral);
		
		for (PoliticaFactu politicafactuLocal: politicafactus ) {
			PoliticaFactuLogicAdditional.updatePoliticaFactuToGet(politicafactuLocal,this.arrDatoGeneral);
		}
		
		return politicafactus;
	}
	
	public void setPoliticaFactus(List<PoliticaFactu> newPoliticaFactus) {
		this.politicafactus = newPoliticaFactus;
	}
	
	public Object getPoliticaFactuObject() {	
		this.politicafactuObject=this.politicafactuDataAccess.getEntityObject();
		return this.politicafactuObject;
	}
		
	public void setPoliticaFactuObject(Object newPoliticaFactuObject) {
		this.politicafactuObject = newPoliticaFactuObject;
	}
	
	public List<Object> getPoliticaFactusObject() {		
		this.politicafactusObject=this.politicafactuDataAccess.getEntitiesObject();
		return this.politicafactusObject;
	}
		
	public void setPoliticaFactusObject(List<Object> newPoliticaFactusObject) {
		this.politicafactusObject = newPoliticaFactusObject;
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
		
		if(this.politicafactuDataAccess!=null) {
			this.politicafactuDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			politicafactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			politicafactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		politicafactu = new  PoliticaFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			politicafactu=politicafactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
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
		politicafactu = new  PoliticaFactu();
		  		  
        try {
			
			politicafactu=politicafactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		politicafactu = new  PoliticaFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			politicafactu=politicafactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
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
		politicafactu = new  PoliticaFactu();
		  		  
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
		politicafactu = new  PoliticaFactu();
		  		  
        try {
			
			politicafactu=politicafactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		politicafactu = new  PoliticaFactu();
		  		  
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
		politicafactu = new  PoliticaFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =politicafactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicafactu = new  PoliticaFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=politicafactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		politicafactu = new  PoliticaFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =politicafactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicafactu = new  PoliticaFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=politicafactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		politicafactu = new  PoliticaFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =politicafactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicafactu = new  PoliticaFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=politicafactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		politicafactu = new  PoliticaFactu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactu=politicafactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
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
		politicafactu = new  PoliticaFactu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactu=politicafactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
		politicafactus = new  ArrayList<PoliticaFactu>();
		  		  
        try {
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPoliticaFactusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		politicafactus = new  ArrayList<PoliticaFactu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getTodosPoliticaFactusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
	
	public  void  getTodosPoliticaFactus(String sFinalQuery,Pagination pagination)throws Exception {
		politicafactus = new  ArrayList<PoliticaFactu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPoliticaFactu(politicafactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPoliticaFactu(PoliticaFactu politicafactu) throws Exception {
		Boolean estaValidado=false;
		
		if(politicafactu.getIsNew() || politicafactu.getIsChanged()) { 
			this.invalidValues = politicafactuValidator.getInvalidValues(politicafactu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(politicafactu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPoliticaFactu(List<PoliticaFactu> PoliticaFactus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PoliticaFactu politicafactuLocal:politicafactus) {				
			estaValidadoObjeto=this.validarGuardarPoliticaFactu(politicafactuLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPoliticaFactu(List<PoliticaFactu> PoliticaFactus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPoliticaFactu(politicafactus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPoliticaFactu(PoliticaFactu PoliticaFactu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPoliticaFactu(politicafactu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PoliticaFactu politicafactu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+politicafactu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PoliticaFactuConstantesFunciones.getPoliticaFactuLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"politicafactu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PoliticaFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PoliticaFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePoliticaFactuWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-savePoliticaFactuWithConnection");connexion.begin();			
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSave(this.politicafactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PoliticaFactuLogicAdditional.updatePoliticaFactuToSave(this.politicafactu,this.arrDatoGeneral);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.politicafactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPoliticaFactu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPoliticaFactu(this.politicafactu)) {
				PoliticaFactuDataAccess.save(this.politicafactu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSaveAfter(this.politicafactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPoliticaFactu();
			
			connexion.commit();			
			
			if(this.politicafactu.getIsDeleted()) {
				this.politicafactu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePoliticaFactu()throws Exception {	
		try {	
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSave(this.politicafactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PoliticaFactuLogicAdditional.updatePoliticaFactuToSave(this.politicafactu,this.arrDatoGeneral);
			
			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.politicafactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPoliticaFactu(this.politicafactu)) {			
				PoliticaFactuDataAccess.save(this.politicafactu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.politicafactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSaveAfter(this.politicafactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.politicafactu.getIsDeleted()) {
				this.politicafactu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePoliticaFactusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-savePoliticaFactusWithConnection");connexion.begin();			
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSaves(politicafactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPoliticaFactus();
			
			Boolean validadoTodosPoliticaFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PoliticaFactu politicafactuLocal:politicafactus) {		
				if(politicafactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PoliticaFactuLogicAdditional.updatePoliticaFactuToSave(politicafactuLocal,this.arrDatoGeneral);
	        	
				PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),politicafactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPoliticaFactu(politicafactuLocal)) {
					PoliticaFactuDataAccess.save(politicafactuLocal, connexion);				
				} else {
					validadoTodosPoliticaFactu=false;
				}
			}
			
			if(!validadoTodosPoliticaFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSavesAfter(politicafactus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPoliticaFactus();
			
			connexion.commit();		
			
			this.quitarPoliticaFactusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePoliticaFactus()throws Exception {				
		 try {	
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSaves(politicafactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPoliticaFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PoliticaFactu politicafactuLocal:politicafactus) {				
				if(politicafactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PoliticaFactuLogicAdditional.updatePoliticaFactuToSave(politicafactuLocal,this.arrDatoGeneral);
	        	
				PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),politicafactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPoliticaFactu(politicafactuLocal)) {				
					PoliticaFactuDataAccess.save(politicafactuLocal, connexion);				
				} else {
					validadoTodosPoliticaFactu=false;
				}
			}
			
			if(!validadoTodosPoliticaFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PoliticaFactuLogicAdditional.checkPoliticaFactuToSavesAfter(politicafactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPoliticaFactusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PoliticaFactuParameterReturnGeneral procesarAccionPoliticaFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PoliticaFactu> politicafactus,PoliticaFactuParameterReturnGeneral politicafactuParameterGeneral)throws Exception {
		 try {	
			PoliticaFactuParameterReturnGeneral politicafactuReturnGeneral=new PoliticaFactuParameterReturnGeneral();
	
			PoliticaFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,politicafactus,politicafactuParameterGeneral,politicafactuReturnGeneral);
			
			return politicafactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PoliticaFactuParameterReturnGeneral procesarAccionPoliticaFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PoliticaFactu> politicafactus,PoliticaFactuParameterReturnGeneral politicafactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-procesarAccionPoliticaFactusWithConnection");connexion.begin();			
			
			PoliticaFactuParameterReturnGeneral politicafactuReturnGeneral=new PoliticaFactuParameterReturnGeneral();
	
			PoliticaFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,politicafactus,politicafactuParameterGeneral,politicafactuReturnGeneral);
			
			this.connexion.commit();
			
			return politicafactuReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PoliticaFactuParameterReturnGeneral procesarEventosPoliticaFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PoliticaFactu> politicafactus,PoliticaFactu politicafactu,PoliticaFactuParameterReturnGeneral politicafactuParameterGeneral,Boolean isEsNuevoPoliticaFactu,ArrayList<Classe> clases)throws Exception {
		 try {	
			PoliticaFactuParameterReturnGeneral politicafactuReturnGeneral=new PoliticaFactuParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				politicafactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PoliticaFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,politicafactus,politicafactu,politicafactuParameterGeneral,politicafactuReturnGeneral,isEsNuevoPoliticaFactu,clases);
			
			return politicafactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PoliticaFactuParameterReturnGeneral procesarEventosPoliticaFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PoliticaFactu> politicafactus,PoliticaFactu politicafactu,PoliticaFactuParameterReturnGeneral politicafactuParameterGeneral,Boolean isEsNuevoPoliticaFactu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-procesarEventosPoliticaFactusWithConnection");connexion.begin();			
			
			PoliticaFactuParameterReturnGeneral politicafactuReturnGeneral=new PoliticaFactuParameterReturnGeneral();
	
			politicafactuReturnGeneral.setPoliticaFactu(politicafactu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				politicafactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PoliticaFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,politicafactus,politicafactu,politicafactuParameterGeneral,politicafactuReturnGeneral,isEsNuevoPoliticaFactu,clases);
			
			this.connexion.commit();
			
			return politicafactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PoliticaFactuParameterReturnGeneral procesarImportacionPoliticaFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PoliticaFactuParameterReturnGeneral politicafactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-procesarImportacionPoliticaFactusWithConnection");connexion.begin();			
			
			PoliticaFactuParameterReturnGeneral politicafactuReturnGeneral=new PoliticaFactuParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.politicafactus=new ArrayList<PoliticaFactu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.politicafactu=new PoliticaFactu();
				
				
				if(conColumnasBase) {this.politicafactu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.politicafactu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.politicafactu.setnombre(arrColumnas[iColumn++]);
				this.politicafactu.setfecha_desde(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicafactu.setfecha_hasta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicafactu.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicafactu.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicafactu.setcon_banco_cliente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.politicafactu.setcon_banco_producto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.politicafactu.setes_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.politicafactus.add(this.politicafactu);
			}
			
			this.savePoliticaFactus();
			
			this.connexion.commit();
			
			politicafactuReturnGeneral.setConRetornoEstaProcesado(true);
			politicafactuReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return politicafactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPoliticaFactusEliminados() throws Exception {				
		
		List<PoliticaFactu> politicafactusAux= new ArrayList<PoliticaFactu>();
		
		for(PoliticaFactu politicafactu:politicafactus) {
			if(!politicafactu.getIsDeleted()) {
				politicafactusAux.add(politicafactu);
			}
		}
		
		politicafactus=politicafactusAux;
	}
	
	public void quitarPoliticaFactusNulos() throws Exception {				
		
		List<PoliticaFactu> politicafactusAux= new ArrayList<PoliticaFactu>();
		
		for(PoliticaFactu politicafactu : this.politicafactus) {
			if(politicafactu==null) {
				politicafactusAux.add(politicafactu);
			}
		}
		
		//this.politicafactus=politicafactusAux;
		
		this.politicafactus.removeAll(politicafactusAux);
	}
	
	public void getSetVersionRowPoliticaFactuWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(politicafactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((politicafactu.getIsDeleted() || (politicafactu.getIsChanged()&&!politicafactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=politicafactuDataAccess.getSetVersionRowPoliticaFactu(connexion,politicafactu.getId());
				
				if(!politicafactu.getVersionRow().equals(timestamp)) {	
					politicafactu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				politicafactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPoliticaFactu()throws Exception {	
		
		if(politicafactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((politicafactu.getIsDeleted() || (politicafactu.getIsChanged()&&!politicafactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=politicafactuDataAccess.getSetVersionRowPoliticaFactu(connexion,politicafactu.getId());
			
			try {							
				if(!politicafactu.getVersionRow().equals(timestamp)) {	
					politicafactu.setVersionRow(timestamp);
				}
				
				politicafactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPoliticaFactusWithConnection()throws Exception {	
		if(politicafactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PoliticaFactu politicafactuAux:politicafactus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(politicafactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(politicafactuAux.getIsDeleted() || (politicafactuAux.getIsChanged()&&!politicafactuAux.getIsNew())) {
						
						timestamp=politicafactuDataAccess.getSetVersionRowPoliticaFactu(connexion,politicafactuAux.getId());
						
						if(!politicafactu.getVersionRow().equals(timestamp)) {	
							politicafactuAux.setVersionRow(timestamp);
						}
								
						politicafactuAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPoliticaFactus()throws Exception {	
		if(politicafactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PoliticaFactu politicafactuAux:politicafactus) {
					if(politicafactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(politicafactuAux.getIsDeleted() || (politicafactuAux.getIsChanged()&&!politicafactuAux.getIsNew())) {
						
						timestamp=politicafactuDataAccess.getSetVersionRowPoliticaFactu(connexion,politicafactuAux.getId());
						
						if(!politicafactuAux.getVersionRow().equals(timestamp)) {	
							politicafactuAux.setVersionRow(timestamp);
						}
						
													
						politicafactuAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PoliticaFactuParameterReturnGeneral cargarCombosLoteForeignKeyPoliticaFactuWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalProducto,String finalQueryGlobalGrupoCliente) throws Exception {
		PoliticaFactuParameterReturnGeneral  politicafactuReturnGeneral =new PoliticaFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-cargarCombosLoteForeignKeyPoliticaFactuWithConnection");connexion.begin();
			
			politicafactuReturnGeneral =new PoliticaFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			politicafactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			politicafactuReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			politicafactuReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			politicafactuReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return politicafactuReturnGeneral;
	}
	
	public PoliticaFactuParameterReturnGeneral cargarCombosLoteForeignKeyPoliticaFactu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalProducto,String finalQueryGlobalGrupoCliente) throws Exception {
		PoliticaFactuParameterReturnGeneral  politicafactuReturnGeneral =new PoliticaFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			politicafactuReturnGeneral =new PoliticaFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			politicafactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			politicafactuReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			politicafactuReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			politicafactuReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return politicafactuReturnGeneral;
	}
	
	
	public void deepLoad(PoliticaFactu politicafactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PoliticaFactuLogicAdditional.updatePoliticaFactuToGet(politicafactu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
		politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
		politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
		politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
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
			politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(politicafactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(politicafactu.getSucursal(),isDeep,deepLoadType,clases);
				
		politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(politicafactu.getProducto(),isDeep,deepLoadType,clases);
				
		politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(politicafactu.getGrupoCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(politicafactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(politicafactu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(politicafactu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(politicafactu.getGrupoCliente(),isDeep,deepLoadType,clases);				
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
			politicafactu.setEmpresa(politicafactuDataAccess.getEmpresa(connexion,politicafactu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(politicafactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setSucursal(politicafactuDataAccess.getSucursal(connexion,politicafactu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(politicafactu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setProducto(politicafactuDataAccess.getProducto(connexion,politicafactu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(politicafactu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicafactu.setGrupoCliente(politicafactuDataAccess.getGrupoCliente(connexion,politicafactu));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(politicafactu.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PoliticaFactu politicafactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PoliticaFactuLogicAdditional.updatePoliticaFactuToSave(politicafactu,this.arrDatoGeneral);
			
PoliticaFactuDataAccess.save(politicafactu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(politicafactu.getEmpresa(),connexion);

		SucursalDataAccess.save(politicafactu.getSucursal(),connexion);

		ProductoDataAccess.save(politicafactu.getProducto(),connexion);

		GrupoClienteDataAccess.save(politicafactu.getGrupoCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(politicafactu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(politicafactu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(politicafactu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(politicafactu.getGrupoCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(politicafactu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(politicafactu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(politicafactu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(politicafactu.getSucursal(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(politicafactu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(politicafactu.getProducto(),isDeep,deepLoadType,clases);
				

		GrupoClienteDataAccess.save(politicafactu.getGrupoCliente(),connexion);
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(politicafactu.getGrupoCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(politicafactu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(politicafactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(politicafactu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(politicafactu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(politicafactu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(politicafactu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(politicafactu.getGrupoCliente(),connexion);
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepSave(politicafactu.getGrupoCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PoliticaFactu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(politicafactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(politicafactu);
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
			this.deepLoad(this.politicafactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PoliticaFactu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(politicafactus!=null) {
				for(PoliticaFactu politicafactu:politicafactus) {
					this.deepLoad(politicafactu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(politicafactus);
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
			if(politicafactus!=null) {
				for(PoliticaFactu politicafactu:politicafactus) {
					this.deepLoad(politicafactu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(politicafactus);
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
			this.getNewConnexionToDeep(PoliticaFactu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(politicafactu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PoliticaFactu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(politicafactus!=null) {
				for(PoliticaFactu politicafactu:politicafactus) {
					this.deepSave(politicafactu,isDeep,deepLoadType,clases);
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
			if(politicafactus!=null) {
				for(PoliticaFactu politicafactu:politicafactus) {
					this.deepSave(politicafactu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPoliticaFactusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PoliticaFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticaFactusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PoliticaFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticaFactusFK_IdGrupoClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticaFactusFK_IdGrupoCliente(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticaFactusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PoliticaFactuConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticaFactusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PoliticaFactuConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticaFactusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticaFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PoliticaFactuConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticaFactusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PoliticaFactuConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PoliticaFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(this.politicafactus);
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
			if(PoliticaFactuConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticaFactuDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PoliticaFactu politicafactu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PoliticaFactuConstantesFunciones.ISCONAUDITORIA) {
				if(politicafactu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticaFactuDataAccess.TABLENAME, politicafactu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PoliticaFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PoliticaFactuLogic.registrarAuditoriaDetallesPoliticaFactu(connexion,politicafactu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(politicafactu.getIsDeleted()) {
					/*if(!politicafactu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PoliticaFactuDataAccess.TABLENAME, politicafactu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PoliticaFactuLogic.registrarAuditoriaDetallesPoliticaFactu(connexion,politicafactu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticaFactuDataAccess.TABLENAME, politicafactu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(politicafactu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticaFactuDataAccess.TABLENAME, politicafactu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PoliticaFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PoliticaFactuLogic.registrarAuditoriaDetallesPoliticaFactu(connexion,politicafactu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPoliticaFactu(Connexion connexion,PoliticaFactu politicafactu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(politicafactu.getIsNew()||!politicafactu.getid_empresa().equals(politicafactu.getPoliticaFactuOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getid_empresa()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getid_empresa().toString();
				}
				if(politicafactu.getid_empresa()!=null)
				{
					strValorNuevo=politicafactu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getid_sucursal().equals(politicafactu.getPoliticaFactuOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getid_sucursal()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getid_sucursal().toString();
				}
				if(politicafactu.getid_sucursal()!=null)
				{
					strValorNuevo=politicafactu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getid_producto().equals(politicafactu.getPoliticaFactuOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getid_producto()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getid_producto().toString();
				}
				if(politicafactu.getid_producto()!=null)
				{
					strValorNuevo=politicafactu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getid_grupo_cliente().equals(politicafactu.getPoliticaFactuOriginal().getid_grupo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getid_grupo_cliente()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getid_grupo_cliente().toString();
				}
				if(politicafactu.getid_grupo_cliente()!=null)
				{
					strValorNuevo=politicafactu.getid_grupo_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getnombre().equals(politicafactu.getPoliticaFactuOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getnombre()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getnombre();
				}
				if(politicafactu.getnombre()!=null)
				{
					strValorNuevo=politicafactu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getfecha_desde().equals(politicafactu.getPoliticaFactuOriginal().getfecha_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getfecha_desde()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getfecha_desde().toString();
				}
				if(politicafactu.getfecha_desde()!=null)
				{
					strValorNuevo=politicafactu.getfecha_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.FECHADESDE,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getfecha_hasta().equals(politicafactu.getPoliticaFactuOriginal().getfecha_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getfecha_hasta()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getfecha_hasta().toString();
				}
				if(politicafactu.getfecha_hasta()!=null)
				{
					strValorNuevo=politicafactu.getfecha_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.FECHAHASTA,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getporcentaje().equals(politicafactu.getPoliticaFactuOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getporcentaje()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getporcentaje().toString();
				}
				if(politicafactu.getporcentaje()!=null)
				{
					strValorNuevo=politicafactu.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getvalor().equals(politicafactu.getPoliticaFactuOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getvalor()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getvalor().toString();
				}
				if(politicafactu.getvalor()!=null)
				{
					strValorNuevo=politicafactu.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getcon_banco_cliente().equals(politicafactu.getPoliticaFactuOriginal().getcon_banco_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getcon_banco_cliente()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getcon_banco_cliente().toString();
				}
				if(politicafactu.getcon_banco_cliente()!=null)
				{
					strValorNuevo=politicafactu.getcon_banco_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.CONBANCOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getcon_banco_producto().equals(politicafactu.getPoliticaFactuOriginal().getcon_banco_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getcon_banco_producto()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getcon_banco_producto().toString();
				}
				if(politicafactu.getcon_banco_producto()!=null)
				{
					strValorNuevo=politicafactu.getcon_banco_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(politicafactu.getIsNew()||!politicafactu.getes_activo().equals(politicafactu.getPoliticaFactuOriginal().getes_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicafactu.getPoliticaFactuOriginal().getes_activo()!=null)
				{
					strValorActual=politicafactu.getPoliticaFactuOriginal().getes_activo().toString();
				}
				if(politicafactu.getes_activo()!=null)
				{
					strValorNuevo=politicafactu.getes_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticaFactuConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePoliticaFactuRelacionesWithConnection(PoliticaFactu politicafactu) throws Exception {

		if(!politicafactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePoliticaFactuRelacionesBase(politicafactu,true);
		}
	}

	public void savePoliticaFactuRelaciones(PoliticaFactu politicafactu)throws Exception {

		if(!politicafactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePoliticaFactuRelacionesBase(politicafactu,false);
		}
	}

	public void savePoliticaFactuRelacionesBase(PoliticaFactu politicafactu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PoliticaFactu-saveRelacionesWithConnection");}
	

			this.setPoliticaFactu(politicafactu);

			if(PoliticaFactuLogicAdditional.validarSaveRelaciones(politicafactu,this)) {

				PoliticaFactuLogicAdditional.updateRelacionesToSave(politicafactu,this);

				if((politicafactu.getIsNew()||politicafactu.getIsChanged())&&!politicafactu.getIsDeleted()) {
					this.savePoliticaFactu();
					this.savePoliticaFactuRelacionesDetalles();

				} else if(politicafactu.getIsDeleted()) {
					this.savePoliticaFactuRelacionesDetalles();
					this.savePoliticaFactu();
				}

				PoliticaFactuLogicAdditional.updateRelacionesToSaveAfter(politicafactu,this);

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
	
	
	private void savePoliticaFactuRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticaFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PoliticaFactuConstantesFunciones.getClassesForeignKeysOfPoliticaFactu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PoliticaFactuConstantesFunciones.getClassesRelationshipsOfPoliticaFactu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
