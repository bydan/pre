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


import com.bydan.erp.puntoventa.util.CajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaParameterGeneral;

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
final public class CajaConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
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
	public static final String SNOMBREOPCION="Caja";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Caja"+CajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaConstantesFunciones.SCHEMA+"_"+CajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaConstantesFunciones.SCHEMA+"_"+CajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaConstantesFunciones.SCHEMA+"_"+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaConstantesFunciones.SCHEMA+"_"+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja";
	public static final String SCLASSWEBTITULO_LOWER="Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Caja";
	public static final String OBJECTNAME="caja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select caja from "+CajaConstantesFunciones.SPERSISTENCENAME+" caja";
	public static String QUERYSELECTNATIVE="select "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".version_row,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_empresa,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_sucursal,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre_equipo,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre_impresora,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_pedido,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_pedido_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".punto_emision,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".establecimiento,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_inicio,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_final,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".esta_activo,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".descripcion,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_factura_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_nota_venta_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencia_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencia_nota_credito_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_pais,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_ciudad,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_zona from "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME;//+" as "+CajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREEQUIPO= "nombre_equipo";
    public static final String NOMBREIMPRESORA= "nombre_impresora";
    public static final String SECUENCIALPEDIDO= "secuencial_pedido";
    public static final String SECUENCIALPEDIDOFORMATO= "secuencial_pedido_formato";
    public static final String PUNTOEMISION= "punto_emision";
    public static final String ESTABLECIMIENTO= "establecimiento";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFINAL= "fecha_final";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
    public static final String SECUENCIALFACTURA= "secuencial_factura";
    public static final String SECUENCIALFACTURAFORMATO= "secuencial_factura_formato";
    public static final String SECUENCIALNOTAVENTA= "secuencial_nota_venta";
    public static final String SECUENCIALNOTAVENTAFORMATO= "secuencial_nota_venta_formato";
    public static final String SECUENCIANOTACREDITO= "secuencia_nota_credito";
    public static final String SECUENCIANOTACREDITOFORMATO= "secuencia_nota_credito_formato";
    public static final String AUTORIZACIONFACTURA= "autorizacion_factura";
    public static final String AUTORIZACIONNOTAVENTA= "autorizacion_nota_venta";
    public static final String AUTORIZACIONNOTACREDITO= "autorizacion_nota_credito";
    public static final String FECHACADUCAFACTURA= "fecha_caduca_factura";
    public static final String FECHACADUCANOTAVENTA= "fecha_caduca_nota_venta";
    public static final String FECHACADUCANOTACREDITO= "fecha_caduca_nota_credito";
    public static final String SERIEFACTURA= "serie_factura";
    public static final String SERIENOTAVENTA= "serie_nota_venta";
    public static final String SERIENOTACREDITO= "serie_nota_credito";
    public static final String SECINICIALFACTURA= "sec_inicial_factura";
    public static final String SECINICIALNOTAVENTA= "sec_inicial_nota_venta";
    public static final String SECINICIALNOTACREDITO= "sec_inicial_nota_credito";
    public static final String SECFINALFACTURA= "sec_final_factura";
    public static final String SECFINALNOTAVENTA= "sec_final_nota_venta";
    public static final String SECFINALNOTACREDITO= "sec_final_nota_credito";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREEQUIPO= "Nombre Equipo";
		public static final String LABEL_NOMBREEQUIPO_LOWER= "Nombre Equipo";
    	public static final String LABEL_NOMBREIMPRESORA= "Nombre Impresora";
		public static final String LABEL_NOMBREIMPRESORA_LOWER= "Nombre Impresora";
    	public static final String LABEL_SECUENCIALPEDIDO= "Secuencial Pedido";
		public static final String LABEL_SECUENCIALPEDIDO_LOWER= "Secuencial Pedido";
    	public static final String LABEL_SECUENCIALPEDIDOFORMATO= "Secuencial Pedido Formato";
		public static final String LABEL_SECUENCIALPEDIDOFORMATO_LOWER= "Secuencial Pedido Formato";
    	public static final String LABEL_PUNTOEMISION= "Punto Emision";
		public static final String LABEL_PUNTOEMISION_LOWER= "Punto Emision";
    	public static final String LABEL_ESTABLECIMIENTO= "Establecimiento";
		public static final String LABEL_ESTABLECIMIENTO_LOWER= "Establecimiento";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFINAL= "Fecha Final";
		public static final String LABEL_FECHAFINAL_LOWER= "Fecha Final";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_SECUENCIALFACTURA= "Secuencial";
		public static final String LABEL_SECUENCIALFACTURA_LOWER= "Secuencial Factura";
    	public static final String LABEL_SECUENCIALFACTURAFORMATO= "Secuencial Formato";
		public static final String LABEL_SECUENCIALFACTURAFORMATO_LOWER= "Secuencial Factura Formato";
    	public static final String LABEL_SECUENCIALNOTAVENTA= "Secuencial ";
		public static final String LABEL_SECUENCIALNOTAVENTA_LOWER= "Secuencial Nota Venta";
    	public static final String LABEL_SECUENCIALNOTAVENTAFORMATO= "Secuencial  Formato ";
		public static final String LABEL_SECUENCIALNOTAVENTAFORMATO_LOWER= "Secuencial Nota Venta Formato";
    	public static final String LABEL_SECUENCIANOTACREDITO= "Secuencial  ";
		public static final String LABEL_SECUENCIANOTACREDITO_LOWER= "Secuencia Nota Credito";
    	public static final String LABEL_SECUENCIANOTACREDITOFORMATO= "Secuencial  Formato  ";
		public static final String LABEL_SECUENCIANOTACREDITOFORMATO_LOWER= "Secuencia Nota Credito Formato";
    	public static final String LABEL_AUTORIZACIONFACTURA= "Autorizacion";
		public static final String LABEL_AUTORIZACIONFACTURA_LOWER= "Autorizacion Factura";
    	public static final String LABEL_AUTORIZACIONNOTAVENTA= "Autorizacion ";
		public static final String LABEL_AUTORIZACIONNOTAVENTA_LOWER= "Autorizacion Nota Venta";
    	public static final String LABEL_AUTORIZACIONNOTACREDITO= "Autorizacion  ";
		public static final String LABEL_AUTORIZACIONNOTACREDITO_LOWER= "Autorizacion Nota Credito";
    	public static final String LABEL_FECHACADUCAFACTURA= "Fecha Caduca";
		public static final String LABEL_FECHACADUCAFACTURA_LOWER= "Fecha Caduca Factura";
    	public static final String LABEL_FECHACADUCANOTAVENTA= "Fecha Caduca ";
		public static final String LABEL_FECHACADUCANOTAVENTA_LOWER= "Fecha Caduca Nota Venta";
    	public static final String LABEL_FECHACADUCANOTACREDITO= "Fecha Caduca  ";
		public static final String LABEL_FECHACADUCANOTACREDITO_LOWER= "Fecha Caduca Nota Credito";
    	public static final String LABEL_SERIEFACTURA= "Serie";
		public static final String LABEL_SERIEFACTURA_LOWER= "Serie Factura";
    	public static final String LABEL_SERIENOTAVENTA= "Serie ";
		public static final String LABEL_SERIENOTAVENTA_LOWER= "Serie Nota Venta";
    	public static final String LABEL_SERIENOTACREDITO= "Serie  ";
		public static final String LABEL_SERIENOTACREDITO_LOWER= "Serie Nota Credito";
    	public static final String LABEL_SECINICIALFACTURA= "Sec Inicial";
		public static final String LABEL_SECINICIALFACTURA_LOWER= "Sec Inicial Factura";
    	public static final String LABEL_SECINICIALNOTAVENTA= "Sec Inicial ";
		public static final String LABEL_SECINICIALNOTAVENTA_LOWER= "Sec Inicial Nota Venta";
    	public static final String LABEL_SECINICIALNOTACREDITO= "Sec Inicial  ";
		public static final String LABEL_SECINICIALNOTACREDITO_LOWER= "Sec Inicial Nota Credito";
    	public static final String LABEL_SECFINALFACTURA= "Sec Final";
		public static final String LABEL_SECFINALFACTURA_LOWER= "Sec Final Factura";
    	public static final String LABEL_SECFINALNOTAVENTA= "Sec Final ";
		public static final String LABEL_SECFINALNOTAVENTA_LOWER= "Sec Final Nota Venta";
    	public static final String LABEL_SECFINALNOTACREDITO= "Sec Final  ";
		public static final String LABEL_SECFINALNOTACREDITO_LOWER= "Sec Final Nota Credito";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EQUIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EQUIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_IMPRESORA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_IMPRESORA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIAL_PEDIDO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_PEDIDO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPUNTO_EMISION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPUNTO_EMISION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXESTABLECIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXESTABLECIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIAL_FACTURA_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_FACTURA_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIAL_NOTA_VENTA_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_NOTA_VENTA_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIA_NOTA_CREDITO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIA_NOTA_CREDITO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION_NOTA_VENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION_NOTA_VENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXSERIE_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE_NOTA_VENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE_NOTA_VENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_INICIAL_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_INICIAL_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_INICIAL_NOTA_VENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_INICIAL_NOTA_VENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_INICIAL_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_INICIAL_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_FINAL_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_FINAL_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_FINAL_NOTA_VENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_FINAL_NOTA_VENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEC_FINAL_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEC_FINAL_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaConstantesFunciones.NOMBRE)) {sLabelColumna=CajaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CajaConstantesFunciones.NOMBREEQUIPO)) {sLabelColumna=CajaConstantesFunciones.LABEL_NOMBREEQUIPO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.NOMBREIMPRESORA)) {sLabelColumna=CajaConstantesFunciones.LABEL_NOMBREIMPRESORA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALPEDIDO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALPEDIDO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALPEDIDOFORMATO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.PUNTOEMISION)) {sLabelColumna=CajaConstantesFunciones.LABEL_PUNTOEMISION;}
		if(sNombreColumna.equals(CajaConstantesFunciones.ESTABLECIMIENTO)) {sLabelColumna=CajaConstantesFunciones.LABEL_ESTABLECIMIENTO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.FECHAINICIO)) {sLabelColumna=CajaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.FECHAFINAL)) {sLabelColumna=CajaConstantesFunciones.LABEL_FECHAFINAL;}
		if(sNombreColumna.equals(CajaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=CajaConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.DESCRIPCION)) {sLabelColumna=CajaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALFACTURAFORMATO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALFACTURAFORMATO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTAFORMATO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIANOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITOFORMATO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.AUTORIZACIONFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_AUTORIZACIONFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.AUTORIZACIONNOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_AUTORIZACIONNOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.AUTORIZACIONNOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_AUTORIZACIONNOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.FECHACADUCAFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_FECHACADUCAFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.FECHACADUCANOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_FECHACADUCANOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.FECHACADUCANOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_FECHACADUCANOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SERIEFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SERIEFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SERIENOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SERIENOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SERIENOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SERIENOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECINICIALFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECINICIALFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECINICIALNOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECINICIALNOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECINICIALNOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECINICIALNOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECFINALFACTURA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECFINALFACTURA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECFINALNOTAVENTA)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECFINALNOTAVENTA;}
		if(sNombreColumna.equals(CajaConstantesFunciones.SECFINALNOTACREDITO)) {sLabelColumna=CajaConstantesFunciones.LABEL_SECFINALNOTACREDITO;}
		if(sNombreColumna.equals(CajaConstantesFunciones.IDPAIS)) {sLabelColumna=CajaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(CajaConstantesFunciones.IDCIUDAD)) {sLabelColumna=CajaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(CajaConstantesFunciones.IDZONA)) {sLabelColumna=CajaConstantesFunciones.LABEL_IDZONA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(Caja caja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!caja.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Caja caja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(caja.getId(),caja.getesta_activo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(caja !=null/* && caja.getId()!=0*/) {
			sDescripcion=caja.getnombre();//cajacaja.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaDescripcionDetallado(Caja caja) {
		String sDescripcion="";
			
		sDescripcion+=CajaConstantesFunciones.ID+"=";
		sDescripcion+=caja.getId().toString()+",";
		sDescripcion+=CajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=caja.getVersionRow().toString()+",";
		sDescripcion+=CajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=caja.getid_empresa().toString()+",";
		sDescripcion+=CajaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=caja.getid_sucursal().toString()+",";
		sDescripcion+=CajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=caja.getnombre()+",";
		sDescripcion+=CajaConstantesFunciones.NOMBREEQUIPO+"=";
		sDescripcion+=caja.getnombre_equipo()+",";
		sDescripcion+=CajaConstantesFunciones.NOMBREIMPRESORA+"=";
		sDescripcion+=caja.getnombre_impresora()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALPEDIDO+"=";
		sDescripcion+=caja.getsecuencial_pedido().toString()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO+"=";
		sDescripcion+=caja.getsecuencial_pedido_formato()+",";
		sDescripcion+=CajaConstantesFunciones.PUNTOEMISION+"=";
		sDescripcion+=caja.getpunto_emision()+",";
		sDescripcion+=CajaConstantesFunciones.ESTABLECIMIENTO+"=";
		sDescripcion+=caja.getestablecimiento()+",";
		sDescripcion+=CajaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=caja.getfecha_inicio().toString()+",";
		sDescripcion+=CajaConstantesFunciones.FECHAFINAL+"=";
		sDescripcion+=caja.getfecha_final().toString()+",";
		sDescripcion+=CajaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=caja.getesta_activo().toString()+",";
		sDescripcion+=CajaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=caja.getdescripcion()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALFACTURA+"=";
		sDescripcion+=caja.getsecuencial_factura().toString()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALFACTURAFORMATO+"=";
		sDescripcion+=caja.getsecuencial_factura_formato()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALNOTAVENTA+"=";
		sDescripcion+=caja.getsecuencial_nota_venta().toString()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO+"=";
		sDescripcion+=caja.getsecuencial_nota_venta_formato()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIANOTACREDITO+"=";
		sDescripcion+=caja.getsecuencia_nota_credito().toString()+",";
		sDescripcion+=CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO+"=";
		sDescripcion+=caja.getsecuencia_nota_credito_formato()+",";
		sDescripcion+=CajaConstantesFunciones.AUTORIZACIONFACTURA+"=";
		sDescripcion+=caja.getautorizacion_factura()+",";
		sDescripcion+=CajaConstantesFunciones.AUTORIZACIONNOTAVENTA+"=";
		sDescripcion+=caja.getautorizacion_nota_venta()+",";
		sDescripcion+=CajaConstantesFunciones.AUTORIZACIONNOTACREDITO+"=";
		sDescripcion+=caja.getautorizacion_nota_credito()+",";
		sDescripcion+=CajaConstantesFunciones.FECHACADUCAFACTURA+"=";
		sDescripcion+=caja.getfecha_caduca_factura().toString()+",";
		sDescripcion+=CajaConstantesFunciones.FECHACADUCANOTAVENTA+"=";
		sDescripcion+=caja.getfecha_caduca_nota_venta().toString()+",";
		sDescripcion+=CajaConstantesFunciones.FECHACADUCANOTACREDITO+"=";
		sDescripcion+=caja.getfecha_caduca_nota_credito().toString()+",";
		sDescripcion+=CajaConstantesFunciones.SERIEFACTURA+"=";
		sDescripcion+=caja.getserie_factura()+",";
		sDescripcion+=CajaConstantesFunciones.SERIENOTAVENTA+"=";
		sDescripcion+=caja.getserie_nota_venta()+",";
		sDescripcion+=CajaConstantesFunciones.SERIENOTACREDITO+"=";
		sDescripcion+=caja.getserie_nota_credito()+",";
		sDescripcion+=CajaConstantesFunciones.SECINICIALFACTURA+"=";
		sDescripcion+=caja.getsec_inicial_factura()+",";
		sDescripcion+=CajaConstantesFunciones.SECINICIALNOTAVENTA+"=";
		sDescripcion+=caja.getsec_inicial_nota_venta()+",";
		sDescripcion+=CajaConstantesFunciones.SECINICIALNOTACREDITO+"=";
		sDescripcion+=caja.getsec_inicial_nota_credito()+",";
		sDescripcion+=CajaConstantesFunciones.SECFINALFACTURA+"=";
		sDescripcion+=caja.getsec_final_factura()+",";
		sDescripcion+=CajaConstantesFunciones.SECFINALNOTAVENTA+"=";
		sDescripcion+=caja.getsec_final_nota_venta()+",";
		sDescripcion+=CajaConstantesFunciones.SECFINALNOTACREDITO+"=";
		sDescripcion+=caja.getsec_final_nota_credito()+",";
		sDescripcion+=CajaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=caja.getid_pais().toString()+",";
		sDescripcion+=CajaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=caja.getid_ciudad().toString()+",";
		sDescripcion+=CajaConstantesFunciones.IDZONA+"=";
		sDescripcion+=caja.getid_zona().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaDescripcion(Caja caja,String sValor) throws Exception {			
		if(caja !=null) {
			caja.setnombre(sValor);;//cajacaja.getnombre().trim();
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

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCaja(Caja caja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		caja.setnombre(caja.getnombre().trim());
		caja.setnombre_equipo(caja.getnombre_equipo().trim());
		caja.setnombre_impresora(caja.getnombre_impresora().trim());
		caja.setsecuencial_pedido_formato(caja.getsecuencial_pedido_formato().trim());
		caja.setpunto_emision(caja.getpunto_emision().trim());
		caja.setestablecimiento(caja.getestablecimiento().trim());
		caja.setdescripcion(caja.getdescripcion().trim());
		caja.setsecuencial_factura_formato(caja.getsecuencial_factura_formato().trim());
		caja.setsecuencial_nota_venta_formato(caja.getsecuencial_nota_venta_formato().trim());
		caja.setsecuencia_nota_credito_formato(caja.getsecuencia_nota_credito_formato().trim());
		caja.setautorizacion_factura(caja.getautorizacion_factura().trim());
		caja.setautorizacion_nota_venta(caja.getautorizacion_nota_venta().trim());
		caja.setautorizacion_nota_credito(caja.getautorizacion_nota_credito().trim());
		caja.setserie_factura(caja.getserie_factura().trim());
		caja.setserie_nota_venta(caja.getserie_nota_venta().trim());
		caja.setserie_nota_credito(caja.getserie_nota_credito().trim());
		caja.setsec_inicial_factura(caja.getsec_inicial_factura().trim());
		caja.setsec_inicial_nota_venta(caja.getsec_inicial_nota_venta().trim());
		caja.setsec_inicial_nota_credito(caja.getsec_inicial_nota_credito().trim());
		caja.setsec_final_factura(caja.getsec_final_factura().trim());
		caja.setsec_final_nota_venta(caja.getsec_final_nota_venta().trim());
		caja.setsec_final_nota_credito(caja.getsec_final_nota_credito().trim());
	}
	
	public static void quitarEspaciosCajas(List<Caja> cajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Caja caja: cajas) {
			caja.setnombre(caja.getnombre().trim());
			caja.setnombre_equipo(caja.getnombre_equipo().trim());
			caja.setnombre_impresora(caja.getnombre_impresora().trim());
			caja.setsecuencial_pedido_formato(caja.getsecuencial_pedido_formato().trim());
			caja.setpunto_emision(caja.getpunto_emision().trim());
			caja.setestablecimiento(caja.getestablecimiento().trim());
			caja.setdescripcion(caja.getdescripcion().trim());
			caja.setsecuencial_factura_formato(caja.getsecuencial_factura_formato().trim());
			caja.setsecuencial_nota_venta_formato(caja.getsecuencial_nota_venta_formato().trim());
			caja.setsecuencia_nota_credito_formato(caja.getsecuencia_nota_credito_formato().trim());
			caja.setautorizacion_factura(caja.getautorizacion_factura().trim());
			caja.setautorizacion_nota_venta(caja.getautorizacion_nota_venta().trim());
			caja.setautorizacion_nota_credito(caja.getautorizacion_nota_credito().trim());
			caja.setserie_factura(caja.getserie_factura().trim());
			caja.setserie_nota_venta(caja.getserie_nota_venta().trim());
			caja.setserie_nota_credito(caja.getserie_nota_credito().trim());
			caja.setsec_inicial_factura(caja.getsec_inicial_factura().trim());
			caja.setsec_inicial_nota_venta(caja.getsec_inicial_nota_venta().trim());
			caja.setsec_inicial_nota_credito(caja.getsec_inicial_nota_credito().trim());
			caja.setsec_final_factura(caja.getsec_final_factura().trim());
			caja.setsec_final_nota_venta(caja.getsec_final_nota_venta().trim());
			caja.setsec_final_nota_credito(caja.getsec_final_nota_credito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCaja(Caja caja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && caja.getConCambioAuxiliar()) {
			caja.setIsDeleted(caja.getIsDeletedAuxiliar());	
			caja.setIsNew(caja.getIsNewAuxiliar());	
			caja.setIsChanged(caja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			caja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			caja.setIsDeletedAuxiliar(false);	
			caja.setIsNewAuxiliar(false);	
			caja.setIsChangedAuxiliar(false);
			
			caja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajas(List<Caja> cajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Caja caja : cajas) {
			if(conAsignarBase && caja.getConCambioAuxiliar()) {
				caja.setIsDeleted(caja.getIsDeletedAuxiliar());	
				caja.setIsNew(caja.getIsNewAuxiliar());	
				caja.setIsChanged(caja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				caja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				caja.setIsDeletedAuxiliar(false);	
				caja.setIsNewAuxiliar(false);	
				caja.setIsChangedAuxiliar(false);
				
				caja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCaja(Caja caja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			caja.setsecuencial_pedido(0L);
			caja.setsecuencial_factura(0L);
			caja.setsecuencial_nota_venta(0L);
			caja.setsecuencia_nota_credito(0L);
		}
	}		
	
	public static void InicializarValoresCajas(List<Caja> cajas,Boolean conEnteros) throws Exception  {
		
		for(Caja caja: cajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				caja.setsecuencial_pedido(0L);
				caja.setsecuencial_factura(0L);
				caja.setsecuencial_nota_venta(0L);
				caja.setsecuencia_nota_credito(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCaja(List<Caja> cajas,Caja cajaAux) throws Exception  {
		CajaConstantesFunciones.InicializarValoresCaja(cajaAux,true);
		
		for(Caja caja: cajas) {
			if(caja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajaAux.setsecuencial_pedido(cajaAux.getsecuencial_pedido()+caja.getsecuencial_pedido());			
			cajaAux.setsecuencial_factura(cajaAux.getsecuencial_factura()+caja.getsecuencial_factura());			
			cajaAux.setsecuencial_nota_venta(cajaAux.getsecuencial_nota_venta()+caja.getsecuencial_nota_venta());			
			cajaAux.setsecuencia_nota_credito(cajaAux.getsecuencia_nota_credito()+caja.getsecuencia_nota_credito());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaConstantesFunciones.getArrayColumnasGlobalesCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Caja> cajas,Caja caja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Caja cajaAux: cajas) {
			if(cajaAux!=null && caja!=null) {
				if((cajaAux.getId()==null && caja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajaAux.getId()!=null && caja.getId()!=null){
					if(cajaAux.getId().equals(caja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCaja(List<Caja> cajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Caja caja: cajas) {			
			if(caja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_ID, CajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_VERSIONROW, CajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_IDEMPRESA, CajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_IDSUCURSAL, CajaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_NOMBRE, CajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_NOMBREEQUIPO, CajaConstantesFunciones.NOMBREEQUIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_NOMBREIMPRESORA, CajaConstantesFunciones.NOMBREIMPRESORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALPEDIDO, CajaConstantesFunciones.SECUENCIALPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALPEDIDOFORMATO, CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_PUNTOEMISION, CajaConstantesFunciones.PUNTOEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_ESTABLECIMIENTO, CajaConstantesFunciones.ESTABLECIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_FECHAINICIO, CajaConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_FECHAFINAL, CajaConstantesFunciones.FECHAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_ESTAACTIVO, CajaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_DESCRIPCION, CajaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALFACTURA, CajaConstantesFunciones.SECUENCIALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALFACTURAFORMATO, CajaConstantesFunciones.SECUENCIALFACTURAFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTA, CajaConstantesFunciones.SECUENCIALNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTAFORMATO, CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITO, CajaConstantesFunciones.SECUENCIANOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITOFORMATO, CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_AUTORIZACIONFACTURA, CajaConstantesFunciones.AUTORIZACIONFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_AUTORIZACIONNOTAVENTA, CajaConstantesFunciones.AUTORIZACIONNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_AUTORIZACIONNOTACREDITO, CajaConstantesFunciones.AUTORIZACIONNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_FECHACADUCAFACTURA, CajaConstantesFunciones.FECHACADUCAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_FECHACADUCANOTAVENTA, CajaConstantesFunciones.FECHACADUCANOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_FECHACADUCANOTACREDITO, CajaConstantesFunciones.FECHACADUCANOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SERIEFACTURA, CajaConstantesFunciones.SERIEFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SERIENOTAVENTA, CajaConstantesFunciones.SERIENOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SERIENOTACREDITO, CajaConstantesFunciones.SERIENOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECINICIALFACTURA, CajaConstantesFunciones.SECINICIALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECINICIALNOTAVENTA, CajaConstantesFunciones.SECINICIALNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECINICIALNOTACREDITO, CajaConstantesFunciones.SECINICIALNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECFINALFACTURA, CajaConstantesFunciones.SECFINALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECFINALNOTAVENTA, CajaConstantesFunciones.SECFINALNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_SECFINALNOTACREDITO, CajaConstantesFunciones.SECFINALNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_IDPAIS, CajaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_IDCIUDAD, CajaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaConstantesFunciones.LABEL_IDZONA, CajaConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.NOMBREEQUIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.NOMBREIMPRESORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.PUNTOEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.ESTABLECIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.FECHAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALFACTURAFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIANOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.AUTORIZACIONFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.AUTORIZACIONNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.AUTORIZACIONNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.FECHACADUCAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.FECHACADUCANOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.FECHACADUCANOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SERIEFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SERIENOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SERIENOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECINICIALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECINICIALNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECINICIALNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECFINALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECFINALNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.SECFINALNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCaja() throws Exception  {
		return CajaConstantesFunciones.getTiposSeleccionarCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCaja(Boolean conFk) throws Exception  {
		return CajaConstantesFunciones.getTiposSeleccionarCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_NOMBREEQUIPO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_NOMBREEQUIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_NOMBREIMPRESORA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_NOMBREIMPRESORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDOFORMATO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_PUNTOEMISION);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_PUNTOEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_ESTABLECIMIENTO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_ESTABLECIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_FECHAFINAL);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_FECHAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALFACTURAFORMATO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALFACTURAFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTAFORMATO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTAFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITOFORMATO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_AUTORIZACIONFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_AUTORIZACIONFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_FECHACADUCAFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_FECHACADUCAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_FECHACADUCANOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_FECHACADUCANOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_FECHACADUCANOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_FECHACADUCANOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SERIEFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SERIEFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SERIENOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SERIENOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SERIENOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SERIENOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECINICIALFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECINICIALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECINICIALNOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECINICIALNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECINICIALNOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECINICIALNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECFINALFACTURA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECFINALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECFINALNOTAVENTA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECFINALNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_SECFINALNOTACREDITO);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_SECFINALNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(CajaConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCaja(Caja cajaAux) throws Exception {
		
			cajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaAux.getEmpresa()));
			cajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaAux.getSucursal()));
			cajaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cajaAux.getPais()));
			cajaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cajaAux.getCiudad()));
			cajaAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(cajaAux.getZona()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCaja(List<Caja> cajasTemp) throws Exception {
		for(Caja cajaAux:cajasTemp) {
			
			cajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaAux.getEmpresa()));
			cajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaAux.getSucursal()));
			cajaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cajaAux.getPais()));
			cajaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cajaAux.getCiudad()));
			cajaAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(cajaAux.getZona()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				
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
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaConstantesFunciones.getClassesRelationshipsOfCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				classes.add(new Classe(CajaCierre.class));
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(CajaEgreso.class));
				classes.add(new Classe(CajeroTurno.class));
				classes.add(new Classe(PresupuestoVentasPunVen.class));
				classes.add(new Classe(PedidoPuntoVenta.class));
				classes.add(new Classe(CajaIngreso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaCierre.class)) {
						classes.add(new Classe(CajaCierre.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaEgreso.class)) {
						classes.add(new Classe(CajaEgreso.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajeroTurno.class)) {
						classes.add(new Classe(CajeroTurno.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentasPunVen.class)) {
						classes.add(new Classe(PresupuestoVentasPunVen.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaIngreso.class)) {
						classes.add(new Classe(CajaIngreso.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaConstantesFunciones.getClassesRelationshipsFromStringsOfCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(CajaCierre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaCierre.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(PresupuestoVentasPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasPunVen.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(CajaCierre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaCierre.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(PresupuestoVentasPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasPunVen.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
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
	public static void actualizarLista(Caja caja,List<Caja> cajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Caja cajaEncontrado=null;
			
			for(Caja cajaLocal:cajas) {
				if(cajaLocal.getId().equals(caja.getId())) {
					cajaEncontrado=cajaLocal;
					
					cajaLocal.setIsChanged(caja.getIsChanged());
					cajaLocal.setIsNew(caja.getIsNew());
					cajaLocal.setIsDeleted(caja.getIsDeleted());
					
					cajaLocal.setGeneralEntityOriginal(caja.getGeneralEntityOriginal());
					
					cajaLocal.setId(caja.getId());	
					cajaLocal.setVersionRow(caja.getVersionRow());	
					cajaLocal.setid_empresa(caja.getid_empresa());	
					cajaLocal.setid_sucursal(caja.getid_sucursal());	
					cajaLocal.setnombre(caja.getnombre());	
					cajaLocal.setnombre_equipo(caja.getnombre_equipo());	
					cajaLocal.setnombre_impresora(caja.getnombre_impresora());	
					cajaLocal.setsecuencial_pedido(caja.getsecuencial_pedido());	
					cajaLocal.setsecuencial_pedido_formato(caja.getsecuencial_pedido_formato());	
					cajaLocal.setpunto_emision(caja.getpunto_emision());	
					cajaLocal.setestablecimiento(caja.getestablecimiento());	
					cajaLocal.setfecha_inicio(caja.getfecha_inicio());	
					cajaLocal.setfecha_final(caja.getfecha_final());	
					cajaLocal.setesta_activo(caja.getesta_activo());	
					cajaLocal.setdescripcion(caja.getdescripcion());	
					cajaLocal.setsecuencial_factura(caja.getsecuencial_factura());	
					cajaLocal.setsecuencial_factura_formato(caja.getsecuencial_factura_formato());	
					cajaLocal.setsecuencial_nota_venta(caja.getsecuencial_nota_venta());	
					cajaLocal.setsecuencial_nota_venta_formato(caja.getsecuencial_nota_venta_formato());	
					cajaLocal.setsecuencia_nota_credito(caja.getsecuencia_nota_credito());	
					cajaLocal.setsecuencia_nota_credito_formato(caja.getsecuencia_nota_credito_formato());	
					cajaLocal.setautorizacion_factura(caja.getautorizacion_factura());	
					cajaLocal.setautorizacion_nota_venta(caja.getautorizacion_nota_venta());	
					cajaLocal.setautorizacion_nota_credito(caja.getautorizacion_nota_credito());	
					cajaLocal.setfecha_caduca_factura(caja.getfecha_caduca_factura());	
					cajaLocal.setfecha_caduca_nota_venta(caja.getfecha_caduca_nota_venta());	
					cajaLocal.setfecha_caduca_nota_credito(caja.getfecha_caduca_nota_credito());	
					cajaLocal.setserie_factura(caja.getserie_factura());	
					cajaLocal.setserie_nota_venta(caja.getserie_nota_venta());	
					cajaLocal.setserie_nota_credito(caja.getserie_nota_credito());	
					cajaLocal.setsec_inicial_factura(caja.getsec_inicial_factura());	
					cajaLocal.setsec_inicial_nota_venta(caja.getsec_inicial_nota_venta());	
					cajaLocal.setsec_inicial_nota_credito(caja.getsec_inicial_nota_credito());	
					cajaLocal.setsec_final_factura(caja.getsec_final_factura());	
					cajaLocal.setsec_final_nota_venta(caja.getsec_final_nota_venta());	
					cajaLocal.setsec_final_nota_credito(caja.getsec_final_nota_credito());	
					cajaLocal.setid_pais(caja.getid_pais());	
					cajaLocal.setid_ciudad(caja.getid_ciudad());	
					cajaLocal.setid_zona(caja.getid_zona());	
					
					
					cajaLocal.setNotaCreditoPuntoVentas(caja.getNotaCreditoPuntoVentas());
					cajaLocal.setCajaCierres(caja.getCajaCierres());
					cajaLocal.setFacturaPuntoVentas(caja.getFacturaPuntoVentas());
					cajaLocal.setCajaEgresos(caja.getCajaEgresos());
					cajaLocal.setCajeroTurnos(caja.getCajeroTurnos());
					cajaLocal.setPresupuestoVentasPunVens(caja.getPresupuestoVentasPunVens());
					cajaLocal.setPedidoPuntoVentas(caja.getPedidoPuntoVentas());
					cajaLocal.setCajaIngresos(caja.getCajaIngresos());
					
					existe=true;
					break;
				}
			}
			
			if(!caja.getIsDeleted()) {
				if(!existe) {
					cajas.add(caja);
				}
			} else {
				if(cajaEncontrado!=null && permiteQuitar)  {
					cajas.remove(cajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Caja caja,List<Caja> cajas) throws Exception {
		try	{			
			for(Caja cajaLocal:cajas) {
				if(cajaLocal.getId().equals(caja.getId())) {
					cajaLocal.setIsSelected(caja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCaja(List<Caja> cajasAux) throws Exception {
		//this.cajasAux=cajasAux;
		
		for(Caja cajaAux:cajasAux) {
			if(cajaAux.getIsChanged()) {
				cajaAux.setIsChanged(false);
			}		
			
			if(cajaAux.getIsNew()) {
				cajaAux.setIsNew(false);
			}	
			
			if(cajaAux.getIsDeleted()) {
				cajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCaja(Caja cajaAux) throws Exception {
		//this.cajaAux=cajaAux;
		
			if(cajaAux.getIsChanged()) {
				cajaAux.setIsChanged(false);
			}		
			
			if(cajaAux.getIsNew()) {
				cajaAux.setIsNew(false);
			}	
			
			if(cajaAux.getIsDeleted()) {
				cajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Caja cajaAsignar,Caja caja) throws Exception {
		cajaAsignar.setId(caja.getId());	
		cajaAsignar.setVersionRow(caja.getVersionRow());	
		cajaAsignar.setid_empresa(caja.getid_empresa());
		cajaAsignar.setempresa_descripcion(caja.getempresa_descripcion());	
		cajaAsignar.setid_sucursal(caja.getid_sucursal());
		cajaAsignar.setsucursal_descripcion(caja.getsucursal_descripcion());	
		cajaAsignar.setnombre(caja.getnombre());	
		cajaAsignar.setnombre_equipo(caja.getnombre_equipo());	
		cajaAsignar.setnombre_impresora(caja.getnombre_impresora());	
		cajaAsignar.setsecuencial_pedido(caja.getsecuencial_pedido());	
		cajaAsignar.setsecuencial_pedido_formato(caja.getsecuencial_pedido_formato());	
		cajaAsignar.setpunto_emision(caja.getpunto_emision());	
		cajaAsignar.setestablecimiento(caja.getestablecimiento());	
		cajaAsignar.setfecha_inicio(caja.getfecha_inicio());	
		cajaAsignar.setfecha_final(caja.getfecha_final());	
		cajaAsignar.setesta_activo(caja.getesta_activo());	
		cajaAsignar.setdescripcion(caja.getdescripcion());	
		cajaAsignar.setsecuencial_factura(caja.getsecuencial_factura());	
		cajaAsignar.setsecuencial_factura_formato(caja.getsecuencial_factura_formato());	
		cajaAsignar.setsecuencial_nota_venta(caja.getsecuencial_nota_venta());	
		cajaAsignar.setsecuencial_nota_venta_formato(caja.getsecuencial_nota_venta_formato());	
		cajaAsignar.setsecuencia_nota_credito(caja.getsecuencia_nota_credito());	
		cajaAsignar.setsecuencia_nota_credito_formato(caja.getsecuencia_nota_credito_formato());	
		cajaAsignar.setautorizacion_factura(caja.getautorizacion_factura());	
		cajaAsignar.setautorizacion_nota_venta(caja.getautorizacion_nota_venta());	
		cajaAsignar.setautorizacion_nota_credito(caja.getautorizacion_nota_credito());	
		cajaAsignar.setfecha_caduca_factura(caja.getfecha_caduca_factura());	
		cajaAsignar.setfecha_caduca_nota_venta(caja.getfecha_caduca_nota_venta());	
		cajaAsignar.setfecha_caduca_nota_credito(caja.getfecha_caduca_nota_credito());	
		cajaAsignar.setserie_factura(caja.getserie_factura());	
		cajaAsignar.setserie_nota_venta(caja.getserie_nota_venta());	
		cajaAsignar.setserie_nota_credito(caja.getserie_nota_credito());	
		cajaAsignar.setsec_inicial_factura(caja.getsec_inicial_factura());	
		cajaAsignar.setsec_inicial_nota_venta(caja.getsec_inicial_nota_venta());	
		cajaAsignar.setsec_inicial_nota_credito(caja.getsec_inicial_nota_credito());	
		cajaAsignar.setsec_final_factura(caja.getsec_final_factura());	
		cajaAsignar.setsec_final_nota_venta(caja.getsec_final_nota_venta());	
		cajaAsignar.setsec_final_nota_credito(caja.getsec_final_nota_credito());	
		cajaAsignar.setid_pais(caja.getid_pais());
		cajaAsignar.setpais_descripcion(caja.getpais_descripcion());	
		cajaAsignar.setid_ciudad(caja.getid_ciudad());
		cajaAsignar.setciudad_descripcion(caja.getciudad_descripcion());	
		cajaAsignar.setid_zona(caja.getid_zona());
		cajaAsignar.setzona_descripcion(caja.getzona_descripcion());	
	}
	
	public static void inicializarCaja(Caja caja) throws Exception {
		try {
				caja.setId(0L);	
					
				caja.setid_empresa(-1L);	
				caja.setid_sucursal(-1L);	
				caja.setnombre("");	
				caja.setnombre_equipo("");	
				caja.setnombre_impresora("");	
				caja.setsecuencial_pedido(0L);	
				caja.setsecuencial_pedido_formato("");	
				caja.setpunto_emision("");	
				caja.setestablecimiento("");	
				caja.setfecha_inicio(new Date());	
				caja.setfecha_final(new Date());	
				caja.setesta_activo(false);	
				caja.setdescripcion("");	
				caja.setsecuencial_factura(0L);	
				caja.setsecuencial_factura_formato("");	
				caja.setsecuencial_nota_venta(0L);	
				caja.setsecuencial_nota_venta_formato("");	
				caja.setsecuencia_nota_credito(0L);	
				caja.setsecuencia_nota_credito_formato("");	
				caja.setautorizacion_factura("");	
				caja.setautorizacion_nota_venta("");	
				caja.setautorizacion_nota_credito("");	
				caja.setfecha_caduca_factura(new Date());	
				caja.setfecha_caduca_nota_venta(new Date());	
				caja.setfecha_caduca_nota_credito(new Date());	
				caja.setserie_factura("");	
				caja.setserie_nota_venta("");	
				caja.setserie_nota_credito("");	
				caja.setsec_inicial_factura("");	
				caja.setsec_inicial_nota_venta("");	
				caja.setsec_inicial_nota_credito("");	
				caja.setsec_final_factura("");	
				caja.setsec_final_nota_venta("");	
				caja.setsec_final_nota_credito("");	
				caja.setid_pais(-1L);	
				caja.setid_ciudad(-1L);	
				caja.setid_zona(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_NOMBREEQUIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_NOMBREIMPRESORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALPEDIDOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_PUNTOEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_ESTABLECIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_FECHAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALFACTURAFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIALNOTAVENTAFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECUENCIANOTACREDITOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_AUTORIZACIONFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_AUTORIZACIONNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_FECHACADUCAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_FECHACADUCANOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_FECHACADUCANOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SERIEFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SERIENOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SERIENOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECINICIALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECINICIALNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECINICIALNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECFINALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECFINALNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_SECFINALNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCaja(String sTipo,Row row,Workbook workbook,Caja caja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getnombre_equipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getnombre_impresora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_pedido_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getpunto_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getestablecimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getfecha_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(caja.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_factura_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencial_nota_venta_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencia_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsecuencia_nota_credito_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getautorizacion_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getautorizacion_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getautorizacion_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getfecha_caduca_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getfecha_caduca_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getfecha_caduca_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getserie_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getserie_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getserie_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_inicial_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_inicial_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_inicial_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_final_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_final_nota_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getsec_final_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(caja.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCaja() {
		return this.sFinalQueryCaja;
	}
	
	public void setsFinalQueryCaja(String sFinalQueryCaja) {
		this.sFinalQueryCaja= sFinalQueryCaja;
	}
	
	public Border resaltarSeleccionarCaja=null;
	
	public Border setResaltarSeleccionarCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCaja() {
		return this.resaltarSeleccionarCaja;
	}
	
	public void setResaltarSeleccionarCaja(Border borderResaltarSeleccionarCaja) {
		this.resaltarSeleccionarCaja= borderResaltarSeleccionarCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCaja=null;
	public Boolean mostraridCaja=true;
	public Boolean activaridCaja=true;

	public Border resaltarid_empresaCaja=null;
	public Boolean mostrarid_empresaCaja=true;
	public Boolean activarid_empresaCaja=true;
	public Boolean cargarid_empresaCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCaja=false;//ConEventDepend=true

	public Border resaltarid_sucursalCaja=null;
	public Boolean mostrarid_sucursalCaja=true;
	public Boolean activarid_sucursalCaja=true;
	public Boolean cargarid_sucursalCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCaja=false;//ConEventDepend=true

	public Border resaltarnombreCaja=null;
	public Boolean mostrarnombreCaja=true;
	public Boolean activarnombreCaja=true;

	public Border resaltarnombre_equipoCaja=null;
	public Boolean mostrarnombre_equipoCaja=true;
	public Boolean activarnombre_equipoCaja=true;

	public Border resaltarnombre_impresoraCaja=null;
	public Boolean mostrarnombre_impresoraCaja=true;
	public Boolean activarnombre_impresoraCaja=true;

	public Border resaltarsecuencial_pedidoCaja=null;
	public Boolean mostrarsecuencial_pedidoCaja=true;
	public Boolean activarsecuencial_pedidoCaja=true;

	public Border resaltarsecuencial_pedido_formatoCaja=null;
	public Boolean mostrarsecuencial_pedido_formatoCaja=true;
	public Boolean activarsecuencial_pedido_formatoCaja=true;

	public Border resaltarpunto_emisionCaja=null;
	public Boolean mostrarpunto_emisionCaja=true;
	public Boolean activarpunto_emisionCaja=true;

	public Border resaltarestablecimientoCaja=null;
	public Boolean mostrarestablecimientoCaja=true;
	public Boolean activarestablecimientoCaja=true;

	public Border resaltarfecha_inicioCaja=null;
	public Boolean mostrarfecha_inicioCaja=true;
	public Boolean activarfecha_inicioCaja=true;

	public Border resaltarfecha_finalCaja=null;
	public Boolean mostrarfecha_finalCaja=true;
	public Boolean activarfecha_finalCaja=true;

	public Border resaltaresta_activoCaja=null;
	public Boolean mostraresta_activoCaja=true;
	public Boolean activaresta_activoCaja=true;

	public Border resaltardescripcionCaja=null;
	public Boolean mostrardescripcionCaja=true;
	public Boolean activardescripcionCaja=true;

	public Border resaltarsecuencial_facturaCaja=null;
	public Boolean mostrarsecuencial_facturaCaja=true;
	public Boolean activarsecuencial_facturaCaja=true;

	public Border resaltarsecuencial_factura_formatoCaja=null;
	public Boolean mostrarsecuencial_factura_formatoCaja=true;
	public Boolean activarsecuencial_factura_formatoCaja=true;

	public Border resaltarsecuencial_nota_ventaCaja=null;
	public Boolean mostrarsecuencial_nota_ventaCaja=true;
	public Boolean activarsecuencial_nota_ventaCaja=true;

	public Border resaltarsecuencial_nota_venta_formatoCaja=null;
	public Boolean mostrarsecuencial_nota_venta_formatoCaja=true;
	public Boolean activarsecuencial_nota_venta_formatoCaja=true;

	public Border resaltarsecuencia_nota_creditoCaja=null;
	public Boolean mostrarsecuencia_nota_creditoCaja=true;
	public Boolean activarsecuencia_nota_creditoCaja=true;

	public Border resaltarsecuencia_nota_credito_formatoCaja=null;
	public Boolean mostrarsecuencia_nota_credito_formatoCaja=true;
	public Boolean activarsecuencia_nota_credito_formatoCaja=true;

	public Border resaltarautorizacion_facturaCaja=null;
	public Boolean mostrarautorizacion_facturaCaja=true;
	public Boolean activarautorizacion_facturaCaja=true;

	public Border resaltarautorizacion_nota_ventaCaja=null;
	public Boolean mostrarautorizacion_nota_ventaCaja=true;
	public Boolean activarautorizacion_nota_ventaCaja=true;

	public Border resaltarautorizacion_nota_creditoCaja=null;
	public Boolean mostrarautorizacion_nota_creditoCaja=true;
	public Boolean activarautorizacion_nota_creditoCaja=true;

	public Border resaltarfecha_caduca_facturaCaja=null;
	public Boolean mostrarfecha_caduca_facturaCaja=true;
	public Boolean activarfecha_caduca_facturaCaja=true;

	public Border resaltarfecha_caduca_nota_ventaCaja=null;
	public Boolean mostrarfecha_caduca_nota_ventaCaja=true;
	public Boolean activarfecha_caduca_nota_ventaCaja=true;

	public Border resaltarfecha_caduca_nota_creditoCaja=null;
	public Boolean mostrarfecha_caduca_nota_creditoCaja=true;
	public Boolean activarfecha_caduca_nota_creditoCaja=true;

	public Border resaltarserie_facturaCaja=null;
	public Boolean mostrarserie_facturaCaja=true;
	public Boolean activarserie_facturaCaja=true;

	public Border resaltarserie_nota_ventaCaja=null;
	public Boolean mostrarserie_nota_ventaCaja=true;
	public Boolean activarserie_nota_ventaCaja=true;

	public Border resaltarserie_nota_creditoCaja=null;
	public Boolean mostrarserie_nota_creditoCaja=true;
	public Boolean activarserie_nota_creditoCaja=true;

	public Border resaltarsec_inicial_facturaCaja=null;
	public Boolean mostrarsec_inicial_facturaCaja=true;
	public Boolean activarsec_inicial_facturaCaja=true;

	public Border resaltarsec_inicial_nota_ventaCaja=null;
	public Boolean mostrarsec_inicial_nota_ventaCaja=true;
	public Boolean activarsec_inicial_nota_ventaCaja=true;

	public Border resaltarsec_inicial_nota_creditoCaja=null;
	public Boolean mostrarsec_inicial_nota_creditoCaja=true;
	public Boolean activarsec_inicial_nota_creditoCaja=true;

	public Border resaltarsec_final_facturaCaja=null;
	public Boolean mostrarsec_final_facturaCaja=true;
	public Boolean activarsec_final_facturaCaja=true;

	public Border resaltarsec_final_nota_ventaCaja=null;
	public Boolean mostrarsec_final_nota_ventaCaja=true;
	public Boolean activarsec_final_nota_ventaCaja=true;

	public Border resaltarsec_final_nota_creditoCaja=null;
	public Boolean mostrarsec_final_nota_creditoCaja=true;
	public Boolean activarsec_final_nota_creditoCaja=true;

	public Border resaltarid_paisCaja=null;
	public Boolean mostrarid_paisCaja=true;
	public Boolean activarid_paisCaja=true;
	public Boolean cargarid_paisCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCaja=false;//ConEventDepend=true

	public Border resaltarid_ciudadCaja=null;
	public Boolean mostrarid_ciudadCaja=true;
	public Boolean activarid_ciudadCaja=true;
	public Boolean cargarid_ciudadCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadCaja=false;//ConEventDepend=true

	public Border resaltarid_zonaCaja=null;
	public Boolean mostrarid_zonaCaja=true;
	public Boolean activarid_zonaCaja=true;
	public Boolean cargarid_zonaCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaCaja=false;//ConEventDepend=true

	
	

	public Border setResaltaridCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltaridCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCaja() {
		return this.resaltaridCaja;
	}

	public void setResaltaridCaja(Border borderResaltar) {
		this.resaltaridCaja= borderResaltar;
	}

	public Boolean getMostraridCaja() {
		return this.mostraridCaja;
	}

	public void setMostraridCaja(Boolean mostraridCaja) {
		this.mostraridCaja= mostraridCaja;
	}

	public Boolean getActivaridCaja() {
		return this.activaridCaja;
	}

	public void setActivaridCaja(Boolean activaridCaja) {
		this.activaridCaja= activaridCaja;
	}

	public Border setResaltarid_empresaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCaja() {
		return this.resaltarid_empresaCaja;
	}

	public void setResaltarid_empresaCaja(Border borderResaltar) {
		this.resaltarid_empresaCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaCaja() {
		return this.mostrarid_empresaCaja;
	}

	public void setMostrarid_empresaCaja(Boolean mostrarid_empresaCaja) {
		this.mostrarid_empresaCaja= mostrarid_empresaCaja;
	}

	public Boolean getActivarid_empresaCaja() {
		return this.activarid_empresaCaja;
	}

	public void setActivarid_empresaCaja(Boolean activarid_empresaCaja) {
		this.activarid_empresaCaja= activarid_empresaCaja;
	}

	public Boolean getCargarid_empresaCaja() {
		return this.cargarid_empresaCaja;
	}

	public void setCargarid_empresaCaja(Boolean cargarid_empresaCaja) {
		this.cargarid_empresaCaja= cargarid_empresaCaja;
	}

	public Border setResaltarid_sucursalCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCaja() {
		return this.resaltarid_sucursalCaja;
	}

	public void setResaltarid_sucursalCaja(Border borderResaltar) {
		this.resaltarid_sucursalCaja= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCaja() {
		return this.mostrarid_sucursalCaja;
	}

	public void setMostrarid_sucursalCaja(Boolean mostrarid_sucursalCaja) {
		this.mostrarid_sucursalCaja= mostrarid_sucursalCaja;
	}

	public Boolean getActivarid_sucursalCaja() {
		return this.activarid_sucursalCaja;
	}

	public void setActivarid_sucursalCaja(Boolean activarid_sucursalCaja) {
		this.activarid_sucursalCaja= activarid_sucursalCaja;
	}

	public Boolean getCargarid_sucursalCaja() {
		return this.cargarid_sucursalCaja;
	}

	public void setCargarid_sucursalCaja(Boolean cargarid_sucursalCaja) {
		this.cargarid_sucursalCaja= cargarid_sucursalCaja;
	}

	public Border setResaltarnombreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarnombreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCaja() {
		return this.resaltarnombreCaja;
	}

	public void setResaltarnombreCaja(Border borderResaltar) {
		this.resaltarnombreCaja= borderResaltar;
	}

	public Boolean getMostrarnombreCaja() {
		return this.mostrarnombreCaja;
	}

	public void setMostrarnombreCaja(Boolean mostrarnombreCaja) {
		this.mostrarnombreCaja= mostrarnombreCaja;
	}

	public Boolean getActivarnombreCaja() {
		return this.activarnombreCaja;
	}

	public void setActivarnombreCaja(Boolean activarnombreCaja) {
		this.activarnombreCaja= activarnombreCaja;
	}

	public Border setResaltarnombre_equipoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_equipoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_equipoCaja() {
		return this.resaltarnombre_equipoCaja;
	}

	public void setResaltarnombre_equipoCaja(Border borderResaltar) {
		this.resaltarnombre_equipoCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_equipoCaja() {
		return this.mostrarnombre_equipoCaja;
	}

	public void setMostrarnombre_equipoCaja(Boolean mostrarnombre_equipoCaja) {
		this.mostrarnombre_equipoCaja= mostrarnombre_equipoCaja;
	}

	public Boolean getActivarnombre_equipoCaja() {
		return this.activarnombre_equipoCaja;
	}

	public void setActivarnombre_equipoCaja(Boolean activarnombre_equipoCaja) {
		this.activarnombre_equipoCaja= activarnombre_equipoCaja;
	}

	public Border setResaltarnombre_impresoraCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_impresoraCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_impresoraCaja() {
		return this.resaltarnombre_impresoraCaja;
	}

	public void setResaltarnombre_impresoraCaja(Border borderResaltar) {
		this.resaltarnombre_impresoraCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_impresoraCaja() {
		return this.mostrarnombre_impresoraCaja;
	}

	public void setMostrarnombre_impresoraCaja(Boolean mostrarnombre_impresoraCaja) {
		this.mostrarnombre_impresoraCaja= mostrarnombre_impresoraCaja;
	}

	public Boolean getActivarnombre_impresoraCaja() {
		return this.activarnombre_impresoraCaja;
	}

	public void setActivarnombre_impresoraCaja(Boolean activarnombre_impresoraCaja) {
		this.activarnombre_impresoraCaja= activarnombre_impresoraCaja;
	}

	public Border setResaltarsecuencial_pedidoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_pedidoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_pedidoCaja() {
		return this.resaltarsecuencial_pedidoCaja;
	}

	public void setResaltarsecuencial_pedidoCaja(Border borderResaltar) {
		this.resaltarsecuencial_pedidoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_pedidoCaja() {
		return this.mostrarsecuencial_pedidoCaja;
	}

	public void setMostrarsecuencial_pedidoCaja(Boolean mostrarsecuencial_pedidoCaja) {
		this.mostrarsecuencial_pedidoCaja= mostrarsecuencial_pedidoCaja;
	}

	public Boolean getActivarsecuencial_pedidoCaja() {
		return this.activarsecuencial_pedidoCaja;
	}

	public void setActivarsecuencial_pedidoCaja(Boolean activarsecuencial_pedidoCaja) {
		this.activarsecuencial_pedidoCaja= activarsecuencial_pedidoCaja;
	}

	public Border setResaltarsecuencial_pedido_formatoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_pedido_formatoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_pedido_formatoCaja() {
		return this.resaltarsecuencial_pedido_formatoCaja;
	}

	public void setResaltarsecuencial_pedido_formatoCaja(Border borderResaltar) {
		this.resaltarsecuencial_pedido_formatoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_pedido_formatoCaja() {
		return this.mostrarsecuencial_pedido_formatoCaja;
	}

	public void setMostrarsecuencial_pedido_formatoCaja(Boolean mostrarsecuencial_pedido_formatoCaja) {
		this.mostrarsecuencial_pedido_formatoCaja= mostrarsecuencial_pedido_formatoCaja;
	}

	public Boolean getActivarsecuencial_pedido_formatoCaja() {
		return this.activarsecuencial_pedido_formatoCaja;
	}

	public void setActivarsecuencial_pedido_formatoCaja(Boolean activarsecuencial_pedido_formatoCaja) {
		this.activarsecuencial_pedido_formatoCaja= activarsecuencial_pedido_formatoCaja;
	}

	public Border setResaltarpunto_emisionCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarpunto_emisionCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpunto_emisionCaja() {
		return this.resaltarpunto_emisionCaja;
	}

	public void setResaltarpunto_emisionCaja(Border borderResaltar) {
		this.resaltarpunto_emisionCaja= borderResaltar;
	}

	public Boolean getMostrarpunto_emisionCaja() {
		return this.mostrarpunto_emisionCaja;
	}

	public void setMostrarpunto_emisionCaja(Boolean mostrarpunto_emisionCaja) {
		this.mostrarpunto_emisionCaja= mostrarpunto_emisionCaja;
	}

	public Boolean getActivarpunto_emisionCaja() {
		return this.activarpunto_emisionCaja;
	}

	public void setActivarpunto_emisionCaja(Boolean activarpunto_emisionCaja) {
		this.activarpunto_emisionCaja= activarpunto_emisionCaja;
	}

	public Border setResaltarestablecimientoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarestablecimientoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestablecimientoCaja() {
		return this.resaltarestablecimientoCaja;
	}

	public void setResaltarestablecimientoCaja(Border borderResaltar) {
		this.resaltarestablecimientoCaja= borderResaltar;
	}

	public Boolean getMostrarestablecimientoCaja() {
		return this.mostrarestablecimientoCaja;
	}

	public void setMostrarestablecimientoCaja(Boolean mostrarestablecimientoCaja) {
		this.mostrarestablecimientoCaja= mostrarestablecimientoCaja;
	}

	public Boolean getActivarestablecimientoCaja() {
		return this.activarestablecimientoCaja;
	}

	public void setActivarestablecimientoCaja(Boolean activarestablecimientoCaja) {
		this.activarestablecimientoCaja= activarestablecimientoCaja;
	}

	public Border setResaltarfecha_inicioCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioCaja() {
		return this.resaltarfecha_inicioCaja;
	}

	public void setResaltarfecha_inicioCaja(Border borderResaltar) {
		this.resaltarfecha_inicioCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioCaja() {
		return this.mostrarfecha_inicioCaja;
	}

	public void setMostrarfecha_inicioCaja(Boolean mostrarfecha_inicioCaja) {
		this.mostrarfecha_inicioCaja= mostrarfecha_inicioCaja;
	}

	public Boolean getActivarfecha_inicioCaja() {
		return this.activarfecha_inicioCaja;
	}

	public void setActivarfecha_inicioCaja(Boolean activarfecha_inicioCaja) {
		this.activarfecha_inicioCaja= activarfecha_inicioCaja;
	}

	public Border setResaltarfecha_finalCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_finalCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalCaja() {
		return this.resaltarfecha_finalCaja;
	}

	public void setResaltarfecha_finalCaja(Border borderResaltar) {
		this.resaltarfecha_finalCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_finalCaja() {
		return this.mostrarfecha_finalCaja;
	}

	public void setMostrarfecha_finalCaja(Boolean mostrarfecha_finalCaja) {
		this.mostrarfecha_finalCaja= mostrarfecha_finalCaja;
	}

	public Boolean getActivarfecha_finalCaja() {
		return this.activarfecha_finalCaja;
	}

	public void setActivarfecha_finalCaja(Boolean activarfecha_finalCaja) {
		this.activarfecha_finalCaja= activarfecha_finalCaja;
	}

	public Border setResaltaresta_activoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltaresta_activoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoCaja() {
		return this.resaltaresta_activoCaja;
	}

	public void setResaltaresta_activoCaja(Border borderResaltar) {
		this.resaltaresta_activoCaja= borderResaltar;
	}

	public Boolean getMostraresta_activoCaja() {
		return this.mostraresta_activoCaja;
	}

	public void setMostraresta_activoCaja(Boolean mostraresta_activoCaja) {
		this.mostraresta_activoCaja= mostraresta_activoCaja;
	}

	public Boolean getActivaresta_activoCaja() {
		return this.activaresta_activoCaja;
	}

	public void setActivaresta_activoCaja(Boolean activaresta_activoCaja) {
		this.activaresta_activoCaja= activaresta_activoCaja;
	}

	public Border setResaltardescripcionCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltardescripcionCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCaja() {
		return this.resaltardescripcionCaja;
	}

	public void setResaltardescripcionCaja(Border borderResaltar) {
		this.resaltardescripcionCaja= borderResaltar;
	}

	public Boolean getMostrardescripcionCaja() {
		return this.mostrardescripcionCaja;
	}

	public void setMostrardescripcionCaja(Boolean mostrardescripcionCaja) {
		this.mostrardescripcionCaja= mostrardescripcionCaja;
	}

	public Boolean getActivardescripcionCaja() {
		return this.activardescripcionCaja;
	}

	public void setActivardescripcionCaja(Boolean activardescripcionCaja) {
		this.activardescripcionCaja= activardescripcionCaja;
	}

	public Border setResaltarsecuencial_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_facturaCaja() {
		return this.resaltarsecuencial_facturaCaja;
	}

	public void setResaltarsecuencial_facturaCaja(Border borderResaltar) {
		this.resaltarsecuencial_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_facturaCaja() {
		return this.mostrarsecuencial_facturaCaja;
	}

	public void setMostrarsecuencial_facturaCaja(Boolean mostrarsecuencial_facturaCaja) {
		this.mostrarsecuencial_facturaCaja= mostrarsecuencial_facturaCaja;
	}

	public Boolean getActivarsecuencial_facturaCaja() {
		return this.activarsecuencial_facturaCaja;
	}

	public void setActivarsecuencial_facturaCaja(Boolean activarsecuencial_facturaCaja) {
		this.activarsecuencial_facturaCaja= activarsecuencial_facturaCaja;
	}

	public Border setResaltarsecuencial_factura_formatoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_factura_formatoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_factura_formatoCaja() {
		return this.resaltarsecuencial_factura_formatoCaja;
	}

	public void setResaltarsecuencial_factura_formatoCaja(Border borderResaltar) {
		this.resaltarsecuencial_factura_formatoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_factura_formatoCaja() {
		return this.mostrarsecuencial_factura_formatoCaja;
	}

	public void setMostrarsecuencial_factura_formatoCaja(Boolean mostrarsecuencial_factura_formatoCaja) {
		this.mostrarsecuencial_factura_formatoCaja= mostrarsecuencial_factura_formatoCaja;
	}

	public Boolean getActivarsecuencial_factura_formatoCaja() {
		return this.activarsecuencial_factura_formatoCaja;
	}

	public void setActivarsecuencial_factura_formatoCaja(Boolean activarsecuencial_factura_formatoCaja) {
		this.activarsecuencial_factura_formatoCaja= activarsecuencial_factura_formatoCaja;
	}

	public Border setResaltarsecuencial_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_nota_ventaCaja() {
		return this.resaltarsecuencial_nota_ventaCaja;
	}

	public void setResaltarsecuencial_nota_ventaCaja(Border borderResaltar) {
		this.resaltarsecuencial_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_nota_ventaCaja() {
		return this.mostrarsecuencial_nota_ventaCaja;
	}

	public void setMostrarsecuencial_nota_ventaCaja(Boolean mostrarsecuencial_nota_ventaCaja) {
		this.mostrarsecuencial_nota_ventaCaja= mostrarsecuencial_nota_ventaCaja;
	}

	public Boolean getActivarsecuencial_nota_ventaCaja() {
		return this.activarsecuencial_nota_ventaCaja;
	}

	public void setActivarsecuencial_nota_ventaCaja(Boolean activarsecuencial_nota_ventaCaja) {
		this.activarsecuencial_nota_ventaCaja= activarsecuencial_nota_ventaCaja;
	}

	public Border setResaltarsecuencial_nota_venta_formatoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencial_nota_venta_formatoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_nota_venta_formatoCaja() {
		return this.resaltarsecuencial_nota_venta_formatoCaja;
	}

	public void setResaltarsecuencial_nota_venta_formatoCaja(Border borderResaltar) {
		this.resaltarsecuencial_nota_venta_formatoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencial_nota_venta_formatoCaja() {
		return this.mostrarsecuencial_nota_venta_formatoCaja;
	}

	public void setMostrarsecuencial_nota_venta_formatoCaja(Boolean mostrarsecuencial_nota_venta_formatoCaja) {
		this.mostrarsecuencial_nota_venta_formatoCaja= mostrarsecuencial_nota_venta_formatoCaja;
	}

	public Boolean getActivarsecuencial_nota_venta_formatoCaja() {
		return this.activarsecuencial_nota_venta_formatoCaja;
	}

	public void setActivarsecuencial_nota_venta_formatoCaja(Boolean activarsecuencial_nota_venta_formatoCaja) {
		this.activarsecuencial_nota_venta_formatoCaja= activarsecuencial_nota_venta_formatoCaja;
	}

	public Border setResaltarsecuencia_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencia_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencia_nota_creditoCaja() {
		return this.resaltarsecuencia_nota_creditoCaja;
	}

	public void setResaltarsecuencia_nota_creditoCaja(Border borderResaltar) {
		this.resaltarsecuencia_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencia_nota_creditoCaja() {
		return this.mostrarsecuencia_nota_creditoCaja;
	}

	public void setMostrarsecuencia_nota_creditoCaja(Boolean mostrarsecuencia_nota_creditoCaja) {
		this.mostrarsecuencia_nota_creditoCaja= mostrarsecuencia_nota_creditoCaja;
	}

	public Boolean getActivarsecuencia_nota_creditoCaja() {
		return this.activarsecuencia_nota_creditoCaja;
	}

	public void setActivarsecuencia_nota_creditoCaja(Boolean activarsecuencia_nota_creditoCaja) {
		this.activarsecuencia_nota_creditoCaja= activarsecuencia_nota_creditoCaja;
	}

	public Border setResaltarsecuencia_nota_credito_formatoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencia_nota_credito_formatoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencia_nota_credito_formatoCaja() {
		return this.resaltarsecuencia_nota_credito_formatoCaja;
	}

	public void setResaltarsecuencia_nota_credito_formatoCaja(Border borderResaltar) {
		this.resaltarsecuencia_nota_credito_formatoCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencia_nota_credito_formatoCaja() {
		return this.mostrarsecuencia_nota_credito_formatoCaja;
	}

	public void setMostrarsecuencia_nota_credito_formatoCaja(Boolean mostrarsecuencia_nota_credito_formatoCaja) {
		this.mostrarsecuencia_nota_credito_formatoCaja= mostrarsecuencia_nota_credito_formatoCaja;
	}

	public Boolean getActivarsecuencia_nota_credito_formatoCaja() {
		return this.activarsecuencia_nota_credito_formatoCaja;
	}

	public void setActivarsecuencia_nota_credito_formatoCaja(Boolean activarsecuencia_nota_credito_formatoCaja) {
		this.activarsecuencia_nota_credito_formatoCaja= activarsecuencia_nota_credito_formatoCaja;
	}

	public Border setResaltarautorizacion_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarautorizacion_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacion_facturaCaja() {
		return this.resaltarautorizacion_facturaCaja;
	}

	public void setResaltarautorizacion_facturaCaja(Border borderResaltar) {
		this.resaltarautorizacion_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarautorizacion_facturaCaja() {
		return this.mostrarautorizacion_facturaCaja;
	}

	public void setMostrarautorizacion_facturaCaja(Boolean mostrarautorizacion_facturaCaja) {
		this.mostrarautorizacion_facturaCaja= mostrarautorizacion_facturaCaja;
	}

	public Boolean getActivarautorizacion_facturaCaja() {
		return this.activarautorizacion_facturaCaja;
	}

	public void setActivarautorizacion_facturaCaja(Boolean activarautorizacion_facturaCaja) {
		this.activarautorizacion_facturaCaja= activarautorizacion_facturaCaja;
	}

	public Border setResaltarautorizacion_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarautorizacion_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacion_nota_ventaCaja() {
		return this.resaltarautorizacion_nota_ventaCaja;
	}

	public void setResaltarautorizacion_nota_ventaCaja(Border borderResaltar) {
		this.resaltarautorizacion_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarautorizacion_nota_ventaCaja() {
		return this.mostrarautorizacion_nota_ventaCaja;
	}

	public void setMostrarautorizacion_nota_ventaCaja(Boolean mostrarautorizacion_nota_ventaCaja) {
		this.mostrarautorizacion_nota_ventaCaja= mostrarautorizacion_nota_ventaCaja;
	}

	public Boolean getActivarautorizacion_nota_ventaCaja() {
		return this.activarautorizacion_nota_ventaCaja;
	}

	public void setActivarautorizacion_nota_ventaCaja(Boolean activarautorizacion_nota_ventaCaja) {
		this.activarautorizacion_nota_ventaCaja= activarautorizacion_nota_ventaCaja;
	}

	public Border setResaltarautorizacion_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarautorizacion_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacion_nota_creditoCaja() {
		return this.resaltarautorizacion_nota_creditoCaja;
	}

	public void setResaltarautorizacion_nota_creditoCaja(Border borderResaltar) {
		this.resaltarautorizacion_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarautorizacion_nota_creditoCaja() {
		return this.mostrarautorizacion_nota_creditoCaja;
	}

	public void setMostrarautorizacion_nota_creditoCaja(Boolean mostrarautorizacion_nota_creditoCaja) {
		this.mostrarautorizacion_nota_creditoCaja= mostrarautorizacion_nota_creditoCaja;
	}

	public Boolean getActivarautorizacion_nota_creditoCaja() {
		return this.activarautorizacion_nota_creditoCaja;
	}

	public void setActivarautorizacion_nota_creditoCaja(Boolean activarautorizacion_nota_creditoCaja) {
		this.activarautorizacion_nota_creditoCaja= activarautorizacion_nota_creditoCaja;
	}

	public Border setResaltarfecha_caduca_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_caduca_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caduca_facturaCaja() {
		return this.resaltarfecha_caduca_facturaCaja;
	}

	public void setResaltarfecha_caduca_facturaCaja(Border borderResaltar) {
		this.resaltarfecha_caduca_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_caduca_facturaCaja() {
		return this.mostrarfecha_caduca_facturaCaja;
	}

	public void setMostrarfecha_caduca_facturaCaja(Boolean mostrarfecha_caduca_facturaCaja) {
		this.mostrarfecha_caduca_facturaCaja= mostrarfecha_caduca_facturaCaja;
	}

	public Boolean getActivarfecha_caduca_facturaCaja() {
		return this.activarfecha_caduca_facturaCaja;
	}

	public void setActivarfecha_caduca_facturaCaja(Boolean activarfecha_caduca_facturaCaja) {
		this.activarfecha_caduca_facturaCaja= activarfecha_caduca_facturaCaja;
	}

	public Border setResaltarfecha_caduca_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_caduca_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caduca_nota_ventaCaja() {
		return this.resaltarfecha_caduca_nota_ventaCaja;
	}

	public void setResaltarfecha_caduca_nota_ventaCaja(Border borderResaltar) {
		this.resaltarfecha_caduca_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_caduca_nota_ventaCaja() {
		return this.mostrarfecha_caduca_nota_ventaCaja;
	}

	public void setMostrarfecha_caduca_nota_ventaCaja(Boolean mostrarfecha_caduca_nota_ventaCaja) {
		this.mostrarfecha_caduca_nota_ventaCaja= mostrarfecha_caduca_nota_ventaCaja;
	}

	public Boolean getActivarfecha_caduca_nota_ventaCaja() {
		return this.activarfecha_caduca_nota_ventaCaja;
	}

	public void setActivarfecha_caduca_nota_ventaCaja(Boolean activarfecha_caduca_nota_ventaCaja) {
		this.activarfecha_caduca_nota_ventaCaja= activarfecha_caduca_nota_ventaCaja;
	}

	public Border setResaltarfecha_caduca_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_caduca_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caduca_nota_creditoCaja() {
		return this.resaltarfecha_caduca_nota_creditoCaja;
	}

	public void setResaltarfecha_caduca_nota_creditoCaja(Border borderResaltar) {
		this.resaltarfecha_caduca_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_caduca_nota_creditoCaja() {
		return this.mostrarfecha_caduca_nota_creditoCaja;
	}

	public void setMostrarfecha_caduca_nota_creditoCaja(Boolean mostrarfecha_caduca_nota_creditoCaja) {
		this.mostrarfecha_caduca_nota_creditoCaja= mostrarfecha_caduca_nota_creditoCaja;
	}

	public Boolean getActivarfecha_caduca_nota_creditoCaja() {
		return this.activarfecha_caduca_nota_creditoCaja;
	}

	public void setActivarfecha_caduca_nota_creditoCaja(Boolean activarfecha_caduca_nota_creditoCaja) {
		this.activarfecha_caduca_nota_creditoCaja= activarfecha_caduca_nota_creditoCaja;
	}

	public Border setResaltarserie_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarserie_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserie_facturaCaja() {
		return this.resaltarserie_facturaCaja;
	}

	public void setResaltarserie_facturaCaja(Border borderResaltar) {
		this.resaltarserie_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarserie_facturaCaja() {
		return this.mostrarserie_facturaCaja;
	}

	public void setMostrarserie_facturaCaja(Boolean mostrarserie_facturaCaja) {
		this.mostrarserie_facturaCaja= mostrarserie_facturaCaja;
	}

	public Boolean getActivarserie_facturaCaja() {
		return this.activarserie_facturaCaja;
	}

	public void setActivarserie_facturaCaja(Boolean activarserie_facturaCaja) {
		this.activarserie_facturaCaja= activarserie_facturaCaja;
	}

	public Border setResaltarserie_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarserie_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserie_nota_ventaCaja() {
		return this.resaltarserie_nota_ventaCaja;
	}

	public void setResaltarserie_nota_ventaCaja(Border borderResaltar) {
		this.resaltarserie_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarserie_nota_ventaCaja() {
		return this.mostrarserie_nota_ventaCaja;
	}

	public void setMostrarserie_nota_ventaCaja(Boolean mostrarserie_nota_ventaCaja) {
		this.mostrarserie_nota_ventaCaja= mostrarserie_nota_ventaCaja;
	}

	public Boolean getActivarserie_nota_ventaCaja() {
		return this.activarserie_nota_ventaCaja;
	}

	public void setActivarserie_nota_ventaCaja(Boolean activarserie_nota_ventaCaja) {
		this.activarserie_nota_ventaCaja= activarserie_nota_ventaCaja;
	}

	public Border setResaltarserie_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarserie_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserie_nota_creditoCaja() {
		return this.resaltarserie_nota_creditoCaja;
	}

	public void setResaltarserie_nota_creditoCaja(Border borderResaltar) {
		this.resaltarserie_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarserie_nota_creditoCaja() {
		return this.mostrarserie_nota_creditoCaja;
	}

	public void setMostrarserie_nota_creditoCaja(Boolean mostrarserie_nota_creditoCaja) {
		this.mostrarserie_nota_creditoCaja= mostrarserie_nota_creditoCaja;
	}

	public Boolean getActivarserie_nota_creditoCaja() {
		return this.activarserie_nota_creditoCaja;
	}

	public void setActivarserie_nota_creditoCaja(Boolean activarserie_nota_creditoCaja) {
		this.activarserie_nota_creditoCaja= activarserie_nota_creditoCaja;
	}

	public Border setResaltarsec_inicial_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_inicial_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_inicial_facturaCaja() {
		return this.resaltarsec_inicial_facturaCaja;
	}

	public void setResaltarsec_inicial_facturaCaja(Border borderResaltar) {
		this.resaltarsec_inicial_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarsec_inicial_facturaCaja() {
		return this.mostrarsec_inicial_facturaCaja;
	}

	public void setMostrarsec_inicial_facturaCaja(Boolean mostrarsec_inicial_facturaCaja) {
		this.mostrarsec_inicial_facturaCaja= mostrarsec_inicial_facturaCaja;
	}

	public Boolean getActivarsec_inicial_facturaCaja() {
		return this.activarsec_inicial_facturaCaja;
	}

	public void setActivarsec_inicial_facturaCaja(Boolean activarsec_inicial_facturaCaja) {
		this.activarsec_inicial_facturaCaja= activarsec_inicial_facturaCaja;
	}

	public Border setResaltarsec_inicial_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_inicial_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_inicial_nota_ventaCaja() {
		return this.resaltarsec_inicial_nota_ventaCaja;
	}

	public void setResaltarsec_inicial_nota_ventaCaja(Border borderResaltar) {
		this.resaltarsec_inicial_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarsec_inicial_nota_ventaCaja() {
		return this.mostrarsec_inicial_nota_ventaCaja;
	}

	public void setMostrarsec_inicial_nota_ventaCaja(Boolean mostrarsec_inicial_nota_ventaCaja) {
		this.mostrarsec_inicial_nota_ventaCaja= mostrarsec_inicial_nota_ventaCaja;
	}

	public Boolean getActivarsec_inicial_nota_ventaCaja() {
		return this.activarsec_inicial_nota_ventaCaja;
	}

	public void setActivarsec_inicial_nota_ventaCaja(Boolean activarsec_inicial_nota_ventaCaja) {
		this.activarsec_inicial_nota_ventaCaja= activarsec_inicial_nota_ventaCaja;
	}

	public Border setResaltarsec_inicial_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_inicial_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_inicial_nota_creditoCaja() {
		return this.resaltarsec_inicial_nota_creditoCaja;
	}

	public void setResaltarsec_inicial_nota_creditoCaja(Border borderResaltar) {
		this.resaltarsec_inicial_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarsec_inicial_nota_creditoCaja() {
		return this.mostrarsec_inicial_nota_creditoCaja;
	}

	public void setMostrarsec_inicial_nota_creditoCaja(Boolean mostrarsec_inicial_nota_creditoCaja) {
		this.mostrarsec_inicial_nota_creditoCaja= mostrarsec_inicial_nota_creditoCaja;
	}

	public Boolean getActivarsec_inicial_nota_creditoCaja() {
		return this.activarsec_inicial_nota_creditoCaja;
	}

	public void setActivarsec_inicial_nota_creditoCaja(Boolean activarsec_inicial_nota_creditoCaja) {
		this.activarsec_inicial_nota_creditoCaja= activarsec_inicial_nota_creditoCaja;
	}

	public Border setResaltarsec_final_facturaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_final_facturaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_final_facturaCaja() {
		return this.resaltarsec_final_facturaCaja;
	}

	public void setResaltarsec_final_facturaCaja(Border borderResaltar) {
		this.resaltarsec_final_facturaCaja= borderResaltar;
	}

	public Boolean getMostrarsec_final_facturaCaja() {
		return this.mostrarsec_final_facturaCaja;
	}

	public void setMostrarsec_final_facturaCaja(Boolean mostrarsec_final_facturaCaja) {
		this.mostrarsec_final_facturaCaja= mostrarsec_final_facturaCaja;
	}

	public Boolean getActivarsec_final_facturaCaja() {
		return this.activarsec_final_facturaCaja;
	}

	public void setActivarsec_final_facturaCaja(Boolean activarsec_final_facturaCaja) {
		this.activarsec_final_facturaCaja= activarsec_final_facturaCaja;
	}

	public Border setResaltarsec_final_nota_ventaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_final_nota_ventaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_final_nota_ventaCaja() {
		return this.resaltarsec_final_nota_ventaCaja;
	}

	public void setResaltarsec_final_nota_ventaCaja(Border borderResaltar) {
		this.resaltarsec_final_nota_ventaCaja= borderResaltar;
	}

	public Boolean getMostrarsec_final_nota_ventaCaja() {
		return this.mostrarsec_final_nota_ventaCaja;
	}

	public void setMostrarsec_final_nota_ventaCaja(Boolean mostrarsec_final_nota_ventaCaja) {
		this.mostrarsec_final_nota_ventaCaja= mostrarsec_final_nota_ventaCaja;
	}

	public Boolean getActivarsec_final_nota_ventaCaja() {
		return this.activarsec_final_nota_ventaCaja;
	}

	public void setActivarsec_final_nota_ventaCaja(Boolean activarsec_final_nota_ventaCaja) {
		this.activarsec_final_nota_ventaCaja= activarsec_final_nota_ventaCaja;
	}

	public Border setResaltarsec_final_nota_creditoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarsec_final_nota_creditoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsec_final_nota_creditoCaja() {
		return this.resaltarsec_final_nota_creditoCaja;
	}

	public void setResaltarsec_final_nota_creditoCaja(Border borderResaltar) {
		this.resaltarsec_final_nota_creditoCaja= borderResaltar;
	}

	public Boolean getMostrarsec_final_nota_creditoCaja() {
		return this.mostrarsec_final_nota_creditoCaja;
	}

	public void setMostrarsec_final_nota_creditoCaja(Boolean mostrarsec_final_nota_creditoCaja) {
		this.mostrarsec_final_nota_creditoCaja= mostrarsec_final_nota_creditoCaja;
	}

	public Boolean getActivarsec_final_nota_creditoCaja() {
		return this.activarsec_final_nota_creditoCaja;
	}

	public void setActivarsec_final_nota_creditoCaja(Boolean activarsec_final_nota_creditoCaja) {
		this.activarsec_final_nota_creditoCaja= activarsec_final_nota_creditoCaja;
	}

	public Border setResaltarid_paisCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarid_paisCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCaja() {
		return this.resaltarid_paisCaja;
	}

	public void setResaltarid_paisCaja(Border borderResaltar) {
		this.resaltarid_paisCaja= borderResaltar;
	}

	public Boolean getMostrarid_paisCaja() {
		return this.mostrarid_paisCaja;
	}

	public void setMostrarid_paisCaja(Boolean mostrarid_paisCaja) {
		this.mostrarid_paisCaja= mostrarid_paisCaja;
	}

	public Boolean getActivarid_paisCaja() {
		return this.activarid_paisCaja;
	}

	public void setActivarid_paisCaja(Boolean activarid_paisCaja) {
		this.activarid_paisCaja= activarid_paisCaja;
	}

	public Boolean getCargarid_paisCaja() {
		return this.cargarid_paisCaja;
	}

	public void setCargarid_paisCaja(Boolean cargarid_paisCaja) {
		this.cargarid_paisCaja= cargarid_paisCaja;
	}

	public Border setResaltarid_ciudadCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarid_ciudadCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadCaja() {
		return this.resaltarid_ciudadCaja;
	}

	public void setResaltarid_ciudadCaja(Border borderResaltar) {
		this.resaltarid_ciudadCaja= borderResaltar;
	}

	public Boolean getMostrarid_ciudadCaja() {
		return this.mostrarid_ciudadCaja;
	}

	public void setMostrarid_ciudadCaja(Boolean mostrarid_ciudadCaja) {
		this.mostrarid_ciudadCaja= mostrarid_ciudadCaja;
	}

	public Boolean getActivarid_ciudadCaja() {
		return this.activarid_ciudadCaja;
	}

	public void setActivarid_ciudadCaja(Boolean activarid_ciudadCaja) {
		this.activarid_ciudadCaja= activarid_ciudadCaja;
	}

	public Boolean getCargarid_ciudadCaja() {
		return this.cargarid_ciudadCaja;
	}

	public void setCargarid_ciudadCaja(Boolean cargarid_ciudadCaja) {
		this.cargarid_ciudadCaja= cargarid_ciudadCaja;
	}

	public Border setResaltarid_zonaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltar);
		
		this.resaltarid_zonaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaCaja() {
		return this.resaltarid_zonaCaja;
	}

	public void setResaltarid_zonaCaja(Border borderResaltar) {
		this.resaltarid_zonaCaja= borderResaltar;
	}

	public Boolean getMostrarid_zonaCaja() {
		return this.mostrarid_zonaCaja;
	}

	public void setMostrarid_zonaCaja(Boolean mostrarid_zonaCaja) {
		this.mostrarid_zonaCaja= mostrarid_zonaCaja;
	}

	public Boolean getActivarid_zonaCaja() {
		return this.activarid_zonaCaja;
	}

	public void setActivarid_zonaCaja(Boolean activarid_zonaCaja) {
		this.activarid_zonaCaja= activarid_zonaCaja;
	}

	public Boolean getCargarid_zonaCaja() {
		return this.cargarid_zonaCaja;
	}

	public void setCargarid_zonaCaja(Boolean cargarid_zonaCaja) {
		this.cargarid_zonaCaja= cargarid_zonaCaja;
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
		
		
		this.setMostraridCaja(esInicial);
		this.setMostrarid_empresaCaja(esInicial);
		this.setMostrarid_sucursalCaja(esInicial);
		this.setMostrarnombreCaja(esInicial);
		this.setMostrarnombre_equipoCaja(esInicial);
		this.setMostrarnombre_impresoraCaja(esInicial);
		this.setMostrarsecuencial_pedidoCaja(esInicial);
		this.setMostrarsecuencial_pedido_formatoCaja(esInicial);
		this.setMostrarpunto_emisionCaja(esInicial);
		this.setMostrarestablecimientoCaja(esInicial);
		this.setMostrarfecha_inicioCaja(esInicial);
		this.setMostrarfecha_finalCaja(esInicial);
		this.setMostraresta_activoCaja(esInicial);
		this.setMostrardescripcionCaja(esInicial);
		this.setMostrarsecuencial_facturaCaja(esInicial);
		this.setMostrarsecuencial_factura_formatoCaja(esInicial);
		this.setMostrarsecuencial_nota_ventaCaja(esInicial);
		this.setMostrarsecuencial_nota_venta_formatoCaja(esInicial);
		this.setMostrarsecuencia_nota_creditoCaja(esInicial);
		this.setMostrarsecuencia_nota_credito_formatoCaja(esInicial);
		this.setMostrarautorizacion_facturaCaja(esInicial);
		this.setMostrarautorizacion_nota_ventaCaja(esInicial);
		this.setMostrarautorizacion_nota_creditoCaja(esInicial);
		this.setMostrarfecha_caduca_facturaCaja(esInicial);
		this.setMostrarfecha_caduca_nota_ventaCaja(esInicial);
		this.setMostrarfecha_caduca_nota_creditoCaja(esInicial);
		this.setMostrarserie_facturaCaja(esInicial);
		this.setMostrarserie_nota_ventaCaja(esInicial);
		this.setMostrarserie_nota_creditoCaja(esInicial);
		this.setMostrarsec_inicial_facturaCaja(esInicial);
		this.setMostrarsec_inicial_nota_ventaCaja(esInicial);
		this.setMostrarsec_inicial_nota_creditoCaja(esInicial);
		this.setMostrarsec_final_facturaCaja(esInicial);
		this.setMostrarsec_final_nota_ventaCaja(esInicial);
		this.setMostrarsec_final_nota_creditoCaja(esInicial);
		this.setMostrarid_paisCaja(esInicial);
		this.setMostrarid_ciudadCaja(esInicial);
		this.setMostrarid_zonaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaConstantesFunciones.ID)) {
				this.setMostraridCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREEQUIPO)) {
				this.setMostrarnombre_equipoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREIMPRESORA)) {
				this.setMostrarnombre_impresoraCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setMostrarsecuencial_pedidoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO)) {
				this.setMostrarsecuencial_pedido_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.PUNTOEMISION)) {
				this.setMostrarpunto_emisionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTABLECIMIENTO)) {
				this.setMostrarestablecimientoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAFINAL)) {
				this.setMostrarfecha_finalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURA)) {
				this.setMostrarsecuencial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURAFORMATO)) {
				this.setMostrarsecuencial_factura_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTA)) {
				this.setMostrarsecuencial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO)) {
				this.setMostrarsecuencial_nota_venta_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITO)) {
				this.setMostrarsecuencia_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO)) {
				this.setMostrarsecuencia_nota_credito_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONFACTURA)) {
				this.setMostrarautorizacion_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTAVENTA)) {
				this.setMostrarautorizacion_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTACREDITO)) {
				this.setMostrarautorizacion_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCAFACTURA)) {
				this.setMostrarfecha_caduca_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTAVENTA)) {
				this.setMostrarfecha_caduca_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTACREDITO)) {
				this.setMostrarfecha_caduca_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIEFACTURA)) {
				this.setMostrarserie_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTAVENTA)) {
				this.setMostrarserie_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTACREDITO)) {
				this.setMostrarserie_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALFACTURA)) {
				this.setMostrarsec_inicial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTAVENTA)) {
				this.setMostrarsec_inicial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTACREDITO)) {
				this.setMostrarsec_inicial_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALFACTURA)) {
				this.setMostrarsec_final_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTAVENTA)) {
				this.setMostrarsec_final_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTACREDITO)) {
				this.setMostrarsec_final_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaCaja(esAsigna);
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
		
		
		this.setActivaridCaja(esInicial);
		this.setActivarid_empresaCaja(esInicial);
		this.setActivarid_sucursalCaja(esInicial);
		this.setActivarnombreCaja(esInicial);
		this.setActivarnombre_equipoCaja(esInicial);
		this.setActivarnombre_impresoraCaja(esInicial);
		this.setActivarsecuencial_pedidoCaja(esInicial);
		this.setActivarsecuencial_pedido_formatoCaja(esInicial);
		this.setActivarpunto_emisionCaja(esInicial);
		this.setActivarestablecimientoCaja(esInicial);
		this.setActivarfecha_inicioCaja(esInicial);
		this.setActivarfecha_finalCaja(esInicial);
		this.setActivaresta_activoCaja(esInicial);
		this.setActivardescripcionCaja(esInicial);
		this.setActivarsecuencial_facturaCaja(esInicial);
		this.setActivarsecuencial_factura_formatoCaja(esInicial);
		this.setActivarsecuencial_nota_ventaCaja(esInicial);
		this.setActivarsecuencial_nota_venta_formatoCaja(esInicial);
		this.setActivarsecuencia_nota_creditoCaja(esInicial);
		this.setActivarsecuencia_nota_credito_formatoCaja(esInicial);
		this.setActivarautorizacion_facturaCaja(esInicial);
		this.setActivarautorizacion_nota_ventaCaja(esInicial);
		this.setActivarautorizacion_nota_creditoCaja(esInicial);
		this.setActivarfecha_caduca_facturaCaja(esInicial);
		this.setActivarfecha_caduca_nota_ventaCaja(esInicial);
		this.setActivarfecha_caduca_nota_creditoCaja(esInicial);
		this.setActivarserie_facturaCaja(esInicial);
		this.setActivarserie_nota_ventaCaja(esInicial);
		this.setActivarserie_nota_creditoCaja(esInicial);
		this.setActivarsec_inicial_facturaCaja(esInicial);
		this.setActivarsec_inicial_nota_ventaCaja(esInicial);
		this.setActivarsec_inicial_nota_creditoCaja(esInicial);
		this.setActivarsec_final_facturaCaja(esInicial);
		this.setActivarsec_final_nota_ventaCaja(esInicial);
		this.setActivarsec_final_nota_creditoCaja(esInicial);
		this.setActivarid_paisCaja(esInicial);
		this.setActivarid_ciudadCaja(esInicial);
		this.setActivarid_zonaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaConstantesFunciones.ID)) {
				this.setActivaridCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREEQUIPO)) {
				this.setActivarnombre_equipoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREIMPRESORA)) {
				this.setActivarnombre_impresoraCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setActivarsecuencial_pedidoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO)) {
				this.setActivarsecuencial_pedido_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.PUNTOEMISION)) {
				this.setActivarpunto_emisionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTABLECIMIENTO)) {
				this.setActivarestablecimientoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAFINAL)) {
				this.setActivarfecha_finalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURA)) {
				this.setActivarsecuencial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURAFORMATO)) {
				this.setActivarsecuencial_factura_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTA)) {
				this.setActivarsecuencial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO)) {
				this.setActivarsecuencial_nota_venta_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITO)) {
				this.setActivarsecuencia_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO)) {
				this.setActivarsecuencia_nota_credito_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONFACTURA)) {
				this.setActivarautorizacion_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTAVENTA)) {
				this.setActivarautorizacion_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTACREDITO)) {
				this.setActivarautorizacion_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCAFACTURA)) {
				this.setActivarfecha_caduca_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTAVENTA)) {
				this.setActivarfecha_caduca_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTACREDITO)) {
				this.setActivarfecha_caduca_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIEFACTURA)) {
				this.setActivarserie_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTAVENTA)) {
				this.setActivarserie_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTACREDITO)) {
				this.setActivarserie_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALFACTURA)) {
				this.setActivarsec_inicial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTAVENTA)) {
				this.setActivarsec_inicial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTACREDITO)) {
				this.setActivarsec_inicial_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALFACTURA)) {
				this.setActivarsec_final_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTAVENTA)) {
				this.setActivarsec_final_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTACREDITO)) {
				this.setActivarsec_final_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCaja(esInicial);
		this.setResaltarid_empresaCaja(esInicial);
		this.setResaltarid_sucursalCaja(esInicial);
		this.setResaltarnombreCaja(esInicial);
		this.setResaltarnombre_equipoCaja(esInicial);
		this.setResaltarnombre_impresoraCaja(esInicial);
		this.setResaltarsecuencial_pedidoCaja(esInicial);
		this.setResaltarsecuencial_pedido_formatoCaja(esInicial);
		this.setResaltarpunto_emisionCaja(esInicial);
		this.setResaltarestablecimientoCaja(esInicial);
		this.setResaltarfecha_inicioCaja(esInicial);
		this.setResaltarfecha_finalCaja(esInicial);
		this.setResaltaresta_activoCaja(esInicial);
		this.setResaltardescripcionCaja(esInicial);
		this.setResaltarsecuencial_facturaCaja(esInicial);
		this.setResaltarsecuencial_factura_formatoCaja(esInicial);
		this.setResaltarsecuencial_nota_ventaCaja(esInicial);
		this.setResaltarsecuencial_nota_venta_formatoCaja(esInicial);
		this.setResaltarsecuencia_nota_creditoCaja(esInicial);
		this.setResaltarsecuencia_nota_credito_formatoCaja(esInicial);
		this.setResaltarautorizacion_facturaCaja(esInicial);
		this.setResaltarautorizacion_nota_ventaCaja(esInicial);
		this.setResaltarautorizacion_nota_creditoCaja(esInicial);
		this.setResaltarfecha_caduca_facturaCaja(esInicial);
		this.setResaltarfecha_caduca_nota_ventaCaja(esInicial);
		this.setResaltarfecha_caduca_nota_creditoCaja(esInicial);
		this.setResaltarserie_facturaCaja(esInicial);
		this.setResaltarserie_nota_ventaCaja(esInicial);
		this.setResaltarserie_nota_creditoCaja(esInicial);
		this.setResaltarsec_inicial_facturaCaja(esInicial);
		this.setResaltarsec_inicial_nota_ventaCaja(esInicial);
		this.setResaltarsec_inicial_nota_creditoCaja(esInicial);
		this.setResaltarsec_final_facturaCaja(esInicial);
		this.setResaltarsec_final_nota_ventaCaja(esInicial);
		this.setResaltarsec_final_nota_creditoCaja(esInicial);
		this.setResaltarid_paisCaja(esInicial);
		this.setResaltarid_ciudadCaja(esInicial);
		this.setResaltarid_zonaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaConstantesFunciones.ID)) {
				this.setResaltaridCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREEQUIPO)) {
				this.setResaltarnombre_equipoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.NOMBREIMPRESORA)) {
				this.setResaltarnombre_impresoraCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setResaltarsecuencial_pedidoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO)) {
				this.setResaltarsecuencial_pedido_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.PUNTOEMISION)) {
				this.setResaltarpunto_emisionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTABLECIMIENTO)) {
				this.setResaltarestablecimientoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHAFINAL)) {
				this.setResaltarfecha_finalCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURA)) {
				this.setResaltarsecuencial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALFACTURAFORMATO)) {
				this.setResaltarsecuencial_factura_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTA)) {
				this.setResaltarsecuencial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO)) {
				this.setResaltarsecuencial_nota_venta_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITO)) {
				this.setResaltarsecuencia_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO)) {
				this.setResaltarsecuencia_nota_credito_formatoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONFACTURA)) {
				this.setResaltarautorizacion_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTAVENTA)) {
				this.setResaltarautorizacion_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.AUTORIZACIONNOTACREDITO)) {
				this.setResaltarautorizacion_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCAFACTURA)) {
				this.setResaltarfecha_caduca_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTAVENTA)) {
				this.setResaltarfecha_caduca_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.FECHACADUCANOTACREDITO)) {
				this.setResaltarfecha_caduca_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIEFACTURA)) {
				this.setResaltarserie_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTAVENTA)) {
				this.setResaltarserie_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SERIENOTACREDITO)) {
				this.setResaltarserie_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALFACTURA)) {
				this.setResaltarsec_inicial_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTAVENTA)) {
				this.setResaltarsec_inicial_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECINICIALNOTACREDITO)) {
				this.setResaltarsec_inicial_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALFACTURA)) {
				this.setResaltarsec_final_facturaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTAVENTA)) {
				this.setResaltarsec_final_nota_ventaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.SECFINALNOTACREDITO)) {
				this.setResaltarsec_final_nota_creditoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaCaja(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNotaCreditoPuntoVentaCaja=null;

	public Border getResaltarNotaCreditoPuntoVentaCaja() {
		return this.resaltarNotaCreditoPuntoVentaCaja;
	}

	public void setResaltarNotaCreditoPuntoVentaCaja(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaCaja= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaCaja= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaCaja=true;

	public Boolean getMostrarNotaCreditoPuntoVentaCaja() {
		return this.mostrarNotaCreditoPuntoVentaCaja;
	}

	public void setMostrarNotaCreditoPuntoVentaCaja(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaCaja= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaCaja=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaCaja() {
		return this.activarNotaCreditoPuntoVentaCaja;
	}

	public void setActivarNotaCreditoPuntoVentaCaja(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaCaja= habilitarResaltarNotaCreditoPuntoVenta;
	}


	public Border resaltarCajaCierreCaja=null;

	public Border getResaltarCajaCierreCaja() {
		return this.resaltarCajaCierreCaja;
	}

	public void setResaltarCajaCierreCaja(Border borderResaltarCajaCierre) {
		if(borderResaltarCajaCierre!=null) {
			this.resaltarCajaCierreCaja= borderResaltarCajaCierre;
		}
	}

	public Border setResaltarCajaCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaCierre=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarCajaCierre);
			
		this.resaltarCajaCierreCaja= borderResaltarCajaCierre;

		 return borderResaltarCajaCierre;
	}



	public Boolean mostrarCajaCierreCaja=true;

	public Boolean getMostrarCajaCierreCaja() {
		return this.mostrarCajaCierreCaja;
	}

	public void setMostrarCajaCierreCaja(Boolean visibilidadResaltarCajaCierre) {
		this.mostrarCajaCierreCaja= visibilidadResaltarCajaCierre;
	}



	public Boolean activarCajaCierreCaja=true;

	public Boolean gethabilitarResaltarCajaCierreCaja() {
		return this.activarCajaCierreCaja;
	}

	public void setActivarCajaCierreCaja(Boolean habilitarResaltarCajaCierre) {
		this.activarCajaCierreCaja= habilitarResaltarCajaCierre;
	}


	public Border resaltarFacturaPuntoVentaCaja=null;

	public Border getResaltarFacturaPuntoVentaCaja() {
		return this.resaltarFacturaPuntoVentaCaja;
	}

	public void setResaltarFacturaPuntoVentaCaja(Border borderResaltarFacturaPuntoVenta) {
		if(borderResaltarFacturaPuntoVenta!=null) {
			this.resaltarFacturaPuntoVentaCaja= borderResaltarFacturaPuntoVenta;
		}
	}

	public Border setResaltarFacturaPuntoVentaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarFacturaPuntoVenta);
			
		this.resaltarFacturaPuntoVentaCaja= borderResaltarFacturaPuntoVenta;

		 return borderResaltarFacturaPuntoVenta;
	}



	public Boolean mostrarFacturaPuntoVentaCaja=true;

	public Boolean getMostrarFacturaPuntoVentaCaja() {
		return this.mostrarFacturaPuntoVentaCaja;
	}

	public void setMostrarFacturaPuntoVentaCaja(Boolean visibilidadResaltarFacturaPuntoVenta) {
		this.mostrarFacturaPuntoVentaCaja= visibilidadResaltarFacturaPuntoVenta;
	}



	public Boolean activarFacturaPuntoVentaCaja=true;

	public Boolean gethabilitarResaltarFacturaPuntoVentaCaja() {
		return this.activarFacturaPuntoVentaCaja;
	}

	public void setActivarFacturaPuntoVentaCaja(Boolean habilitarResaltarFacturaPuntoVenta) {
		this.activarFacturaPuntoVentaCaja= habilitarResaltarFacturaPuntoVenta;
	}


	public Border resaltarCajaEgresoCaja=null;

	public Border getResaltarCajaEgresoCaja() {
		return this.resaltarCajaEgresoCaja;
	}

	public void setResaltarCajaEgresoCaja(Border borderResaltarCajaEgreso) {
		if(borderResaltarCajaEgreso!=null) {
			this.resaltarCajaEgresoCaja= borderResaltarCajaEgreso;
		}
	}

	public Border setResaltarCajaEgresoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaEgreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarCajaEgreso);
			
		this.resaltarCajaEgresoCaja= borderResaltarCajaEgreso;

		 return borderResaltarCajaEgreso;
	}



	public Boolean mostrarCajaEgresoCaja=true;

	public Boolean getMostrarCajaEgresoCaja() {
		return this.mostrarCajaEgresoCaja;
	}

	public void setMostrarCajaEgresoCaja(Boolean visibilidadResaltarCajaEgreso) {
		this.mostrarCajaEgresoCaja= visibilidadResaltarCajaEgreso;
	}



	public Boolean activarCajaEgresoCaja=true;

	public Boolean gethabilitarResaltarCajaEgresoCaja() {
		return this.activarCajaEgresoCaja;
	}

	public void setActivarCajaEgresoCaja(Boolean habilitarResaltarCajaEgreso) {
		this.activarCajaEgresoCaja= habilitarResaltarCajaEgreso;
	}


	public Border resaltarCajeroTurnoCaja=null;

	public Border getResaltarCajeroTurnoCaja() {
		return this.resaltarCajeroTurnoCaja;
	}

	public void setResaltarCajeroTurnoCaja(Border borderResaltarCajeroTurno) {
		if(borderResaltarCajeroTurno!=null) {
			this.resaltarCajeroTurnoCaja= borderResaltarCajeroTurno;
		}
	}

	public Border setResaltarCajeroTurnoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarCajeroTurno=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarCajeroTurno);
			
		this.resaltarCajeroTurnoCaja= borderResaltarCajeroTurno;

		 return borderResaltarCajeroTurno;
	}



	public Boolean mostrarCajeroTurnoCaja=true;

	public Boolean getMostrarCajeroTurnoCaja() {
		return this.mostrarCajeroTurnoCaja;
	}

	public void setMostrarCajeroTurnoCaja(Boolean visibilidadResaltarCajeroTurno) {
		this.mostrarCajeroTurnoCaja= visibilidadResaltarCajeroTurno;
	}



	public Boolean activarCajeroTurnoCaja=true;

	public Boolean gethabilitarResaltarCajeroTurnoCaja() {
		return this.activarCajeroTurnoCaja;
	}

	public void setActivarCajeroTurnoCaja(Boolean habilitarResaltarCajeroTurno) {
		this.activarCajeroTurnoCaja= habilitarResaltarCajeroTurno;
	}


	public Border resaltarPresupuestoVentasPunVenCaja=null;

	public Border getResaltarPresupuestoVentasPunVenCaja() {
		return this.resaltarPresupuestoVentasPunVenCaja;
	}

	public void setResaltarPresupuestoVentasPunVenCaja(Border borderResaltarPresupuestoVentasPunVen) {
		if(borderResaltarPresupuestoVentasPunVen!=null) {
			this.resaltarPresupuestoVentasPunVenCaja= borderResaltarPresupuestoVentasPunVen;
		}
	}

	public Border setResaltarPresupuestoVentasPunVenCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentasPunVen=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarPresupuestoVentasPunVen);
			
		this.resaltarPresupuestoVentasPunVenCaja= borderResaltarPresupuestoVentasPunVen;

		 return borderResaltarPresupuestoVentasPunVen;
	}



	public Boolean mostrarPresupuestoVentasPunVenCaja=true;

	public Boolean getMostrarPresupuestoVentasPunVenCaja() {
		return this.mostrarPresupuestoVentasPunVenCaja;
	}

	public void setMostrarPresupuestoVentasPunVenCaja(Boolean visibilidadResaltarPresupuestoVentasPunVen) {
		this.mostrarPresupuestoVentasPunVenCaja= visibilidadResaltarPresupuestoVentasPunVen;
	}



	public Boolean activarPresupuestoVentasPunVenCaja=true;

	public Boolean gethabilitarResaltarPresupuestoVentasPunVenCaja() {
		return this.activarPresupuestoVentasPunVenCaja;
	}

	public void setActivarPresupuestoVentasPunVenCaja(Boolean habilitarResaltarPresupuestoVentasPunVen) {
		this.activarPresupuestoVentasPunVenCaja= habilitarResaltarPresupuestoVentasPunVen;
	}


	public Border resaltarPedidoPuntoVentaCaja=null;

	public Border getResaltarPedidoPuntoVentaCaja() {
		return this.resaltarPedidoPuntoVentaCaja;
	}

	public void setResaltarPedidoPuntoVentaCaja(Border borderResaltarPedidoPuntoVenta) {
		if(borderResaltarPedidoPuntoVenta!=null) {
			this.resaltarPedidoPuntoVentaCaja= borderResaltarPedidoPuntoVenta;
		}
	}

	public Border setResaltarPedidoPuntoVentaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarPedidoPuntoVenta);
			
		this.resaltarPedidoPuntoVentaCaja= borderResaltarPedidoPuntoVenta;

		 return borderResaltarPedidoPuntoVenta;
	}



	public Boolean mostrarPedidoPuntoVentaCaja=true;

	public Boolean getMostrarPedidoPuntoVentaCaja() {
		return this.mostrarPedidoPuntoVentaCaja;
	}

	public void setMostrarPedidoPuntoVentaCaja(Boolean visibilidadResaltarPedidoPuntoVenta) {
		this.mostrarPedidoPuntoVentaCaja= visibilidadResaltarPedidoPuntoVenta;
	}



	public Boolean activarPedidoPuntoVentaCaja=true;

	public Boolean gethabilitarResaltarPedidoPuntoVentaCaja() {
		return this.activarPedidoPuntoVentaCaja;
	}

	public void setActivarPedidoPuntoVentaCaja(Boolean habilitarResaltarPedidoPuntoVenta) {
		this.activarPedidoPuntoVentaCaja= habilitarResaltarPedidoPuntoVenta;
	}


	public Border resaltarCajaIngresoCaja=null;

	public Border getResaltarCajaIngresoCaja() {
		return this.resaltarCajaIngresoCaja;
	}

	public void setResaltarCajaIngresoCaja(Border borderResaltarCajaIngreso) {
		if(borderResaltarCajaIngreso!=null) {
			this.resaltarCajaIngresoCaja= borderResaltarCajaIngreso;
		}
	}

	public Border setResaltarCajaIngresoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaIngreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaBeanSwingJInternalFrame.jTtoolBarCaja.setBorder(borderResaltarCajaIngreso);
			
		this.resaltarCajaIngresoCaja= borderResaltarCajaIngreso;

		 return borderResaltarCajaIngreso;
	}



	public Boolean mostrarCajaIngresoCaja=true;

	public Boolean getMostrarCajaIngresoCaja() {
		return this.mostrarCajaIngresoCaja;
	}

	public void setMostrarCajaIngresoCaja(Boolean visibilidadResaltarCajaIngreso) {
		this.mostrarCajaIngresoCaja= visibilidadResaltarCajaIngreso;
	}



	public Boolean activarCajaIngresoCaja=true;

	public Boolean gethabilitarResaltarCajaIngresoCaja() {
		return this.activarCajaIngresoCaja;
	}

	public void setActivarCajaIngresoCaja(Boolean habilitarResaltarCajaIngreso) {
		this.activarCajaIngresoCaja= habilitarResaltarCajaIngreso;
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

		this.setMostrarNotaCreditoPuntoVentaCaja(esInicial);
		this.setMostrarCajaCierreCaja(esInicial);
		this.setMostrarFacturaPuntoVentaCaja(esInicial);
		this.setMostrarCajaEgresoCaja(esInicial);
		this.setMostrarCajeroTurnoCaja(esInicial);
		this.setMostrarPresupuestoVentasPunVenCaja(esInicial);
		this.setMostrarPedidoPuntoVentaCaja(esInicial);
		this.setMostrarCajaIngresoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaCierre.class)) {
				this.setMostrarCajaCierreCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setMostrarFacturaPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setMostrarCajaEgresoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setMostrarCajeroTurnoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasPunVen.class)) {
				this.setMostrarPresupuestoVentasPunVenCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setMostrarPedidoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setMostrarCajaIngresoCaja(esAsigna);
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

		this.setActivarNotaCreditoPuntoVentaCaja(esInicial);
		this.setActivarCajaCierreCaja(esInicial);
		this.setActivarFacturaPuntoVentaCaja(esInicial);
		this.setActivarCajaEgresoCaja(esInicial);
		this.setActivarCajeroTurnoCaja(esInicial);
		this.setActivarPresupuestoVentasPunVenCaja(esInicial);
		this.setActivarPedidoPuntoVentaCaja(esInicial);
		this.setActivarCajaIngresoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaCierre.class)) {
				this.setActivarCajaCierreCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setActivarFacturaPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setActivarCajaEgresoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setActivarCajeroTurnoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasPunVen.class)) {
				this.setActivarPresupuestoVentasPunVenCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setActivarPedidoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setActivarCajaIngresoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNotaCreditoPuntoVentaCaja(esInicial);
		this.setResaltarCajaCierreCaja(esInicial);
		this.setResaltarFacturaPuntoVentaCaja(esInicial);
		this.setResaltarCajaEgresoCaja(esInicial);
		this.setResaltarCajeroTurnoCaja(esInicial);
		this.setResaltarPresupuestoVentasPunVenCaja(esInicial);
		this.setResaltarPedidoPuntoVentaCaja(esInicial);
		this.setResaltarCajaIngresoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaCierre.class)) {
				this.setResaltarCajaCierreCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setResaltarFacturaPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setResaltarCajaEgresoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setResaltarCajeroTurnoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasPunVen.class)) {
				this.setResaltarPresupuestoVentasPunVenCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setResaltarPedidoPuntoVentaCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setResaltarCajaIngresoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadCaja=true;

	public Boolean getMostrarFK_IdCiudadCaja() {
		return this.mostrarFK_IdCiudadCaja;
	}

	public void setMostrarFK_IdCiudadCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCaja=true;

	public Boolean getMostrarFK_IdEmpresaCaja() {
		return this.mostrarFK_IdEmpresaCaja;
	}

	public void setMostrarFK_IdEmpresaCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisCaja=true;

	public Boolean getMostrarFK_IdPaisCaja() {
		return this.mostrarFK_IdPaisCaja;
	}

	public void setMostrarFK_IdPaisCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCaja=true;

	public Boolean getMostrarFK_IdSucursalCaja() {
		return this.mostrarFK_IdSucursalCaja;
	}

	public void setMostrarFK_IdSucursalCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaCaja=true;

	public Boolean getMostrarFK_IdZonaCaja() {
		return this.mostrarFK_IdZonaCaja;
	}

	public void setMostrarFK_IdZonaCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaCaja= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadCaja=true;

	public Boolean getActivarFK_IdCiudadCaja() {
		return this.activarFK_IdCiudadCaja;
	}

	public void setActivarFK_IdCiudadCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCaja=true;

	public Boolean getActivarFK_IdEmpresaCaja() {
		return this.activarFK_IdEmpresaCaja;
	}

	public void setActivarFK_IdEmpresaCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisCaja=true;

	public Boolean getActivarFK_IdPaisCaja() {
		return this.activarFK_IdPaisCaja;
	}

	public void setActivarFK_IdPaisCaja(Boolean habilitarResaltar) {
		this.activarFK_IdPaisCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCaja=true;

	public Boolean getActivarFK_IdSucursalCaja() {
		return this.activarFK_IdSucursalCaja;
	}

	public void setActivarFK_IdSucursalCaja(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaCaja=true;

	public Boolean getActivarFK_IdZonaCaja() {
		return this.activarFK_IdZonaCaja;
	}

	public void setActivarFK_IdZonaCaja(Boolean habilitarResaltar) {
		this.activarFK_IdZonaCaja= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadCaja=null;

	public Border getResaltarFK_IdCiudadCaja() {
		return this.resaltarFK_IdCiudadCaja;
	}

	public void setResaltarFK_IdCiudadCaja(Border borderResaltar) {
		this.resaltarFK_IdCiudadCaja= borderResaltar;
	}

	public void setResaltarFK_IdCiudadCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCaja=null;

	public Border getResaltarFK_IdEmpresaCaja() {
		return this.resaltarFK_IdEmpresaCaja;
	}

	public void setResaltarFK_IdEmpresaCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCaja= borderResaltar;
	}

	public Border resaltarFK_IdPaisCaja=null;

	public Border getResaltarFK_IdPaisCaja() {
		return this.resaltarFK_IdPaisCaja;
	}

	public void setResaltarFK_IdPaisCaja(Border borderResaltar) {
		this.resaltarFK_IdPaisCaja= borderResaltar;
	}

	public void setResaltarFK_IdPaisCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisCaja= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCaja=null;

	public Border getResaltarFK_IdSucursalCaja() {
		return this.resaltarFK_IdSucursalCaja;
	}

	public void setResaltarFK_IdSucursalCaja(Border borderResaltar) {
		this.resaltarFK_IdSucursalCaja= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCaja= borderResaltar;
	}

	public Border resaltarFK_IdZonaCaja=null;

	public Border getResaltarFK_IdZonaCaja() {
		return this.resaltarFK_IdZonaCaja;
	}

	public void setResaltarFK_IdZonaCaja(Border borderResaltar) {
		this.resaltarFK_IdZonaCaja= borderResaltar;
	}

	public void setResaltarFK_IdZonaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaBeanSwingJInternalFrame cajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}