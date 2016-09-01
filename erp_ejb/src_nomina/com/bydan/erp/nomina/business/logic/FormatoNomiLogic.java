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
import com.bydan.erp.nomina.util.FormatoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.FormatoNomi;
import com.bydan.erp.nomina.business.logic.FormatoNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormatoNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormatoNomiLogic.class);
	
	protected FormatoNomiDataAccess formatonomiDataAccess; 	
	protected FormatoNomi formatonomi;
	protected List<FormatoNomi> formatonomis;
	protected Object formatonomiObject;	
	protected List<Object> formatonomisObject;
	
	public static ClassValidator<FormatoNomi> formatonomiValidator = new ClassValidator<FormatoNomi>(FormatoNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormatoNomiLogicAdditional formatonomiLogicAdditional=null;
	
	public FormatoNomiLogicAdditional getFormatoNomiLogicAdditional() {
		return this.formatonomiLogicAdditional;
	}
	
	public void setFormatoNomiLogicAdditional(FormatoNomiLogicAdditional formatonomiLogicAdditional) {
		try {
			this.formatonomiLogicAdditional=formatonomiLogicAdditional;
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
	
	
	
	
	public  FormatoNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formatonomiDataAccess = new FormatoNomiDataAccess();
			
			this.formatonomis= new ArrayList<FormatoNomi>();
			this.formatonomi= new FormatoNomi();
			
			this.formatonomiObject=new Object();
			this.formatonomisObject=new ArrayList<Object>();
				
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
			
			this.formatonomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormatoNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formatonomiDataAccess = new FormatoNomiDataAccess();
			this.formatonomis= new ArrayList<FormatoNomi>();
			this.formatonomi= new FormatoNomi();
			this.formatonomiObject=new Object();
			this.formatonomisObject=new ArrayList<Object>();
			
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
			
			this.formatonomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormatoNomi getFormatoNomi() throws Exception {	
		FormatoNomiLogicAdditional.checkFormatoNomiToGet(formatonomi,this.datosCliente,this.arrDatoGeneral);
		FormatoNomiLogicAdditional.updateFormatoNomiToGet(formatonomi,this.arrDatoGeneral);
		
		return formatonomi;
	}
		
	public void setFormatoNomi(FormatoNomi newFormatoNomi) {
		this.formatonomi = newFormatoNomi;
	}
	
	public FormatoNomiDataAccess getFormatoNomiDataAccess() {
		return formatonomiDataAccess;
	}
	
	public void setFormatoNomiDataAccess(FormatoNomiDataAccess newformatonomiDataAccess) {
		this.formatonomiDataAccess = newformatonomiDataAccess;
	}
	
	public List<FormatoNomi> getFormatoNomis() throws Exception {		
		this.quitarFormatoNomisNulos();
		
		FormatoNomiLogicAdditional.checkFormatoNomiToGets(formatonomis,this.datosCliente,this.arrDatoGeneral);
		
		for (FormatoNomi formatonomiLocal: formatonomis ) {
			FormatoNomiLogicAdditional.updateFormatoNomiToGet(formatonomiLocal,this.arrDatoGeneral);
		}
		
		return formatonomis;
	}
	
	public void setFormatoNomis(List<FormatoNomi> newFormatoNomis) {
		this.formatonomis = newFormatoNomis;
	}
	
	public Object getFormatoNomiObject() {	
		this.formatonomiObject=this.formatonomiDataAccess.getEntityObject();
		return this.formatonomiObject;
	}
		
	public void setFormatoNomiObject(Object newFormatoNomiObject) {
		this.formatonomiObject = newFormatoNomiObject;
	}
	
	public List<Object> getFormatoNomisObject() {		
		this.formatonomisObject=this.formatonomiDataAccess.getEntitiesObject();
		return this.formatonomisObject;
	}
		
	public void setFormatoNomisObject(List<Object> newFormatoNomisObject) {
		this.formatonomisObject = newFormatoNomisObject;
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
		
		if(this.formatonomiDataAccess!=null) {
			this.formatonomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formatonomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formatonomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formatonomi = new  FormatoNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomi=formatonomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
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
		formatonomi = new  FormatoNomi();
		  		  
        try {
			
			formatonomi=formatonomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formatonomi = new  FormatoNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomi=formatonomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
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
		formatonomi = new  FormatoNomi();
		  		  
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
		formatonomi = new  FormatoNomi();
		  		  
        try {
			
			formatonomi=formatonomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formatonomi = new  FormatoNomi();
		  		  
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
		formatonomi = new  FormatoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formatonomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomi = new  FormatoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formatonomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomi = new  FormatoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formatonomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomi = new  FormatoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formatonomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomi = new  FormatoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formatonomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomi = new  FormatoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formatonomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
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
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
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
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
		formatonomis = new  ArrayList<FormatoNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
		formatonomis = new  ArrayList<FormatoNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formatonomi = new  FormatoNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomi=formatonomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
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
		formatonomi = new  FormatoNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomi=formatonomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
		formatonomis = new  ArrayList<FormatoNomi>();
		  		  
        try {
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormatoNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomis = new  ArrayList<FormatoNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getTodosFormatoNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
	
	public  void  getTodosFormatoNomis(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomis = new  ArrayList<FormatoNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomi(formatonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormatoNomi(FormatoNomi formatonomi) throws Exception {
		Boolean estaValidado=false;
		
		if(formatonomi.getIsNew() || formatonomi.getIsChanged()) { 
			this.invalidValues = formatonomiValidator.getInvalidValues(formatonomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formatonomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormatoNomi(List<FormatoNomi> FormatoNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormatoNomi formatonomiLocal:formatonomis) {				
			estaValidadoObjeto=this.validarGuardarFormatoNomi(formatonomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormatoNomi(List<FormatoNomi> FormatoNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomi(formatonomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormatoNomi(FormatoNomi FormatoNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomi(formatonomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormatoNomi formatonomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formatonomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormatoNomiConstantesFunciones.getFormatoNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formatonomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormatoNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormatoNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormatoNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-saveFormatoNomiWithConnection");connexion.begin();			
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSave(this.formatonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiLogicAdditional.updateFormatoNomiToSave(this.formatonomi,this.arrDatoGeneral);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomi(this.formatonomi)) {
				FormatoNomiDataAccess.save(this.formatonomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSaveAfter(this.formatonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomi();
			
			connexion.commit();			
			
			if(this.formatonomi.getIsDeleted()) {
				this.formatonomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormatoNomi()throws Exception {	
		try {	
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSave(this.formatonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiLogicAdditional.updateFormatoNomiToSave(this.formatonomi,this.arrDatoGeneral);
			
			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomi(this.formatonomi)) {			
				FormatoNomiDataAccess.save(this.formatonomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formatonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSaveAfter(this.formatonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formatonomi.getIsDeleted()) {
				this.formatonomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormatoNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-saveFormatoNomisWithConnection");connexion.begin();			
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSaves(formatonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomis();
			
			Boolean validadoTodosFormatoNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomi formatonomiLocal:formatonomis) {		
				if(formatonomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiLogicAdditional.updateFormatoNomiToSave(formatonomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomi(formatonomiLocal)) {
					FormatoNomiDataAccess.save(formatonomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSavesAfter(formatonomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomis();
			
			connexion.commit();		
			
			this.quitarFormatoNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormatoNomis()throws Exception {				
		 try {	
			FormatoNomiLogicAdditional.checkFormatoNomiToSaves(formatonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormatoNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomi formatonomiLocal:formatonomis) {				
				if(formatonomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiLogicAdditional.updateFormatoNomiToSave(formatonomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomi(formatonomiLocal)) {				
					FormatoNomiDataAccess.save(formatonomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiLogicAdditional.checkFormatoNomiToSavesAfter(formatonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormatoNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiParameterReturnGeneral procesarAccionFormatoNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomi> formatonomis,FormatoNomiParameterReturnGeneral formatonomiParameterGeneral)throws Exception {
		 try {	
			FormatoNomiParameterReturnGeneral formatonomiReturnGeneral=new FormatoNomiParameterReturnGeneral();
	
			FormatoNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomis,formatonomiParameterGeneral,formatonomiReturnGeneral);
			
			return formatonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiParameterReturnGeneral procesarAccionFormatoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomi> formatonomis,FormatoNomiParameterReturnGeneral formatonomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-procesarAccionFormatoNomisWithConnection");connexion.begin();			
			
			FormatoNomiParameterReturnGeneral formatonomiReturnGeneral=new FormatoNomiParameterReturnGeneral();
	
			FormatoNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomis,formatonomiParameterGeneral,formatonomiReturnGeneral);
			
			this.connexion.commit();
			
			return formatonomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiParameterReturnGeneral procesarEventosFormatoNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomi> formatonomis,FormatoNomi formatonomi,FormatoNomiParameterReturnGeneral formatonomiParameterGeneral,Boolean isEsNuevoFormatoNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormatoNomiParameterReturnGeneral formatonomiReturnGeneral=new FormatoNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomis,formatonomi,formatonomiParameterGeneral,formatonomiReturnGeneral,isEsNuevoFormatoNomi,clases);
			
			return formatonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormatoNomiParameterReturnGeneral procesarEventosFormatoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomi> formatonomis,FormatoNomi formatonomi,FormatoNomiParameterReturnGeneral formatonomiParameterGeneral,Boolean isEsNuevoFormatoNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-procesarEventosFormatoNomisWithConnection");connexion.begin();			
			
			FormatoNomiParameterReturnGeneral formatonomiReturnGeneral=new FormatoNomiParameterReturnGeneral();
	
			formatonomiReturnGeneral.setFormatoNomi(formatonomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomis,formatonomi,formatonomiParameterGeneral,formatonomiReturnGeneral,isEsNuevoFormatoNomi,clases);
			
			this.connexion.commit();
			
			return formatonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiParameterReturnGeneral procesarImportacionFormatoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormatoNomiParameterReturnGeneral formatonomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-procesarImportacionFormatoNomisWithConnection");connexion.begin();			
			
			FormatoNomiParameterReturnGeneral formatonomiReturnGeneral=new FormatoNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formatonomis=new ArrayList<FormatoNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formatonomi=new FormatoNomi();
				
				
				if(conColumnasBase) {this.formatonomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formatonomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formatonomi.setcodigo(arrColumnas[iColumn++]);
				this.formatonomi.setnombre(arrColumnas[iColumn++]);
				this.formatonomi.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.formatonomi.setinstrucciones(arrColumnas[iColumn++]);
				
				this.formatonomis.add(this.formatonomi);
			}
			
			this.saveFormatoNomis();
			
			this.connexion.commit();
			
			formatonomiReturnGeneral.setConRetornoEstaProcesado(true);
			formatonomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formatonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormatoNomisEliminados() throws Exception {				
		
		List<FormatoNomi> formatonomisAux= new ArrayList<FormatoNomi>();
		
		for(FormatoNomi formatonomi:formatonomis) {
			if(!formatonomi.getIsDeleted()) {
				formatonomisAux.add(formatonomi);
			}
		}
		
		formatonomis=formatonomisAux;
	}
	
	public void quitarFormatoNomisNulos() throws Exception {				
		
		List<FormatoNomi> formatonomisAux= new ArrayList<FormatoNomi>();
		
		for(FormatoNomi formatonomi : this.formatonomis) {
			if(formatonomi==null) {
				formatonomisAux.add(formatonomi);
			}
		}
		
		//this.formatonomis=formatonomisAux;
		
		this.formatonomis.removeAll(formatonomisAux);
	}
	
	public void getSetVersionRowFormatoNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formatonomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formatonomi.getIsDeleted() || (formatonomi.getIsChanged()&&!formatonomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formatonomiDataAccess.getSetVersionRowFormatoNomi(connexion,formatonomi.getId());
				
				if(!formatonomi.getVersionRow().equals(timestamp)) {	
					formatonomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formatonomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormatoNomi()throws Exception {	
		
		if(formatonomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formatonomi.getIsDeleted() || (formatonomi.getIsChanged()&&!formatonomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formatonomiDataAccess.getSetVersionRowFormatoNomi(connexion,formatonomi.getId());
			
			try {							
				if(!formatonomi.getVersionRow().equals(timestamp)) {	
					formatonomi.setVersionRow(timestamp);
				}
				
				formatonomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormatoNomisWithConnection()throws Exception {	
		if(formatonomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormatoNomi formatonomiAux:formatonomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formatonomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomiAux.getIsDeleted() || (formatonomiAux.getIsChanged()&&!formatonomiAux.getIsNew())) {
						
						timestamp=formatonomiDataAccess.getSetVersionRowFormatoNomi(connexion,formatonomiAux.getId());
						
						if(!formatonomi.getVersionRow().equals(timestamp)) {	
							formatonomiAux.setVersionRow(timestamp);
						}
								
						formatonomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormatoNomis()throws Exception {	
		if(formatonomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormatoNomi formatonomiAux:formatonomis) {
					if(formatonomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomiAux.getIsDeleted() || (formatonomiAux.getIsChanged()&&!formatonomiAux.getIsNew())) {
						
						timestamp=formatonomiDataAccess.getSetVersionRowFormatoNomi(connexion,formatonomiAux.getId());
						
						if(!formatonomiAux.getVersionRow().equals(timestamp)) {	
							formatonomiAux.setVersionRow(timestamp);
						}
						
													
						formatonomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormatoNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalPuntajeNomi) throws Exception {
		FormatoNomiParameterReturnGeneral  formatonomiReturnGeneral =new FormatoNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormatoNomiWithConnection");connexion.begin();
			
			formatonomiReturnGeneral =new FormatoNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			formatonomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<PuntajeNomi> puntajenomisForeignKey=new ArrayList<PuntajeNomi>();
			PuntajeNomiLogic puntajenomiLogic=new PuntajeNomiLogic();
			puntajenomiLogic.setConnexion(this.connexion);
			puntajenomiLogic.getPuntajeNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuntajeNomi.equals("NONE")) {
				puntajenomiLogic.getTodosPuntajeNomis(finalQueryGlobalPuntajeNomi,new Pagination());
				puntajenomisForeignKey=puntajenomiLogic.getPuntajeNomis();
			}

			formatonomiReturnGeneral.setpuntajenomisForeignKey(puntajenomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formatonomiReturnGeneral;
	}
	
	public FormatoNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalPuntajeNomi) throws Exception {
		FormatoNomiParameterReturnGeneral  formatonomiReturnGeneral =new FormatoNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formatonomiReturnGeneral =new FormatoNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			formatonomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<PuntajeNomi> puntajenomisForeignKey=new ArrayList<PuntajeNomi>();
			PuntajeNomiLogic puntajenomiLogic=new PuntajeNomiLogic();
			puntajenomiLogic.setConnexion(this.connexion);
			puntajenomiLogic.getPuntajeNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuntajeNomi.equals("NONE")) {
				puntajenomiLogic.getTodosPuntajeNomis(finalQueryGlobalPuntajeNomi,new Pagination());
				puntajenomisForeignKey=puntajenomiLogic.getPuntajeNomis();
			}

			formatonomiReturnGeneral.setpuntajenomisForeignKey(puntajenomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formatonomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormatoNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic=new FormatoNomiPreguntaNomiLogic();
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic=new FormatoNomiFactorNomiLogic();
			EvaluacionNomiLogic evaluacionnomiLogic=new EvaluacionNomiLogic();
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic=new DetalleEvaluacionNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormatoNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormatoNomiPreguntaNomi.class));
			classes.add(new Classe(FormatoNomiFactorNomi.class));
			classes.add(new Classe(EvaluacionNomi.class));
			classes.add(new Classe(DetalleEvaluacionNomi.class));
											
			

			formatonomipreguntanomiLogic.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic.setDatosCliente(this.datosCliente);
			formatonomipreguntanomiLogic.setIsConRefrescarForeignKeys(true);

			formatonomifactornomiLogic.setConnexion(this.getConnexion());
			formatonomifactornomiLogic.setDatosCliente(this.datosCliente);
			formatonomifactornomiLogic.setIsConRefrescarForeignKeys(true);

			evaluacionnomiLogic.setConnexion(this.getConnexion());
			evaluacionnomiLogic.setDatosCliente(this.datosCliente);
			evaluacionnomiLogic.setIsConRefrescarForeignKeys(true);

			detalleevaluacionnomiLogic.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FormatoNomi formatonomi:this.formatonomis) {
				

				classes=new ArrayList<Classe>();
				classes=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(formatonomi.formatonomipreguntanomis);
				formatonomipreguntanomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormatoNomiFactorNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiFactorNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomifactornomiLogic.setFormatoNomiFactorNomis(formatonomi.formatonomifactornomis);
				formatonomifactornomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EvaluacionNomiConstantesFunciones.getClassesForeignKeysOfEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				evaluacionnomiLogic.setEvaluacionNomis(formatonomi.evaluacionnomis);
				evaluacionnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(formatonomi.detalleevaluacionnomis);
				detalleevaluacionnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FormatoNomi formatonomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormatoNomiLogicAdditional.updateFormatoNomiToGet(formatonomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
		formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
		formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
		formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
		formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));
		formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));
		formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));
		formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
				continue;
			}

			if(clas.clas.equals(PuntajeNomi.class)) {
				formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));

				if(this.isConDeep) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(this.connexion);
					formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(formatonomi.getFormatoNomiPreguntaNomis());
					ArrayList<Classe> classesLocal=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomipreguntanomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
					formatonomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
				}

				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));

				if(this.isConDeep) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(this.connexion);
					formatonomifactornomiLogic.setFormatoNomiFactorNomis(formatonomi.getFormatoNomiFactorNomis());
					ArrayList<Classe> classesLocal=FormatoNomiFactorNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiFactorNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomifactornomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(formatonomifactornomiLogic.getFormatoNomiFactorNomis());
					formatonomi.setFormatoNomiFactorNomis(formatonomifactornomiLogic.getFormatoNomiFactorNomis());
				}

				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));

				if(this.isConDeep) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(this.connexion);
					evaluacionnomiLogic.setEvaluacionNomis(formatonomi.getEvaluacionNomis());
					ArrayList<Classe> classesLocal=EvaluacionNomiConstantesFunciones.getClassesForeignKeysOfEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					evaluacionnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(evaluacionnomiLogic.getEvaluacionNomis());
					formatonomi.setEvaluacionNomis(evaluacionnomiLogic.getEvaluacionNomis());
				}

				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));

				if(this.isConDeep) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(this.connexion);
					detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(formatonomi.getDetalleEvaluacionNomis());
					ArrayList<Classe> classesLocal=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
					formatonomi.setDetalleEvaluacionNomis(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
				}

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
			formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PuntajeNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiFactorNomi.class));
			formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionNomi.class));
			formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionNomi.class));
			formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomi.getSucursal(),isDeep,deepLoadType,clases);
				
		formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(formatonomi.getEstructura(),isDeep,deepLoadType,clases);
				
		formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
		PuntajeNomiLogic puntajenomiLogic= new PuntajeNomiLogic(connexion);
		puntajenomiLogic.deepLoad(formatonomi.getPuntajeNomi(),isDeep,deepLoadType,clases);
				

		formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}

		formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));

		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
			formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
		}

		formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));

		for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
			EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
			evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
		}

		formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));

		for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formatonomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formatonomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(formatonomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PuntajeNomi.class)) {
				formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
				PuntajeNomiLogic puntajenomiLogic= new PuntajeNomiLogic(connexion);
				puntajenomiLogic.deepLoad(formatonomi.getPuntajeNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));

				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
					formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));

				for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
					evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));

				for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
					detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
				}
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
			formatonomi.setEmpresa(formatonomiDataAccess.getEmpresa(connexion,formatonomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formatonomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setSucursal(formatonomiDataAccess.getSucursal(connexion,formatonomi));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formatonomi.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setEstructura(formatonomiDataAccess.getEstructura(connexion,formatonomi));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(formatonomi.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PuntajeNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomi.setPuntajeNomi(formatonomiDataAccess.getPuntajeNomi(connexion,formatonomi));
			PuntajeNomiLogic puntajenomiLogic= new PuntajeNomiLogic(connexion);
			puntajenomiLogic.deepLoad(formatonomi.getPuntajeNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			formatonomi.setFormatoNomiPreguntaNomis(formatonomiDataAccess.getFormatoNomiPreguntaNomis(connexion,formatonomi));

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiFactorNomi.class));
			formatonomi.setFormatoNomiFactorNomis(formatonomiDataAccess.getFormatoNomiFactorNomis(connexion,formatonomi));

			for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
				FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
				formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionNomi.class));
			formatonomi.setEvaluacionNomis(formatonomiDataAccess.getEvaluacionNomis(connexion,formatonomi));

			for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
				EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
				evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionNomi.class));
			formatonomi.setDetalleEvaluacionNomis(formatonomiDataAccess.getDetalleEvaluacionNomis(connexion,formatonomi));

			for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
				DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
				detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormatoNomi formatonomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormatoNomiLogicAdditional.updateFormatoNomiToSave(formatonomi,this.arrDatoGeneral);
			
FormatoNomiDataAccess.save(formatonomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomi.getEmpresa(),connexion);

		SucursalDataAccess.save(formatonomi.getSucursal(),connexion);

		EstructuraDataAccess.save(formatonomi.getEstructura(),connexion);

		PuntajeNomiDataAccess.save(formatonomi.getPuntajeNomi(),connexion);

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
			formatonomipreguntanomi.setid_formato_nomi(formatonomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
		}

		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
			formatonomifactornomi.setid_formato_nomi(formatonomi.getId());
			FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
		}

		for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
			evaluacionnomi.setid_formato_nomi(formatonomi.getId());
			EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
		}

		for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
			detalleevaluacionnomi.setid_formato_nomi(formatonomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomi.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(formatonomi.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(PuntajeNomi.class)) {
				PuntajeNomiDataAccess.save(formatonomi.getPuntajeNomi(),connexion);
				continue;
			}


			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
					formatonomipreguntanomi.setid_formato_nomi(formatonomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
					formatonomifactornomi.setid_formato_nomi(formatonomi.getId());
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
					evaluacionnomi.setid_formato_nomi(formatonomi.getId());
					EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi.setid_formato_nomi(formatonomi.getId());
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formatonomi.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomi.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(formatonomi.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(formatonomi.getEstructura(),isDeep,deepLoadType,clases);
				

		PuntajeNomiDataAccess.save(formatonomi.getPuntajeNomi(),connexion);
		PuntajeNomiLogic puntajenomiLogic= new PuntajeNomiLogic(connexion);
		puntajenomiLogic.deepLoad(formatonomi.getPuntajeNomi(),isDeep,deepLoadType,clases);
				

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomi.setid_formato_nomi(formatonomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
			formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}

		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
			formatonomifactornomi.setid_formato_nomi(formatonomi.getId());
			FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
			formatonomifactornomiLogic.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
		}

		for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
			EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
			evaluacionnomi.setid_formato_nomi(formatonomi.getId());
			EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
			evaluacionnomiLogic.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
		}

		for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomi.setid_formato_nomi(formatonomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
			detalleevaluacionnomiLogic.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formatonomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomi.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formatonomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(formatonomi.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(formatonomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PuntajeNomi.class)) {
				PuntajeNomiDataAccess.save(formatonomi.getPuntajeNomi(),connexion);
				PuntajeNomiLogic puntajenomiLogic= new PuntajeNomiLogic(connexion);
				puntajenomiLogic.deepSave(formatonomi.getPuntajeNomi(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomi.setid_formato_nomi(formatonomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
					formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomi.getFormatoNomiFactorNomis()) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
					formatonomifactornomi.setid_formato_nomi(formatonomi.getId());
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
					formatonomifactornomiLogic.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionNomi evaluacionnomi:formatonomi.getEvaluacionNomis()) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
					evaluacionnomi.setid_formato_nomi(formatonomi.getId());
					EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
					evaluacionnomiLogic.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:formatonomi.getDetalleEvaluacionNomis()) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
					detalleevaluacionnomi.setid_formato_nomi(formatonomi.getId());
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
					detalleevaluacionnomiLogic.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FormatoNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formatonomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(formatonomi);
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
			this.deepLoad(this.formatonomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormatoNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formatonomis!=null) {
				for(FormatoNomi formatonomi:formatonomis) {
					this.deepLoad(formatonomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(formatonomis);
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
			if(formatonomis!=null) {
				for(FormatoNomi formatonomi:formatonomis) {
					this.deepLoad(formatonomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(formatonomis);
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
			this.getNewConnexionToDeep(FormatoNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formatonomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormatoNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formatonomis!=null) {
				for(FormatoNomi formatonomi:formatonomis) {
					this.deepSave(formatonomi,isDeep,deepLoadType,clases);
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
			if(formatonomis!=null) {
				for(FormatoNomi formatonomi:formatonomis) {
					this.deepSave(formatonomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormatoNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomisFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,FormatoNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomisFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,FormatoNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomisFK_IdPuntajeNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_puntaje_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuntajeNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuntajeNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puntaje_nomi,FormatoNomiConstantesFunciones.IDPUNTAJENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuntajeNomi);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuntajeNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomisFK_IdPuntajeNomi(String sFinalQuery,Pagination pagination,Long id_puntaje_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuntajeNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuntajeNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puntaje_nomi,FormatoNomiConstantesFunciones.IDPUNTAJENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuntajeNomi);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuntajeNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(this.formatonomis);
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
			if(FormatoNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormatoNomi formatonomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormatoNomiConstantesFunciones.ISCONAUDITORIA) {
				if(formatonomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiDataAccess.TABLENAME, formatonomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiLogic.registrarAuditoriaDetallesFormatoNomi(connexion,formatonomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formatonomi.getIsDeleted()) {
					/*if(!formatonomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormatoNomiDataAccess.TABLENAME, formatonomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormatoNomiLogic.registrarAuditoriaDetallesFormatoNomi(connexion,formatonomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiDataAccess.TABLENAME, formatonomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formatonomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiDataAccess.TABLENAME, formatonomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiLogic.registrarAuditoriaDetallesFormatoNomi(connexion,formatonomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormatoNomi(Connexion connexion,FormatoNomi formatonomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formatonomi.getIsNew()||!formatonomi.getid_empresa().equals(formatonomi.getFormatoNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getid_empresa().toString();
				}
				if(formatonomi.getid_empresa()!=null)
				{
					strValorNuevo=formatonomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getid_sucursal().equals(formatonomi.getFormatoNomiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getid_sucursal()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getid_sucursal().toString();
				}
				if(formatonomi.getid_sucursal()!=null)
				{
					strValorNuevo=formatonomi.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getcodigo().equals(formatonomi.getFormatoNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getcodigo()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getcodigo();
				}
				if(formatonomi.getcodigo()!=null)
				{
					strValorNuevo=formatonomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getnombre().equals(formatonomi.getFormatoNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getnombre()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getnombre();
				}
				if(formatonomi.getnombre()!=null)
				{
					strValorNuevo=formatonomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getfecha().equals(formatonomi.getFormatoNomiOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getfecha()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getfecha().toString();
				}
				if(formatonomi.getfecha()!=null)
				{
					strValorNuevo=formatonomi.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getinstrucciones().equals(formatonomi.getFormatoNomiOriginal().getinstrucciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getinstrucciones()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getinstrucciones();
				}
				if(formatonomi.getinstrucciones()!=null)
				{
					strValorNuevo=formatonomi.getinstrucciones() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.INSTRUCCIONES,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getid_estructura().equals(formatonomi.getFormatoNomiOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getid_estructura()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getid_estructura().toString();
				}
				if(formatonomi.getid_estructura()!=null)
				{
					strValorNuevo=formatonomi.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(formatonomi.getIsNew()||!formatonomi.getid_puntaje_nomi().equals(formatonomi.getFormatoNomiOriginal().getid_puntaje_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomi.getFormatoNomiOriginal().getid_puntaje_nomi()!=null)
				{
					strValorActual=formatonomi.getFormatoNomiOriginal().getid_puntaje_nomi().toString();
				}
				if(formatonomi.getid_puntaje_nomi()!=null)
				{
					strValorNuevo=formatonomi.getid_puntaje_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiConstantesFunciones.IDPUNTAJENOMI,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormatoNomiRelacionesWithConnection(FormatoNomi formatonomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<FormatoNomiFactorNomi> formatonomifactornomis,List<EvaluacionNomi> evaluacionnomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis) throws Exception {

		if(!formatonomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiRelacionesBase(formatonomi,formatonomipreguntanomis,formatonomifactornomis,evaluacionnomis,detalleevaluacionnomis,true);
		}
	}

	public void saveFormatoNomiRelaciones(FormatoNomi formatonomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<FormatoNomiFactorNomi> formatonomifactornomis,List<EvaluacionNomi> evaluacionnomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {

		if(!formatonomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiRelacionesBase(formatonomi,formatonomipreguntanomis,formatonomifactornomis,evaluacionnomis,detalleevaluacionnomis,false);
		}
	}

	public void saveFormatoNomiRelacionesBase(FormatoNomi formatonomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<FormatoNomiFactorNomi> formatonomifactornomis,List<EvaluacionNomi> evaluacionnomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormatoNomi-saveRelacionesWithConnection");}
	
			formatonomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);
			formatonomi.setFormatoNomiFactorNomis(formatonomifactornomis);
			formatonomi.setEvaluacionNomis(evaluacionnomis);
			formatonomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			this.setFormatoNomi(formatonomi);

			if(FormatoNomiLogicAdditional.validarSaveRelaciones(formatonomi,this)) {

				FormatoNomiLogicAdditional.updateRelacionesToSave(formatonomi,this);

				if((formatonomi.getIsNew()||formatonomi.getIsChanged())&&!formatonomi.getIsDeleted()) {
					this.saveFormatoNomi();
					this.saveFormatoNomiRelacionesDetalles(formatonomipreguntanomis,formatonomifactornomis,evaluacionnomis,detalleevaluacionnomis);

				} else if(formatonomi.getIsDeleted()) {
					this.saveFormatoNomiRelacionesDetalles(formatonomipreguntanomis,formatonomifactornomis,evaluacionnomis,detalleevaluacionnomis);
					this.saveFormatoNomi();
				}

				FormatoNomiLogicAdditional.updateRelacionesToSaveAfter(formatonomi,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormatoNomiPreguntaNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomiPreguntaNomis(formatonomipreguntanomis,true,true);
			FormatoNomiFactorNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomiFactorNomis(formatonomifactornomis,true,true);
			EvaluacionNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresEvaluacionNomis(evaluacionnomis,true,true);
			DetalleEvaluacionNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionNomis(detalleevaluacionnomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFormatoNomiRelacionesDetalles(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<FormatoNomiFactorNomi> formatonomifactornomis,List<EvaluacionNomi> evaluacionnomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {
		try {
	

			Long idFormatoNomiActual=this.getFormatoNomi().getId();

			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic_Desde_FormatoNomi=new FormatoNomiPreguntaNomiLogic();
			formatonomipreguntanomiLogic_Desde_FormatoNomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);

			formatonomipreguntanomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi_Desde_FormatoNomi:formatonomipreguntanomiLogic_Desde_FormatoNomi.getFormatoNomiPreguntaNomis()) {
				formatonomipreguntanomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

				formatonomipreguntanomiLogic_Desde_FormatoNomi.setFormatoNomiPreguntaNomi(formatonomipreguntanomi_Desde_FormatoNomi);
				formatonomipreguntanomiLogic_Desde_FormatoNomi.saveFormatoNomiPreguntaNomi();

				Long idFormatoNomiPreguntaNomiActual=formatonomipreguntanomi_Desde_FormatoNomi.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();

				if(formatonomipreguntanomi_Desde_FormatoNomi.getCalificacionEmpleados()==null){
					formatonomipreguntanomi_Desde_FormatoNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(formatonomipreguntanomi_Desde_FormatoNomi.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
					calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();
			}


			FormatoNomiFactorNomiLogic formatonomifactornomiLogic_Desde_FormatoNomi=new FormatoNomiFactorNomiLogic();
			formatonomifactornomiLogic_Desde_FormatoNomi.setFormatoNomiFactorNomis(formatonomifactornomis);

			formatonomifactornomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
			formatonomifactornomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

			for(FormatoNomiFactorNomi formatonomifactornomi_Desde_FormatoNomi:formatonomifactornomiLogic_Desde_FormatoNomi.getFormatoNomiFactorNomis()) {
				formatonomifactornomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

				formatonomifactornomiLogic_Desde_FormatoNomi.setFormatoNomiFactorNomi(formatonomifactornomi_Desde_FormatoNomi);
				formatonomifactornomiLogic_Desde_FormatoNomi.saveFormatoNomiFactorNomi();

				Long idFormatoNomiFactorNomiActual=formatonomifactornomi_Desde_FormatoNomi.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiFactorNomi=new CalificacionEmpleadoLogic();

				if(formatonomifactornomi_Desde_FormatoNomi.getCalificacionEmpleados()==null){
					formatonomifactornomi_Desde_FormatoNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setCalificacionEmpleados(formatonomifactornomi_Desde_FormatoNomi.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiFactorNomi:calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.getCalificacionEmpleados()) {
					calificacionempleado_Desde_FormatoNomiFactorNomi.setid_formato_nomi_factor_nomi(idFormatoNomiFactorNomiActual);
				}

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.saveCalificacionEmpleados();
			}


			EvaluacionNomiLogic evaluacionnomiLogic_Desde_FormatoNomi=new EvaluacionNomiLogic();
			evaluacionnomiLogic_Desde_FormatoNomi.setEvaluacionNomis(evaluacionnomis);

			evaluacionnomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
			evaluacionnomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

			for(EvaluacionNomi evaluacionnomi_Desde_FormatoNomi:evaluacionnomiLogic_Desde_FormatoNomi.getEvaluacionNomis()) {
				evaluacionnomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

				evaluacionnomiLogic_Desde_FormatoNomi.setEvaluacionNomi(evaluacionnomi_Desde_FormatoNomi);
				evaluacionnomiLogic_Desde_FormatoNomi.saveEvaluacionNomi();

				Long idEvaluacionNomiActual=evaluacionnomi_Desde_FormatoNomi.getId();

				DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_EvaluacionNomi=new DetalleEvaluacionNomiLogic();

				if(evaluacionnomi_Desde_FormatoNomi.getDetalleEvaluacionNomis()==null){
					evaluacionnomi_Desde_FormatoNomi.setDetalleEvaluacionNomis(new ArrayList<DetalleEvaluacionNomi>());
				}

				detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setDetalleEvaluacionNomis(evaluacionnomi_Desde_FormatoNomi.getDetalleEvaluacionNomis());

				detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setConnexion(this.getConnexion());
				detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setDatosCliente(this.datosCliente);

				for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_EvaluacionNomi:detalleevaluacionnomiLogic_Desde_EvaluacionNomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi_Desde_EvaluacionNomi.setid_evaluacion_nomi(idEvaluacionNomiActual);
				}

				detalleevaluacionnomiLogic_Desde_EvaluacionNomi.saveDetalleEvaluacionNomis();
			}


			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_FormatoNomi=new DetalleEvaluacionNomiLogic();
			detalleevaluacionnomiLogic_Desde_FormatoNomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			detalleevaluacionnomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_FormatoNomi:detalleevaluacionnomiLogic_Desde_FormatoNomi.getDetalleEvaluacionNomis()) {
				detalleevaluacionnomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);
			}

			detalleevaluacionnomiLogic_Desde_FormatoNomi.saveDetalleEvaluacionNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
