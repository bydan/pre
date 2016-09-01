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
import com.bydan.erp.inventario.util.UbicacionProduConstantesFunciones;
import com.bydan.erp.inventario.util.UbicacionProduParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UbicacionProduParameterGeneral;
import com.bydan.erp.inventario.business.entity.UbicacionProdu;
import com.bydan.erp.inventario.business.logic.UbicacionProduLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class UbicacionProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UbicacionProduLogic.class);
	
	protected UbicacionProduDataAccess ubicacionproduDataAccess; 	
	protected UbicacionProdu ubicacionprodu;
	protected List<UbicacionProdu> ubicacionprodus;
	protected Object ubicacionproduObject;	
	protected List<Object> ubicacionprodusObject;
	
	public static ClassValidator<UbicacionProdu> ubicacionproduValidator = new ClassValidator<UbicacionProdu>(UbicacionProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UbicacionProduLogicAdditional ubicacionproduLogicAdditional=null;
	
	public UbicacionProduLogicAdditional getUbicacionProduLogicAdditional() {
		return this.ubicacionproduLogicAdditional;
	}
	
	public void setUbicacionProduLogicAdditional(UbicacionProduLogicAdditional ubicacionproduLogicAdditional) {
		try {
			this.ubicacionproduLogicAdditional=ubicacionproduLogicAdditional;
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
	
	
	
	
	public  UbicacionProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ubicacionproduDataAccess = new UbicacionProduDataAccess();
			
			this.ubicacionprodus= new ArrayList<UbicacionProdu>();
			this.ubicacionprodu= new UbicacionProdu();
			
			this.ubicacionproduObject=new Object();
			this.ubicacionprodusObject=new ArrayList<Object>();
				
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
			
			this.ubicacionproduDataAccess.setConnexionType(this.connexionType);
			this.ubicacionproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UbicacionProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ubicacionproduDataAccess = new UbicacionProduDataAccess();
			this.ubicacionprodus= new ArrayList<UbicacionProdu>();
			this.ubicacionprodu= new UbicacionProdu();
			this.ubicacionproduObject=new Object();
			this.ubicacionprodusObject=new ArrayList<Object>();
			
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
			
			this.ubicacionproduDataAccess.setConnexionType(this.connexionType);
			this.ubicacionproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UbicacionProdu getUbicacionProdu() throws Exception {	
		UbicacionProduLogicAdditional.checkUbicacionProduToGet(ubicacionprodu,this.datosCliente,this.arrDatoGeneral);
		UbicacionProduLogicAdditional.updateUbicacionProduToGet(ubicacionprodu,this.arrDatoGeneral);
		
		return ubicacionprodu;
	}
		
	public void setUbicacionProdu(UbicacionProdu newUbicacionProdu) {
		this.ubicacionprodu = newUbicacionProdu;
	}
	
	public UbicacionProduDataAccess getUbicacionProduDataAccess() {
		return ubicacionproduDataAccess;
	}
	
	public void setUbicacionProduDataAccess(UbicacionProduDataAccess newubicacionproduDataAccess) {
		this.ubicacionproduDataAccess = newubicacionproduDataAccess;
	}
	
	public List<UbicacionProdu> getUbicacionProdus() throws Exception {		
		this.quitarUbicacionProdusNulos();
		
		UbicacionProduLogicAdditional.checkUbicacionProduToGets(ubicacionprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (UbicacionProdu ubicacionproduLocal: ubicacionprodus ) {
			UbicacionProduLogicAdditional.updateUbicacionProduToGet(ubicacionproduLocal,this.arrDatoGeneral);
		}
		
		return ubicacionprodus;
	}
	
	public void setUbicacionProdus(List<UbicacionProdu> newUbicacionProdus) {
		this.ubicacionprodus = newUbicacionProdus;
	}
	
	public Object getUbicacionProduObject() {	
		this.ubicacionproduObject=this.ubicacionproduDataAccess.getEntityObject();
		return this.ubicacionproduObject;
	}
		
	public void setUbicacionProduObject(Object newUbicacionProduObject) {
		this.ubicacionproduObject = newUbicacionProduObject;
	}
	
	public List<Object> getUbicacionProdusObject() {		
		this.ubicacionprodusObject=this.ubicacionproduDataAccess.getEntitiesObject();
		return this.ubicacionprodusObject;
	}
		
	public void setUbicacionProdusObject(List<Object> newUbicacionProdusObject) {
		this.ubicacionprodusObject = newUbicacionProdusObject;
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
		
		if(this.ubicacionproduDataAccess!=null) {
			this.ubicacionproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ubicacionproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ubicacionproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ubicacionprodu = new  UbicacionProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
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
		ubicacionprodu = new  UbicacionProdu();
		  		  
        try {
			
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ubicacionprodu = new  UbicacionProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
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
		ubicacionprodu = new  UbicacionProdu();
		  		  
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
		ubicacionprodu = new  UbicacionProdu();
		  		  
        try {
			
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ubicacionprodu = new  UbicacionProdu();
		  		  
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
		ubicacionprodu = new  UbicacionProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ubicacionproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionprodu = new  UbicacionProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ubicacionproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ubicacionprodu = new  UbicacionProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ubicacionproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionprodu = new  UbicacionProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ubicacionproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ubicacionprodu = new  UbicacionProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ubicacionproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionprodu = new  UbicacionProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ubicacionproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ubicacionprodu = new  UbicacionProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
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
		ubicacionprodu = new  UbicacionProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodu=ubicacionproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		  		  
        try {
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUbicacionProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getTodosUbicacionProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
	
	public  void  getTodosUbicacionProdus(String sFinalQuery,Pagination pagination)throws Exception {
		ubicacionprodus = new  ArrayList<UbicacionProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUbicacionProdu(ubicacionprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUbicacionProdu(UbicacionProdu ubicacionprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(ubicacionprodu.getIsNew() || ubicacionprodu.getIsChanged()) { 
			this.invalidValues = ubicacionproduValidator.getInvalidValues(ubicacionprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ubicacionprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUbicacionProdu(List<UbicacionProdu> UbicacionProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UbicacionProdu ubicacionproduLocal:ubicacionprodus) {				
			estaValidadoObjeto=this.validarGuardarUbicacionProdu(ubicacionproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUbicacionProdu(List<UbicacionProdu> UbicacionProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUbicacionProdu(ubicacionprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUbicacionProdu(UbicacionProdu UbicacionProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUbicacionProdu(ubicacionprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UbicacionProdu ubicacionprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ubicacionprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UbicacionProduConstantesFunciones.getUbicacionProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ubicacionprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UbicacionProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UbicacionProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUbicacionProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-saveUbicacionProduWithConnection");connexion.begin();			
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSave(this.ubicacionprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UbicacionProduLogicAdditional.updateUbicacionProduToSave(this.ubicacionprodu,this.arrDatoGeneral);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ubicacionprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUbicacionProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUbicacionProdu(this.ubicacionprodu)) {
				UbicacionProduDataAccess.save(this.ubicacionprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSaveAfter(this.ubicacionprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUbicacionProdu();
			
			connexion.commit();			
			
			if(this.ubicacionprodu.getIsDeleted()) {
				this.ubicacionprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUbicacionProdu()throws Exception {	
		try {	
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSave(this.ubicacionprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UbicacionProduLogicAdditional.updateUbicacionProduToSave(this.ubicacionprodu,this.arrDatoGeneral);
			
			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ubicacionprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUbicacionProdu(this.ubicacionprodu)) {			
				UbicacionProduDataAccess.save(this.ubicacionprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ubicacionprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSaveAfter(this.ubicacionprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ubicacionprodu.getIsDeleted()) {
				this.ubicacionprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUbicacionProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-saveUbicacionProdusWithConnection");connexion.begin();			
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSaves(ubicacionprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUbicacionProdus();
			
			Boolean validadoTodosUbicacionProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UbicacionProdu ubicacionproduLocal:ubicacionprodus) {		
				if(ubicacionproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UbicacionProduLogicAdditional.updateUbicacionProduToSave(ubicacionproduLocal,this.arrDatoGeneral);
	        	
				UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ubicacionproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUbicacionProdu(ubicacionproduLocal)) {
					UbicacionProduDataAccess.save(ubicacionproduLocal, connexion);				
				} else {
					validadoTodosUbicacionProdu=false;
				}
			}
			
			if(!validadoTodosUbicacionProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSavesAfter(ubicacionprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUbicacionProdus();
			
			connexion.commit();		
			
			this.quitarUbicacionProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUbicacionProdus()throws Exception {				
		 try {	
			UbicacionProduLogicAdditional.checkUbicacionProduToSaves(ubicacionprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUbicacionProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UbicacionProdu ubicacionproduLocal:ubicacionprodus) {				
				if(ubicacionproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UbicacionProduLogicAdditional.updateUbicacionProduToSave(ubicacionproduLocal,this.arrDatoGeneral);
	        	
				UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ubicacionproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUbicacionProdu(ubicacionproduLocal)) {				
					UbicacionProduDataAccess.save(ubicacionproduLocal, connexion);				
				} else {
					validadoTodosUbicacionProdu=false;
				}
			}
			
			if(!validadoTodosUbicacionProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UbicacionProduLogicAdditional.checkUbicacionProduToSavesAfter(ubicacionprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUbicacionProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UbicacionProduParameterReturnGeneral procesarAccionUbicacionProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UbicacionProdu> ubicacionprodus,UbicacionProduParameterReturnGeneral ubicacionproduParameterGeneral)throws Exception {
		 try {	
			UbicacionProduParameterReturnGeneral ubicacionproduReturnGeneral=new UbicacionProduParameterReturnGeneral();
	
			UbicacionProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ubicacionprodus,ubicacionproduParameterGeneral,ubicacionproduReturnGeneral);
			
			return ubicacionproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UbicacionProduParameterReturnGeneral procesarAccionUbicacionProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UbicacionProdu> ubicacionprodus,UbicacionProduParameterReturnGeneral ubicacionproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-procesarAccionUbicacionProdusWithConnection");connexion.begin();			
			
			UbicacionProduParameterReturnGeneral ubicacionproduReturnGeneral=new UbicacionProduParameterReturnGeneral();
	
			UbicacionProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ubicacionprodus,ubicacionproduParameterGeneral,ubicacionproduReturnGeneral);
			
			this.connexion.commit();
			
			return ubicacionproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UbicacionProduParameterReturnGeneral procesarEventosUbicacionProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UbicacionProdu> ubicacionprodus,UbicacionProdu ubicacionprodu,UbicacionProduParameterReturnGeneral ubicacionproduParameterGeneral,Boolean isEsNuevoUbicacionProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			UbicacionProduParameterReturnGeneral ubicacionproduReturnGeneral=new UbicacionProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ubicacionproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UbicacionProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ubicacionprodus,ubicacionprodu,ubicacionproduParameterGeneral,ubicacionproduReturnGeneral,isEsNuevoUbicacionProdu,clases);
			
			return ubicacionproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UbicacionProduParameterReturnGeneral procesarEventosUbicacionProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UbicacionProdu> ubicacionprodus,UbicacionProdu ubicacionprodu,UbicacionProduParameterReturnGeneral ubicacionproduParameterGeneral,Boolean isEsNuevoUbicacionProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-procesarEventosUbicacionProdusWithConnection");connexion.begin();			
			
			UbicacionProduParameterReturnGeneral ubicacionproduReturnGeneral=new UbicacionProduParameterReturnGeneral();
	
			ubicacionproduReturnGeneral.setUbicacionProdu(ubicacionprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ubicacionproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UbicacionProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ubicacionprodus,ubicacionprodu,ubicacionproduParameterGeneral,ubicacionproduReturnGeneral,isEsNuevoUbicacionProdu,clases);
			
			this.connexion.commit();
			
			return ubicacionproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UbicacionProduParameterReturnGeneral procesarImportacionUbicacionProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UbicacionProduParameterReturnGeneral ubicacionproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-procesarImportacionUbicacionProdusWithConnection");connexion.begin();			
			
			UbicacionProduParameterReturnGeneral ubicacionproduReturnGeneral=new UbicacionProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ubicacionprodus=new ArrayList<UbicacionProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ubicacionprodu=new UbicacionProdu();
				
				
				if(conColumnasBase) {this.ubicacionprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ubicacionprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.ubicacionprodus.add(this.ubicacionprodu);
			}
			
			this.saveUbicacionProdus();
			
			this.connexion.commit();
			
			ubicacionproduReturnGeneral.setConRetornoEstaProcesado(true);
			ubicacionproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ubicacionproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUbicacionProdusEliminados() throws Exception {				
		
		List<UbicacionProdu> ubicacionprodusAux= new ArrayList<UbicacionProdu>();
		
		for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
			if(!ubicacionprodu.getIsDeleted()) {
				ubicacionprodusAux.add(ubicacionprodu);
			}
		}
		
		ubicacionprodus=ubicacionprodusAux;
	}
	
	public void quitarUbicacionProdusNulos() throws Exception {				
		
		List<UbicacionProdu> ubicacionprodusAux= new ArrayList<UbicacionProdu>();
		
		for(UbicacionProdu ubicacionprodu : this.ubicacionprodus) {
			if(ubicacionprodu==null) {
				ubicacionprodusAux.add(ubicacionprodu);
			}
		}
		
		//this.ubicacionprodus=ubicacionprodusAux;
		
		this.ubicacionprodus.removeAll(ubicacionprodusAux);
	}
	
	public void getSetVersionRowUbicacionProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ubicacionprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ubicacionprodu.getIsDeleted() || (ubicacionprodu.getIsChanged()&&!ubicacionprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ubicacionproduDataAccess.getSetVersionRowUbicacionProdu(connexion,ubicacionprodu.getId());
				
				if(!ubicacionprodu.getVersionRow().equals(timestamp)) {	
					ubicacionprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ubicacionprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUbicacionProdu()throws Exception {	
		
		if(ubicacionprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ubicacionprodu.getIsDeleted() || (ubicacionprodu.getIsChanged()&&!ubicacionprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ubicacionproduDataAccess.getSetVersionRowUbicacionProdu(connexion,ubicacionprodu.getId());
			
			try {							
				if(!ubicacionprodu.getVersionRow().equals(timestamp)) {	
					ubicacionprodu.setVersionRow(timestamp);
				}
				
				ubicacionprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUbicacionProdusWithConnection()throws Exception {	
		if(ubicacionprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UbicacionProdu ubicacionproduAux:ubicacionprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ubicacionproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ubicacionproduAux.getIsDeleted() || (ubicacionproduAux.getIsChanged()&&!ubicacionproduAux.getIsNew())) {
						
						timestamp=ubicacionproduDataAccess.getSetVersionRowUbicacionProdu(connexion,ubicacionproduAux.getId());
						
						if(!ubicacionprodu.getVersionRow().equals(timestamp)) {	
							ubicacionproduAux.setVersionRow(timestamp);
						}
								
						ubicacionproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUbicacionProdus()throws Exception {	
		if(ubicacionprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UbicacionProdu ubicacionproduAux:ubicacionprodus) {
					if(ubicacionproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ubicacionproduAux.getIsDeleted() || (ubicacionproduAux.getIsChanged()&&!ubicacionproduAux.getIsNew())) {
						
						timestamp=ubicacionproduDataAccess.getSetVersionRowUbicacionProdu(connexion,ubicacionproduAux.getId());
						
						if(!ubicacionproduAux.getVersionRow().equals(timestamp)) {	
							ubicacionproduAux.setVersionRow(timestamp);
						}
						
													
						ubicacionproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UbicacionProduParameterReturnGeneral cargarCombosLoteForeignKeyUbicacionProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUbicacionBode) throws Exception {
		UbicacionProduParameterReturnGeneral  ubicacionproduReturnGeneral =new UbicacionProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyUbicacionProduWithConnection");connexion.begin();
			
			ubicacionproduReturnGeneral =new UbicacionProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ubicacionproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ubicacionproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ubicacionproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ubicacionproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<UbicacionBode> ubicacionbodesForeignKey=new ArrayList<UbicacionBode>();
			UbicacionBodeLogic ubicacionbodeLogic=new UbicacionBodeLogic();
			ubicacionbodeLogic.setConnexion(this.connexion);
			ubicacionbodeLogic.getUbicacionBodeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUbicacionBode.equals("NONE")) {
				ubicacionbodeLogic.getTodosUbicacionBodes(finalQueryGlobalUbicacionBode,new Pagination());
				ubicacionbodesForeignKey=ubicacionbodeLogic.getUbicacionBodes();
			}

			ubicacionproduReturnGeneral.setubicacionbodesForeignKey(ubicacionbodesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ubicacionproduReturnGeneral;
	}
	
	public UbicacionProduParameterReturnGeneral cargarCombosLoteForeignKeyUbicacionProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUbicacionBode) throws Exception {
		UbicacionProduParameterReturnGeneral  ubicacionproduReturnGeneral =new UbicacionProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ubicacionproduReturnGeneral =new UbicacionProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ubicacionproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ubicacionproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ubicacionproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ubicacionproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<UbicacionBode> ubicacionbodesForeignKey=new ArrayList<UbicacionBode>();
			UbicacionBodeLogic ubicacionbodeLogic=new UbicacionBodeLogic();
			ubicacionbodeLogic.setConnexion(this.connexion);
			ubicacionbodeLogic.getUbicacionBodeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUbicacionBode.equals("NONE")) {
				ubicacionbodeLogic.getTodosUbicacionBodes(finalQueryGlobalUbicacionBode,new Pagination());
				ubicacionbodesForeignKey=ubicacionbodeLogic.getUbicacionBodes();
			}

			ubicacionproduReturnGeneral.setubicacionbodesForeignKey(ubicacionbodesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ubicacionproduReturnGeneral;
	}
	
	
	public void deepLoad(UbicacionProdu ubicacionprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UbicacionProduLogicAdditional.updateUbicacionProduToGet(ubicacionprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
		ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
		ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
		ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
		ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
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
			ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ubicacionprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ubicacionprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ubicacionprodu.getBodega(),isDeep,deepLoadType,clases);
				
		ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ubicacionprodu.getProducto(),isDeep,deepLoadType,clases);
				
		ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
		UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
		ubicacionbodeLogic.deepLoad(ubicacionprodu.getUbicacionBode(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ubicacionprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ubicacionprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ubicacionprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(ubicacionprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
				UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
				ubicacionbodeLogic.deepLoad(ubicacionprodu.getUbicacionBode(),isDeep,deepLoadType,clases);				
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
			ubicacionprodu.setEmpresa(ubicacionproduDataAccess.getEmpresa(connexion,ubicacionprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ubicacionprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setSucursal(ubicacionproduDataAccess.getSucursal(connexion,ubicacionprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ubicacionprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setBodega(ubicacionproduDataAccess.getBodega(connexion,ubicacionprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ubicacionprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setProducto(ubicacionproduDataAccess.getProducto(connexion,ubicacionprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(ubicacionprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionprodu.setUbicacionBode(ubicacionproduDataAccess.getUbicacionBode(connexion,ubicacionprodu));
			UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
			ubicacionbodeLogic.deepLoad(ubicacionprodu.getUbicacionBode(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UbicacionProdu ubicacionprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UbicacionProduLogicAdditional.updateUbicacionProduToSave(ubicacionprodu,this.arrDatoGeneral);
			
UbicacionProduDataAccess.save(ubicacionprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ubicacionprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(ubicacionprodu.getSucursal(),connexion);

		BodegaDataAccess.save(ubicacionprodu.getBodega(),connexion);

		ProductoDataAccess.save(ubicacionprodu.getProducto(),connexion);

		UbicacionBodeDataAccess.save(ubicacionprodu.getUbicacionBode(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ubicacionprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ubicacionprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ubicacionprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ubicacionprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				UbicacionBodeDataAccess.save(ubicacionprodu.getUbicacionBode(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ubicacionprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ubicacionprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ubicacionprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ubicacionprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ubicacionprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ubicacionprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(ubicacionprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ubicacionprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UbicacionBodeDataAccess.save(ubicacionprodu.getUbicacionBode(),connexion);
		UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
		ubicacionbodeLogic.deepLoad(ubicacionprodu.getUbicacionBode(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ubicacionprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ubicacionprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ubicacionprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ubicacionprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ubicacionprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ubicacionprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ubicacionprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(ubicacionprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				UbicacionBodeDataAccess.save(ubicacionprodu.getUbicacionBode(),connexion);
				UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
				ubicacionbodeLogic.deepSave(ubicacionprodu.getUbicacionBode(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(UbicacionProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(ubicacionprodu);
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
			this.deepLoad(this.ubicacionprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UbicacionProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ubicacionprodus!=null) {
				for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
					this.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(ubicacionprodus);
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
			if(ubicacionprodus!=null) {
				for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
					this.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(ubicacionprodus);
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
			this.getNewConnexionToDeep(UbicacionProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(UbicacionProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ubicacionprodus!=null) {
				for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
					this.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
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
			if(ubicacionprodus!=null) {
				for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
					this.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUbicacionProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,UbicacionProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,UbicacionProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UbicacionProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UbicacionProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,UbicacionProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,UbicacionProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UbicacionProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UbicacionProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionProdusFK_IdUbicacionBodeWithConnection(String sFinalQuery,Pagination pagination,Long id_ubicacion_bode)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUbicacionBode= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUbicacionBode.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ubicacion_bode,UbicacionProduConstantesFunciones.IDUBICACIONBODE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUbicacionBode);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUbicacionBode","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionProdusFK_IdUbicacionBode(String sFinalQuery,Pagination pagination,Long id_ubicacion_bode)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUbicacionBode= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUbicacionBode.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ubicacion_bode,UbicacionProduConstantesFunciones.IDUBICACIONBODE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUbicacionBode);

			UbicacionProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUbicacionBode","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(this.ubicacionprodus);
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
			if(UbicacionProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UbicacionProdu ubicacionprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UbicacionProduConstantesFunciones.ISCONAUDITORIA) {
				if(ubicacionprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionProduDataAccess.TABLENAME, ubicacionprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UbicacionProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UbicacionProduLogic.registrarAuditoriaDetallesUbicacionProdu(connexion,ubicacionprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ubicacionprodu.getIsDeleted()) {
					/*if(!ubicacionprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UbicacionProduDataAccess.TABLENAME, ubicacionprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UbicacionProduLogic.registrarAuditoriaDetallesUbicacionProdu(connexion,ubicacionprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionProduDataAccess.TABLENAME, ubicacionprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ubicacionprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionProduDataAccess.TABLENAME, ubicacionprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UbicacionProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UbicacionProduLogic.registrarAuditoriaDetallesUbicacionProdu(connexion,ubicacionprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUbicacionProdu(Connexion connexion,UbicacionProdu ubicacionprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ubicacionprodu.getIsNew()||!ubicacionprodu.getid_empresa().equals(ubicacionprodu.getUbicacionProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionprodu.getUbicacionProduOriginal().getid_empresa()!=null)
				{
					strValorActual=ubicacionprodu.getUbicacionProduOriginal().getid_empresa().toString();
				}
				if(ubicacionprodu.getid_empresa()!=null)
				{
					strValorNuevo=ubicacionprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionprodu.getIsNew()||!ubicacionprodu.getid_sucursal().equals(ubicacionprodu.getUbicacionProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionprodu.getUbicacionProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=ubicacionprodu.getUbicacionProduOriginal().getid_sucursal().toString();
				}
				if(ubicacionprodu.getid_sucursal()!=null)
				{
					strValorNuevo=ubicacionprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionprodu.getIsNew()||!ubicacionprodu.getid_bodega().equals(ubicacionprodu.getUbicacionProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionprodu.getUbicacionProduOriginal().getid_bodega()!=null)
				{
					strValorActual=ubicacionprodu.getUbicacionProduOriginal().getid_bodega().toString();
				}
				if(ubicacionprodu.getid_bodega()!=null)
				{
					strValorNuevo=ubicacionprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionprodu.getIsNew()||!ubicacionprodu.getid_producto().equals(ubicacionprodu.getUbicacionProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionprodu.getUbicacionProduOriginal().getid_producto()!=null)
				{
					strValorActual=ubicacionprodu.getUbicacionProduOriginal().getid_producto().toString();
				}
				if(ubicacionprodu.getid_producto()!=null)
				{
					strValorNuevo=ubicacionprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionprodu.getIsNew()||!ubicacionprodu.getid_ubicacion_bode().equals(ubicacionprodu.getUbicacionProduOriginal().getid_ubicacion_bode()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionprodu.getUbicacionProduOriginal().getid_ubicacion_bode()!=null)
				{
					strValorActual=ubicacionprodu.getUbicacionProduOriginal().getid_ubicacion_bode().toString();
				}
				if(ubicacionprodu.getid_ubicacion_bode()!=null)
				{
					strValorNuevo=ubicacionprodu.getid_ubicacion_bode().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionProduConstantesFunciones.IDUBICACIONBODE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUbicacionProduRelacionesWithConnection(UbicacionProdu ubicacionprodu) throws Exception {

		if(!ubicacionprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUbicacionProduRelacionesBase(ubicacionprodu,true);
		}
	}

	public void saveUbicacionProduRelaciones(UbicacionProdu ubicacionprodu)throws Exception {

		if(!ubicacionprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUbicacionProduRelacionesBase(ubicacionprodu,false);
		}
	}

	public void saveUbicacionProduRelacionesBase(UbicacionProdu ubicacionprodu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("UbicacionProdu-saveRelacionesWithConnection");}
	

			this.setUbicacionProdu(ubicacionprodu);

			if(UbicacionProduLogicAdditional.validarSaveRelaciones(ubicacionprodu,this)) {

				UbicacionProduLogicAdditional.updateRelacionesToSave(ubicacionprodu,this);

				if((ubicacionprodu.getIsNew()||ubicacionprodu.getIsChanged())&&!ubicacionprodu.getIsDeleted()) {
					this.saveUbicacionProdu();
					this.saveUbicacionProduRelacionesDetalles();

				} else if(ubicacionprodu.getIsDeleted()) {
					this.saveUbicacionProduRelacionesDetalles();
					this.saveUbicacionProdu();
				}

				UbicacionProduLogicAdditional.updateRelacionesToSaveAfter(ubicacionprodu,this);

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
	
	
	private void saveUbicacionProduRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUbicacionProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UbicacionProduConstantesFunciones.getClassesForeignKeysOfUbicacionProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UbicacionProduConstantesFunciones.getClassesRelationshipsOfUbicacionProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
