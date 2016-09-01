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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//FacturaPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class FacturaPuntoVentaDataAccess extends  FacturaPuntoVentaDataAccessAdditional{ //FacturaPuntoVentaDataAccessAdditional,DataAccessHelper<FacturaPuntoVenta>
	//static Logger logger = Logger.getLogger(FacturaPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_vendedor,id_cliente,id_caja,id_tipo_precio,id_mesa,id_formato,id_tipo_factura_punto_venta,id_estado_factura_punto_venta,id_asiento_contable,numero_secuencial,codigo_cliente,nombre_cliente,tarjeta_cliente,direccion_cliente,telefono_cliente,fecha,hora,total_iva,total_sin_iva,iva,descuento,financiamiento,flete,ice,otros,sub_total,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_cliente=?,id_caja=?,id_tipo_precio=?,id_mesa=?,id_formato=?,id_tipo_factura_punto_venta=?,id_estado_factura_punto_venta=?,id_asiento_contable=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,tarjeta_cliente=?,direccion_cliente=?,telefono_cliente=?,fecha=?,hora=?,total_iva=?,total_sin_iva=?,iva=?,descuento=?,financiamiento=?,flete=?,ice=?,otros=?,sub_total=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select facturapuntoventa from "+FacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" facturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_formato,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_factura_punto_venta,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_estado_factura_punto_venta,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".hora,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total_iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total_sin_iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".financiamiento,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".flete,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".ice,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".otros,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total from "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FacturaPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial from "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_cliente=?,id_caja=?,id_tipo_precio=?,id_mesa=?,id_formato=?,id_tipo_factura_punto_venta=?,id_estado_factura_punto_venta=?,id_asiento_contable=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,tarjeta_cliente=?,direccion_cliente=?,telefono_cliente=?,fecha=?,hora=?,total_iva=?,total_sin_iva=?,iva=?,descuento=?,financiamiento=?,flete=?,ice=?,otros=?,sub_total=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURAPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURAPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURAPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURAPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected FacturaPuntoVentaDataAccessAdditional facturapuntoventaDataAccessAdditional=null;
	
	public FacturaPuntoVentaDataAccessAdditional getFacturaPuntoVentaDataAccessAdditional() {
		return this.facturapuntoventaDataAccessAdditional;
	}
	
	public void setFacturaPuntoVentaDataAccessAdditional(FacturaPuntoVentaDataAccessAdditional facturapuntoventaDataAccessAdditional) {
		try {
			this.facturapuntoventaDataAccessAdditional=facturapuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaPuntoVentaDataAccess() {
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
		FacturaPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaPuntoVentaOriginal(FacturaPuntoVenta facturapuntoventa)throws Exception  {
		facturapuntoventa.setFacturaPuntoVentaOriginal((FacturaPuntoVenta)facturapuntoventa.clone());		
	}
	
	public void setFacturaPuntoVentasOriginal(List<FacturaPuntoVenta> facturapuntoventas)throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas){
			facturapuntoventa.setFacturaPuntoVentaOriginal((FacturaPuntoVenta)facturapuntoventa.clone());
		}
	}
	
	public static void setFacturaPuntoVentaOriginalStatic(FacturaPuntoVenta facturapuntoventa)throws Exception  {
		facturapuntoventa.setFacturaPuntoVentaOriginal((FacturaPuntoVenta)facturapuntoventa.clone());		
	}
	
	public static void setFacturaPuntoVentasOriginalStatic(List<FacturaPuntoVenta> facturapuntoventas)throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas){
			facturapuntoventa.setFacturaPuntoVentaOriginal((FacturaPuntoVenta)facturapuntoventa.clone());
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
	
	public  FacturaPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		
		
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
	
	public  FacturaPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.FacturaPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaPuntoVentaOriginal(new FacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaPuntoVenta("",entity,resultSet); 
				
				//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FacturaPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();
				
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
	
	public  FacturaPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.FacturaPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaPuntoVentaOriginal(new FacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaPuntoVenta("",entity,resultSet);    
				
				//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FacturaPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FacturaPuntoVenta entity = new FacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.FacturaPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FacturaPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		
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
	
	public  List<FacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
      	    	//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
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
	
	public  List<FacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaPuntoVenta();
					//entity.setMapFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=FacturaPuntoVentaDataAccess.getEntityFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
					////entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FacturaPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
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
	
	public  FacturaPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaPuntoVenta();
					//entity.setMapFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=FacturaPuntoVentaDataAccess.getEntityFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
					////entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFacturaPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturaPuntoVenta getEntityFacturaPuntoVenta(String strPrefijo,FacturaPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaPuntoVentaDataAccess.setFieldReflectionFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFacturaPuntoVenta=FacturaPuntoVentaConstantesFunciones.getTodosTiposColumnasFacturaPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFacturaPuntoVenta) {
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
							field = FacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaPuntoVentaDataAccess.setFieldReflectionFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturaPuntoVenta(Field field,String strPrefijo,String sColumn,FacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDMESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.OTROS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaPuntoVentaConstantesFunciones.TOTAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FacturaPuntoVenta();
					entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFacturaPuntoVenta("",entity,resultSet);
					
					//entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
					//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
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
	
	public  List<FacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
      	    	//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturaPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
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
	
	public  List<FacturaPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaPuntoVenta> entities = new  ArrayList<FacturaPuntoVenta>();
		FacturaPuntoVenta entity = new FacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFacturaPuntoVentaOriginal( new FacturaPuntoVenta());
      	    	//entity.setFacturaPuntoVentaOriginal(super.getEntity("",entity.getFacturaPuntoVentaOriginal(),resultSet,FacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaPuntoVentaOriginal(this.getEntityFacturaPuntoVenta("",entity.getFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FacturaPuntoVenta getEntityFacturaPuntoVenta(String strPrefijo,FacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDUSUARIO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDVENDEDOR));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDCLIENTE));
				entity.setid_caja(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDCAJA));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO));
				entity.setid_mesa(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDMESA));
				entity.setid_formato(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDFORMATO));
				entity.setid_tipo_factura_punto_venta(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA));
				entity.setid_estado_factura_punto_venta(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL));
				entity.setcodigo_cliente(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE));
				entity.setnombre_cliente(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE));
				entity.settarjeta_cliente(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+FacturaPuntoVentaConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+FacturaPuntoVentaConstantesFunciones.HORA));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.TOTALIVA));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.TOTALSINIVA));
				entity.setiva(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.IVA));
				entity.setdescuento(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.DESCUENTO));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO));
				entity.setflete(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.FLETE));
				entity.setice(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.ICE));
				entity.setotros(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.OTROS));
				entity.setsub_total(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+FacturaPuntoVentaConstantesFunciones.TOTAL));
			} else {
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFacturaPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FacturaPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaPuntoVentaDataAccess.TABLENAME,FacturaPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaPuntoVentaDataAccess.setFacturaPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfacturapuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturapuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relfacturapuntoventa.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Vendedor getVendedor(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relfacturapuntoventa.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Cliente getCliente(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfacturapuntoventa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Caja getCaja(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relfacturapuntoventa.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relfacturapuntoventa.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Mesa getMesa(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Mesa mesa= new Mesa();

		try {
			MesaDataAccess mesaDataAccess=new MesaDataAccess();

			mesaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesaDataAccess.setConnexionType(this.connexionType);
			mesaDataAccess.setParameterDbType(this.parameterDbType);

			mesa=mesaDataAccess.getEntity(connexion,relfacturapuntoventa.getid_mesa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mesa;

	}

	public Formato getFormato(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relfacturapuntoventa.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoFacturaPuntoVenta getTipoFacturaPuntoVenta(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		TipoFacturaPuntoVenta tipofacturapuntoventa= new TipoFacturaPuntoVenta();

		try {
			TipoFacturaPuntoVentaDataAccess tipofacturapuntoventaDataAccess=new TipoFacturaPuntoVentaDataAccess();

			tipofacturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			tipofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion,relfacturapuntoventa.getid_tipo_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofacturapuntoventa;

	}

	public EstadoFacturaPuntoVenta getEstadoFacturaPuntoVenta(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		EstadoFacturaPuntoVenta estadofacturapuntoventa= new EstadoFacturaPuntoVenta();

		try {
			EstadoFacturaPuntoVentaDataAccess estadofacturapuntoventaDataAccess=new EstadoFacturaPuntoVentaDataAccess();

			estadofacturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			estadofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion,relfacturapuntoventa.getid_estado_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadofacturapuntoventa;

	}

	public AsientoContable getAsientoContable(Connexion connexion,FacturaPuntoVenta relfacturapuntoventa)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relfacturapuntoventa.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<HistorialFormaPagoPuntoVenta> getHistorialFormaPagoPuntoVentas(Connexion connexion,FacturaPuntoVenta facturapuntoventa)throws SQLException,Exception {

		List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas= new ArrayList<HistorialFormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta ON "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+".historial_forma_pago_punto_venta.id_factura_punto_venta="+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id WHERE "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id="+String.valueOf(facturapuntoventa.getId());
			} else {
				sQuery=" INNER JOIN historialformapagopuntoventa.FacturaPuntoVenta WHERE historialformapagopuntoventa.FacturaPuntoVenta.id="+String.valueOf(facturapuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialFormaPagoPuntoVentaDataAccess historialformapagopuntoventaDataAccess=new HistorialFormaPagoPuntoVentaDataAccess();

			historialformapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			historialformapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialformapagopuntoventas;

	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,FacturaPuntoVenta facturapuntoventa)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_factura_punto_venta="+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id WHERE "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id="+String.valueOf(facturapuntoventa.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.FacturaPuntoVenta WHERE formapagopuntoventa.FacturaPuntoVenta.id="+String.valueOf(facturapuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}

	public List<DetalleFacturaPuntoVenta> getDetalleFacturaPuntoVentas(Connexion connexion,FacturaPuntoVenta facturapuntoventa)throws SQLException,Exception {

		List<DetalleFacturaPuntoVenta> detallefacturapuntoventas= new ArrayList<DetalleFacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta ON "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+".detalle_factura_punto_venta.id_factura_punto_venta="+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id WHERE "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id="+String.valueOf(facturapuntoventa.getId());
			} else {
				sQuery=" INNER JOIN detallefacturapuntoventa.FacturaPuntoVenta WHERE detallefacturapuntoventa.FacturaPuntoVenta.id="+String.valueOf(facturapuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaPuntoVentaDataAccess detallefacturapuntoventaDataAccess=new DetalleFacturaPuntoVentaDataAccess();

			detallefacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			detallefacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturapuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FacturaPuntoVenta facturapuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!facturapuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(facturapuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(facturapuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(facturapuntoventa.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(facturapuntoventa.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(facturapuntoventa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(facturapuntoventa.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(facturapuntoventa.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mesa=new ParameterValue<Long>();
					parameterMaintenanceValueid_mesa.setValue(facturapuntoventa.getid_mesa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mesa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(facturapuntoventa.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_factura_punto_venta.setValue(facturapuntoventa.getid_tipo_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_factura_punto_venta.setValue(facturapuntoventa.getid_estado_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(facturapuntoventa.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(facturapuntoventa.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_cliente=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_cliente.setValue(facturapuntoventa.getcodigo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_cliente=new ParameterValue<String>();
					parameterMaintenanceValuenombre_cliente.setValue(facturapuntoventa.getnombre_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetarjeta_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetarjeta_cliente.setValue(facturapuntoventa.gettarjeta_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetarjeta_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(facturapuntoventa.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(facturapuntoventa.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(facturapuntoventa.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(facturapuntoventa.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(facturapuntoventa.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(facturapuntoventa.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(facturapuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(facturapuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(facturapuntoventa.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(facturapuntoventa.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(facturapuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros=new ParameterValue<Double>();
					parameterMaintenanceValueotros.setValue(facturapuntoventa.getotros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(facturapuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(facturapuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!facturapuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(facturapuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(facturapuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(facturapuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa)throws Exception  {		
		facturapuntoventa.setIsNew(false);
		facturapuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas)throws Exception  {				
		for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
			facturapuntoventa.setIsNew(false);
			facturapuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarFacturaPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
