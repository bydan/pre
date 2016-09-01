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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//ParametroFactuEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class ParametroFactuEmpresaDataAccess extends  ParametroFactuEmpresaDataAccessAdditional{ //ParametroFactuEmpresaDataAccessAdditional,DataAccessHelper<ParametroFactuEmpresa>
	//static Logger logger = Logger.getLogger(ParametroFactuEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_factu_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empresa_origen,id_sucursal,id_transaccion_origen,id_bodega_origen,id_cliente_origen,costo_origen,id_empresa_destino,id_sucursal_destino,id_transaccion_destino,id_bodega_destino,id_cliente_destino,costo_destino,con_transferencia,id_empresa_multi_destino,id_sucursal_multi_destino,id_transaccion_multi_destino,id_bodega_multi_origen,id_bodega_multi_destino)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empresa_origen=?,id_sucursal=?,id_transaccion_origen=?,id_bodega_origen=?,id_cliente_origen=?,costo_origen=?,id_empresa_destino=?,id_sucursal_destino=?,id_transaccion_destino=?,id_bodega_destino=?,id_cliente_destino=?,costo_destino=?,con_transferencia=?,id_empresa_multi_destino=?,id_sucursal_multi_destino=?,id_transaccion_multi_destino=?,id_bodega_multi_origen=?,id_bodega_multi_destino=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofactuempresa from "+ParametroFactuEmpresaConstantesFunciones.SPERSISTENCENAME+" parametrofactuempresa";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_cliente_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".costo_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_cliente_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".costo_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".con_transferencia,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_multi_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_multi_destino from "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME;//+" as "+ParametroFactuEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".version_row from "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME;//+" as "+ParametroFactuEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empresa_origen=?,id_sucursal=?,id_transaccion_origen=?,id_bodega_origen=?,id_cliente_origen=?,costo_origen=?,id_empresa_destino=?,id_sucursal_destino=?,id_transaccion_destino=?,id_bodega_destino=?,id_cliente_destino=?,costo_destino=?,con_transferencia=?,id_empresa_multi_destino=?,id_sucursal_multi_destino=?,id_transaccion_multi_destino=?,id_bodega_multi_origen=?,id_bodega_multi_destino=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTUEMPRESA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTUEMPRESA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTUEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTUEMPRESA_SELECT(?,?)";
	
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
	
	
	protected ParametroFactuEmpresaDataAccessAdditional parametrofactuempresaDataAccessAdditional=null;
	
	public ParametroFactuEmpresaDataAccessAdditional getParametroFactuEmpresaDataAccessAdditional() {
		return this.parametrofactuempresaDataAccessAdditional;
	}
	
	public void setParametroFactuEmpresaDataAccessAdditional(ParametroFactuEmpresaDataAccessAdditional parametrofactuempresaDataAccessAdditional) {
		try {
			this.parametrofactuempresaDataAccessAdditional=parametrofactuempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFactuEmpresaDataAccess() {
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
		ParametroFactuEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFactuEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFactuEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFactuEmpresaOriginal(ParametroFactuEmpresa parametrofactuempresa)throws Exception  {
		parametrofactuempresa.setParametroFactuEmpresaOriginal((ParametroFactuEmpresa)parametrofactuempresa.clone());		
	}
	
	public void setParametroFactuEmpresasOriginal(List<ParametroFactuEmpresa> parametrofactuempresas)throws Exception  {
		
		for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas){
			parametrofactuempresa.setParametroFactuEmpresaOriginal((ParametroFactuEmpresa)parametrofactuempresa.clone());
		}
	}
	
	public static void setParametroFactuEmpresaOriginalStatic(ParametroFactuEmpresa parametrofactuempresa)throws Exception  {
		parametrofactuempresa.setParametroFactuEmpresaOriginal((ParametroFactuEmpresa)parametrofactuempresa.clone());		
	}
	
	public static void setParametroFactuEmpresasOriginalStatic(List<ParametroFactuEmpresa> parametrofactuempresas)throws Exception  {
		
		for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas){
			parametrofactuempresa.setParametroFactuEmpresaOriginal((ParametroFactuEmpresa)parametrofactuempresa.clone());
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
	
	public  ParametroFactuEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		
		
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
	
	public  ParametroFactuEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFactuEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFactuEmpresaOriginal(new ParametroFactuEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuEmpresa("",entity,resultSet); 
				
				//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFactuEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();
				
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
	
	public  ParametroFactuEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFactuEmpresaOriginal(new ParametroFactuEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuEmpresa("",entity,resultSet);    
				
				//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFactuEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFactuEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFactuEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		
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
	
	public  List<ParametroFactuEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuEmpresa("",entity,resultSet);
      	    	
				//entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
      	    	//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
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
	
	public  List<ParametroFactuEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuEmpresa();
					//entity.setMapParametroFactuEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFactuEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuEmpresaDataAccess.getEntityParametroFactuEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
					////entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFactuEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
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
	
	public  ParametroFactuEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuEmpresa();
					//entity.setMapParametroFactuEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFactuEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuEmpresaDataAccess.getEntityParametroFactuEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
					////entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFactuEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFactuEmpresa getEntityParametroFactuEmpresa(String strPrefijo,ParametroFactuEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFactuEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFactuEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFactuEmpresaDataAccess.setFieldReflectionParametroFactuEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFactuEmpresa=ParametroFactuEmpresaConstantesFunciones.getTodosTiposColumnasParametroFactuEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFactuEmpresa) {
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
							field = ParametroFactuEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFactuEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFactuEmpresaDataAccess.setFieldReflectionParametroFactuEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFactuEmpresa(Field field,String strPrefijo,String sColumn,ParametroFactuEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFactuEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.COSTODESTINO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFactuEmpresa();
					entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFactuEmpresa("",entity,resultSet);
					
					//entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
					//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFactuEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFactuEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
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
	
	public  List<ParametroFactuEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuEmpresa("",entity,resultSet);
      	    	
				//entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
      	    	//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFactuEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
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
	
	public  List<ParametroFactuEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuEmpresa> entities = new  ArrayList<ParametroFactuEmpresa>();
		ParametroFactuEmpresa entity = new ParametroFactuEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuEmpresa("",entity,resultSet);
      	    	
				//entity.setParametroFactuEmpresaOriginal( new ParametroFactuEmpresa());
      	    	//entity.setParametroFactuEmpresaOriginal(super.getEntity("",entity.getParametroFactuEmpresaOriginal(),resultSet,ParametroFactuEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuEmpresaOriginal(this.getEntityParametroFactuEmpresa("",entity.getParametroFactuEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFactuEmpresa getEntityParametroFactuEmpresa(String strPrefijo,ParametroFactuEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDEMPRESA));
				entity.setid_empresa_origen(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL));
				entity.setid_transaccion_origen(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN));
				entity.setid_bodega_origen(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN));
				entity.setid_cliente_origen(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN));
				entity.setcosto_origen(resultSet.getDouble(strPrefijo+ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN));
				entity.setid_empresa_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO));
				entity.setid_sucursal_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO));
				entity.setid_transaccion_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO));
				entity.setid_bodega_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO));
				entity.setid_cliente_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO));
				entity.setcosto_destino(resultSet.getDouble(strPrefijo+ParametroFactuEmpresaConstantesFunciones.COSTODESTINO));
				entity.setcon_transferencia(resultSet.getBoolean(strPrefijo+ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA));
				entity.setid_empresa_multi_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO));
				entity.setid_sucursal_multi_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO));
				entity.setid_transaccion_multi_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO));
				entity.setid_bodega_multi_origen(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN));
				entity.setid_bodega_multi_destino(resultSet.getLong(strPrefijo+ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFactuEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFactuEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFactuEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFactuEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFactuEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFactuEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFactuEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFactuEmpresaDataAccess.TABLENAME,ParametroFactuEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFactuEmpresaDataAccess.setParametroFactuEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empresa getEmpresaOrigen(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_empresa_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactuempresa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Transaccion getTransaccionOrigen(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactuempresa.getid_transaccion_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Bodega getBodegaOrigen(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_bodega_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Cliente getClienteOrigen(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relparametrofactuempresa.getid_cliente_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empresa getEmpresaDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_empresa_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursalDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactuempresa.getid_sucursal_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Transaccion getTransaccionDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactuempresa.getid_transaccion_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Bodega getBodegaDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_bodega_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Cliente getClienteDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relparametrofactuempresa.getid_cliente_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empresa getEmpresaMultiDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_empresa_multi_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursalMultiDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactuempresa.getid_sucursal_multi_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Transaccion getTransaccionMultiDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactuempresa.getid_transaccion_multi_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Bodega getBodegaMultiOrigen(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_bodega_multi_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Bodega getBodegaMultiDestino(Connexion connexion,ParametroFactuEmpresa relparametrofactuempresa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactuempresa.getid_bodega_multi_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofactuempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofactuempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa_origen.setValue(parametrofactuempresa.getid_empresa_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofactuempresa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_origen.setValue(parametrofactuempresa.getid_transaccion_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_origen.setValue(parametrofactuempresa.getid_bodega_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_origen.setValue(parametrofactuempresa.getid_cliente_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_origen=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_origen.setValue(parametrofactuempresa.getcosto_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa_destino.setValue(parametrofactuempresa.getid_empresa_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_destino.setValue(parametrofactuempresa.getid_sucursal_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_destino.setValue(parametrofactuempresa.getid_transaccion_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_destino.setValue(parametrofactuempresa.getid_bodega_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_destino.setValue(parametrofactuempresa.getid_cliente_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_destino=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_destino.setValue(parametrofactuempresa.getcosto_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_transferencia=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_transferencia.setValue(parametrofactuempresa.getcon_transferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_transferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa_multi_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa_multi_destino.setValue(parametrofactuempresa.getid_empresa_multi_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa_multi_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_multi_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_multi_destino.setValue(parametrofactuempresa.getid_sucursal_multi_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_multi_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_multi_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_multi_destino.setValue(parametrofactuempresa.getid_transaccion_multi_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_multi_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_multi_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_multi_origen.setValue(parametrofactuempresa.getid_bodega_multi_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_multi_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_multi_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_multi_destino.setValue(parametrofactuempresa.getid_bodega_multi_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_multi_destino);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofactuempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofactuempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofactuempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofactuempresa.getId());
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
	
	public void setIsNewIsChangedFalseParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa)throws Exception  {		
		parametrofactuempresa.setIsNew(false);
		parametrofactuempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFactuEmpresas(List<ParametroFactuEmpresa> parametrofactuempresas)throws Exception  {				
		for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
			parametrofactuempresa.setIsNew(false);
			parametrofactuempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFactuEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
