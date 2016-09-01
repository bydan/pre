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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.ParametroGraficoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroGraficoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroGraficoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroGrafico;
import com.bydan.erp.contabilidad.business.logic.ParametroGraficoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroGraficoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroGraficoLogic.class);
	
	protected ParametroGraficoDataAccess parametrograficoDataAccess; 	
	protected ParametroGrafico parametrografico;
	protected List<ParametroGrafico> parametrograficos;
	protected Object parametrograficoObject;	
	protected List<Object> parametrograficosObject;
	
	public static ClassValidator<ParametroGrafico> parametrograficoValidator = new ClassValidator<ParametroGrafico>(ParametroGrafico.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroGraficoLogicAdditional parametrograficoLogicAdditional=null;
	
	public ParametroGraficoLogicAdditional getParametroGraficoLogicAdditional() {
		return this.parametrograficoLogicAdditional;
	}
	
	public void setParametroGraficoLogicAdditional(ParametroGraficoLogicAdditional parametrograficoLogicAdditional) {
		try {
			this.parametrograficoLogicAdditional=parametrograficoLogicAdditional;
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
	
	
	
	
	public  ParametroGraficoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrograficoDataAccess = new ParametroGraficoDataAccess();
			
			this.parametrograficos= new ArrayList<ParametroGrafico>();
			this.parametrografico= new ParametroGrafico();
			
			this.parametrograficoObject=new Object();
			this.parametrograficosObject=new ArrayList<Object>();
				
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
			
			this.parametrograficoDataAccess.setConnexionType(this.connexionType);
			this.parametrograficoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroGraficoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrograficoDataAccess = new ParametroGraficoDataAccess();
			this.parametrograficos= new ArrayList<ParametroGrafico>();
			this.parametrografico= new ParametroGrafico();
			this.parametrograficoObject=new Object();
			this.parametrograficosObject=new ArrayList<Object>();
			
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
			
			this.parametrograficoDataAccess.setConnexionType(this.connexionType);
			this.parametrograficoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroGrafico getParametroGrafico() throws Exception {	
		ParametroGraficoLogicAdditional.checkParametroGraficoToGet(parametrografico,this.datosCliente,this.arrDatoGeneral);
		ParametroGraficoLogicAdditional.updateParametroGraficoToGet(parametrografico,this.arrDatoGeneral);
		
		return parametrografico;
	}
		
	public void setParametroGrafico(ParametroGrafico newParametroGrafico) {
		this.parametrografico = newParametroGrafico;
	}
	
	public ParametroGraficoDataAccess getParametroGraficoDataAccess() {
		return parametrograficoDataAccess;
	}
	
	public void setParametroGraficoDataAccess(ParametroGraficoDataAccess newparametrograficoDataAccess) {
		this.parametrograficoDataAccess = newparametrograficoDataAccess;
	}
	
	public List<ParametroGrafico> getParametroGraficos() throws Exception {		
		this.quitarParametroGraficosNulos();
		
		ParametroGraficoLogicAdditional.checkParametroGraficoToGets(parametrograficos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroGrafico parametrograficoLocal: parametrograficos ) {
			ParametroGraficoLogicAdditional.updateParametroGraficoToGet(parametrograficoLocal,this.arrDatoGeneral);
		}
		
		return parametrograficos;
	}
	
	public void setParametroGraficos(List<ParametroGrafico> newParametroGraficos) {
		this.parametrograficos = newParametroGraficos;
	}
	
	public Object getParametroGraficoObject() {	
		this.parametrograficoObject=this.parametrograficoDataAccess.getEntityObject();
		return this.parametrograficoObject;
	}
		
	public void setParametroGraficoObject(Object newParametroGraficoObject) {
		this.parametrograficoObject = newParametroGraficoObject;
	}
	
	public List<Object> getParametroGraficosObject() {		
		this.parametrograficosObject=this.parametrograficoDataAccess.getEntitiesObject();
		return this.parametrograficosObject;
	}
		
	public void setParametroGraficosObject(List<Object> newParametroGraficosObject) {
		this.parametrograficosObject = newParametroGraficosObject;
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
		
		if(this.parametrograficoDataAccess!=null) {
			this.parametrograficoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrograficoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrograficoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrografico = new  ParametroGrafico();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrografico=parametrograficoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
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
		parametrografico = new  ParametroGrafico();
		  		  
        try {
			
			parametrografico=parametrograficoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrografico = new  ParametroGrafico();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrografico=parametrograficoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
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
		parametrografico = new  ParametroGrafico();
		  		  
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
		parametrografico = new  ParametroGrafico();
		  		  
        try {
			
			parametrografico=parametrograficoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrografico = new  ParametroGrafico();
		  		  
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
		parametrografico = new  ParametroGrafico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrograficoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrografico = new  ParametroGrafico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrograficoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrografico = new  ParametroGrafico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrograficoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrografico = new  ParametroGrafico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrograficoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrografico = new  ParametroGrafico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrograficoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrografico = new  ParametroGrafico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrograficoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrografico = new  ParametroGrafico();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrografico=parametrograficoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrografico);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
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
		parametrografico = new  ParametroGrafico();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrografico=parametrograficoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrografico);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
		parametrograficos = new  ArrayList<ParametroGrafico>();
		  		  
        try {
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroGraficosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrograficos = new  ArrayList<ParametroGrafico>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getTodosParametroGraficosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
	
	public  void  getTodosParametroGraficos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrograficos = new  ArrayList<ParametroGrafico>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGrafico(parametrograficos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroGrafico(ParametroGrafico parametrografico) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrografico.getIsNew() || parametrografico.getIsChanged()) { 
			this.invalidValues = parametrograficoValidator.getInvalidValues(parametrografico);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrografico);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroGrafico(List<ParametroGrafico> ParametroGraficos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroGrafico parametrograficoLocal:parametrograficos) {				
			estaValidadoObjeto=this.validarGuardarParametroGrafico(parametrograficoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroGrafico(List<ParametroGrafico> ParametroGraficos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGrafico(parametrograficos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroGrafico(ParametroGrafico ParametroGrafico) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGrafico(parametrografico)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroGrafico parametrografico) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrografico.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroGraficoConstantesFunciones.getParametroGraficoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrografico","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroGraficoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroGraficoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroGraficoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-saveParametroGraficoWithConnection");connexion.begin();			
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSave(this.parametrografico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGraficoLogicAdditional.updateParametroGraficoToSave(this.parametrografico,this.arrDatoGeneral);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrografico,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroGrafico();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGrafico(this.parametrografico)) {
				ParametroGraficoDataAccess.save(this.parametrografico, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSaveAfter(this.parametrografico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGrafico();
			
			connexion.commit();			
			
			if(this.parametrografico.getIsDeleted()) {
				this.parametrografico=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroGrafico()throws Exception {	
		try {	
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSave(this.parametrografico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGraficoLogicAdditional.updateParametroGraficoToSave(this.parametrografico,this.arrDatoGeneral);
			
			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrografico,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGrafico(this.parametrografico)) {			
				ParametroGraficoDataAccess.save(this.parametrografico, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrografico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSaveAfter(this.parametrografico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrografico.getIsDeleted()) {
				this.parametrografico=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroGraficosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-saveParametroGraficosWithConnection");connexion.begin();			
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSaves(parametrograficos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroGraficos();
			
			Boolean validadoTodosParametroGrafico=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGrafico parametrograficoLocal:parametrograficos) {		
				if(parametrograficoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGraficoLogicAdditional.updateParametroGraficoToSave(parametrograficoLocal,this.arrDatoGeneral);
	        	
				ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrograficoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGrafico(parametrograficoLocal)) {
					ParametroGraficoDataAccess.save(parametrograficoLocal, connexion);				
				} else {
					validadoTodosParametroGrafico=false;
				}
			}
			
			if(!validadoTodosParametroGrafico) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSavesAfter(parametrograficos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGraficos();
			
			connexion.commit();		
			
			this.quitarParametroGraficosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroGraficos()throws Exception {				
		 try {	
			ParametroGraficoLogicAdditional.checkParametroGraficoToSaves(parametrograficos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroGrafico=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGrafico parametrograficoLocal:parametrograficos) {				
				if(parametrograficoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGraficoLogicAdditional.updateParametroGraficoToSave(parametrograficoLocal,this.arrDatoGeneral);
	        	
				ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrograficoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGrafico(parametrograficoLocal)) {				
					ParametroGraficoDataAccess.save(parametrograficoLocal, connexion);				
				} else {
					validadoTodosParametroGrafico=false;
				}
			}
			
			if(!validadoTodosParametroGrafico) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGraficoLogicAdditional.checkParametroGraficoToSavesAfter(parametrograficos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroGraficosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGraficoParameterReturnGeneral procesarAccionParametroGraficos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGrafico> parametrograficos,ParametroGraficoParameterReturnGeneral parametrograficoParameterGeneral)throws Exception {
		 try {	
			ParametroGraficoParameterReturnGeneral parametrograficoReturnGeneral=new ParametroGraficoParameterReturnGeneral();
	
			ParametroGraficoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrograficos,parametrograficoParameterGeneral,parametrograficoReturnGeneral);
			
			return parametrograficoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGraficoParameterReturnGeneral procesarAccionParametroGraficosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGrafico> parametrograficos,ParametroGraficoParameterReturnGeneral parametrograficoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-procesarAccionParametroGraficosWithConnection");connexion.begin();			
			
			ParametroGraficoParameterReturnGeneral parametrograficoReturnGeneral=new ParametroGraficoParameterReturnGeneral();
	
			ParametroGraficoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrograficos,parametrograficoParameterGeneral,parametrograficoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrograficoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGraficoParameterReturnGeneral procesarEventosParametroGraficos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGrafico> parametrograficos,ParametroGrafico parametrografico,ParametroGraficoParameterReturnGeneral parametrograficoParameterGeneral,Boolean isEsNuevoParametroGrafico,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroGraficoParameterReturnGeneral parametrograficoReturnGeneral=new ParametroGraficoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrograficoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGraficoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrograficos,parametrografico,parametrograficoParameterGeneral,parametrograficoReturnGeneral,isEsNuevoParametroGrafico,clases);
			
			return parametrograficoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroGraficoParameterReturnGeneral procesarEventosParametroGraficosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGrafico> parametrograficos,ParametroGrafico parametrografico,ParametroGraficoParameterReturnGeneral parametrograficoParameterGeneral,Boolean isEsNuevoParametroGrafico,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-procesarEventosParametroGraficosWithConnection");connexion.begin();			
			
			ParametroGraficoParameterReturnGeneral parametrograficoReturnGeneral=new ParametroGraficoParameterReturnGeneral();
	
			parametrograficoReturnGeneral.setParametroGrafico(parametrografico);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrograficoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGraficoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrograficos,parametrografico,parametrograficoParameterGeneral,parametrograficoReturnGeneral,isEsNuevoParametroGrafico,clases);
			
			this.connexion.commit();
			
			return parametrograficoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGraficoParameterReturnGeneral procesarImportacionParametroGraficosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroGraficoParameterReturnGeneral parametrograficoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-procesarImportacionParametroGraficosWithConnection");connexion.begin();			
			
			ParametroGraficoParameterReturnGeneral parametrograficoReturnGeneral=new ParametroGraficoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrograficos=new ArrayList<ParametroGrafico>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrografico=new ParametroGrafico();
				
				
				if(conColumnasBase) {this.parametrografico.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrografico.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrografico.setinventario_inicial(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.parametrograficos.add(this.parametrografico);
			}
			
			this.saveParametroGraficos();
			
			this.connexion.commit();
			
			parametrograficoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrograficoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrograficoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroGraficosEliminados() throws Exception {				
		
		List<ParametroGrafico> parametrograficosAux= new ArrayList<ParametroGrafico>();
		
		for(ParametroGrafico parametrografico:parametrograficos) {
			if(!parametrografico.getIsDeleted()) {
				parametrograficosAux.add(parametrografico);
			}
		}
		
		parametrograficos=parametrograficosAux;
	}
	
	public void quitarParametroGraficosNulos() throws Exception {				
		
		List<ParametroGrafico> parametrograficosAux= new ArrayList<ParametroGrafico>();
		
		for(ParametroGrafico parametrografico : this.parametrograficos) {
			if(parametrografico==null) {
				parametrograficosAux.add(parametrografico);
			}
		}
		
		//this.parametrograficos=parametrograficosAux;
		
		this.parametrograficos.removeAll(parametrograficosAux);
	}
	
	public void getSetVersionRowParametroGraficoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrografico.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrografico.getIsDeleted() || (parametrografico.getIsChanged()&&!parametrografico.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrograficoDataAccess.getSetVersionRowParametroGrafico(connexion,parametrografico.getId());
				
				if(!parametrografico.getVersionRow().equals(timestamp)) {	
					parametrografico.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrografico.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroGrafico()throws Exception {	
		
		if(parametrografico.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrografico.getIsDeleted() || (parametrografico.getIsChanged()&&!parametrografico.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrograficoDataAccess.getSetVersionRowParametroGrafico(connexion,parametrografico.getId());
			
			try {							
				if(!parametrografico.getVersionRow().equals(timestamp)) {	
					parametrografico.setVersionRow(timestamp);
				}
				
				parametrografico.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroGraficosWithConnection()throws Exception {	
		if(parametrograficos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroGrafico parametrograficoAux:parametrograficos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrograficoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrograficoAux.getIsDeleted() || (parametrograficoAux.getIsChanged()&&!parametrograficoAux.getIsNew())) {
						
						timestamp=parametrograficoDataAccess.getSetVersionRowParametroGrafico(connexion,parametrograficoAux.getId());
						
						if(!parametrografico.getVersionRow().equals(timestamp)) {	
							parametrograficoAux.setVersionRow(timestamp);
						}
								
						parametrograficoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroGraficos()throws Exception {	
		if(parametrograficos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroGrafico parametrograficoAux:parametrograficos) {
					if(parametrograficoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrograficoAux.getIsDeleted() || (parametrograficoAux.getIsChanged()&&!parametrograficoAux.getIsNew())) {
						
						timestamp=parametrograficoDataAccess.getSetVersionRowParametroGrafico(connexion,parametrograficoAux.getId());
						
						if(!parametrograficoAux.getVersionRow().equals(timestamp)) {	
							parametrograficoAux.setVersionRow(timestamp);
						}
						
													
						parametrograficoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroGraficoParameterReturnGeneral cargarCombosLoteForeignKeyParametroGraficoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableActivo,String finalQueryGlobalCuentaContablePasivo,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableDisponibilidad,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableInventarioIni,String finalQueryGlobalCuentaContableInventarioFin,String finalQueryGlobalCuentaContableCuentasCobrar,String finalQueryGlobalCuentaContableVentaCredito,String finalQueryGlobalCuentaContableActivoTotal,String finalQueryGlobalCuentaContablePasivoTotal,String finalQueryGlobalCuentaContablePatrimonio,String finalQueryGlobalCuentaContablePatrimonioTotal,String finalQueryGlobalCuentaContableVenta) throws Exception {
		ParametroGraficoParameterReturnGeneral  parametrograficoReturnGeneral =new ParametroGraficoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroGraficoWithConnection");connexion.begin();
			
			parametrograficoReturnGeneral =new ParametroGraficoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrograficoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivoLogic=new CuentaContableLogic();
			cuentacontableactivoLogic.setConnexion(this.connexion);
			cuentacontableactivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivo.equals("NONE")) {
				cuentacontableactivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivo,new Pagination());
				cuentacontableactivosForeignKey=cuentacontableactivoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableactivosForeignKey(cuentacontableactivosForeignKey);


			List<CuentaContable> cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivoLogic=new CuentaContableLogic();
			cuentacontablepasivoLogic.setConnexion(this.connexion);
			cuentacontablepasivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivo.equals("NONE")) {
				cuentacontablepasivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivo,new Pagination());
				cuentacontablepasivosForeignKey=cuentacontablepasivoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepasivosForeignKey(cuentacontablepasivosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontabledisponibilidadsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledisponibilidadLogic=new CuentaContableLogic();
			cuentacontabledisponibilidadLogic.setConnexion(this.connexion);
			cuentacontabledisponibilidadLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDisponibilidad.equals("NONE")) {
				cuentacontabledisponibilidadLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDisponibilidad,new Pagination());
				cuentacontabledisponibilidadsForeignKey=cuentacontabledisponibilidadLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontabledisponibilidadsForeignKey(cuentacontabledisponibilidadsForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableinventarioinisForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioiniLogic=new CuentaContableLogic();
			cuentacontableinventarioiniLogic.setConnexion(this.connexion);
			cuentacontableinventarioiniLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventarioIni.equals("NONE")) {
				cuentacontableinventarioiniLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventarioIni,new Pagination());
				cuentacontableinventarioinisForeignKey=cuentacontableinventarioiniLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventarioinisForeignKey(cuentacontableinventarioinisForeignKey);


			List<CuentaContable> cuentacontableinventariofinsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventariofinLogic=new CuentaContableLogic();
			cuentacontableinventariofinLogic.setConnexion(this.connexion);
			cuentacontableinventariofinLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventarioFin.equals("NONE")) {
				cuentacontableinventariofinLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventarioFin,new Pagination());
				cuentacontableinventariofinsForeignKey=cuentacontableinventariofinLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventariofinsForeignKey(cuentacontableinventariofinsForeignKey);


			List<CuentaContable> cuentacontablecuentascobrarsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecuentascobrarLogic=new CuentaContableLogic();
			cuentacontablecuentascobrarLogic.setConnexion(this.connexion);
			cuentacontablecuentascobrarLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCuentasCobrar.equals("NONE")) {
				cuentacontablecuentascobrarLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCuentasCobrar,new Pagination());
				cuentacontablecuentascobrarsForeignKey=cuentacontablecuentascobrarLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablecuentascobrarsForeignKey(cuentacontablecuentascobrarsForeignKey);


			List<CuentaContable> cuentacontableventacreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventacreditoLogic=new CuentaContableLogic();
			cuentacontableventacreditoLogic.setConnexion(this.connexion);
			cuentacontableventacreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVentaCredito.equals("NONE")) {
				cuentacontableventacreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVentaCredito,new Pagination());
				cuentacontableventacreditosForeignKey=cuentacontableventacreditoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableventacreditosForeignKey(cuentacontableventacreditosForeignKey);


			List<CuentaContable> cuentacontableactivototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivototalLogic=new CuentaContableLogic();
			cuentacontableactivototalLogic.setConnexion(this.connexion);
			cuentacontableactivototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivoTotal.equals("NONE")) {
				cuentacontableactivototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivoTotal,new Pagination());
				cuentacontableactivototalsForeignKey=cuentacontableactivototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableactivototalsForeignKey(cuentacontableactivototalsForeignKey);


			List<CuentaContable> cuentacontablepasivototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivototalLogic=new CuentaContableLogic();
			cuentacontablepasivototalLogic.setConnexion(this.connexion);
			cuentacontablepasivototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivoTotal.equals("NONE")) {
				cuentacontablepasivototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivoTotal,new Pagination());
				cuentacontablepasivototalsForeignKey=cuentacontablepasivototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepasivototalsForeignKey(cuentacontablepasivototalsForeignKey);


			List<CuentaContable> cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimonioLogic=new CuentaContableLogic();
			cuentacontablepatrimonioLogic.setConnexion(this.connexion);
			cuentacontablepatrimonioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonio.equals("NONE")) {
				cuentacontablepatrimonioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonio,new Pagination());
				cuentacontablepatrimoniosForeignKey=cuentacontablepatrimonioLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepatrimoniosForeignKey(cuentacontablepatrimoniosForeignKey);


			List<CuentaContable> cuentacontablepatrimoniototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimoniototalLogic=new CuentaContableLogic();
			cuentacontablepatrimoniototalLogic.setConnexion(this.connexion);
			cuentacontablepatrimoniototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonioTotal.equals("NONE")) {
				cuentacontablepatrimoniototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonioTotal,new Pagination());
				cuentacontablepatrimoniototalsForeignKey=cuentacontablepatrimoniototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepatrimoniototalsForeignKey(cuentacontablepatrimoniototalsForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrograficoReturnGeneral;
	}
	
	public ParametroGraficoParameterReturnGeneral cargarCombosLoteForeignKeyParametroGrafico(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableActivo,String finalQueryGlobalCuentaContablePasivo,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableDisponibilidad,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableInventarioIni,String finalQueryGlobalCuentaContableInventarioFin,String finalQueryGlobalCuentaContableCuentasCobrar,String finalQueryGlobalCuentaContableVentaCredito,String finalQueryGlobalCuentaContableActivoTotal,String finalQueryGlobalCuentaContablePasivoTotal,String finalQueryGlobalCuentaContablePatrimonio,String finalQueryGlobalCuentaContablePatrimonioTotal,String finalQueryGlobalCuentaContableVenta) throws Exception {
		ParametroGraficoParameterReturnGeneral  parametrograficoReturnGeneral =new ParametroGraficoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrograficoReturnGeneral =new ParametroGraficoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrograficoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivoLogic=new CuentaContableLogic();
			cuentacontableactivoLogic.setConnexion(this.connexion);
			cuentacontableactivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivo.equals("NONE")) {
				cuentacontableactivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivo,new Pagination());
				cuentacontableactivosForeignKey=cuentacontableactivoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableactivosForeignKey(cuentacontableactivosForeignKey);


			List<CuentaContable> cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivoLogic=new CuentaContableLogic();
			cuentacontablepasivoLogic.setConnexion(this.connexion);
			cuentacontablepasivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivo.equals("NONE")) {
				cuentacontablepasivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivo,new Pagination());
				cuentacontablepasivosForeignKey=cuentacontablepasivoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepasivosForeignKey(cuentacontablepasivosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontabledisponibilidadsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledisponibilidadLogic=new CuentaContableLogic();
			cuentacontabledisponibilidadLogic.setConnexion(this.connexion);
			cuentacontabledisponibilidadLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDisponibilidad.equals("NONE")) {
				cuentacontabledisponibilidadLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDisponibilidad,new Pagination());
				cuentacontabledisponibilidadsForeignKey=cuentacontabledisponibilidadLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontabledisponibilidadsForeignKey(cuentacontabledisponibilidadsForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableinventarioinisForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioiniLogic=new CuentaContableLogic();
			cuentacontableinventarioiniLogic.setConnexion(this.connexion);
			cuentacontableinventarioiniLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventarioIni.equals("NONE")) {
				cuentacontableinventarioiniLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventarioIni,new Pagination());
				cuentacontableinventarioinisForeignKey=cuentacontableinventarioiniLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventarioinisForeignKey(cuentacontableinventarioinisForeignKey);


			List<CuentaContable> cuentacontableinventariofinsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventariofinLogic=new CuentaContableLogic();
			cuentacontableinventariofinLogic.setConnexion(this.connexion);
			cuentacontableinventariofinLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventarioFin.equals("NONE")) {
				cuentacontableinventariofinLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventarioFin,new Pagination());
				cuentacontableinventariofinsForeignKey=cuentacontableinventariofinLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableinventariofinsForeignKey(cuentacontableinventariofinsForeignKey);


			List<CuentaContable> cuentacontablecuentascobrarsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecuentascobrarLogic=new CuentaContableLogic();
			cuentacontablecuentascobrarLogic.setConnexion(this.connexion);
			cuentacontablecuentascobrarLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCuentasCobrar.equals("NONE")) {
				cuentacontablecuentascobrarLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCuentasCobrar,new Pagination());
				cuentacontablecuentascobrarsForeignKey=cuentacontablecuentascobrarLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablecuentascobrarsForeignKey(cuentacontablecuentascobrarsForeignKey);


			List<CuentaContable> cuentacontableventacreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventacreditoLogic=new CuentaContableLogic();
			cuentacontableventacreditoLogic.setConnexion(this.connexion);
			cuentacontableventacreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVentaCredito.equals("NONE")) {
				cuentacontableventacreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVentaCredito,new Pagination());
				cuentacontableventacreditosForeignKey=cuentacontableventacreditoLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableventacreditosForeignKey(cuentacontableventacreditosForeignKey);


			List<CuentaContable> cuentacontableactivototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivototalLogic=new CuentaContableLogic();
			cuentacontableactivototalLogic.setConnexion(this.connexion);
			cuentacontableactivototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivoTotal.equals("NONE")) {
				cuentacontableactivototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivoTotal,new Pagination());
				cuentacontableactivototalsForeignKey=cuentacontableactivototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableactivototalsForeignKey(cuentacontableactivototalsForeignKey);


			List<CuentaContable> cuentacontablepasivototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivototalLogic=new CuentaContableLogic();
			cuentacontablepasivototalLogic.setConnexion(this.connexion);
			cuentacontablepasivototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivoTotal.equals("NONE")) {
				cuentacontablepasivototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivoTotal,new Pagination());
				cuentacontablepasivototalsForeignKey=cuentacontablepasivototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepasivototalsForeignKey(cuentacontablepasivototalsForeignKey);


			List<CuentaContable> cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimonioLogic=new CuentaContableLogic();
			cuentacontablepatrimonioLogic.setConnexion(this.connexion);
			cuentacontablepatrimonioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonio.equals("NONE")) {
				cuentacontablepatrimonioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonio,new Pagination());
				cuentacontablepatrimoniosForeignKey=cuentacontablepatrimonioLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepatrimoniosForeignKey(cuentacontablepatrimoniosForeignKey);


			List<CuentaContable> cuentacontablepatrimoniototalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimoniototalLogic=new CuentaContableLogic();
			cuentacontablepatrimoniototalLogic.setConnexion(this.connexion);
			cuentacontablepatrimoniototalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonioTotal.equals("NONE")) {
				cuentacontablepatrimoniototalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonioTotal,new Pagination());
				cuentacontablepatrimoniototalsForeignKey=cuentacontablepatrimoniototalLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontablepatrimoniototalsForeignKey(cuentacontablepatrimoniototalsForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			parametrograficoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrograficoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroGrafico parametrografico,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroGraficoLogicAdditional.updateParametroGraficoToGet(parametrografico,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
		parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
		parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
		parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
		parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
		parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
		parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
		parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
		parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
		parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
		parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
		parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
		parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
		parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
		parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
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
			parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrografico.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
		CuentaContableLogic cuentacontableactivoLogic= new CuentaContableLogic(connexion);
		cuentacontableactivoLogic.deepLoad(parametrografico.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
		CuentaContableLogic cuentacontablepasivoLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivoLogic.deepLoad(parametrografico.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(parametrografico.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
		CuentaContableLogic cuentacontabledisponibilidadLogic= new CuentaContableLogic(connexion);
		cuentacontabledisponibilidadLogic.deepLoad(parametrografico.getCuentaContableDisponibilidad(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(parametrografico.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
		CuentaContableLogic cuentacontableinventarioiniLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioiniLogic.deepLoad(parametrografico.getCuentaContableInventarioIni(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
		CuentaContableLogic cuentacontableinventariofinLogic= new CuentaContableLogic(connexion);
		cuentacontableinventariofinLogic.deepLoad(parametrografico.getCuentaContableInventarioFin(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
		CuentaContableLogic cuentacontablecuentascobrarLogic= new CuentaContableLogic(connexion);
		cuentacontablecuentascobrarLogic.deepLoad(parametrografico.getCuentaContableCuentasCobrar(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
		CuentaContableLogic cuentacontableventacreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableventacreditoLogic.deepLoad(parametrografico.getCuentaContableVentaCredito(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
		CuentaContableLogic cuentacontableactivototalLogic= new CuentaContableLogic(connexion);
		cuentacontableactivototalLogic.deepLoad(parametrografico.getCuentaContableActivoTotal(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
		CuentaContableLogic cuentacontablepasivototalLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivototalLogic.deepLoad(parametrografico.getCuentaContablePasivoTotal(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
		CuentaContableLogic cuentacontablepatrimonioLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimonioLogic.deepLoad(parametrografico.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
		CuentaContableLogic cuentacontablepatrimoniototalLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimoniototalLogic.deepLoad(parametrografico.getCuentaContablePatrimonioTotal(),isDeep,deepLoadType,clases);
				
		parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(parametrografico.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrografico.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableActivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePasivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableDisponibilidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventarioIni(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventarioFin(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableCuentasCobrar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableVentaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableActivoTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePasivoTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePatrimonioTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrografico.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
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
			parametrografico.setEmpresa(parametrograficoDataAccess.getEmpresa(connexion,parametrografico));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrografico.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableActivo(parametrograficoDataAccess.getCuentaContableActivo(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePasivo(parametrograficoDataAccess.getCuentaContablePasivo(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventario(parametrograficoDataAccess.getCuentaContableInventario(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableDisponibilidad(parametrograficoDataAccess.getCuentaContableDisponibilidad(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableDisponibilidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableCostoVenta(parametrograficoDataAccess.getCuentaContableCostoVenta(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventarioIni(parametrograficoDataAccess.getCuentaContableInventarioIni(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventarioIni(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableInventarioFin(parametrograficoDataAccess.getCuentaContableInventarioFin(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableInventarioFin(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableCuentasCobrar(parametrograficoDataAccess.getCuentaContableCuentasCobrar(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableCuentasCobrar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableVentaCredito(parametrograficoDataAccess.getCuentaContableVentaCredito(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableVentaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableActivoTotal(parametrograficoDataAccess.getCuentaContableActivoTotal(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableActivoTotal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePasivoTotal(parametrograficoDataAccess.getCuentaContablePasivoTotal(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePasivoTotal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePatrimonio(parametrograficoDataAccess.getCuentaContablePatrimonio(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContablePatrimonioTotal(parametrograficoDataAccess.getCuentaContablePatrimonioTotal(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContablePatrimonioTotal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrografico.setCuentaContableVenta(parametrograficoDataAccess.getCuentaContableVenta(connexion,parametrografico));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrografico.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroGrafico parametrografico,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroGraficoLogicAdditional.updateParametroGraficoToSave(parametrografico,this.arrDatoGeneral);
			
ParametroGraficoDataAccess.save(parametrografico, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrografico.getEmpresa(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableActivo(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivo(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableDisponibilidad(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableCostoVenta(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioIni(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioFin(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableCuentasCobrar(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableVentaCredito(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableActivoTotal(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivoTotal(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonio(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonioTotal(),connexion);

		CuentaContableDataAccess.save(parametrografico.getCuentaContableVenta(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrografico.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableActivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableDisponibilidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableCostoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioIni(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioFin(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableCuentasCobrar(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableVentaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableActivoTotal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivoTotal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonioTotal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableVenta(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrografico.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrografico.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableActivo(),connexion);
		CuentaContableLogic cuentacontableactivoLogic= new CuentaContableLogic(connexion);
		cuentacontableactivoLogic.deepLoad(parametrografico.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivo(),connexion);
		CuentaContableLogic cuentacontablepasivoLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivoLogic.deepLoad(parametrografico.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(parametrografico.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableDisponibilidad(),connexion);
		CuentaContableLogic cuentacontabledisponibilidadLogic= new CuentaContableLogic(connexion);
		cuentacontabledisponibilidadLogic.deepLoad(parametrografico.getCuentaContableDisponibilidad(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableCostoVenta(),connexion);
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(parametrografico.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioIni(),connexion);
		CuentaContableLogic cuentacontableinventarioiniLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioiniLogic.deepLoad(parametrografico.getCuentaContableInventarioIni(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioFin(),connexion);
		CuentaContableLogic cuentacontableinventariofinLogic= new CuentaContableLogic(connexion);
		cuentacontableinventariofinLogic.deepLoad(parametrografico.getCuentaContableInventarioFin(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableCuentasCobrar(),connexion);
		CuentaContableLogic cuentacontablecuentascobrarLogic= new CuentaContableLogic(connexion);
		cuentacontablecuentascobrarLogic.deepLoad(parametrografico.getCuentaContableCuentasCobrar(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableVentaCredito(),connexion);
		CuentaContableLogic cuentacontableventacreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableventacreditoLogic.deepLoad(parametrografico.getCuentaContableVentaCredito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableActivoTotal(),connexion);
		CuentaContableLogic cuentacontableactivototalLogic= new CuentaContableLogic(connexion);
		cuentacontableactivototalLogic.deepLoad(parametrografico.getCuentaContableActivoTotal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivoTotal(),connexion);
		CuentaContableLogic cuentacontablepasivototalLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivototalLogic.deepLoad(parametrografico.getCuentaContablePasivoTotal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonio(),connexion);
		CuentaContableLogic cuentacontablepatrimonioLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimonioLogic.deepLoad(parametrografico.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonioTotal(),connexion);
		CuentaContableLogic cuentacontablepatrimoniototalLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimoniototalLogic.deepLoad(parametrografico.getCuentaContablePatrimonioTotal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrografico.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(parametrografico.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrografico.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrografico.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableActivo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableActivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContablePasivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableDisponibilidad(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableDisponibilidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableCostoVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioIni(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableInventarioIni(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableInventarioFin(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableInventarioFin(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableCuentasCobrar(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableCuentasCobrar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableVentaCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableVentaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableActivoTotal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableActivoTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePasivoTotal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContablePasivoTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContablePatrimonioTotal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContablePatrimonioTotal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrografico.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrografico.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroGrafico.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrografico,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(parametrografico);
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
			this.deepLoad(this.parametrografico,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrografico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGrafico.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrograficos!=null) {
				for(ParametroGrafico parametrografico:parametrograficos) {
					this.deepLoad(parametrografico,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(parametrograficos);
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
			if(parametrograficos!=null) {
				for(ParametroGrafico parametrografico:parametrograficos) {
					this.deepLoad(parametrografico,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(parametrograficos);
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
			this.getNewConnexionToDeep(ParametroGrafico.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrografico,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroGrafico.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrograficos!=null) {
				for(ParametroGrafico parametrografico:parametrograficos) {
					this.deepSave(parametrografico,isDeep,deepLoadType,clases);
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
			if(parametrograficos!=null) {
				for(ParametroGrafico parametrografico:parametrograficos) {
					this.deepSave(parametrografico,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroGraficosFK_IdCuentaContableActivoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivo);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableActivo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivo);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableActivoTotalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo_total)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivoTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivoTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivoTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivoTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableActivoTotal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo_total)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivoTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivoTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivoTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivoTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableCostoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableCostoVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableCuentasCobrarWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_cuenta_cobrar)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCuentasCobrar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCuentasCobrar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_cuenta_cobrar,ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCuentasCobrar);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCuentasCobrar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableCuentasCobrar(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_cuenta_cobrar)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCuentasCobrar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCuentasCobrar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_cuenta_cobrar,ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCuentasCobrar);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCuentasCobrar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableDisponibiladWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_disponibilidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDisponibilidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDisponibilidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_disponibilidad,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDisponibilidad);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDisponibilad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableDisponibilad(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_disponibilidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDisponibilidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDisponibilidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_disponibilidad,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDisponibilidad);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDisponibilad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventarioFinWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario_fin)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventarioFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventarioFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario_fin,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventarioFin);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventarioFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventarioFin(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario_fin)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventarioFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventarioFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario_fin,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventarioFin);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventarioFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventarioIniWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario_ini)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventarioIni= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventarioIni.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario_ini,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventarioIni);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventarioIni","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableInventarioIni(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario_ini)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventarioIni= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventarioIni.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario_ini,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventarioIni);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventarioIni","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePasivoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivo);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePasivo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivo);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePasivoTotalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo_total)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivoTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivoTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivoTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivoTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePasivoTotal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo_total)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivoTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivoTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivoTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivoTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePatrimonioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonio);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePatrimonio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonio);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePatrimonioTotalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio_total)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonioTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonioTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonioTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonioTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContablePatrimonioTotal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio_total)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonioTotal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonioTotal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio_total,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonioTotal);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonioTotal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdCuentaContableVentaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVentaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVentaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta_credito,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVentaCredito);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVentaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdCuentaContableVentaCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVentaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVentaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta_credito,ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVentaCredito);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVentaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGraficosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGrafico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGraficoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGraficosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGraficoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGraficoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrograficos=parametrograficoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGraficoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGrafico(this.parametrograficos);
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
			if(ParametroGraficoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGraficoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroGrafico parametrografico,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroGraficoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrografico.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGraficoDataAccess.TABLENAME, parametrografico.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGraficoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGraficoLogic.registrarAuditoriaDetallesParametroGrafico(connexion,parametrografico,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrografico.getIsDeleted()) {
					/*if(!parametrografico.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroGraficoDataAccess.TABLENAME, parametrografico.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroGraficoLogic.registrarAuditoriaDetallesParametroGrafico(connexion,parametrografico,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGraficoDataAccess.TABLENAME, parametrografico.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrografico.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGraficoDataAccess.TABLENAME, parametrografico.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGraficoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGraficoLogic.registrarAuditoriaDetallesParametroGrafico(connexion,parametrografico,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroGrafico(Connexion connexion,ParametroGrafico parametrografico)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrografico.getIsNew()||!parametrografico.getid_empresa().equals(parametrografico.getParametroGraficoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_empresa().toString();
				}
				if(parametrografico.getid_empresa()!=null)
				{
					strValorNuevo=parametrografico.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_activo().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo().toString();
				}
				if(parametrografico.getid_cuenta_contable_activo()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_pasivo().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo().toString();
				}
				if(parametrografico.getid_cuenta_contable_pasivo()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_pasivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_inventario().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(parametrografico.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_disponibilidad().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_disponibilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_disponibilidad()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_disponibilidad().toString();
				}
				if(parametrografico.getid_cuenta_contable_disponibilidad()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_disponibilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_costo_venta().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_costo_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_costo_venta()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_costo_venta().toString();
				}
				if(parametrografico.getid_cuenta_contable_costo_venta()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_costo_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_inventario_ini().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_ini()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_ini()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_ini().toString();
				}
				if(parametrografico.getid_cuenta_contable_inventario_ini()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_inventario_ini().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_inventario_fin().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_fin()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_inventario_fin().toString();
				}
				if(parametrografico.getid_cuenta_contable_inventario_fin()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_inventario_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_cuenta_cobrar().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_cuenta_cobrar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_cuenta_cobrar()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_cuenta_cobrar().toString();
				}
				if(parametrografico.getid_cuenta_contable_cuenta_cobrar()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_cuenta_cobrar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_venta_credito().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta_credito()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta_credito().toString();
				}
				if(parametrografico.getid_cuenta_contable_venta_credito()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_venta_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_activo_total().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo_total()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_activo_total().toString();
				}
				if(parametrografico.getid_cuenta_contable_activo_total()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_activo_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_pasivo_total().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo_total()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_pasivo_total().toString();
				}
				if(parametrografico.getid_cuenta_contable_pasivo_total()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_pasivo_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_patrimonio().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio().toString();
				}
				if(parametrografico.getid_cuenta_contable_patrimonio()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_patrimonio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_patrimonio_total().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio_total()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_patrimonio_total().toString();
				}
				if(parametrografico.getid_cuenta_contable_patrimonio_total()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_patrimonio_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getid_cuenta_contable_venta().equals(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getid_cuenta_contable_venta().toString();
				}
				if(parametrografico.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=parametrografico.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrografico.getIsNew()||!parametrografico.getinventario_inicial().equals(parametrografico.getParametroGraficoOriginal().getinventario_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrografico.getParametroGraficoOriginal().getinventario_inicial()!=null)
				{
					strValorActual=parametrografico.getParametroGraficoOriginal().getinventario_inicial().toString();
				}
				if(parametrografico.getinventario_inicial()!=null)
				{
					strValorNuevo=parametrografico.getinventario_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGraficoConstantesFunciones.INVENTARIOINICIAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroGraficoRelacionesWithConnection(ParametroGrafico parametrografico) throws Exception {

		if(!parametrografico.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGraficoRelacionesBase(parametrografico,true);
		}
	}

	public void saveParametroGraficoRelaciones(ParametroGrafico parametrografico)throws Exception {

		if(!parametrografico.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGraficoRelacionesBase(parametrografico,false);
		}
	}

	public void saveParametroGraficoRelacionesBase(ParametroGrafico parametrografico,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroGrafico-saveRelacionesWithConnection");}
	

			this.setParametroGrafico(parametrografico);

			if(ParametroGraficoLogicAdditional.validarSaveRelaciones(parametrografico,this)) {

				ParametroGraficoLogicAdditional.updateRelacionesToSave(parametrografico,this);

				if((parametrografico.getIsNew()||parametrografico.getIsChanged())&&!parametrografico.getIsDeleted()) {
					this.saveParametroGrafico();
					this.saveParametroGraficoRelacionesDetalles();

				} else if(parametrografico.getIsDeleted()) {
					this.saveParametroGraficoRelacionesDetalles();
					this.saveParametroGrafico();
				}

				ParametroGraficoLogicAdditional.updateRelacionesToSaveAfter(parametrografico,this);

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
	
	
	private void saveParametroGraficoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGrafico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGraficoConstantesFunciones.getClassesForeignKeysOfParametroGrafico(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGrafico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGraficoConstantesFunciones.getClassesRelationshipsOfParametroGrafico(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
