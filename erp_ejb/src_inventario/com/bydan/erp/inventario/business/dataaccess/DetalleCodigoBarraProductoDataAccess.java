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
import com.bydan.erp.inventario.util.*;//DetalleCodigoBarraProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleCodigoBarraProductoDataAccess extends  DetalleCodigoBarraProductoDataAccessAdditional{ //DetalleCodigoBarraProductoDataAccessAdditional,DataAccessHelper<DetalleCodigoBarraProducto>
	//static Logger logger = Logger.getLogger(DetalleCodigoBarraProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_codigo_barra_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,control,medicion,valor_anterior,fecha,observacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,control=?,medicion=?,valor_anterior=?,fecha=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallecodigobarraproducto from "+DetalleCodigoBarraProductoConstantesFunciones.SPERSISTENCENAME+" detallecodigobarraproducto";
	public static String QUERYSELECTNATIVE="select "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".version_row,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_bodega,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_producto,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_unidad,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_marca,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".control,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".medicion,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".valor_anterior,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".fecha,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".observacion from "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;//+" as "+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".version_row from "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;//+" as "+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,control=?,medicion=?,valor_anterior=?,fecha=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECODIGOBARRAPRODUCTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECODIGOBARRAPRODUCTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECODIGOBARRAPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECODIGOBARRAPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected DetalleCodigoBarraProductoDataAccessAdditional detallecodigobarraproductoDataAccessAdditional=null;
	
	public DetalleCodigoBarraProductoDataAccessAdditional getDetalleCodigoBarraProductoDataAccessAdditional() {
		return this.detallecodigobarraproductoDataAccessAdditional;
	}
	
	public void setDetalleCodigoBarraProductoDataAccessAdditional(DetalleCodigoBarraProductoDataAccessAdditional detallecodigobarraproductoDataAccessAdditional) {
		try {
			this.detallecodigobarraproductoDataAccessAdditional=detallecodigobarraproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleCodigoBarraProductoDataAccess() {
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
		DetalleCodigoBarraProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleCodigoBarraProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleCodigoBarraProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleCodigoBarraProductoOriginal(DetalleCodigoBarraProducto detallecodigobarraproducto)throws Exception  {
		detallecodigobarraproducto.setDetalleCodigoBarraProductoOriginal((DetalleCodigoBarraProducto)detallecodigobarraproducto.clone());		
	}
	
	public void setDetalleCodigoBarraProductosOriginal(List<DetalleCodigoBarraProducto> detallecodigobarraproductos)throws Exception  {
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos){
			detallecodigobarraproducto.setDetalleCodigoBarraProductoOriginal((DetalleCodigoBarraProducto)detallecodigobarraproducto.clone());
		}
	}
	
	public static void setDetalleCodigoBarraProductoOriginalStatic(DetalleCodigoBarraProducto detallecodigobarraproducto)throws Exception  {
		detallecodigobarraproducto.setDetalleCodigoBarraProductoOriginal((DetalleCodigoBarraProducto)detallecodigobarraproducto.clone());		
	}
	
	public static void setDetalleCodigoBarraProductosOriginalStatic(List<DetalleCodigoBarraProducto> detallecodigobarraproductos)throws Exception  {
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos){
			detallecodigobarraproducto.setDetalleCodigoBarraProductoOriginal((DetalleCodigoBarraProducto)detallecodigobarraproducto.clone());
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
	
	public  DetalleCodigoBarraProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		
		
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
	
	public  DetalleCodigoBarraProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleCodigoBarraProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleCodigoBarraProductoOriginal(new DetalleCodigoBarraProducto());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet); 
				
				//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCodigoBarraProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleCodigoBarraProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();
				
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
	
	public  DetalleCodigoBarraProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCodigoBarraProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleCodigoBarraProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleCodigoBarraProductoOriginal(new DetalleCodigoBarraProducto());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet);    
				
				//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCodigoBarraProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleCodigoBarraProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCodigoBarraProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleCodigoBarraProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleCodigoBarraProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleCodigoBarraProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		
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
	
	public  List<DetalleCodigoBarraProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCodigoBarraProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCodigoBarraProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet);
      	    	
				//entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
      	    	//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCodigoBarraProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCodigoBarraProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCodigoBarraProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
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
	
	public  List<DetalleCodigoBarraProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCodigoBarraProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCodigoBarraProducto();
					//entity.setMapDetalleCodigoBarraProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleCodigoBarraProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCodigoBarraProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCodigoBarraProductoDataAccess.getEntityDetalleCodigoBarraProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
					////entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCodigoBarraProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCodigoBarraProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleCodigoBarraProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
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
	
	public  DetalleCodigoBarraProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCodigoBarraProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCodigoBarraProducto();
					//entity.setMapDetalleCodigoBarraProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleCodigoBarraProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCodigoBarraProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCodigoBarraProductoDataAccess.getEntityDetalleCodigoBarraProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
					////entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleCodigoBarraProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCodigoBarraProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleCodigoBarraProducto getEntityDetalleCodigoBarraProducto(String strPrefijo,DetalleCodigoBarraProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleCodigoBarraProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleCodigoBarraProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleCodigoBarraProductoDataAccess.setFieldReflectionDetalleCodigoBarraProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleCodigoBarraProducto=DetalleCodigoBarraProductoConstantesFunciones.getTodosTiposColumnasDetalleCodigoBarraProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleCodigoBarraProducto) {
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
							field = DetalleCodigoBarraProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleCodigoBarraProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleCodigoBarraProductoDataAccess.setFieldReflectionDetalleCodigoBarraProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleCodigoBarraProducto(Field field,String strPrefijo,String sColumn,DetalleCodigoBarraProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleCodigoBarraProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.CONTROL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.MEDICION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCodigoBarraProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCodigoBarraProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleCodigoBarraProducto();
					entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet);
					
					//entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
					//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleCodigoBarraProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCodigoBarraProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCodigoBarraProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCodigoBarraProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCodigoBarraProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleCodigoBarraProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
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
	
	public  List<DetalleCodigoBarraProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCodigoBarraProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet);
      	    	
				//entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
      	    	//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleCodigoBarraProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCodigoBarraProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCodigoBarraProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
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
	
	public  List<DetalleCodigoBarraProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCodigoBarraProducto> entities = new  ArrayList<DetalleCodigoBarraProducto>();
		DetalleCodigoBarraProducto entity = new DetalleCodigoBarraProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCodigoBarraProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCodigoBarraProducto("",entity,resultSet);
      	    	
				//entity.setDetalleCodigoBarraProductoOriginal( new DetalleCodigoBarraProducto());
      	    	//entity.setDetalleCodigoBarraProductoOriginal(super.getEntity("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet,DetalleCodigoBarraProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCodigoBarraProductoOriginal(this.getEntityDetalleCodigoBarraProducto("",entity.getDetalleCodigoBarraProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCodigoBarraProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleCodigoBarraProducto getEntityDetalleCodigoBarraProducto(String strPrefijo,DetalleCodigoBarraProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD));
				entity.setid_linea(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO));
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA));
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA));
				entity.setcontrol(resultSet.getString(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.CONTROL));
				entity.setmedicion(resultSet.getString(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.MEDICION));
				entity.setvalor_anterior(resultSet.getDouble(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.FECHA).getTime()));
				entity.setobservacion(resultSet.getString(strPrefijo+DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleCodigoBarraProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleCodigoBarraProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleCodigoBarraProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleCodigoBarraProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleCodigoBarraProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleCodigoBarraProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleCodigoBarraProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleCodigoBarraProductoDataAccess.TABLENAME,DetalleCodigoBarraProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleCodigoBarraProductoDataAccess.setDetalleCodigoBarraProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Linea getLinea(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,DetalleCodigoBarraProducto reldetallecodigobarraproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,reldetallecodigobarraproducto.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallecodigobarraproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallecodigobarraproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallecodigobarraproducto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallecodigobarraproducto.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallecodigobarraproducto.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallecodigobarraproducto.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(detallecodigobarraproducto.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(detallecodigobarraproducto.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(detallecodigobarraproducto.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(detallecodigobarraproducto.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontrol=new ParameterValue<String>();
					parameterMaintenanceValuecontrol.setValue(detallecodigobarraproducto.getcontrol());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontrol);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemedicion=new ParameterValue<String>();
					parameterMaintenanceValuemedicion.setValue(detallecodigobarraproducto.getmedicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemedicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_anterior=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_anterior.setValue(detallecodigobarraproducto.getvalor_anterior());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_anterior);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detallecodigobarraproducto.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(detallecodigobarraproducto.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallecodigobarraproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallecodigobarraproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallecodigobarraproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallecodigobarraproducto.getId());
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
	
	public void setIsNewIsChangedFalseDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto)throws Exception  {		
		detallecodigobarraproducto.setIsNew(false);
		detallecodigobarraproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> detallecodigobarraproductos)throws Exception  {				
		for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
			detallecodigobarraproducto.setIsNew(false);
			detallecodigobarraproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleCodigoBarraProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
