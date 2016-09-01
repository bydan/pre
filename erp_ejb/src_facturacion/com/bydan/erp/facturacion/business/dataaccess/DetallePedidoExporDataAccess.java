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
import com.bydan.erp.facturacion.util.*;//DetallePedidoExporConstantesFunciones;


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
final public class DetallePedidoExporDataAccess extends  DetallePedidoExporDataAccessAdditional{ //DetallePedidoExporDataAccessAdditional,DataAccessHelper<DetallePedidoExpor>
	//static Logger logger = Logger.getLogger(DetallePedidoExporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_pedido_expor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_pedido_expor,id_bodega,id_producto,id_unidad,id_estado_detalle_pedido,cantidad,precio,descuento_porcentaje,descuento_valor,iva,total,ice,costo,utilidad)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_pedido_expor=?,id_bodega=?,id_producto=?,id_unidad=?,id_estado_detalle_pedido=?,cantidad=?,precio=?,descuento_porcentaje=?,descuento_valor=?,iva=?,total=?,ice=?,costo=?,utilidad=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallepedidoexpor from "+DetallePedidoExporConstantesFunciones.SPERSISTENCENAME+" detallepedidoexpor";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_mes,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_pedido_expor,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_estado_detalle_pedido,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".cantidad,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".precio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".descuento_valor,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".iva,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".total,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".ice,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".costo,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".utilidad from "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoExporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".version_row from "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoExporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_pedido_expor=?,id_bodega=?,id_producto=?,id_unidad=?,id_estado_detalle_pedido=?,cantidad=?,precio=?,descuento_porcentaje=?,descuento_valor=?,iva=?,total=?,ice=?,costo=?,utilidad=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPEDIDOEXPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPEDIDOEXPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPEDIDOEXPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPEDIDOEXPOR_SELECT(?,?)";
	
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
	
	
	protected DetallePedidoExporDataAccessAdditional detallepedidoexporDataAccessAdditional=null;
	
	public DetallePedidoExporDataAccessAdditional getDetallePedidoExporDataAccessAdditional() {
		return this.detallepedidoexporDataAccessAdditional;
	}
	
	public void setDetallePedidoExporDataAccessAdditional(DetallePedidoExporDataAccessAdditional detallepedidoexporDataAccessAdditional) {
		try {
			this.detallepedidoexporDataAccessAdditional=detallepedidoexporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetallePedidoExporDataAccess() {
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
		DetallePedidoExporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetallePedidoExporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetallePedidoExporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetallePedidoExporOriginal(DetallePedidoExpor detallepedidoexpor)throws Exception  {
		detallepedidoexpor.setDetallePedidoExporOriginal((DetallePedidoExpor)detallepedidoexpor.clone());		
	}
	
	public void setDetallePedidoExporsOriginal(List<DetallePedidoExpor> detallepedidoexpors)throws Exception  {
		
		for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors){
			detallepedidoexpor.setDetallePedidoExporOriginal((DetallePedidoExpor)detallepedidoexpor.clone());
		}
	}
	
	public static void setDetallePedidoExporOriginalStatic(DetallePedidoExpor detallepedidoexpor)throws Exception  {
		detallepedidoexpor.setDetallePedidoExporOriginal((DetallePedidoExpor)detallepedidoexpor.clone());		
	}
	
	public static void setDetallePedidoExporsOriginalStatic(List<DetallePedidoExpor> detallepedidoexpors)throws Exception  {
		
		for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors){
			detallepedidoexpor.setDetallePedidoExporOriginal((DetallePedidoExpor)detallepedidoexpor.clone());
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
	
	public  DetallePedidoExpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();		
		
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
	
	public  DetallePedidoExpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetallePedidoExpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetallePedidoExporOriginal(new DetallePedidoExpor());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoExpor("",entity,resultSet); 
				
				//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoExpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetallePedidoExpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();
				
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
	
	public  DetallePedidoExpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetallePedidoExpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetallePedidoExporOriginal(new DetallePedidoExpor());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoExpor("",entity,resultSet);    
				
				//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoExpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetallePedidoExpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetallePedidoExpor entity = new DetallePedidoExpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetallePedidoExpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetallePedidoExpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetallePedidoExpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		
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
	
	public  List<DetallePedidoExpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoExpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
      	    	//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoExpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoExpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
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
	
	public  List<DetallePedidoExpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoExpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoExpor();
					//entity.setMapDetallePedidoExpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetallePedidoExporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoExpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoExporDataAccess.getEntityDetallePedidoExpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
					////entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoExpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetallePedidoExpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
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
	
	public  DetallePedidoExpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoExpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoExpor();
					//entity.setMapDetallePedidoExpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetallePedidoExporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoExpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoExporDataAccess.getEntityDetallePedidoExpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
					////entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetallePedidoExpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallePedidoExpor getEntityDetallePedidoExpor(String strPrefijo,DetallePedidoExpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetallePedidoExpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetallePedidoExpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetallePedidoExporDataAccess.setFieldReflectionDetallePedidoExpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetallePedidoExpor=DetallePedidoExporConstantesFunciones.getTodosTiposColumnasDetallePedidoExpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetallePedidoExpor) {
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
							field = DetallePedidoExpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetallePedidoExpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetallePedidoExporDataAccess.setFieldReflectionDetallePedidoExpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallePedidoExpor(Field field,String strPrefijo,String sColumn,DetallePedidoExpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallePedidoExporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoExporConstantesFunciones.UTILIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoExpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetallePedidoExpor();
					entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetallePedidoExpor("",entity,resultSet);
					
					//entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
					//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
					//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetallePedidoExpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoExpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetallePedidoExpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
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
	
	public  List<DetallePedidoExpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoExpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
      	    	//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetallePedidoExpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoExpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
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
	
	public  List<DetallePedidoExpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoExpor> entities = new  ArrayList<DetallePedidoExpor>();
		DetallePedidoExpor entity = new DetallePedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoExpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoExporOriginal( new DetallePedidoExpor());
      	    	//entity.setDetallePedidoExporOriginal(super.getEntity("",entity.getDetallePedidoExporOriginal(),resultSet,DetallePedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoExporOriginal(this.getEntityDetallePedidoExpor("",entity.getDetallePedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoExpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetallePedidoExpor getEntityDetallePedidoExpor(String strPrefijo,DetallePedidoExpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_pedido_expor(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDUNIDAD));
				entity.setid_estado_detalle_pedido(resultSet.getLong(strPrefijo+DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetallePedidoExporConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.PRECIO));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.DESCUENTOVALOR));
				entity.setiva(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.IVA));
				entity.settotal(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.TOTAL));
				entity.setice(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.ICE));
				entity.setcosto(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.COSTO));
				entity.setutilidad(resultSet.getDouble(strPrefijo+DetallePedidoExporConstantesFunciones.UTILIDAD));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetallePedidoExpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetallePedidoExpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetallePedidoExporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetallePedidoExporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetallePedidoExporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetallePedidoExporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetallePedidoExporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetallePedidoExporDataAccess.TABLENAME,DetallePedidoExporDataAccess.ISWITHSTOREPROCEDURES);
			
			DetallePedidoExporDataAccess.setDetallePedidoExporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public PedidoExpor getPedidoExpor(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		PedidoExpor pedidoexpor= new PedidoExpor();

		try {
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);

			pedidoexpor=pedidoexporDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_pedido_expor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpor;

	}

	public Bodega getBodega(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public EstadoDetallePedido getEstadoDetallePedidoExpor(Connexion connexion,DetallePedidoExpor reldetallepedidoexpor)throws SQLException,Exception {

		EstadoDetallePedido estadodetallepedido= new EstadoDetallePedido();

		try {
			EstadoDetallePedidoDataAccess estadodetallepedidoDataAccess=new EstadoDetallePedidoDataAccess();

			estadodetallepedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetallepedidoDataAccess.setConnexionType(this.connexionType);
			estadodetallepedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,reldetallepedidoexpor.getid_estado_detalle_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallepedido;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetallePedidoExpor detallepedidoexpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallepedidoexpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallepedidoexpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallepedidoexpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallepedidoexpor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallepedidoexpor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallepedidoexpor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallepedidoexpor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_expor=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_expor.setValue(detallepedidoexpor.getid_pedido_expor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_expor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallepedidoexpor.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallepedidoexpor.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallepedidoexpor.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_pedido.setValue(detallepedidoexpor.getid_estado_detalle_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallepedidoexpor.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detallepedidoexpor.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(detallepedidoexpor.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(detallepedidoexpor.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallepedidoexpor.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detallepedidoexpor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallepedidoexpor.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(detallepedidoexpor.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad.setValue(detallepedidoexpor.getutilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallepedidoexpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallepedidoexpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallepedidoexpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallepedidoexpor.getId());
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
	
	public void setIsNewIsChangedFalseDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor)throws Exception  {		
		detallepedidoexpor.setIsNew(false);
		detallepedidoexpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetallePedidoExpors(List<DetallePedidoExpor> detallepedidoexpors)throws Exception  {				
		for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
			detallepedidoexpor.setIsNew(false);
			detallepedidoexpor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetallePedidoExpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
