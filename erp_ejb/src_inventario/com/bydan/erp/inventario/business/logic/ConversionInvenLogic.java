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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.ConversionInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ConversionInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ConversionInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.ConversionInven;
import com.bydan.erp.inventario.business.logic.ConversionInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConversionInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConversionInvenLogic.class);
	
	protected ConversionInvenDataAccess conversioninvenDataAccess; 	
	protected ConversionInven conversioninven;
	protected List<ConversionInven> conversioninvens;
	protected Object conversioninvenObject;	
	protected List<Object> conversioninvensObject;
	
	public static ClassValidator<ConversionInven> conversioninvenValidator = new ClassValidator<ConversionInven>(ConversionInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConversionInvenLogicAdditional conversioninvenLogicAdditional=null;
	
	public ConversionInvenLogicAdditional getConversionInvenLogicAdditional() {
		return this.conversioninvenLogicAdditional;
	}
	
	public void setConversionInvenLogicAdditional(ConversionInvenLogicAdditional conversioninvenLogicAdditional) {
		try {
			this.conversioninvenLogicAdditional=conversioninvenLogicAdditional;
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
	
	
	
	
	public  ConversionInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.conversioninvenDataAccess = new ConversionInvenDataAccess();
			
			this.conversioninvens= new ArrayList<ConversionInven>();
			this.conversioninven= new ConversionInven();
			
			this.conversioninvenObject=new Object();
			this.conversioninvensObject=new ArrayList<Object>();
				
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
			
			this.conversioninvenDataAccess.setConnexionType(this.connexionType);
			this.conversioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConversionInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.conversioninvenDataAccess = new ConversionInvenDataAccess();
			this.conversioninvens= new ArrayList<ConversionInven>();
			this.conversioninven= new ConversionInven();
			this.conversioninvenObject=new Object();
			this.conversioninvensObject=new ArrayList<Object>();
			
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
			
			this.conversioninvenDataAccess.setConnexionType(this.connexionType);
			this.conversioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConversionInven getConversionInven() throws Exception {	
		ConversionInvenLogicAdditional.checkConversionInvenToGet(conversioninven,this.datosCliente,this.arrDatoGeneral);
		ConversionInvenLogicAdditional.updateConversionInvenToGet(conversioninven,this.arrDatoGeneral);
		
		return conversioninven;
	}
		
	public void setConversionInven(ConversionInven newConversionInven) {
		this.conversioninven = newConversionInven;
	}
	
	public ConversionInvenDataAccess getConversionInvenDataAccess() {
		return conversioninvenDataAccess;
	}
	
	public void setConversionInvenDataAccess(ConversionInvenDataAccess newconversioninvenDataAccess) {
		this.conversioninvenDataAccess = newconversioninvenDataAccess;
	}
	
	public List<ConversionInven> getConversionInvens() throws Exception {		
		this.quitarConversionInvensNulos();
		
		ConversionInvenLogicAdditional.checkConversionInvenToGets(conversioninvens,this.datosCliente,this.arrDatoGeneral);
		
		for (ConversionInven conversioninvenLocal: conversioninvens ) {
			ConversionInvenLogicAdditional.updateConversionInvenToGet(conversioninvenLocal,this.arrDatoGeneral);
		}
		
		return conversioninvens;
	}
	
	public void setConversionInvens(List<ConversionInven> newConversionInvens) {
		this.conversioninvens = newConversionInvens;
	}
	
	public Object getConversionInvenObject() {	
		this.conversioninvenObject=this.conversioninvenDataAccess.getEntityObject();
		return this.conversioninvenObject;
	}
		
	public void setConversionInvenObject(Object newConversionInvenObject) {
		this.conversioninvenObject = newConversionInvenObject;
	}
	
	public List<Object> getConversionInvensObject() {		
		this.conversioninvensObject=this.conversioninvenDataAccess.getEntitiesObject();
		return this.conversioninvensObject;
	}
		
	public void setConversionInvensObject(List<Object> newConversionInvensObject) {
		this.conversioninvensObject = newConversionInvensObject;
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
		
		if(this.conversioninvenDataAccess!=null) {
			this.conversioninvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			conversioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			conversioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		conversioninven = new  ConversionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conversioninven=conversioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
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
		conversioninven = new  ConversionInven();
		  		  
        try {
			
			conversioninven=conversioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		conversioninven = new  ConversionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conversioninven=conversioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
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
		conversioninven = new  ConversionInven();
		  		  
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
		conversioninven = new  ConversionInven();
		  		  
        try {
			
			conversioninven=conversioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		conversioninven = new  ConversionInven();
		  		  
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
		conversioninven = new  ConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =conversioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversioninven = new  ConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=conversioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conversioninven = new  ConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =conversioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversioninven = new  ConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=conversioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conversioninven = new  ConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =conversioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversioninven = new  ConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=conversioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
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
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
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
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
		conversioninvens = new  ArrayList<ConversionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
		conversioninvens = new  ArrayList<ConversionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		conversioninven = new  ConversionInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninven=conversioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
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
		conversioninven = new  ConversionInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninven=conversioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
		conversioninvens = new  ArrayList<ConversionInven>();
		  		  
        try {
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConversionInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		conversioninvens = new  ArrayList<ConversionInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getTodosConversionInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
	
	public  void  getTodosConversionInvens(String sFinalQuery,Pagination pagination)throws Exception {
		conversioninvens = new  ArrayList<ConversionInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConversionInven(conversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConversionInven(ConversionInven conversioninven) throws Exception {
		Boolean estaValidado=false;
		
		if(conversioninven.getIsNew() || conversioninven.getIsChanged()) { 
			this.invalidValues = conversioninvenValidator.getInvalidValues(conversioninven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(conversioninven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConversionInven(List<ConversionInven> ConversionInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ConversionInven conversioninvenLocal:conversioninvens) {				
			estaValidadoObjeto=this.validarGuardarConversionInven(conversioninvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConversionInven(List<ConversionInven> ConversionInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConversionInven(conversioninvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConversionInven(ConversionInven ConversionInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConversionInven(conversioninven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ConversionInven conversioninven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+conversioninven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConversionInvenConstantesFunciones.getConversionInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"conversioninven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConversionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConversionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConversionInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-saveConversionInvenWithConnection");connexion.begin();			
			
			ConversionInvenLogicAdditional.checkConversionInvenToSave(this.conversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConversionInvenLogicAdditional.updateConversionInvenToSave(this.conversioninven,this.arrDatoGeneral);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conversioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConversionInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConversionInven(this.conversioninven)) {
				ConversionInvenDataAccess.save(this.conversioninven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConversionInvenLogicAdditional.checkConversionInvenToSaveAfter(this.conversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConversionInven();
			
			connexion.commit();			
			
			if(this.conversioninven.getIsDeleted()) {
				this.conversioninven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConversionInven()throws Exception {	
		try {	
			
			ConversionInvenLogicAdditional.checkConversionInvenToSave(this.conversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConversionInvenLogicAdditional.updateConversionInvenToSave(this.conversioninven,this.arrDatoGeneral);
			
			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conversioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConversionInven(this.conversioninven)) {			
				ConversionInvenDataAccess.save(this.conversioninven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.conversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConversionInvenLogicAdditional.checkConversionInvenToSaveAfter(this.conversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.conversioninven.getIsDeleted()) {
				this.conversioninven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConversionInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-saveConversionInvensWithConnection");connexion.begin();			
			
			ConversionInvenLogicAdditional.checkConversionInvenToSaves(conversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConversionInvens();
			
			Boolean validadoTodosConversionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConversionInven conversioninvenLocal:conversioninvens) {		
				if(conversioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConversionInvenLogicAdditional.updateConversionInvenToSave(conversioninvenLocal,this.arrDatoGeneral);
	        	
				ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conversioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConversionInven(conversioninvenLocal)) {
					ConversionInvenDataAccess.save(conversioninvenLocal, connexion);				
				} else {
					validadoTodosConversionInven=false;
				}
			}
			
			if(!validadoTodosConversionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConversionInvenLogicAdditional.checkConversionInvenToSavesAfter(conversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConversionInvens();
			
			connexion.commit();		
			
			this.quitarConversionInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConversionInvens()throws Exception {				
		 try {	
			ConversionInvenLogicAdditional.checkConversionInvenToSaves(conversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConversionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConversionInven conversioninvenLocal:conversioninvens) {				
				if(conversioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConversionInvenLogicAdditional.updateConversionInvenToSave(conversioninvenLocal,this.arrDatoGeneral);
	        	
				ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conversioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConversionInven(conversioninvenLocal)) {				
					ConversionInvenDataAccess.save(conversioninvenLocal, connexion);				
				} else {
					validadoTodosConversionInven=false;
				}
			}
			
			if(!validadoTodosConversionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConversionInvenLogicAdditional.checkConversionInvenToSavesAfter(conversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConversionInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConversionInvenParameterReturnGeneral procesarAccionConversionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConversionInven> conversioninvens,ConversionInvenParameterReturnGeneral conversioninvenParameterGeneral)throws Exception {
		 try {	
			ConversionInvenParameterReturnGeneral conversioninvenReturnGeneral=new ConversionInvenParameterReturnGeneral();
	
			ConversionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conversioninvens,conversioninvenParameterGeneral,conversioninvenReturnGeneral);
			
			return conversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConversionInvenParameterReturnGeneral procesarAccionConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConversionInven> conversioninvens,ConversionInvenParameterReturnGeneral conversioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-procesarAccionConversionInvensWithConnection");connexion.begin();			
			
			ConversionInvenParameterReturnGeneral conversioninvenReturnGeneral=new ConversionInvenParameterReturnGeneral();
	
			ConversionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conversioninvens,conversioninvenParameterGeneral,conversioninvenReturnGeneral);
			
			this.connexion.commit();
			
			return conversioninvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConversionInvenParameterReturnGeneral procesarEventosConversionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConversionInven> conversioninvens,ConversionInven conversioninven,ConversionInvenParameterReturnGeneral conversioninvenParameterGeneral,Boolean isEsNuevoConversionInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConversionInvenParameterReturnGeneral conversioninvenReturnGeneral=new ConversionInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conversioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConversionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conversioninvens,conversioninven,conversioninvenParameterGeneral,conversioninvenReturnGeneral,isEsNuevoConversionInven,clases);
			
			return conversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConversionInvenParameterReturnGeneral procesarEventosConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConversionInven> conversioninvens,ConversionInven conversioninven,ConversionInvenParameterReturnGeneral conversioninvenParameterGeneral,Boolean isEsNuevoConversionInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-procesarEventosConversionInvensWithConnection");connexion.begin();			
			
			ConversionInvenParameterReturnGeneral conversioninvenReturnGeneral=new ConversionInvenParameterReturnGeneral();
	
			conversioninvenReturnGeneral.setConversionInven(conversioninven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conversioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConversionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conversioninvens,conversioninven,conversioninvenParameterGeneral,conversioninvenReturnGeneral,isEsNuevoConversionInven,clases);
			
			this.connexion.commit();
			
			return conversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConversionInvenParameterReturnGeneral procesarImportacionConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConversionInvenParameterReturnGeneral conversioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-procesarImportacionConversionInvensWithConnection");connexion.begin();			
			
			ConversionInvenParameterReturnGeneral conversioninvenReturnGeneral=new ConversionInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.conversioninvens=new ArrayList<ConversionInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.conversioninven=new ConversionInven();
				
				
				if(conColumnasBase) {this.conversioninven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.conversioninven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.conversioninven.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.conversioninven.setdescripcion(arrColumnas[iColumn++]);
				
				this.conversioninvens.add(this.conversioninven);
			}
			
			this.saveConversionInvens();
			
			this.connexion.commit();
			
			conversioninvenReturnGeneral.setConRetornoEstaProcesado(true);
			conversioninvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return conversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConversionInvensEliminados() throws Exception {				
		
		List<ConversionInven> conversioninvensAux= new ArrayList<ConversionInven>();
		
		for(ConversionInven conversioninven:conversioninvens) {
			if(!conversioninven.getIsDeleted()) {
				conversioninvensAux.add(conversioninven);
			}
		}
		
		conversioninvens=conversioninvensAux;
	}
	
	public void quitarConversionInvensNulos() throws Exception {				
		
		List<ConversionInven> conversioninvensAux= new ArrayList<ConversionInven>();
		
		for(ConversionInven conversioninven : this.conversioninvens) {
			if(conversioninven==null) {
				conversioninvensAux.add(conversioninven);
			}
		}
		
		//this.conversioninvens=conversioninvensAux;
		
		this.conversioninvens.removeAll(conversioninvensAux);
	}
	
	public void getSetVersionRowConversionInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(conversioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((conversioninven.getIsDeleted() || (conversioninven.getIsChanged()&&!conversioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=conversioninvenDataAccess.getSetVersionRowConversionInven(connexion,conversioninven.getId());
				
				if(!conversioninven.getVersionRow().equals(timestamp)) {	
					conversioninven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				conversioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConversionInven()throws Exception {	
		
		if(conversioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((conversioninven.getIsDeleted() || (conversioninven.getIsChanged()&&!conversioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=conversioninvenDataAccess.getSetVersionRowConversionInven(connexion,conversioninven.getId());
			
			try {							
				if(!conversioninven.getVersionRow().equals(timestamp)) {	
					conversioninven.setVersionRow(timestamp);
				}
				
				conversioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConversionInvensWithConnection()throws Exception {	
		if(conversioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ConversionInven conversioninvenAux:conversioninvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(conversioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conversioninvenAux.getIsDeleted() || (conversioninvenAux.getIsChanged()&&!conversioninvenAux.getIsNew())) {
						
						timestamp=conversioninvenDataAccess.getSetVersionRowConversionInven(connexion,conversioninvenAux.getId());
						
						if(!conversioninven.getVersionRow().equals(timestamp)) {	
							conversioninvenAux.setVersionRow(timestamp);
						}
								
						conversioninvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConversionInvens()throws Exception {	
		if(conversioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ConversionInven conversioninvenAux:conversioninvens) {
					if(conversioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conversioninvenAux.getIsDeleted() || (conversioninvenAux.getIsChanged()&&!conversioninvenAux.getIsNew())) {
						
						timestamp=conversioninvenDataAccess.getSetVersionRowConversionInven(connexion,conversioninvenAux.getId());
						
						if(!conversioninvenAux.getVersionRow().equals(timestamp)) {	
							conversioninvenAux.setVersionRow(timestamp);
						}
						
													
						conversioninvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConversionInvenParameterReturnGeneral cargarCombosLoteForeignKeyConversionInvenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoConversionInven,String finalQueryGlobalUnidad,String finalQueryGlobalUnidadConversion) throws Exception {
		ConversionInvenParameterReturnGeneral  conversioninvenReturnGeneral =new ConversionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyConversionInvenWithConnection");connexion.begin();
			
			conversioninvenReturnGeneral =new ConversionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			conversioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoConversionInven> tipoconversioninvensForeignKey=new ArrayList<TipoConversionInven>();
			TipoConversionInvenLogic tipoconversioninvenLogic=new TipoConversionInvenLogic();
			tipoconversioninvenLogic.setConnexion(this.connexion);
			tipoconversioninvenLogic.getTipoConversionInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConversionInven.equals("NONE")) {
				tipoconversioninvenLogic.getTodosTipoConversionInvens(finalQueryGlobalTipoConversionInven,new Pagination());
				tipoconversioninvensForeignKey=tipoconversioninvenLogic.getTipoConversionInvens();
			}

			conversioninvenReturnGeneral.settipoconversioninvensForeignKey(tipoconversioninvensForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			conversioninvenReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Unidad> unidadconversionsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadconversionLogic=new UnidadLogic();
			unidadconversionLogic.setConnexion(this.connexion);
			unidadconversionLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadConversion.equals("NONE")) {
				unidadconversionLogic.getTodosUnidads(finalQueryGlobalUnidadConversion,new Pagination());
				unidadconversionsForeignKey=unidadconversionLogic.getUnidads();
			}

			conversioninvenReturnGeneral.setunidadconversionsForeignKey(unidadconversionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return conversioninvenReturnGeneral;
	}
	
	public ConversionInvenParameterReturnGeneral cargarCombosLoteForeignKeyConversionInven(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoConversionInven,String finalQueryGlobalUnidad,String finalQueryGlobalUnidadConversion) throws Exception {
		ConversionInvenParameterReturnGeneral  conversioninvenReturnGeneral =new ConversionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			conversioninvenReturnGeneral =new ConversionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			conversioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoConversionInven> tipoconversioninvensForeignKey=new ArrayList<TipoConversionInven>();
			TipoConversionInvenLogic tipoconversioninvenLogic=new TipoConversionInvenLogic();
			tipoconversioninvenLogic.setConnexion(this.connexion);
			tipoconversioninvenLogic.getTipoConversionInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConversionInven.equals("NONE")) {
				tipoconversioninvenLogic.getTodosTipoConversionInvens(finalQueryGlobalTipoConversionInven,new Pagination());
				tipoconversioninvensForeignKey=tipoconversioninvenLogic.getTipoConversionInvens();
			}

			conversioninvenReturnGeneral.settipoconversioninvensForeignKey(tipoconversioninvensForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			conversioninvenReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Unidad> unidadconversionsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadconversionLogic=new UnidadLogic();
			unidadconversionLogic.setConnexion(this.connexion);
			unidadconversionLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadConversion.equals("NONE")) {
				unidadconversionLogic.getTodosUnidads(finalQueryGlobalUnidadConversion,new Pagination());
				unidadconversionsForeignKey=unidadconversionLogic.getUnidads();
			}

			conversioninvenReturnGeneral.setunidadconversionsForeignKey(unidadconversionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return conversioninvenReturnGeneral;
	}
	
	
	public void deepLoad(ConversionInven conversioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConversionInvenLogicAdditional.updateConversionInvenToGet(conversioninven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
		conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
		conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
		conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
				continue;
			}

			if(clas.clas.equals(TipoConversionInven.class)) {
				conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
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
			conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConversionInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				
		conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
		TipoConversionInvenLogic tipoconversioninvenLogic= new TipoConversionInvenLogic(connexion);
		tipoconversioninvenLogic.deepLoad(conversioninven.getTipoConversionInven(),isDeep,deepLoadType,clases);
				
		conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(conversioninven.getUnidad(),isDeep,deepLoadType,clases);
				
		conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
		UnidadLogic unidadconversionLogic= new UnidadLogic(connexion);
		unidadconversionLogic.deepLoad(conversioninven.getUnidadConversion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(conversioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoConversionInven.class)) {
				conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
				TipoConversionInvenLogic tipoconversioninvenLogic= new TipoConversionInvenLogic(connexion);
				tipoconversioninvenLogic.deepLoad(conversioninven.getTipoConversionInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(conversioninven.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(conversioninven.getUnidadConversion(),isDeep,deepLoadType,clases);				
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
			conversioninven.setEmpresa(conversioninvenDataAccess.getEmpresa(connexion,conversioninven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(conversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConversionInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setTipoConversionInven(conversioninvenDataAccess.getTipoConversionInven(connexion,conversioninven));
			TipoConversionInvenLogic tipoconversioninvenLogic= new TipoConversionInvenLogic(connexion);
			tipoconversioninvenLogic.deepLoad(conversioninven.getTipoConversionInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setUnidad(conversioninvenDataAccess.getUnidad(connexion,conversioninven));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(conversioninven.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversioninven.setUnidadConversion(conversioninvenDataAccess.getUnidadConversion(connexion,conversioninven));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(conversioninven.getUnidadConversion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ConversionInven conversioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConversionInvenLogicAdditional.updateConversionInvenToSave(conversioninven,this.arrDatoGeneral);
			
ConversionInvenDataAccess.save(conversioninven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(conversioninven.getEmpresa(),connexion);

		TipoConversionInvenDataAccess.save(conversioninven.getTipoConversionInven(),connexion);

		UnidadDataAccess.save(conversioninven.getUnidad(),connexion);

		UnidadDataAccess.save(conversioninven.getUnidadConversion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(conversioninven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoConversionInven.class)) {
				TipoConversionInvenDataAccess.save(conversioninven.getTipoConversionInven(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversioninven.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversioninven.getUnidadConversion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(conversioninven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoConversionInvenDataAccess.save(conversioninven.getTipoConversionInven(),connexion);
		TipoConversionInvenLogic tipoconversioninvenLogic= new TipoConversionInvenLogic(connexion);
		tipoconversioninvenLogic.deepLoad(conversioninven.getTipoConversionInven(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(conversioninven.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(conversioninven.getUnidad(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(conversioninven.getUnidadConversion(),connexion);
		UnidadLogic unidadconversionLogic= new UnidadLogic(connexion);
		unidadconversionLogic.deepLoad(conversioninven.getUnidadConversion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(conversioninven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(conversioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoConversionInven.class)) {
				TipoConversionInvenDataAccess.save(conversioninven.getTipoConversionInven(),connexion);
				TipoConversionInvenLogic tipoconversioninvenLogic= new TipoConversionInvenLogic(connexion);
				tipoconversioninvenLogic.deepSave(conversioninven.getTipoConversionInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversioninven.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(conversioninven.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversioninven.getUnidadConversion(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(conversioninven.getUnidadConversion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ConversionInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(conversioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(conversioninven);
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
			this.deepLoad(this.conversioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ConversionInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(conversioninvens!=null) {
				for(ConversionInven conversioninven:conversioninvens) {
					this.deepLoad(conversioninven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(conversioninvens);
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
			if(conversioninvens!=null) {
				for(ConversionInven conversioninven:conversioninvens) {
					this.deepLoad(conversioninven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(conversioninvens);
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
			this.getNewConnexionToDeep(ConversionInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(conversioninven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ConversionInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(conversioninvens!=null) {
				for(ConversionInven conversioninven:conversioninvens) {
					this.deepSave(conversioninven,isDeep,deepLoadType,clases);
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
			if(conversioninvens!=null) {
				for(ConversionInven conversioninven:conversioninvens) {
					this.deepSave(conversioninven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConversionInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConversionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConversionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConversionInvensFK_IdTipoConversionInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_conversion_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConversionInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConversionInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_conversion_inven,ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConversionInven);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConversionInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionInvensFK_IdTipoConversionInven(String sFinalQuery,Pagination pagination,Long id_tipo_conversion_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConversionInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConversionInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_conversion_inven,ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConversionInven);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConversionInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConversionInvensFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ConversionInvenConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionInvensFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ConversionInvenConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConversionInvensFK_IdUnidadConversionWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad_conversion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadConversion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadConversion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_conversion,ConversionInvenConstantesFunciones.IDUNIDADCONVERSION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadConversion);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadConversion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionInvensFK_IdUnidadConversion(String sFinalQuery,Pagination pagination,Long id_unidad_conversion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadConversion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadConversion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_conversion,ConversionInvenConstantesFunciones.IDUNIDADCONVERSION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadConversion);

			ConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadConversion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversioninvens=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(this.conversioninvens);
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
			if(ConversionInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ConversionInven conversioninven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConversionInvenConstantesFunciones.ISCONAUDITORIA) {
				if(conversioninven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionInvenDataAccess.TABLENAME, conversioninven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConversionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConversionInvenLogic.registrarAuditoriaDetallesConversionInven(connexion,conversioninven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(conversioninven.getIsDeleted()) {
					/*if(!conversioninven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConversionInvenDataAccess.TABLENAME, conversioninven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConversionInvenLogic.registrarAuditoriaDetallesConversionInven(connexion,conversioninven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionInvenDataAccess.TABLENAME, conversioninven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(conversioninven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionInvenDataAccess.TABLENAME, conversioninven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConversionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConversionInvenLogic.registrarAuditoriaDetallesConversionInven(connexion,conversioninven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConversionInven(Connexion connexion,ConversionInven conversioninven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(conversioninven.getIsNew()||!conversioninven.getid_empresa().equals(conversioninven.getConversionInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getid_empresa().toString();
				}
				if(conversioninven.getid_empresa()!=null)
				{
					strValorNuevo=conversioninven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(conversioninven.getIsNew()||!conversioninven.getid_tipo_conversion_inven().equals(conversioninven.getConversionInvenOriginal().getid_tipo_conversion_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getid_tipo_conversion_inven()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getid_tipo_conversion_inven().toString();
				}
				if(conversioninven.getid_tipo_conversion_inven()!=null)
				{
					strValorNuevo=conversioninven.getid_tipo_conversion_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN,strValorActual,strValorNuevo);
			}	
			
			if(conversioninven.getIsNew()||!conversioninven.getid_unidad().equals(conversioninven.getConversionInvenOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getid_unidad()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getid_unidad().toString();
				}
				if(conversioninven.getid_unidad()!=null)
				{
					strValorNuevo=conversioninven.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(conversioninven.getIsNew()||!conversioninven.getid_unidad_conversion().equals(conversioninven.getConversionInvenOriginal().getid_unidad_conversion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getid_unidad_conversion()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getid_unidad_conversion().toString();
				}
				if(conversioninven.getid_unidad_conversion()!=null)
				{
					strValorNuevo=conversioninven.getid_unidad_conversion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.IDUNIDADCONVERSION,strValorActual,strValorNuevo);
			}	
			
			if(conversioninven.getIsNew()||!conversioninven.getvalor().equals(conversioninven.getConversionInvenOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getvalor()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getvalor().toString();
				}
				if(conversioninven.getvalor()!=null)
				{
					strValorNuevo=conversioninven.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(conversioninven.getIsNew()||!conversioninven.getdescripcion().equals(conversioninven.getConversionInvenOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversioninven.getConversionInvenOriginal().getdescripcion()!=null)
				{
					strValorActual=conversioninven.getConversionInvenOriginal().getdescripcion();
				}
				if(conversioninven.getdescripcion()!=null)
				{
					strValorNuevo=conversioninven.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionInvenConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConversionInvenRelacionesWithConnection(ConversionInven conversioninven) throws Exception {

		if(!conversioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConversionInvenRelacionesBase(conversioninven,true);
		}
	}

	public void saveConversionInvenRelaciones(ConversionInven conversioninven)throws Exception {

		if(!conversioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConversionInvenRelacionesBase(conversioninven,false);
		}
	}

	public void saveConversionInvenRelacionesBase(ConversionInven conversioninven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ConversionInven-saveRelacionesWithConnection");}
	

			this.setConversionInven(conversioninven);

			if(ConversionInvenLogicAdditional.validarSaveRelaciones(conversioninven,this)) {

				ConversionInvenLogicAdditional.updateRelacionesToSave(conversioninven,this);

				if((conversioninven.getIsNew()||conversioninven.getIsChanged())&&!conversioninven.getIsDeleted()) {
					this.saveConversionInven();
					this.saveConversionInvenRelacionesDetalles();

				} else if(conversioninven.getIsDeleted()) {
					this.saveConversionInvenRelacionesDetalles();
					this.saveConversionInven();
				}

				ConversionInvenLogicAdditional.updateRelacionesToSaveAfter(conversioninven,this);

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
	
	
	private void saveConversionInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConversionInvenConstantesFunciones.getClassesForeignKeysOfConversionInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConversionInvenConstantesFunciones.getClassesRelationshipsOfConversionInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
