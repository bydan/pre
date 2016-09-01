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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionGrupoConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionGrupoParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionGrupoParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionGrupo;
import com.bydan.erp.comisiones.business.logic.ComisionGrupoLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ComisionGrupoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionGrupoLogic.class);
	
	protected ComisionGrupoDataAccess comisiongrupoDataAccess; 	
	protected ComisionGrupo comisiongrupo;
	protected List<ComisionGrupo> comisiongrupos;
	protected Object comisiongrupoObject;	
	protected List<Object> comisiongruposObject;
	
	public static ClassValidator<ComisionGrupo> comisiongrupoValidator = new ClassValidator<ComisionGrupo>(ComisionGrupo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionGrupoLogicAdditional comisiongrupoLogicAdditional=null;
	
	public ComisionGrupoLogicAdditional getComisionGrupoLogicAdditional() {
		return this.comisiongrupoLogicAdditional;
	}
	
	public void setComisionGrupoLogicAdditional(ComisionGrupoLogicAdditional comisiongrupoLogicAdditional) {
		try {
			this.comisiongrupoLogicAdditional=comisiongrupoLogicAdditional;
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
	
	
	
	
	public  ComisionGrupoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisiongrupoDataAccess = new ComisionGrupoDataAccess();
			
			this.comisiongrupos= new ArrayList<ComisionGrupo>();
			this.comisiongrupo= new ComisionGrupo();
			
			this.comisiongrupoObject=new Object();
			this.comisiongruposObject=new ArrayList<Object>();
				
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
			
			this.comisiongrupoDataAccess.setConnexionType(this.connexionType);
			this.comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionGrupoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisiongrupoDataAccess = new ComisionGrupoDataAccess();
			this.comisiongrupos= new ArrayList<ComisionGrupo>();
			this.comisiongrupo= new ComisionGrupo();
			this.comisiongrupoObject=new Object();
			this.comisiongruposObject=new ArrayList<Object>();
			
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
			
			this.comisiongrupoDataAccess.setConnexionType(this.connexionType);
			this.comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionGrupo getComisionGrupo() throws Exception {	
		ComisionGrupoLogicAdditional.checkComisionGrupoToGet(comisiongrupo,this.datosCliente,this.arrDatoGeneral);
		ComisionGrupoLogicAdditional.updateComisionGrupoToGet(comisiongrupo,this.arrDatoGeneral);
		
		return comisiongrupo;
	}
		
	public void setComisionGrupo(ComisionGrupo newComisionGrupo) {
		this.comisiongrupo = newComisionGrupo;
	}
	
	public ComisionGrupoDataAccess getComisionGrupoDataAccess() {
		return comisiongrupoDataAccess;
	}
	
	public void setComisionGrupoDataAccess(ComisionGrupoDataAccess newcomisiongrupoDataAccess) {
		this.comisiongrupoDataAccess = newcomisiongrupoDataAccess;
	}
	
	public List<ComisionGrupo> getComisionGrupos() throws Exception {		
		this.quitarComisionGruposNulos();
		
		ComisionGrupoLogicAdditional.checkComisionGrupoToGets(comisiongrupos,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionGrupo comisiongrupoLocal: comisiongrupos ) {
			ComisionGrupoLogicAdditional.updateComisionGrupoToGet(comisiongrupoLocal,this.arrDatoGeneral);
		}
		
		return comisiongrupos;
	}
	
	public void setComisionGrupos(List<ComisionGrupo> newComisionGrupos) {
		this.comisiongrupos = newComisionGrupos;
	}
	
	public Object getComisionGrupoObject() {	
		this.comisiongrupoObject=this.comisiongrupoDataAccess.getEntityObject();
		return this.comisiongrupoObject;
	}
		
	public void setComisionGrupoObject(Object newComisionGrupoObject) {
		this.comisiongrupoObject = newComisionGrupoObject;
	}
	
	public List<Object> getComisionGruposObject() {		
		this.comisiongruposObject=this.comisiongrupoDataAccess.getEntitiesObject();
		return this.comisiongruposObject;
	}
		
	public void setComisionGruposObject(List<Object> newComisionGruposObject) {
		this.comisiongruposObject = newComisionGruposObject;
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
		
		if(this.comisiongrupoDataAccess!=null) {
			this.comisiongrupoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisiongrupoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisiongrupoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisiongrupo = new  ComisionGrupo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
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
		comisiongrupo = new  ComisionGrupo();
		  		  
        try {
			
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisiongrupo = new  ComisionGrupo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
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
		comisiongrupo = new  ComisionGrupo();
		  		  
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
		comisiongrupo = new  ComisionGrupo();
		  		  
        try {
			
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisiongrupo = new  ComisionGrupo();
		  		  
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
		comisiongrupo = new  ComisionGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisiongrupoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisiongrupo = new  ComisionGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisiongrupoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisiongrupo = new  ComisionGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisiongrupoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisiongrupo = new  ComisionGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisiongrupoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisiongrupo = new  ComisionGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisiongrupoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisiongrupo = new  ComisionGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisiongrupoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisiongrupo = new  ComisionGrupo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
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
		comisiongrupo = new  ComisionGrupo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupo=comisiongrupoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		  		  
        try {
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionGruposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getTodosComisionGruposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
	
	public  void  getTodosComisionGrupos(String sFinalQuery,Pagination pagination)throws Exception {
		comisiongrupos = new  ArrayList<ComisionGrupo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionGrupo(comisiongrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionGrupo(ComisionGrupo comisiongrupo) throws Exception {
		Boolean estaValidado=false;
		
		if(comisiongrupo.getIsNew() || comisiongrupo.getIsChanged()) { 
			this.invalidValues = comisiongrupoValidator.getInvalidValues(comisiongrupo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisiongrupo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionGrupo(List<ComisionGrupo> ComisionGrupos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionGrupo comisiongrupoLocal:comisiongrupos) {				
			estaValidadoObjeto=this.validarGuardarComisionGrupo(comisiongrupoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionGrupo(List<ComisionGrupo> ComisionGrupos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionGrupo(comisiongrupos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionGrupo(ComisionGrupo ComisionGrupo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionGrupo(comisiongrupo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionGrupo comisiongrupo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisiongrupo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionGrupoConstantesFunciones.getComisionGrupoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisiongrupo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionGrupoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionGrupoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionGrupoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-saveComisionGrupoWithConnection");connexion.begin();			
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSave(this.comisiongrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionGrupoLogicAdditional.updateComisionGrupoToSave(this.comisiongrupo,this.arrDatoGeneral);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisiongrupo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionGrupo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionGrupo(this.comisiongrupo)) {
				ComisionGrupoDataAccess.save(this.comisiongrupo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSaveAfter(this.comisiongrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionGrupo();
			
			connexion.commit();			
			
			if(this.comisiongrupo.getIsDeleted()) {
				this.comisiongrupo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionGrupo()throws Exception {	
		try {	
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSave(this.comisiongrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionGrupoLogicAdditional.updateComisionGrupoToSave(this.comisiongrupo,this.arrDatoGeneral);
			
			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisiongrupo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionGrupo(this.comisiongrupo)) {			
				ComisionGrupoDataAccess.save(this.comisiongrupo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisiongrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSaveAfter(this.comisiongrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisiongrupo.getIsDeleted()) {
				this.comisiongrupo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionGruposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-saveComisionGruposWithConnection");connexion.begin();			
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSaves(comisiongrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionGrupos();
			
			Boolean validadoTodosComisionGrupo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionGrupo comisiongrupoLocal:comisiongrupos) {		
				if(comisiongrupoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionGrupoLogicAdditional.updateComisionGrupoToSave(comisiongrupoLocal,this.arrDatoGeneral);
	        	
				ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisiongrupoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionGrupo(comisiongrupoLocal)) {
					ComisionGrupoDataAccess.save(comisiongrupoLocal, connexion);				
				} else {
					validadoTodosComisionGrupo=false;
				}
			}
			
			if(!validadoTodosComisionGrupo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSavesAfter(comisiongrupos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionGrupos();
			
			connexion.commit();		
			
			this.quitarComisionGruposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionGrupos()throws Exception {				
		 try {	
			ComisionGrupoLogicAdditional.checkComisionGrupoToSaves(comisiongrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionGrupo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionGrupo comisiongrupoLocal:comisiongrupos) {				
				if(comisiongrupoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionGrupoLogicAdditional.updateComisionGrupoToSave(comisiongrupoLocal,this.arrDatoGeneral);
	        	
				ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisiongrupoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionGrupo(comisiongrupoLocal)) {				
					ComisionGrupoDataAccess.save(comisiongrupoLocal, connexion);				
				} else {
					validadoTodosComisionGrupo=false;
				}
			}
			
			if(!validadoTodosComisionGrupo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionGrupoLogicAdditional.checkComisionGrupoToSavesAfter(comisiongrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionGruposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionGrupoParameterReturnGeneral procesarAccionComisionGrupos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionGrupo> comisiongrupos,ComisionGrupoParameterReturnGeneral comisiongrupoParameterGeneral)throws Exception {
		 try {	
			ComisionGrupoParameterReturnGeneral comisiongrupoReturnGeneral=new ComisionGrupoParameterReturnGeneral();
	
			ComisionGrupoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisiongrupos,comisiongrupoParameterGeneral,comisiongrupoReturnGeneral);
			
			return comisiongrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionGrupoParameterReturnGeneral procesarAccionComisionGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionGrupo> comisiongrupos,ComisionGrupoParameterReturnGeneral comisiongrupoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-procesarAccionComisionGruposWithConnection");connexion.begin();			
			
			ComisionGrupoParameterReturnGeneral comisiongrupoReturnGeneral=new ComisionGrupoParameterReturnGeneral();
	
			ComisionGrupoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisiongrupos,comisiongrupoParameterGeneral,comisiongrupoReturnGeneral);
			
			this.connexion.commit();
			
			return comisiongrupoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionGrupoParameterReturnGeneral procesarEventosComisionGrupos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionGrupo> comisiongrupos,ComisionGrupo comisiongrupo,ComisionGrupoParameterReturnGeneral comisiongrupoParameterGeneral,Boolean isEsNuevoComisionGrupo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionGrupoParameterReturnGeneral comisiongrupoReturnGeneral=new ComisionGrupoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisiongrupoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionGrupoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisiongrupos,comisiongrupo,comisiongrupoParameterGeneral,comisiongrupoReturnGeneral,isEsNuevoComisionGrupo,clases);
			
			return comisiongrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionGrupoParameterReturnGeneral procesarEventosComisionGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionGrupo> comisiongrupos,ComisionGrupo comisiongrupo,ComisionGrupoParameterReturnGeneral comisiongrupoParameterGeneral,Boolean isEsNuevoComisionGrupo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-procesarEventosComisionGruposWithConnection");connexion.begin();			
			
			ComisionGrupoParameterReturnGeneral comisiongrupoReturnGeneral=new ComisionGrupoParameterReturnGeneral();
	
			comisiongrupoReturnGeneral.setComisionGrupo(comisiongrupo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisiongrupoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionGrupoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisiongrupos,comisiongrupo,comisiongrupoParameterGeneral,comisiongrupoReturnGeneral,isEsNuevoComisionGrupo,clases);
			
			this.connexion.commit();
			
			return comisiongrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionGrupoParameterReturnGeneral procesarImportacionComisionGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionGrupoParameterReturnGeneral comisiongrupoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-procesarImportacionComisionGruposWithConnection");connexion.begin();			
			
			ComisionGrupoParameterReturnGeneral comisiongrupoReturnGeneral=new ComisionGrupoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisiongrupos=new ArrayList<ComisionGrupo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisiongrupo=new ComisionGrupo();
				
				
				if(conColumnasBase) {this.comisiongrupo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisiongrupo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisiongrupo.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisiongrupo.setdescripcion(arrColumnas[iColumn++]);
				
				this.comisiongrupos.add(this.comisiongrupo);
			}
			
			this.saveComisionGrupos();
			
			this.connexion.commit();
			
			comisiongrupoReturnGeneral.setConRetornoEstaProcesado(true);
			comisiongrupoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisiongrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionGruposEliminados() throws Exception {				
		
		List<ComisionGrupo> comisiongruposAux= new ArrayList<ComisionGrupo>();
		
		for(ComisionGrupo comisiongrupo:comisiongrupos) {
			if(!comisiongrupo.getIsDeleted()) {
				comisiongruposAux.add(comisiongrupo);
			}
		}
		
		comisiongrupos=comisiongruposAux;
	}
	
	public void quitarComisionGruposNulos() throws Exception {				
		
		List<ComisionGrupo> comisiongruposAux= new ArrayList<ComisionGrupo>();
		
		for(ComisionGrupo comisiongrupo : this.comisiongrupos) {
			if(comisiongrupo==null) {
				comisiongruposAux.add(comisiongrupo);
			}
		}
		
		//this.comisiongrupos=comisiongruposAux;
		
		this.comisiongrupos.removeAll(comisiongruposAux);
	}
	
	public void getSetVersionRowComisionGrupoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisiongrupo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisiongrupo.getIsDeleted() || (comisiongrupo.getIsChanged()&&!comisiongrupo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisiongrupoDataAccess.getSetVersionRowComisionGrupo(connexion,comisiongrupo.getId());
				
				if(!comisiongrupo.getVersionRow().equals(timestamp)) {	
					comisiongrupo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisiongrupo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionGrupo()throws Exception {	
		
		if(comisiongrupo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisiongrupo.getIsDeleted() || (comisiongrupo.getIsChanged()&&!comisiongrupo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisiongrupoDataAccess.getSetVersionRowComisionGrupo(connexion,comisiongrupo.getId());
			
			try {							
				if(!comisiongrupo.getVersionRow().equals(timestamp)) {	
					comisiongrupo.setVersionRow(timestamp);
				}
				
				comisiongrupo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionGruposWithConnection()throws Exception {	
		if(comisiongrupos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionGrupo comisiongrupoAux:comisiongrupos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisiongrupoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisiongrupoAux.getIsDeleted() || (comisiongrupoAux.getIsChanged()&&!comisiongrupoAux.getIsNew())) {
						
						timestamp=comisiongrupoDataAccess.getSetVersionRowComisionGrupo(connexion,comisiongrupoAux.getId());
						
						if(!comisiongrupo.getVersionRow().equals(timestamp)) {	
							comisiongrupoAux.setVersionRow(timestamp);
						}
								
						comisiongrupoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionGrupos()throws Exception {	
		if(comisiongrupos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionGrupo comisiongrupoAux:comisiongrupos) {
					if(comisiongrupoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisiongrupoAux.getIsDeleted() || (comisiongrupoAux.getIsChanged()&&!comisiongrupoAux.getIsNew())) {
						
						timestamp=comisiongrupoDataAccess.getSetVersionRowComisionGrupo(connexion,comisiongrupoAux.getId());
						
						if(!comisiongrupoAux.getVersionRow().equals(timestamp)) {	
							comisiongrupoAux.setVersionRow(timestamp);
						}
						
													
						comisiongrupoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionGrupoParameterReturnGeneral cargarCombosLoteForeignKeyComisionGrupoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionGrupoParameterReturnGeneral  comisiongrupoReturnGeneral =new ComisionGrupoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionGrupoWithConnection");connexion.begin();
			
			comisiongrupoReturnGeneral =new ComisionGrupoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisiongrupoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisiongrupoReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisiongrupoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisiongrupoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisiongrupoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisiongrupoReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisiongrupoReturnGeneral;
	}
	
	public ComisionGrupoParameterReturnGeneral cargarCombosLoteForeignKeyComisionGrupo(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionGrupoParameterReturnGeneral  comisiongrupoReturnGeneral =new ComisionGrupoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisiongrupoReturnGeneral =new ComisionGrupoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisiongrupoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisiongrupoReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisiongrupoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisiongrupoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisiongrupoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisiongrupoReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisiongrupoReturnGeneral;
	}
	
	
	public void deepLoad(ComisionGrupo comisiongrupo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionGrupoLogicAdditional.updateComisionGrupoToGet(comisiongrupo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
		comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
		comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
		comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
		comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
		comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
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
			comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisiongrupo.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisiongrupo.getComisionConfig(),isDeep,deepLoadType,clases);
				
		comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisiongrupo.getVendedor(),isDeep,deepLoadType,clases);
				
		comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisiongrupo.getLinea(),isDeep,deepLoadType,clases);
				
		comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisiongrupo.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisiongrupo.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisiongrupo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisiongrupo.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comisiongrupo.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisiongrupo.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisiongrupo.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepLoad(comisiongrupo.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			comisiongrupo.setEmpresa(comisiongrupoDataAccess.getEmpresa(connexion,comisiongrupo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisiongrupo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setComisionConfig(comisiongrupoDataAccess.getComisionConfig(connexion,comisiongrupo));
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisiongrupo.getComisionConfig(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setVendedor(comisiongrupoDataAccess.getVendedor(connexion,comisiongrupo));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comisiongrupo.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setLinea(comisiongrupoDataAccess.getLinea(connexion,comisiongrupo));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisiongrupo.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setLineaGrupo(comisiongrupoDataAccess.getLineaGrupo(connexion,comisiongrupo));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisiongrupo.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisiongrupo.setEstadoComision(comisiongrupoDataAccess.getEstadoComision(connexion,comisiongrupo));
			EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
			estadocomisionLogic.deepLoad(comisiongrupo.getEstadoComision(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionGrupo comisiongrupo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionGrupoLogicAdditional.updateComisionGrupoToSave(comisiongrupo,this.arrDatoGeneral);
			
ComisionGrupoDataAccess.save(comisiongrupo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisiongrupo.getEmpresa(),connexion);

		ComisionConfigDataAccess.save(comisiongrupo.getComisionConfig(),connexion);

		VendedorDataAccess.save(comisiongrupo.getVendedor(),connexion);

		LineaDataAccess.save(comisiongrupo.getLinea(),connexion);

		LineaDataAccess.save(comisiongrupo.getLineaGrupo(),connexion);

		EstadoComisionDataAccess.save(comisiongrupo.getEstadoComision(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisiongrupo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisiongrupo.getComisionConfig(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisiongrupo.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisiongrupo.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisiongrupo.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisiongrupo.getEstadoComision(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisiongrupo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisiongrupo.getEmpresa(),isDeep,deepLoadType,clases);
				

		ComisionConfigDataAccess.save(comisiongrupo.getComisionConfig(),connexion);
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisiongrupo.getComisionConfig(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(comisiongrupo.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisiongrupo.getVendedor(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisiongrupo.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisiongrupo.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisiongrupo.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisiongrupo.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		EstadoComisionDataAccess.save(comisiongrupo.getEstadoComision(),connexion);
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisiongrupo.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisiongrupo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisiongrupo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisiongrupo.getComisionConfig(),connexion);
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepSave(comisiongrupo.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisiongrupo.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(comisiongrupo.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisiongrupo.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisiongrupo.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisiongrupo.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisiongrupo.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisiongrupo.getEstadoComision(),connexion);
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepSave(comisiongrupo.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ComisionGrupo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupo);
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
			this.deepLoad(this.comisiongrupo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionGrupo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisiongrupos!=null) {
				for(ComisionGrupo comisiongrupo:comisiongrupos) {
					this.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupos);
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
			if(comisiongrupos!=null) {
				for(ComisionGrupo comisiongrupo:comisiongrupos) {
					this.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupos);
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
			this.getNewConnexionToDeep(ComisionGrupo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisiongrupo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionGrupo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisiongrupos!=null) {
				for(ComisionGrupo comisiongrupo:comisiongrupos) {
					this.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
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
			if(comisiongrupos!=null) {
				for(ComisionGrupo comisiongrupo:comisiongrupos) {
					this.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionGruposFK_IdComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdComisionConfig(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionGruposFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionGrupoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionGrupoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionGruposFK_IdEstadoComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionGrupoConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdEstadoComision(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionGrupoConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionGruposFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionGrupoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionGrupoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionGruposFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionGrupoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionGrupoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionGruposFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionGrupoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionGruposFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionGrupoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(this.comisiongrupos);
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
			if(ComisionGrupoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionGrupoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionGrupo comisiongrupo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionGrupoConstantesFunciones.ISCONAUDITORIA) {
				if(comisiongrupo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionGrupoDataAccess.TABLENAME, comisiongrupo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionGrupoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionGrupoLogic.registrarAuditoriaDetallesComisionGrupo(connexion,comisiongrupo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisiongrupo.getIsDeleted()) {
					/*if(!comisiongrupo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionGrupoDataAccess.TABLENAME, comisiongrupo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionGrupoLogic.registrarAuditoriaDetallesComisionGrupo(connexion,comisiongrupo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionGrupoDataAccess.TABLENAME, comisiongrupo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisiongrupo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionGrupoDataAccess.TABLENAME, comisiongrupo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionGrupoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionGrupoLogic.registrarAuditoriaDetallesComisionGrupo(connexion,comisiongrupo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionGrupo(Connexion connexion,ComisionGrupo comisiongrupo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_empresa().equals(comisiongrupo.getComisionGrupoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_empresa()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_empresa().toString();
				}
				if(comisiongrupo.getid_empresa()!=null)
				{
					strValorNuevo=comisiongrupo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_comision_config().equals(comisiongrupo.getComisionGrupoOriginal().getid_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_comision_config()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_comision_config().toString();
				}
				if(comisiongrupo.getid_comision_config()!=null)
				{
					strValorNuevo=comisiongrupo.getid_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_vendedor().equals(comisiongrupo.getComisionGrupoOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_vendedor()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_vendedor().toString();
				}
				if(comisiongrupo.getid_vendedor()!=null)
				{
					strValorNuevo=comisiongrupo.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_linea().equals(comisiongrupo.getComisionGrupoOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_linea()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_linea().toString();
				}
				if(comisiongrupo.getid_linea()!=null)
				{
					strValorNuevo=comisiongrupo.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_linea_grupo().equals(comisiongrupo.getComisionGrupoOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_linea_grupo().toString();
				}
				if(comisiongrupo.getid_linea_grupo()!=null)
				{
					strValorNuevo=comisiongrupo.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getid_estado_comision().equals(comisiongrupo.getComisionGrupoOriginal().getid_estado_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getid_estado_comision()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getid_estado_comision().toString();
				}
				if(comisiongrupo.getid_estado_comision()!=null)
				{
					strValorNuevo=comisiongrupo.getid_estado_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.IDESTADOCOMISION,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getporcentaje().equals(comisiongrupo.getComisionGrupoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getporcentaje()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getporcentaje().toString();
				}
				if(comisiongrupo.getporcentaje()!=null)
				{
					strValorNuevo=comisiongrupo.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(comisiongrupo.getIsNew()||!comisiongrupo.getdescripcion().equals(comisiongrupo.getComisionGrupoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisiongrupo.getComisionGrupoOriginal().getdescripcion()!=null)
				{
					strValorActual=comisiongrupo.getComisionGrupoOriginal().getdescripcion();
				}
				if(comisiongrupo.getdescripcion()!=null)
				{
					strValorNuevo=comisiongrupo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionGrupoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionGrupoRelacionesWithConnection(ComisionGrupo comisiongrupo) throws Exception {

		if(!comisiongrupo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionGrupoRelacionesBase(comisiongrupo,true);
		}
	}

	public void saveComisionGrupoRelaciones(ComisionGrupo comisiongrupo)throws Exception {

		if(!comisiongrupo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionGrupoRelacionesBase(comisiongrupo,false);
		}
	}

	public void saveComisionGrupoRelacionesBase(ComisionGrupo comisiongrupo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionGrupo-saveRelacionesWithConnection");}
	

			this.setComisionGrupo(comisiongrupo);

			if(ComisionGrupoLogicAdditional.validarSaveRelaciones(comisiongrupo,this)) {

				ComisionGrupoLogicAdditional.updateRelacionesToSave(comisiongrupo,this);

				if((comisiongrupo.getIsNew()||comisiongrupo.getIsChanged())&&!comisiongrupo.getIsDeleted()) {
					this.saveComisionGrupo();
					this.saveComisionGrupoRelacionesDetalles();

				} else if(comisiongrupo.getIsDeleted()) {
					this.saveComisionGrupoRelacionesDetalles();
					this.saveComisionGrupo();
				}

				ComisionGrupoLogicAdditional.updateRelacionesToSaveAfter(comisiongrupo,this);

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
	
	
	private void saveComisionGrupoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionGrupoConstantesFunciones.getClassesRelationshipsOfComisionGrupo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
