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


import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NotaCreditoPuntoVentaConstantesFunciones extends NotaCreditoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NotaCreditoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NotaCreditoPuntoVenta"+NotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NotaCreditoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NotaCreditoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NotaCreditoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NotaCreditoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NotaCreditoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NotaCreditoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Nota Credito Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NotaCreditoPuntoVenta";
	public static final String OBJECTNAME="notacreditopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="nota_credito_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select notacreditopuntoventa from "+NotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" notacreditopuntoventa";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_factura_punto_venta,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_estado_nota_credito_punto_venta,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".hora,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".flete,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".otros,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total from "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected NotaCreditoPuntoVentaConstantesFuncionesAdditional notacreditopuntoventaConstantesFuncionesAdditional=null;
	
	public NotaCreditoPuntoVentaConstantesFuncionesAdditional getNotaCreditoPuntoVentaConstantesFuncionesAdditional() {
		return this.notacreditopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setNotaCreditoPuntoVentaConstantesFuncionesAdditional(NotaCreditoPuntoVentaConstantesFuncionesAdditional notacreditopuntoventaConstantesFuncionesAdditional) {
		try {
			this.notacreditopuntoventaConstantesFuncionesAdditional=notacreditopuntoventaConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDMESA= "id_mesa";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOFACTURAPUNTOVENTA= "id_tipo_factura_punto_venta";
    public static final String IDESTADONOTACREDITOPUNTOVENTA= "id_estado_nota_credito_punto_venta";
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
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDMESA= "Mesa";
		public static final String LABEL_IDMESA_LOWER= "Mesa";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOFACTURAPUNTOVENTA= "Tipo";
		public static final String LABEL_IDTIPOFACTURAPUNTOVENTA_LOWER= "Tipo Factura Punto Venta";
    	public static final String LABEL_IDESTADONOTACREDITOPUNTOVENTA= "Estado";
		public static final String LABEL_IDESTADONOTACREDITOPUNTOVENTA_LOWER= "Estado Nota Credito Punto Venta";
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
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getNotaCreditoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCAJA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDMESA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDMESA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDESTADONOTACREDITOPUNTOVENTA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.FECHA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.HORA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.FLETE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.OTROS)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNotaCreditoPuntoVentaDescripcion(NotaCreditoPuntoVenta notacreditopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(notacreditopuntoventa !=null/* && notacreditopuntoventa.getId()!=0*/) {
			sDescripcion=notacreditopuntoventa.getnumero_secuencial();//notacreditopuntoventanotacreditopuntoventa.getnumero_secuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNotaCreditoPuntoVentaDescripcionDetallado(NotaCreditoPuntoVenta notacreditopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=notacreditopuntoventa.getId().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=notacreditopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=notacreditopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=notacreditopuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=notacreditopuntoventa.getid_usuario().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=notacreditopuntoventa.getid_vendedor().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.getid_cliente().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=notacreditopuntoventa.getid_caja().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=notacreditopuntoventa.getid_asiento_contable().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=notacreditopuntoventa.getid_tipo_precio().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDMESA+"=";
		sDescripcion+=notacreditopuntoventa.getid_mesa().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=notacreditopuntoventa.getid_formato().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA+"=";
		sDescripcion+=notacreditopuntoventa.getid_tipo_factura_punto_venta().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA+"=";
		sDescripcion+=notacreditopuntoventa.getid_estado_nota_credito_punto_venta().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=notacreditopuntoventa.getnumero_secuencial()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.getcodigo_cliente()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.getnombre_cliente()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.gettarjeta_cliente()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.getdireccion_cliente()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=notacreditopuntoventa.gettelefono_cliente()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.FECHA+"=";
		sDescripcion+=notacreditopuntoventa.getfecha().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.HORA+"=";
		sDescripcion+=notacreditopuntoventa.gethora().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=notacreditopuntoventa.gettotal_iva().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=notacreditopuntoventa.gettotal_sin_iva().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=notacreditopuntoventa.getiva().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=notacreditopuntoventa.getdescuento().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=notacreditopuntoventa.getfinanciamiento().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.FLETE+"=";
		sDescripcion+=notacreditopuntoventa.getflete().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=notacreditopuntoventa.getice().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.OTROS+"=";
		sDescripcion+=notacreditopuntoventa.getotros().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=notacreditopuntoventa.getsub_total().toString()+",";
		sDescripcion+=NotaCreditoPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=notacreditopuntoventa.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNotaCreditoPuntoVentaDescripcion(NotaCreditoPuntoVenta notacreditopuntoventa,String sValor) throws Exception {			
		if(notacreditopuntoventa !=null) {
			notacreditopuntoventa.setnumero_secuencial(sValor);;//notacreditopuntoventanotacreditopuntoventa.getnumero_secuencial().trim();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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

	public static String getEstadoNotaCreditoPuntoVentaDescripcion(EstadoNotaCredito estadonotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadonotacredito!=null/*&&estadonotacredito.getId()>0*/) {
			sDescripcion=EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(estadonotacredito);
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
		} else if(sNombreIndice.equals("FK_IdEstadoNotaCreditoPuntoVenta")) {
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

	public static String getDetalleIndiceFK_IdEstadoNotaCreditoPuntoVenta(Long id_estado_nota_credito_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_nota_credito_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_nota_credito_punto_venta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		notacreditopuntoventa.setnumero_secuencial(notacreditopuntoventa.getnumero_secuencial().trim());
		notacreditopuntoventa.setcodigo_cliente(notacreditopuntoventa.getcodigo_cliente().trim());
		notacreditopuntoventa.setnombre_cliente(notacreditopuntoventa.getnombre_cliente().trim());
		notacreditopuntoventa.settarjeta_cliente(notacreditopuntoventa.gettarjeta_cliente().trim());
		notacreditopuntoventa.setdireccion_cliente(notacreditopuntoventa.getdireccion_cliente().trim());
		notacreditopuntoventa.settelefono_cliente(notacreditopuntoventa.gettelefono_cliente().trim());
	}
	
	public static void quitarEspaciosNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa: notacreditopuntoventas) {
			notacreditopuntoventa.setnumero_secuencial(notacreditopuntoventa.getnumero_secuencial().trim());
			notacreditopuntoventa.setcodigo_cliente(notacreditopuntoventa.getcodigo_cliente().trim());
			notacreditopuntoventa.setnombre_cliente(notacreditopuntoventa.getnombre_cliente().trim());
			notacreditopuntoventa.settarjeta_cliente(notacreditopuntoventa.gettarjeta_cliente().trim());
			notacreditopuntoventa.setdireccion_cliente(notacreditopuntoventa.getdireccion_cliente().trim());
			notacreditopuntoventa.settelefono_cliente(notacreditopuntoventa.gettelefono_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && notacreditopuntoventa.getConCambioAuxiliar()) {
			notacreditopuntoventa.setIsDeleted(notacreditopuntoventa.getIsDeletedAuxiliar());	
			notacreditopuntoventa.setIsNew(notacreditopuntoventa.getIsNewAuxiliar());	
			notacreditopuntoventa.setIsChanged(notacreditopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			notacreditopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			notacreditopuntoventa.setIsDeletedAuxiliar(false);	
			notacreditopuntoventa.setIsNewAuxiliar(false);	
			notacreditopuntoventa.setIsChangedAuxiliar(false);
			
			notacreditopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa : notacreditopuntoventas) {
			if(conAsignarBase && notacreditopuntoventa.getConCambioAuxiliar()) {
				notacreditopuntoventa.setIsDeleted(notacreditopuntoventa.getIsDeletedAuxiliar());	
				notacreditopuntoventa.setIsNew(notacreditopuntoventa.getIsNewAuxiliar());	
				notacreditopuntoventa.setIsChanged(notacreditopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				notacreditopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				notacreditopuntoventa.setIsDeletedAuxiliar(false);	
				notacreditopuntoventa.setIsNewAuxiliar(false);	
				notacreditopuntoventa.setIsChangedAuxiliar(false);
				
				notacreditopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa,Boolean conEnteros) throws Exception  {
		notacreditopuntoventa.settotal_iva(0.0);
		notacreditopuntoventa.settotal_sin_iva(0.0);
		notacreditopuntoventa.setiva(0.0);
		notacreditopuntoventa.setdescuento(0.0);
		notacreditopuntoventa.setfinanciamiento(0.0);
		notacreditopuntoventa.setflete(0.0);
		notacreditopuntoventa.setice(0.0);
		notacreditopuntoventa.setotros(0.0);
		notacreditopuntoventa.setsub_total(0.0);
		notacreditopuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa: notacreditopuntoventas) {
			notacreditopuntoventa.settotal_iva(0.0);
			notacreditopuntoventa.settotal_sin_iva(0.0);
			notacreditopuntoventa.setiva(0.0);
			notacreditopuntoventa.setdescuento(0.0);
			notacreditopuntoventa.setfinanciamiento(0.0);
			notacreditopuntoventa.setflete(0.0);
			notacreditopuntoventa.setice(0.0);
			notacreditopuntoventa.setotros(0.0);
			notacreditopuntoventa.setsub_total(0.0);
			notacreditopuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVenta notacreditopuntoventaAux) throws Exception  {
		NotaCreditoPuntoVentaConstantesFunciones.InicializarValoresNotaCreditoPuntoVenta(notacreditopuntoventaAux,true);
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa: notacreditopuntoventas) {
			if(notacreditopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			notacreditopuntoventaAux.settotal_iva(notacreditopuntoventaAux.gettotal_iva()+notacreditopuntoventa.gettotal_iva());			
			notacreditopuntoventaAux.settotal_sin_iva(notacreditopuntoventaAux.gettotal_sin_iva()+notacreditopuntoventa.gettotal_sin_iva());			
			notacreditopuntoventaAux.setiva(notacreditopuntoventaAux.getiva()+notacreditopuntoventa.getiva());			
			notacreditopuntoventaAux.setdescuento(notacreditopuntoventaAux.getdescuento()+notacreditopuntoventa.getdescuento());			
			notacreditopuntoventaAux.setfinanciamiento(notacreditopuntoventaAux.getfinanciamiento()+notacreditopuntoventa.getfinanciamiento());			
			notacreditopuntoventaAux.setflete(notacreditopuntoventaAux.getflete()+notacreditopuntoventa.getflete());			
			notacreditopuntoventaAux.setice(notacreditopuntoventaAux.getice()+notacreditopuntoventa.getice());			
			notacreditopuntoventaAux.setotros(notacreditopuntoventaAux.getotros()+notacreditopuntoventa.getotros());			
			notacreditopuntoventaAux.setsub_total(notacreditopuntoventaAux.getsub_total()+notacreditopuntoventa.getsub_total());			
			notacreditopuntoventaAux.settotal(notacreditopuntoventaAux.gettotal()+notacreditopuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NotaCreditoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesNotaCreditoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVenta notacreditopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NotaCreditoPuntoVenta notacreditopuntoventaAux: notacreditopuntoventas) {
			if(notacreditopuntoventaAux!=null && notacreditopuntoventa!=null) {
				if((notacreditopuntoventaAux.getId()==null && notacreditopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(notacreditopuntoventaAux.getId()!=null && notacreditopuntoventa.getId()!=null){
					if(notacreditopuntoventaAux.getId().equals(notacreditopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> notacreditopuntoventas) throws Exception  {
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
	
		for(NotaCreditoPuntoVenta notacreditopuntoventa: notacreditopuntoventas) {			
			if(notacreditopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=notacreditopuntoventa.gettotal_iva();
			total_sin_ivaTotal+=notacreditopuntoventa.gettotal_sin_iva();
			ivaTotal+=notacreditopuntoventa.getiva();
			descuentoTotal+=notacreditopuntoventa.getdescuento();
			financiamientoTotal+=notacreditopuntoventa.getfinanciamiento();
			fleteTotal+=notacreditopuntoventa.getflete();
			iceTotal+=notacreditopuntoventa.getice();
			otrosTotal+=notacreditopuntoventa.getotros();
			sub_totalTotal+=notacreditopuntoventa.getsub_total();
			totalTotal+=notacreditopuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.OTROS);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS);
		datoGeneral.setdValorDouble(otrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNotaCreditoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_ID, NotaCreditoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, NotaCreditoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO, NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR, NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE, NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCAJA, NotaCreditoPuntoVentaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE, NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO, NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDMESA, NotaCreditoPuntoVentaConstantesFunciones.IDMESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDFORMATO, NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA, NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDESTADONOTACREDITOPUNTOVENTA, NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL, NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE, NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE, NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE, NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE, NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE, NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_FECHA, NotaCreditoPuntoVentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_HORA, NotaCreditoPuntoVentaConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA, NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA, NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA, NotaCreditoPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO, NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO, NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE, NotaCreditoPuntoVentaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE, NotaCreditoPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS, NotaCreditoPuntoVentaConstantesFunciones.OTROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL, NotaCreditoPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNotaCreditoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDMESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.OTROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoPuntoVenta() throws Exception  {
		return NotaCreditoPuntoVentaConstantesFunciones.getTiposSeleccionarNotaCreditoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoPuntoVenta(Boolean conFk) throws Exception  {
		return NotaCreditoPuntoVentaConstantesFunciones.getTiposSeleccionarNotaCreditoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDMESA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDMESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDESTADONOTACREDITOPUNTOVENTA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDESTADONOTACREDITOPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNotaCreditoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventaAux) throws Exception {
		
			notacreditopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditopuntoventaAux.getEmpresa()));
			notacreditopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditopuntoventaAux.getSucursal()));
			notacreditopuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditopuntoventaAux.getUsuario()));
			notacreditopuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditopuntoventaAux.getVendedor()));
			notacreditopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditopuntoventaAux.getCliente()));
			notacreditopuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(notacreditopuntoventaAux.getCaja()));
			notacreditopuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(notacreditopuntoventaAux.getAsientoContable()));
			notacreditopuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditopuntoventaAux.getTipoPrecio()));
			notacreditopuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(notacreditopuntoventaAux.getMesa()));
			notacreditopuntoventaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditopuntoventaAux.getFormato()));
			notacreditopuntoventaAux.settipofacturapuntoventa_descripcion(TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(notacreditopuntoventaAux.getTipoFacturaPuntoVenta()));
			notacreditopuntoventaAux.setestadonotacreditopuntoventa_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditopuntoventaAux.getEstadoNotaCreditoPuntoVenta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> notacreditopuntoventasTemp) throws Exception {
		for(NotaCreditoPuntoVenta notacreditopuntoventaAux:notacreditopuntoventasTemp) {
			
			notacreditopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditopuntoventaAux.getEmpresa()));
			notacreditopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditopuntoventaAux.getSucursal()));
			notacreditopuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditopuntoventaAux.getUsuario()));
			notacreditopuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditopuntoventaAux.getVendedor()));
			notacreditopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditopuntoventaAux.getCliente()));
			notacreditopuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(notacreditopuntoventaAux.getCaja()));
			notacreditopuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(notacreditopuntoventaAux.getAsientoContable()));
			notacreditopuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditopuntoventaAux.getTipoPrecio()));
			notacreditopuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(notacreditopuntoventaAux.getMesa()));
			notacreditopuntoventaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditopuntoventaAux.getFormato()));
			notacreditopuntoventaAux.settipofacturapuntoventa_descripcion(TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(notacreditopuntoventaAux.getTipoFacturaPuntoVenta()));
			notacreditopuntoventaAux.setestadonotacreditopuntoventa_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditopuntoventaAux.getEstadoNotaCreditoPuntoVenta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Mesa.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoFacturaPuntoVenta.class));
				classes.add(new Classe(EstadoNotaCredito.class));
				
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
					if(clas.clas.equals(EstadoNotaCredito.class)) {
						classes.add(new Classe(EstadoNotaCredito.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsOfNotaCreditoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleNotaCreditoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(DetalleNotaCreditoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfNotaCreditoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleNotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleNotaCreditoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleNotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleNotaCreditoPuntoVenta.class)); continue;
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
	public static void actualizarLista(NotaCreditoPuntoVenta notacreditopuntoventa,List<NotaCreditoPuntoVenta> notacreditopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NotaCreditoPuntoVenta notacreditopuntoventaEncontrado=null;
			
			for(NotaCreditoPuntoVenta notacreditopuntoventaLocal:notacreditopuntoventas) {
				if(notacreditopuntoventaLocal.getId().equals(notacreditopuntoventa.getId())) {
					notacreditopuntoventaEncontrado=notacreditopuntoventaLocal;
					
					notacreditopuntoventaLocal.setIsChanged(notacreditopuntoventa.getIsChanged());
					notacreditopuntoventaLocal.setIsNew(notacreditopuntoventa.getIsNew());
					notacreditopuntoventaLocal.setIsDeleted(notacreditopuntoventa.getIsDeleted());
					
					notacreditopuntoventaLocal.setGeneralEntityOriginal(notacreditopuntoventa.getGeneralEntityOriginal());
					
					notacreditopuntoventaLocal.setId(notacreditopuntoventa.getId());	
					notacreditopuntoventaLocal.setVersionRow(notacreditopuntoventa.getVersionRow());	
					notacreditopuntoventaLocal.setid_empresa(notacreditopuntoventa.getid_empresa());	
					notacreditopuntoventaLocal.setid_sucursal(notacreditopuntoventa.getid_sucursal());	
					notacreditopuntoventaLocal.setid_usuario(notacreditopuntoventa.getid_usuario());	
					notacreditopuntoventaLocal.setid_vendedor(notacreditopuntoventa.getid_vendedor());	
					notacreditopuntoventaLocal.setid_cliente(notacreditopuntoventa.getid_cliente());	
					notacreditopuntoventaLocal.setid_caja(notacreditopuntoventa.getid_caja());	
					notacreditopuntoventaLocal.setid_asiento_contable(notacreditopuntoventa.getid_asiento_contable());	
					notacreditopuntoventaLocal.setid_tipo_precio(notacreditopuntoventa.getid_tipo_precio());	
					notacreditopuntoventaLocal.setid_mesa(notacreditopuntoventa.getid_mesa());	
					notacreditopuntoventaLocal.setid_formato(notacreditopuntoventa.getid_formato());	
					notacreditopuntoventaLocal.setid_tipo_factura_punto_venta(notacreditopuntoventa.getid_tipo_factura_punto_venta());	
					notacreditopuntoventaLocal.setid_estado_nota_credito_punto_venta(notacreditopuntoventa.getid_estado_nota_credito_punto_venta());	
					notacreditopuntoventaLocal.setnumero_secuencial(notacreditopuntoventa.getnumero_secuencial());	
					notacreditopuntoventaLocal.setcodigo_cliente(notacreditopuntoventa.getcodigo_cliente());	
					notacreditopuntoventaLocal.setnombre_cliente(notacreditopuntoventa.getnombre_cliente());	
					notacreditopuntoventaLocal.settarjeta_cliente(notacreditopuntoventa.gettarjeta_cliente());	
					notacreditopuntoventaLocal.setdireccion_cliente(notacreditopuntoventa.getdireccion_cliente());	
					notacreditopuntoventaLocal.settelefono_cliente(notacreditopuntoventa.gettelefono_cliente());	
					notacreditopuntoventaLocal.setfecha(notacreditopuntoventa.getfecha());	
					notacreditopuntoventaLocal.sethora(notacreditopuntoventa.gethora());	
					notacreditopuntoventaLocal.settotal_iva(notacreditopuntoventa.gettotal_iva());	
					notacreditopuntoventaLocal.settotal_sin_iva(notacreditopuntoventa.gettotal_sin_iva());	
					notacreditopuntoventaLocal.setiva(notacreditopuntoventa.getiva());	
					notacreditopuntoventaLocal.setdescuento(notacreditopuntoventa.getdescuento());	
					notacreditopuntoventaLocal.setfinanciamiento(notacreditopuntoventa.getfinanciamiento());	
					notacreditopuntoventaLocal.setflete(notacreditopuntoventa.getflete());	
					notacreditopuntoventaLocal.setice(notacreditopuntoventa.getice());	
					notacreditopuntoventaLocal.setotros(notacreditopuntoventa.getotros());	
					notacreditopuntoventaLocal.setsub_total(notacreditopuntoventa.getsub_total());	
					notacreditopuntoventaLocal.settotal(notacreditopuntoventa.gettotal());	
					
					
					notacreditopuntoventaLocal.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!notacreditopuntoventa.getIsDeleted()) {
				if(!existe) {
					notacreditopuntoventas.add(notacreditopuntoventa);
				}
			} else {
				if(notacreditopuntoventaEncontrado!=null && permiteQuitar)  {
					notacreditopuntoventas.remove(notacreditopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NotaCreditoPuntoVenta notacreditopuntoventa,List<NotaCreditoPuntoVenta> notacreditopuntoventas) throws Exception {
		try	{			
			for(NotaCreditoPuntoVenta notacreditopuntoventaLocal:notacreditopuntoventas) {
				if(notacreditopuntoventaLocal.getId().equals(notacreditopuntoventa.getId())) {
					notacreditopuntoventaLocal.setIsSelected(notacreditopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> notacreditopuntoventasAux) throws Exception {
		//this.notacreditopuntoventasAux=notacreditopuntoventasAux;
		
		for(NotaCreditoPuntoVenta notacreditopuntoventaAux:notacreditopuntoventasAux) {
			if(notacreditopuntoventaAux.getIsChanged()) {
				notacreditopuntoventaAux.setIsChanged(false);
			}		
			
			if(notacreditopuntoventaAux.getIsNew()) {
				notacreditopuntoventaAux.setIsNew(false);
			}	
			
			if(notacreditopuntoventaAux.getIsDeleted()) {
				notacreditopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventaAux) throws Exception {
		//this.notacreditopuntoventaAux=notacreditopuntoventaAux;
		
			if(notacreditopuntoventaAux.getIsChanged()) {
				notacreditopuntoventaAux.setIsChanged(false);
			}		
			
			if(notacreditopuntoventaAux.getIsNew()) {
				notacreditopuntoventaAux.setIsNew(false);
			}	
			
			if(notacreditopuntoventaAux.getIsDeleted()) {
				notacreditopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NotaCreditoPuntoVenta notacreditopuntoventaAsignar,NotaCreditoPuntoVenta notacreditopuntoventa) throws Exception {
		notacreditopuntoventaAsignar.setId(notacreditopuntoventa.getId());	
		notacreditopuntoventaAsignar.setVersionRow(notacreditopuntoventa.getVersionRow());	
		notacreditopuntoventaAsignar.setid_empresa(notacreditopuntoventa.getid_empresa());
		notacreditopuntoventaAsignar.setempresa_descripcion(notacreditopuntoventa.getempresa_descripcion());	
		notacreditopuntoventaAsignar.setid_sucursal(notacreditopuntoventa.getid_sucursal());
		notacreditopuntoventaAsignar.setsucursal_descripcion(notacreditopuntoventa.getsucursal_descripcion());	
		notacreditopuntoventaAsignar.setid_usuario(notacreditopuntoventa.getid_usuario());
		notacreditopuntoventaAsignar.setusuario_descripcion(notacreditopuntoventa.getusuario_descripcion());	
		notacreditopuntoventaAsignar.setid_vendedor(notacreditopuntoventa.getid_vendedor());
		notacreditopuntoventaAsignar.setvendedor_descripcion(notacreditopuntoventa.getvendedor_descripcion());	
		notacreditopuntoventaAsignar.setid_cliente(notacreditopuntoventa.getid_cliente());
		notacreditopuntoventaAsignar.setcliente_descripcion(notacreditopuntoventa.getcliente_descripcion());	
		notacreditopuntoventaAsignar.setid_caja(notacreditopuntoventa.getid_caja());
		notacreditopuntoventaAsignar.setcaja_descripcion(notacreditopuntoventa.getcaja_descripcion());	
		notacreditopuntoventaAsignar.setid_asiento_contable(notacreditopuntoventa.getid_asiento_contable());
		notacreditopuntoventaAsignar.setasientocontable_descripcion(notacreditopuntoventa.getasientocontable_descripcion());	
		notacreditopuntoventaAsignar.setid_tipo_precio(notacreditopuntoventa.getid_tipo_precio());
		notacreditopuntoventaAsignar.settipoprecio_descripcion(notacreditopuntoventa.gettipoprecio_descripcion());	
		notacreditopuntoventaAsignar.setid_mesa(notacreditopuntoventa.getid_mesa());
		notacreditopuntoventaAsignar.setmesa_descripcion(notacreditopuntoventa.getmesa_descripcion());	
		notacreditopuntoventaAsignar.setid_formato(notacreditopuntoventa.getid_formato());
		notacreditopuntoventaAsignar.setformato_descripcion(notacreditopuntoventa.getformato_descripcion());	
		notacreditopuntoventaAsignar.setid_tipo_factura_punto_venta(notacreditopuntoventa.getid_tipo_factura_punto_venta());
		notacreditopuntoventaAsignar.settipofacturapuntoventa_descripcion(notacreditopuntoventa.gettipofacturapuntoventa_descripcion());	
		notacreditopuntoventaAsignar.setid_estado_nota_credito_punto_venta(notacreditopuntoventa.getid_estado_nota_credito_punto_venta());
		notacreditopuntoventaAsignar.setestadonotacreditopuntoventa_descripcion(notacreditopuntoventa.getestadonotacreditopuntoventa_descripcion());	
		notacreditopuntoventaAsignar.setnumero_secuencial(notacreditopuntoventa.getnumero_secuencial());	
		notacreditopuntoventaAsignar.setcodigo_cliente(notacreditopuntoventa.getcodigo_cliente());	
		notacreditopuntoventaAsignar.setnombre_cliente(notacreditopuntoventa.getnombre_cliente());	
		notacreditopuntoventaAsignar.settarjeta_cliente(notacreditopuntoventa.gettarjeta_cliente());	
		notacreditopuntoventaAsignar.setdireccion_cliente(notacreditopuntoventa.getdireccion_cliente());	
		notacreditopuntoventaAsignar.settelefono_cliente(notacreditopuntoventa.gettelefono_cliente());	
		notacreditopuntoventaAsignar.setfecha(notacreditopuntoventa.getfecha());	
		notacreditopuntoventaAsignar.sethora(notacreditopuntoventa.gethora());	
		notacreditopuntoventaAsignar.settotal_iva(notacreditopuntoventa.gettotal_iva());	
		notacreditopuntoventaAsignar.settotal_sin_iva(notacreditopuntoventa.gettotal_sin_iva());	
		notacreditopuntoventaAsignar.setiva(notacreditopuntoventa.getiva());	
		notacreditopuntoventaAsignar.setdescuento(notacreditopuntoventa.getdescuento());	
		notacreditopuntoventaAsignar.setfinanciamiento(notacreditopuntoventa.getfinanciamiento());	
		notacreditopuntoventaAsignar.setflete(notacreditopuntoventa.getflete());	
		notacreditopuntoventaAsignar.setice(notacreditopuntoventa.getice());	
		notacreditopuntoventaAsignar.setotros(notacreditopuntoventa.getotros());	
		notacreditopuntoventaAsignar.setsub_total(notacreditopuntoventa.getsub_total());	
		notacreditopuntoventaAsignar.settotal(notacreditopuntoventa.gettotal());	
	}
	
	public static void inicializarNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa) throws Exception {
		try {
				notacreditopuntoventa.setId(0L);	
					
				notacreditopuntoventa.setid_empresa(-1L);	
				notacreditopuntoventa.setid_sucursal(-1L);	
				notacreditopuntoventa.setid_usuario(-1L);	
				notacreditopuntoventa.setid_vendedor(-1L);	
				notacreditopuntoventa.setid_cliente(-1L);	
				notacreditopuntoventa.setid_caja(-1L);	
				notacreditopuntoventa.setid_asiento_contable(null);	
				notacreditopuntoventa.setid_tipo_precio(-1L);	
				notacreditopuntoventa.setid_mesa(-1L);	
				notacreditopuntoventa.setid_formato(-1L);	
				notacreditopuntoventa.setid_tipo_factura_punto_venta(-1L);	
				notacreditopuntoventa.setid_estado_nota_credito_punto_venta(-1L);	
				notacreditopuntoventa.setnumero_secuencial("");	
				notacreditopuntoventa.setcodigo_cliente("");	
				notacreditopuntoventa.setnombre_cliente("");	
				notacreditopuntoventa.settarjeta_cliente("");	
				notacreditopuntoventa.setdireccion_cliente("");	
				notacreditopuntoventa.settelefono_cliente("");	
				notacreditopuntoventa.setfecha(new Date());	
				notacreditopuntoventa.sethora(new Time((new Date()).getTime()));	
				notacreditopuntoventa.settotal_iva(0.0);	
				notacreditopuntoventa.settotal_sin_iva(0.0);	
				notacreditopuntoventa.setiva(0.0);	
				notacreditopuntoventa.setdescuento(0.0);	
				notacreditopuntoventa.setfinanciamiento(0.0);	
				notacreditopuntoventa.setflete(0.0);	
				notacreditopuntoventa.setice(0.0);	
				notacreditopuntoventa.setotros(0.0);	
				notacreditopuntoventa.setsub_total(0.0);	
				notacreditopuntoventa.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNotaCreditoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDMESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDTIPOFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IDESTADONOTACREDITOPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_OTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNotaCreditoPuntoVenta(String sTipo,Row row,Workbook workbook,NotaCreditoPuntoVenta notacreditopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getmesa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettipofacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getestadonotacreditopuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettarjeta_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getotros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditopuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNotaCreditoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNotaCreditoPuntoVenta() {
		return this.sFinalQueryNotaCreditoPuntoVenta;
	}
	
	public void setsFinalQueryNotaCreditoPuntoVenta(String sFinalQueryNotaCreditoPuntoVenta) {
		this.sFinalQueryNotaCreditoPuntoVenta= sFinalQueryNotaCreditoPuntoVenta;
	}
	
	public Border resaltarSeleccionarNotaCreditoPuntoVenta=null;
	
	public Border setResaltarSeleccionarNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNotaCreditoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNotaCreditoPuntoVenta() {
		return this.resaltarSeleccionarNotaCreditoPuntoVenta;
	}
	
	public void setResaltarSeleccionarNotaCreditoPuntoVenta(Border borderResaltarSeleccionarNotaCreditoPuntoVenta) {
		this.resaltarSeleccionarNotaCreditoPuntoVenta= borderResaltarSeleccionarNotaCreditoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNotaCreditoPuntoVenta=null;
	public Boolean mostraridNotaCreditoPuntoVenta=true;
	public Boolean activaridNotaCreditoPuntoVenta=true;

	public Border resaltarid_empresaNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_empresaNotaCreditoPuntoVenta=true;
	public Boolean activarid_empresaNotaCreditoPuntoVenta=true;
	public Boolean cargarid_empresaNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_sucursalNotaCreditoPuntoVenta=true;
	public Boolean activarid_sucursalNotaCreditoPuntoVenta=true;
	public Boolean cargarid_sucursalNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_usuarioNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_usuarioNotaCreditoPuntoVenta=true;
	public Boolean activarid_usuarioNotaCreditoPuntoVenta=true;
	public Boolean cargarid_usuarioNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_vendedorNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_vendedorNotaCreditoPuntoVenta=true;
	public Boolean activarid_vendedorNotaCreditoPuntoVenta=true;
	public Boolean cargarid_vendedorNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_clienteNotaCreditoPuntoVenta=true;
	public Boolean activarid_clienteNotaCreditoPuntoVenta=true;
	public Boolean cargarid_clienteNotaCreditoPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_cajaNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_cajaNotaCreditoPuntoVenta=true;
	public Boolean activarid_cajaNotaCreditoPuntoVenta=true;
	public Boolean cargarid_cajaNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_asiento_contableNotaCreditoPuntoVenta=true;
	public Boolean activarid_asiento_contableNotaCreditoPuntoVenta=false;
	public Boolean cargarid_asiento_contableNotaCreditoPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_tipo_precioNotaCreditoPuntoVenta=true;
	public Boolean activarid_tipo_precioNotaCreditoPuntoVenta=true;
	public Boolean cargarid_tipo_precioNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_mesaNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_mesaNotaCreditoPuntoVenta=true;
	public Boolean activarid_mesaNotaCreditoPuntoVenta=true;
	public Boolean cargarid_mesaNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesaNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_formatoNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_formatoNotaCreditoPuntoVenta=true;
	public Boolean activarid_formatoNotaCreditoPuntoVenta=true;
	public Boolean cargarid_formatoNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta=true;
	public Boolean activarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta=true;
	public Boolean cargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_factura_punto_ventaNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta=true;
	public Boolean activarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta=true;
	public Boolean cargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialNotaCreditoPuntoVenta=null;
	public Boolean mostrarnumero_secuencialNotaCreditoPuntoVenta=true;
	public Boolean activarnumero_secuencialNotaCreditoPuntoVenta=true;

	public Border resaltarcodigo_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrarcodigo_clienteNotaCreditoPuntoVenta=true;
	public Boolean activarcodigo_clienteNotaCreditoPuntoVenta=true;

	public Border resaltarnombre_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrarnombre_clienteNotaCreditoPuntoVenta=true;
	public Boolean activarnombre_clienteNotaCreditoPuntoVenta=true;

	public Border resaltartarjeta_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrartarjeta_clienteNotaCreditoPuntoVenta=true;
	public Boolean activartarjeta_clienteNotaCreditoPuntoVenta=true;

	public Border resaltardireccion_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrardireccion_clienteNotaCreditoPuntoVenta=true;
	public Boolean activardireccion_clienteNotaCreditoPuntoVenta=true;

	public Border resaltartelefono_clienteNotaCreditoPuntoVenta=null;
	public Boolean mostrartelefono_clienteNotaCreditoPuntoVenta=true;
	public Boolean activartelefono_clienteNotaCreditoPuntoVenta=true;

	public Border resaltarfechaNotaCreditoPuntoVenta=null;
	public Boolean mostrarfechaNotaCreditoPuntoVenta=true;
	public Boolean activarfechaNotaCreditoPuntoVenta=false;

	public Border resaltarhoraNotaCreditoPuntoVenta=null;
	public Boolean mostrarhoraNotaCreditoPuntoVenta=true;
	public Boolean activarhoraNotaCreditoPuntoVenta=true;

	public Border resaltartotal_ivaNotaCreditoPuntoVenta=null;
	public Boolean mostrartotal_ivaNotaCreditoPuntoVenta=true;
	public Boolean activartotal_ivaNotaCreditoPuntoVenta=true;

	public Border resaltartotal_sin_ivaNotaCreditoPuntoVenta=null;
	public Boolean mostrartotal_sin_ivaNotaCreditoPuntoVenta=true;
	public Boolean activartotal_sin_ivaNotaCreditoPuntoVenta=true;

	public Border resaltarivaNotaCreditoPuntoVenta=null;
	public Boolean mostrarivaNotaCreditoPuntoVenta=true;
	public Boolean activarivaNotaCreditoPuntoVenta=true;

	public Border resaltardescuentoNotaCreditoPuntoVenta=null;
	public Boolean mostrardescuentoNotaCreditoPuntoVenta=true;
	public Boolean activardescuentoNotaCreditoPuntoVenta=true;

	public Border resaltarfinanciamientoNotaCreditoPuntoVenta=null;
	public Boolean mostrarfinanciamientoNotaCreditoPuntoVenta=true;
	public Boolean activarfinanciamientoNotaCreditoPuntoVenta=true;

	public Border resaltarfleteNotaCreditoPuntoVenta=null;
	public Boolean mostrarfleteNotaCreditoPuntoVenta=true;
	public Boolean activarfleteNotaCreditoPuntoVenta=true;

	public Border resaltariceNotaCreditoPuntoVenta=null;
	public Boolean mostrariceNotaCreditoPuntoVenta=true;
	public Boolean activariceNotaCreditoPuntoVenta=true;

	public Border resaltarotrosNotaCreditoPuntoVenta=null;
	public Boolean mostrarotrosNotaCreditoPuntoVenta=true;
	public Boolean activarotrosNotaCreditoPuntoVenta=true;

	public Border resaltarsub_totalNotaCreditoPuntoVenta=null;
	public Boolean mostrarsub_totalNotaCreditoPuntoVenta=true;
	public Boolean activarsub_totalNotaCreditoPuntoVenta=true;

	public Border resaltartotalNotaCreditoPuntoVenta=null;
	public Boolean mostrartotalNotaCreditoPuntoVenta=true;
	public Boolean activartotalNotaCreditoPuntoVenta=true;

	
	

	public Border setResaltaridNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNotaCreditoPuntoVenta() {
		return this.resaltaridNotaCreditoPuntoVenta;
	}

	public void setResaltaridNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltaridNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridNotaCreditoPuntoVenta() {
		return this.mostraridNotaCreditoPuntoVenta;
	}

	public void setMostraridNotaCreditoPuntoVenta(Boolean mostraridNotaCreditoPuntoVenta) {
		this.mostraridNotaCreditoPuntoVenta= mostraridNotaCreditoPuntoVenta;
	}

	public Boolean getActivaridNotaCreditoPuntoVenta() {
		return this.activaridNotaCreditoPuntoVenta;
	}

	public void setActivaridNotaCreditoPuntoVenta(Boolean activaridNotaCreditoPuntoVenta) {
		this.activaridNotaCreditoPuntoVenta= activaridNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_empresaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNotaCreditoPuntoVenta() {
		return this.resaltarid_empresaNotaCreditoPuntoVenta;
	}

	public void setResaltarid_empresaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaNotaCreditoPuntoVenta() {
		return this.mostrarid_empresaNotaCreditoPuntoVenta;
	}

	public void setMostrarid_empresaNotaCreditoPuntoVenta(Boolean mostrarid_empresaNotaCreditoPuntoVenta) {
		this.mostrarid_empresaNotaCreditoPuntoVenta= mostrarid_empresaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_empresaNotaCreditoPuntoVenta() {
		return this.activarid_empresaNotaCreditoPuntoVenta;
	}

	public void setActivarid_empresaNotaCreditoPuntoVenta(Boolean activarid_empresaNotaCreditoPuntoVenta) {
		this.activarid_empresaNotaCreditoPuntoVenta= activarid_empresaNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_empresaNotaCreditoPuntoVenta() {
		return this.cargarid_empresaNotaCreditoPuntoVenta;
	}

	public void setCargarid_empresaNotaCreditoPuntoVenta(Boolean cargarid_empresaNotaCreditoPuntoVenta) {
		this.cargarid_empresaNotaCreditoPuntoVenta= cargarid_empresaNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_sucursalNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNotaCreditoPuntoVenta() {
		return this.resaltarid_sucursalNotaCreditoPuntoVenta;
	}

	public void setResaltarid_sucursalNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNotaCreditoPuntoVenta() {
		return this.mostrarid_sucursalNotaCreditoPuntoVenta;
	}

	public void setMostrarid_sucursalNotaCreditoPuntoVenta(Boolean mostrarid_sucursalNotaCreditoPuntoVenta) {
		this.mostrarid_sucursalNotaCreditoPuntoVenta= mostrarid_sucursalNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_sucursalNotaCreditoPuntoVenta() {
		return this.activarid_sucursalNotaCreditoPuntoVenta;
	}

	public void setActivarid_sucursalNotaCreditoPuntoVenta(Boolean activarid_sucursalNotaCreditoPuntoVenta) {
		this.activarid_sucursalNotaCreditoPuntoVenta= activarid_sucursalNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_sucursalNotaCreditoPuntoVenta() {
		return this.cargarid_sucursalNotaCreditoPuntoVenta;
	}

	public void setCargarid_sucursalNotaCreditoPuntoVenta(Boolean cargarid_sucursalNotaCreditoPuntoVenta) {
		this.cargarid_sucursalNotaCreditoPuntoVenta= cargarid_sucursalNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_usuarioNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_usuarioNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioNotaCreditoPuntoVenta() {
		return this.resaltarid_usuarioNotaCreditoPuntoVenta;
	}

	public void setResaltarid_usuarioNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_usuarioNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_usuarioNotaCreditoPuntoVenta() {
		return this.mostrarid_usuarioNotaCreditoPuntoVenta;
	}

	public void setMostrarid_usuarioNotaCreditoPuntoVenta(Boolean mostrarid_usuarioNotaCreditoPuntoVenta) {
		this.mostrarid_usuarioNotaCreditoPuntoVenta= mostrarid_usuarioNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_usuarioNotaCreditoPuntoVenta() {
		return this.activarid_usuarioNotaCreditoPuntoVenta;
	}

	public void setActivarid_usuarioNotaCreditoPuntoVenta(Boolean activarid_usuarioNotaCreditoPuntoVenta) {
		this.activarid_usuarioNotaCreditoPuntoVenta= activarid_usuarioNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_usuarioNotaCreditoPuntoVenta() {
		return this.cargarid_usuarioNotaCreditoPuntoVenta;
	}

	public void setCargarid_usuarioNotaCreditoPuntoVenta(Boolean cargarid_usuarioNotaCreditoPuntoVenta) {
		this.cargarid_usuarioNotaCreditoPuntoVenta= cargarid_usuarioNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_vendedorNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_vendedorNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorNotaCreditoPuntoVenta() {
		return this.resaltarid_vendedorNotaCreditoPuntoVenta;
	}

	public void setResaltarid_vendedorNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_vendedorNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_vendedorNotaCreditoPuntoVenta() {
		return this.mostrarid_vendedorNotaCreditoPuntoVenta;
	}

	public void setMostrarid_vendedorNotaCreditoPuntoVenta(Boolean mostrarid_vendedorNotaCreditoPuntoVenta) {
		this.mostrarid_vendedorNotaCreditoPuntoVenta= mostrarid_vendedorNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_vendedorNotaCreditoPuntoVenta() {
		return this.activarid_vendedorNotaCreditoPuntoVenta;
	}

	public void setActivarid_vendedorNotaCreditoPuntoVenta(Boolean activarid_vendedorNotaCreditoPuntoVenta) {
		this.activarid_vendedorNotaCreditoPuntoVenta= activarid_vendedorNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_vendedorNotaCreditoPuntoVenta() {
		return this.cargarid_vendedorNotaCreditoPuntoVenta;
	}

	public void setCargarid_vendedorNotaCreditoPuntoVenta(Boolean cargarid_vendedorNotaCreditoPuntoVenta) {
		this.cargarid_vendedorNotaCreditoPuntoVenta= cargarid_vendedorNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteNotaCreditoPuntoVenta() {
		return this.resaltarid_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltarid_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_clienteNotaCreditoPuntoVenta() {
		return this.mostrarid_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrarid_clienteNotaCreditoPuntoVenta(Boolean mostrarid_clienteNotaCreditoPuntoVenta) {
		this.mostrarid_clienteNotaCreditoPuntoVenta= mostrarid_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_clienteNotaCreditoPuntoVenta() {
		return this.activarid_clienteNotaCreditoPuntoVenta;
	}

	public void setActivarid_clienteNotaCreditoPuntoVenta(Boolean activarid_clienteNotaCreditoPuntoVenta) {
		this.activarid_clienteNotaCreditoPuntoVenta= activarid_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_clienteNotaCreditoPuntoVenta() {
		return this.cargarid_clienteNotaCreditoPuntoVenta;
	}

	public void setCargarid_clienteNotaCreditoPuntoVenta(Boolean cargarid_clienteNotaCreditoPuntoVenta) {
		this.cargarid_clienteNotaCreditoPuntoVenta= cargarid_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_cajaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_cajaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaNotaCreditoPuntoVenta() {
		return this.resaltarid_cajaNotaCreditoPuntoVenta;
	}

	public void setResaltarid_cajaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_cajaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_cajaNotaCreditoPuntoVenta() {
		return this.mostrarid_cajaNotaCreditoPuntoVenta;
	}

	public void setMostrarid_cajaNotaCreditoPuntoVenta(Boolean mostrarid_cajaNotaCreditoPuntoVenta) {
		this.mostrarid_cajaNotaCreditoPuntoVenta= mostrarid_cajaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_cajaNotaCreditoPuntoVenta() {
		return this.activarid_cajaNotaCreditoPuntoVenta;
	}

	public void setActivarid_cajaNotaCreditoPuntoVenta(Boolean activarid_cajaNotaCreditoPuntoVenta) {
		this.activarid_cajaNotaCreditoPuntoVenta= activarid_cajaNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_cajaNotaCreditoPuntoVenta() {
		return this.cargarid_cajaNotaCreditoPuntoVenta;
	}

	public void setCargarid_cajaNotaCreditoPuntoVenta(Boolean cargarid_cajaNotaCreditoPuntoVenta) {
		this.cargarid_cajaNotaCreditoPuntoVenta= cargarid_cajaNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_asiento_contableNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableNotaCreditoPuntoVenta() {
		return this.resaltarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public void setResaltarid_asiento_contableNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_asiento_contableNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableNotaCreditoPuntoVenta() {
		return this.mostrarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public void setMostrarid_asiento_contableNotaCreditoPuntoVenta(Boolean mostrarid_asiento_contableNotaCreditoPuntoVenta) {
		this.mostrarid_asiento_contableNotaCreditoPuntoVenta= mostrarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_asiento_contableNotaCreditoPuntoVenta() {
		return this.activarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public void setActivarid_asiento_contableNotaCreditoPuntoVenta(Boolean activarid_asiento_contableNotaCreditoPuntoVenta) {
		this.activarid_asiento_contableNotaCreditoPuntoVenta= activarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_asiento_contableNotaCreditoPuntoVenta() {
		return this.cargarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public void setCargarid_asiento_contableNotaCreditoPuntoVenta(Boolean cargarid_asiento_contableNotaCreditoPuntoVenta) {
		this.cargarid_asiento_contableNotaCreditoPuntoVenta= cargarid_asiento_contableNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_tipo_precioNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioNotaCreditoPuntoVenta() {
		return this.resaltarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public void setResaltarid_tipo_precioNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_precioNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioNotaCreditoPuntoVenta() {
		return this.mostrarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public void setMostrarid_tipo_precioNotaCreditoPuntoVenta(Boolean mostrarid_tipo_precioNotaCreditoPuntoVenta) {
		this.mostrarid_tipo_precioNotaCreditoPuntoVenta= mostrarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_tipo_precioNotaCreditoPuntoVenta() {
		return this.activarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public void setActivarid_tipo_precioNotaCreditoPuntoVenta(Boolean activarid_tipo_precioNotaCreditoPuntoVenta) {
		this.activarid_tipo_precioNotaCreditoPuntoVenta= activarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_tipo_precioNotaCreditoPuntoVenta() {
		return this.cargarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public void setCargarid_tipo_precioNotaCreditoPuntoVenta(Boolean cargarid_tipo_precioNotaCreditoPuntoVenta) {
		this.cargarid_tipo_precioNotaCreditoPuntoVenta= cargarid_tipo_precioNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_mesaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_mesaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesaNotaCreditoPuntoVenta() {
		return this.resaltarid_mesaNotaCreditoPuntoVenta;
	}

	public void setResaltarid_mesaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_mesaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_mesaNotaCreditoPuntoVenta() {
		return this.mostrarid_mesaNotaCreditoPuntoVenta;
	}

	public void setMostrarid_mesaNotaCreditoPuntoVenta(Boolean mostrarid_mesaNotaCreditoPuntoVenta) {
		this.mostrarid_mesaNotaCreditoPuntoVenta= mostrarid_mesaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_mesaNotaCreditoPuntoVenta() {
		return this.activarid_mesaNotaCreditoPuntoVenta;
	}

	public void setActivarid_mesaNotaCreditoPuntoVenta(Boolean activarid_mesaNotaCreditoPuntoVenta) {
		this.activarid_mesaNotaCreditoPuntoVenta= activarid_mesaNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_mesaNotaCreditoPuntoVenta() {
		return this.cargarid_mesaNotaCreditoPuntoVenta;
	}

	public void setCargarid_mesaNotaCreditoPuntoVenta(Boolean cargarid_mesaNotaCreditoPuntoVenta) {
		this.cargarid_mesaNotaCreditoPuntoVenta= cargarid_mesaNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_formatoNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_formatoNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoNotaCreditoPuntoVenta() {
		return this.resaltarid_formatoNotaCreditoPuntoVenta;
	}

	public void setResaltarid_formatoNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_formatoNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_formatoNotaCreditoPuntoVenta() {
		return this.mostrarid_formatoNotaCreditoPuntoVenta;
	}

	public void setMostrarid_formatoNotaCreditoPuntoVenta(Boolean mostrarid_formatoNotaCreditoPuntoVenta) {
		this.mostrarid_formatoNotaCreditoPuntoVenta= mostrarid_formatoNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_formatoNotaCreditoPuntoVenta() {
		return this.activarid_formatoNotaCreditoPuntoVenta;
	}

	public void setActivarid_formatoNotaCreditoPuntoVenta(Boolean activarid_formatoNotaCreditoPuntoVenta) {
		this.activarid_formatoNotaCreditoPuntoVenta= activarid_formatoNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_formatoNotaCreditoPuntoVenta() {
		return this.cargarid_formatoNotaCreditoPuntoVenta;
	}

	public void setCargarid_formatoNotaCreditoPuntoVenta(Boolean cargarid_formatoNotaCreditoPuntoVenta) {
		this.cargarid_formatoNotaCreditoPuntoVenta= cargarid_formatoNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta() {
		return this.resaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setResaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta() {
		return this.mostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setMostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(Boolean mostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta) {
		this.mostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta= mostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta() {
		return this.activarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setActivarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(Boolean activarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta) {
		this.activarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta= activarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta() {
		return this.cargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setCargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(Boolean cargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta) {
		this.cargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta= cargarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta() {
		return this.resaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setResaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta() {
		return this.mostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setMostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(Boolean mostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta) {
		this.mostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta= mostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta() {
		return this.activarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setActivarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(Boolean activarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta) {
		this.activarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta= activarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta() {
		return this.cargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public void setCargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(Boolean cargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta) {
		this.cargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta= cargarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta;
	}

	public Border setResaltarnumero_secuencialNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialNotaCreditoPuntoVenta() {
		return this.resaltarnumero_secuencialNotaCreditoPuntoVenta;
	}

	public void setResaltarnumero_secuencialNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_secuencialNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialNotaCreditoPuntoVenta() {
		return this.mostrarnumero_secuencialNotaCreditoPuntoVenta;
	}

	public void setMostrarnumero_secuencialNotaCreditoPuntoVenta(Boolean mostrarnumero_secuencialNotaCreditoPuntoVenta) {
		this.mostrarnumero_secuencialNotaCreditoPuntoVenta= mostrarnumero_secuencialNotaCreditoPuntoVenta;
	}

	public Boolean getActivarnumero_secuencialNotaCreditoPuntoVenta() {
		return this.activarnumero_secuencialNotaCreditoPuntoVenta;
	}

	public void setActivarnumero_secuencialNotaCreditoPuntoVenta(Boolean activarnumero_secuencialNotaCreditoPuntoVenta) {
		this.activarnumero_secuencialNotaCreditoPuntoVenta= activarnumero_secuencialNotaCreditoPuntoVenta;
	}

	public Border setResaltarcodigo_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteNotaCreditoPuntoVenta() {
		return this.resaltarcodigo_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltarcodigo_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarcodigo_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteNotaCreditoPuntoVenta() {
		return this.mostrarcodigo_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrarcodigo_clienteNotaCreditoPuntoVenta(Boolean mostrarcodigo_clienteNotaCreditoPuntoVenta) {
		this.mostrarcodigo_clienteNotaCreditoPuntoVenta= mostrarcodigo_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivarcodigo_clienteNotaCreditoPuntoVenta() {
		return this.activarcodigo_clienteNotaCreditoPuntoVenta;
	}

	public void setActivarcodigo_clienteNotaCreditoPuntoVenta(Boolean activarcodigo_clienteNotaCreditoPuntoVenta) {
		this.activarcodigo_clienteNotaCreditoPuntoVenta= activarcodigo_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltarnombre_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteNotaCreditoPuntoVenta() {
		return this.resaltarnombre_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltarnombre_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarnombre_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteNotaCreditoPuntoVenta() {
		return this.mostrarnombre_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrarnombre_clienteNotaCreditoPuntoVenta(Boolean mostrarnombre_clienteNotaCreditoPuntoVenta) {
		this.mostrarnombre_clienteNotaCreditoPuntoVenta= mostrarnombre_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivarnombre_clienteNotaCreditoPuntoVenta() {
		return this.activarnombre_clienteNotaCreditoPuntoVenta;
	}

	public void setActivarnombre_clienteNotaCreditoPuntoVenta(Boolean activarnombre_clienteNotaCreditoPuntoVenta) {
		this.activarnombre_clienteNotaCreditoPuntoVenta= activarnombre_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltartarjeta_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartarjeta_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjeta_clienteNotaCreditoPuntoVenta() {
		return this.resaltartarjeta_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltartarjeta_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartarjeta_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartarjeta_clienteNotaCreditoPuntoVenta() {
		return this.mostrartarjeta_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrartarjeta_clienteNotaCreditoPuntoVenta(Boolean mostrartarjeta_clienteNotaCreditoPuntoVenta) {
		this.mostrartarjeta_clienteNotaCreditoPuntoVenta= mostrartarjeta_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivartarjeta_clienteNotaCreditoPuntoVenta() {
		return this.activartarjeta_clienteNotaCreditoPuntoVenta;
	}

	public void setActivartarjeta_clienteNotaCreditoPuntoVenta(Boolean activartarjeta_clienteNotaCreditoPuntoVenta) {
		this.activartarjeta_clienteNotaCreditoPuntoVenta= activartarjeta_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltardireccion_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardireccion_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clienteNotaCreditoPuntoVenta() {
		return this.resaltardireccion_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltardireccion_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltardireccion_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardireccion_clienteNotaCreditoPuntoVenta() {
		return this.mostrardireccion_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrardireccion_clienteNotaCreditoPuntoVenta(Boolean mostrardireccion_clienteNotaCreditoPuntoVenta) {
		this.mostrardireccion_clienteNotaCreditoPuntoVenta= mostrardireccion_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivardireccion_clienteNotaCreditoPuntoVenta() {
		return this.activardireccion_clienteNotaCreditoPuntoVenta;
	}

	public void setActivardireccion_clienteNotaCreditoPuntoVenta(Boolean activardireccion_clienteNotaCreditoPuntoVenta) {
		this.activardireccion_clienteNotaCreditoPuntoVenta= activardireccion_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltartelefono_clienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartelefono_clienteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clienteNotaCreditoPuntoVenta() {
		return this.resaltartelefono_clienteNotaCreditoPuntoVenta;
	}

	public void setResaltartelefono_clienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartelefono_clienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartelefono_clienteNotaCreditoPuntoVenta() {
		return this.mostrartelefono_clienteNotaCreditoPuntoVenta;
	}

	public void setMostrartelefono_clienteNotaCreditoPuntoVenta(Boolean mostrartelefono_clienteNotaCreditoPuntoVenta) {
		this.mostrartelefono_clienteNotaCreditoPuntoVenta= mostrartelefono_clienteNotaCreditoPuntoVenta;
	}

	public Boolean getActivartelefono_clienteNotaCreditoPuntoVenta() {
		return this.activartelefono_clienteNotaCreditoPuntoVenta;
	}

	public void setActivartelefono_clienteNotaCreditoPuntoVenta(Boolean activartelefono_clienteNotaCreditoPuntoVenta) {
		this.activartelefono_clienteNotaCreditoPuntoVenta= activartelefono_clienteNotaCreditoPuntoVenta;
	}

	public Border setResaltarfechaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfechaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaNotaCreditoPuntoVenta() {
		return this.resaltarfechaNotaCreditoPuntoVenta;
	}

	public void setResaltarfechaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarfechaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfechaNotaCreditoPuntoVenta() {
		return this.mostrarfechaNotaCreditoPuntoVenta;
	}

	public void setMostrarfechaNotaCreditoPuntoVenta(Boolean mostrarfechaNotaCreditoPuntoVenta) {
		this.mostrarfechaNotaCreditoPuntoVenta= mostrarfechaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarfechaNotaCreditoPuntoVenta() {
		return this.activarfechaNotaCreditoPuntoVenta;
	}

	public void setActivarfechaNotaCreditoPuntoVenta(Boolean activarfechaNotaCreditoPuntoVenta) {
		this.activarfechaNotaCreditoPuntoVenta= activarfechaNotaCreditoPuntoVenta;
	}

	public Border setResaltarhoraNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarhoraNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraNotaCreditoPuntoVenta() {
		return this.resaltarhoraNotaCreditoPuntoVenta;
	}

	public void setResaltarhoraNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarhoraNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarhoraNotaCreditoPuntoVenta() {
		return this.mostrarhoraNotaCreditoPuntoVenta;
	}

	public void setMostrarhoraNotaCreditoPuntoVenta(Boolean mostrarhoraNotaCreditoPuntoVenta) {
		this.mostrarhoraNotaCreditoPuntoVenta= mostrarhoraNotaCreditoPuntoVenta;
	}

	public Boolean getActivarhoraNotaCreditoPuntoVenta() {
		return this.activarhoraNotaCreditoPuntoVenta;
	}

	public void setActivarhoraNotaCreditoPuntoVenta(Boolean activarhoraNotaCreditoPuntoVenta) {
		this.activarhoraNotaCreditoPuntoVenta= activarhoraNotaCreditoPuntoVenta;
	}

	public Border setResaltartotal_ivaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_ivaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaNotaCreditoPuntoVenta() {
		return this.resaltartotal_ivaNotaCreditoPuntoVenta;
	}

	public void setResaltartotal_ivaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartotal_ivaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_ivaNotaCreditoPuntoVenta() {
		return this.mostrartotal_ivaNotaCreditoPuntoVenta;
	}

	public void setMostrartotal_ivaNotaCreditoPuntoVenta(Boolean mostrartotal_ivaNotaCreditoPuntoVenta) {
		this.mostrartotal_ivaNotaCreditoPuntoVenta= mostrartotal_ivaNotaCreditoPuntoVenta;
	}

	public Boolean getActivartotal_ivaNotaCreditoPuntoVenta() {
		return this.activartotal_ivaNotaCreditoPuntoVenta;
	}

	public void setActivartotal_ivaNotaCreditoPuntoVenta(Boolean activartotal_ivaNotaCreditoPuntoVenta) {
		this.activartotal_ivaNotaCreditoPuntoVenta= activartotal_ivaNotaCreditoPuntoVenta;
	}

	public Border setResaltartotal_sin_ivaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaNotaCreditoPuntoVenta() {
		return this.resaltartotal_sin_ivaNotaCreditoPuntoVenta;
	}

	public void setResaltartotal_sin_ivaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartotal_sin_ivaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaNotaCreditoPuntoVenta() {
		return this.mostrartotal_sin_ivaNotaCreditoPuntoVenta;
	}

	public void setMostrartotal_sin_ivaNotaCreditoPuntoVenta(Boolean mostrartotal_sin_ivaNotaCreditoPuntoVenta) {
		this.mostrartotal_sin_ivaNotaCreditoPuntoVenta= mostrartotal_sin_ivaNotaCreditoPuntoVenta;
	}

	public Boolean getActivartotal_sin_ivaNotaCreditoPuntoVenta() {
		return this.activartotal_sin_ivaNotaCreditoPuntoVenta;
	}

	public void setActivartotal_sin_ivaNotaCreditoPuntoVenta(Boolean activartotal_sin_ivaNotaCreditoPuntoVenta) {
		this.activartotal_sin_ivaNotaCreditoPuntoVenta= activartotal_sin_ivaNotaCreditoPuntoVenta;
	}

	public Border setResaltarivaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaNotaCreditoPuntoVenta() {
		return this.resaltarivaNotaCreditoPuntoVenta;
	}

	public void setResaltarivaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarivaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaNotaCreditoPuntoVenta() {
		return this.mostrarivaNotaCreditoPuntoVenta;
	}

	public void setMostrarivaNotaCreditoPuntoVenta(Boolean mostrarivaNotaCreditoPuntoVenta) {
		this.mostrarivaNotaCreditoPuntoVenta= mostrarivaNotaCreditoPuntoVenta;
	}

	public Boolean getActivarivaNotaCreditoPuntoVenta() {
		return this.activarivaNotaCreditoPuntoVenta;
	}

	public void setActivarivaNotaCreditoPuntoVenta(Boolean activarivaNotaCreditoPuntoVenta) {
		this.activarivaNotaCreditoPuntoVenta= activarivaNotaCreditoPuntoVenta;
	}

	public Border setResaltardescuentoNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoNotaCreditoPuntoVenta() {
		return this.resaltardescuentoNotaCreditoPuntoVenta;
	}

	public void setResaltardescuentoNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoNotaCreditoPuntoVenta() {
		return this.mostrardescuentoNotaCreditoPuntoVenta;
	}

	public void setMostrardescuentoNotaCreditoPuntoVenta(Boolean mostrardescuentoNotaCreditoPuntoVenta) {
		this.mostrardescuentoNotaCreditoPuntoVenta= mostrardescuentoNotaCreditoPuntoVenta;
	}

	public Boolean getActivardescuentoNotaCreditoPuntoVenta() {
		return this.activardescuentoNotaCreditoPuntoVenta;
	}

	public void setActivardescuentoNotaCreditoPuntoVenta(Boolean activardescuentoNotaCreditoPuntoVenta) {
		this.activardescuentoNotaCreditoPuntoVenta= activardescuentoNotaCreditoPuntoVenta;
	}

	public Border setResaltarfinanciamientoNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoNotaCreditoPuntoVenta() {
		return this.resaltarfinanciamientoNotaCreditoPuntoVenta;
	}

	public void setResaltarfinanciamientoNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarfinanciamientoNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoNotaCreditoPuntoVenta() {
		return this.mostrarfinanciamientoNotaCreditoPuntoVenta;
	}

	public void setMostrarfinanciamientoNotaCreditoPuntoVenta(Boolean mostrarfinanciamientoNotaCreditoPuntoVenta) {
		this.mostrarfinanciamientoNotaCreditoPuntoVenta= mostrarfinanciamientoNotaCreditoPuntoVenta;
	}

	public Boolean getActivarfinanciamientoNotaCreditoPuntoVenta() {
		return this.activarfinanciamientoNotaCreditoPuntoVenta;
	}

	public void setActivarfinanciamientoNotaCreditoPuntoVenta(Boolean activarfinanciamientoNotaCreditoPuntoVenta) {
		this.activarfinanciamientoNotaCreditoPuntoVenta= activarfinanciamientoNotaCreditoPuntoVenta;
	}

	public Border setResaltarfleteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfleteNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteNotaCreditoPuntoVenta() {
		return this.resaltarfleteNotaCreditoPuntoVenta;
	}

	public void setResaltarfleteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarfleteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfleteNotaCreditoPuntoVenta() {
		return this.mostrarfleteNotaCreditoPuntoVenta;
	}

	public void setMostrarfleteNotaCreditoPuntoVenta(Boolean mostrarfleteNotaCreditoPuntoVenta) {
		this.mostrarfleteNotaCreditoPuntoVenta= mostrarfleteNotaCreditoPuntoVenta;
	}

	public Boolean getActivarfleteNotaCreditoPuntoVenta() {
		return this.activarfleteNotaCreditoPuntoVenta;
	}

	public void setActivarfleteNotaCreditoPuntoVenta(Boolean activarfleteNotaCreditoPuntoVenta) {
		this.activarfleteNotaCreditoPuntoVenta= activarfleteNotaCreditoPuntoVenta;
	}

	public Border setResaltariceNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariceNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceNotaCreditoPuntoVenta() {
		return this.resaltariceNotaCreditoPuntoVenta;
	}

	public void setResaltariceNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltariceNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariceNotaCreditoPuntoVenta() {
		return this.mostrariceNotaCreditoPuntoVenta;
	}

	public void setMostrariceNotaCreditoPuntoVenta(Boolean mostrariceNotaCreditoPuntoVenta) {
		this.mostrariceNotaCreditoPuntoVenta= mostrariceNotaCreditoPuntoVenta;
	}

	public Boolean getActivariceNotaCreditoPuntoVenta() {
		return this.activariceNotaCreditoPuntoVenta;
	}

	public void setActivariceNotaCreditoPuntoVenta(Boolean activariceNotaCreditoPuntoVenta) {
		this.activariceNotaCreditoPuntoVenta= activariceNotaCreditoPuntoVenta;
	}

	public Border setResaltarotrosNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarotrosNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotrosNotaCreditoPuntoVenta() {
		return this.resaltarotrosNotaCreditoPuntoVenta;
	}

	public void setResaltarotrosNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarotrosNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarotrosNotaCreditoPuntoVenta() {
		return this.mostrarotrosNotaCreditoPuntoVenta;
	}

	public void setMostrarotrosNotaCreditoPuntoVenta(Boolean mostrarotrosNotaCreditoPuntoVenta) {
		this.mostrarotrosNotaCreditoPuntoVenta= mostrarotrosNotaCreditoPuntoVenta;
	}

	public Boolean getActivarotrosNotaCreditoPuntoVenta() {
		return this.activarotrosNotaCreditoPuntoVenta;
	}

	public void setActivarotrosNotaCreditoPuntoVenta(Boolean activarotrosNotaCreditoPuntoVenta) {
		this.activarotrosNotaCreditoPuntoVenta= activarotrosNotaCreditoPuntoVenta;
	}

	public Border setResaltarsub_totalNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalNotaCreditoPuntoVenta() {
		return this.resaltarsub_totalNotaCreditoPuntoVenta;
	}

	public void setResaltarsub_totalNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalNotaCreditoPuntoVenta() {
		return this.mostrarsub_totalNotaCreditoPuntoVenta;
	}

	public void setMostrarsub_totalNotaCreditoPuntoVenta(Boolean mostrarsub_totalNotaCreditoPuntoVenta) {
		this.mostrarsub_totalNotaCreditoPuntoVenta= mostrarsub_totalNotaCreditoPuntoVenta;
	}

	public Boolean getActivarsub_totalNotaCreditoPuntoVenta() {
		return this.activarsub_totalNotaCreditoPuntoVenta;
	}

	public void setActivarsub_totalNotaCreditoPuntoVenta(Boolean activarsub_totalNotaCreditoPuntoVenta) {
		this.activarsub_totalNotaCreditoPuntoVenta= activarsub_totalNotaCreditoPuntoVenta;
	}

	public Border setResaltartotalNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalNotaCreditoPuntoVenta() {
		return this.resaltartotalNotaCreditoPuntoVenta;
	}

	public void setResaltartotalNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartotalNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalNotaCreditoPuntoVenta() {
		return this.mostrartotalNotaCreditoPuntoVenta;
	}

	public void setMostrartotalNotaCreditoPuntoVenta(Boolean mostrartotalNotaCreditoPuntoVenta) {
		this.mostrartotalNotaCreditoPuntoVenta= mostrartotalNotaCreditoPuntoVenta;
	}

	public Boolean getActivartotalNotaCreditoPuntoVenta() {
		return this.activartotalNotaCreditoPuntoVenta;
	}

	public void setActivartotalNotaCreditoPuntoVenta(Boolean activartotalNotaCreditoPuntoVenta) {
		this.activartotalNotaCreditoPuntoVenta= activartotalNotaCreditoPuntoVenta;
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
		
		
		this.setMostraridNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_empresaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_sucursalNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_usuarioNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_vendedorNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_cajaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_asiento_contableNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_tipo_precioNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_mesaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_formatoNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarnumero_secuencialNotaCreditoPuntoVenta(esInicial);
		this.setMostrarcodigo_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrarnombre_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrartarjeta_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrardireccion_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrartelefono_clienteNotaCreditoPuntoVenta(esInicial);
		this.setMostrarfechaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarhoraNotaCreditoPuntoVenta(esInicial);
		this.setMostrartotal_ivaNotaCreditoPuntoVenta(esInicial);
		this.setMostrartotal_sin_ivaNotaCreditoPuntoVenta(esInicial);
		this.setMostrarivaNotaCreditoPuntoVenta(esInicial);
		this.setMostrardescuentoNotaCreditoPuntoVenta(esInicial);
		this.setMostrarfinanciamientoNotaCreditoPuntoVenta(esInicial);
		this.setMostrarfleteNotaCreditoPuntoVenta(esInicial);
		this.setMostrariceNotaCreditoPuntoVenta(esInicial);
		this.setMostrarotrosNotaCreditoPuntoVenta(esInicial);
		this.setMostrarsub_totalNotaCreditoPuntoVenta(esInicial);
		this.setMostrartotalNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setMostrarid_mesaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setMostrarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA)) {
				this.setMostrarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setMostrartarjeta_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.HORA)) {
				this.setMostrarhoraNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FLETE)) {
				this.setMostrarfleteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setMostrariceNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.OTROS)) {
				this.setMostrarotrosNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalNotaCreditoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_empresaNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_sucursalNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_usuarioNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_vendedorNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_cajaNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_asiento_contableNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_tipo_precioNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_mesaNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_formatoNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setActivarnumero_secuencialNotaCreditoPuntoVenta(esInicial);
		this.setActivarcodigo_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivarnombre_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivartarjeta_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivardireccion_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivartelefono_clienteNotaCreditoPuntoVenta(esInicial);
		this.setActivarfechaNotaCreditoPuntoVenta(esInicial);
		this.setActivarhoraNotaCreditoPuntoVenta(esInicial);
		this.setActivartotal_ivaNotaCreditoPuntoVenta(esInicial);
		this.setActivartotal_sin_ivaNotaCreditoPuntoVenta(esInicial);
		this.setActivarivaNotaCreditoPuntoVenta(esInicial);
		this.setActivardescuentoNotaCreditoPuntoVenta(esInicial);
		this.setActivarfinanciamientoNotaCreditoPuntoVenta(esInicial);
		this.setActivarfleteNotaCreditoPuntoVenta(esInicial);
		this.setActivariceNotaCreditoPuntoVenta(esInicial);
		this.setActivarotrosNotaCreditoPuntoVenta(esInicial);
		this.setActivarsub_totalNotaCreditoPuntoVenta(esInicial);
		this.setActivartotalNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setActivarid_mesaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setActivarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA)) {
				this.setActivarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setActivartarjeta_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FECHA)) {
				this.setActivarfechaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.HORA)) {
				this.setActivarhoraNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FLETE)) {
				this.setActivarfleteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setActivariceNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.OTROS)) {
				this.setActivarotrosNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_empresaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_sucursalNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_usuarioNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_vendedorNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_cajaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_asiento_contableNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_tipo_precioNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_mesaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_formatoNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarnumero_secuencialNotaCreditoPuntoVenta(esInicial);
		this.setResaltarcodigo_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltarnombre_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltartarjeta_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltardireccion_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltartelefono_clienteNotaCreditoPuntoVenta(esInicial);
		this.setResaltarfechaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarhoraNotaCreditoPuntoVenta(esInicial);
		this.setResaltartotal_ivaNotaCreditoPuntoVenta(esInicial);
		this.setResaltartotal_sin_ivaNotaCreditoPuntoVenta(esInicial);
		this.setResaltarivaNotaCreditoPuntoVenta(esInicial);
		this.setResaltardescuentoNotaCreditoPuntoVenta(esInicial);
		this.setResaltarfinanciamientoNotaCreditoPuntoVenta(esInicial);
		this.setResaltarfleteNotaCreditoPuntoVenta(esInicial);
		this.setResaltariceNotaCreditoPuntoVenta(esInicial);
		this.setResaltarotrosNotaCreditoPuntoVenta(esInicial);
		this.setResaltarsub_totalNotaCreditoPuntoVenta(esInicial);
		this.setResaltartotalNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setResaltarid_mesaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA)) {
				this.setResaltarid_tipo_factura_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA)) {
				this.setResaltarid_estado_nota_credito_punto_ventaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setResaltartarjeta_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clienteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.HORA)) {
				this.setResaltarhoraNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.FLETE)) {
				this.setResaltarfleteNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltariceNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.OTROS)) {
				this.setResaltarotrosNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalNotaCreditoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta=null;

	public Border getResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.resaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Border borderResaltarDetalleNotaCreditoPuntoVenta) {
		if(borderResaltarDetalleNotaCreditoPuntoVenta!=null) {
			this.resaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta= borderResaltarDetalleNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//notacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarNotaCreditoPuntoVenta.setBorder(borderResaltarDetalleNotaCreditoPuntoVenta);
			
		this.resaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta= borderResaltarDetalleNotaCreditoPuntoVenta;

		 return borderResaltarDetalleNotaCreditoPuntoVenta;
	}



	public Boolean mostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.mostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setMostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Boolean visibilidadResaltarDetalleNotaCreditoPuntoVenta) {
		this.mostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta= visibilidadResaltarDetalleNotaCreditoPuntoVenta;
	}



	public Boolean activarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean gethabilitarResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.activarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setActivarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Boolean habilitarResaltarDetalleNotaCreditoPuntoVenta) {
		this.activarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta= habilitarResaltarDetalleNotaCreditoPuntoVenta;
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

		this.setMostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleNotaCreditoPuntoVenta.class)) {
				this.setMostrarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esAsigna);
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

		this.setActivarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleNotaCreditoPuntoVenta.class)) {
				this.setActivarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleNotaCreditoPuntoVenta.class)) {
				this.setResaltarDetalleNotaCreditoPuntoVentaNotaCreditoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdAsientoContableNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdAsientoContableNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdAsientoContableNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCajaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdCajaNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdCajaNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdCajaNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdClienteNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdClienteNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdClienteNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdEmpresaNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdFormatoNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdFormatoNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdFormatoNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdMesaNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdMesaNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdMesaNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesaNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdSucursalNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoPrecioNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdTipoPrecioNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdTipoPrecioNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdUsuarioNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdUsuarioNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdUsuarioNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdVendedorNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdVendedorNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdVendedorNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorNotaCreditoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdAsientoContableNotaCreditoPuntoVenta() {
		return this.activarFK_IdAsientoContableNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdAsientoContableNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdCajaNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdCajaNotaCreditoPuntoVenta() {
		return this.activarFK_IdCajaNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdCajaNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdCajaNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdClienteNotaCreditoPuntoVenta() {
		return this.activarFK_IdClienteNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdClienteNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdClienteNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaNotaCreditoPuntoVenta() {
		return this.activarFK_IdEmpresaNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.activarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdFormatoNotaCreditoPuntoVenta() {
		return this.activarFK_IdFormatoNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdFormatoNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdMesaNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdMesaNotaCreditoPuntoVenta() {
		return this.activarFK_IdMesaNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdMesaNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdMesaNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalNotaCreditoPuntoVenta() {
		return this.activarFK_IdSucursalNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdSucursalNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta() {
		return this.activarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoPrecioNotaCreditoPuntoVenta() {
		return this.activarFK_IdTipoPrecioNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdTipoPrecioNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdUsuarioNotaCreditoPuntoVenta() {
		return this.activarFK_IdUsuarioNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdUsuarioNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdVendedorNotaCreditoPuntoVenta() {
		return this.activarFK_IdVendedorNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdVendedorNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorNotaCreditoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdAsientoContableNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdAsientoContableNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdAsientoContableNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdCajaNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdCajaNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdCajaNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdCajaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdCajaNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdCajaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdClienteNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdClienteNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdClienteNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdClienteNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdClienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdClienteNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdEmpresaNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoNotaCreditoPuntoVentaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdFormatoNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdFormatoNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdFormatoNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdFormatoNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdMesaNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdMesaNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdMesaNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdMesaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdMesaNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdMesaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdSucursalNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFacturaPuntoVentaNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdTipoPrecioNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdTipoPrecioNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdTipoPrecioNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdUsuarioNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdUsuarioNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdUsuarioNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUsuarioNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdVendedorNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdVendedorNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdVendedorNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdVendedorNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdVendedorNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdVendedorNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoPuntoVentaBeanSwingJInternalFrame notacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorNotaCreditoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}