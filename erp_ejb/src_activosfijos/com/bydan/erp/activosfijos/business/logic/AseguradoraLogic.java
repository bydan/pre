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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.AseguradoraConstantesFunciones;
import com.bydan.erp.activosfijos.util.AseguradoraParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.AseguradoraParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.Aseguradora;
import com.bydan.erp.activosfijos.business.logic.AseguradoraLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class AseguradoraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AseguradoraLogic.class);
	
	protected AseguradoraDataAccess aseguradoraDataAccess; 	
	protected Aseguradora aseguradora;
	protected List<Aseguradora> aseguradoras;
	protected Object aseguradoraObject;	
	protected List<Object> aseguradorasObject;
	
	public static ClassValidator<Aseguradora> aseguradoraValidator = new ClassValidator<Aseguradora>(Aseguradora.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AseguradoraLogicAdditional aseguradoraLogicAdditional=null;
	
	public AseguradoraLogicAdditional getAseguradoraLogicAdditional() {
		return this.aseguradoraLogicAdditional;
	}
	
	public void setAseguradoraLogicAdditional(AseguradoraLogicAdditional aseguradoraLogicAdditional) {
		try {
			this.aseguradoraLogicAdditional=aseguradoraLogicAdditional;
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
	
	
	
	
	public  AseguradoraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.aseguradoraDataAccess = new AseguradoraDataAccess();
			
			this.aseguradoras= new ArrayList<Aseguradora>();
			this.aseguradora= new Aseguradora();
			
			this.aseguradoraObject=new Object();
			this.aseguradorasObject=new ArrayList<Object>();
				
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
			
			this.aseguradoraDataAccess.setConnexionType(this.connexionType);
			this.aseguradoraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AseguradoraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.aseguradoraDataAccess = new AseguradoraDataAccess();
			this.aseguradoras= new ArrayList<Aseguradora>();
			this.aseguradora= new Aseguradora();
			this.aseguradoraObject=new Object();
			this.aseguradorasObject=new ArrayList<Object>();
			
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
			
			this.aseguradoraDataAccess.setConnexionType(this.connexionType);
			this.aseguradoraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Aseguradora getAseguradora() throws Exception {	
		AseguradoraLogicAdditional.checkAseguradoraToGet(aseguradora,this.datosCliente,this.arrDatoGeneral);
		AseguradoraLogicAdditional.updateAseguradoraToGet(aseguradora,this.arrDatoGeneral);
		
		return aseguradora;
	}
		
	public void setAseguradora(Aseguradora newAseguradora) {
		this.aseguradora = newAseguradora;
	}
	
	public AseguradoraDataAccess getAseguradoraDataAccess() {
		return aseguradoraDataAccess;
	}
	
	public void setAseguradoraDataAccess(AseguradoraDataAccess newaseguradoraDataAccess) {
		this.aseguradoraDataAccess = newaseguradoraDataAccess;
	}
	
	public List<Aseguradora> getAseguradoras() throws Exception {		
		this.quitarAseguradorasNulos();
		
		AseguradoraLogicAdditional.checkAseguradoraToGets(aseguradoras,this.datosCliente,this.arrDatoGeneral);
		
		for (Aseguradora aseguradoraLocal: aseguradoras ) {
			AseguradoraLogicAdditional.updateAseguradoraToGet(aseguradoraLocal,this.arrDatoGeneral);
		}
		
		return aseguradoras;
	}
	
	public void setAseguradoras(List<Aseguradora> newAseguradoras) {
		this.aseguradoras = newAseguradoras;
	}
	
	public Object getAseguradoraObject() {	
		this.aseguradoraObject=this.aseguradoraDataAccess.getEntityObject();
		return this.aseguradoraObject;
	}
		
	public void setAseguradoraObject(Object newAseguradoraObject) {
		this.aseguradoraObject = newAseguradoraObject;
	}
	
	public List<Object> getAseguradorasObject() {		
		this.aseguradorasObject=this.aseguradoraDataAccess.getEntitiesObject();
		return this.aseguradorasObject;
	}
		
	public void setAseguradorasObject(List<Object> newAseguradorasObject) {
		this.aseguradorasObject = newAseguradorasObject;
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
		
		if(this.aseguradoraDataAccess!=null) {
			this.aseguradoraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			aseguradoraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			aseguradoraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		aseguradora = new  Aseguradora();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			aseguradora=aseguradoraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
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
		aseguradora = new  Aseguradora();
		  		  
        try {
			
			aseguradora=aseguradoraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		aseguradora = new  Aseguradora();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			aseguradora=aseguradoraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
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
		aseguradora = new  Aseguradora();
		  		  
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
		aseguradora = new  Aseguradora();
		  		  
        try {
			
			aseguradora=aseguradoraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		aseguradora = new  Aseguradora();
		  		  
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
		aseguradora = new  Aseguradora();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =aseguradoraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		aseguradora = new  Aseguradora();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=aseguradoraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		aseguradora = new  Aseguradora();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =aseguradoraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		aseguradora = new  Aseguradora();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=aseguradoraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		aseguradora = new  Aseguradora();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =aseguradoraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		aseguradora = new  Aseguradora();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=aseguradoraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
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
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
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
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
		aseguradoras = new  ArrayList<Aseguradora>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
		aseguradoras = new  ArrayList<Aseguradora>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		aseguradora = new  Aseguradora();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradora=aseguradoraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradora);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
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
		aseguradora = new  Aseguradora();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradora=aseguradoraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradora);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
		aseguradoras = new  ArrayList<Aseguradora>();
		  		  
        try {
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAseguradorasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		aseguradoras = new  ArrayList<Aseguradora>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getTodosAseguradorasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
	
	public  void  getTodosAseguradoras(String sFinalQuery,Pagination pagination)throws Exception {
		aseguradoras = new  ArrayList<Aseguradora>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			aseguradoras=aseguradoraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAseguradora(aseguradoras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAseguradora(Aseguradora aseguradora) throws Exception {
		Boolean estaValidado=false;
		
		if(aseguradora.getIsNew() || aseguradora.getIsChanged()) { 
			this.invalidValues = aseguradoraValidator.getInvalidValues(aseguradora);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(aseguradora);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAseguradora(List<Aseguradora> Aseguradoras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Aseguradora aseguradoraLocal:aseguradoras) {				
			estaValidadoObjeto=this.validarGuardarAseguradora(aseguradoraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAseguradora(List<Aseguradora> Aseguradoras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAseguradora(aseguradoras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAseguradora(Aseguradora Aseguradora) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAseguradora(aseguradora)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Aseguradora aseguradora) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+aseguradora.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AseguradoraConstantesFunciones.getAseguradoraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"aseguradora","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AseguradoraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AseguradoraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAseguradoraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-saveAseguradoraWithConnection");connexion.begin();			
			
			AseguradoraLogicAdditional.checkAseguradoraToSave(this.aseguradora,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AseguradoraLogicAdditional.updateAseguradoraToSave(this.aseguradora,this.arrDatoGeneral);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.aseguradora,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAseguradora();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAseguradora(this.aseguradora)) {
				AseguradoraDataAccess.save(this.aseguradora, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AseguradoraLogicAdditional.checkAseguradoraToSaveAfter(this.aseguradora,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAseguradora();
			
			connexion.commit();			
			
			if(this.aseguradora.getIsDeleted()) {
				this.aseguradora=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAseguradora()throws Exception {	
		try {	
			
			AseguradoraLogicAdditional.checkAseguradoraToSave(this.aseguradora,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AseguradoraLogicAdditional.updateAseguradoraToSave(this.aseguradora,this.arrDatoGeneral);
			
			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.aseguradora,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAseguradora(this.aseguradora)) {			
				AseguradoraDataAccess.save(this.aseguradora, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.aseguradora,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AseguradoraLogicAdditional.checkAseguradoraToSaveAfter(this.aseguradora,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.aseguradora.getIsDeleted()) {
				this.aseguradora=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAseguradorasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-saveAseguradorasWithConnection");connexion.begin();			
			
			AseguradoraLogicAdditional.checkAseguradoraToSaves(aseguradoras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAseguradoras();
			
			Boolean validadoTodosAseguradora=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Aseguradora aseguradoraLocal:aseguradoras) {		
				if(aseguradoraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AseguradoraLogicAdditional.updateAseguradoraToSave(aseguradoraLocal,this.arrDatoGeneral);
	        	
				AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),aseguradoraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAseguradora(aseguradoraLocal)) {
					AseguradoraDataAccess.save(aseguradoraLocal, connexion);				
				} else {
					validadoTodosAseguradora=false;
				}
			}
			
			if(!validadoTodosAseguradora) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AseguradoraLogicAdditional.checkAseguradoraToSavesAfter(aseguradoras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAseguradoras();
			
			connexion.commit();		
			
			this.quitarAseguradorasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAseguradoras()throws Exception {				
		 try {	
			AseguradoraLogicAdditional.checkAseguradoraToSaves(aseguradoras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAseguradora=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Aseguradora aseguradoraLocal:aseguradoras) {				
				if(aseguradoraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AseguradoraLogicAdditional.updateAseguradoraToSave(aseguradoraLocal,this.arrDatoGeneral);
	        	
				AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),aseguradoraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAseguradora(aseguradoraLocal)) {				
					AseguradoraDataAccess.save(aseguradoraLocal, connexion);				
				} else {
					validadoTodosAseguradora=false;
				}
			}
			
			if(!validadoTodosAseguradora) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AseguradoraLogicAdditional.checkAseguradoraToSavesAfter(aseguradoras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAseguradorasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AseguradoraParameterReturnGeneral procesarAccionAseguradoras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Aseguradora> aseguradoras,AseguradoraParameterReturnGeneral aseguradoraParameterGeneral)throws Exception {
		 try {	
			AseguradoraParameterReturnGeneral aseguradoraReturnGeneral=new AseguradoraParameterReturnGeneral();
	
			AseguradoraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,aseguradoras,aseguradoraParameterGeneral,aseguradoraReturnGeneral);
			
			return aseguradoraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AseguradoraParameterReturnGeneral procesarAccionAseguradorasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Aseguradora> aseguradoras,AseguradoraParameterReturnGeneral aseguradoraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-procesarAccionAseguradorasWithConnection");connexion.begin();			
			
			AseguradoraParameterReturnGeneral aseguradoraReturnGeneral=new AseguradoraParameterReturnGeneral();
	
			AseguradoraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,aseguradoras,aseguradoraParameterGeneral,aseguradoraReturnGeneral);
			
			this.connexion.commit();
			
			return aseguradoraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AseguradoraParameterReturnGeneral procesarEventosAseguradoras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Aseguradora> aseguradoras,Aseguradora aseguradora,AseguradoraParameterReturnGeneral aseguradoraParameterGeneral,Boolean isEsNuevoAseguradora,ArrayList<Classe> clases)throws Exception {
		 try {	
			AseguradoraParameterReturnGeneral aseguradoraReturnGeneral=new AseguradoraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				aseguradoraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AseguradoraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,aseguradoras,aseguradora,aseguradoraParameterGeneral,aseguradoraReturnGeneral,isEsNuevoAseguradora,clases);
			
			return aseguradoraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AseguradoraParameterReturnGeneral procesarEventosAseguradorasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Aseguradora> aseguradoras,Aseguradora aseguradora,AseguradoraParameterReturnGeneral aseguradoraParameterGeneral,Boolean isEsNuevoAseguradora,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-procesarEventosAseguradorasWithConnection");connexion.begin();			
			
			AseguradoraParameterReturnGeneral aseguradoraReturnGeneral=new AseguradoraParameterReturnGeneral();
	
			aseguradoraReturnGeneral.setAseguradora(aseguradora);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				aseguradoraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AseguradoraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,aseguradoras,aseguradora,aseguradoraParameterGeneral,aseguradoraReturnGeneral,isEsNuevoAseguradora,clases);
			
			this.connexion.commit();
			
			return aseguradoraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AseguradoraParameterReturnGeneral procesarImportacionAseguradorasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AseguradoraParameterReturnGeneral aseguradoraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-procesarImportacionAseguradorasWithConnection");connexion.begin();			
			
			AseguradoraParameterReturnGeneral aseguradoraReturnGeneral=new AseguradoraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.aseguradoras=new ArrayList<Aseguradora>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.aseguradora=new Aseguradora();
				
				
				if(conColumnasBase) {this.aseguradora.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.aseguradora.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.aseguradora.setcodigo(arrColumnas[iColumn++]);
				this.aseguradora.setnombre(arrColumnas[iColumn++]);
			this.aseguradora.setdireccion(arrColumnas[iColumn++]);
				this.aseguradora.settelefono(arrColumnas[iColumn++]);
				
				this.aseguradoras.add(this.aseguradora);
			}
			
			this.saveAseguradoras();
			
			this.connexion.commit();
			
			aseguradoraReturnGeneral.setConRetornoEstaProcesado(true);
			aseguradoraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return aseguradoraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAseguradorasEliminados() throws Exception {				
		
		List<Aseguradora> aseguradorasAux= new ArrayList<Aseguradora>();
		
		for(Aseguradora aseguradora:aseguradoras) {
			if(!aseguradora.getIsDeleted()) {
				aseguradorasAux.add(aseguradora);
			}
		}
		
		aseguradoras=aseguradorasAux;
	}
	
	public void quitarAseguradorasNulos() throws Exception {				
		
		List<Aseguradora> aseguradorasAux= new ArrayList<Aseguradora>();
		
		for(Aseguradora aseguradora : this.aseguradoras) {
			if(aseguradora==null) {
				aseguradorasAux.add(aseguradora);
			}
		}
		
		//this.aseguradoras=aseguradorasAux;
		
		this.aseguradoras.removeAll(aseguradorasAux);
	}
	
	public void getSetVersionRowAseguradoraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(aseguradora.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((aseguradora.getIsDeleted() || (aseguradora.getIsChanged()&&!aseguradora.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=aseguradoraDataAccess.getSetVersionRowAseguradora(connexion,aseguradora.getId());
				
				if(!aseguradora.getVersionRow().equals(timestamp)) {	
					aseguradora.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				aseguradora.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAseguradora()throws Exception {	
		
		if(aseguradora.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((aseguradora.getIsDeleted() || (aseguradora.getIsChanged()&&!aseguradora.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=aseguradoraDataAccess.getSetVersionRowAseguradora(connexion,aseguradora.getId());
			
			try {							
				if(!aseguradora.getVersionRow().equals(timestamp)) {	
					aseguradora.setVersionRow(timestamp);
				}
				
				aseguradora.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAseguradorasWithConnection()throws Exception {	
		if(aseguradoras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Aseguradora aseguradoraAux:aseguradoras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(aseguradoraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(aseguradoraAux.getIsDeleted() || (aseguradoraAux.getIsChanged()&&!aseguradoraAux.getIsNew())) {
						
						timestamp=aseguradoraDataAccess.getSetVersionRowAseguradora(connexion,aseguradoraAux.getId());
						
						if(!aseguradora.getVersionRow().equals(timestamp)) {	
							aseguradoraAux.setVersionRow(timestamp);
						}
								
						aseguradoraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAseguradoras()throws Exception {	
		if(aseguradoras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Aseguradora aseguradoraAux:aseguradoras) {
					if(aseguradoraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(aseguradoraAux.getIsDeleted() || (aseguradoraAux.getIsChanged()&&!aseguradoraAux.getIsNew())) {
						
						timestamp=aseguradoraDataAccess.getSetVersionRowAseguradora(connexion,aseguradoraAux.getId());
						
						if(!aseguradoraAux.getVersionRow().equals(timestamp)) {	
							aseguradoraAux.setVersionRow(timestamp);
						}
						
													
						aseguradoraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AseguradoraParameterReturnGeneral cargarCombosLoteForeignKeyAseguradoraWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		AseguradoraParameterReturnGeneral  aseguradoraReturnGeneral =new AseguradoraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-cargarCombosLoteForeignKeyAseguradoraWithConnection");connexion.begin();
			
			aseguradoraReturnGeneral =new AseguradoraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			aseguradoraReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return aseguradoraReturnGeneral;
	}
	
	public AseguradoraParameterReturnGeneral cargarCombosLoteForeignKeyAseguradora(String finalQueryGlobalEmpresa) throws Exception {
		AseguradoraParameterReturnGeneral  aseguradoraReturnGeneral =new AseguradoraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			aseguradoraReturnGeneral =new AseguradoraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			aseguradoraReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return aseguradoraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAseguradoraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			VehiculoLogic vehiculoLogic=new VehiculoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAseguradoraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Vehiculo.class));
											
			

			vehiculoLogic.setConnexion(this.getConnexion());
			vehiculoLogic.setDatosCliente(this.datosCliente);
			vehiculoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Aseguradora aseguradora:this.aseguradoras) {
				

				classes=new ArrayList<Classe>();
				classes=VehiculoConstantesFunciones.getClassesForeignKeysOfVehiculo(new ArrayList<Classe>(),DeepLoadType.NONE);

				vehiculoLogic.setVehiculos(aseguradora.vehiculos);
				vehiculoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Aseguradora aseguradora,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AseguradoraLogicAdditional.updateAseguradoraToGet(aseguradora,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
		aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));

				if(this.isConDeep) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(this.connexion);
					vehiculoLogic.setVehiculos(aseguradora.getVehiculos());
					ArrayList<Classe> classesLocal=VehiculoConstantesFunciones.getClassesForeignKeysOfVehiculo(new ArrayList<Classe>(),DeepLoadType.NONE);
					vehiculoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(vehiculoLogic.getVehiculos());
					aseguradora.setVehiculos(vehiculoLogic.getVehiculos());
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
			aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vehiculo.class));
			aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(aseguradora.getEmpresa(),isDeep,deepLoadType,clases);
				

		aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));

		for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
			VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
			vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(aseguradora.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));

				for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
					vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
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
			aseguradora.setEmpresa(aseguradoraDataAccess.getEmpresa(connexion,aseguradora));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(aseguradora.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vehiculo.class));
			aseguradora.setVehiculos(aseguradoraDataAccess.getVehiculos(connexion,aseguradora));

			for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
				VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
				vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Aseguradora aseguradora,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AseguradoraLogicAdditional.updateAseguradoraToSave(aseguradora,this.arrDatoGeneral);
			
AseguradoraDataAccess.save(aseguradora, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(aseguradora.getEmpresa(),connexion);

		for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
			vehiculo.setid_aseguradora(aseguradora.getId());
			VehiculoDataAccess.save(vehiculo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(aseguradora.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
					vehiculo.setid_aseguradora(aseguradora.getId());
					VehiculoDataAccess.save(vehiculo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(aseguradora.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(aseguradora.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
			VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
			vehiculo.setid_aseguradora(aseguradora.getId());
			VehiculoDataAccess.save(vehiculo,connexion);
			vehiculoLogic.deepSave(vehiculo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(aseguradora.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(aseguradora.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vehiculo vehiculo:aseguradora.getVehiculos()) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
					vehiculo.setid_aseguradora(aseguradora.getId());
					VehiculoDataAccess.save(vehiculo,connexion);
					vehiculoLogic.deepSave(vehiculo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Aseguradora.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(aseguradora,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(aseguradora);
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
			this.deepLoad(this.aseguradora,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradora);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Aseguradora.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(aseguradoras!=null) {
				for(Aseguradora aseguradora:aseguradoras) {
					this.deepLoad(aseguradora,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(aseguradoras);
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
			if(aseguradoras!=null) {
				for(Aseguradora aseguradora:aseguradoras) {
					this.deepLoad(aseguradora,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(aseguradoras);
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
			this.getNewConnexionToDeep(Aseguradora.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(aseguradora,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Aseguradora.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(aseguradoras!=null) {
				for(Aseguradora aseguradora:aseguradoras) {
					this.deepSave(aseguradora,isDeep,deepLoadType,clases);
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
			if(aseguradoras!=null) {
				for(Aseguradora aseguradora:aseguradoras) {
					this.deepSave(aseguradora,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAseguradorasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Aseguradora.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AseguradoraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			aseguradoras=aseguradoraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAseguradorasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AseguradoraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AseguradoraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			aseguradoras=aseguradoraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AseguradoraConstantesFunciones.refrescarForeignKeysDescripcionesAseguradora(this.aseguradoras);
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
			if(AseguradoraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AseguradoraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Aseguradora aseguradora,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AseguradoraConstantesFunciones.ISCONAUDITORIA) {
				if(aseguradora.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AseguradoraDataAccess.TABLENAME, aseguradora.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AseguradoraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AseguradoraLogic.registrarAuditoriaDetallesAseguradora(connexion,aseguradora,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(aseguradora.getIsDeleted()) {
					/*if(!aseguradora.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AseguradoraDataAccess.TABLENAME, aseguradora.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AseguradoraLogic.registrarAuditoriaDetallesAseguradora(connexion,aseguradora,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AseguradoraDataAccess.TABLENAME, aseguradora.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(aseguradora.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AseguradoraDataAccess.TABLENAME, aseguradora.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AseguradoraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AseguradoraLogic.registrarAuditoriaDetallesAseguradora(connexion,aseguradora,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAseguradora(Connexion connexion,Aseguradora aseguradora)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(aseguradora.getIsNew()||!aseguradora.getid_empresa().equals(aseguradora.getAseguradoraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(aseguradora.getAseguradoraOriginal().getid_empresa()!=null)
				{
					strValorActual=aseguradora.getAseguradoraOriginal().getid_empresa().toString();
				}
				if(aseguradora.getid_empresa()!=null)
				{
					strValorNuevo=aseguradora.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AseguradoraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(aseguradora.getIsNew()||!aseguradora.getcodigo().equals(aseguradora.getAseguradoraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(aseguradora.getAseguradoraOriginal().getcodigo()!=null)
				{
					strValorActual=aseguradora.getAseguradoraOriginal().getcodigo();
				}
				if(aseguradora.getcodigo()!=null)
				{
					strValorNuevo=aseguradora.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AseguradoraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(aseguradora.getIsNew()||!aseguradora.getnombre().equals(aseguradora.getAseguradoraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(aseguradora.getAseguradoraOriginal().getnombre()!=null)
				{
					strValorActual=aseguradora.getAseguradoraOriginal().getnombre();
				}
				if(aseguradora.getnombre()!=null)
				{
					strValorNuevo=aseguradora.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AseguradoraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(aseguradora.getIsNew()||!aseguradora.getdireccion().equals(aseguradora.getAseguradoraOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(aseguradora.getAseguradoraOriginal().getdireccion()!=null)
				{
					strValorActual=aseguradora.getAseguradoraOriginal().getdireccion();
				}
				if(aseguradora.getdireccion()!=null)
				{
					strValorNuevo=aseguradora.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AseguradoraConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(aseguradora.getIsNew()||!aseguradora.gettelefono().equals(aseguradora.getAseguradoraOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(aseguradora.getAseguradoraOriginal().gettelefono()!=null)
				{
					strValorActual=aseguradora.getAseguradoraOriginal().gettelefono();
				}
				if(aseguradora.gettelefono()!=null)
				{
					strValorNuevo=aseguradora.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AseguradoraConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAseguradoraRelacionesWithConnection(Aseguradora aseguradora,List<Vehiculo> vehiculos) throws Exception {

		if(!aseguradora.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAseguradoraRelacionesBase(aseguradora,vehiculos,true);
		}
	}

	public void saveAseguradoraRelaciones(Aseguradora aseguradora,List<Vehiculo> vehiculos)throws Exception {

		if(!aseguradora.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAseguradoraRelacionesBase(aseguradora,vehiculos,false);
		}
	}

	public void saveAseguradoraRelacionesBase(Aseguradora aseguradora,List<Vehiculo> vehiculos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Aseguradora-saveRelacionesWithConnection");}
	
			aseguradora.setVehiculos(vehiculos);

			this.setAseguradora(aseguradora);

			if(AseguradoraLogicAdditional.validarSaveRelaciones(aseguradora,this)) {

				AseguradoraLogicAdditional.updateRelacionesToSave(aseguradora,this);

				if((aseguradora.getIsNew()||aseguradora.getIsChanged())&&!aseguradora.getIsDeleted()) {
					this.saveAseguradora();
					this.saveAseguradoraRelacionesDetalles(vehiculos);

				} else if(aseguradora.getIsDeleted()) {
					this.saveAseguradoraRelacionesDetalles(vehiculos);
					this.saveAseguradora();
				}

				AseguradoraLogicAdditional.updateRelacionesToSaveAfter(aseguradora,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			VehiculoConstantesFunciones.InicializarGeneralEntityAuxiliaresVehiculos(vehiculos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAseguradoraRelacionesDetalles(List<Vehiculo> vehiculos)throws Exception {
		try {
	

			Long idAseguradoraActual=this.getAseguradora().getId();

			VehiculoLogic vehiculoLogic_Desde_Aseguradora=new VehiculoLogic();
			vehiculoLogic_Desde_Aseguradora.setVehiculos(vehiculos);

			vehiculoLogic_Desde_Aseguradora.setConnexion(this.getConnexion());
			vehiculoLogic_Desde_Aseguradora.setDatosCliente(this.datosCliente);

			for(Vehiculo vehiculo_Desde_Aseguradora:vehiculoLogic_Desde_Aseguradora.getVehiculos()) {
				vehiculo_Desde_Aseguradora.setid_aseguradora(idAseguradoraActual);

				vehiculoLogic_Desde_Aseguradora.setVehiculo(vehiculo_Desde_Aseguradora);
				vehiculoLogic_Desde_Aseguradora.saveVehiculo();

				Long idVehiculoActual=vehiculo_Desde_Aseguradora.getId();

				ServicioTransporteLogic serviciotransporteLogic_Desde_Vehiculo=new ServicioTransporteLogic();

				if(vehiculo_Desde_Aseguradora.getServicioTransportes()==null){
					vehiculo_Desde_Aseguradora.setServicioTransportes(new ArrayList<ServicioTransporte>());
				}

				serviciotransporteLogic_Desde_Vehiculo.setServicioTransportes(vehiculo_Desde_Aseguradora.getServicioTransportes());

				serviciotransporteLogic_Desde_Vehiculo.setConnexion(this.getConnexion());
				serviciotransporteLogic_Desde_Vehiculo.setDatosCliente(this.datosCliente);

				for(ServicioTransporte serviciotransporte_Desde_Vehiculo:serviciotransporteLogic_Desde_Vehiculo.getServicioTransportes()) {
					serviciotransporte_Desde_Vehiculo.setid_vehiculo(idVehiculoActual);

					serviciotransporteLogic_Desde_Vehiculo.setServicioTransporte(serviciotransporte_Desde_Vehiculo);
					serviciotransporteLogic_Desde_Vehiculo.saveServicioTransporte();

					Long idServicioTransporteActual=serviciotransporte_Desde_Vehiculo.getId();

					DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();

					if(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes()==null){
						serviciotransporte_Desde_Vehiculo.setDetalleServicioTransportes(new ArrayList<DetalleServicioTransporte>());
					}

					detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes());

					detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
					detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

					for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
						detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
					}

					detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAseguradora(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AseguradoraConstantesFunciones.getClassesForeignKeysOfAseguradora(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAseguradora(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AseguradoraConstantesFunciones.getClassesRelationshipsOfAseguradora(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
