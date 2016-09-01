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
import com.bydan.erp.inventario.util.*;//ParametroInventarioDefectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class ParametroInventarioDefectoDataAccess extends  ParametroInventarioDefectoDataAccessAdditional{ //ParametroInventarioDefectoDataAccessAdditional,DataAccessHelper<ParametroInventarioDefecto>
	//static Logger logger = Logger.getLogger(ParametroInventarioDefectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_inventario_defecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_grupo_bodega,id_calidad_producto,id_tipo_servicio,id_tipo_producto_servicio_inven,id_tipo_producto_servicio,id_tipo_costeo,id_tipo_producto,id_tipo_via_transporte,id_rango_unidad_venta,id_pais,id_ciudad,id_color_producto,id_clase_producto,id_efecto_producto,id_marca_producto,id_modelo_producto,id_material_producto,id_segmento_producto,id_talla_producto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_grupo_bodega=?,id_calidad_producto=?,id_tipo_servicio=?,id_tipo_producto_servicio_inven=?,id_tipo_producto_servicio=?,id_tipo_costeo=?,id_tipo_producto=?,id_tipo_via_transporte=?,id_rango_unidad_venta=?,id_pais=?,id_ciudad=?,id_color_producto=?,id_clase_producto=?,id_efecto_producto=?,id_marca_producto=?,id_modelo_producto=?,id_material_producto=?,id_segmento_producto=?,id_talla_producto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroinventariodefecto from "+ParametroInventarioDefectoConstantesFunciones.SPERSISTENCENAME+" parametroinventariodefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_grupo_bodega,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_calidad_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_servicio,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio_inven,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_costeo,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_rango_unidad_venta,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_pais,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_ciudad,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_color_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_clase_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_efecto_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_marca_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_modelo_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_material_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_segmento_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_talla_producto from "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroInventarioDefectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".version_row from "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroInventarioDefectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_grupo_bodega=?,id_calidad_producto=?,id_tipo_servicio=?,id_tipo_producto_servicio_inven=?,id_tipo_producto_servicio=?,id_tipo_costeo=?,id_tipo_producto=?,id_tipo_via_transporte=?,id_rango_unidad_venta=?,id_pais=?,id_ciudad=?,id_color_producto=?,id_clase_producto=?,id_efecto_producto=?,id_marca_producto=?,id_modelo_producto=?,id_material_producto=?,id_segmento_producto=?,id_talla_producto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROINVENTARIODEFECTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROINVENTARIODEFECTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROINVENTARIODEFECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROINVENTARIODEFECTO_SELECT(?,?)";
	
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
	
	
	protected ParametroInventarioDefectoDataAccessAdditional parametroinventariodefectoDataAccessAdditional=null;
	
	public ParametroInventarioDefectoDataAccessAdditional getParametroInventarioDefectoDataAccessAdditional() {
		return this.parametroinventariodefectoDataAccessAdditional;
	}
	
	public void setParametroInventarioDefectoDataAccessAdditional(ParametroInventarioDefectoDataAccessAdditional parametroinventariodefectoDataAccessAdditional) {
		try {
			this.parametroinventariodefectoDataAccessAdditional=parametroinventariodefectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroInventarioDefectoDataAccess() {
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
		ParametroInventarioDefectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroInventarioDefectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroInventarioDefectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroInventarioDefectoOriginal(ParametroInventarioDefecto parametroinventariodefecto)throws Exception  {
		parametroinventariodefecto.setParametroInventarioDefectoOriginal((ParametroInventarioDefecto)parametroinventariodefecto.clone());		
	}
	
	public void setParametroInventarioDefectosOriginal(List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception  {
		
		for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos){
			parametroinventariodefecto.setParametroInventarioDefectoOriginal((ParametroInventarioDefecto)parametroinventariodefecto.clone());
		}
	}
	
	public static void setParametroInventarioDefectoOriginalStatic(ParametroInventarioDefecto parametroinventariodefecto)throws Exception  {
		parametroinventariodefecto.setParametroInventarioDefectoOriginal((ParametroInventarioDefecto)parametroinventariodefecto.clone());		
	}
	
	public static void setParametroInventarioDefectosOriginalStatic(List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception  {
		
		for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos){
			parametroinventariodefecto.setParametroInventarioDefectoOriginal((ParametroInventarioDefecto)parametroinventariodefecto.clone());
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
	
	public  ParametroInventarioDefecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		
		
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
	
	public  ParametroInventarioDefecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ParametroInventarioDefecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroInventarioDefectoOriginal(new ParametroInventarioDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroInventarioDefecto("",entity,resultSet); 
				
				//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroInventarioDefecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroInventarioDefecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();
				
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
	
	public  ParametroInventarioDefecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInventarioDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroInventarioDefecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroInventarioDefectoOriginal(new ParametroInventarioDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroInventarioDefecto("",entity,resultSet);    
				
				//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroInventarioDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroInventarioDefecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInventarioDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroInventarioDefecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroInventarioDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroInventarioDefecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		
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
	
	public  List<ParametroInventarioDefecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInventarioDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInventarioDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInventarioDefecto("",entity,resultSet);
      	    	
				//entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
      	    	//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInventarioDefectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInventarioDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroInventarioDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
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
	
	public  List<ParametroInventarioDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInventarioDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroInventarioDefecto();
					//entity.setMapParametroInventarioDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroInventarioDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroInventarioDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroInventarioDefectoDataAccess.getEntityParametroInventarioDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
					////entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInventarioDefectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInventarioDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroInventarioDefecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
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
	
	public  ParametroInventarioDefecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInventarioDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroInventarioDefecto();
					//entity.setMapParametroInventarioDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroInventarioDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroInventarioDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroInventarioDefectoDataAccess.getEntityParametroInventarioDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
					////entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroInventarioDefecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInventarioDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroInventarioDefecto getEntityParametroInventarioDefecto(String strPrefijo,ParametroInventarioDefecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroInventarioDefecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroInventarioDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroInventarioDefectoDataAccess.setFieldReflectionParametroInventarioDefecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroInventarioDefecto=ParametroInventarioDefectoConstantesFunciones.getTodosTiposColumnasParametroInventarioDefecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroInventarioDefecto) {
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
							field = ParametroInventarioDefecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroInventarioDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroInventarioDefectoDataAccess.setFieldReflectionParametroInventarioDefecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroInventarioDefecto(Field field,String strPrefijo,String sColumn,ParametroInventarioDefecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroInventarioDefectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroInventarioDefecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInventarioDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroInventarioDefecto();
					entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroInventarioDefecto("",entity,resultSet);
					
					//entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
					//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroInventarioDefectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInventarioDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroInventarioDefecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInventarioDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInventarioDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroInventarioDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
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
	
	public  List<ParametroInventarioDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInventarioDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInventarioDefecto("",entity,resultSet);
      	    	
				//entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
      	    	//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroInventarioDefectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInventarioDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroInventarioDefecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
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
	
	public  List<ParametroInventarioDefecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInventarioDefecto> entities = new  ArrayList<ParametroInventarioDefecto>();
		ParametroInventarioDefecto entity = new ParametroInventarioDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInventarioDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInventarioDefecto("",entity,resultSet);
      	    	
				//entity.setParametroInventarioDefectoOriginal( new ParametroInventarioDefecto());
      	    	//entity.setParametroInventarioDefectoOriginal(super.getEntity("",entity.getParametroInventarioDefectoOriginal(),resultSet,ParametroInventarioDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInventarioDefectoOriginal(this.getEntityParametroInventarioDefecto("",entity.getParametroInventarioDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInventarioDefectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroInventarioDefecto getEntityParametroInventarioDefecto(String strPrefijo,ParametroInventarioDefecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL));
				entity.setid_grupo_bodega(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA));
				entity.setid_calidad_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO));
				entity.setid_tipo_servicio(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO));
				entity.setid_tipo_producto_servicio_inven(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN));
				entity.setid_tipo_producto_servicio(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO));
				entity.setid_tipo_costeo(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO));
				entity.setid_tipo_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setid_rango_unidad_venta(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA));
				entity.setid_pais(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDCIUDAD));
				entity.setid_color_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO));
				entity.setid_clase_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO));
				entity.setid_efecto_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO));
				entity.setid_marca_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO));
				entity.setid_modelo_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO));
				entity.setid_material_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO));
				entity.setid_segmento_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO));
				entity.setid_talla_producto(resultSet.getLong(strPrefijo+ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroInventarioDefecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroInventarioDefecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroInventarioDefectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroInventarioDefectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroInventarioDefectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroInventarioDefectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroInventarioDefectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroInventarioDefectoDataAccess.TABLENAME,ParametroInventarioDefectoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroInventarioDefectoDataAccess.setParametroInventarioDefectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public GrupoBodega getGrupoBodega(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		GrupoBodega grupobodega= new GrupoBodega();

		try {
			GrupoBodegaDataAccess grupobodegaDataAccess=new GrupoBodegaDataAccess();

			grupobodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupobodegaDataAccess.setConnexionType(this.connexionType);
			grupobodegaDataAccess.setParameterDbType(this.parameterDbType);

			grupobodega=grupobodegaDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_grupo_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupobodega;

	}

	public CalidadProducto getCalidadProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		CalidadProducto calidadproducto= new CalidadProducto();

		try {
			CalidadProductoDataAccess calidadproductoDataAccess=new CalidadProductoDataAccess();

			calidadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			calidadproductoDataAccess.setConnexionType(this.connexionType);
			calidadproductoDataAccess.setParameterDbType(this.parameterDbType);

			calidadproducto=calidadproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_calidad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return calidadproducto;

	}

	public TipoServicio getTipoServicio(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoServicio tiposervicio= new TipoServicio();

		try {
			TipoServicioDataAccess tiposervicioDataAccess=new TipoServicioDataAccess();

			tiposervicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiposervicioDataAccess.setConnexionType(this.connexionType);
			tiposervicioDataAccess.setParameterDbType(this.parameterDbType);

			tiposervicio=tiposervicioDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiposervicio;

	}

	public TipoProductoServicioInven getTipoProductoServicioInven(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoProductoServicioInven tipoproductoservicioinven= new TipoProductoServicioInven();

		try {
			TipoProductoServicioInvenDataAccess tipoproductoservicioinvenDataAccess=new TipoProductoServicioInvenDataAccess();

			tipoproductoservicioinvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioinvenDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioinvenDataAccess.setParameterDbType(this.parameterDbType);

			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_producto_servicio_inven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicioinven;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}

	public TipoCosteo getTipoCosteo(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoCosteo tipocosteo= new TipoCosteo();

		try {
			TipoCosteoDataAccess tipocosteoDataAccess=new TipoCosteoDataAccess();

			tipocosteoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocosteoDataAccess.setConnexionType(this.connexionType);
			tipocosteoDataAccess.setParameterDbType(this.parameterDbType);

			tipocosteo=tipocosteoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_costeo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocosteo;

	}

	public TipoProducto getTipoProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoProducto tipoproducto= new TipoProducto();

		try {
			TipoProductoDataAccess tipoproductoDataAccess=new TipoProductoDataAccess();

			tipoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoDataAccess.setConnexionType(this.connexionType);
			tipoproductoDataAccess.setParameterDbType(this.parameterDbType);

			tipoproducto=tipoproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproducto;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}

	public RangoUnidadVenta getRangoUnidadVenta(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		RangoUnidadVenta rangounidadventa= new RangoUnidadVenta();

		try {
			RangoUnidadVentaDataAccess rangounidadventaDataAccess=new RangoUnidadVentaDataAccess();

			rangounidadventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rangounidadventaDataAccess.setConnexionType(this.connexionType);
			rangounidadventaDataAccess.setParameterDbType(this.parameterDbType);

			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_rango_unidad_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rangounidadventa;

	}

	public Pais getPais(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public ColorProducto getColorProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		ColorProducto colorproducto= new ColorProducto();

		try {
			ColorProductoDataAccess colorproductoDataAccess=new ColorProductoDataAccess();

			colorproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			colorproductoDataAccess.setConnexionType(this.connexionType);
			colorproductoDataAccess.setParameterDbType(this.parameterDbType);

			colorproducto=colorproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_color_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return colorproducto;

	}

	public ClaseProducto getClaseProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		ClaseProducto claseproducto= new ClaseProducto();

		try {
			ClaseProductoDataAccess claseproductoDataAccess=new ClaseProductoDataAccess();

			claseproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			claseproductoDataAccess.setConnexionType(this.connexionType);
			claseproductoDataAccess.setParameterDbType(this.parameterDbType);

			claseproducto=claseproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_clase_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return claseproducto;

	}

	public EfectoProducto getEfectoProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		EfectoProducto efectoproducto= new EfectoProducto();

		try {
			EfectoProductoDataAccess efectoproductoDataAccess=new EfectoProductoDataAccess();

			efectoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			efectoproductoDataAccess.setConnexionType(this.connexionType);
			efectoproductoDataAccess.setParameterDbType(this.parameterDbType);

			efectoproducto=efectoproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_efecto_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return efectoproducto;

	}

	public MarcaProducto getMarcaProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		MarcaProducto marcaproducto= new MarcaProducto();

		try {
			MarcaProductoDataAccess marcaproductoDataAccess=new MarcaProductoDataAccess();

			marcaproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			marcaproductoDataAccess.setConnexionType(this.connexionType);
			marcaproductoDataAccess.setParameterDbType(this.parameterDbType);

			marcaproducto=marcaproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_marca_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return marcaproducto;

	}

	public ModeloProducto getModeloProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		ModeloProducto modeloproducto= new ModeloProducto();

		try {
			ModeloProductoDataAccess modeloproductoDataAccess=new ModeloProductoDataAccess();

			modeloproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			modeloproductoDataAccess.setConnexionType(this.connexionType);
			modeloproductoDataAccess.setParameterDbType(this.parameterDbType);

			modeloproducto=modeloproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_modelo_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modeloproducto;

	}

	public MaterialProducto getMaterialProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		MaterialProducto materialproducto= new MaterialProducto();

		try {
			MaterialProductoDataAccess materialproductoDataAccess=new MaterialProductoDataAccess();

			materialproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			materialproductoDataAccess.setConnexionType(this.connexionType);
			materialproductoDataAccess.setParameterDbType(this.parameterDbType);

			materialproducto=materialproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_material_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return materialproducto;

	}

	public SegmentoProducto getSegmentoProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		SegmentoProducto segmentoproducto= new SegmentoProducto();

		try {
			SegmentoProductoDataAccess segmentoproductoDataAccess=new SegmentoProductoDataAccess();

			segmentoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			segmentoproductoDataAccess.setConnexionType(this.connexionType);
			segmentoproductoDataAccess.setParameterDbType(this.parameterDbType);

			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_segmento_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return segmentoproducto;

	}

	public TallaProducto getTallaProducto(Connexion connexion,ParametroInventarioDefecto relparametroinventariodefecto)throws SQLException,Exception {

		TallaProducto tallaproducto= new TallaProducto();

		try {
			TallaProductoDataAccess tallaproductoDataAccess=new TallaProductoDataAccess();

			tallaproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tallaproductoDataAccess.setConnexionType(this.connexionType);
			tallaproductoDataAccess.setParameterDbType(this.parameterDbType);

			tallaproducto=tallaproductoDataAccess.getEntity(connexion,relparametroinventariodefecto.getid_talla_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tallaproducto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroInventarioDefecto parametroinventariodefecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroinventariodefecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroinventariodefecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametroinventariodefecto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_bodega.setValue(parametroinventariodefecto.getid_grupo_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_calidad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_calidad_producto.setValue(parametroinventariodefecto.getid_calidad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_calidad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_servicio.setValue(parametroinventariodefecto.getid_tipo_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto_servicio_inven=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto_servicio_inven.setValue(parametroinventariodefecto.getid_tipo_producto_servicio_inven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto_servicio_inven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto_servicio.setValue(parametroinventariodefecto.getid_tipo_producto_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_costeo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_costeo.setValue(parametroinventariodefecto.getid_tipo_costeo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_costeo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto.setValue(parametroinventariodefecto.getid_tipo_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(parametroinventariodefecto.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rango_unidad_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_rango_unidad_venta.setValue(parametroinventariodefecto.getid_rango_unidad_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rango_unidad_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(parametroinventariodefecto.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(parametroinventariodefecto.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_color_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_color_producto.setValue(parametroinventariodefecto.getid_color_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_color_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_clase_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_clase_producto.setValue(parametroinventariodefecto.getid_clase_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_clase_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_efecto_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_efecto_producto.setValue(parametroinventariodefecto.getid_efecto_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_efecto_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_marca_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_marca_producto.setValue(parametroinventariodefecto.getid_marca_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_marca_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modelo_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_modelo_producto.setValue(parametroinventariodefecto.getid_modelo_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modelo_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_material_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_material_producto.setValue(parametroinventariodefecto.getid_material_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_material_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_segmento_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_segmento_producto.setValue(parametroinventariodefecto.getid_segmento_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_segmento_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_talla_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_talla_producto.setValue(parametroinventariodefecto.getid_talla_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_talla_producto);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroinventariodefecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroinventariodefecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroinventariodefecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroinventariodefecto.getId());
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
	
	public void setIsNewIsChangedFalseParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto)throws Exception  {		
		parametroinventariodefecto.setIsNew(false);
		parametroinventariodefecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception  {				
		for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
			parametroinventariodefecto.setIsNew(false);
			parametroinventariodefecto.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroInventarioDefecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
