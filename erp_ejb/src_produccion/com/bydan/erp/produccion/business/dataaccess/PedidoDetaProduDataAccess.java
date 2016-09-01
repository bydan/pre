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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//PedidoDetaProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class PedidoDetaProduDataAccess extends  PedidoDetaProduDataAccessAdditional{ //PedidoDetaProduDataAccessAdditional,DataAccessHelper<PedidoDetaProdu>
	//static Logger logger = Logger.getLogger(PedidoDetaProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_deta_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_pedido_produ,id_bodega,id_producto,id_unidad,id_bodega_destino,id_tipo_proceso_produ,cantidad,cantidad_pendiente,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_pedido_produ=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_destino=?,id_tipo_proceso_produ=?,cantidad=?,cantidad_pendiente=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidodetaprodu from "+PedidoDetaProduConstantesFunciones.SPERSISTENCENAME+" pedidodetaprodu";
	public static String QUERYSELECTNATIVE="select "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".version_row,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_empresa,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_periodo,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_pedido_produ,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_producto,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_bodega_destino,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_tipo_proceso_produ,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".cantidad,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".cantidad_pendiente,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".descripcion from "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME;//+" as "+PedidoDetaProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".version_row from "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME;//+" as "+PedidoDetaProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_pedido_produ=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_destino=?,id_tipo_proceso_produ=?,cantidad=?,cantidad_pendiente=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDODETAPRODU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDODETAPRODU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDODETAPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDODETAPRODU_SELECT(?,?)";
	
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
	
	
	protected PedidoDetaProduDataAccessAdditional pedidodetaproduDataAccessAdditional=null;
	
	public PedidoDetaProduDataAccessAdditional getPedidoDetaProduDataAccessAdditional() {
		return this.pedidodetaproduDataAccessAdditional;
	}
	
	public void setPedidoDetaProduDataAccessAdditional(PedidoDetaProduDataAccessAdditional pedidodetaproduDataAccessAdditional) {
		try {
			this.pedidodetaproduDataAccessAdditional=pedidodetaproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoDetaProduDataAccess() {
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
		PedidoDetaProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoDetaProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoDetaProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoDetaProduOriginal(PedidoDetaProdu pedidodetaprodu)throws Exception  {
		pedidodetaprodu.setPedidoDetaProduOriginal((PedidoDetaProdu)pedidodetaprodu.clone());		
	}
	
	public void setPedidoDetaProdusOriginal(List<PedidoDetaProdu> pedidodetaprodus)throws Exception  {
		
		for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus){
			pedidodetaprodu.setPedidoDetaProduOriginal((PedidoDetaProdu)pedidodetaprodu.clone());
		}
	}
	
	public static void setPedidoDetaProduOriginalStatic(PedidoDetaProdu pedidodetaprodu)throws Exception  {
		pedidodetaprodu.setPedidoDetaProduOriginal((PedidoDetaProdu)pedidodetaprodu.clone());		
	}
	
	public static void setPedidoDetaProdusOriginalStatic(List<PedidoDetaProdu> pedidodetaprodus)throws Exception  {
		
		for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus){
			pedidodetaprodu.setPedidoDetaProduOriginal((PedidoDetaProdu)pedidodetaprodu.clone());
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
	
	public  PedidoDetaProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();		
		
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
	
	public  PedidoDetaProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.PedidoDetaProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoDetaProduOriginal(new PedidoDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoDetaProdu("",entity,resultSet); 
				
				//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoDetaProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoDetaProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();
				
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
	
	public  PedidoDetaProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.PedidoDetaProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoDetaProduOriginal(new PedidoDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoDetaProdu("",entity,resultSet);    
				
				//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoDetaProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoDetaProdu entity = new PedidoDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.PedidoDetaProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoDetaProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		
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
	
	public  List<PedidoDetaProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoDetaProdu("",entity,resultSet);
      	    	
				//entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
      	    	//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoDetaProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
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
	
	public  List<PedidoDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoDetaProdu();
					//entity.setMapPedidoDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=PedidoDetaProduDataAccess.getEntityPedidoDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
					////entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoDetaProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoDetaProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
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
	
	public  PedidoDetaProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoDetaProdu();
					//entity.setMapPedidoDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=PedidoDetaProduDataAccess.getEntityPedidoDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
					////entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoDetaProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoDetaProdu getEntityPedidoDetaProdu(String strPrefijo,PedidoDetaProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoDetaProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoDetaProduDataAccess.setFieldReflectionPedidoDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoDetaProdu=PedidoDetaProduConstantesFunciones.getTodosTiposColumnasPedidoDetaProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoDetaProdu) {
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
							field = PedidoDetaProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoDetaProduDataAccess.setFieldReflectionPedidoDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoDetaProdu(Field field,String strPrefijo,String sColumn,PedidoDetaProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoDetaProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDBODEGADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidoDetaProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoDetaProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoDetaProdu();
					entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoDetaProdu("",entity,resultSet);
					
					//entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
					//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoDetaProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoDetaProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
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
	
	public  List<PedidoDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoDetaProdu("",entity,resultSet);
      	    	
				//entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
      	    	//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoDetaProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoDetaProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
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
	
	public  List<PedidoDetaProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoDetaProdu> entities = new  ArrayList<PedidoDetaProdu>();
		PedidoDetaProdu entity = new PedidoDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoDetaProdu("",entity,resultSet);
      	    	
				//entity.setPedidoDetaProduOriginal( new PedidoDetaProdu());
      	    	//entity.setPedidoDetaProduOriginal(super.getEntity("",entity.getPedidoDetaProduOriginal(),resultSet,PedidoDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoDetaProduOriginal(this.getEntityPedidoDetaProdu("",entity.getPedidoDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoDetaProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoDetaProdu getEntityPedidoDetaProdu(String strPrefijo,PedidoDetaProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDPERIODO));
				entity.setid_pedido_produ(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU));
				entity.setid_bodega(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDUNIDAD));
				entity.setid_bodega_destino(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDBODEGADESTINO));
				entity.setid_tipo_proceso_produ(resultSet.getLong(strPrefijo+PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU));
				entity.setcantidad(resultSet.getInt(strPrefijo+PedidoDetaProduConstantesFunciones.CANTIDAD));
				entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoDetaProduConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoDetaProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoDetaProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoDetaProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoDetaProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoDetaProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoDetaProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoDetaProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoDetaProduDataAccess.TABLENAME,PedidoDetaProduDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoDetaProduDataAccess.setPedidoDetaProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidodetaprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidodetaprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedidodetaprodu.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedidodetaprodu.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public PedidoProdu getPedidoProdu(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		PedidoProdu pedidoprodu= new PedidoProdu();

		try {
			PedidoProduDataAccess pedidoproduDataAccess=new PedidoProduDataAccess();

			pedidoproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidoproduDataAccess.setConnexionType(this.connexionType);
			pedidoproduDataAccess.setParameterDbType(this.parameterDbType);

			pedidoprodu=pedidoproduDataAccess.getEntity(connexion,relpedidodetaprodu.getid_pedido_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoprodu;

	}

	public Bodega getBodega(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relpedidodetaprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relpedidodetaprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relpedidodetaprodu.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Bodega getBodegaDestino(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relpedidodetaprodu.getid_bodega_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public TipoProcesoProdu getTipoProcesoProdu(Connexion connexion,PedidoDetaProdu relpedidodetaprodu)throws SQLException,Exception {

		TipoProcesoProdu tipoprocesoprodu= new TipoProcesoProdu();

		try {
			TipoProcesoProduDataAccess tipoprocesoproduDataAccess=new TipoProcesoProduDataAccess();

			tipoprocesoproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion,relpedidodetaprodu.getid_tipo_proceso_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoprodu;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoDetaProdu pedidodetaprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidodetaprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidodetaprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidodetaprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedidodetaprodu.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedidodetaprodu.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_produ.setValue(pedidodetaprodu.getid_pedido_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(pedidodetaprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(pedidodetaprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(pedidodetaprodu.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_destino.setValue(pedidodetaprodu.getid_bodega_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_produ.setValue(pedidodetaprodu.getid_tipo_proceso_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(pedidodetaprodu.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pendiente=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pendiente.setValue(pedidodetaprodu.getcantidad_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pendiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedidodetaprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidodetaprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidodetaprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidodetaprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidodetaprodu.getId());
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
	
	public void setIsNewIsChangedFalsePedidoDetaProdu(PedidoDetaProdu pedidodetaprodu)throws Exception  {		
		pedidodetaprodu.setIsNew(false);
		pedidodetaprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoDetaProdus(List<PedidoDetaProdu> pedidodetaprodus)throws Exception  {				
		for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
			pedidodetaprodu.setIsNew(false);
			pedidodetaprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoDetaProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
