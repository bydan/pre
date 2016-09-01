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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.PeriodoDeclaraConstantesFunciones;
import com.bydan.erp.sris.util.PeriodoDeclaraParameterReturnGeneral;
//import com.bydan.erp.sris.util.PeriodoDeclaraParameterGeneral;
import com.bydan.erp.sris.business.entity.PeriodoDeclara;
import com.bydan.erp.sris.business.logic.PeriodoDeclaraLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PeriodoDeclaraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PeriodoDeclaraLogic.class);
	
	protected PeriodoDeclaraDataAccess periododeclaraDataAccess; 	
	protected PeriodoDeclara periododeclara;
	protected List<PeriodoDeclara> periododeclaras;
	protected Object periododeclaraObject;	
	protected List<Object> periododeclarasObject;
	
	public static ClassValidator<PeriodoDeclara> periododeclaraValidator = new ClassValidator<PeriodoDeclara>(PeriodoDeclara.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PeriodoDeclaraLogicAdditional periododeclaraLogicAdditional=null;
	
	public PeriodoDeclaraLogicAdditional getPeriodoDeclaraLogicAdditional() {
		return this.periododeclaraLogicAdditional;
	}
	
	public void setPeriodoDeclaraLogicAdditional(PeriodoDeclaraLogicAdditional periododeclaraLogicAdditional) {
		try {
			this.periododeclaraLogicAdditional=periododeclaraLogicAdditional;
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
	
	
	
	
	public  PeriodoDeclaraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.periododeclaraDataAccess = new PeriodoDeclaraDataAccess();
			
			this.periododeclaras= new ArrayList<PeriodoDeclara>();
			this.periododeclara= new PeriodoDeclara();
			
			this.periododeclaraObject=new Object();
			this.periododeclarasObject=new ArrayList<Object>();
				
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
			
			this.periododeclaraDataAccess.setConnexionType(this.connexionType);
			this.periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PeriodoDeclaraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.periododeclaraDataAccess = new PeriodoDeclaraDataAccess();
			this.periododeclaras= new ArrayList<PeriodoDeclara>();
			this.periododeclara= new PeriodoDeclara();
			this.periododeclaraObject=new Object();
			this.periododeclarasObject=new ArrayList<Object>();
			
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
			
			this.periododeclaraDataAccess.setConnexionType(this.connexionType);
			this.periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PeriodoDeclara getPeriodoDeclara() throws Exception {	
		PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToGet(periododeclara,this.datosCliente,this.arrDatoGeneral);
		PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToGet(periododeclara,this.arrDatoGeneral);
		
		return periododeclara;
	}
		
	public void setPeriodoDeclara(PeriodoDeclara newPeriodoDeclara) {
		this.periododeclara = newPeriodoDeclara;
	}
	
	public PeriodoDeclaraDataAccess getPeriodoDeclaraDataAccess() {
		return periododeclaraDataAccess;
	}
	
	public void setPeriodoDeclaraDataAccess(PeriodoDeclaraDataAccess newperiododeclaraDataAccess) {
		this.periododeclaraDataAccess = newperiododeclaraDataAccess;
	}
	
	public List<PeriodoDeclara> getPeriodoDeclaras() throws Exception {		
		this.quitarPeriodoDeclarasNulos();
		
		PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToGets(periododeclaras,this.datosCliente,this.arrDatoGeneral);
		
		for (PeriodoDeclara periododeclaraLocal: periododeclaras ) {
			PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToGet(periododeclaraLocal,this.arrDatoGeneral);
		}
		
		return periododeclaras;
	}
	
	public void setPeriodoDeclaras(List<PeriodoDeclara> newPeriodoDeclaras) {
		this.periododeclaras = newPeriodoDeclaras;
	}
	
	public Object getPeriodoDeclaraObject() {	
		this.periododeclaraObject=this.periododeclaraDataAccess.getEntityObject();
		return this.periododeclaraObject;
	}
		
	public void setPeriodoDeclaraObject(Object newPeriodoDeclaraObject) {
		this.periododeclaraObject = newPeriodoDeclaraObject;
	}
	
	public List<Object> getPeriodoDeclarasObject() {		
		this.periododeclarasObject=this.periododeclaraDataAccess.getEntitiesObject();
		return this.periododeclarasObject;
	}
		
	public void setPeriodoDeclarasObject(List<Object> newPeriodoDeclarasObject) {
		this.periododeclarasObject = newPeriodoDeclarasObject;
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
		
		if(this.periododeclaraDataAccess!=null) {
			this.periododeclaraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			periododeclaraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			periododeclaraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		periododeclara = new  PeriodoDeclara();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periododeclara=periododeclaraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
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
		periododeclara = new  PeriodoDeclara();
		  		  
        try {
			
			periododeclara=periododeclaraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		periododeclara = new  PeriodoDeclara();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periododeclara=periododeclaraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
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
		periododeclara = new  PeriodoDeclara();
		  		  
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
		periododeclara = new  PeriodoDeclara();
		  		  
        try {
			
			periododeclara=periododeclaraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		periododeclara = new  PeriodoDeclara();
		  		  
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
		periododeclara = new  PeriodoDeclara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =periododeclaraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periododeclara = new  PeriodoDeclara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=periododeclaraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periododeclara = new  PeriodoDeclara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =periododeclaraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periododeclara = new  PeriodoDeclara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=periododeclaraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periododeclara = new  PeriodoDeclara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =periododeclaraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periododeclara = new  PeriodoDeclara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=periododeclaraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		periododeclara = new  PeriodoDeclara();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclara=periododeclaraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclara);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
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
		periododeclara = new  PeriodoDeclara();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclara=periododeclaraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclara);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		  		  
        try {
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPeriodoDeclarasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getTodosPeriodoDeclarasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
	
	public  void  getTodosPeriodoDeclaras(String sFinalQuery,Pagination pagination)throws Exception {
		periododeclaras = new  ArrayList<PeriodoDeclara>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoDeclara(periododeclaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPeriodoDeclara(PeriodoDeclara periododeclara) throws Exception {
		Boolean estaValidado=false;
		
		if(periododeclara.getIsNew() || periododeclara.getIsChanged()) { 
			this.invalidValues = periododeclaraValidator.getInvalidValues(periododeclara);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(periododeclara);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPeriodoDeclara(List<PeriodoDeclara> PeriodoDeclaras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PeriodoDeclara periododeclaraLocal:periododeclaras) {				
			estaValidadoObjeto=this.validarGuardarPeriodoDeclara(periododeclaraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPeriodoDeclara(List<PeriodoDeclara> PeriodoDeclaras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoDeclara(periododeclaras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPeriodoDeclara(PeriodoDeclara PeriodoDeclara) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoDeclara(periododeclara)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PeriodoDeclara periododeclara) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+periododeclara.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"periododeclara","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PeriodoDeclaraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PeriodoDeclaraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePeriodoDeclaraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-savePeriodoDeclaraWithConnection");connexion.begin();			
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSave(this.periododeclara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToSave(this.periododeclara,this.arrDatoGeneral);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periododeclara,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoDeclara();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoDeclara(this.periododeclara)) {
				PeriodoDeclaraDataAccess.save(this.periododeclara, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSaveAfter(this.periododeclara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoDeclara();
			
			connexion.commit();			
			
			if(this.periododeclara.getIsDeleted()) {
				this.periododeclara=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePeriodoDeclara()throws Exception {	
		try {	
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSave(this.periododeclara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToSave(this.periododeclara,this.arrDatoGeneral);
			
			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periododeclara,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoDeclara(this.periododeclara)) {			
				PeriodoDeclaraDataAccess.save(this.periododeclara, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.periododeclara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSaveAfter(this.periododeclara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.periododeclara.getIsDeleted()) {
				this.periododeclara=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePeriodoDeclarasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-savePeriodoDeclarasWithConnection");connexion.begin();			
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSaves(periododeclaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoDeclaras();
			
			Boolean validadoTodosPeriodoDeclara=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoDeclara periododeclaraLocal:periododeclaras) {		
				if(periododeclaraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToSave(periododeclaraLocal,this.arrDatoGeneral);
	        	
				PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periododeclaraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoDeclara(periododeclaraLocal)) {
					PeriodoDeclaraDataAccess.save(periododeclaraLocal, connexion);				
				} else {
					validadoTodosPeriodoDeclara=false;
				}
			}
			
			if(!validadoTodosPeriodoDeclara) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSavesAfter(periododeclaras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoDeclaras();
			
			connexion.commit();		
			
			this.quitarPeriodoDeclarasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePeriodoDeclaras()throws Exception {				
		 try {	
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSaves(periododeclaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPeriodoDeclara=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoDeclara periododeclaraLocal:periododeclaras) {				
				if(periododeclaraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToSave(periododeclaraLocal,this.arrDatoGeneral);
	        	
				PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periododeclaraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoDeclara(periododeclaraLocal)) {				
					PeriodoDeclaraDataAccess.save(periododeclaraLocal, connexion);				
				} else {
					validadoTodosPeriodoDeclara=false;
				}
			}
			
			if(!validadoTodosPeriodoDeclara) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoDeclaraLogicAdditional.checkPeriodoDeclaraToSavesAfter(periododeclaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPeriodoDeclarasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoDeclaraParameterReturnGeneral procesarAccionPeriodoDeclaras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoDeclara> periododeclaras,PeriodoDeclaraParameterReturnGeneral periododeclaraParameterGeneral)throws Exception {
		 try {	
			PeriodoDeclaraParameterReturnGeneral periododeclaraReturnGeneral=new PeriodoDeclaraParameterReturnGeneral();
	
			PeriodoDeclaraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periododeclaras,periododeclaraParameterGeneral,periododeclaraReturnGeneral);
			
			return periododeclaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoDeclaraParameterReturnGeneral procesarAccionPeriodoDeclarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoDeclara> periododeclaras,PeriodoDeclaraParameterReturnGeneral periododeclaraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-procesarAccionPeriodoDeclarasWithConnection");connexion.begin();			
			
			PeriodoDeclaraParameterReturnGeneral periododeclaraReturnGeneral=new PeriodoDeclaraParameterReturnGeneral();
	
			PeriodoDeclaraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periododeclaras,periododeclaraParameterGeneral,periododeclaraReturnGeneral);
			
			this.connexion.commit();
			
			return periododeclaraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoDeclaraParameterReturnGeneral procesarEventosPeriodoDeclaras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoDeclara> periododeclaras,PeriodoDeclara periododeclara,PeriodoDeclaraParameterReturnGeneral periododeclaraParameterGeneral,Boolean isEsNuevoPeriodoDeclara,ArrayList<Classe> clases)throws Exception {
		 try {	
			PeriodoDeclaraParameterReturnGeneral periododeclaraReturnGeneral=new PeriodoDeclaraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periododeclaraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoDeclaraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periododeclaras,periododeclara,periododeclaraParameterGeneral,periododeclaraReturnGeneral,isEsNuevoPeriodoDeclara,clases);
			
			return periododeclaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PeriodoDeclaraParameterReturnGeneral procesarEventosPeriodoDeclarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoDeclara> periododeclaras,PeriodoDeclara periododeclara,PeriodoDeclaraParameterReturnGeneral periododeclaraParameterGeneral,Boolean isEsNuevoPeriodoDeclara,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-procesarEventosPeriodoDeclarasWithConnection");connexion.begin();			
			
			PeriodoDeclaraParameterReturnGeneral periododeclaraReturnGeneral=new PeriodoDeclaraParameterReturnGeneral();
	
			periododeclaraReturnGeneral.setPeriodoDeclara(periododeclara);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periododeclaraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoDeclaraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periododeclaras,periododeclara,periododeclaraParameterGeneral,periododeclaraReturnGeneral,isEsNuevoPeriodoDeclara,clases);
			
			this.connexion.commit();
			
			return periododeclaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoDeclaraParameterReturnGeneral procesarImportacionPeriodoDeclarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PeriodoDeclaraParameterReturnGeneral periododeclaraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-procesarImportacionPeriodoDeclarasWithConnection");connexion.begin();			
			
			PeriodoDeclaraParameterReturnGeneral periododeclaraReturnGeneral=new PeriodoDeclaraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.periododeclaras=new ArrayList<PeriodoDeclara>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.periododeclara=new PeriodoDeclara();
				
				
				if(conColumnasBase) {this.periododeclara.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.periododeclara.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.periododeclara.setcodigo(arrColumnas[iColumn++]);
				this.periododeclara.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.periododeclara.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.periododeclaras.add(this.periododeclara);
			}
			
			this.savePeriodoDeclaras();
			
			this.connexion.commit();
			
			periododeclaraReturnGeneral.setConRetornoEstaProcesado(true);
			periododeclaraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return periododeclaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPeriodoDeclarasEliminados() throws Exception {				
		
		List<PeriodoDeclara> periododeclarasAux= new ArrayList<PeriodoDeclara>();
		
		for(PeriodoDeclara periododeclara:periododeclaras) {
			if(!periododeclara.getIsDeleted()) {
				periododeclarasAux.add(periododeclara);
			}
		}
		
		periododeclaras=periododeclarasAux;
	}
	
	public void quitarPeriodoDeclarasNulos() throws Exception {				
		
		List<PeriodoDeclara> periododeclarasAux= new ArrayList<PeriodoDeclara>();
		
		for(PeriodoDeclara periododeclara : this.periododeclaras) {
			if(periododeclara==null) {
				periododeclarasAux.add(periododeclara);
			}
		}
		
		//this.periododeclaras=periododeclarasAux;
		
		this.periododeclaras.removeAll(periododeclarasAux);
	}
	
	public void getSetVersionRowPeriodoDeclaraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(periododeclara.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((periododeclara.getIsDeleted() || (periododeclara.getIsChanged()&&!periododeclara.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=periododeclaraDataAccess.getSetVersionRowPeriodoDeclara(connexion,periododeclara.getId());
				
				if(!periododeclara.getVersionRow().equals(timestamp)) {	
					periododeclara.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				periododeclara.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPeriodoDeclara()throws Exception {	
		
		if(periododeclara.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((periododeclara.getIsDeleted() || (periododeclara.getIsChanged()&&!periododeclara.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=periododeclaraDataAccess.getSetVersionRowPeriodoDeclara(connexion,periododeclara.getId());
			
			try {							
				if(!periododeclara.getVersionRow().equals(timestamp)) {	
					periododeclara.setVersionRow(timestamp);
				}
				
				periododeclara.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPeriodoDeclarasWithConnection()throws Exception {	
		if(periododeclaras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PeriodoDeclara periododeclaraAux:periododeclaras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(periododeclaraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periododeclaraAux.getIsDeleted() || (periododeclaraAux.getIsChanged()&&!periododeclaraAux.getIsNew())) {
						
						timestamp=periododeclaraDataAccess.getSetVersionRowPeriodoDeclara(connexion,periododeclaraAux.getId());
						
						if(!periododeclara.getVersionRow().equals(timestamp)) {	
							periododeclaraAux.setVersionRow(timestamp);
						}
								
						periododeclaraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPeriodoDeclaras()throws Exception {	
		if(periododeclaras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PeriodoDeclara periododeclaraAux:periododeclaras) {
					if(periododeclaraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periododeclaraAux.getIsDeleted() || (periododeclaraAux.getIsChanged()&&!periododeclaraAux.getIsNew())) {
						
						timestamp=periododeclaraDataAccess.getSetVersionRowPeriodoDeclara(connexion,periododeclaraAux.getId());
						
						if(!periododeclaraAux.getVersionRow().equals(timestamp)) {	
							periododeclaraAux.setVersionRow(timestamp);
						}
						
													
						periododeclaraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PeriodoDeclaraParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoDeclaraWithConnection(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PeriodoDeclaraParameterReturnGeneral  periododeclaraReturnGeneral =new PeriodoDeclaraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-cargarCombosLoteForeignKeyPeriodoDeclaraWithConnection");connexion.begin();
			
			periododeclaraReturnGeneral =new PeriodoDeclaraParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			periododeclaraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			periododeclaraReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return periododeclaraReturnGeneral;
	}
	
	public PeriodoDeclaraParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoDeclara(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PeriodoDeclaraParameterReturnGeneral  periododeclaraReturnGeneral =new PeriodoDeclaraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			periododeclaraReturnGeneral =new PeriodoDeclaraParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			periododeclaraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			periododeclaraReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return periododeclaraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPeriodoDeclaraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			RetencionVentaLogic retencionventaLogic=new RetencionVentaLogic();
			FacturaDiarioLogic facturadiarioLogic=new FacturaDiarioLogic();
			DocumentoAnuladoLogic documentoanuladoLogic=new DocumentoAnuladoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPeriodoDeclaraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(RetencionVenta.class));
			classes.add(new Classe(FacturaDiario.class));
			classes.add(new Classe(DocumentoAnulado.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			retencionventaLogic.setConnexion(this.getConnexion());
			retencionventaLogic.setDatosCliente(this.datosCliente);
			retencionventaLogic.setIsConRefrescarForeignKeys(true);

			facturadiarioLogic.setConnexion(this.getConnexion());
			facturadiarioLogic.setDatosCliente(this.datosCliente);
			facturadiarioLogic.setIsConRefrescarForeignKeys(true);

			documentoanuladoLogic.setConnexion(this.getConnexion());
			documentoanuladoLogic.setDatosCliente(this.datosCliente);
			documentoanuladoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PeriodoDeclara periododeclara:this.periododeclaras) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(periododeclara.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RetencionVentaConstantesFunciones.getClassesForeignKeysOfRetencionVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				retencionventaLogic.setRetencionVentas(periododeclara.retencionventas);
				retencionventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaDiarioConstantesFunciones.getClassesForeignKeysOfFacturaDiario(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturadiarioLogic.setFacturaDiarios(periododeclara.facturadiarios);
				facturadiarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DocumentoAnuladoConstantesFunciones.getClassesForeignKeysOfDocumentoAnulado(new ArrayList<Classe>(),DeepLoadType.NONE);

				documentoanuladoLogic.setDocumentoAnulados(periododeclara.documentoanulados);
				documentoanuladoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(PeriodoDeclara periododeclara,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToGet(periododeclara,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
		periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
		periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));
		periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));
		periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));
		periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(periododeclara.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					periododeclara.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));

				if(this.isConDeep) {
					RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(this.connexion);
					retencionventaLogic.setRetencionVentas(periododeclara.getRetencionVentas());
					ArrayList<Classe> classesLocal=RetencionVentaConstantesFunciones.getClassesForeignKeysOfRetencionVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					retencionventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(retencionventaLogic.getRetencionVentas());
					periododeclara.setRetencionVentas(retencionventaLogic.getRetencionVentas());
				}

				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));

				if(this.isConDeep) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(this.connexion);
					facturadiarioLogic.setFacturaDiarios(periododeclara.getFacturaDiarios());
					ArrayList<Classe> classesLocal=FacturaDiarioConstantesFunciones.getClassesForeignKeysOfFacturaDiario(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturadiarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(facturadiarioLogic.getFacturaDiarios());
					periododeclara.setFacturaDiarios(facturadiarioLogic.getFacturaDiarios());
				}

				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));

				if(this.isConDeep) {
					DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(this.connexion);
					documentoanuladoLogic.setDocumentoAnulados(periododeclara.getDocumentoAnulados());
					ArrayList<Classe> classesLocal=DocumentoAnuladoConstantesFunciones.getClassesForeignKeysOfDocumentoAnulado(new ArrayList<Classe>(),DeepLoadType.NONE);
					documentoanuladoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(documentoanuladoLogic.getDocumentoAnulados());
					periododeclara.setDocumentoAnulados(documentoanuladoLogic.getDocumentoAnulados());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RetencionVenta.class));
			periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaDiario.class));
			periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DocumentoAnulado.class));
			periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(periododeclara.getAnio(),isDeep,deepLoadType,clases);
				
		periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(periododeclara.getMes(),isDeep,deepLoadType,clases);
				

		periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));

		for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));

		for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
			RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(connexion);
			retencionventaLogic.deepLoad(retencionventa,isDeep,deepLoadType,clases);
		}

		periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));

		for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
			FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
			facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
		}

		periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));

		for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
			DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
			documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(periododeclara.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(periododeclara.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));

				for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));

				for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
					RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(connexion);
					retencionventaLogic.deepLoad(retencionventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));

				for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
					facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));

				for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
					DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
					documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periododeclara.setAnio(periododeclaraDataAccess.getAnio(connexion,periododeclara));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(periododeclara.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periododeclara.setMes(periododeclaraDataAccess.getMes(connexion,periododeclara));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(periododeclara.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			periododeclara.setTransaccionLocals(periododeclaraDataAccess.getTransaccionLocals(connexion,periododeclara));

			for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RetencionVenta.class));
			periododeclara.setRetencionVentas(periododeclaraDataAccess.getRetencionVentas(connexion,periododeclara));

			for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
				RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(connexion);
				retencionventaLogic.deepLoad(retencionventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaDiario.class));
			periododeclara.setFacturaDiarios(periododeclaraDataAccess.getFacturaDiarios(connexion,periododeclara));

			for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
				FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
				facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DocumentoAnulado.class));
			periododeclara.setDocumentoAnulados(periododeclaraDataAccess.getDocumentoAnulados(connexion,periododeclara));

			for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
				DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
				documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PeriodoDeclara periododeclara,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PeriodoDeclaraLogicAdditional.updatePeriodoDeclaraToSave(periododeclara,this.arrDatoGeneral);
			
PeriodoDeclaraDataAccess.save(periododeclara, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(periododeclara.getAnio(),connexion);

		MesDataAccess.save(periododeclara.getMes(),connexion);

		for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
			transaccionlocal.setid_periodo_declara(periododeclara.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}

		for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
			retencionventa.setid_periodo_declara(periododeclara.getId());
			RetencionVentaDataAccess.save(retencionventa,connexion);
		}

		for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
			facturadiario.setid_periodo_declara(periododeclara.getId());
			FacturaDiarioDataAccess.save(facturadiario,connexion);
		}

		for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
			documentoanulado.setid_periodo_declara(periododeclara.getId());
			DocumentoAnuladoDataAccess.save(documentoanulado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(periododeclara.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(periododeclara.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
					transaccionlocal.setid_periodo_declara(periododeclara.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
					retencionventa.setid_periodo_declara(periododeclara.getId());
					RetencionVentaDataAccess.save(retencionventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
					facturadiario.setid_periodo_declara(periododeclara.getId());
					FacturaDiarioDataAccess.save(facturadiario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
					documentoanulado.setid_periodo_declara(periododeclara.getId());
					DocumentoAnuladoDataAccess.save(documentoanulado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(periododeclara.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(periododeclara.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(periododeclara.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(periododeclara.getMes(),isDeep,deepLoadType,clases);
				

		for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_periodo_declara(periododeclara.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}

		for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
			RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(connexion);
			retencionventa.setid_periodo_declara(periododeclara.getId());
			RetencionVentaDataAccess.save(retencionventa,connexion);
			retencionventaLogic.deepSave(retencionventa,isDeep,deepLoadType,clases);
		}

		for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
			FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
			facturadiario.setid_periodo_declara(periododeclara.getId());
			FacturaDiarioDataAccess.save(facturadiario,connexion);
			facturadiarioLogic.deepSave(facturadiario,isDeep,deepLoadType,clases);
		}

		for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
			DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
			documentoanulado.setid_periodo_declara(periododeclara.getId());
			DocumentoAnuladoDataAccess.save(documentoanulado,connexion);
			documentoanuladoLogic.deepSave(documentoanulado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(periododeclara.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(periododeclara.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(periododeclara.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(periododeclara.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:periododeclara.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_periodo_declara(periododeclara.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RetencionVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RetencionVenta retencionventa:periododeclara.getRetencionVentas()) {
					RetencionVentaLogic retencionventaLogic= new RetencionVentaLogic(connexion);
					retencionventa.setid_periodo_declara(periododeclara.getId());
					RetencionVentaDataAccess.save(retencionventa,connexion);
					retencionventaLogic.deepSave(retencionventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaDiario facturadiario:periododeclara.getFacturaDiarios()) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
					facturadiario.setid_periodo_declara(periododeclara.getId());
					FacturaDiarioDataAccess.save(facturadiario,connexion);
					facturadiarioLogic.deepSave(facturadiario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DocumentoAnulado documentoanulado:periododeclara.getDocumentoAnulados()) {
					DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
					documentoanulado.setid_periodo_declara(periododeclara.getId());
					DocumentoAnuladoDataAccess.save(documentoanulado,connexion);
					documentoanuladoLogic.deepSave(documentoanulado,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(PeriodoDeclara.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(periododeclara,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(periododeclara);
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
			this.deepLoad(this.periododeclara,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PeriodoDeclara.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(periododeclaras!=null) {
				for(PeriodoDeclara periododeclara:periododeclaras) {
					this.deepLoad(periododeclara,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(periododeclaras);
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
			if(periododeclaras!=null) {
				for(PeriodoDeclara periododeclara:periododeclaras) {
					this.deepLoad(periododeclara,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(periododeclaras);
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
			this.getNewConnexionToDeep(PeriodoDeclara.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(periododeclara,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PeriodoDeclara.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(periododeclaras!=null) {
				for(PeriodoDeclara periododeclara:periododeclaras) {
					this.deepSave(periododeclara,isDeep,deepLoadType,clases);
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
			if(periododeclaras!=null) {
				for(PeriodoDeclara periododeclara:periododeclaras) {
					this.deepSave(periododeclara,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPeriodoDeclarasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoDeclaraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoDeclarasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoDeclaraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoDeclarasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoDeclara.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoDeclaraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoDeclarasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoDeclaraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PeriodoDeclaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periododeclaras=periododeclaraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoDeclaraConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoDeclara(this.periododeclaras);
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
			if(PeriodoDeclaraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoDeclaraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PeriodoDeclara periododeclara,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PeriodoDeclaraConstantesFunciones.ISCONAUDITORIA) {
				if(periododeclara.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoDeclaraDataAccess.TABLENAME, periododeclara.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoDeclaraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoDeclaraLogic.registrarAuditoriaDetallesPeriodoDeclara(connexion,periododeclara,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(periododeclara.getIsDeleted()) {
					/*if(!periododeclara.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PeriodoDeclaraDataAccess.TABLENAME, periododeclara.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PeriodoDeclaraLogic.registrarAuditoriaDetallesPeriodoDeclara(connexion,periododeclara,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoDeclaraDataAccess.TABLENAME, periododeclara.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(periododeclara.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoDeclaraDataAccess.TABLENAME, periododeclara.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoDeclaraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoDeclaraLogic.registrarAuditoriaDetallesPeriodoDeclara(connexion,periododeclara,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPeriodoDeclara(Connexion connexion,PeriodoDeclara periododeclara)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(periododeclara.getIsNew()||!periododeclara.getcodigo().equals(periododeclara.getPeriodoDeclaraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periododeclara.getPeriodoDeclaraOriginal().getcodigo()!=null)
				{
					strValorActual=periododeclara.getPeriodoDeclaraOriginal().getcodigo();
				}
				if(periododeclara.getcodigo()!=null)
				{
					strValorNuevo=periododeclara.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoDeclaraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(periododeclara.getIsNew()||!periododeclara.getid_anio().equals(periododeclara.getPeriodoDeclaraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periododeclara.getPeriodoDeclaraOriginal().getid_anio()!=null)
				{
					strValorActual=periododeclara.getPeriodoDeclaraOriginal().getid_anio().toString();
				}
				if(periododeclara.getid_anio()!=null)
				{
					strValorNuevo=periododeclara.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoDeclaraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(periododeclara.getIsNew()||!periododeclara.getid_mes().equals(periododeclara.getPeriodoDeclaraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periododeclara.getPeriodoDeclaraOriginal().getid_mes()!=null)
				{
					strValorActual=periododeclara.getPeriodoDeclaraOriginal().getid_mes().toString();
				}
				if(periododeclara.getid_mes()!=null)
				{
					strValorNuevo=periododeclara.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoDeclaraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(periododeclara.getIsNew()||!periododeclara.getfecha().equals(periododeclara.getPeriodoDeclaraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periododeclara.getPeriodoDeclaraOriginal().getfecha()!=null)
				{
					strValorActual=periododeclara.getPeriodoDeclaraOriginal().getfecha().toString();
				}
				if(periododeclara.getfecha()!=null)
				{
					strValorNuevo=periododeclara.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoDeclaraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(periododeclara.getIsNew()||!periododeclara.getesta_activo().equals(periododeclara.getPeriodoDeclaraOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periododeclara.getPeriodoDeclaraOriginal().getesta_activo()!=null)
				{
					strValorActual=periododeclara.getPeriodoDeclaraOriginal().getesta_activo().toString();
				}
				if(periododeclara.getesta_activo()!=null)
				{
					strValorNuevo=periododeclara.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoDeclaraConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePeriodoDeclaraRelacionesWithConnection(PeriodoDeclara periododeclara,List<TransaccionLocal> transaccionlocals,List<RetencionVenta> retencionventas,List<FacturaDiario> facturadiarios,List<DocumentoAnulado> documentoanulados) throws Exception {

		if(!periododeclara.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoDeclaraRelacionesBase(periododeclara,transaccionlocals,retencionventas,facturadiarios,documentoanulados,true);
		}
	}

	public void savePeriodoDeclaraRelaciones(PeriodoDeclara periododeclara,List<TransaccionLocal> transaccionlocals,List<RetencionVenta> retencionventas,List<FacturaDiario> facturadiarios,List<DocumentoAnulado> documentoanulados)throws Exception {

		if(!periododeclara.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoDeclaraRelacionesBase(periododeclara,transaccionlocals,retencionventas,facturadiarios,documentoanulados,false);
		}
	}

	public void savePeriodoDeclaraRelacionesBase(PeriodoDeclara periododeclara,List<TransaccionLocal> transaccionlocals,List<RetencionVenta> retencionventas,List<FacturaDiario> facturadiarios,List<DocumentoAnulado> documentoanulados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PeriodoDeclara-saveRelacionesWithConnection");}
	
			periododeclara.setTransaccionLocals(transaccionlocals);
			periododeclara.setRetencionVentas(retencionventas);
			periododeclara.setFacturaDiarios(facturadiarios);
			periododeclara.setDocumentoAnulados(documentoanulados);

			this.setPeriodoDeclara(periododeclara);

			if(PeriodoDeclaraLogicAdditional.validarSaveRelaciones(periododeclara,this)) {

				PeriodoDeclaraLogicAdditional.updateRelacionesToSave(periododeclara,this);

				if((periododeclara.getIsNew()||periododeclara.getIsChanged())&&!periododeclara.getIsDeleted()) {
					this.savePeriodoDeclara();
					this.savePeriodoDeclaraRelacionesDetalles(transaccionlocals,retencionventas,facturadiarios,documentoanulados);

				} else if(periododeclara.getIsDeleted()) {
					this.savePeriodoDeclaraRelacionesDetalles(transaccionlocals,retencionventas,facturadiarios,documentoanulados);
					this.savePeriodoDeclara();
				}

				PeriodoDeclaraLogicAdditional.updateRelacionesToSaveAfter(periododeclara,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);
			RetencionVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresRetencionVentas(retencionventas,true,true);
			FacturaDiarioConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaDiarios(facturadiarios,true,true);
			DocumentoAnuladoConstantesFunciones.InicializarGeneralEntityAuxiliaresDocumentoAnulados(documentoanulados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePeriodoDeclaraRelacionesDetalles(List<TransaccionLocal> transaccionlocals,List<RetencionVenta> retencionventas,List<FacturaDiario> facturadiarios,List<DocumentoAnulado> documentoanulados)throws Exception {
		try {
	

			Long idPeriodoDeclaraActual=this.getPeriodoDeclara().getId();

			TransaccionLocalLogic transaccionlocalLogic_Desde_PeriodoDeclara=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_PeriodoDeclara.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_PeriodoDeclara.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_PeriodoDeclara.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_PeriodoDeclara:transaccionlocalLogic_Desde_PeriodoDeclara.getTransaccionLocals()) {
				transaccionlocal_Desde_PeriodoDeclara.setid_periodo_declara(idPeriodoDeclaraActual);
			}

			transaccionlocalLogic_Desde_PeriodoDeclara.saveTransaccionLocals();

			RetencionVentaLogic retencionventaLogic_Desde_PeriodoDeclara=new RetencionVentaLogic();
			retencionventaLogic_Desde_PeriodoDeclara.setRetencionVentas(retencionventas);

			retencionventaLogic_Desde_PeriodoDeclara.setConnexion(this.getConnexion());
			retencionventaLogic_Desde_PeriodoDeclara.setDatosCliente(this.datosCliente);

			for(RetencionVenta retencionventa_Desde_PeriodoDeclara:retencionventaLogic_Desde_PeriodoDeclara.getRetencionVentas()) {
				retencionventa_Desde_PeriodoDeclara.setid_periodo_declara(idPeriodoDeclaraActual);
			}

			retencionventaLogic_Desde_PeriodoDeclara.saveRetencionVentas();

			FacturaDiarioLogic facturadiarioLogic_Desde_PeriodoDeclara=new FacturaDiarioLogic();
			facturadiarioLogic_Desde_PeriodoDeclara.setFacturaDiarios(facturadiarios);

			facturadiarioLogic_Desde_PeriodoDeclara.setConnexion(this.getConnexion());
			facturadiarioLogic_Desde_PeriodoDeclara.setDatosCliente(this.datosCliente);

			for(FacturaDiario facturadiario_Desde_PeriodoDeclara:facturadiarioLogic_Desde_PeriodoDeclara.getFacturaDiarios()) {
				facturadiario_Desde_PeriodoDeclara.setid_periodo_declara(idPeriodoDeclaraActual);
			}

			facturadiarioLogic_Desde_PeriodoDeclara.saveFacturaDiarios();

			DocumentoAnuladoLogic documentoanuladoLogic_Desde_PeriodoDeclara=new DocumentoAnuladoLogic();
			documentoanuladoLogic_Desde_PeriodoDeclara.setDocumentoAnulados(documentoanulados);

			documentoanuladoLogic_Desde_PeriodoDeclara.setConnexion(this.getConnexion());
			documentoanuladoLogic_Desde_PeriodoDeclara.setDatosCliente(this.datosCliente);

			for(DocumentoAnulado documentoanulado_Desde_PeriodoDeclara:documentoanuladoLogic_Desde_PeriodoDeclara.getDocumentoAnulados()) {
				documentoanulado_Desde_PeriodoDeclara.setid_periodo_declara(idPeriodoDeclaraActual);
			}

			documentoanuladoLogic_Desde_PeriodoDeclara.saveDocumentoAnulados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoDeclara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoDeclaraConstantesFunciones.getClassesForeignKeysOfPeriodoDeclara(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoDeclara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoDeclaraConstantesFunciones.getClassesRelationshipsOfPeriodoDeclara(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
