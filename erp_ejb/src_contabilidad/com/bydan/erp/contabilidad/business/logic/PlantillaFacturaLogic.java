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
import com.bydan.erp.contabilidad.util.PlantillaFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PlantillaFacturaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PlantillaFacturaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PlantillaFactura;
import com.bydan.erp.contabilidad.business.logic.PlantillaFacturaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PlantillaFacturaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PlantillaFacturaLogic.class);
	
	protected PlantillaFacturaDataAccess plantillafacturaDataAccess; 	
	protected PlantillaFactura plantillafactura;
	protected List<PlantillaFactura> plantillafacturas;
	protected Object plantillafacturaObject;	
	protected List<Object> plantillafacturasObject;
	
	public static ClassValidator<PlantillaFactura> plantillafacturaValidator = new ClassValidator<PlantillaFactura>(PlantillaFactura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PlantillaFacturaLogicAdditional plantillafacturaLogicAdditional=null;
	
	public PlantillaFacturaLogicAdditional getPlantillaFacturaLogicAdditional() {
		return this.plantillafacturaLogicAdditional;
	}
	
	public void setPlantillaFacturaLogicAdditional(PlantillaFacturaLogicAdditional plantillafacturaLogicAdditional) {
		try {
			this.plantillafacturaLogicAdditional=plantillafacturaLogicAdditional;
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
	
	
	
	
	public  PlantillaFacturaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.plantillafacturaDataAccess = new PlantillaFacturaDataAccess();
			
			this.plantillafacturas= new ArrayList<PlantillaFactura>();
			this.plantillafactura= new PlantillaFactura();
			
			this.plantillafacturaObject=new Object();
			this.plantillafacturasObject=new ArrayList<Object>();
				
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
			
			this.plantillafacturaDataAccess.setConnexionType(this.connexionType);
			this.plantillafacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PlantillaFacturaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.plantillafacturaDataAccess = new PlantillaFacturaDataAccess();
			this.plantillafacturas= new ArrayList<PlantillaFactura>();
			this.plantillafactura= new PlantillaFactura();
			this.plantillafacturaObject=new Object();
			this.plantillafacturasObject=new ArrayList<Object>();
			
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
			
			this.plantillafacturaDataAccess.setConnexionType(this.connexionType);
			this.plantillafacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PlantillaFactura getPlantillaFactura() throws Exception {	
		PlantillaFacturaLogicAdditional.checkPlantillaFacturaToGet(plantillafactura,this.datosCliente,this.arrDatoGeneral);
		PlantillaFacturaLogicAdditional.updatePlantillaFacturaToGet(plantillafactura,this.arrDatoGeneral);
		
		return plantillafactura;
	}
		
	public void setPlantillaFactura(PlantillaFactura newPlantillaFactura) {
		this.plantillafactura = newPlantillaFactura;
	}
	
	public PlantillaFacturaDataAccess getPlantillaFacturaDataAccess() {
		return plantillafacturaDataAccess;
	}
	
	public void setPlantillaFacturaDataAccess(PlantillaFacturaDataAccess newplantillafacturaDataAccess) {
		this.plantillafacturaDataAccess = newplantillafacturaDataAccess;
	}
	
	public List<PlantillaFactura> getPlantillaFacturas() throws Exception {		
		this.quitarPlantillaFacturasNulos();
		
		PlantillaFacturaLogicAdditional.checkPlantillaFacturaToGets(plantillafacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (PlantillaFactura plantillafacturaLocal: plantillafacturas ) {
			PlantillaFacturaLogicAdditional.updatePlantillaFacturaToGet(plantillafacturaLocal,this.arrDatoGeneral);
		}
		
		return plantillafacturas;
	}
	
	public void setPlantillaFacturas(List<PlantillaFactura> newPlantillaFacturas) {
		this.plantillafacturas = newPlantillaFacturas;
	}
	
	public Object getPlantillaFacturaObject() {	
		this.plantillafacturaObject=this.plantillafacturaDataAccess.getEntityObject();
		return this.plantillafacturaObject;
	}
		
	public void setPlantillaFacturaObject(Object newPlantillaFacturaObject) {
		this.plantillafacturaObject = newPlantillaFacturaObject;
	}
	
	public List<Object> getPlantillaFacturasObject() {		
		this.plantillafacturasObject=this.plantillafacturaDataAccess.getEntitiesObject();
		return this.plantillafacturasObject;
	}
		
	public void setPlantillaFacturasObject(List<Object> newPlantillaFacturasObject) {
		this.plantillafacturasObject = newPlantillaFacturasObject;
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
		
		if(this.plantillafacturaDataAccess!=null) {
			this.plantillafacturaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			plantillafacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			plantillafacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		plantillafactura = new  PlantillaFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
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
		plantillafactura = new  PlantillaFactura();
		  		  
        try {
			
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		plantillafactura = new  PlantillaFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
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
		plantillafactura = new  PlantillaFactura();
		  		  
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
		plantillafactura = new  PlantillaFactura();
		  		  
        try {
			
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		plantillafactura = new  PlantillaFactura();
		  		  
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
		plantillafactura = new  PlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =plantillafacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		plantillafactura = new  PlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=plantillafacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		plantillafactura = new  PlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =plantillafacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		plantillafactura = new  PlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=plantillafacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		plantillafactura = new  PlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =plantillafacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		plantillafactura = new  PlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=plantillafacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		plantillafactura = new  PlantillaFactura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
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
		plantillafactura = new  PlantillaFactura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafactura=plantillafacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		  		  
        try {
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPlantillaFacturasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getTodosPlantillaFacturasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
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
	
	public  void  getTodosPlantillaFacturas(String sFinalQuery,Pagination pagination)throws Exception {
		plantillafacturas = new  ArrayList<PlantillaFactura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlantillaFactura(plantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPlantillaFactura(PlantillaFactura plantillafactura) throws Exception {
		Boolean estaValidado=false;
		
		if(plantillafactura.getIsNew() || plantillafactura.getIsChanged()) { 
			this.invalidValues = plantillafacturaValidator.getInvalidValues(plantillafactura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(plantillafactura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPlantillaFactura(List<PlantillaFactura> PlantillaFacturas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PlantillaFactura plantillafacturaLocal:plantillafacturas) {				
			estaValidadoObjeto=this.validarGuardarPlantillaFactura(plantillafacturaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPlantillaFactura(List<PlantillaFactura> PlantillaFacturas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlantillaFactura(plantillafacturas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPlantillaFactura(PlantillaFactura PlantillaFactura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlantillaFactura(plantillafactura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PlantillaFactura plantillafactura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+plantillafactura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PlantillaFacturaConstantesFunciones.getPlantillaFacturaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"plantillafactura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PlantillaFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PlantillaFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePlantillaFacturaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-savePlantillaFacturaWithConnection");connexion.begin();			
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSave(this.plantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlantillaFacturaLogicAdditional.updatePlantillaFacturaToSave(this.plantillafactura,this.arrDatoGeneral);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.plantillafactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPlantillaFactura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlantillaFactura(this.plantillafactura)) {
				PlantillaFacturaDataAccess.save(this.plantillafactura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSaveAfter(this.plantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlantillaFactura();
			
			connexion.commit();			
			
			if(this.plantillafactura.getIsDeleted()) {
				this.plantillafactura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePlantillaFactura()throws Exception {	
		try {	
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSave(this.plantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlantillaFacturaLogicAdditional.updatePlantillaFacturaToSave(this.plantillafactura,this.arrDatoGeneral);
			
			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.plantillafactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlantillaFactura(this.plantillafactura)) {			
				PlantillaFacturaDataAccess.save(this.plantillafactura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSaveAfter(this.plantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.plantillafactura.getIsDeleted()) {
				this.plantillafactura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePlantillaFacturasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-savePlantillaFacturasWithConnection");connexion.begin();			
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSaves(plantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPlantillaFacturas();
			
			Boolean validadoTodosPlantillaFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlantillaFactura plantillafacturaLocal:plantillafacturas) {		
				if(plantillafacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlantillaFacturaLogicAdditional.updatePlantillaFacturaToSave(plantillafacturaLocal,this.arrDatoGeneral);
	        	
				PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),plantillafacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlantillaFactura(plantillafacturaLocal)) {
					PlantillaFacturaDataAccess.save(plantillafacturaLocal, connexion);				
				} else {
					validadoTodosPlantillaFactura=false;
				}
			}
			
			if(!validadoTodosPlantillaFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSavesAfter(plantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlantillaFacturas();
			
			connexion.commit();		
			
			this.quitarPlantillaFacturasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePlantillaFacturas()throws Exception {				
		 try {	
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSaves(plantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPlantillaFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlantillaFactura plantillafacturaLocal:plantillafacturas) {				
				if(plantillafacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlantillaFacturaLogicAdditional.updatePlantillaFacturaToSave(plantillafacturaLocal,this.arrDatoGeneral);
	        	
				PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),plantillafacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlantillaFactura(plantillafacturaLocal)) {				
					PlantillaFacturaDataAccess.save(plantillafacturaLocal, connexion);				
				} else {
					validadoTodosPlantillaFactura=false;
				}
			}
			
			if(!validadoTodosPlantillaFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlantillaFacturaLogicAdditional.checkPlantillaFacturaToSavesAfter(plantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPlantillaFacturasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlantillaFacturaParameterReturnGeneral procesarAccionPlantillaFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlantillaFactura> plantillafacturas,PlantillaFacturaParameterReturnGeneral plantillafacturaParameterGeneral)throws Exception {
		 try {	
			PlantillaFacturaParameterReturnGeneral plantillafacturaReturnGeneral=new PlantillaFacturaParameterReturnGeneral();
	
			PlantillaFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,plantillafacturas,plantillafacturaParameterGeneral,plantillafacturaReturnGeneral);
			
			return plantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlantillaFacturaParameterReturnGeneral procesarAccionPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlantillaFactura> plantillafacturas,PlantillaFacturaParameterReturnGeneral plantillafacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-procesarAccionPlantillaFacturasWithConnection");connexion.begin();			
			
			PlantillaFacturaParameterReturnGeneral plantillafacturaReturnGeneral=new PlantillaFacturaParameterReturnGeneral();
	
			PlantillaFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,plantillafacturas,plantillafacturaParameterGeneral,plantillafacturaReturnGeneral);
			
			this.connexion.commit();
			
			return plantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlantillaFacturaParameterReturnGeneral procesarEventosPlantillaFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlantillaFactura> plantillafacturas,PlantillaFactura plantillafactura,PlantillaFacturaParameterReturnGeneral plantillafacturaParameterGeneral,Boolean isEsNuevoPlantillaFactura,ArrayList<Classe> clases)throws Exception {
		 try {	
			PlantillaFacturaParameterReturnGeneral plantillafacturaReturnGeneral=new PlantillaFacturaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				plantillafacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlantillaFacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,plantillafacturas,plantillafactura,plantillafacturaParameterGeneral,plantillafacturaReturnGeneral,isEsNuevoPlantillaFactura,clases);
			
			return plantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PlantillaFacturaParameterReturnGeneral procesarEventosPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlantillaFactura> plantillafacturas,PlantillaFactura plantillafactura,PlantillaFacturaParameterReturnGeneral plantillafacturaParameterGeneral,Boolean isEsNuevoPlantillaFactura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-procesarEventosPlantillaFacturasWithConnection");connexion.begin();			
			
			PlantillaFacturaParameterReturnGeneral plantillafacturaReturnGeneral=new PlantillaFacturaParameterReturnGeneral();
	
			plantillafacturaReturnGeneral.setPlantillaFactura(plantillafactura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				plantillafacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlantillaFacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,plantillafacturas,plantillafactura,plantillafacturaParameterGeneral,plantillafacturaReturnGeneral,isEsNuevoPlantillaFactura,clases);
			
			this.connexion.commit();
			
			return plantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlantillaFacturaParameterReturnGeneral procesarImportacionPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PlantillaFacturaParameterReturnGeneral plantillafacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-procesarImportacionPlantillaFacturasWithConnection");connexion.begin();			
			
			PlantillaFacturaParameterReturnGeneral plantillafacturaReturnGeneral=new PlantillaFacturaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.plantillafacturas=new ArrayList<PlantillaFactura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.plantillafactura=new PlantillaFactura();
				
				
				if(conColumnasBase) {this.plantillafactura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.plantillafactura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.plantillafactura.setcodigo(arrColumnas[iColumn++]);
			this.plantillafactura.setnombre(arrColumnas[iColumn++]);
			this.plantillafactura.setdescripcion(arrColumnas[iColumn++]);
				this.plantillafactura.setes_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.plantillafacturas.add(this.plantillafactura);
			}
			
			this.savePlantillaFacturas();
			
			this.connexion.commit();
			
			plantillafacturaReturnGeneral.setConRetornoEstaProcesado(true);
			plantillafacturaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return plantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPlantillaFacturasEliminados() throws Exception {				
		
		List<PlantillaFactura> plantillafacturasAux= new ArrayList<PlantillaFactura>();
		
		for(PlantillaFactura plantillafactura:plantillafacturas) {
			if(!plantillafactura.getIsDeleted()) {
				plantillafacturasAux.add(plantillafactura);
			}
		}
		
		plantillafacturas=plantillafacturasAux;
	}
	
	public void quitarPlantillaFacturasNulos() throws Exception {				
		
		List<PlantillaFactura> plantillafacturasAux= new ArrayList<PlantillaFactura>();
		
		for(PlantillaFactura plantillafactura : this.plantillafacturas) {
			if(plantillafactura==null) {
				plantillafacturasAux.add(plantillafactura);
			}
		}
		
		//this.plantillafacturas=plantillafacturasAux;
		
		this.plantillafacturas.removeAll(plantillafacturasAux);
	}
	
	public void getSetVersionRowPlantillaFacturaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(plantillafactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((plantillafactura.getIsDeleted() || (plantillafactura.getIsChanged()&&!plantillafactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=plantillafacturaDataAccess.getSetVersionRowPlantillaFactura(connexion,plantillafactura.getId());
				
				if(!plantillafactura.getVersionRow().equals(timestamp)) {	
					plantillafactura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				plantillafactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPlantillaFactura()throws Exception {	
		
		if(plantillafactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((plantillafactura.getIsDeleted() || (plantillafactura.getIsChanged()&&!plantillafactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=plantillafacturaDataAccess.getSetVersionRowPlantillaFactura(connexion,plantillafactura.getId());
			
			try {							
				if(!plantillafactura.getVersionRow().equals(timestamp)) {	
					plantillafactura.setVersionRow(timestamp);
				}
				
				plantillafactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPlantillaFacturasWithConnection()throws Exception {	
		if(plantillafacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PlantillaFactura plantillafacturaAux:plantillafacturas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(plantillafacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(plantillafacturaAux.getIsDeleted() || (plantillafacturaAux.getIsChanged()&&!plantillafacturaAux.getIsNew())) {
						
						timestamp=plantillafacturaDataAccess.getSetVersionRowPlantillaFactura(connexion,plantillafacturaAux.getId());
						
						if(!plantillafactura.getVersionRow().equals(timestamp)) {	
							plantillafacturaAux.setVersionRow(timestamp);
						}
								
						plantillafacturaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPlantillaFacturas()throws Exception {	
		if(plantillafacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PlantillaFactura plantillafacturaAux:plantillafacturas) {
					if(plantillafacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(plantillafacturaAux.getIsDeleted() || (plantillafacturaAux.getIsChanged()&&!plantillafacturaAux.getIsNew())) {
						
						timestamp=plantillafacturaDataAccess.getSetVersionRowPlantillaFactura(connexion,plantillafacturaAux.getId());
						
						if(!plantillafacturaAux.getVersionRow().equals(timestamp)) {	
							plantillafacturaAux.setVersionRow(timestamp);
						}
						
													
						plantillafacturaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PlantillaFacturaParameterReturnGeneral cargarCombosLoteForeignKeyPlantillaFacturaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableAplicada,String finalQueryGlobalCuentaContableCreditoBien,String finalQueryGlobalCuentaContableCreditoServicio,String finalQueryGlobalTipoRetencionFuenteBien,String finalQueryGlobalTipoRetencionFuenteServicio,String finalQueryGlobalTipoRetencionIvaBien,String finalQueryGlobalTipoRetencionIvaServicio,String finalQueryGlobalCuentaContableGasto) throws Exception {
		PlantillaFacturaParameterReturnGeneral  plantillafacturaReturnGeneral =new PlantillaFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-cargarCombosLoteForeignKeyPlantillaFacturaWithConnection");connexion.begin();
			
			plantillafacturaReturnGeneral =new PlantillaFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			plantillafacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableaplicadasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableaplicadaLogic=new CuentaContableLogic();
			cuentacontableaplicadaLogic.setConnexion(this.connexion);
			cuentacontableaplicadaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableAplicada.equals("NONE")) {
				cuentacontableaplicadaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableAplicada,new Pagination());
				cuentacontableaplicadasForeignKey=cuentacontableaplicadaLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontableaplicadasForeignKey(cuentacontableaplicadasForeignKey);


			List<CuentaContable> cuentacontablecreditobiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditobienLogic=new CuentaContableLogic();
			cuentacontablecreditobienLogic.setConnexion(this.connexion);
			cuentacontablecreditobienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoBien.equals("NONE")) {
				cuentacontablecreditobienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoBien,new Pagination());
				cuentacontablecreditobiensForeignKey=cuentacontablecreditobienLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablecreditobiensForeignKey(cuentacontablecreditobiensForeignKey);


			List<CuentaContable> cuentacontablecreditoserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoservicioLogic=new CuentaContableLogic();
			cuentacontablecreditoservicioLogic.setConnexion(this.connexion);
			cuentacontablecreditoservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoServicio.equals("NONE")) {
				cuentacontablecreditoservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoServicio,new Pagination());
				cuentacontablecreditoserviciosForeignKey=cuentacontablecreditoservicioLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablecreditoserviciosForeignKey(cuentacontablecreditoserviciosForeignKey);


			List<TipoRetencion> tiporetencionfuentebiensForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuentebienLogic=new TipoRetencionLogic();
			tiporetencionfuentebienLogic.setConnexion(this.connexion);
			tiporetencionfuentebienLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuenteBien.equals("NONE")) {
				tiporetencionfuentebienLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuenteBien,new Pagination());
				tiporetencionfuentebiensForeignKey=tiporetencionfuentebienLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionfuentebiensForeignKey(tiporetencionfuentebiensForeignKey);


			List<TipoRetencion> tiporetencionfuenteserviciosForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuenteservicioLogic=new TipoRetencionLogic();
			tiporetencionfuenteservicioLogic.setConnexion(this.connexion);
			tiporetencionfuenteservicioLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuenteServicio.equals("NONE")) {
				tiporetencionfuenteservicioLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuenteServicio,new Pagination());
				tiporetencionfuenteserviciosForeignKey=tiporetencionfuenteservicioLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionfuenteserviciosForeignKey(tiporetencionfuenteserviciosForeignKey);


			List<TipoRetencion> tiporetencionivabiensForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionivabienLogic=new TipoRetencionLogic();
			tiporetencionivabienLogic.setConnexion(this.connexion);
			tiporetencionivabienLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaBien.equals("NONE")) {
				tiporetencionivabienLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIvaBien,new Pagination());
				tiporetencionivabiensForeignKey=tiporetencionivabienLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionivabiensForeignKey(tiporetencionivabiensForeignKey);


			List<TipoRetencion> tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionivaservicioLogic=new TipoRetencionLogic();
			tiporetencionivaservicioLogic.setConnexion(this.connexion);
			tiporetencionivaservicioLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaServicio.equals("NONE")) {
				tiporetencionivaservicioLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIvaServicio,new Pagination());
				tiporetencionivaserviciosForeignKey=tiporetencionivaservicioLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionivaserviciosForeignKey(tiporetencionivaserviciosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return plantillafacturaReturnGeneral;
	}
	
	public PlantillaFacturaParameterReturnGeneral cargarCombosLoteForeignKeyPlantillaFactura(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableAplicada,String finalQueryGlobalCuentaContableCreditoBien,String finalQueryGlobalCuentaContableCreditoServicio,String finalQueryGlobalTipoRetencionFuenteBien,String finalQueryGlobalTipoRetencionFuenteServicio,String finalQueryGlobalTipoRetencionIvaBien,String finalQueryGlobalTipoRetencionIvaServicio,String finalQueryGlobalCuentaContableGasto) throws Exception {
		PlantillaFacturaParameterReturnGeneral  plantillafacturaReturnGeneral =new PlantillaFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			plantillafacturaReturnGeneral =new PlantillaFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			plantillafacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableaplicadasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableaplicadaLogic=new CuentaContableLogic();
			cuentacontableaplicadaLogic.setConnexion(this.connexion);
			cuentacontableaplicadaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableAplicada.equals("NONE")) {
				cuentacontableaplicadaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableAplicada,new Pagination());
				cuentacontableaplicadasForeignKey=cuentacontableaplicadaLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontableaplicadasForeignKey(cuentacontableaplicadasForeignKey);


			List<CuentaContable> cuentacontablecreditobiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditobienLogic=new CuentaContableLogic();
			cuentacontablecreditobienLogic.setConnexion(this.connexion);
			cuentacontablecreditobienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoBien.equals("NONE")) {
				cuentacontablecreditobienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoBien,new Pagination());
				cuentacontablecreditobiensForeignKey=cuentacontablecreditobienLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablecreditobiensForeignKey(cuentacontablecreditobiensForeignKey);


			List<CuentaContable> cuentacontablecreditoserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoservicioLogic=new CuentaContableLogic();
			cuentacontablecreditoservicioLogic.setConnexion(this.connexion);
			cuentacontablecreditoservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoServicio.equals("NONE")) {
				cuentacontablecreditoservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoServicio,new Pagination());
				cuentacontablecreditoserviciosForeignKey=cuentacontablecreditoservicioLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablecreditoserviciosForeignKey(cuentacontablecreditoserviciosForeignKey);


			List<TipoRetencion> tiporetencionfuentebiensForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuentebienLogic=new TipoRetencionLogic();
			tiporetencionfuentebienLogic.setConnexion(this.connexion);
			tiporetencionfuentebienLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuenteBien.equals("NONE")) {
				tiporetencionfuentebienLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuenteBien,new Pagination());
				tiporetencionfuentebiensForeignKey=tiporetencionfuentebienLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionfuentebiensForeignKey(tiporetencionfuentebiensForeignKey);


			List<TipoRetencion> tiporetencionfuenteserviciosForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuenteservicioLogic=new TipoRetencionLogic();
			tiporetencionfuenteservicioLogic.setConnexion(this.connexion);
			tiporetencionfuenteservicioLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuenteServicio.equals("NONE")) {
				tiporetencionfuenteservicioLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuenteServicio,new Pagination());
				tiporetencionfuenteserviciosForeignKey=tiporetencionfuenteservicioLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionfuenteserviciosForeignKey(tiporetencionfuenteserviciosForeignKey);


			List<TipoRetencion> tiporetencionivabiensForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionivabienLogic=new TipoRetencionLogic();
			tiporetencionivabienLogic.setConnexion(this.connexion);
			tiporetencionivabienLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaBien.equals("NONE")) {
				tiporetencionivabienLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIvaBien,new Pagination());
				tiporetencionivabiensForeignKey=tiporetencionivabienLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionivabiensForeignKey(tiporetencionivabiensForeignKey);


			List<TipoRetencion> tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionivaservicioLogic=new TipoRetencionLogic();
			tiporetencionivaservicioLogic.setConnexion(this.connexion);
			tiporetencionivaservicioLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaServicio.equals("NONE")) {
				tiporetencionivaservicioLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIvaServicio,new Pagination());
				tiporetencionivaserviciosForeignKey=tiporetencionivaservicioLogic.getTipoRetencions();
			}

			plantillafacturaReturnGeneral.settiporetencionivaserviciosForeignKey(tiporetencionivaserviciosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			plantillafacturaReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return plantillafacturaReturnGeneral;
	}
	
	
	public void deepLoad(PlantillaFactura plantillafactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PlantillaFacturaLogicAdditional.updatePlantillaFacturaToGet(plantillafactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
		plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
		plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
		plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
		plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
		plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
		plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
		plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
		plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
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
			plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(plantillafactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
		CuentaContableLogic cuentacontableaplicadaLogic= new CuentaContableLogic(connexion);
		cuentacontableaplicadaLogic.deepLoad(plantillafactura.getCuentaContableAplicada(),isDeep,deepLoadType,clases);
				
		plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
		CuentaContableLogic cuentacontablecreditobienLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditobienLogic.deepLoad(plantillafactura.getCuentaContableCreditoBien(),isDeep,deepLoadType,clases);
				
		plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
		CuentaContableLogic cuentacontablecreditoservicioLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoservicioLogic.deepLoad(plantillafactura.getCuentaContableCreditoServicio(),isDeep,deepLoadType,clases);
				
		plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
		TipoRetencionLogic tiporetencionfuentebienLogic= new TipoRetencionLogic(connexion);
		tiporetencionfuentebienLogic.deepLoad(plantillafactura.getTipoRetencionFuenteBien(),isDeep,deepLoadType,clases);
				
		plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
		TipoRetencionLogic tiporetencionfuenteservicioLogic= new TipoRetencionLogic(connexion);
		tiporetencionfuenteservicioLogic.deepLoad(plantillafactura.getTipoRetencionFuenteServicio(),isDeep,deepLoadType,clases);
				
		plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
		TipoRetencionLogic tiporetencionivabienLogic= new TipoRetencionLogic(connexion);
		tiporetencionivabienLogic.deepLoad(plantillafactura.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				
		plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
		TipoRetencionLogic tiporetencionivaservicioLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaservicioLogic.deepLoad(plantillafactura.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				
		plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(plantillafactura.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(plantillafactura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableAplicada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableCreditoBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableCreditoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionFuenteBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionFuenteServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
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
			plantillafactura.setEmpresa(plantillafacturaDataAccess.getEmpresa(connexion,plantillafactura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(plantillafactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableAplicada(plantillafacturaDataAccess.getCuentaContableAplicada(connexion,plantillafactura));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableAplicada(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableCreditoBien(plantillafacturaDataAccess.getCuentaContableCreditoBien(connexion,plantillafactura));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableCreditoBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableCreditoServicio(plantillafacturaDataAccess.getCuentaContableCreditoServicio(connexion,plantillafactura));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableCreditoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionFuenteBien(plantillafacturaDataAccess.getTipoRetencionFuenteBien(connexion,plantillafactura));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionFuenteBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionFuenteServicio(plantillafacturaDataAccess.getTipoRetencionFuenteServicio(connexion,plantillafactura));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionFuenteServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionIvaBien(plantillafacturaDataAccess.getTipoRetencionIvaBien(connexion,plantillafactura));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setTipoRetencionIvaServicio(plantillafacturaDataAccess.getTipoRetencionIvaServicio(connexion,plantillafactura));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(plantillafactura.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			plantillafactura.setCuentaContableGasto(plantillafacturaDataAccess.getCuentaContableGasto(connexion,plantillafactura));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(plantillafactura.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PlantillaFactura plantillafactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PlantillaFacturaLogicAdditional.updatePlantillaFacturaToSave(plantillafactura,this.arrDatoGeneral);
			
PlantillaFacturaDataAccess.save(plantillafactura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(plantillafactura.getEmpresa(),connexion);

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableAplicada(),connexion);

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoBien(),connexion);

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoServicio(),connexion);

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteBien(),connexion);

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteServicio(),connexion);

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaBien(),connexion);

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaServicio(),connexion);

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableGasto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(plantillafactura.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableAplicada(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoBien(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteBien(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaBien(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableGasto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(plantillafactura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(plantillafactura.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableAplicada(),connexion);
		CuentaContableLogic cuentacontableaplicadaLogic= new CuentaContableLogic(connexion);
		cuentacontableaplicadaLogic.deepLoad(plantillafactura.getCuentaContableAplicada(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoBien(),connexion);
		CuentaContableLogic cuentacontablecreditobienLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditobienLogic.deepLoad(plantillafactura.getCuentaContableCreditoBien(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoServicio(),connexion);
		CuentaContableLogic cuentacontablecreditoservicioLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoservicioLogic.deepLoad(plantillafactura.getCuentaContableCreditoServicio(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteBien(),connexion);
		TipoRetencionLogic tiporetencionfuentebienLogic= new TipoRetencionLogic(connexion);
		tiporetencionfuentebienLogic.deepLoad(plantillafactura.getTipoRetencionFuenteBien(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteServicio(),connexion);
		TipoRetencionLogic tiporetencionfuenteservicioLogic= new TipoRetencionLogic(connexion);
		tiporetencionfuenteservicioLogic.deepLoad(plantillafactura.getTipoRetencionFuenteServicio(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaBien(),connexion);
		TipoRetencionLogic tiporetencionivabienLogic= new TipoRetencionLogic(connexion);
		tiporetencionivabienLogic.deepLoad(plantillafactura.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaServicio(),connexion);
		TipoRetencionLogic tiporetencionivaservicioLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaservicioLogic.deepLoad(plantillafactura.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(plantillafactura.getCuentaContableGasto(),connexion);
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(plantillafactura.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(plantillafactura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(plantillafactura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableAplicada(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(plantillafactura.getCuentaContableAplicada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoBien(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(plantillafactura.getCuentaContableCreditoBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableCreditoServicio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(plantillafactura.getCuentaContableCreditoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteBien(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(plantillafactura.getTipoRetencionFuenteBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionFuenteServicio(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(plantillafactura.getTipoRetencionFuenteServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaBien(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(plantillafactura.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(plantillafactura.getTipoRetencionIvaServicio(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(plantillafactura.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(plantillafactura.getCuentaContableGasto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(plantillafactura.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PlantillaFactura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(plantillafactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(plantillafactura);
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
			this.deepLoad(this.plantillafactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PlantillaFactura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(plantillafacturas!=null) {
				for(PlantillaFactura plantillafactura:plantillafacturas) {
					this.deepLoad(plantillafactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(plantillafacturas);
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
			if(plantillafacturas!=null) {
				for(PlantillaFactura plantillafactura:plantillafacturas) {
					this.deepLoad(plantillafactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(plantillafacturas);
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
			this.getNewConnexionToDeep(PlantillaFactura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(plantillafactura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PlantillaFactura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(plantillafacturas!=null) {
				for(PlantillaFactura plantillafactura:plantillafacturas) {
					this.deepSave(plantillafactura,isDeep,deepLoadType,clases);
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
			if(plantillafacturas!=null) {
				for(PlantillaFactura plantillafactura:plantillafacturas) {
					this.deepSave(plantillafactura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPlantillaFacturasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PlantillaFacturaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PlantillaFacturaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PlantillaFacturaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PlantillaFacturaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_aplicada)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableAplicada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableAplicada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_aplicada,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableAplicada);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_aplicada)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableAplicada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableAplicada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_aplicada,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableAplicada);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCreditoBienWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_bien,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCreditoBien(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_bien,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCreditoFinServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_servicio,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFinServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableCreditoFinServicio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_servicio,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFinServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableGastoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdCuentaContableGasto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionFuenteBienWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuenteBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuenteBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente_bien,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuenteBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuenteBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionFuenteBien(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuenteBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuenteBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente_bien,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuenteBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuenteBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionFuenteServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuenteServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuenteServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente_servicio,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuenteServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuenteServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionFuenteServicio(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuenteServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuenteServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente_servicio,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuenteServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuenteServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionIvaBienWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_bien,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionIvaBien(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_bien,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaBien);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionIvaServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_servicio,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturasFK_IdTipoRetencionIvaServicio(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_servicio,PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaServicio);

			PlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			plantillafacturas=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlantillaFacturaPorIdEmpresaPorCodigoWithConnection(Long id_empresa,String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,PlantillaFacturaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			plantillafactura=plantillafacturaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlantillaFacturaPorIdEmpresaPorCodigo(Long id_empresa,String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,PlantillaFacturaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			plantillafactura=plantillafacturaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.plantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesPlantillaFactura(this.plantillafactura);
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
			if(PlantillaFacturaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PlantillaFacturaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PlantillaFactura plantillafactura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PlantillaFacturaConstantesFunciones.ISCONAUDITORIA) {
				if(plantillafactura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlantillaFacturaDataAccess.TABLENAME, plantillafactura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlantillaFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlantillaFacturaLogic.registrarAuditoriaDetallesPlantillaFactura(connexion,plantillafactura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(plantillafactura.getIsDeleted()) {
					/*if(!plantillafactura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PlantillaFacturaDataAccess.TABLENAME, plantillafactura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PlantillaFacturaLogic.registrarAuditoriaDetallesPlantillaFactura(connexion,plantillafactura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlantillaFacturaDataAccess.TABLENAME, plantillafactura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(plantillafactura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlantillaFacturaDataAccess.TABLENAME, plantillafactura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlantillaFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlantillaFacturaLogic.registrarAuditoriaDetallesPlantillaFactura(connexion,plantillafactura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPlantillaFactura(Connexion connexion,PlantillaFactura plantillafactura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_empresa().equals(plantillafactura.getPlantillaFacturaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_empresa()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_empresa().toString();
				}
				if(plantillafactura.getid_empresa()!=null)
				{
					strValorNuevo=plantillafactura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getcodigo().equals(plantillafactura.getPlantillaFacturaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getcodigo()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getcodigo();
				}
				if(plantillafactura.getcodigo()!=null)
				{
					strValorNuevo=plantillafactura.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getnombre().equals(plantillafactura.getPlantillaFacturaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getnombre()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getnombre();
				}
				if(plantillafactura.getnombre()!=null)
				{
					strValorNuevo=plantillafactura.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getdescripcion().equals(plantillafactura.getPlantillaFacturaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getdescripcion()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getdescripcion();
				}
				if(plantillafactura.getdescripcion()!=null)
				{
					strValorNuevo=plantillafactura.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getes_proveedor().equals(plantillafactura.getPlantillaFacturaOriginal().getes_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getes_proveedor()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getes_proveedor().toString();
				}
				if(plantillafactura.getes_proveedor()!=null)
				{
					strValorNuevo=plantillafactura.getes_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.ESPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_cuenta_contable_aplicada().equals(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_aplicada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_aplicada()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_aplicada().toString();
				}
				if(plantillafactura.getid_cuenta_contable_aplicada()!=null)
				{
					strValorNuevo=plantillafactura.getid_cuenta_contable_aplicada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_cuenta_contable_credito_bien().equals(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_bien()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_bien().toString();
				}
				if(plantillafactura.getid_cuenta_contable_credito_bien()!=null)
				{
					strValorNuevo=plantillafactura.getid_cuenta_contable_credito_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_cuenta_contable_credito_servicio().equals(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_servicio()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_credito_servicio().toString();
				}
				if(plantillafactura.getid_cuenta_contable_credito_servicio()!=null)
				{
					strValorNuevo=plantillafactura.getid_cuenta_contable_credito_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_tipo_retencion_fuente_bien().equals(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_bien()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_bien().toString();
				}
				if(plantillafactura.getid_tipo_retencion_fuente_bien()!=null)
				{
					strValorNuevo=plantillafactura.getid_tipo_retencion_fuente_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_tipo_retencion_fuente_servicio().equals(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_servicio()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_fuente_servicio().toString();
				}
				if(plantillafactura.getid_tipo_retencion_fuente_servicio()!=null)
				{
					strValorNuevo=plantillafactura.getid_tipo_retencion_fuente_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_tipo_retencion_iva_bien().equals(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_bien()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_bien().toString();
				}
				if(plantillafactura.getid_tipo_retencion_iva_bien()!=null)
				{
					strValorNuevo=plantillafactura.getid_tipo_retencion_iva_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_tipo_retencion_iva_servicio().equals(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_servicio()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_tipo_retencion_iva_servicio().toString();
				}
				if(plantillafactura.getid_tipo_retencion_iva_servicio()!=null)
				{
					strValorNuevo=plantillafactura.getid_tipo_retencion_iva_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(plantillafactura.getIsNew()||!plantillafactura.getid_cuenta_contable_gasto().equals(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_gasto()!=null)
				{
					strValorActual=plantillafactura.getPlantillaFacturaOriginal().getid_cuenta_contable_gasto().toString();
				}
				if(plantillafactura.getid_cuenta_contable_gasto()!=null)
				{
					strValorNuevo=plantillafactura.getid_cuenta_contable_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePlantillaFacturaRelacionesWithConnection(PlantillaFactura plantillafactura) throws Exception {

		if(!plantillafactura.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlantillaFacturaRelacionesBase(plantillafactura,true);
		}
	}

	public void savePlantillaFacturaRelaciones(PlantillaFactura plantillafactura)throws Exception {

		if(!plantillafactura.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlantillaFacturaRelacionesBase(plantillafactura,false);
		}
	}

	public void savePlantillaFacturaRelacionesBase(PlantillaFactura plantillafactura,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PlantillaFactura-saveRelacionesWithConnection");}
	

			this.setPlantillaFactura(plantillafactura);

			if(PlantillaFacturaLogicAdditional.validarSaveRelaciones(plantillafactura,this)) {

				PlantillaFacturaLogicAdditional.updateRelacionesToSave(plantillafactura,this);

				if((plantillafactura.getIsNew()||plantillafactura.getIsChanged())&&!plantillafactura.getIsDeleted()) {
					this.savePlantillaFactura();
					this.savePlantillaFacturaRelacionesDetalles();

				} else if(plantillafactura.getIsDeleted()) {
					this.savePlantillaFacturaRelacionesDetalles();
					this.savePlantillaFactura();
				}

				PlantillaFacturaLogicAdditional.updateRelacionesToSaveAfter(plantillafactura,this);

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
	
	
	private void savePlantillaFacturaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlantillaFacturaConstantesFunciones.getClassesForeignKeysOfPlantillaFactura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlantillaFacturaConstantesFunciones.getClassesRelationshipsOfPlantillaFactura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
