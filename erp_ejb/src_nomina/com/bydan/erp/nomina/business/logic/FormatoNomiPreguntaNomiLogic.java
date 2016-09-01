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
import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.FormatoNomiPreguntaNomi;
import com.bydan.erp.nomina.business.logic.FormatoNomiPreguntaNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormatoNomiPreguntaNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormatoNomiPreguntaNomiLogic.class);
	
	protected FormatoNomiPreguntaNomiDataAccess formatonomipreguntanomiDataAccess; 	
	protected FormatoNomiPreguntaNomi formatonomipreguntanomi;
	protected List<FormatoNomiPreguntaNomi> formatonomipreguntanomis;
	protected Object formatonomipreguntanomiObject;	
	protected List<Object> formatonomipreguntanomisObject;
	
	public static ClassValidator<FormatoNomiPreguntaNomi> formatonomipreguntanomiValidator = new ClassValidator<FormatoNomiPreguntaNomi>(FormatoNomiPreguntaNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormatoNomiPreguntaNomiLogicAdditional formatonomipreguntanomiLogicAdditional=null;
	
	public FormatoNomiPreguntaNomiLogicAdditional getFormatoNomiPreguntaNomiLogicAdditional() {
		return this.formatonomipreguntanomiLogicAdditional;
	}
	
	public void setFormatoNomiPreguntaNomiLogicAdditional(FormatoNomiPreguntaNomiLogicAdditional formatonomipreguntanomiLogicAdditional) {
		try {
			this.formatonomipreguntanomiLogicAdditional=formatonomipreguntanomiLogicAdditional;
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
	
	
	
	
	public  FormatoNomiPreguntaNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formatonomipreguntanomiDataAccess = new FormatoNomiPreguntaNomiDataAccess();
			
			this.formatonomipreguntanomis= new ArrayList<FormatoNomiPreguntaNomi>();
			this.formatonomipreguntanomi= new FormatoNomiPreguntaNomi();
			
			this.formatonomipreguntanomiObject=new Object();
			this.formatonomipreguntanomisObject=new ArrayList<Object>();
				
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
			
			this.formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormatoNomiPreguntaNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formatonomipreguntanomiDataAccess = new FormatoNomiPreguntaNomiDataAccess();
			this.formatonomipreguntanomis= new ArrayList<FormatoNomiPreguntaNomi>();
			this.formatonomipreguntanomi= new FormatoNomiPreguntaNomi();
			this.formatonomipreguntanomiObject=new Object();
			this.formatonomipreguntanomisObject=new ArrayList<Object>();
			
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
			
			this.formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			this.formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi() throws Exception {	
		FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToGet(formatonomipreguntanomi,this.datosCliente,this.arrDatoGeneral);
		FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToGet(formatonomipreguntanomi,this.arrDatoGeneral);
		
		return formatonomipreguntanomi;
	}
		
	public void setFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi newFormatoNomiPreguntaNomi) {
		this.formatonomipreguntanomi = newFormatoNomiPreguntaNomi;
	}
	
	public FormatoNomiPreguntaNomiDataAccess getFormatoNomiPreguntaNomiDataAccess() {
		return formatonomipreguntanomiDataAccess;
	}
	
	public void setFormatoNomiPreguntaNomiDataAccess(FormatoNomiPreguntaNomiDataAccess newformatonomipreguntanomiDataAccess) {
		this.formatonomipreguntanomiDataAccess = newformatonomipreguntanomiDataAccess;
	}
	
	public List<FormatoNomiPreguntaNomi> getFormatoNomiPreguntaNomis() throws Exception {		
		this.quitarFormatoNomiPreguntaNomisNulos();
		
		FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToGets(formatonomipreguntanomis,this.datosCliente,this.arrDatoGeneral);
		
		for (FormatoNomiPreguntaNomi formatonomipreguntanomiLocal: formatonomipreguntanomis ) {
			FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToGet(formatonomipreguntanomiLocal,this.arrDatoGeneral);
		}
		
		return formatonomipreguntanomis;
	}
	
	public void setFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> newFormatoNomiPreguntaNomis) {
		this.formatonomipreguntanomis = newFormatoNomiPreguntaNomis;
	}
	
	public Object getFormatoNomiPreguntaNomiObject() {	
		this.formatonomipreguntanomiObject=this.formatonomipreguntanomiDataAccess.getEntityObject();
		return this.formatonomipreguntanomiObject;
	}
		
	public void setFormatoNomiPreguntaNomiObject(Object newFormatoNomiPreguntaNomiObject) {
		this.formatonomipreguntanomiObject = newFormatoNomiPreguntaNomiObject;
	}
	
	public List<Object> getFormatoNomiPreguntaNomisObject() {		
		this.formatonomipreguntanomisObject=this.formatonomipreguntanomiDataAccess.getEntitiesObject();
		return this.formatonomipreguntanomisObject;
	}
		
	public void setFormatoNomiPreguntaNomisObject(List<Object> newFormatoNomiPreguntaNomisObject) {
		this.formatonomipreguntanomisObject = newFormatoNomiPreguntaNomisObject;
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
		
		if(this.formatonomipreguntanomiDataAccess!=null) {
			this.formatonomipreguntanomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formatonomipreguntanomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formatonomipreguntanomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
        try {
			
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
        try {
			
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  		  
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formatonomipreguntanomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formatonomipreguntanomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formatonomipreguntanomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formatonomipreguntanomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formatonomipreguntanomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formatonomipreguntanomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
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
		formatonomipreguntanomi = new  FormatoNomiPreguntaNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		  		  
        try {
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormatoNomiPreguntaNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getTodosFormatoNomiPreguntaNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
	
	public  void  getTodosFormatoNomiPreguntaNomis(String sFinalQuery,Pagination pagination)throws Exception {
		formatonomipreguntanomis = new  ArrayList<FormatoNomiPreguntaNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoNomiPreguntaNomi(formatonomipreguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi) throws Exception {
		Boolean estaValidado=false;
		
		if(formatonomipreguntanomi.getIsNew() || formatonomipreguntanomi.getIsChanged()) { 
			this.invalidValues = formatonomipreguntanomiValidator.getInvalidValues(formatonomipreguntanomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formatonomipreguntanomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> FormatoNomiPreguntaNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomiLocal:formatonomipreguntanomis) {				
			estaValidadoObjeto=this.validarGuardarFormatoNomiPreguntaNomi(formatonomipreguntanomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> FormatoNomiPreguntaNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomiPreguntaNomi(formatonomipreguntanomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi FormatoNomiPreguntaNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoNomiPreguntaNomi(formatonomipreguntanomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormatoNomiPreguntaNomi formatonomipreguntanomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formatonomipreguntanomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formatonomipreguntanomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormatoNomiPreguntaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormatoNomiPreguntaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormatoNomiPreguntaNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-saveFormatoNomiPreguntaNomiWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSave(this.formatonomipreguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToSave(this.formatonomipreguntanomi,this.arrDatoGeneral);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomipreguntanomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomiPreguntaNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomiPreguntaNomi(this.formatonomipreguntanomi)) {
				FormatoNomiPreguntaNomiDataAccess.save(this.formatonomipreguntanomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSaveAfter(this.formatonomipreguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomiPreguntaNomi();
			
			connexion.commit();			
			
			if(this.formatonomipreguntanomi.getIsDeleted()) {
				this.formatonomipreguntanomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormatoNomiPreguntaNomi()throws Exception {	
		try {	
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSave(this.formatonomipreguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToSave(this.formatonomipreguntanomi,this.arrDatoGeneral);
			
			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatonomipreguntanomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoNomiPreguntaNomi(this.formatonomipreguntanomi)) {			
				FormatoNomiPreguntaNomiDataAccess.save(this.formatonomipreguntanomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formatonomipreguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSaveAfter(this.formatonomipreguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formatonomipreguntanomi.getIsDeleted()) {
				this.formatonomipreguntanomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormatoNomiPreguntaNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-saveFormatoNomiPreguntaNomisWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSaves(formatonomipreguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormatoNomiPreguntaNomis();
			
			Boolean validadoTodosFormatoNomiPreguntaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomiPreguntaNomi formatonomipreguntanomiLocal:formatonomipreguntanomis) {		
				if(formatonomipreguntanomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToSave(formatonomipreguntanomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomipreguntanomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomiPreguntaNomi(formatonomipreguntanomiLocal)) {
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomiPreguntaNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomiPreguntaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSavesAfter(formatonomipreguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoNomiPreguntaNomis();
			
			connexion.commit();		
			
			this.quitarFormatoNomiPreguntaNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormatoNomiPreguntaNomis()throws Exception {				
		 try {	
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSaves(formatonomipreguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormatoNomiPreguntaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoNomiPreguntaNomi formatonomipreguntanomiLocal:formatonomipreguntanomis) {				
				if(formatonomipreguntanomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToSave(formatonomipreguntanomiLocal,this.arrDatoGeneral);
	        	
				FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatonomipreguntanomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoNomiPreguntaNomi(formatonomipreguntanomiLocal)) {				
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomiLocal, connexion);				
				} else {
					validadoTodosFormatoNomiPreguntaNomi=false;
				}
			}
			
			if(!validadoTodosFormatoNomiPreguntaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.checkFormatoNomiPreguntaNomiToSavesAfter(formatonomipreguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormatoNomiPreguntaNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral procesarAccionFormatoNomiPreguntaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiParameterGeneral)throws Exception {
		 try {	
			FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiReturnGeneral=new FormatoNomiPreguntaNomiParameterReturnGeneral();
	
			FormatoNomiPreguntaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomipreguntanomis,formatonomipreguntanomiParameterGeneral,formatonomipreguntanomiReturnGeneral);
			
			return formatonomipreguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral procesarAccionFormatoNomiPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-procesarAccionFormatoNomiPreguntaNomisWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiReturnGeneral=new FormatoNomiPreguntaNomiParameterReturnGeneral();
	
			FormatoNomiPreguntaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatonomipreguntanomis,formatonomipreguntanomiParameterGeneral,formatonomipreguntanomiReturnGeneral);
			
			this.connexion.commit();
			
			return formatonomipreguntanomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral procesarEventosFormatoNomiPreguntaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomi formatonomipreguntanomi,FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiParameterGeneral,Boolean isEsNuevoFormatoNomiPreguntaNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiReturnGeneral=new FormatoNomiPreguntaNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomipreguntanomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomipreguntanomis,formatonomipreguntanomi,formatonomipreguntanomiParameterGeneral,formatonomipreguntanomiReturnGeneral,isEsNuevoFormatoNomiPreguntaNomi,clases);
			
			return formatonomipreguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormatoNomiPreguntaNomiParameterReturnGeneral procesarEventosFormatoNomiPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomi formatonomipreguntanomi,FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiParameterGeneral,Boolean isEsNuevoFormatoNomiPreguntaNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-procesarEventosFormatoNomiPreguntaNomisWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiReturnGeneral=new FormatoNomiPreguntaNomiParameterReturnGeneral();
	
			formatonomipreguntanomiReturnGeneral.setFormatoNomiPreguntaNomi(formatonomipreguntanomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatonomipreguntanomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoNomiPreguntaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatonomipreguntanomis,formatonomipreguntanomi,formatonomipreguntanomiParameterGeneral,formatonomipreguntanomiReturnGeneral,isEsNuevoFormatoNomiPreguntaNomi,clases);
			
			this.connexion.commit();
			
			return formatonomipreguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral procesarImportacionFormatoNomiPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-procesarImportacionFormatoNomiPreguntaNomisWithConnection");connexion.begin();			
			
			FormatoNomiPreguntaNomiParameterReturnGeneral formatonomipreguntanomiReturnGeneral=new FormatoNomiPreguntaNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formatonomipreguntanomis=new ArrayList<FormatoNomiPreguntaNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formatonomipreguntanomi=new FormatoNomiPreguntaNomi();
				
				
				if(conColumnasBase) {this.formatonomipreguntanomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formatonomipreguntanomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formatonomipreguntanomi.setponderacion(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.formatonomipreguntanomis.add(this.formatonomipreguntanomi);
			}
			
			this.saveFormatoNomiPreguntaNomis();
			
			this.connexion.commit();
			
			formatonomipreguntanomiReturnGeneral.setConRetornoEstaProcesado(true);
			formatonomipreguntanomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formatonomipreguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormatoNomiPreguntaNomisEliminados() throws Exception {				
		
		List<FormatoNomiPreguntaNomi> formatonomipreguntanomisAux= new ArrayList<FormatoNomiPreguntaNomi>();
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
			if(!formatonomipreguntanomi.getIsDeleted()) {
				formatonomipreguntanomisAux.add(formatonomipreguntanomi);
			}
		}
		
		formatonomipreguntanomis=formatonomipreguntanomisAux;
	}
	
	public void quitarFormatoNomiPreguntaNomisNulos() throws Exception {				
		
		List<FormatoNomiPreguntaNomi> formatonomipreguntanomisAux= new ArrayList<FormatoNomiPreguntaNomi>();
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi : this.formatonomipreguntanomis) {
			if(formatonomipreguntanomi==null) {
				formatonomipreguntanomisAux.add(formatonomipreguntanomi);
			}
		}
		
		//this.formatonomipreguntanomis=formatonomipreguntanomisAux;
		
		this.formatonomipreguntanomis.removeAll(formatonomipreguntanomisAux);
	}
	
	public void getSetVersionRowFormatoNomiPreguntaNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formatonomipreguntanomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formatonomipreguntanomi.getIsDeleted() || (formatonomipreguntanomi.getIsChanged()&&!formatonomipreguntanomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formatonomipreguntanomiDataAccess.getSetVersionRowFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomi.getId());
				
				if(!formatonomipreguntanomi.getVersionRow().equals(timestamp)) {	
					formatonomipreguntanomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formatonomipreguntanomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormatoNomiPreguntaNomi()throws Exception {	
		
		if(formatonomipreguntanomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formatonomipreguntanomi.getIsDeleted() || (formatonomipreguntanomi.getIsChanged()&&!formatonomipreguntanomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formatonomipreguntanomiDataAccess.getSetVersionRowFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomi.getId());
			
			try {							
				if(!formatonomipreguntanomi.getVersionRow().equals(timestamp)) {	
					formatonomipreguntanomi.setVersionRow(timestamp);
				}
				
				formatonomipreguntanomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormatoNomiPreguntaNomisWithConnection()throws Exception {	
		if(formatonomipreguntanomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormatoNomiPreguntaNomi formatonomipreguntanomiAux:formatonomipreguntanomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formatonomipreguntanomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomipreguntanomiAux.getIsDeleted() || (formatonomipreguntanomiAux.getIsChanged()&&!formatonomipreguntanomiAux.getIsNew())) {
						
						timestamp=formatonomipreguntanomiDataAccess.getSetVersionRowFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomiAux.getId());
						
						if(!formatonomipreguntanomi.getVersionRow().equals(timestamp)) {	
							formatonomipreguntanomiAux.setVersionRow(timestamp);
						}
								
						formatonomipreguntanomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormatoNomiPreguntaNomis()throws Exception {	
		if(formatonomipreguntanomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormatoNomiPreguntaNomi formatonomipreguntanomiAux:formatonomipreguntanomis) {
					if(formatonomipreguntanomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatonomipreguntanomiAux.getIsDeleted() || (formatonomipreguntanomiAux.getIsChanged()&&!formatonomipreguntanomiAux.getIsNew())) {
						
						timestamp=formatonomipreguntanomiDataAccess.getSetVersionRowFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomiAux.getId());
						
						if(!formatonomipreguntanomiAux.getVersionRow().equals(timestamp)) {	
							formatonomipreguntanomiAux.setVersionRow(timestamp);
						}
						
													
						formatonomipreguntanomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomiPreguntaNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormatoNomi,String finalQueryGlobalFactorNomi,String finalQueryGlobalPreguntaNomi) throws Exception {
		FormatoNomiPreguntaNomiParameterReturnGeneral  formatonomipreguntanomiReturnGeneral =new FormatoNomiPreguntaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormatoNomiPreguntaNomiWithConnection");connexion.begin();
			
			formatonomipreguntanomiReturnGeneral =new FormatoNomiPreguntaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomipreguntanomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomipreguntanomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			formatonomipreguntanomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			formatonomipreguntanomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);


			List<PreguntaNomi> preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
			PreguntaNomiLogic preguntanomiLogic=new PreguntaNomiLogic();
			preguntanomiLogic.setConnexion(this.connexion);
			preguntanomiLogic.getPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaNomi.equals("NONE")) {
				preguntanomiLogic.getTodosPreguntaNomis(finalQueryGlobalPreguntaNomi,new Pagination());
				preguntanomisForeignKey=preguntanomiLogic.getPreguntaNomis();
			}

			formatonomipreguntanomiReturnGeneral.setpreguntanomisForeignKey(preguntanomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formatonomipreguntanomiReturnGeneral;
	}
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral cargarCombosLoteForeignKeyFormatoNomiPreguntaNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormatoNomi,String finalQueryGlobalFactorNomi,String finalQueryGlobalPreguntaNomi) throws Exception {
		FormatoNomiPreguntaNomiParameterReturnGeneral  formatonomipreguntanomiReturnGeneral =new FormatoNomiPreguntaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formatonomipreguntanomiReturnGeneral =new FormatoNomiPreguntaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatonomipreguntanomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formatonomipreguntanomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			formatonomipreguntanomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			formatonomipreguntanomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);


			List<PreguntaNomi> preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
			PreguntaNomiLogic preguntanomiLogic=new PreguntaNomiLogic();
			preguntanomiLogic.setConnexion(this.connexion);
			preguntanomiLogic.getPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaNomi.equals("NONE")) {
				preguntanomiLogic.getTodosPreguntaNomis(finalQueryGlobalPreguntaNomi,new Pagination());
				preguntanomisForeignKey=preguntanomiLogic.getPreguntaNomis();
			}

			formatonomipreguntanomiReturnGeneral.setpreguntanomisForeignKey(preguntanomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formatonomipreguntanomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormatoNomiPreguntaNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CalificacionEmpleadoLogic calificacionempleadoLogic=new CalificacionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormatoNomiPreguntaNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CalificacionEmpleado.class));
											
			

			calificacionempleadoLogic.setConnexion(this.getConnexion());
			calificacionempleadoLogic.setDatosCliente(this.datosCliente);
			calificacionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FormatoNomiPreguntaNomi formatonomipreguntanomi:this.formatonomipreguntanomis) {
				

				classes=new ArrayList<Classe>();
				classes=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				calificacionempleadoLogic.setCalificacionEmpleados(formatonomipreguntanomi.calificacionempleados);
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
	
	public void deepLoad(FormatoNomiPreguntaNomi formatonomipreguntanomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToGet(formatonomipreguntanomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
		formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
		formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
		formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
		formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
		formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));

				if(this.isConDeep) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(this.connexion);
					calificacionempleadoLogic.setCalificacionEmpleados(formatonomipreguntanomi.getCalificacionEmpleados());
					ArrayList<Classe> classesLocal=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					calificacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleadoLogic.getCalificacionEmpleados());
					formatonomipreguntanomi.setCalificacionEmpleados(calificacionempleadoLogic.getCalificacionEmpleados());
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
			formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
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
			formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomipreguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomipreguntanomi.getSucursal(),isDeep,deepLoadType,clases);
				
		formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(formatonomipreguntanomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(formatonomipreguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				
		formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
		PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
		preguntanomiLogic.deepLoad(formatonomipreguntanomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				

		formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));

		for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formatonomipreguntanomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formatonomipreguntanomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(formatonomipreguntanomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepLoad(formatonomipreguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
				PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
				preguntanomiLogic.deepLoad(formatonomipreguntanomi.getPreguntaNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));

				for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
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
			formatonomipreguntanomi.setEmpresa(formatonomipreguntanomiDataAccess.getEmpresa(connexion,formatonomipreguntanomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formatonomipreguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setSucursal(formatonomipreguntanomiDataAccess.getSucursal(connexion,formatonomipreguntanomi));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formatonomipreguntanomi.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setFormatoNomi(formatonomipreguntanomiDataAccess.getFormatoNomi(connexion,formatonomipreguntanomi));
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(formatonomipreguntanomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setFactorNomi(formatonomipreguntanomiDataAccess.getFactorNomi(connexion,formatonomipreguntanomi));
			FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
			factornomiLogic.deepLoad(formatonomipreguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatonomipreguntanomi.setPreguntaNomi(formatonomipreguntanomiDataAccess.getPreguntaNomi(connexion,formatonomipreguntanomi));
			PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
			preguntanomiLogic.deepLoad(formatonomipreguntanomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				
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
			formatonomipreguntanomi.setCalificacionEmpleados(formatonomipreguntanomiDataAccess.getCalificacionEmpleados(connexion,formatonomipreguntanomi));

			for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
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
	
	public void deepSave(FormatoNomiPreguntaNomi formatonomipreguntanomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormatoNomiPreguntaNomiLogicAdditional.updateFormatoNomiPreguntaNomiToSave(formatonomipreguntanomi,this.arrDatoGeneral);
			
FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomipreguntanomi.getEmpresa(),connexion);

		SucursalDataAccess.save(formatonomipreguntanomi.getSucursal(),connexion);

		FormatoNomiDataAccess.save(formatonomipreguntanomi.getFormatoNomi(),connexion);

		FactorNomiDataAccess.save(formatonomipreguntanomi.getFactorNomi(),connexion);

		PreguntaNomiDataAccess.save(formatonomipreguntanomi.getPreguntaNomi(),connexion);

		for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
			calificacionempleado.setid_formato_nomi_pregunta_nomi(formatonomipreguntanomi.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomipreguntanomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomipreguntanomi.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(formatonomipreguntanomi.getFormatoNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(formatonomipreguntanomi.getFactorNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				PreguntaNomiDataAccess.save(formatonomipreguntanomi.getPreguntaNomi(),connexion);
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
					calificacionempleado.setid_formato_nomi_pregunta_nomi(formatonomipreguntanomi.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatonomipreguntanomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatonomipreguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formatonomipreguntanomi.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formatonomipreguntanomi.getSucursal(),isDeep,deepLoadType,clases);
				

		FormatoNomiDataAccess.save(formatonomipreguntanomi.getFormatoNomi(),connexion);
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(formatonomipreguntanomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				

		FactorNomiDataAccess.save(formatonomipreguntanomi.getFactorNomi(),connexion);
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(formatonomipreguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				

		PreguntaNomiDataAccess.save(formatonomipreguntanomi.getPreguntaNomi(),connexion);
		PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
		preguntanomiLogic.deepLoad(formatonomipreguntanomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				

		for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleado.setid_formato_nomi_pregunta_nomi(formatonomipreguntanomi.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
			calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatonomipreguntanomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formatonomipreguntanomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formatonomipreguntanomi.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formatonomipreguntanomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(formatonomipreguntanomi.getFormatoNomi(),connexion);
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepSave(formatonomipreguntanomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(formatonomipreguntanomi.getFactorNomi(),connexion);
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepSave(formatonomipreguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				PreguntaNomiDataAccess.save(formatonomipreguntanomi.getPreguntaNomi(),connexion);
				PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
				preguntanomiLogic.deepSave(formatonomipreguntanomi.getPreguntaNomi(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:formatonomipreguntanomi.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleado.setid_formato_nomi_pregunta_nomi(formatonomipreguntanomi.getId());
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
			this.getNewConnexionToDeep(FormatoNomiPreguntaNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomi);
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
			this.deepLoad(this.formatonomipreguntanomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormatoNomiPreguntaNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formatonomipreguntanomis!=null) {
				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
					this.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomis);
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
			if(formatonomipreguntanomis!=null) {
				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
					this.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomis);
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
			this.getNewConnexionToDeep(FormatoNomiPreguntaNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormatoNomiPreguntaNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formatonomipreguntanomis!=null) {
				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
					this.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
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
			if(formatonomipreguntanomis!=null) {
				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
					this.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormatoNomiPreguntaNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdFactorNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdFactorNomi(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdFormatoNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdFormatoNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdPreguntaNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_pregunta_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdPreguntaNomi(String sFinalQuery,Pagination pagination,Long id_pregunta_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_nomi,FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaNomi);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoNomiPreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoNomiPreguntaNomisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormatoNomiPreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(this.formatonomipreguntanomis);
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
			if(FormatoNomiPreguntaNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiPreguntaNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormatoNomiPreguntaNomi formatonomipreguntanomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormatoNomiPreguntaNomiConstantesFunciones.ISCONAUDITORIA) {
				if(formatonomipreguntanomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiPreguntaNomiDataAccess.TABLENAME, formatonomipreguntanomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiPreguntaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiPreguntaNomiLogic.registrarAuditoriaDetallesFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formatonomipreguntanomi.getIsDeleted()) {
					/*if(!formatonomipreguntanomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormatoNomiPreguntaNomiDataAccess.TABLENAME, formatonomipreguntanomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormatoNomiPreguntaNomiLogic.registrarAuditoriaDetallesFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiPreguntaNomiDataAccess.TABLENAME, formatonomipreguntanomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formatonomipreguntanomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoNomiPreguntaNomiDataAccess.TABLENAME, formatonomipreguntanomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoNomiPreguntaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoNomiPreguntaNomiLogic.registrarAuditoriaDetallesFormatoNomiPreguntaNomi(connexion,formatonomipreguntanomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormatoNomiPreguntaNomi(Connexion connexion,FormatoNomiPreguntaNomi formatonomipreguntanomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getid_empresa().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_empresa().toString();
				}
				if(formatonomipreguntanomi.getid_empresa()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getid_sucursal().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_sucursal()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_sucursal().toString();
				}
				if(formatonomipreguntanomi.getid_sucursal()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getid_formato_nomi().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_formato_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_formato_nomi()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_formato_nomi().toString();
				}
				if(formatonomipreguntanomi.getid_formato_nomi()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getid_formato_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI,strValorActual,strValorNuevo);
			}	
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getid_factor_nomi().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_factor_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_factor_nomi()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_factor_nomi().toString();
				}
				if(formatonomipreguntanomi.getid_factor_nomi()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getid_factor_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI,strValorActual,strValorNuevo);
			}	
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getid_pregunta_nomi().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_pregunta_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_pregunta_nomi()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getid_pregunta_nomi().toString();
				}
				if(formatonomipreguntanomi.getid_pregunta_nomi()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getid_pregunta_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI,strValorActual,strValorNuevo);
			}	
			
			if(formatonomipreguntanomi.getIsNew()||!formatonomipreguntanomi.getponderacion().equals(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getponderacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getponderacion()!=null)
				{
					strValorActual=formatonomipreguntanomi.getFormatoNomiPreguntaNomiOriginal().getponderacion().toString();
				}
				if(formatonomipreguntanomi.getponderacion()!=null)
				{
					strValorNuevo=formatonomipreguntanomi.getponderacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormatoNomiPreguntaNomiRelacionesWithConnection(FormatoNomiPreguntaNomi formatonomipreguntanomi,List<CalificacionEmpleado> calificacionempleados) throws Exception {

		if(!formatonomipreguntanomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiPreguntaNomiRelacionesBase(formatonomipreguntanomi,calificacionempleados,true);
		}
	}

	public void saveFormatoNomiPreguntaNomiRelaciones(FormatoNomiPreguntaNomi formatonomipreguntanomi,List<CalificacionEmpleado> calificacionempleados)throws Exception {

		if(!formatonomipreguntanomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoNomiPreguntaNomiRelacionesBase(formatonomipreguntanomi,calificacionempleados,false);
		}
	}

	public void saveFormatoNomiPreguntaNomiRelacionesBase(FormatoNomiPreguntaNomi formatonomipreguntanomi,List<CalificacionEmpleado> calificacionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormatoNomiPreguntaNomi-saveRelacionesWithConnection");}
	
			formatonomipreguntanomi.setCalificacionEmpleados(calificacionempleados);

			this.setFormatoNomiPreguntaNomi(formatonomipreguntanomi);

			if(FormatoNomiPreguntaNomiLogicAdditional.validarSaveRelaciones(formatonomipreguntanomi,this)) {

				FormatoNomiPreguntaNomiLogicAdditional.updateRelacionesToSave(formatonomipreguntanomi,this);

				if((formatonomipreguntanomi.getIsNew()||formatonomipreguntanomi.getIsChanged())&&!formatonomipreguntanomi.getIsDeleted()) {
					this.saveFormatoNomiPreguntaNomi();
					this.saveFormatoNomiPreguntaNomiRelacionesDetalles(calificacionempleados);

				} else if(formatonomipreguntanomi.getIsDeleted()) {
					this.saveFormatoNomiPreguntaNomiRelacionesDetalles(calificacionempleados);
					this.saveFormatoNomiPreguntaNomi();
				}

				FormatoNomiPreguntaNomiLogicAdditional.updateRelacionesToSaveAfter(formatonomipreguntanomi,this);

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
	
	
	private void saveFormatoNomiPreguntaNomiRelacionesDetalles(List<CalificacionEmpleado> calificacionempleados)throws Exception {
		try {
	

			Long idFormatoNomiPreguntaNomiActual=this.getFormatoNomiPreguntaNomi().getId();

			CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();
			calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(calificacionempleados);

			calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
			calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

			for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
				calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
			}

			calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomiPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoNomiPreguntaNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomiPreguntaNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
