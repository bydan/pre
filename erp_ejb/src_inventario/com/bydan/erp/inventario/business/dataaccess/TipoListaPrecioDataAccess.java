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
package com.bydan.erp.inventario.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//TipoListaPrecioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class TipoListaPrecioDataAccess extends  TipoListaPrecioDataAccessAdditional{ //TipoListaPrecioDataAccessAdditional,DataAccessHelper<TipoListaPrecio>
	//static Logger logger = Logger.getLogger(TipoListaPrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_lista_precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,fecha_desde,fecha_hasta,esta_activo,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,fecha_desde=?,fecha_hasta=?,esta_activo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipolistaprecio from "+TipoListaPrecioConstantesFunciones.SPERSISTENCENAME+" tipolistaprecio";
	public static String QUERYSELECTNATIVE="select "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".id,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".id_empresa,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".codigo,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".nombre,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".fecha_desde,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".fecha_hasta,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".esta_activo,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".descripcion from "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME;//+" as "+TipoListaPrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".id,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".codigo from "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME;//+" as "+TipoListaPrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,fecha_desde=?,fecha_hasta=?,esta_activo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOLISTAPRECIO_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOLISTAPRECIO_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOLISTAPRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOLISTAPRECIO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected TipoListaPrecioDataAccessAdditional tipolistaprecioDataAccessAdditional=null;
	
	public TipoListaPrecioDataAccessAdditional getTipoListaPrecioDataAccessAdditional() {
		return this.tipolistaprecioDataAccessAdditional;
	}
	
	public void setTipoListaPrecioDataAccessAdditional(TipoListaPrecioDataAccessAdditional tipolistaprecioDataAccessAdditional) {
		try {
			this.tipolistaprecioDataAccessAdditional=tipolistaprecioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoListaPrecioDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		TipoListaPrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoListaPrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoListaPrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setTipoListaPrecioOriginal(TipoListaPrecio tipolistaprecio)throws Exception  {
		tipolistaprecio.setTipoListaPrecioOriginal((TipoListaPrecio)tipolistaprecio.clone());		
	}
	
	public void setTipoListaPreciosOriginal(List<TipoListaPrecio> tipolistaprecios)throws Exception  {
		
		for(TipoListaPrecio tipolistaprecio:tipolistaprecios){
			tipolistaprecio.setTipoListaPrecioOriginal((TipoListaPrecio)tipolistaprecio.clone());
		}
	}
	
	public static void setTipoListaPrecioOriginalStatic(TipoListaPrecio tipolistaprecio)throws Exception  {
		tipolistaprecio.setTipoListaPrecioOriginal((TipoListaPrecio)tipolistaprecio.clone());		
	}
	
	public static void setTipoListaPreciosOriginalStatic(List<TipoListaPrecio> tipolistaprecios)throws Exception  {
		
		for(TipoListaPrecio tipolistaprecio:tipolistaprecios){
			tipolistaprecio.setTipoListaPrecioOriginal((TipoListaPrecio)tipolistaprecio.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  TipoListaPrecio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  TipoListaPrecio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoListaPrecio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoListaPrecioOriginal(new TipoListaPrecio());
      	    	entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoListaPrecio("",entity,resultSet); 
				
				//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoListaPrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoListaPrecio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoListaPrecio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoListaPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoListaPrecio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoListaPrecioOriginal(new TipoListaPrecio());
      	    	entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoListaPrecio("",entity,resultSet);    
				
				//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoListaPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoListaPrecio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoListaPrecio entity = new TipoListaPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoListaPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoListaPrecio.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseTipoListaPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoListaPrecio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoListaPrecio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoListaPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoListaPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoListaPrecio("",entity,resultSet);
      	    	
				//entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
      	    	//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoListaPrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoListaPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoListaPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoListaPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoListaPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoListaPrecio();
					//entity.setMapTipoListaPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoListaPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoListaPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
					entity=TipoListaPrecioDataAccess.getEntityTipoListaPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
					////entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoListaPrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoListaPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoListaPrecio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoListaPrecio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoListaPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoListaPrecio();
					//entity.setMapTipoListaPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoListaPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoListaPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
					entity=TipoListaPrecioDataAccess.getEntityTipoListaPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
					////entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoListaPrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoListaPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoListaPrecio getEntityTipoListaPrecio(String strPrefijo,TipoListaPrecio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoListaPrecio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoListaPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoListaPrecioDataAccess.setFieldReflectionTipoListaPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoListaPrecio=TipoListaPrecioConstantesFunciones.getTodosTiposColumnasTipoListaPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoListaPrecio) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = TipoListaPrecio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoListaPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoListaPrecioDataAccess.setFieldReflectionTipoListaPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoListaPrecio(Field field,String strPrefijo,String sColumn,TipoListaPrecio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoListaPrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.FECHADESDE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TipoListaPrecioConstantesFunciones.FECHAHASTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TipoListaPrecioConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoListaPrecioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoListaPrecio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoListaPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new TipoListaPrecio();
					entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoListaPrecio("",entity,resultSet);
					
					//entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
					//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoListaPrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoListaPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoListaPrecio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoListaPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoListaPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<TipoListaPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoListaPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoListaPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoListaPrecio("",entity,resultSet);
      	    	
				//entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
      	    	//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoListaPrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoListaPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoListaPrecio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoListaPrecio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoListaPrecio> entities = new  ArrayList<TipoListaPrecio>();
		TipoListaPrecio entity = new TipoListaPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoListaPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoListaPrecio("",entity,resultSet);
      	    	
				//entity.setTipoListaPrecioOriginal( new TipoListaPrecio());
      	    	//entity.setTipoListaPrecioOriginal(super.getEntity("",entity.getTipoListaPrecioOriginal(),resultSet,TipoListaPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoListaPrecioOriginal(this.getEntityTipoListaPrecio("",entity.getTipoListaPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoListaPrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoListaPrecio getEntityTipoListaPrecio(String strPrefijo,TipoListaPrecio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoListaPrecioConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoListaPrecioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoListaPrecioConstantesFunciones.NOMBRE));
				entity.setfecha_desde(new Date(resultSet.getDate(strPrefijo+TipoListaPrecioConstantesFunciones.FECHADESDE).getTime()));
				entity.setfecha_hasta(new Date(resultSet.getDate(strPrefijo+TipoListaPrecioConstantesFunciones.FECHAHASTA).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+TipoListaPrecioConstantesFunciones.ESTAACTIVO));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoListaPrecioConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoListaPrecioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoListaPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoListaPrecio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoListaPrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoListaPrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoListaPrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoListaPrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoListaPrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoListaPrecioDataAccess.TABLENAME,TipoListaPrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoListaPrecioDataAccess.setTipoListaPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoListaPrecio reltipolistaprecio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipolistaprecio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Cliente> getClientes(Connexion connexion,TipoListaPrecio tipolistaprecio)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_tipo_lista_precio="+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio.id WHERE "+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio.id="+String.valueOf(tipolistaprecio.getId());
			} else {
				sQuery=" INNER JOIN cliente.TipoListaPrecio WHERE cliente.TipoListaPrecio.id="+String.valueOf(tipolistaprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos(Connexion connexion,TipoListaPrecio tipolistaprecio)throws SQLException,Exception {

		List<ParametroCarteraDefecto> parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio ON "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+".parametro_cartera_defecto.id_tipo_lista_precio="+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio.id WHERE "+TipoListaPrecioConstantesFunciones.SCHEMA+".tipo_lista_precio.id="+String.valueOf(tipolistaprecio.getId());
			} else {
				sQuery=" INNER JOIN parametrocarteradefecto.TipoListaPrecio WHERE parametrocarteradefecto.TipoListaPrecio.id="+String.valueOf(tipolistaprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess=new ParametroCarteraDefectoDataAccess();

			parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarteradefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoListaPrecio tipolistaprecio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipolistaprecio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipolistaprecio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipolistaprecio.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipolistaprecio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_desde=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_desde.setValue(tipolistaprecio.getfecha_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_hasta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_hasta.setValue(tipolistaprecio.getfecha_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(tipolistaprecio.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipolistaprecio.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipolistaprecio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipolistaprecio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipolistaprecio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipolistaprecio.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseTipoListaPrecio(TipoListaPrecio tipolistaprecio)throws Exception  {		
		tipolistaprecio.setIsNew(false);
		tipolistaprecio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoListaPrecios(List<TipoListaPrecio> tipolistaprecios)throws Exception  {				
		for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
			tipolistaprecio.setIsNew(false);
			tipolistaprecio.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoListaPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
