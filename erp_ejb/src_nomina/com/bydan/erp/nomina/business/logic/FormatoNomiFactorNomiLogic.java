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
import com.bydan.erp.nomina.util.FormatoNomiFactorNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiFactorNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiFactorNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.FormatoNomiFactorNomi;
import com.bydan.erp.nomina.business.logic.FormatoNomiFactorNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormatoNomiFactorNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormatoNomiFactorNomiLogic.class);
	
	protected FormatoNomiFactorNomiDataAccess formatonomifactornomiDataAccess; 	
	protected FormatoNomiFactorNomi formatonomifactornomi;
	protected List<FormatoNomiFactorNomi> formatonomifactornomis;
	protected Object formatonomifactornomiObject;	
	protected List<Object> formatonomifactornomisObject;
	
	public static ClassValidator<FormatoNomiFactorNomi> formatonomifactornomiValidator = new ClassValidator<FormatoNomiFactorNomi>(FormatoNomiFactorNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormatoNomiFactorNomiLogicAdditional formatonomifactornomiLogicAdditional=null;
	
	public FormatoNomiFactorNomiLogicAdditional getFormatoNomiFactorNomiLogicAdditional() {
		return this.formatonomifactornomiLogicAdditional;
	}
	
	public void setFormatoNomiFactorNomiLogicAdditional(FormatoNomiFactorNomiLogicAdditional formatonomifactornomiLogicAdditional) {
		try {
			this.formatonomifactornomiLogicAdditional=formatonomifactornomiLogicAdditional;
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
	
	
	
	
	public  FormatoNomiFactorNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formatonomifactornomiDataAccess = new FormatoNomiFactorNomiDataAccess();
			
			this.formatonomifactornomis= new ArrayList<FormatoNomiFactorNomi>();
			this.formatonomifactornomi= new FormatoNomiFactorNomi();
			
			this.formatonomifactornomiObject=new Object();
			this.formatonomifactornomisObject=new ArrayList<Object>();
				
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
			
			this.formatonomifactornomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomifactornomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormatoNomiFactorNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formatonomifactornomiDataAccess = new FormatoNomiFactorNomiDataAccess();
			this.formatonomifactornomis= new ArrayList<FormatoNomiFactorNomi>();
			this.formatonomifactornomi= new FormatoNomiFactorNomi();
			this.formatonomifactornomiObject=new Object();
			this.formatonomifactornomisObject=new ArrayList<Object>();
			
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
			
			this.formatonomifactornomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomifactornomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormatoNomiFactorNomi getFormatoNomiFactorNomi() throws Exception {	
		FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToGet(formatonomifactornomi,this.datosCliente,this.arrDatoGeneral);
		FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToGet(formatonomifactornomi,this.arrDatoGeneral);
		
		return formatonomifactornomi;
	}
		
	public void setFormatoNomiFactorNomi(FormatoNomiFactorNomi newFormatoNomiFactorNomi) {
		this.formatonomifactornomi = newFormatoNomiFactorNomi;
	}
	
	public FormatoNomiFactorNomiDataAccess getFormatoNomiFactorNomiDataAccess() {
		return formatonomifactornomiDataAccess;
	}
	
	public void setFormatoNomiFactorNomiDataAccess(FormatoNomiFactorNomiDataAccess newformatonomifactornomiDataAccess) {
		this.formatonomifactornomiDataAccess = newformatonomifactornomiDataAccess;
	}
	
	public List<FormatoNomiFactorNomi> getFormatoNomiFactorNomis() throws Exception {		
		this.quitarFormatoNomiFactorNomisNulos();
		
		FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToGets(formatonomifactornomis,this.datosCliente,this.arrDatoGeneral);
		
		for (FormatoNomiFactorNomi formatonomifactornomiLocal: formatonomifactornomis ) {
			FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToGet(formatonomifactornomiLocal,this.arrDatoGeneral);
		}
		
		return formatonomifactornomis;
	}
	
	public void setFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> newFormatoNomiFactorNomis) {
		this.formatonomifactornomis = newFormatoNomiFactorNomis;
	}
	
	public Object getFormatoNomiFactorNomiObject() {	
		this.formatonomifactornomiObject=this.formatonomifactornomiDataAccess.getEntityObject();
		return this.formatonomifactornomiObject;
	}
		
	public void setFormatoNomiFactorNomiObject(Object newFormatoNomiFactorNomiObject) {
		this.formatonomifactornomiObject = newFormatoNomiFactorNomiObject;
	}
	
	public List<Object> getFormatoNomiFactorNomisObject() {		
		this.formatonomifactornomisObject=this.formatonomifactornomiDataAccess.getEntitiesObject();
		return this.formatonomifactornomisObject;
	}
		
	public void setFormatoNomiFactorNomisObject(List<Object> newFormatoNomiFactorNomisObject) {
		this.formatonomifactornomisObject = newFormatoNomiFactorNomisObject;
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
		
		if(this.formatonomifactornomiDataAccess!=null) {
			this.formatonomifactornomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formatonomifactornomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formatonomifactornomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
        try {
			
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
        try {
			
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  		  
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formatonomifactornomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formatonomifactornomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formatonomifactornomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formatonomifactornomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formatonomifactornomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formatonomifactornomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
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
		formatonomifactornomi = new  FormatoNomiFactorNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		  		  
        try {
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormatoNomiFactorNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getTodosFormatoNomiFactorNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
	
	public  void  getTodosFormatoNomiFactorNomis(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomifactornomis = new  ArrayList<FormatoNomiFactorNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomiFactorNomi(formatonomifactornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		Boolean estaValidado=false;
		
		if(formatonomifactornomi.getIsNew() || formatonomifactornomi.getIsChanged()) { 
			this.invalidValues = formatonomifactornomiValidator.getInvalidValues(formatonomifactornomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formatonomifactornomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> FormatoNomiFactorNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormatoNomiFactorNomi formatonomifactornomiLocal:formatonomifactornomis) {				
			estaValidadoObjeto=this.validarGuardarFormatoNomiFactorNomi(formatonomifactornomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> FormatoNomiFactorNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomiFactorNomi(formatonomifactornomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormatoNomiFactorNomi(FormatoNomiFactorNomi FormatoNomiFactorNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomiFactorNomi(formatonomifactornomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formatonomifactornomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormatoNomiFactorNomiConstantesFunciones.getFormatoNomiFactorNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formatonomifactornomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormatoNomiFactorNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormatoNomiFactorNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormatoNomiFactorNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-saveFormatoNomiFactorNomiWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSave(this.formatonomifactornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToSave(this.formatonomifactornomi,this.arrDatoGeneral);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomifactornomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomiFactorNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomiFactorNomi(this.formatonomifactornomi)) {
				FormatoNomiFactorNomiDataAccess.save(this.formatonomifactornomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSaveAfter(this.formatonomifactornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomiFactorNomi();
			
			connexion.commit();			
			
			if(this.formatonomifactornomi.getIsDeleted()) {
				this.formatonomifactornomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormatoNomiFactorNomi()throws Exception {	
		try {	
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSave(this.formatonomifactornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToSave(this.formatonomifactornomi,this.arrDatoGeneral);
			
			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomifactornomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomiFactorNomi(this.formatonomifactornomi)) {			
				FormatoNomiFactorNomiDataAccess.save(this.formatonomifactornomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formatonomifactornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSaveAfter(this.formatonomifactornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formatonomifactornomi.getIsDeleted()) {
				this.formatonomifactornomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormatoNomiFactorNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-saveFormatoNomiFactorNomisWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSaves(formatonomifactornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomiFactorNomis();
			
			Boolean validadoTodosFormatoNomiFactorNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomiFactorNomi formatonomifactornomiLocal:formatonomifactornomis) {		
				if(formatonomifactornomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToSave(formatonomifactornomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomifactornomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomiFactorNomi(formatonomifactornomiLocal)) {
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomiFactorNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomiFactorNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSavesAfter(formatonomifactornomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomiFactorNomis();
			
			connexion.commit();		
			
			this.quitarFormatoNomiFactorNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormatoNomiFactorNomis()throws Exception {				
		 try {	
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSaves(formatonomifactornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormatoNomiFactorNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomiFactorNomi formatonomifactornomiLocal:formatonomifactornomis) {				
				if(formatonomifactornomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToSave(formatonomifactornomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomifactornomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomiFactorNomi(formatonomifactornomiLocal)) {				
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomiFactorNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomiFactorNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiFactorNomiLogicAdditional.checkFormatoNomiFactorNomiToSavesAfter(formatonomifactornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormatoNomiFactorNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral procesarAccionFormatoNomiFactorNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiParameterGeneral)throws Exception {
		 try {	
			FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiReturnGeneral=new FormatoNomiFactorNomiParameterReturnGeneral();
	
			FormatoNomiFactorNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomifactornomis,formatonomifactornomiParameterGeneral,formatonomifactornomiReturnGeneral);
			
			return formatonomifactornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral procesarAccionFormatoNomiFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-procesarAccionFormatoNomiFactorNomisWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiReturnGeneral=new FormatoNomiFactorNomiParameterReturnGeneral();
	
			FormatoNomiFactorNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomifactornomis,formatonomifactornomiParameterGeneral,formatonomifactornomiReturnGeneral);
			
			this.connexion.commit();
			
			return formatonomifactornomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral procesarEventosFormatoNomiFactorNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomi formatonomifactornomi,FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiParameterGeneral,Boolean isEsNuevoFormatoNomiFactorNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiReturnGeneral=new FormatoNomiFactorNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomifactornomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiFactorNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomifactornomis,formatonomifactornomi,formatonomifactornomiParameterGeneral,formatonomifactornomiReturnGeneral,isEsNuevoFormatoNomiFactorNomi,clases);
			
			return formatonomifactornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormatoNomiFactorNomiParameterReturnGeneral procesarEventosFormatoNomiFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomi formatonomifactornomi,FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiParameterGeneral,Boolean isEsNuevoFormatoNomiFactorNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-procesarEventosFormatoNomiFactorNomisWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiReturnGeneral=new FormatoNomiFactorNomiParameterReturnGeneral();
	
			formatonomifactornomiReturnGeneral.setFormatoNomiFactorNomi(formatonomifactornomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomifactornomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiFactorNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomifactornomis,formatonomifactornomi,formatonomifactornomiParameterGeneral,formatonomifactornomiReturnGeneral,isEsNuevoFormatoNomiFactorNomi,clases);
			
			this.connexion.commit();
			
			return formatonomifactornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral procesarImportacionFormatoNomiFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-procesarImportacionFormatoNomiFactorNomisWithConnection");connexion.begin();			
			
			FormatoNomiFactorNomiParameterReturnGeneral formatonomifactornomiReturnGeneral=new FormatoNomiFactorNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formatonomifactornomis=new ArrayList<FormatoNomiFactorNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formatonomifactornomi=new FormatoNomiFactorNomi();
				
				
				if(conColumnasBase) {this.formatonomifactornomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formatonomifactornomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formatonomifactornomi.setponderacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.formatonomifactornomi.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.formatonomifactornomis.add(this.formatonomifactornomi);
			}
			
			this.saveFormatoNomiFactorNomis();
			
			this.connexion.commit();
			
			formatonomifactornomiReturnGeneral.setConRetornoEstaProcesado(true);
			formatonomifactornomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formatonomifactornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormatoNomiFactorNomisEliminados() throws Exception {				
		
		List<FormatoNomiFactorNomi> formatonomifactornomisAux= new ArrayList<FormatoNomiFactorNomi>();
		
		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
			if(!formatonomifactornomi.getIsDeleted()) {
				formatonomifactornomisAux.add(formatonomifactornomi);
			}
		}
		
		formatonomifactornomis=formatonomifactornomisAux;
	}
	
	public void quitarFormatoNomiFactorNomisNulos() throws Exception {				
		
		List<FormatoNomiFactorNomi> formatonomifactornomisAux= new ArrayList<FormatoNomiFactorNomi>();
		
		for(FormatoNomiFactorNomi formatonomifactornomi : this.formatonomifactornomis) {
			if(formatonomifactornomi==null) {
				formatonomifactornomisAux.add(formatonomifactornomi);
			}
		}
		
		//this.formatonomifactornomis=formatonomifactornomisAux;
		
		this.formatonomifactornomis.removeAll(formatonomifactornomisAux);
	}
	
	public void getSetVersionRowFormatoNomiFactorNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formatonomifactornomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formatonomifactornomi.getIsDeleted() || (formatonomifactornomi.getIsChanged()&&!formatonomifactornomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formatonomifactornomiDataAccess.getSetVersionRowFormatoNomiFactorNomi(connexion,formatonomifactornomi.getId());
				
				if(!formatonomifactornomi.getVersionRow().equals(timestamp)) {	
					formatonomifactornomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formatonomifactornomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormatoNomiFactorNomi()throws Exception {	
		
		if(formatonomifactornomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formatonomifactornomi.getIsDeleted() || (formatonomifactornomi.getIsChanged()&&!formatonomifactornomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formatonomifactornomiDataAccess.getSetVersionRowFormatoNomiFactorNomi(connexion,formatonomifactornomi.getId());
			
			try {							
				if(!formatonomifactornomi.getVersionRow().equals(timestamp)) {	
					formatonomifactornomi.setVersionRow(timestamp);
				}
				
				formatonomifactornomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormatoNomiFactorNomisWithConnection()throws Exception {	
		if(formatonomifactornomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormatoNomiFactorNomi formatonomifactornomiAux:formatonomifactornomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formatonomifactornomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomifactornomiAux.getIsDeleted() || (formatonomifactornomiAux.getIsChanged()&&!formatonomifactornomiAux.getIsNew())) {
						
						timestamp=formatonomifactornomiDataAccess.getSetVersionRowFormatoNomiFactorNomi(connexion,formatonomifactornomiAux.getId());
						
						if(!formatonomifactornomi.getVersionRow().equals(timestamp)) {	
							formatonomifactornomiAux.setVersionRow(timestamp);
						}
								
						formatonomifactornomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormatoNomiFactorNomis()throws Exception {	
		if(formatonomifactornomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormatoNomiFactorNomi formatonomifactornomiAux:formatonomifactornomis) {
					if(formatonomifactornomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomifactornomiAux.getIsDeleted() || (formatonomifactornomiAux.getIsChanged()&&!formatonomifactornomiAux.getIsNew())) {
						
						timestamp=formatonomifactornomiDataAccess.getSetVersionRowFormatoNomiFactorNomi(connexion,formatonomifactornomiAux.getId());
						
						if(!formatonomifactornomiAux.getVersionRow().equals(timestamp)) {	
							formatonomifactornomiAux.setVersionRow(timestamp);
						}
						
													
						formatonomifactornomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomiFactorNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormatoNomi,String finalQueryGlobalFactorNomi) throws Exception {
		FormatoNomiFactorNomiParameterReturnGeneral  formatonomifactornomiReturnGeneral =new FormatoNomiFactorNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormatoNomiFactorNomiWithConnection");connexion.begin();
			
			formatonomifactornomiReturnGeneral =new FormatoNomiFactorNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomifactornomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomifactornomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			formatonomifactornomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			formatonomifactornomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formatonomifactornomiReturnGeneral;
	}
	
	public FormatoNomiFactorNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomiFactorNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormatoNomi,String finalQueryGlobalFactorNomi) throws Exception {
		FormatoNomiFactorNomiParameterReturnGeneral  formatonomifactornomiReturnGeneral =new FormatoNomiFactorNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formatonomifactornomiReturnGeneral =new FormatoNomiFactorNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomifactornomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomifactornomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			formatonomifactornomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			formatonomifactornomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formatonomifactornomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormatoNomiFactorNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CalificacionEmpleadoLogic calificacionempleadoLogic=new CalificacionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormatoNomiFactorNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CalificacionEmpleado.class));
											
			

			calificacionempleadoLogic.setConnexion(this.getConnexion());
			calificacionempleadoLogic.setDatosCliente(this.datosCliente);
			calificacionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FormatoNomiFactorNomi formatonomifactornomi:this.formatonomifactornomis) {
				

				classes=new ArrayList<Classe>();
				classes=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				calificacionempleadoLogic.setCalificacionEmpleados(formatonomifactornomi.calificacionempleados);
				calificacionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FormatoNomiFactorNomi formatonomifactornomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToGet(formatonomifactornomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
		formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
		formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
		formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
		formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));

				if(this.isConDeep) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(this.connexion);
					calificacionempleadoLogic.setCalificacionEmpleados(formatonomifactornomi.getCalificacionEmpleados());
					ArrayList<Classe> classesLocal=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					calificacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleadoLogic.getCalificacionEmpleados());
					formatonomifactornomi.setCalificacionEmpleados(calificacionempleadoLogic.getCalificacionEmpleados());
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
			formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomifactornomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomifactornomi.getSucursal(),isDeep,deepLoadType,clases);
				
		formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(formatonomifactornomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(formatonomifactornomi.getFactorNomi(),isDeep,deepLoadType,clases);
				

		formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));

		for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formatonomifactornomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formatonomifactornomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(formatonomifactornomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepLoad(formatonomifactornomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));

				for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
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
			formatonomifactornomi.setEmpresa(formatonomifactornomiDataAccess.getEmpresa(connexion,formatonomifactornomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formatonomifactornomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setSucursal(formatonomifactornomiDataAccess.getSucursal(connexion,formatonomifactornomi));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formatonomifactornomi.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setFormatoNomi(formatonomifactornomiDataAccess.getFormatoNomi(connexion,formatonomifactornomi));
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(formatonomifactornomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomifactornomi.setFactorNomi(formatonomifactornomiDataAccess.getFactorNomi(connexion,formatonomifactornomi));
			FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
			factornomiLogic.deepLoad(formatonomifactornomi.getFactorNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			formatonomifactornomi.setCalificacionEmpleados(formatonomifactornomiDataAccess.getCalificacionEmpleados(connexion,formatonomifactornomi));

			for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
				CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
				calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormatoNomiFactorNomi formatonomifactornomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormatoNomiFactorNomiLogicAdditional.updateFormatoNomiFactorNomiToSave(formatonomifactornomi,this.arrDatoGeneral);
			
FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomifactornomi.getEmpresa(),connexion);

		SucursalDataAccess.save(formatonomifactornomi.getSucursal(),connexion);

		FormatoNomiDataAccess.save(formatonomifactornomi.getFormatoNomi(),connexion);

		FactorNomiDataAccess.save(formatonomifactornomi.getFactorNomi(),connexion);

		for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
			calificacionempleado.setid_formato_nomi_factor_nomi(formatonomifactornomi.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomifactornomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomifactornomi.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(formatonomifactornomi.getFormatoNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(formatonomifactornomi.getFactorNomi(),connexion);
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
					calificacionempleado.setid_formato_nomi_factor_nomi(formatonomifactornomi.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomifactornomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomifactornomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formatonomifactornomi.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomifactornomi.getSucursal(),isDeep,deepLoadType,clases);
				

		FormatoNomiDataAccess.save(formatonomifactornomi.getFormatoNomi(),connexion);
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(formatonomifactornomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				

		FactorNomiDataAccess.save(formatonomifactornomi.getFactorNomi(),connexion);
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(formatonomifactornomi.getFactorNomi(),isDeep,deepLoadType,clases);
				

		for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleado.setid_formato_nomi_factor_nomi(formatonomifactornomi.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
			calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomifactornomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formatonomifactornomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomifactornomi.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formatonomifactornomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(formatonomifactornomi.getFormatoNomi(),connexion);
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepSave(formatonomifactornomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(formatonomifactornomi.getFactorNomi(),connexion);
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepSave(formatonomifactornomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:formatonomifactornomi.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleado.setid_formato_nomi_factor_nomi(formatonomifactornomi.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
					calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FormatoNomiFactorNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(formatonomifactornomi);
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
			this.deepLoad(this.formatonomifactornomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormatoNomiFactorNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formatonomifactornomis!=null) {
				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
					this.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(formatonomifactornomis);
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
			if(formatonomifactornomis!=null) {
				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
					this.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(formatonomifactornomis);
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
			this.getNewConnexionToDeep(FormatoNomiFactorNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormatoNomiFactorNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formatonomifactornomis!=null) {
				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
					this.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
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
			if(formatonomifactornomis!=null) {
				for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
					this.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormatoNomiFactorNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiFactorNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiFactorNomisFK_IdFactorNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiFactorNomisFK_IdFactorNomi(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiFactorNomisFK_IdFormatoNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiFactorNomisFK_IdFormatoNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiFactorNomisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiFactorNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiFactorNomisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiFactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomifactornomis=formatonomifactornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(this.formatonomifactornomis);
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
			if(FormatoNomiFactorNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiFactorNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormatoNomiFactorNomi formatonomifactornomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormatoNomiFactorNomiConstantesFunciones.ISCONAUDITORIA) {
				if(formatonomifactornomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiFactorNomiDataAccess.TABLENAME, formatonomifactornomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiFactorNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiFactorNomiLogic.registrarAuditoriaDetallesFormatoNomiFactorNomi(connexion,formatonomifactornomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formatonomifactornomi.getIsDeleted()) {
					/*if(!formatonomifactornomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormatoNomiFactorNomiDataAccess.TABLENAME, formatonomifactornomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormatoNomiFactorNomiLogic.registrarAuditoriaDetallesFormatoNomiFactorNomi(connexion,formatonomifactornomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiFactorNomiDataAccess.TABLENAME, formatonomifactornomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formatonomifactornomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiFactorNomiDataAccess.TABLENAME, formatonomifactornomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiFactorNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiFactorNomiLogic.registrarAuditoriaDetallesFormatoNomiFactorNomi(connexion,formatonomifactornomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormatoNomiFactorNomi(Connexion connexion,FormatoNomiFactorNomi formatonomifactornomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getid_empresa().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_empresa().toString();
				}
				if(formatonomifactornomi.getid_empresa()!=null)
				{
					strValorNuevo=formatonomifactornomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getid_sucursal().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_sucursal()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_sucursal().toString();
				}
				if(formatonomifactornomi.getid_sucursal()!=null)
				{
					strValorNuevo=formatonomifactornomi.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getid_formato_nomi().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_formato_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_formato_nomi()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_formato_nomi().toString();
				}
				if(formatonomifactornomi.getid_formato_nomi()!=null)
				{
					strValorNuevo=formatonomifactornomi.getid_formato_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI,strValorActual,strValorNuevo);
			}	
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getid_factor_nomi().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_factor_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_factor_nomi()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getid_factor_nomi().toString();
				}
				if(formatonomifactornomi.getid_factor_nomi()!=null)
				{
					strValorNuevo=formatonomifactornomi.getid_factor_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI,strValorActual,strValorNuevo);
			}	
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getponderacion().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getponderacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getponderacion()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getponderacion().toString();
				}
				if(formatonomifactornomi.getponderacion()!=null)
				{
					strValorNuevo=formatonomifactornomi.getponderacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.PONDERACION,strValorActual,strValorNuevo);
			}	
			
			if(formatonomifactornomi.getIsNew()||!formatonomifactornomi.getesta_activo().equals(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getesta_activo()!=null)
				{
					strValorActual=formatonomifactornomi.getFormatoNomiFactorNomiOriginal().getesta_activo().toString();
				}
				if(formatonomifactornomi.getesta_activo()!=null)
				{
					strValorNuevo=formatonomifactornomi.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormatoNomiFactorNomiRelacionesWithConnection(FormatoNomiFactorNomi formatonomifactornomi,List<CalificacionEmpleado> calificacionempleados) throws Exception {

		if(!formatonomifactornomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiFactorNomiRelacionesBase(formatonomifactornomi,calificacionempleados,true);
		}
	}

	public void saveFormatoNomiFactorNomiRelaciones(FormatoNomiFactorNomi formatonomifactornomi,List<CalificacionEmpleado> calificacionempleados)throws Exception {

		if(!formatonomifactornomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiFactorNomiRelacionesBase(formatonomifactornomi,calificacionempleados,false);
		}
	}

	public void saveFormatoNomiFactorNomiRelacionesBase(FormatoNomiFactorNomi formatonomifactornomi,List<CalificacionEmpleado> calificacionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormatoNomiFactorNomi-saveRelacionesWithConnection");}
	
			formatonomifactornomi.setCalificacionEmpleados(calificacionempleados);

			this.setFormatoNomiFactorNomi(formatonomifactornomi);

			if(FormatoNomiFactorNomiLogicAdditional.validarSaveRelaciones(formatonomifactornomi,this)) {

				FormatoNomiFactorNomiLogicAdditional.updateRelacionesToSave(formatonomifactornomi,this);

				if((formatonomifactornomi.getIsNew()||formatonomifactornomi.getIsChanged())&&!formatonomifactornomi.getIsDeleted()) {
					this.saveFormatoNomiFactorNomi();
					this.saveFormatoNomiFactorNomiRelacionesDetalles(calificacionempleados);

				} else if(formatonomifactornomi.getIsDeleted()) {
					this.saveFormatoNomiFactorNomiRelacionesDetalles(calificacionempleados);
					this.saveFormatoNomiFactorNomi();
				}

				FormatoNomiFactorNomiLogicAdditional.updateRelacionesToSaveAfter(formatonomifactornomi,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CalificacionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresCalificacionEmpleados(calificacionempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFormatoNomiFactorNomiRelacionesDetalles(List<CalificacionEmpleado> calificacionempleados)throws Exception {
		try {
	

			Long idFormatoNomiFactorNomiActual=this.getFormatoNomiFactorNomi().getId();

			CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiFactorNomi=new CalificacionEmpleadoLogic();
			calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setCalificacionEmpleados(calificacionempleados);

			calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setConnexion(this.getConnexion());
			calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setDatosCliente(this.datosCliente);

			for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiFactorNomi:calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.getCalificacionEmpleados()) {
				calificacionempleado_Desde_FormatoNomiFactorNomi.setid_formato_nomi_factor_nomi(idFormatoNomiFactorNomiActual);
			}

			calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.saveCalificacionEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomiFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiFactorNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiFactorNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiFactorNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomiFactorNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
