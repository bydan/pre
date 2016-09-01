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
import com.bydan.erp.facturacion.util.*;//FacturaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class FacturaDataAccess extends  FacturaDataAccessAdditional{ //FacturaDataAccessAdditional,DataAccessHelper<Factura>
	//static Logger logger = Logger.getLogger(FacturaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,numero_pre_impreso,fecha_emision,numero_dias,fecha_vencimiento,id_moneda,cotizacion,id_empleado,id_formato,direccion,ruc,id_cliente,id_tipo_precio,telefono,id_sub_cliente,id_vendedor,id_transporte,id_transportista,orden,id_tipo_llamada,hora_inicio,hora_fin,id_tipo_factura,descripcion,cupo,saldo,documentos,disponible,porcentaje_descuento,total_iva,suman,descuento_valor,total_sin_iva,total_descuento,total_flete,total,sub_total,total_otro,ultimo_costo,iva,descuento,financiamiento,margen_utilidad,ice,anticipo,otros_valores,total_retencion,total_consumo_especial,retencion,id_tipo_cambio,es_cliente,id_asiento_contable,id_pedido,id_responsable,id_estado_fisico_factura_empresa,fecha,fecha_autorizacion,fecha_cliente,numero_documento,numero_dau,numero_referendo,fecha_referendo,aforo_referendo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero_pre_impreso=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,direccion=?,ruc=?,id_cliente=?,id_tipo_precio=?,telefono=?,id_sub_cliente=?,id_vendedor=?,id_transporte=?,id_transportista=?,orden=?,id_tipo_llamada=?,hora_inicio=?,hora_fin=?,id_tipo_factura=?,descripcion=?,cupo=?,saldo=?,documentos=?,disponible=?,porcentaje_descuento=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,total_flete=?,total=?,sub_total=?,total_otro=?,ultimo_costo=?,iva=?,descuento=?,financiamiento=?,margen_utilidad=?,ice=?,anticipo=?,otros_valores=?,total_retencion=?,total_consumo_especial=?,retencion=?,id_tipo_cambio=?,es_cliente=?,id_asiento_contable=?,id_pedido=?,id_responsable=?,id_estado_fisico_factura_empresa=?,fecha=?,fecha_autorizacion=?,fecha_cliente=?,numero_documento=?,numero_dau=?,numero_referendo=?,fecha_referendo=?,aforo_referendo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select factura from "+FacturaConstantesFunciones.SPERSISTENCENAME+" factura";
	public static String QUERYSELECTNATIVE="select "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".version_row,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_empresa,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_periodo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_anio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_mes,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_usuario,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_dias,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_moneda,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".cotizacion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_empleado,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_formato,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".direccion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ruc,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_precio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".telefono,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_sub_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_vendedor,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_transporte,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_transportista,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".orden,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_llamada,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".hora_inicio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".hora_fin,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_factura,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descripcion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".cupo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".saldo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".documentos,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".disponible,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".porcentaje_descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".suman,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descuento_valor,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_sin_iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_flete,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".sub_total,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_otro,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ultimo_costo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".financiamiento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".margen_utilidad,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ice,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".anticipo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".otros_valores,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_retencion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_consumo_especial,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".retencion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".es_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_asiento_contable,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_pedido,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_responsable,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_estado_fisico_factura_empresa,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_autorizacion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_documento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_dau,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_referendo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_referendo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".aforo_referendo from "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME;//+" as "+FacturaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".version_row,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_pre_impreso from "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME;//+" as "+FacturaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero_pre_impreso=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,direccion=?,ruc=?,id_cliente=?,id_tipo_precio=?,telefono=?,id_sub_cliente=?,id_vendedor=?,id_transporte=?,id_transportista=?,orden=?,id_tipo_llamada=?,hora_inicio=?,hora_fin=?,id_tipo_factura=?,descripcion=?,cupo=?,saldo=?,documentos=?,disponible=?,porcentaje_descuento=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,total_flete=?,total=?,sub_total=?,total_otro=?,ultimo_costo=?,iva=?,descuento=?,financiamiento=?,margen_utilidad=?,ice=?,anticipo=?,otros_valores=?,total_retencion=?,total_consumo_especial=?,retencion=?,id_tipo_cambio=?,es_cliente=?,id_asiento_contable=?,id_pedido=?,id_responsable=?,id_estado_fisico_factura_empresa=?,fecha=?,fecha_autorizacion=?,fecha_cliente=?,numero_documento=?,numero_dau=?,numero_referendo=?,fecha_referendo=?,aforo_referendo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURA_SELECT(?,?)";
	
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
	
	
	protected FacturaDataAccessAdditional facturaDataAccessAdditional=null;
	
	public FacturaDataAccessAdditional getFacturaDataAccessAdditional() {
		return this.facturaDataAccessAdditional;
	}
	
	public void setFacturaDataAccessAdditional(FacturaDataAccessAdditional facturaDataAccessAdditional) {
		try {
			this.facturaDataAccessAdditional=facturaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaDataAccess() {
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
		FacturaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaOriginal(Factura factura)throws Exception  {
		factura.setFacturaOriginal((Factura)factura.clone());		
	}
	
	public void setFacturasOriginal(List<Factura> facturas)throws Exception  {
		
		for(Factura factura:facturas){
			factura.setFacturaOriginal((Factura)factura.clone());
		}
	}
	
	public static void setFacturaOriginalStatic(Factura factura)throws Exception  {
		factura.setFacturaOriginal((Factura)factura.clone());		
	}
	
	public static void setFacturasOriginalStatic(List<Factura> facturas)throws Exception  {
		
		for(Factura factura:facturas){
			factura.setFacturaOriginal((Factura)factura.clone());
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
	
	public  Factura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Factura entity = new Factura();		
		
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
	
	public  Factura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Factura entity = new Factura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.Factura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaOriginal(new Factura());
      	    	entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFactura("",entity,resultSet); 
				
				//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFactura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Factura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Factura entity = new Factura();
				
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
	
	public  Factura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Factura entity = new Factura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Factura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaOriginal(new Factura());
      	    	entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFactura("",entity,resultSet);    
				
				//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Factura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Factura entity = new Factura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Factura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Factura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		
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
	
	public  List<Factura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Factura();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFactura("",entity,resultSet);
      	    	
				//entity.setFacturaOriginal( new Factura());
      	    	//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Factura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
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
	
	public  List<Factura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Factura();
				
				if(conMapGenerico) {
					entity.inicializarMapFactura();
					//entity.setMapFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
					entity=FacturaDataAccess.getEntityFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaOriginal( new Factura());
					////entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Factura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Factura entity = new Factura();		  
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
	
	public  Factura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Factura entity = new Factura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Factura();
				
				if(conMapGenerico) {
					entity.inicializarMapFactura();
					//entity.setMapFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
					entity=FacturaDataAccess.getEntityFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaOriginal( new Factura());
					////entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFactura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Factura getEntityFactura(String strPrefijo,Factura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Factura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Factura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaDataAccess.setFieldReflectionFactura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFactura=FacturaConstantesFunciones.getTodosTiposColumnasFactura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFactura) {
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
							field = Factura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Factura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaDataAccess.setFieldReflectionFactura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFactura(Field field,String strPrefijo,String sColumn,Factura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case FacturaConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDSUBCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTIPOLLAMADA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case FacturaConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTIPOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.CUPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.DOCUMENTOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALFLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.MARGENUTILIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.ANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.OTROSVALORES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALRETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.TOTALCONSUMOESPECIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.ESCLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDRESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.FECHAAUTORIZACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.FECHACLIENTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.NUMERODAU:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.NUMEROREFERENDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaConstantesFunciones.FECHAREFERENDO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaConstantesFunciones.AFOROREFERENDO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Factura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Factura();
					entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFactura("",entity,resultSet);
					
					//entity.setFacturaOriginal( new Factura());
					//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Factura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Factura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
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
	
	public  List<Factura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Factura();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFactura("",entity,resultSet);
      	    	
				//entity.setFacturaOriginal( new Factura());
      	    	//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Factura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
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
	
	public  List<Factura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Factura> entities = new  ArrayList<Factura>();
		Factura entity = new Factura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Factura();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFactura("",entity,resultSet);
      	    	
				//entity.setFacturaOriginal( new Factura());
      	    	//entity.setFacturaOriginal(super.getEntity("",entity.getFacturaOriginal(),resultSet,FacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaOriginal(this.getEntityFactura("",entity.getFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Factura getEntityFactura(String strPrefijo,Factura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDUSUARIO));
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+FacturaConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHAEMISION).getTime()));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+FacturaConstantesFunciones.NUMERODIAS));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.COTIZACION));
				entity.setid_empleado(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDEMPLEADO));
				entity.setid_formato(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDFORMATO));
				entity.setdireccion(resultSet.getString(strPrefijo+FacturaConstantesFunciones.DIRECCION));
				entity.setruc(resultSet.getString(strPrefijo+FacturaConstantesFunciones.RUC));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTIPOPRECIO));
				entity.settelefono(resultSet.getString(strPrefijo+FacturaConstantesFunciones.TELEFONO));
				entity.setid_sub_cliente(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDSUBCLIENTE));if(resultSet.wasNull()) {entity.setid_sub_cliente(null); }
				entity.setid_vendedor(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDVENDEDOR));
				entity.setid_transporte(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTRANSPORTE));if(resultSet.wasNull()) {entity.setid_transporte(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setorden(resultSet.getString(strPrefijo+FacturaConstantesFunciones.ORDEN));
				entity.setid_tipo_llamada(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTIPOLLAMADA));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+FacturaConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+FacturaConstantesFunciones.HORAFIN));
				entity.setid_tipo_factura(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTIPOFACTURA));
				entity.setdescripcion(resultSet.getString(strPrefijo+FacturaConstantesFunciones.DESCRIPCION));
				entity.setcupo(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.CUPO));
				entity.setsaldo(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.SALDO));
				entity.setdocumentos(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.DOCUMENTOS));
				entity.setdisponible(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.DISPONIBLE));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.DESCUENTOVALOR));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALSINIVA));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALDESCUENTO));
				entity.settotal_flete(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALFLETE));
				entity.settotal(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTAL));
				entity.setsub_total(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.SUBTOTAL));
				entity.settotal_otro(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALOTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.ULTIMOCOSTO));
				entity.setiva(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.IVA));
				entity.setdescuento(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.DESCUENTO));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.FINANCIAMIENTO));
				entity.setmargen_utilidad(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.MARGENUTILIDAD));
				entity.setice(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.ICE));
				entity.setanticipo(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.ANTICIPO));
				entity.setotros_valores(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.OTROSVALORES));
				entity.settotal_retencion(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALRETENCION));
				entity.settotal_consumo_especial(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.TOTALCONSUMOESPECIAL));
				entity.setretencion(resultSet.getDouble(strPrefijo+FacturaConstantesFunciones.RETENCION));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setes_cliente(resultSet.getBoolean(strPrefijo+FacturaConstantesFunciones.ESCLIENTE));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setid_pedido(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDPEDIDO));if(resultSet.wasNull()) {entity.setid_pedido(null); }
				entity.setid_responsable(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDRESPONSABLE));if(resultSet.wasNull()) {entity.setid_responsable(null); }
				entity.setid_estado_fisico_factura_empresa(resultSet.getLong(strPrefijo+FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA));if(resultSet.wasNull()) {entity.setid_estado_fisico_factura_empresa(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHA).getTime()));
				entity.setfecha_autorizacion(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHAAUTORIZACION).getTime()));
				entity.setfecha_cliente(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHACLIENTE).getTime()));
				entity.setnumero_documento(resultSet.getString(strPrefijo+FacturaConstantesFunciones.NUMERODOCUMENTO));
				entity.setnumero_dau(resultSet.getString(strPrefijo+FacturaConstantesFunciones.NUMERODAU));
				entity.setnumero_referendo(resultSet.getString(strPrefijo+FacturaConstantesFunciones.NUMEROREFERENDO));
				entity.setfecha_referendo(new Date(resultSet.getDate(strPrefijo+FacturaConstantesFunciones.FECHAREFERENDO).getTime()));
				entity.setaforo_referendo(resultSet.getString(strPrefijo+FacturaConstantesFunciones.AFOROREFERENDO));
			} else {
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+FacturaConstantesFunciones.NUMEROPREIMPRESO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFactura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Factura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaDataAccess.TABLENAME,FacturaDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaDataAccess.setFacturaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfactura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfactura.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relfactura.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relfactura.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relfactura.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relfactura.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relfactura.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relfactura.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relfactura.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relfactura.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Cliente getCliente(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfactura.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relfactura.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public SubCliente getSubCliente(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		SubCliente subcliente= new SubCliente();

		try {
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);

			subcliente=subclienteDataAccess.getEntity(connexion,relfactura.getid_sub_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subcliente;

	}

	public Vendedor getVendedor(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relfactura.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Transporte getTransporte(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relfactura.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public Transportista getTransportista(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relfactura.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public TipoLlamada getTipoLlamada(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		TipoLlamada tipollamada= new TipoLlamada();

		try {
			TipoLlamadaDataAccess tipollamadaDataAccess=new TipoLlamadaDataAccess();

			tipollamadaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipollamadaDataAccess.setConnexionType(this.connexionType);
			tipollamadaDataAccess.setParameterDbType(this.parameterDbType);

			tipollamada=tipollamadaDataAccess.getEntity(connexion,relfactura.getid_tipo_llamada());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipollamada;

	}

	public TipoFactura getTipoFactura(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		TipoFactura tipofactura= new TipoFactura();

		try {
			TipoFacturaDataAccess tipofacturaDataAccess=new TipoFacturaDataAccess();

			tipofacturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofacturaDataAccess.setConnexionType(this.connexionType);
			tipofacturaDataAccess.setParameterDbType(this.parameterDbType);

			tipofactura=tipofacturaDataAccess.getEntity(connexion,relfactura.getid_tipo_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofactura;

	}

	public TipoCambio getTipoCambio(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relfactura.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public AsientoContable getAsientoContable(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relfactura.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Pedido getPedido(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Pedido pedido= new Pedido();

		try {
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);

			pedido=pedidoDataAccess.getEntity(connexion,relfactura.getid_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedido;

	}

	public Responsable getResponsable(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		Responsable responsable= new Responsable();

		try {
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);

			responsable=responsableDataAccess.getEntity(connexion,relfactura.getid_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsable;

	}

	public EstadoFisicoFacturaEmpresa getEstadoFisicoFacturaEmpresa(Connexion connexion,Factura relfactura)throws SQLException,Exception {

		EstadoFisicoFacturaEmpresa estadofisicofacturaempresa= new EstadoFisicoFacturaEmpresa();

		try {
			EstadoFisicoFacturaEmpresaDataAccess estadofisicofacturaempresaDataAccess=new EstadoFisicoFacturaEmpresaDataAccess();

			estadofisicofacturaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadofisicofacturaempresaDataAccess.setConnexionType(this.connexionType);
			estadofisicofacturaempresaDataAccess.setParameterDbType(this.parameterDbType);

			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion,relfactura.getid_estado_fisico_factura_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadofisicofacturaempresa;

	}


		
		public List<DetaFormaPago> getDetaFormaPagos(Connexion connexion,Factura factura)throws SQLException,Exception {

		List<DetaFormaPago> detaformapagos= new ArrayList<DetaFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaConstantesFunciones.SCHEMA+".factura ON "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id_factura="+FacturaConstantesFunciones.SCHEMA+".factura.id WHERE "+FacturaConstantesFunciones.SCHEMA+".factura.id="+String.valueOf(factura.getId());
			} else {
				sQuery=" INNER JOIN detaformapago.Factura WHERE detaformapago.Factura.id="+String.valueOf(factura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaFormaPagoDataAccess detaformapagoDataAccess=new DetaFormaPagoDataAccess();

			detaformapagoDataAccess.setConnexionType(this.connexionType);
			detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagos;

	}

	public List<DetalleFactura> getDetalleFacturas(Connexion connexion,Factura factura)throws SQLException,Exception {

		List<DetalleFactura> detallefacturas= new ArrayList<DetalleFactura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaConstantesFunciones.SCHEMA+".factura ON "+DetalleFacturaConstantesFunciones.SCHEMA+".detalle_factura.id_factura="+FacturaConstantesFunciones.SCHEMA+".factura.id WHERE "+FacturaConstantesFunciones.SCHEMA+".factura.id="+String.valueOf(factura.getId());
			} else {
				sQuery=" INNER JOIN detallefactura.Factura WHERE detallefactura.Factura.id="+String.valueOf(factura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaDataAccess detallefacturaDataAccess=new DetalleFacturaDataAccess();

			detallefacturaDataAccess.setConnexionType(this.connexionType);
			detallefacturaDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturas=detallefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Factura factura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!factura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(factura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(factura.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(factura.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(factura.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(factura.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(factura.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(factura.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(factura.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(factura.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(factura.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(factura.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(factura.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(factura.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(factura.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(factura.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(factura.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(factura.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(factura.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(factura.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(factura.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_cliente.setValue(factura.getid_sub_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(factura.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(factura.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(factura.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorden=new ParameterValue<String>();
					parameterMaintenanceValueorden.setValue(factura.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_llamada=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_llamada.setValue(factura.getid_tipo_llamada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_llamada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(factura.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(factura.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_factura.setValue(factura.getid_tipo_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(factura.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecupo=new ParameterValue<Double>();
					parameterMaintenanceValuecupo.setValue(factura.getcupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo.setValue(factura.getsaldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedocumentos=new ParameterValue<Double>();
					parameterMaintenanceValuedocumentos.setValue(factura.getdocumentos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedocumentos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedisponible=new ParameterValue<Double>();
					parameterMaintenanceValuedisponible.setValue(factura.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(factura.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(factura.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(factura.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(factura.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(factura.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(factura.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_flete=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_flete.setValue(factura.gettotal_flete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_flete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(factura.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(factura.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_otro.setValue(factura.gettotal_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(factura.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(factura.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(factura.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(factura.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemargen_utilidad=new ParameterValue<Double>();
					parameterMaintenanceValuemargen_utilidad.setValue(factura.getmargen_utilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemargen_utilidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(factura.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueanticipo=new ParameterValue<Double>();
					parameterMaintenanceValueanticipo.setValue(factura.getanticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_valores=new ParameterValue<Double>();
					parameterMaintenanceValueotros_valores.setValue(factura.getotros_valores());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_valores);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_retencion.setValue(factura.gettotal_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_consumo_especial=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_consumo_especial.setValue(factura.gettotal_consumo_especial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_consumo_especial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(factura.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(factura.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_cliente.setValue(factura.getes_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(factura.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido.setValue(factura.getid_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable.setValue(factura.getid_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_fisico_factura_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_fisico_factura_empresa.setValue(factura.getid_estado_fisico_factura_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_fisico_factura_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(factura.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autorizacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autorizacion.setValue(factura.getfecha_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_cliente=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_cliente.setValue(factura.getfecha_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_documento=new ParameterValue<String>();
					parameterMaintenanceValuenumero_documento.setValue(factura.getnumero_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_dau=new ParameterValue<String>();
					parameterMaintenanceValuenumero_dau.setValue(factura.getnumero_dau());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dau);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_referendo=new ParameterValue<String>();
					parameterMaintenanceValuenumero_referendo.setValue(factura.getnumero_referendo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_referendo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_referendo=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_referendo.setValue(factura.getfecha_referendo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_referendo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueaforo_referendo=new ParameterValue<String>();
					parameterMaintenanceValueaforo_referendo.setValue(factura.getaforo_referendo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueaforo_referendo);
					parametersTemp.add(parameterMaintenance);
					
						if(!factura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(factura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(factura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(factura.getId());
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
	
	public void setIsNewIsChangedFalseFactura(Factura factura)throws Exception  {		
		factura.setIsNew(false);
		factura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturas(List<Factura> facturas)throws Exception  {				
		for(Factura factura:facturas) {
			factura.setIsNew(false);
			factura.setIsChanged(false);
		}
	}
	
	public void generarExportarFactura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
