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
package com.bydan.erp.puntoventa.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.puntoventa.util.FacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FacturaPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaPuntoVentaConstantesFunciones extends FacturaPuntoVentaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-20);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="FacturaPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaPuntoVenta"+FacturaPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Factura Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaPuntoVenta";
	public static final String OBJECTNAME="facturapuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturapuntoventa from "+FacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" facturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_formato,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_factura_punto_venta,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_estado_factura_punto_venta,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".hora,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total_iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total_sin_iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".iva,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".financiamiento,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".flete,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".ice,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".otros,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME+".total from "+FacturaPuntoVentaConstantesFunciones.SCHEMA+"."+FacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected FacturaPuntoVentaConstantesFuncionesAdditional facturapuntoventaConstantesFuncionesAdditional=null;
	
	public FacturaPuntoVentaConstantesFuncionesAdditional getFacturaPuntoVentaConstantesFuncionesAdditional() {
		return this.facturapuntoventaConstantesFuncionesAdditional;
	}
	
	public void setFacturaPuntoVentaConstantesFuncionesAdditional(FacturaPuntoVentaConstantesFuncionesAdditional facturapuntoventaConstantesFuncionesAdditional) {
		try {
			this.facturapuntoventaConstantesFuncionesAdditional=facturapuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCAJA= "id_caja";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDMESA= "id_mesa";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOFACTURAPUNTOVENTA= "id_tipo_factura_punto_venta";
    public static final String IDESTADOFACTURAPUNTOVENTA= "id_estado_factura_punto_venta";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String TARJETACLIENTE= "tarjeta_cliente";
    public static final String DIRECCIONCLIENTE= "direccion_cliente";
    public static final String TELEFONOCLIENTE= "telefono_cliente";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String OTROS= "otros";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDMESA= "Mesa";
		public static final String LABEL_IDMESA_LOWER= "Mesa";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOFACTURAPUNTOVENTA= "Tipo";
		public static final String LABEL_IDTIPOFACTURAPUNTOVENTA_LOWER= "Tipo Factura Punto Venta";
    	public static final String LABEL_IDESTADOFACTURAPUNTOVENTA= "Estado";
		public static final String LABEL_IDESTADOFACTURAPUNTOVENTA_LOWER= "Estado Factura Punto Venta";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_TARJETACLIENTE= "Tarjeta Cliente";
		public static final String LABEL_TARJETACLIENTE_LOWER= "Tarjeta Cliente";
    	public static final String LABEL_DIRECCIONCLIENTE= "Direccion Cliente";
		public static final String LABEL_DIRECCIONCLIENTE_LOWER= "Direccion Cliente";
    	public static final String LABEL_TELEFONOCLIENTE= "Telefono Cliente";
		public static final String LABEL_TELEFONOCLIENTE_LOWER= "Telefono Cliente";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_OTROS= "Otros";
		public static final String LABEL_OTROS_LOWER= "Otros";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTARJETA_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTARJETA_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_CLIENTE=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getFacturaPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDUSUARIO)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDCAJA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDMESA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDMESA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDFORMATO)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDESTADOFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.FECHA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.HORA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.TOTALIVA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.TOTALSINIVA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.FLETE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.OTROS)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_OTROS;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(FacturaPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturaPuntoVentaDescripcion(FacturaPuntoVenta facturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturapuntoventa !=null/* && facturapuntoventa.getId()!=0*/) {
			sDescripcion=facturapuntoventa.getnumero_secuencial();//facturapuntoventafacturapuntoventa.getnumero_secuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaPuntoVentaDescripcionDetallado(FacturaPuntoVenta facturapuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=facturapuntoventa.getId().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturapuntoventa.getVersionRow().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturapuntoventa.getid_empresa().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturapuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=facturapuntoventa.getid_usuario().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=facturapuntoventa.getid_vendedor().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturapuntoventa.getid_cliente().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=facturapuntoventa.getid_caja().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=facturapuntoventa.getid_tipo_precio().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDMESA+"=";
		sDescripcion+=facturapuntoventa.getid_mesa().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=facturapuntoventa.getid_formato().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA+"=";
		sDescripcion+=facturapuntoventa.getid_tipo_factura_punto_venta().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA+"=";
		sDescripcion+=facturapuntoventa.getid_estado_factura_punto_venta().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=facturapuntoventa.getid_asiento_contable().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=facturapuntoventa.getnumero_secuencial()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=facturapuntoventa.getcodigo_cliente()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=facturapuntoventa.getnombre_cliente()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE+"=";
		sDescripcion+=facturapuntoventa.gettarjeta_cliente()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=facturapuntoventa.getdireccion_cliente()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=facturapuntoventa.gettelefono_cliente()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.FECHA+"=";
		sDescripcion+=facturapuntoventa.getfecha().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.HORA+"=";
		sDescripcion+=facturapuntoventa.gethora().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=facturapuntoventa.gettotal_iva().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=facturapuntoventa.gettotal_sin_iva().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=facturapuntoventa.getiva().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=facturapuntoventa.getdescuento().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=facturapuntoventa.getfinanciamiento().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.FLETE+"=";
		sDescripcion+=facturapuntoventa.getflete().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=facturapuntoventa.getice().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.OTROS+"=";
		sDescripcion+=facturapuntoventa.getotros().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=facturapuntoventa.getsub_total().toString()+",";
		sDescripcion+=FacturaPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturapuntoventa.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaPuntoVentaDescripcion(FacturaPuntoVenta facturapuntoventa,String sValor) throws Exception {			
		if(facturapuntoventa !=null) {
			facturapuntoventa.setnumero_secuencial(sValor);;//facturapuntoventafacturapuntoventa.getnumero_secuencial().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getMesaDescripcion(Mesa mesa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mesa!=null/*&&mesa.getId()>0*/) {
			sDescripcion=MesaConstantesFunciones.getMesaDescripcion(mesa);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTipoFacturaPuntoVentaDescripcion(TipoFacturaPuntoVenta tipofacturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofacturapuntoventa!=null/*&&tipofacturapuntoventa.getId()>0*/) {
			sDescripcion=TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(tipofacturapuntoventa);
		}

		return sDescripcion;
	}

	public static String getEstadoFacturaPuntoVentaDescripcion(EstadoFacturaPuntoVenta estadofacturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadofacturapuntoventa!=null/*&&estadofacturapuntoventa.getId()>0*/) {
			sDescripcion=EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaDescripcion(estadofacturapuntoventa);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoFacturaPuntoVenta")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMesa")) {
			sNombreIndice="Tipo=  Por Mesa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFacturaPuntoVenta")) {
			sNombreIndice="Tipo=  Por Tipo";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoFacturaPuntoVenta(Long id_estado_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_factura_punto_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesa(Long id_mesa) {
		String sDetalleIndice=" Parametros->";
		if(id_mesa!=null) {sDetalleIndice+=" Codigo Unico De Mesa="+id_mesa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFacturaPuntoVenta(Long id_tipo_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_factura_punto_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturapuntoventa.setnumero_secuencial(facturapuntoventa.getnumero_secuencial().trim());
		facturapuntoventa.setcodigo_cliente(facturapuntoventa.getcodigo_cliente().trim());
		facturapuntoventa.setnombre_cliente(facturapuntoventa.getnombre_cliente().trim());
		facturapuntoventa.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente().trim());
		facturapuntoventa.setdireccion_cliente(facturapuntoventa.getdireccion_cliente().trim());
		facturapuntoventa.settelefono_cliente(facturapuntoventa.gettelefono_cliente().trim());
	}
	
	public static void quitarEspaciosFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {
			facturapuntoventa.setnumero_secuencial(facturapuntoventa.getnumero_secuencial().trim());
			facturapuntoventa.setcodigo_cliente(facturapuntoventa.getcodigo_cliente().trim());
			facturapuntoventa.setnombre_cliente(facturapuntoventa.getnombre_cliente().trim());
			facturapuntoventa.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente().trim());
			facturapuntoventa.setdireccion_cliente(facturapuntoventa.getdireccion_cliente().trim());
			facturapuntoventa.settelefono_cliente(facturapuntoventa.gettelefono_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturapuntoventa.getConCambioAuxiliar()) {
			facturapuntoventa.setIsDeleted(facturapuntoventa.getIsDeletedAuxiliar());	
			facturapuntoventa.setIsNew(facturapuntoventa.getIsNewAuxiliar());	
			facturapuntoventa.setIsChanged(facturapuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturapuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturapuntoventa.setIsDeletedAuxiliar(false);	
			facturapuntoventa.setIsNewAuxiliar(false);	
			facturapuntoventa.setIsChangedAuxiliar(false);
			
			facturapuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa : facturapuntoventas) {
			if(conAsignarBase && facturapuntoventa.getConCambioAuxiliar()) {
				facturapuntoventa.setIsDeleted(facturapuntoventa.getIsDeletedAuxiliar());	
				facturapuntoventa.setIsNew(facturapuntoventa.getIsNewAuxiliar());	
				facturapuntoventa.setIsChanged(facturapuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturapuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturapuntoventa.setIsDeletedAuxiliar(false);	
				facturapuntoventa.setIsNewAuxiliar(false);	
				facturapuntoventa.setIsChangedAuxiliar(false);
				
				facturapuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa,Boolean conEnteros) throws Exception  {
		facturapuntoventa.settotal_iva(0.0);
		facturapuntoventa.settotal_sin_iva(0.0);
		facturapuntoventa.setiva(0.0);
		facturapuntoventa.setdescuento(0.0);
		facturapuntoventa.setfinanciamiento(0.0);
		facturapuntoventa.setflete(0.0);
		facturapuntoventa.setice(0.0);
		facturapuntoventa.setotros(0.0);
		facturapuntoventa.setsub_total(0.0);
		facturapuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas,Boolean conEnteros) throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {
			facturapuntoventa.settotal_iva(0.0);
			facturapuntoventa.settotal_sin_iva(0.0);
			facturapuntoventa.setiva(0.0);
			facturapuntoventa.setdescuento(0.0);
			facturapuntoventa.setfinanciamiento(0.0);
			facturapuntoventa.setflete(0.0);
			facturapuntoventa.setice(0.0);
			facturapuntoventa.setotros(0.0);
			facturapuntoventa.setsub_total(0.0);
			facturapuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaPuntoVenta(List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVenta facturapuntoventaAux) throws Exception  {
		FacturaPuntoVentaConstantesFunciones.InicializarValoresFacturaPuntoVenta(facturapuntoventaAux,true);
		
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {
			if(facturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturapuntoventaAux.settotal_iva(facturapuntoventaAux.gettotal_iva()+facturapuntoventa.gettotal_iva());			
			facturapuntoventaAux.settotal_sin_iva(facturapuntoventaAux.gettotal_sin_iva()+facturapuntoventa.gettotal_sin_iva());			
			facturapuntoventaAux.setiva(facturapuntoventaAux.getiva()+facturapuntoventa.getiva());			
			facturapuntoventaAux.setdescuento(facturapuntoventaAux.getdescuento()+facturapuntoventa.getdescuento());			
			facturapuntoventaAux.setfinanciamiento(facturapuntoventaAux.getfinanciamiento()+facturapuntoventa.getfinanciamiento());			
			facturapuntoventaAux.setflete(facturapuntoventaAux.getflete()+facturapuntoventa.getflete());			
			facturapuntoventaAux.setice(facturapuntoventaAux.getice()+facturapuntoventa.getice());			
			facturapuntoventaAux.setotros(facturapuntoventaAux.getotros()+facturapuntoventa.getotros());			
			facturapuntoventaAux.setsub_total(facturapuntoventaAux.getsub_total()+facturapuntoventa.getsub_total());			
			facturapuntoventaAux.settotal(facturapuntoventaAux.gettotal()+facturapuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaPuntoVentaConstantesFunciones.getArrayColumnasGlobalesFacturaPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaPuntoVentaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVenta facturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaPuntoVenta facturapuntoventaAux: facturapuntoventas) {
			if(facturapuntoventaAux!=null && facturapuntoventa!=null) {
				if((facturapuntoventaAux.getId()==null && facturapuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturapuntoventaAux.getId()!=null && facturapuntoventa.getId()!=null){
					if(facturapuntoventaAux.getId().equals(facturapuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaPuntoVenta(List<FacturaPuntoVenta> facturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double otrosTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {			
			if(facturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=facturapuntoventa.gettotal_iva();
			total_sin_ivaTotal+=facturapuntoventa.gettotal_sin_iva();
			ivaTotal+=facturapuntoventa.getiva();
			descuentoTotal+=facturapuntoventa.getdescuento();
			financiamientoTotal+=facturapuntoventa.getfinanciamiento();
			fleteTotal+=facturapuntoventa.getflete();
			iceTotal+=facturapuntoventa.getice();
			otrosTotal+=facturapuntoventa.getotros();
			sub_totalTotal+=facturapuntoventa.getsub_total();
			totalTotal+=facturapuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.OTROS);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_OTROS);
		datoGeneral.setdValorDouble(otrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_ID, FacturaPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_VERSIONROW, FacturaPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, FacturaPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, FacturaPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDUSUARIO, FacturaPuntoVentaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR, FacturaPuntoVentaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDCLIENTE, FacturaPuntoVentaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDCAJA, FacturaPuntoVentaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO, FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDMESA, FacturaPuntoVentaConstantesFunciones.IDMESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDFORMATO, FacturaPuntoVentaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA, FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDESTADOFACTURAPUNTOVENTA, FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE, FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL, FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE, FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE, FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE, FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE, FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE, FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_FECHA, FacturaPuntoVentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_HORA, FacturaPuntoVentaConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA, FacturaPuntoVentaConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA, FacturaPuntoVentaConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_IVA, FacturaPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO, FacturaPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO, FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_FLETE, FacturaPuntoVentaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_ICE, FacturaPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_OTROS, FacturaPuntoVentaConstantesFunciones.OTROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, FacturaPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL, FacturaPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDMESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.OTROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaPuntoVenta() throws Exception  {
		return FacturaPuntoVentaConstantesFunciones.getTiposSeleccionarFacturaPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaPuntoVenta(Boolean conFk) throws Exception  {
		return FacturaPuntoVentaConstantesFunciones.getTiposSeleccionarFacturaPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDMESA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDMESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDESTADOFACTURAPUNTOVENTA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDESTADOFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_OTROS);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_OTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventaAux) throws Exception {
		
			facturapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturapuntoventaAux.getEmpresa()));
			facturapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturapuntoventaAux.getSucursal()));
			facturapuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(facturapuntoventaAux.getUsuario()));
			facturapuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturapuntoventaAux.getVendedor()));
			facturapuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturapuntoventaAux.getCliente()));
			facturapuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(facturapuntoventaAux.getCaja()));
			facturapuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(facturapuntoventaAux.getTipoPrecio()));
			facturapuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(facturapuntoventaAux.getMesa()));
			facturapuntoventaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(facturapuntoventaAux.getFormato()));
			facturapuntoventaAux.settipofacturapuntoventa_descripcion(TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(facturapuntoventaAux.getTipoFacturaPuntoVenta()));
			facturapuntoventaAux.setestadofacturapuntoventa_descripcion(EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaDescripcion(facturapuntoventaAux.getEstadoFacturaPuntoVenta()));
			facturapuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(facturapuntoventaAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaPuntoVenta(List<FacturaPuntoVenta> facturapuntoventasTemp) throws Exception {
		for(FacturaPuntoVenta facturapuntoventaAux:facturapuntoventasTemp) {
			
			facturapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturapuntoventaAux.getEmpresa()));
			facturapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturapuntoventaAux.getSucursal()));
			facturapuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(facturapuntoventaAux.getUsuario()));
			facturapuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturapuntoventaAux.getVendedor()));
			facturapuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturapuntoventaAux.getCliente()));
			facturapuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(facturapuntoventaAux.getCaja()));
			facturapuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(facturapuntoventaAux.getTipoPrecio()));
			facturapuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(facturapuntoventaAux.getMesa()));
			facturapuntoventaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(facturapuntoventaAux.getFormato()));
			facturapuntoventaAux.settipofacturapuntoventa_descripcion(TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(facturapuntoventaAux.getTipoFacturaPuntoVenta()));
			facturapuntoventaAux.setestadofacturapuntoventa_descripcion(EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaDescripcion(facturapuntoventaAux.getEstadoFacturaPuntoVenta()));
			facturapuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(facturapuntoventaAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Mesa.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoFacturaPuntoVenta.class));
				classes.add(new Classe(EstadoFacturaPuntoVenta.class));
				classes.add(new Classe(AsientoContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mesa.class)) {
						classes.add(new Classe(Mesa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
						classes.add(new Classe(TipoFacturaPuntoVenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
						classes.add(new Classe(EstadoFacturaPuntoVenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFacturaPuntoVenta.class)); continue;
					}

					if(EstadoFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFacturaPuntoVenta.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFacturaPuntoVenta.class)); continue;
					}

					if(EstadoFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFacturaPuntoVenta.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfFacturaPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(HistorialFormaPagoPuntoVenta.class));
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				classes.add(new Classe(DetalleFacturaPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialFormaPagoPuntoVenta.class)) {
						classes.add(new Classe(HistorialFormaPagoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleFacturaPuntoVenta.class)) {
						classes.add(new Classe(DetalleFacturaPuntoVenta.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(HistorialFormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialFormaPagoPuntoVenta.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(DetalleFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(HistorialFormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialFormaPagoPuntoVenta.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(DetalleFacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(FacturaPuntoVenta facturapuntoventa,List<FacturaPuntoVenta> facturapuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FacturaPuntoVenta facturapuntoventaEncontrado=null;
			
			for(FacturaPuntoVenta facturapuntoventaLocal:facturapuntoventas) {
				if(facturapuntoventaLocal.getId().equals(facturapuntoventa.getId())) {
					facturapuntoventaEncontrado=facturapuntoventaLocal;
					
					facturapuntoventaLocal.setIsChanged(facturapuntoventa.getIsChanged());
					facturapuntoventaLocal.setIsNew(facturapuntoventa.getIsNew());
					facturapuntoventaLocal.setIsDeleted(facturapuntoventa.getIsDeleted());
					
					facturapuntoventaLocal.setGeneralEntityOriginal(facturapuntoventa.getGeneralEntityOriginal());
					
					facturapuntoventaLocal.setId(facturapuntoventa.getId());	
					facturapuntoventaLocal.setVersionRow(facturapuntoventa.getVersionRow());	
					facturapuntoventaLocal.setid_empresa(facturapuntoventa.getid_empresa());	
					facturapuntoventaLocal.setid_sucursal(facturapuntoventa.getid_sucursal());	
					facturapuntoventaLocal.setid_usuario(facturapuntoventa.getid_usuario());	
					facturapuntoventaLocal.setid_vendedor(facturapuntoventa.getid_vendedor());	
					facturapuntoventaLocal.setid_cliente(facturapuntoventa.getid_cliente());	
					facturapuntoventaLocal.setid_caja(facturapuntoventa.getid_caja());	
					facturapuntoventaLocal.setid_tipo_precio(facturapuntoventa.getid_tipo_precio());	
					facturapuntoventaLocal.setid_mesa(facturapuntoventa.getid_mesa());	
					facturapuntoventaLocal.setid_formato(facturapuntoventa.getid_formato());	
					facturapuntoventaLocal.setid_tipo_factura_punto_venta(facturapuntoventa.getid_tipo_factura_punto_venta());	
					facturapuntoventaLocal.setid_estado_factura_punto_venta(facturapuntoventa.getid_estado_factura_punto_venta());	
					facturapuntoventaLocal.setid_asiento_contable(facturapuntoventa.getid_asiento_contable());	
					facturapuntoventaLocal.setnumero_secuencial(facturapuntoventa.getnumero_secuencial());	
					facturapuntoventaLocal.setcodigo_cliente(facturapuntoventa.getcodigo_cliente());	
					facturapuntoventaLocal.setnombre_cliente(facturapuntoventa.getnombre_cliente());	
					facturapuntoventaLocal.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente());	
					facturapuntoventaLocal.setdireccion_cliente(facturapuntoventa.getdireccion_cliente());	
					facturapuntoventaLocal.settelefono_cliente(facturapuntoventa.gettelefono_cliente());	
					facturapuntoventaLocal.setfecha(facturapuntoventa.getfecha());	
					facturapuntoventaLocal.sethora(facturapuntoventa.gethora());	
					facturapuntoventaLocal.settotal_iva(facturapuntoventa.gettotal_iva());	
					facturapuntoventaLocal.settotal_sin_iva(facturapuntoventa.gettotal_sin_iva());	
					facturapuntoventaLocal.setiva(facturapuntoventa.getiva());	
					facturapuntoventaLocal.setdescuento(facturapuntoventa.getdescuento());	
					facturapuntoventaLocal.setfinanciamiento(facturapuntoventa.getfinanciamiento());	
					facturapuntoventaLocal.setflete(facturapuntoventa.getflete());	
					facturapuntoventaLocal.setice(facturapuntoventa.getice());	
					facturapuntoventaLocal.setotros(facturapuntoventa.getotros());	
					facturapuntoventaLocal.setsub_total(facturapuntoventa.getsub_total());	
					facturapuntoventaLocal.settotal(facturapuntoventa.gettotal());	
					
					
					facturapuntoventaLocal.setFormaPagoPuntoVentas(facturapuntoventa.getFormaPagoPuntoVentas());
					facturapuntoventaLocal.setDetalleFacturaPuntoVentas(facturapuntoventa.getDetalleFacturaPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!facturapuntoventa.getIsDeleted()) {
				if(!existe) {
					facturapuntoventas.add(facturapuntoventa);
				}
			} else {
				if(facturapuntoventaEncontrado!=null && permiteQuitar)  {
					facturapuntoventas.remove(facturapuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FacturaPuntoVenta facturapuntoventa,List<FacturaPuntoVenta> facturapuntoventas) throws Exception {
		try	{			
			for(FacturaPuntoVenta facturapuntoventaLocal:facturapuntoventas) {
				if(facturapuntoventaLocal.getId().equals(facturapuntoventa.getId())) {
					facturapuntoventaLocal.setIsSelected(facturapuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaPuntoVenta(List<FacturaPuntoVenta> facturapuntoventasAux) throws Exception {
		//this.facturapuntoventasAux=facturapuntoventasAux;
		
		for(FacturaPuntoVenta facturapuntoventaAux:facturapuntoventasAux) {
			if(facturapuntoventaAux.getIsChanged()) {
				facturapuntoventaAux.setIsChanged(false);
			}		
			
			if(facturapuntoventaAux.getIsNew()) {
				facturapuntoventaAux.setIsNew(false);
			}	
			
			if(facturapuntoventaAux.getIsDeleted()) {
				facturapuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventaAux) throws Exception {
		//this.facturapuntoventaAux=facturapuntoventaAux;
		
			if(facturapuntoventaAux.getIsChanged()) {
				facturapuntoventaAux.setIsChanged(false);
			}		
			
			if(facturapuntoventaAux.getIsNew()) {
				facturapuntoventaAux.setIsNew(false);
			}	
			
			if(facturapuntoventaAux.getIsDeleted()) {
				facturapuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaPuntoVenta facturapuntoventaAsignar,FacturaPuntoVenta facturapuntoventa) throws Exception {
		facturapuntoventaAsignar.setId(facturapuntoventa.getId());	
		facturapuntoventaAsignar.setVersionRow(facturapuntoventa.getVersionRow());	
		facturapuntoventaAsignar.setid_empresa(facturapuntoventa.getid_empresa());
		facturapuntoventaAsignar.setempresa_descripcion(facturapuntoventa.getempresa_descripcion());	
		facturapuntoventaAsignar.setid_sucursal(facturapuntoventa.getid_sucursal());
		facturapuntoventaAsignar.setsucursal_descripcion(facturapuntoventa.getsucursal_descripcion());	
		facturapuntoventaAsignar.setid_usuario(facturapuntoventa.getid_usuario());
		facturapuntoventaAsignar.setusuario_descripcion(facturapuntoventa.getusuario_descripcion());	
		facturapuntoventaAsignar.setid_vendedor(facturapuntoventa.getid_vendedor());
		facturapuntoventaAsignar.setvendedor_descripcion(facturapuntoventa.getvendedor_descripcion());	
		facturapuntoventaAsignar.setid_cliente(facturapuntoventa.getid_cliente());
		facturapuntoventaAsignar.setcliente_descripcion(facturapuntoventa.getcliente_descripcion());	
		facturapuntoventaAsignar.setid_caja(facturapuntoventa.getid_caja());
		facturapuntoventaAsignar.setcaja_descripcion(facturapuntoventa.getcaja_descripcion());	
		facturapuntoventaAsignar.setid_tipo_precio(facturapuntoventa.getid_tipo_precio());
		facturapuntoventaAsignar.settipoprecio_descripcion(facturapuntoventa.gettipoprecio_descripcion());	
		facturapuntoventaAsignar.setid_mesa(facturapuntoventa.getid_mesa());
		facturapuntoventaAsignar.setmesa_descripcion(facturapuntoventa.getmesa_descripcion());	
		facturapuntoventaAsignar.setid_formato(facturapuntoventa.getid_formato());
		facturapuntoventaAsignar.setformato_descripcion(facturapuntoventa.getformato_descripcion());	
		facturapuntoventaAsignar.setid_tipo_factura_punto_venta(facturapuntoventa.getid_tipo_factura_punto_venta());
		facturapuntoventaAsignar.settipofacturapuntoventa_descripcion(facturapuntoventa.gettipofacturapuntoventa_descripcion());	
		facturapuntoventaAsignar.setid_estado_factura_punto_venta(facturapuntoventa.getid_estado_factura_punto_venta());
		facturapuntoventaAsignar.setestadofacturapuntoventa_descripcion(facturapuntoventa.getestadofacturapuntoventa_descripcion());	
		facturapuntoventaAsignar.setid_asiento_contable(facturapuntoventa.getid_asiento_contable());
		facturapuntoventaAsignar.setasientocontable_descripcion(facturapuntoventa.getasientocontable_descripcion());	
		facturapuntoventaAsignar.setnumero_secuencial(facturapuntoventa.getnumero_secuencial());	
		facturapuntoventaAsignar.setcodigo_cliente(facturapuntoventa.getcodigo_cliente());	
		facturapuntoventaAsignar.setnombre_cliente(facturapuntoventa.getnombre_cliente());	
		facturapuntoventaAsignar.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente());	
		facturapuntoventaAsignar.setdireccion_cliente(facturapuntoventa.getdireccion_cliente());	
		facturapuntoventaAsignar.settelefono_cliente(facturapuntoventa.gettelefono_cliente());	
		facturapuntoventaAsignar.setfecha(facturapuntoventa.getfecha());	
		facturapuntoventaAsignar.sethora(facturapuntoventa.gethora());	
		facturapuntoventaAsignar.settotal_iva(facturapuntoventa.gettotal_iva());	
		facturapuntoventaAsignar.settotal_sin_iva(facturapuntoventa.gettotal_sin_iva());	
		facturapuntoventaAsignar.setiva(facturapuntoventa.getiva());	
		facturapuntoventaAsignar.setdescuento(facturapuntoventa.getdescuento());	
		facturapuntoventaAsignar.setfinanciamiento(facturapuntoventa.getfinanciamiento());	
		facturapuntoventaAsignar.setflete(facturapuntoventa.getflete());	
		facturapuntoventaAsignar.setice(facturapuntoventa.getice());	
		facturapuntoventaAsignar.setotros(facturapuntoventa.getotros());	
		facturapuntoventaAsignar.setsub_total(facturapuntoventa.getsub_total());	
		facturapuntoventaAsignar.settotal(facturapuntoventa.gettotal());	
	}
	
	public static void inicializarFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa) throws Exception {
		try {
				facturapuntoventa.setId(0L);	
					
				facturapuntoventa.setid_empresa(-1L);	
				facturapuntoventa.setid_sucursal(-1L);	
				facturapuntoventa.setid_usuario(-1L);	
				facturapuntoventa.setid_vendedor(-1L);	
				facturapuntoventa.setid_cliente(-1L);	
				facturapuntoventa.setid_caja(-1L);	
				facturapuntoventa.setid_tipo_precio(-1L);	
				facturapuntoventa.setid_mesa(-1L);	
				facturapuntoventa.setid_formato(-1L);	
				facturapuntoventa.setid_tipo_factura_punto_venta(-1L);	
				facturapuntoventa.setid_estado_factura_punto_venta(-1L);	
				facturapuntoventa.setid_asiento_contable(null);	
				facturapuntoventa.setnumero_secuencial("");	
				facturapuntoventa.setcodigo_cliente("");	
				facturapuntoventa.setnombre_cliente("");	
				facturapuntoventa.settarjeta_cliente("");	
				facturapuntoventa.setdireccion_cliente("");	
				facturapuntoventa.settelefono_cliente("");	
				facturapuntoventa.setfecha(new Date());	
				facturapuntoventa.sethora(new Time((new Date()).getTime()));	
				facturapuntoventa.settotal_iva(0.0);	
				facturapuntoventa.settotal_sin_iva(0.0);	
				facturapuntoventa.setiva(0.0);	
				facturapuntoventa.setdescuento(0.0);	
				facturapuntoventa.setfinanciamiento(0.0);	
				facturapuntoventa.setflete(0.0);	
				facturapuntoventa.setice(0.0);	
				facturapuntoventa.setotros(0.0);	
				facturapuntoventa.setsub_total(0.0);	
				facturapuntoventa.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDMESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDESTADOFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_OTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaPuntoVenta(String sTipo,Row row,Workbook workbook,FacturaPuntoVenta facturapuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getmesa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettipofacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getestadofacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettarjeta_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getotros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturapuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturaPuntoVenta() {
		return this.sFinalQueryFacturaPuntoVenta;
	}
	
	public void setsFinalQueryFacturaPuntoVenta(String sFinalQueryFacturaPuntoVenta) {
		this.sFinalQueryFacturaPuntoVenta= sFinalQueryFacturaPuntoVenta;
	}
	
	public Border resaltarSeleccionarFacturaPuntoVenta=null;
	
	public Border setResaltarSeleccionarFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaPuntoVenta() {
		return this.resaltarSeleccionarFacturaPuntoVenta;
	}
	
	public void setResaltarSeleccionarFacturaPuntoVenta(Border borderResaltarSeleccionarFacturaPuntoVenta) {
		this.resaltarSeleccionarFacturaPuntoVenta= borderResaltarSeleccionarFacturaPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaPuntoVenta=null;
	public Boolean mostraridFacturaPuntoVenta=true;
	public Boolean activaridFacturaPuntoVenta=true;

	public Border resaltarid_empresaFacturaPuntoVenta=null;
	public Boolean mostrarid_empresaFacturaPuntoVenta=true;
	public Boolean activarid_empresaFacturaPuntoVenta=true;
	public Boolean cargarid_empresaFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturaPuntoVenta=null;
	public Boolean mostrarid_sucursalFacturaPuntoVenta=true;
	public Boolean activarid_sucursalFacturaPuntoVenta=true;
	public Boolean cargarid_sucursalFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_usuarioFacturaPuntoVenta=null;
	public Boolean mostrarid_usuarioFacturaPuntoVenta=true;
	public Boolean activarid_usuarioFacturaPuntoVenta=true;
	public Boolean cargarid_usuarioFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_vendedorFacturaPuntoVenta=null;
	public Boolean mostrarid_vendedorFacturaPuntoVenta=true;
	public Boolean activarid_vendedorFacturaPuntoVenta=true;
	public Boolean cargarid_vendedorFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_clienteFacturaPuntoVenta=null;
	public Boolean mostrarid_clienteFacturaPuntoVenta=true;
	public Boolean activarid_clienteFacturaPuntoVenta=true;
	public Boolean cargarid_clienteFacturaPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_cajaFacturaPuntoVenta=null;
	public Boolean mostrarid_cajaFacturaPuntoVenta=true;
	public Boolean activarid_cajaFacturaPuntoVenta=true;
	public Boolean cargarid_cajaFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioFacturaPuntoVenta=null;
	public Boolean mostrarid_tipo_precioFacturaPuntoVenta=true;
	public Boolean activarid_tipo_precioFacturaPuntoVenta=true;
	public Boolean cargarid_tipo_precioFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_mesaFacturaPuntoVenta=null;
	public Boolean mostrarid_mesaFacturaPuntoVenta=true;
	public Boolean activarid_mesaFacturaPuntoVenta=true;
	public Boolean cargarid_mesaFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesaFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_formatoFacturaPuntoVenta=null;
	public Boolean mostrarid_formatoFacturaPuntoVenta=true;
	public Boolean activarid_formatoFacturaPuntoVenta=true;
	public Boolean cargarid_formatoFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_factura_punto_ventaFacturaPuntoVenta=null;
	public Boolean mostrarid_tipo_factura_punto_ventaFacturaPuntoVenta=true;
	public Boolean activarid_tipo_factura_punto_ventaFacturaPuntoVenta=true;
	public Boolean cargarid_tipo_factura_punto_ventaFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_factura_punto_ventaFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_estado_factura_punto_ventaFacturaPuntoVenta=null;
	public Boolean mostrarid_estado_factura_punto_ventaFacturaPuntoVenta=true;
	public Boolean activarid_estado_factura_punto_ventaFacturaPuntoVenta=true;
	public Boolean cargarid_estado_factura_punto_ventaFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_factura_punto_ventaFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableFacturaPuntoVenta=null;
	public Boolean mostrarid_asiento_contableFacturaPuntoVenta=true;
	public Boolean activarid_asiento_contableFacturaPuntoVenta=false;
	public Boolean cargarid_asiento_contableFacturaPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialFacturaPuntoVenta=null;
	public Boolean mostrarnumero_secuencialFacturaPuntoVenta=true;
	public Boolean activarnumero_secuencialFacturaPuntoVenta=true;

	public Border resaltarcodigo_clienteFacturaPuntoVenta=null;
	public Boolean mostrarcodigo_clienteFacturaPuntoVenta=true;
	public Boolean activarcodigo_clienteFacturaPuntoVenta=true;

	public Border resaltarnombre_clienteFacturaPuntoVenta=null;
	public Boolean mostrarnombre_clienteFacturaPuntoVenta=true;
	public Boolean activarnombre_clienteFacturaPuntoVenta=true;

	public Border resaltartarjeta_clienteFacturaPuntoVenta=null;
	public Boolean mostrartarjeta_clienteFacturaPuntoVenta=true;
	public Boolean activartarjeta_clienteFacturaPuntoVenta=true;

	public Border resaltardireccion_clienteFacturaPuntoVenta=null;
	public Boolean mostrardireccion_clienteFacturaPuntoVenta=true;
	public Boolean activardireccion_clienteFacturaPuntoVenta=true;

	public Border resaltartelefono_clienteFacturaPuntoVenta=null;
	public Boolean mostrartelefono_clienteFacturaPuntoVenta=true;
	public Boolean activartelefono_clienteFacturaPuntoVenta=true;

	public Border resaltarfechaFacturaPuntoVenta=null;
	public Boolean mostrarfechaFacturaPuntoVenta=true;
	public Boolean activarfechaFacturaPuntoVenta=false;

	public Border resaltarhoraFacturaPuntoVenta=null;
	public Boolean mostrarhoraFacturaPuntoVenta=true;
	public Boolean activarhoraFacturaPuntoVenta=true;

	public Border resaltartotal_ivaFacturaPuntoVenta=null;
	public Boolean mostrartotal_ivaFacturaPuntoVenta=true;
	public Boolean activartotal_ivaFacturaPuntoVenta=true;

	public Border resaltartotal_sin_ivaFacturaPuntoVenta=null;
	public Boolean mostrartotal_sin_ivaFacturaPuntoVenta=true;
	public Boolean activartotal_sin_ivaFacturaPuntoVenta=true;

	public Border resaltarivaFacturaPuntoVenta=null;
	public Boolean mostrarivaFacturaPuntoVenta=true;
	public Boolean activarivaFacturaPuntoVenta=true;

	public Border resaltardescuentoFacturaPuntoVenta=null;
	public Boolean mostrardescuentoFacturaPuntoVenta=true;
	public Boolean activardescuentoFacturaPuntoVenta=true;

	public Border resaltarfinanciamientoFacturaPuntoVenta=null;
	public Boolean mostrarfinanciamientoFacturaPuntoVenta=true;
	public Boolean activarfinanciamientoFacturaPuntoVenta=true;

	public Border resaltarfleteFacturaPuntoVenta=null;
	public Boolean mostrarfleteFacturaPuntoVenta=true;
	public Boolean activarfleteFacturaPuntoVenta=true;

	public Border resaltariceFacturaPuntoVenta=null;
	public Boolean mostrariceFacturaPuntoVenta=true;
	public Boolean activariceFacturaPuntoVenta=true;

	public Border resaltarotrosFacturaPuntoVenta=null;
	public Boolean mostrarotrosFacturaPuntoVenta=true;
	public Boolean activarotrosFacturaPuntoVenta=true;

	public Border resaltarsub_totalFacturaPuntoVenta=null;
	public Boolean mostrarsub_totalFacturaPuntoVenta=true;
	public Boolean activarsub_totalFacturaPuntoVenta=true;

	public Border resaltartotalFacturaPuntoVenta=null;
	public Boolean mostrartotalFacturaPuntoVenta=true;
	public Boolean activartotalFacturaPuntoVenta=true;

	
	

	public Border setResaltaridFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaPuntoVenta() {
		return this.resaltaridFacturaPuntoVenta;
	}

	public void setResaltaridFacturaPuntoVenta(Border borderResaltar) {
		this.resaltaridFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridFacturaPuntoVenta() {
		return this.mostraridFacturaPuntoVenta;
	}

	public void setMostraridFacturaPuntoVenta(Boolean mostraridFacturaPuntoVenta) {
		this.mostraridFacturaPuntoVenta= mostraridFacturaPuntoVenta;
	}

	public Boolean getActivaridFacturaPuntoVenta() {
		return this.activaridFacturaPuntoVenta;
	}

	public void setActivaridFacturaPuntoVenta(Boolean activaridFacturaPuntoVenta) {
		this.activaridFacturaPuntoVenta= activaridFacturaPuntoVenta;
	}

	public Border setResaltarid_empresaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaPuntoVenta() {
		return this.resaltarid_empresaFacturaPuntoVenta;
	}

	public void setResaltarid_empresaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaPuntoVenta() {
		return this.mostrarid_empresaFacturaPuntoVenta;
	}

	public void setMostrarid_empresaFacturaPuntoVenta(Boolean mostrarid_empresaFacturaPuntoVenta) {
		this.mostrarid_empresaFacturaPuntoVenta= mostrarid_empresaFacturaPuntoVenta;
	}

	public Boolean getActivarid_empresaFacturaPuntoVenta() {
		return this.activarid_empresaFacturaPuntoVenta;
	}

	public void setActivarid_empresaFacturaPuntoVenta(Boolean activarid_empresaFacturaPuntoVenta) {
		this.activarid_empresaFacturaPuntoVenta= activarid_empresaFacturaPuntoVenta;
	}

	public Boolean getCargarid_empresaFacturaPuntoVenta() {
		return this.cargarid_empresaFacturaPuntoVenta;
	}

	public void setCargarid_empresaFacturaPuntoVenta(Boolean cargarid_empresaFacturaPuntoVenta) {
		this.cargarid_empresaFacturaPuntoVenta= cargarid_empresaFacturaPuntoVenta;
	}

	public Border setResaltarid_sucursalFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturaPuntoVenta() {
		return this.resaltarid_sucursalFacturaPuntoVenta;
	}

	public void setResaltarid_sucursalFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturaPuntoVenta() {
		return this.mostrarid_sucursalFacturaPuntoVenta;
	}

	public void setMostrarid_sucursalFacturaPuntoVenta(Boolean mostrarid_sucursalFacturaPuntoVenta) {
		this.mostrarid_sucursalFacturaPuntoVenta= mostrarid_sucursalFacturaPuntoVenta;
	}

	public Boolean getActivarid_sucursalFacturaPuntoVenta() {
		return this.activarid_sucursalFacturaPuntoVenta;
	}

	public void setActivarid_sucursalFacturaPuntoVenta(Boolean activarid_sucursalFacturaPuntoVenta) {
		this.activarid_sucursalFacturaPuntoVenta= activarid_sucursalFacturaPuntoVenta;
	}

	public Boolean getCargarid_sucursalFacturaPuntoVenta() {
		return this.cargarid_sucursalFacturaPuntoVenta;
	}

	public void setCargarid_sucursalFacturaPuntoVenta(Boolean cargarid_sucursalFacturaPuntoVenta) {
		this.cargarid_sucursalFacturaPuntoVenta= cargarid_sucursalFacturaPuntoVenta;
	}

	public Border setResaltarid_usuarioFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_usuarioFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioFacturaPuntoVenta() {
		return this.resaltarid_usuarioFacturaPuntoVenta;
	}

	public void setResaltarid_usuarioFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_usuarioFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_usuarioFacturaPuntoVenta() {
		return this.mostrarid_usuarioFacturaPuntoVenta;
	}

	public void setMostrarid_usuarioFacturaPuntoVenta(Boolean mostrarid_usuarioFacturaPuntoVenta) {
		this.mostrarid_usuarioFacturaPuntoVenta= mostrarid_usuarioFacturaPuntoVenta;
	}

	public Boolean getActivarid_usuarioFacturaPuntoVenta() {
		return this.activarid_usuarioFacturaPuntoVenta;
	}

	public void setActivarid_usuarioFacturaPuntoVenta(Boolean activarid_usuarioFacturaPuntoVenta) {
		this.activarid_usuarioFacturaPuntoVenta= activarid_usuarioFacturaPuntoVenta;
	}

	public Boolean getCargarid_usuarioFacturaPuntoVenta() {
		return this.cargarid_usuarioFacturaPuntoVenta;
	}

	public void setCargarid_usuarioFacturaPuntoVenta(Boolean cargarid_usuarioFacturaPuntoVenta) {
		this.cargarid_usuarioFacturaPuntoVenta= cargarid_usuarioFacturaPuntoVenta;
	}

	public Border setResaltarid_vendedorFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_vendedorFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorFacturaPuntoVenta() {
		return this.resaltarid_vendedorFacturaPuntoVenta;
	}

	public void setResaltarid_vendedorFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_vendedorFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_vendedorFacturaPuntoVenta() {
		return this.mostrarid_vendedorFacturaPuntoVenta;
	}

	public void setMostrarid_vendedorFacturaPuntoVenta(Boolean mostrarid_vendedorFacturaPuntoVenta) {
		this.mostrarid_vendedorFacturaPuntoVenta= mostrarid_vendedorFacturaPuntoVenta;
	}

	public Boolean getActivarid_vendedorFacturaPuntoVenta() {
		return this.activarid_vendedorFacturaPuntoVenta;
	}

	public void setActivarid_vendedorFacturaPuntoVenta(Boolean activarid_vendedorFacturaPuntoVenta) {
		this.activarid_vendedorFacturaPuntoVenta= activarid_vendedorFacturaPuntoVenta;
	}

	public Boolean getCargarid_vendedorFacturaPuntoVenta() {
		return this.cargarid_vendedorFacturaPuntoVenta;
	}

	public void setCargarid_vendedorFacturaPuntoVenta(Boolean cargarid_vendedorFacturaPuntoVenta) {
		this.cargarid_vendedorFacturaPuntoVenta= cargarid_vendedorFacturaPuntoVenta;
	}

	public Border setResaltarid_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturaPuntoVenta() {
		return this.resaltarid_clienteFacturaPuntoVenta;
	}

	public void setResaltarid_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturaPuntoVenta() {
		return this.mostrarid_clienteFacturaPuntoVenta;
	}

	public void setMostrarid_clienteFacturaPuntoVenta(Boolean mostrarid_clienteFacturaPuntoVenta) {
		this.mostrarid_clienteFacturaPuntoVenta= mostrarid_clienteFacturaPuntoVenta;
	}

	public Boolean getActivarid_clienteFacturaPuntoVenta() {
		return this.activarid_clienteFacturaPuntoVenta;
	}

	public void setActivarid_clienteFacturaPuntoVenta(Boolean activarid_clienteFacturaPuntoVenta) {
		this.activarid_clienteFacturaPuntoVenta= activarid_clienteFacturaPuntoVenta;
	}

	public Boolean getCargarid_clienteFacturaPuntoVenta() {
		return this.cargarid_clienteFacturaPuntoVenta;
	}

	public void setCargarid_clienteFacturaPuntoVenta(Boolean cargarid_clienteFacturaPuntoVenta) {
		this.cargarid_clienteFacturaPuntoVenta= cargarid_clienteFacturaPuntoVenta;
	}

	public Border setResaltarid_cajaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_cajaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaFacturaPuntoVenta() {
		return this.resaltarid_cajaFacturaPuntoVenta;
	}

	public void setResaltarid_cajaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_cajaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_cajaFacturaPuntoVenta() {
		return this.mostrarid_cajaFacturaPuntoVenta;
	}

	public void setMostrarid_cajaFacturaPuntoVenta(Boolean mostrarid_cajaFacturaPuntoVenta) {
		this.mostrarid_cajaFacturaPuntoVenta= mostrarid_cajaFacturaPuntoVenta;
	}

	public Boolean getActivarid_cajaFacturaPuntoVenta() {
		return this.activarid_cajaFacturaPuntoVenta;
	}

	public void setActivarid_cajaFacturaPuntoVenta(Boolean activarid_cajaFacturaPuntoVenta) {
		this.activarid_cajaFacturaPuntoVenta= activarid_cajaFacturaPuntoVenta;
	}

	public Boolean getCargarid_cajaFacturaPuntoVenta() {
		return this.cargarid_cajaFacturaPuntoVenta;
	}

	public void setCargarid_cajaFacturaPuntoVenta(Boolean cargarid_cajaFacturaPuntoVenta) {
		this.cargarid_cajaFacturaPuntoVenta= cargarid_cajaFacturaPuntoVenta;
	}

	public Border setResaltarid_tipo_precioFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioFacturaPuntoVenta() {
		return this.resaltarid_tipo_precioFacturaPuntoVenta;
	}

	public void setResaltarid_tipo_precioFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_precioFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioFacturaPuntoVenta() {
		return this.mostrarid_tipo_precioFacturaPuntoVenta;
	}

	public void setMostrarid_tipo_precioFacturaPuntoVenta(Boolean mostrarid_tipo_precioFacturaPuntoVenta) {
		this.mostrarid_tipo_precioFacturaPuntoVenta= mostrarid_tipo_precioFacturaPuntoVenta;
	}

	public Boolean getActivarid_tipo_precioFacturaPuntoVenta() {
		return this.activarid_tipo_precioFacturaPuntoVenta;
	}

	public void setActivarid_tipo_precioFacturaPuntoVenta(Boolean activarid_tipo_precioFacturaPuntoVenta) {
		this.activarid_tipo_precioFacturaPuntoVenta= activarid_tipo_precioFacturaPuntoVenta;
	}

	public Boolean getCargarid_tipo_precioFacturaPuntoVenta() {
		return this.cargarid_tipo_precioFacturaPuntoVenta;
	}

	public void setCargarid_tipo_precioFacturaPuntoVenta(Boolean cargarid_tipo_precioFacturaPuntoVenta) {
		this.cargarid_tipo_precioFacturaPuntoVenta= cargarid_tipo_precioFacturaPuntoVenta;
	}

	public Border setResaltarid_mesaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_mesaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesaFacturaPuntoVenta() {
		return this.resaltarid_mesaFacturaPuntoVenta;
	}

	public void setResaltarid_mesaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_mesaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_mesaFacturaPuntoVenta() {
		return this.mostrarid_mesaFacturaPuntoVenta;
	}

	public void setMostrarid_mesaFacturaPuntoVenta(Boolean mostrarid_mesaFacturaPuntoVenta) {
		this.mostrarid_mesaFacturaPuntoVenta= mostrarid_mesaFacturaPuntoVenta;
	}

	public Boolean getActivarid_mesaFacturaPuntoVenta() {
		return this.activarid_mesaFacturaPuntoVenta;
	}

	public void setActivarid_mesaFacturaPuntoVenta(Boolean activarid_mesaFacturaPuntoVenta) {
		this.activarid_mesaFacturaPuntoVenta= activarid_mesaFacturaPuntoVenta;
	}

	public Boolean getCargarid_mesaFacturaPuntoVenta() {
		return this.cargarid_mesaFacturaPuntoVenta;
	}

	public void setCargarid_mesaFacturaPuntoVenta(Boolean cargarid_mesaFacturaPuntoVenta) {
		this.cargarid_mesaFacturaPuntoVenta= cargarid_mesaFacturaPuntoVenta;
	}

	public Border setResaltarid_formatoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_formatoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoFacturaPuntoVenta() {
		return this.resaltarid_formatoFacturaPuntoVenta;
	}

	public void setResaltarid_formatoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_formatoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_formatoFacturaPuntoVenta() {
		return this.mostrarid_formatoFacturaPuntoVenta;
	}

	public void setMostrarid_formatoFacturaPuntoVenta(Boolean mostrarid_formatoFacturaPuntoVenta) {
		this.mostrarid_formatoFacturaPuntoVenta= mostrarid_formatoFacturaPuntoVenta;
	}

	public Boolean getActivarid_formatoFacturaPuntoVenta() {
		return this.activarid_formatoFacturaPuntoVenta;
	}

	public void setActivarid_formatoFacturaPuntoVenta(Boolean activarid_formatoFacturaPuntoVenta) {
		this.activarid_formatoFacturaPuntoVenta= activarid_formatoFacturaPuntoVenta;
	}

	public Boolean getCargarid_formatoFacturaPuntoVenta() {
		return this.cargarid_formatoFacturaPuntoVenta;
	}

	public void setCargarid_formatoFacturaPuntoVenta(Boolean cargarid_formatoFacturaPuntoVenta) {
		this.cargarid_formatoFacturaPuntoVenta= cargarid_formatoFacturaPuntoVenta;
	}

	public Border setResaltarid_tipo_factura_punto_ventaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_factura_punto_ventaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_factura_punto_ventaFacturaPuntoVenta() {
		return this.resaltarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setResaltarid_tipo_factura_punto_ventaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_factura_punto_ventaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_factura_punto_ventaFacturaPuntoVenta() {
		return this.mostrarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setMostrarid_tipo_factura_punto_ventaFacturaPuntoVenta(Boolean mostrarid_tipo_factura_punto_ventaFacturaPuntoVenta) {
		this.mostrarid_tipo_factura_punto_ventaFacturaPuntoVenta= mostrarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public Boolean getActivarid_tipo_factura_punto_ventaFacturaPuntoVenta() {
		return this.activarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setActivarid_tipo_factura_punto_ventaFacturaPuntoVenta(Boolean activarid_tipo_factura_punto_ventaFacturaPuntoVenta) {
		this.activarid_tipo_factura_punto_ventaFacturaPuntoVenta= activarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public Boolean getCargarid_tipo_factura_punto_ventaFacturaPuntoVenta() {
		return this.cargarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setCargarid_tipo_factura_punto_ventaFacturaPuntoVenta(Boolean cargarid_tipo_factura_punto_ventaFacturaPuntoVenta) {
		this.cargarid_tipo_factura_punto_ventaFacturaPuntoVenta= cargarid_tipo_factura_punto_ventaFacturaPuntoVenta;
	}

	public Border setResaltarid_estado_factura_punto_ventaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_estado_factura_punto_ventaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_factura_punto_ventaFacturaPuntoVenta() {
		return this.resaltarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setResaltarid_estado_factura_punto_ventaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_estado_factura_punto_ventaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_estado_factura_punto_ventaFacturaPuntoVenta() {
		return this.mostrarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setMostrarid_estado_factura_punto_ventaFacturaPuntoVenta(Boolean mostrarid_estado_factura_punto_ventaFacturaPuntoVenta) {
		this.mostrarid_estado_factura_punto_ventaFacturaPuntoVenta= mostrarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public Boolean getActivarid_estado_factura_punto_ventaFacturaPuntoVenta() {
		return this.activarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setActivarid_estado_factura_punto_ventaFacturaPuntoVenta(Boolean activarid_estado_factura_punto_ventaFacturaPuntoVenta) {
		this.activarid_estado_factura_punto_ventaFacturaPuntoVenta= activarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public Boolean getCargarid_estado_factura_punto_ventaFacturaPuntoVenta() {
		return this.cargarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public void setCargarid_estado_factura_punto_ventaFacturaPuntoVenta(Boolean cargarid_estado_factura_punto_ventaFacturaPuntoVenta) {
		this.cargarid_estado_factura_punto_ventaFacturaPuntoVenta= cargarid_estado_factura_punto_ventaFacturaPuntoVenta;
	}

	public Border setResaltarid_asiento_contableFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableFacturaPuntoVenta() {
		return this.resaltarid_asiento_contableFacturaPuntoVenta;
	}

	public void setResaltarid_asiento_contableFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_asiento_contableFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableFacturaPuntoVenta() {
		return this.mostrarid_asiento_contableFacturaPuntoVenta;
	}

	public void setMostrarid_asiento_contableFacturaPuntoVenta(Boolean mostrarid_asiento_contableFacturaPuntoVenta) {
		this.mostrarid_asiento_contableFacturaPuntoVenta= mostrarid_asiento_contableFacturaPuntoVenta;
	}

	public Boolean getActivarid_asiento_contableFacturaPuntoVenta() {
		return this.activarid_asiento_contableFacturaPuntoVenta;
	}

	public void setActivarid_asiento_contableFacturaPuntoVenta(Boolean activarid_asiento_contableFacturaPuntoVenta) {
		this.activarid_asiento_contableFacturaPuntoVenta= activarid_asiento_contableFacturaPuntoVenta;
	}

	public Boolean getCargarid_asiento_contableFacturaPuntoVenta() {
		return this.cargarid_asiento_contableFacturaPuntoVenta;
	}

	public void setCargarid_asiento_contableFacturaPuntoVenta(Boolean cargarid_asiento_contableFacturaPuntoVenta) {
		this.cargarid_asiento_contableFacturaPuntoVenta= cargarid_asiento_contableFacturaPuntoVenta;
	}

	public Border setResaltarnumero_secuencialFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialFacturaPuntoVenta() {
		return this.resaltarnumero_secuencialFacturaPuntoVenta;
	}

	public void setResaltarnumero_secuencialFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_secuencialFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialFacturaPuntoVenta() {
		return this.mostrarnumero_secuencialFacturaPuntoVenta;
	}

	public void setMostrarnumero_secuencialFacturaPuntoVenta(Boolean mostrarnumero_secuencialFacturaPuntoVenta) {
		this.mostrarnumero_secuencialFacturaPuntoVenta= mostrarnumero_secuencialFacturaPuntoVenta;
	}

	public Boolean getActivarnumero_secuencialFacturaPuntoVenta() {
		return this.activarnumero_secuencialFacturaPuntoVenta;
	}

	public void setActivarnumero_secuencialFacturaPuntoVenta(Boolean activarnumero_secuencialFacturaPuntoVenta) {
		this.activarnumero_secuencialFacturaPuntoVenta= activarnumero_secuencialFacturaPuntoVenta;
	}

	public Border setResaltarcodigo_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteFacturaPuntoVenta() {
		return this.resaltarcodigo_clienteFacturaPuntoVenta;
	}

	public void setResaltarcodigo_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarcodigo_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteFacturaPuntoVenta() {
		return this.mostrarcodigo_clienteFacturaPuntoVenta;
	}

	public void setMostrarcodigo_clienteFacturaPuntoVenta(Boolean mostrarcodigo_clienteFacturaPuntoVenta) {
		this.mostrarcodigo_clienteFacturaPuntoVenta= mostrarcodigo_clienteFacturaPuntoVenta;
	}

	public Boolean getActivarcodigo_clienteFacturaPuntoVenta() {
		return this.activarcodigo_clienteFacturaPuntoVenta;
	}

	public void setActivarcodigo_clienteFacturaPuntoVenta(Boolean activarcodigo_clienteFacturaPuntoVenta) {
		this.activarcodigo_clienteFacturaPuntoVenta= activarcodigo_clienteFacturaPuntoVenta;
	}

	public Border setResaltarnombre_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteFacturaPuntoVenta() {
		return this.resaltarnombre_clienteFacturaPuntoVenta;
	}

	public void setResaltarnombre_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarnombre_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteFacturaPuntoVenta() {
		return this.mostrarnombre_clienteFacturaPuntoVenta;
	}

	public void setMostrarnombre_clienteFacturaPuntoVenta(Boolean mostrarnombre_clienteFacturaPuntoVenta) {
		this.mostrarnombre_clienteFacturaPuntoVenta= mostrarnombre_clienteFacturaPuntoVenta;
	}

	public Boolean getActivarnombre_clienteFacturaPuntoVenta() {
		return this.activarnombre_clienteFacturaPuntoVenta;
	}

	public void setActivarnombre_clienteFacturaPuntoVenta(Boolean activarnombre_clienteFacturaPuntoVenta) {
		this.activarnombre_clienteFacturaPuntoVenta= activarnombre_clienteFacturaPuntoVenta;
	}

	public Border setResaltartarjeta_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartarjeta_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjeta_clienteFacturaPuntoVenta() {
		return this.resaltartarjeta_clienteFacturaPuntoVenta;
	}

	public void setResaltartarjeta_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartarjeta_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartarjeta_clienteFacturaPuntoVenta() {
		return this.mostrartarjeta_clienteFacturaPuntoVenta;
	}

	public void setMostrartarjeta_clienteFacturaPuntoVenta(Boolean mostrartarjeta_clienteFacturaPuntoVenta) {
		this.mostrartarjeta_clienteFacturaPuntoVenta= mostrartarjeta_clienteFacturaPuntoVenta;
	}

	public Boolean getActivartarjeta_clienteFacturaPuntoVenta() {
		return this.activartarjeta_clienteFacturaPuntoVenta;
	}

	public void setActivartarjeta_clienteFacturaPuntoVenta(Boolean activartarjeta_clienteFacturaPuntoVenta) {
		this.activartarjeta_clienteFacturaPuntoVenta= activartarjeta_clienteFacturaPuntoVenta;
	}

	public Border setResaltardireccion_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardireccion_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clienteFacturaPuntoVenta() {
		return this.resaltardireccion_clienteFacturaPuntoVenta;
	}

	public void setResaltardireccion_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardireccion_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardireccion_clienteFacturaPuntoVenta() {
		return this.mostrardireccion_clienteFacturaPuntoVenta;
	}

	public void setMostrardireccion_clienteFacturaPuntoVenta(Boolean mostrardireccion_clienteFacturaPuntoVenta) {
		this.mostrardireccion_clienteFacturaPuntoVenta= mostrardireccion_clienteFacturaPuntoVenta;
	}

	public Boolean getActivardireccion_clienteFacturaPuntoVenta() {
		return this.activardireccion_clienteFacturaPuntoVenta;
	}

	public void setActivardireccion_clienteFacturaPuntoVenta(Boolean activardireccion_clienteFacturaPuntoVenta) {
		this.activardireccion_clienteFacturaPuntoVenta= activardireccion_clienteFacturaPuntoVenta;
	}

	public Border setResaltartelefono_clienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartelefono_clienteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clienteFacturaPuntoVenta() {
		return this.resaltartelefono_clienteFacturaPuntoVenta;
	}

	public void setResaltartelefono_clienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartelefono_clienteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartelefono_clienteFacturaPuntoVenta() {
		return this.mostrartelefono_clienteFacturaPuntoVenta;
	}

	public void setMostrartelefono_clienteFacturaPuntoVenta(Boolean mostrartelefono_clienteFacturaPuntoVenta) {
		this.mostrartelefono_clienteFacturaPuntoVenta= mostrartelefono_clienteFacturaPuntoVenta;
	}

	public Boolean getActivartelefono_clienteFacturaPuntoVenta() {
		return this.activartelefono_clienteFacturaPuntoVenta;
	}

	public void setActivartelefono_clienteFacturaPuntoVenta(Boolean activartelefono_clienteFacturaPuntoVenta) {
		this.activartelefono_clienteFacturaPuntoVenta= activartelefono_clienteFacturaPuntoVenta;
	}

	public Border setResaltarfechaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfechaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFacturaPuntoVenta() {
		return this.resaltarfechaFacturaPuntoVenta;
	}

	public void setResaltarfechaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarfechaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfechaFacturaPuntoVenta() {
		return this.mostrarfechaFacturaPuntoVenta;
	}

	public void setMostrarfechaFacturaPuntoVenta(Boolean mostrarfechaFacturaPuntoVenta) {
		this.mostrarfechaFacturaPuntoVenta= mostrarfechaFacturaPuntoVenta;
	}

	public Boolean getActivarfechaFacturaPuntoVenta() {
		return this.activarfechaFacturaPuntoVenta;
	}

	public void setActivarfechaFacturaPuntoVenta(Boolean activarfechaFacturaPuntoVenta) {
		this.activarfechaFacturaPuntoVenta= activarfechaFacturaPuntoVenta;
	}

	public Border setResaltarhoraFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarhoraFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraFacturaPuntoVenta() {
		return this.resaltarhoraFacturaPuntoVenta;
	}

	public void setResaltarhoraFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarhoraFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarhoraFacturaPuntoVenta() {
		return this.mostrarhoraFacturaPuntoVenta;
	}

	public void setMostrarhoraFacturaPuntoVenta(Boolean mostrarhoraFacturaPuntoVenta) {
		this.mostrarhoraFacturaPuntoVenta= mostrarhoraFacturaPuntoVenta;
	}

	public Boolean getActivarhoraFacturaPuntoVenta() {
		return this.activarhoraFacturaPuntoVenta;
	}

	public void setActivarhoraFacturaPuntoVenta(Boolean activarhoraFacturaPuntoVenta) {
		this.activarhoraFacturaPuntoVenta= activarhoraFacturaPuntoVenta;
	}

	public Border setResaltartotal_ivaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_ivaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaFacturaPuntoVenta() {
		return this.resaltartotal_ivaFacturaPuntoVenta;
	}

	public void setResaltartotal_ivaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartotal_ivaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_ivaFacturaPuntoVenta() {
		return this.mostrartotal_ivaFacturaPuntoVenta;
	}

	public void setMostrartotal_ivaFacturaPuntoVenta(Boolean mostrartotal_ivaFacturaPuntoVenta) {
		this.mostrartotal_ivaFacturaPuntoVenta= mostrartotal_ivaFacturaPuntoVenta;
	}

	public Boolean getActivartotal_ivaFacturaPuntoVenta() {
		return this.activartotal_ivaFacturaPuntoVenta;
	}

	public void setActivartotal_ivaFacturaPuntoVenta(Boolean activartotal_ivaFacturaPuntoVenta) {
		this.activartotal_ivaFacturaPuntoVenta= activartotal_ivaFacturaPuntoVenta;
	}

	public Border setResaltartotal_sin_ivaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaFacturaPuntoVenta() {
		return this.resaltartotal_sin_ivaFacturaPuntoVenta;
	}

	public void setResaltartotal_sin_ivaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartotal_sin_ivaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaFacturaPuntoVenta() {
		return this.mostrartotal_sin_ivaFacturaPuntoVenta;
	}

	public void setMostrartotal_sin_ivaFacturaPuntoVenta(Boolean mostrartotal_sin_ivaFacturaPuntoVenta) {
		this.mostrartotal_sin_ivaFacturaPuntoVenta= mostrartotal_sin_ivaFacturaPuntoVenta;
	}

	public Boolean getActivartotal_sin_ivaFacturaPuntoVenta() {
		return this.activartotal_sin_ivaFacturaPuntoVenta;
	}

	public void setActivartotal_sin_ivaFacturaPuntoVenta(Boolean activartotal_sin_ivaFacturaPuntoVenta) {
		this.activartotal_sin_ivaFacturaPuntoVenta= activartotal_sin_ivaFacturaPuntoVenta;
	}

	public Border setResaltarivaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFacturaPuntoVenta() {
		return this.resaltarivaFacturaPuntoVenta;
	}

	public void setResaltarivaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarivaFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaFacturaPuntoVenta() {
		return this.mostrarivaFacturaPuntoVenta;
	}

	public void setMostrarivaFacturaPuntoVenta(Boolean mostrarivaFacturaPuntoVenta) {
		this.mostrarivaFacturaPuntoVenta= mostrarivaFacturaPuntoVenta;
	}

	public Boolean getActivarivaFacturaPuntoVenta() {
		return this.activarivaFacturaPuntoVenta;
	}

	public void setActivarivaFacturaPuntoVenta(Boolean activarivaFacturaPuntoVenta) {
		this.activarivaFacturaPuntoVenta= activarivaFacturaPuntoVenta;
	}

	public Border setResaltardescuentoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoFacturaPuntoVenta() {
		return this.resaltardescuentoFacturaPuntoVenta;
	}

	public void setResaltardescuentoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoFacturaPuntoVenta() {
		return this.mostrardescuentoFacturaPuntoVenta;
	}

	public void setMostrardescuentoFacturaPuntoVenta(Boolean mostrardescuentoFacturaPuntoVenta) {
		this.mostrardescuentoFacturaPuntoVenta= mostrardescuentoFacturaPuntoVenta;
	}

	public Boolean getActivardescuentoFacturaPuntoVenta() {
		return this.activardescuentoFacturaPuntoVenta;
	}

	public void setActivardescuentoFacturaPuntoVenta(Boolean activardescuentoFacturaPuntoVenta) {
		this.activardescuentoFacturaPuntoVenta= activardescuentoFacturaPuntoVenta;
	}

	public Border setResaltarfinanciamientoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoFacturaPuntoVenta() {
		return this.resaltarfinanciamientoFacturaPuntoVenta;
	}

	public void setResaltarfinanciamientoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarfinanciamientoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoFacturaPuntoVenta() {
		return this.mostrarfinanciamientoFacturaPuntoVenta;
	}

	public void setMostrarfinanciamientoFacturaPuntoVenta(Boolean mostrarfinanciamientoFacturaPuntoVenta) {
		this.mostrarfinanciamientoFacturaPuntoVenta= mostrarfinanciamientoFacturaPuntoVenta;
	}

	public Boolean getActivarfinanciamientoFacturaPuntoVenta() {
		return this.activarfinanciamientoFacturaPuntoVenta;
	}

	public void setActivarfinanciamientoFacturaPuntoVenta(Boolean activarfinanciamientoFacturaPuntoVenta) {
		this.activarfinanciamientoFacturaPuntoVenta= activarfinanciamientoFacturaPuntoVenta;
	}

	public Border setResaltarfleteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfleteFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteFacturaPuntoVenta() {
		return this.resaltarfleteFacturaPuntoVenta;
	}

	public void setResaltarfleteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarfleteFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfleteFacturaPuntoVenta() {
		return this.mostrarfleteFacturaPuntoVenta;
	}

	public void setMostrarfleteFacturaPuntoVenta(Boolean mostrarfleteFacturaPuntoVenta) {
		this.mostrarfleteFacturaPuntoVenta= mostrarfleteFacturaPuntoVenta;
	}

	public Boolean getActivarfleteFacturaPuntoVenta() {
		return this.activarfleteFacturaPuntoVenta;
	}

	public void setActivarfleteFacturaPuntoVenta(Boolean activarfleteFacturaPuntoVenta) {
		this.activarfleteFacturaPuntoVenta= activarfleteFacturaPuntoVenta;
	}

	public Border setResaltariceFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariceFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceFacturaPuntoVenta() {
		return this.resaltariceFacturaPuntoVenta;
	}

	public void setResaltariceFacturaPuntoVenta(Border borderResaltar) {
		this.resaltariceFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariceFacturaPuntoVenta() {
		return this.mostrariceFacturaPuntoVenta;
	}

	public void setMostrariceFacturaPuntoVenta(Boolean mostrariceFacturaPuntoVenta) {
		this.mostrariceFacturaPuntoVenta= mostrariceFacturaPuntoVenta;
	}

	public Boolean getActivariceFacturaPuntoVenta() {
		return this.activariceFacturaPuntoVenta;
	}

	public void setActivariceFacturaPuntoVenta(Boolean activariceFacturaPuntoVenta) {
		this.activariceFacturaPuntoVenta= activariceFacturaPuntoVenta;
	}

	public Border setResaltarotrosFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarotrosFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotrosFacturaPuntoVenta() {
		return this.resaltarotrosFacturaPuntoVenta;
	}

	public void setResaltarotrosFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarotrosFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarotrosFacturaPuntoVenta() {
		return this.mostrarotrosFacturaPuntoVenta;
	}

	public void setMostrarotrosFacturaPuntoVenta(Boolean mostrarotrosFacturaPuntoVenta) {
		this.mostrarotrosFacturaPuntoVenta= mostrarotrosFacturaPuntoVenta;
	}

	public Boolean getActivarotrosFacturaPuntoVenta() {
		return this.activarotrosFacturaPuntoVenta;
	}

	public void setActivarotrosFacturaPuntoVenta(Boolean activarotrosFacturaPuntoVenta) {
		this.activarotrosFacturaPuntoVenta= activarotrosFacturaPuntoVenta;
	}

	public Border setResaltarsub_totalFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalFacturaPuntoVenta() {
		return this.resaltarsub_totalFacturaPuntoVenta;
	}

	public void setResaltarsub_totalFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalFacturaPuntoVenta() {
		return this.mostrarsub_totalFacturaPuntoVenta;
	}

	public void setMostrarsub_totalFacturaPuntoVenta(Boolean mostrarsub_totalFacturaPuntoVenta) {
		this.mostrarsub_totalFacturaPuntoVenta= mostrarsub_totalFacturaPuntoVenta;
	}

	public Boolean getActivarsub_totalFacturaPuntoVenta() {
		return this.activarsub_totalFacturaPuntoVenta;
	}

	public void setActivarsub_totalFacturaPuntoVenta(Boolean activarsub_totalFacturaPuntoVenta) {
		this.activarsub_totalFacturaPuntoVenta= activarsub_totalFacturaPuntoVenta;
	}

	public Border setResaltartotalFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturaPuntoVenta() {
		return this.resaltartotalFacturaPuntoVenta;
	}

	public void setResaltartotalFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartotalFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalFacturaPuntoVenta() {
		return this.mostrartotalFacturaPuntoVenta;
	}

	public void setMostrartotalFacturaPuntoVenta(Boolean mostrartotalFacturaPuntoVenta) {
		this.mostrartotalFacturaPuntoVenta= mostrartotalFacturaPuntoVenta;
	}

	public Boolean getActivartotalFacturaPuntoVenta() {
		return this.activartotalFacturaPuntoVenta;
	}

	public void setActivartotalFacturaPuntoVenta(Boolean activartotalFacturaPuntoVenta) {
		this.activartotalFacturaPuntoVenta= activartotalFacturaPuntoVenta;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridFacturaPuntoVenta(esInicial);
		this.setMostrarid_empresaFacturaPuntoVenta(esInicial);
		this.setMostrarid_sucursalFacturaPuntoVenta(esInicial);
		this.setMostrarid_usuarioFacturaPuntoVenta(esInicial);
		this.setMostrarid_vendedorFacturaPuntoVenta(esInicial);
		this.setMostrarid_clienteFacturaPuntoVenta(esInicial);
		this.setMostrarid_cajaFacturaPuntoVenta(esInicial);
		this.setMostrarid_tipo_precioFacturaPuntoVenta(esInicial);
		this.setMostrarid_mesaFacturaPuntoVenta(esInicial);
		this.setMostrarid_formatoFacturaPuntoVenta(esInicial);
		this.setMostrarid_tipo_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setMostrarid_estado_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setMostrarid_asiento_contableFacturaPuntoVenta(esInicial);
		this.setMostrarnumero_secuencialFacturaPuntoVenta(esInicial);
		this.setMostrarcodigo_clienteFacturaPuntoVenta(esInicial);
		this.setMostrarnombre_clienteFacturaPuntoVenta(esInicial);
		this.setMostrartarjeta_clienteFacturaPuntoVenta(esInicial);
		this.setMostrardireccion_clienteFacturaPuntoVenta(esInicial);
		this.setMostrartelefono_clienteFacturaPuntoVenta(esInicial);
		this.setMostrarfechaFacturaPuntoVenta(esInicial);
		this.setMostrarhoraFacturaPuntoVenta(esInicial);
		this.setMostrartotal_ivaFacturaPuntoVenta(esInicial);
		this.setMostrartotal_sin_ivaFacturaPuntoVenta(esInicial);
		this.setMostrarivaFacturaPuntoVenta(esInicial);
		this.setMostrardescuentoFacturaPuntoVenta(esInicial);
		this.setMostrarfinanciamientoFacturaPuntoVenta(esInicial);
		this.setMostrarfleteFacturaPuntoVenta(esInicial);
		this.setMostrariceFacturaPuntoVenta(esInicial);
		this.setMostrarotrosFacturaPuntoVenta(esInicial);
		this.setMostrarsub_totalFacturaPuntoVenta(esInicial);
		this.setMostrartotalFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDMESA)) {
				this.setMostrarid_mesaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setMostrarid_tipo_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA)) {
				this.setMostrarid_estado_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setMostrartarjeta_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.HORA)) {
				this.setMostrarhoraFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FLETE)) {
				this.setMostrarfleteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setMostrariceFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.OTROS)) {
				this.setMostrarotrosFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridFacturaPuntoVenta(esInicial);
		this.setActivarid_empresaFacturaPuntoVenta(esInicial);
		this.setActivarid_sucursalFacturaPuntoVenta(esInicial);
		this.setActivarid_usuarioFacturaPuntoVenta(esInicial);
		this.setActivarid_vendedorFacturaPuntoVenta(esInicial);
		this.setActivarid_clienteFacturaPuntoVenta(esInicial);
		this.setActivarid_cajaFacturaPuntoVenta(esInicial);
		this.setActivarid_tipo_precioFacturaPuntoVenta(esInicial);
		this.setActivarid_mesaFacturaPuntoVenta(esInicial);
		this.setActivarid_formatoFacturaPuntoVenta(esInicial);
		this.setActivarid_tipo_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setActivarid_estado_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setActivarid_asiento_contableFacturaPuntoVenta(esInicial);
		this.setActivarnumero_secuencialFacturaPuntoVenta(esInicial);
		this.setActivarcodigo_clienteFacturaPuntoVenta(esInicial);
		this.setActivarnombre_clienteFacturaPuntoVenta(esInicial);
		this.setActivartarjeta_clienteFacturaPuntoVenta(esInicial);
		this.setActivardireccion_clienteFacturaPuntoVenta(esInicial);
		this.setActivartelefono_clienteFacturaPuntoVenta(esInicial);
		this.setActivarfechaFacturaPuntoVenta(esInicial);
		this.setActivarhoraFacturaPuntoVenta(esInicial);
		this.setActivartotal_ivaFacturaPuntoVenta(esInicial);
		this.setActivartotal_sin_ivaFacturaPuntoVenta(esInicial);
		this.setActivarivaFacturaPuntoVenta(esInicial);
		this.setActivardescuentoFacturaPuntoVenta(esInicial);
		this.setActivarfinanciamientoFacturaPuntoVenta(esInicial);
		this.setActivarfleteFacturaPuntoVenta(esInicial);
		this.setActivariceFacturaPuntoVenta(esInicial);
		this.setActivarotrosFacturaPuntoVenta(esInicial);
		this.setActivarsub_totalFacturaPuntoVenta(esInicial);
		this.setActivartotalFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDMESA)) {
				this.setActivarid_mesaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setActivarid_tipo_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA)) {
				this.setActivarid_estado_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setActivartarjeta_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FECHA)) {
				this.setActivarfechaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.HORA)) {
				this.setActivarhoraFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FLETE)) {
				this.setActivarfleteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setActivariceFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.OTROS)) {
				this.setActivarotrosFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaPuntoVenta(esInicial);
		this.setResaltarid_empresaFacturaPuntoVenta(esInicial);
		this.setResaltarid_sucursalFacturaPuntoVenta(esInicial);
		this.setResaltarid_usuarioFacturaPuntoVenta(esInicial);
		this.setResaltarid_vendedorFacturaPuntoVenta(esInicial);
		this.setResaltarid_clienteFacturaPuntoVenta(esInicial);
		this.setResaltarid_cajaFacturaPuntoVenta(esInicial);
		this.setResaltarid_tipo_precioFacturaPuntoVenta(esInicial);
		this.setResaltarid_mesaFacturaPuntoVenta(esInicial);
		this.setResaltarid_formatoFacturaPuntoVenta(esInicial);
		this.setResaltarid_tipo_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setResaltarid_estado_factura_punto_ventaFacturaPuntoVenta(esInicial);
		this.setResaltarid_asiento_contableFacturaPuntoVenta(esInicial);
		this.setResaltarnumero_secuencialFacturaPuntoVenta(esInicial);
		this.setResaltarcodigo_clienteFacturaPuntoVenta(esInicial);
		this.setResaltarnombre_clienteFacturaPuntoVenta(esInicial);
		this.setResaltartarjeta_clienteFacturaPuntoVenta(esInicial);
		this.setResaltardireccion_clienteFacturaPuntoVenta(esInicial);
		this.setResaltartelefono_clienteFacturaPuntoVenta(esInicial);
		this.setResaltarfechaFacturaPuntoVenta(esInicial);
		this.setResaltarhoraFacturaPuntoVenta(esInicial);
		this.setResaltartotal_ivaFacturaPuntoVenta(esInicial);
		this.setResaltartotal_sin_ivaFacturaPuntoVenta(esInicial);
		this.setResaltarivaFacturaPuntoVenta(esInicial);
		this.setResaltardescuentoFacturaPuntoVenta(esInicial);
		this.setResaltarfinanciamientoFacturaPuntoVenta(esInicial);
		this.setResaltarfleteFacturaPuntoVenta(esInicial);
		this.setResaltariceFacturaPuntoVenta(esInicial);
		this.setResaltarotrosFacturaPuntoVenta(esInicial);
		this.setResaltarsub_totalFacturaPuntoVenta(esInicial);
		this.setResaltartotalFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDMESA)) {
				this.setResaltarid_mesaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setResaltarid_tipo_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA)) {
				this.setResaltarid_estado_factura_punto_ventaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setResaltartarjeta_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clienteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.HORA)) {
				this.setResaltarhoraFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.FLETE)) {
				this.setResaltarfleteFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltariceFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.OTROS)) {
				this.setResaltarotrosFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormaPagoPuntoVentaFacturaPuntoVenta=null;

	public Border getResaltarFormaPagoPuntoVentaFacturaPuntoVenta() {
		return this.resaltarFormaPagoPuntoVentaFacturaPuntoVenta;
	}

	public void setResaltarFormaPagoPuntoVentaFacturaPuntoVenta(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaFacturaPuntoVenta= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaFacturaPuntoVenta= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaFacturaPuntoVenta=true;

	public Boolean getMostrarFormaPagoPuntoVentaFacturaPuntoVenta() {
		return this.mostrarFormaPagoPuntoVentaFacturaPuntoVenta;
	}

	public void setMostrarFormaPagoPuntoVentaFacturaPuntoVenta(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaFacturaPuntoVenta= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaFacturaPuntoVenta=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaFacturaPuntoVenta() {
		return this.activarFormaPagoPuntoVentaFacturaPuntoVenta;
	}

	public void setActivarFormaPagoPuntoVentaFacturaPuntoVenta(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaFacturaPuntoVenta= habilitarResaltarFormaPagoPuntoVenta;
	}


	public Border resaltarDetalleFacturaPuntoVentaFacturaPuntoVenta=null;

	public Border getResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta() {
		return this.resaltarDetalleFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta(Border borderResaltarDetalleFacturaPuntoVenta) {
		if(borderResaltarDetalleFacturaPuntoVenta!=null) {
			this.resaltarDetalleFacturaPuntoVentaFacturaPuntoVenta= borderResaltarDetalleFacturaPuntoVenta;
		}
	}

	public Border setResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//facturapuntoventaBeanSwingJInternalFrame.jTtoolBarFacturaPuntoVenta.setBorder(borderResaltarDetalleFacturaPuntoVenta);
			
		this.resaltarDetalleFacturaPuntoVentaFacturaPuntoVenta= borderResaltarDetalleFacturaPuntoVenta;

		 return borderResaltarDetalleFacturaPuntoVenta;
	}



	public Boolean mostrarDetalleFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean getMostrarDetalleFacturaPuntoVentaFacturaPuntoVenta() {
		return this.mostrarDetalleFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setMostrarDetalleFacturaPuntoVentaFacturaPuntoVenta(Boolean visibilidadResaltarDetalleFacturaPuntoVenta) {
		this.mostrarDetalleFacturaPuntoVentaFacturaPuntoVenta= visibilidadResaltarDetalleFacturaPuntoVenta;
	}



	public Boolean activarDetalleFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean gethabilitarResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta() {
		return this.activarDetalleFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setActivarDetalleFacturaPuntoVentaFacturaPuntoVenta(Boolean habilitarResaltarDetalleFacturaPuntoVenta) {
		this.activarDetalleFacturaPuntoVentaFacturaPuntoVenta= habilitarResaltarDetalleFacturaPuntoVenta;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarFormaPagoPuntoVentaFacturaPuntoVenta(esInicial);
		this.setMostrarDetalleFacturaPuntoVentaFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFacturaPuntoVenta.class)) {
				this.setMostrarDetalleFacturaPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarFormaPagoPuntoVentaFacturaPuntoVenta(esInicial);
		this.setActivarDetalleFacturaPuntoVentaFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFacturaPuntoVenta.class)) {
				this.setActivarDetalleFacturaPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormaPagoPuntoVentaFacturaPuntoVenta(esInicial);
		this.setResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFacturaPuntoVenta.class)) {
				this.setResaltarDetalleFacturaPuntoVentaFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdAsientoContableFacturaPuntoVenta() {
		return this.mostrarFK_IdAsientoContableFacturaPuntoVenta;
	}

	public void setMostrarFK_IdAsientoContableFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCajaFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdCajaFacturaPuntoVenta() {
		return this.mostrarFK_IdCajaFacturaPuntoVenta;
	}

	public void setMostrarFK_IdCajaFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdClienteFacturaPuntoVenta() {
		return this.mostrarFK_IdClienteFacturaPuntoVenta;
	}

	public void setMostrarFK_IdClienteFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaFacturaPuntoVenta() {
		return this.mostrarFK_IdEmpresaFacturaPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.mostrarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setMostrarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdFormatoFacturaPuntoVenta() {
		return this.mostrarFK_IdFormatoFacturaPuntoVenta;
	}

	public void setMostrarFK_IdFormatoFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesaFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdMesaFacturaPuntoVenta() {
		return this.mostrarFK_IdMesaFacturaPuntoVenta;
	}

	public void setMostrarFK_IdMesaFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesaFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalFacturaPuntoVenta() {
		return this.mostrarFK_IdSucursalFacturaPuntoVenta;
	}

	public void setMostrarFK_IdSucursalFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.mostrarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setMostrarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoPrecioFacturaPuntoVenta() {
		return this.mostrarFK_IdTipoPrecioFacturaPuntoVenta;
	}

	public void setMostrarFK_IdTipoPrecioFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdUsuarioFacturaPuntoVenta() {
		return this.mostrarFK_IdUsuarioFacturaPuntoVenta;
	}

	public void setMostrarFK_IdUsuarioFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdVendedorFacturaPuntoVenta() {
		return this.mostrarFK_IdVendedorFacturaPuntoVenta;
	}

	public void setMostrarFK_IdVendedorFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorFacturaPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdAsientoContableFacturaPuntoVenta() {
		return this.activarFK_IdAsientoContableFacturaPuntoVenta;
	}

	public void setActivarFK_IdAsientoContableFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdCajaFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdCajaFacturaPuntoVenta() {
		return this.activarFK_IdCajaFacturaPuntoVenta;
	}

	public void setActivarFK_IdCajaFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdCajaFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdClienteFacturaPuntoVenta() {
		return this.activarFK_IdClienteFacturaPuntoVenta;
	}

	public void setActivarFK_IdClienteFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaFacturaPuntoVenta() {
		return this.activarFK_IdEmpresaFacturaPuntoVenta;
	}

	public void setActivarFK_IdEmpresaFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.activarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setActivarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdFormatoFacturaPuntoVenta() {
		return this.activarFK_IdFormatoFacturaPuntoVenta;
	}

	public void setActivarFK_IdFormatoFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdMesaFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdMesaFacturaPuntoVenta() {
		return this.activarFK_IdMesaFacturaPuntoVenta;
	}

	public void setActivarFK_IdMesaFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdMesaFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalFacturaPuntoVenta() {
		return this.activarFK_IdSucursalFacturaPuntoVenta;
	}

	public void setActivarFK_IdSucursalFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.activarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setActivarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdTipoPrecioFacturaPuntoVenta() {
		return this.activarFK_IdTipoPrecioFacturaPuntoVenta;
	}

	public void setActivarFK_IdTipoPrecioFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdUsuarioFacturaPuntoVenta() {
		return this.activarFK_IdUsuarioFacturaPuntoVenta;
	}

	public void setActivarFK_IdUsuarioFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdVendedorFacturaPuntoVenta() {
		return this.activarFK_IdVendedorFacturaPuntoVenta;
	}

	public void setActivarFK_IdVendedorFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorFacturaPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableFacturaPuntoVenta=null;

	public Border getResaltarFK_IdAsientoContableFacturaPuntoVenta() {
		return this.resaltarFK_IdAsientoContableFacturaPuntoVenta;
	}

	public void setResaltarFK_IdAsientoContableFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdCajaFacturaPuntoVenta=null;

	public Border getResaltarFK_IdCajaFacturaPuntoVenta() {
		return this.resaltarFK_IdCajaFacturaPuntoVenta;
	}

	public void setResaltarFK_IdCajaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdCajaFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdCajaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdClienteFacturaPuntoVenta=null;

	public Border getResaltarFK_IdClienteFacturaPuntoVenta() {
		return this.resaltarFK_IdClienteFacturaPuntoVenta;
	}

	public void setResaltarFK_IdClienteFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdClienteFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdClienteFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFacturaPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaFacturaPuntoVenta() {
		return this.resaltarFK_IdEmpresaFacturaPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta=null;

	public Border getResaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.resaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setResaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoFacturaPuntoVentaFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdFormatoFacturaPuntoVenta=null;

	public Border getResaltarFK_IdFormatoFacturaPuntoVenta() {
		return this.resaltarFK_IdFormatoFacturaPuntoVenta;
	}

	public void setResaltarFK_IdFormatoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdFormatoFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdFormatoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdMesaFacturaPuntoVenta=null;

	public Border getResaltarFK_IdMesaFacturaPuntoVenta() {
		return this.resaltarFK_IdMesaFacturaPuntoVenta;
	}

	public void setResaltarFK_IdMesaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdMesaFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdMesaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesaFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFacturaPuntoVenta=null;

	public Border getResaltarFK_IdSucursalFacturaPuntoVenta() {
		return this.resaltarFK_IdSucursalFacturaPuntoVenta;
	}

	public void setResaltarFK_IdSucursalFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta=null;

	public Border getResaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta() {
		return this.resaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta;
	}

	public void setResaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFacturaPuntoVentaFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioFacturaPuntoVenta=null;

	public Border getResaltarFK_IdTipoPrecioFacturaPuntoVenta() {
		return this.resaltarFK_IdTipoPrecioFacturaPuntoVenta;
	}

	public void setResaltarFK_IdTipoPrecioFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioFacturaPuntoVenta=null;

	public Border getResaltarFK_IdUsuarioFacturaPuntoVenta() {
		return this.resaltarFK_IdUsuarioFacturaPuntoVenta;
	}

	public void setResaltarFK_IdUsuarioFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUsuarioFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdVendedorFacturaPuntoVenta=null;

	public Border getResaltarFK_IdVendedorFacturaPuntoVenta() {
		return this.resaltarFK_IdVendedorFacturaPuntoVenta;
	}

	public void setResaltarFK_IdVendedorFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdVendedorFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdVendedorFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaPuntoVentaBeanSwingJInternalFrame facturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorFacturaPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}