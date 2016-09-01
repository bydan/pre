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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.VendedorConstantesFunciones;
import com.bydan.erp.comisiones.util.VendedorParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.VendedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VendedorConstantesFunciones extends VendedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Vendedor";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Vendedor"+VendedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VendedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VendedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VendedorConstantesFunciones.SCHEMA+"_"+VendedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VendedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VendedorConstantesFunciones.SCHEMA+"_"+VendedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VendedorConstantesFunciones.SCHEMA+"_"+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VendedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VendedorConstantesFunciones.SCHEMA+"_"+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VendedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VendedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VendedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VendedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vendedores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Vendedor";
	public static final String SCLASSWEBTITULO_LOWER="Vendedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Vendedor";
	public static final String OBJECTNAME="vendedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="vendedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vendedor from "+VendedorConstantesFunciones.SPERSISTENCENAME+" vendedor";
	public static String QUERYSELECTNATIVE="select "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".version_row,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empresa,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_sucursal,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".codigo,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".nombre,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".ruc,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".email,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empleado,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".telefono,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empleado_soporte,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_vendedor,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_pais,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_ciudad,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_zona,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".representante,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".es_supervisor,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".fecha_creacion,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".direccion_domicilio,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".direccion_referencia,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".descripcion,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".porcentaje_comision,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".comision,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".monto_vendido,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".numero_facturas,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".monto_ultima_venta,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".con_presupuesto,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".con_cobertura from "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME;//+" as "+VendedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VendedorConstantesFuncionesAdditional vendedorConstantesFuncionesAdditional=null;
	
	public VendedorConstantesFuncionesAdditional getVendedorConstantesFuncionesAdditional() {
		return this.vendedorConstantesFuncionesAdditional;
	}
	
	public void setVendedorConstantesFuncionesAdditional(VendedorConstantesFuncionesAdditional vendedorConstantesFuncionesAdditional) {
		try {
			this.vendedorConstantesFuncionesAdditional=vendedorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String RUC= "ruc";
    public static final String EMAIL= "email";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String TELEFONO= "telefono";
    public static final String IDEMPLEADOSOPORTE= "id_empleado_soporte";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String REPRESENTANTE= "representante";
    public static final String ESSUPERVISOR= "es_supervisor";
    public static final String FECHACREACION= "fecha_creacion";
    public static final String DIRECCIONDOMICILIO= "direccion_domicilio";
    public static final String DIRECCIONREFERENCIA= "direccion_referencia";
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJECOMISION= "porcentaje_comision";
    public static final String COMISION= "comision";
    public static final String MONTOVENDIDO= "monto_vendido";
    public static final String NUMEROFACTURAS= "numero_facturas";
    public static final String FECHAULTIMAVENTA= "fecha_ultima_venta";
    public static final String MONTOULTIMAVENTA= "monto_ultima_venta";
    public static final String CONPRESUPUESTO= "con_presupuesto";
    public static final String CONCOBERTURA= "con_cobertura";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_IDEMPLEADOSOPORTE= "Empleado Soporte";
		public static final String LABEL_IDEMPLEADOSOPORTE_LOWER= "Empleado Soporte";
    	public static final String LABEL_IDVENDEDOR= "Vendedor Padre";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_REPRESENTANTE= "Representante";
		public static final String LABEL_REPRESENTANTE_LOWER= "Representante";
    	public static final String LABEL_ESSUPERVISOR= "Es Supervisor";
		public static final String LABEL_ESSUPERVISOR_LOWER= "Es Supervisor";
    	public static final String LABEL_FECHACREACION= "Fecha Creacion";
		public static final String LABEL_FECHACREACION_LOWER= "Fecha Creacion";
    	public static final String LABEL_DIRECCIONDOMICILIO= "Direccion Domicilio";
		public static final String LABEL_DIRECCIONDOMICILIO_LOWER= "Direccion Domicilio";
    	public static final String LABEL_DIRECCIONREFERENCIA= "Direccion Referencia";
		public static final String LABEL_DIRECCIONREFERENCIA_LOWER= "Direccion Referencia";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJECOMISION= "Porcentaje Comision";
		public static final String LABEL_PORCENTAJECOMISION_LOWER= "Porcentaje Comision";
    	public static final String LABEL_COMISION= "Comision";
		public static final String LABEL_COMISION_LOWER= "Comision";
    	public static final String LABEL_MONTOVENDIDO= "Monto Vendido";
		public static final String LABEL_MONTOVENDIDO_LOWER= "Monto Vendido";
    	public static final String LABEL_NUMEROFACTURAS= "Numero Facturas";
		public static final String LABEL_NUMEROFACTURAS_LOWER= "Numero Facturas";
    	public static final String LABEL_FECHAULTIMAVENTA= "Fecha Ultima Venta";
		public static final String LABEL_FECHAULTIMAVENTA_LOWER= "Fecha Ultima Venta";
    	public static final String LABEL_MONTOULTIMAVENTA= "Monto Ultima Venta";
		public static final String LABEL_MONTOULTIMAVENTA_LOWER= "Monto Ultima Venta";
    	public static final String LABEL_CONPRESUPUESTO= "Con Presupuesto";
		public static final String LABEL_CONPRESUPUESTO_LOWER= "Con Presupuesto";
    	public static final String LABEL_CONCOBERTURA= "Con Cobertura";
		public static final String LABEL_CONCOBERTURA_LOWER= "Con Cobertura";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
		
		
	public static final String SREGEXREPRESENTANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDIRECCION_DOMICILIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DOMICILIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_REFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_REFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
	
	public static String getVendedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.CODIGO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.NOMBRE)) {sLabelColumna=VendedorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.RUC)) {sLabelColumna=VendedorConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.EMAIL)) {sLabelColumna=VendedorConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDEMPLEADO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.TELEFONO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDEMPLEADOSOPORTE)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDEMPLEADOSOPORTE;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDVENDEDOR)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDPAIS)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDCIUDAD)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.IDZONA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.REPRESENTANTE)) {sLabelColumna=VendedorConstantesFunciones.LABEL_REPRESENTANTE;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.ESSUPERVISOR)) {sLabelColumna=VendedorConstantesFunciones.LABEL_ESSUPERVISOR;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.FECHACREACION)) {sLabelColumna=VendedorConstantesFunciones.LABEL_FECHACREACION;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.DIRECCIONDOMICILIO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_DIRECCIONDOMICILIO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.DIRECCIONREFERENCIA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_DIRECCIONREFERENCIA;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.DESCRIPCION)) {sLabelColumna=VendedorConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.PORCENTAJECOMISION)) {sLabelColumna=VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.COMISION)) {sLabelColumna=VendedorConstantesFunciones.LABEL_COMISION;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.MONTOVENDIDO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_MONTOVENDIDO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.NUMEROFACTURAS)) {sLabelColumna=VendedorConstantesFunciones.LABEL_NUMEROFACTURAS;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.FECHAULTIMAVENTA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_FECHAULTIMAVENTA;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.MONTOULTIMAVENTA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.CONPRESUPUESTO)) {sLabelColumna=VendedorConstantesFunciones.LABEL_CONPRESUPUESTO;}
		if(sNombreColumna.equals(VendedorConstantesFunciones.CONCOBERTURA)) {sLabelColumna=VendedorConstantesFunciones.LABEL_CONCOBERTURA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_supervisorDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!vendedor.getes_supervisor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_supervisorHtmlDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(vendedor.getId(),vendedor.getes_supervisor());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_presupuestoDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!vendedor.getcon_presupuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_presupuestoHtmlDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(vendedor.getId(),vendedor.getcon_presupuesto());

		return sDescripcion;
	}	
		
	public static String getcon_coberturaDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!vendedor.getcon_cobertura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_coberturaHtmlDescripcion(Vendedor vendedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(vendedor.getId(),vendedor.getcon_cobertura());

		return sDescripcion;
	}	
	
	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vendedor !=null/* && vendedor.getId()!=0*/) {
			sDescripcion=vendedor.getcodigo()+"-"+vendedor.getnombre();//vendedorvendedor.getcodigo().trim()+"-"+vendedor.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVendedorDescripcionDetallado(Vendedor vendedor) {
		String sDescripcion="";
			
		sDescripcion+=VendedorConstantesFunciones.ID+"=";
		sDescripcion+=vendedor.getId().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vendedor.getVersionRow().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vendedor.getid_empresa().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=vendedor.getid_sucursal().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.CODIGO+"=";
		sDescripcion+=vendedor.getcodigo()+",";
		sDescripcion+=VendedorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=vendedor.getnombre()+",";
		sDescripcion+=VendedorConstantesFunciones.RUC+"=";
		sDescripcion+=vendedor.getruc()+",";
		sDescripcion+=VendedorConstantesFunciones.EMAIL+"=";
		sDescripcion+=vendedor.getemail()+",";
		sDescripcion+=VendedorConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=vendedor.getid_empleado().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.TELEFONO+"=";
		sDescripcion+=vendedor.gettelefono()+",";
		sDescripcion+=VendedorConstantesFunciones.IDEMPLEADOSOPORTE+"=";
		sDescripcion+=vendedor.getid_empleado_soporte().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=vendedor.getid_vendedor().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDPAIS+"=";
		sDescripcion+=vendedor.getid_pais().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=vendedor.getid_ciudad().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.IDZONA+"=";
		sDescripcion+=vendedor.getid_zona().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.REPRESENTANTE+"=";
		sDescripcion+=vendedor.getrepresentante()+",";
		sDescripcion+=VendedorConstantesFunciones.ESSUPERVISOR+"=";
		sDescripcion+=vendedor.getes_supervisor().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.FECHACREACION+"=";
		sDescripcion+=vendedor.getfecha_creacion().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.DIRECCIONDOMICILIO+"=";
		sDescripcion+=vendedor.getdireccion_domicilio()+",";
		sDescripcion+=VendedorConstantesFunciones.DIRECCIONREFERENCIA+"=";
		sDescripcion+=vendedor.getdireccion_referencia()+",";
		sDescripcion+=VendedorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=vendedor.getdescripcion()+",";
		sDescripcion+=VendedorConstantesFunciones.PORCENTAJECOMISION+"=";
		sDescripcion+=vendedor.getporcentaje_comision().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.COMISION+"=";
		sDescripcion+=vendedor.getcomision().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.MONTOVENDIDO+"=";
		sDescripcion+=vendedor.getmonto_vendido().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.NUMEROFACTURAS+"=";
		sDescripcion+=vendedor.getnumero_facturas().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.FECHAULTIMAVENTA+"=";
		sDescripcion+=vendedor.getfecha_ultima_venta().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.MONTOULTIMAVENTA+"=";
		sDescripcion+=vendedor.getmonto_ultima_venta().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.CONPRESUPUESTO+"=";
		sDescripcion+=vendedor.getcon_presupuesto().toString()+",";
		sDescripcion+=VendedorConstantesFunciones.CONCOBERTURA+"=";
		sDescripcion+=vendedor.getcon_cobertura().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVendedorDescripcion(Vendedor vendedor,String sValor) throws Exception {			
		if(vendedor !=null) {
			vendedor.setcodigo(sValor);
vendedor.setnombre(sValor);;//vendedorvendedor.getcodigo().trim()+"-"+vendedor.getnombre().trim();
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEmpleadoSoporteDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoSoporte")) {
			sNombreIndice="Tipo=  Por Empleado Soporte";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor Padre";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorRuc(String ruc) {
		String sDetalleIndice=" Parametros->";
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoSoporte(Long id_empleado_soporte) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_soporte!=null) {sDetalleIndice+=" Codigo Unico De Empleado Soporte="+id_empleado_soporte.toString();} 

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

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor Padre="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVendedor(Vendedor vendedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vendedor.setcodigo(vendedor.getcodigo().trim());
		vendedor.setnombre(vendedor.getnombre().trim());
		vendedor.setruc(vendedor.getruc().trim());
		vendedor.setemail(vendedor.getemail().trim());
		vendedor.settelefono(vendedor.gettelefono().trim());
		vendedor.setrepresentante(vendedor.getrepresentante().trim());
		vendedor.setdireccion_domicilio(vendedor.getdireccion_domicilio().trim());
		vendedor.setdireccion_referencia(vendedor.getdireccion_referencia().trim());
		vendedor.setdescripcion(vendedor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosVendedors(List<Vendedor> vendedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Vendedor vendedor: vendedors) {
			vendedor.setcodigo(vendedor.getcodigo().trim());
			vendedor.setnombre(vendedor.getnombre().trim());
			vendedor.setruc(vendedor.getruc().trim());
			vendedor.setemail(vendedor.getemail().trim());
			vendedor.settelefono(vendedor.gettelefono().trim());
			vendedor.setrepresentante(vendedor.getrepresentante().trim());
			vendedor.setdireccion_domicilio(vendedor.getdireccion_domicilio().trim());
			vendedor.setdireccion_referencia(vendedor.getdireccion_referencia().trim());
			vendedor.setdescripcion(vendedor.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedor(Vendedor vendedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vendedor.getConCambioAuxiliar()) {
			vendedor.setIsDeleted(vendedor.getIsDeletedAuxiliar());	
			vendedor.setIsNew(vendedor.getIsNewAuxiliar());	
			vendedor.setIsChanged(vendedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vendedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vendedor.setIsDeletedAuxiliar(false);	
			vendedor.setIsNewAuxiliar(false);	
			vendedor.setIsChangedAuxiliar(false);
			
			vendedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedors(List<Vendedor> vendedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Vendedor vendedor : vendedors) {
			if(conAsignarBase && vendedor.getConCambioAuxiliar()) {
				vendedor.setIsDeleted(vendedor.getIsDeletedAuxiliar());	
				vendedor.setIsNew(vendedor.getIsNewAuxiliar());	
				vendedor.setIsChanged(vendedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vendedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vendedor.setIsDeletedAuxiliar(false);	
				vendedor.setIsNewAuxiliar(false);	
				vendedor.setIsChangedAuxiliar(false);
				
				vendedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVendedor(Vendedor vendedor,Boolean conEnteros) throws Exception  {
		vendedor.setporcentaje_comision(0.0);
		vendedor.setcomision(0.0);
		vendedor.setmonto_vendido(0.0);
		vendedor.setmonto_ultima_venta(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			vendedor.setnumero_facturas(0);
		}
	}		
	
	public static void InicializarValoresVendedors(List<Vendedor> vendedors,Boolean conEnteros) throws Exception  {
		
		for(Vendedor vendedor: vendedors) {
			vendedor.setporcentaje_comision(0.0);
			vendedor.setcomision(0.0);
			vendedor.setmonto_vendido(0.0);
			vendedor.setmonto_ultima_venta(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				vendedor.setnumero_facturas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaVendedor(List<Vendedor> vendedors,Vendedor vendedorAux) throws Exception  {
		VendedorConstantesFunciones.InicializarValoresVendedor(vendedorAux,true);
		
		for(Vendedor vendedor: vendedors) {
			if(vendedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vendedorAux.setporcentaje_comision(vendedorAux.getporcentaje_comision()+vendedor.getporcentaje_comision());			
			vendedorAux.setcomision(vendedorAux.getcomision()+vendedor.getcomision());			
			vendedorAux.setmonto_vendido(vendedorAux.getmonto_vendido()+vendedor.getmonto_vendido());			
			vendedorAux.setnumero_facturas(vendedorAux.getnumero_facturas()+vendedor.getnumero_facturas());			
			vendedorAux.setmonto_ultima_venta(vendedorAux.getmonto_ultima_venta()+vendedor.getmonto_ultima_venta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VendedorConstantesFunciones.getArrayColumnasGlobalesVendedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVendedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Vendedor> vendedors,Vendedor vendedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Vendedor vendedorAux: vendedors) {
			if(vendedorAux!=null && vendedor!=null) {
				if((vendedorAux.getId()==null && vendedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vendedorAux.getId()!=null && vendedor.getId()!=null){
					if(vendedorAux.getId().equals(vendedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVendedor(List<Vendedor> vendedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_comisionTotal=0.0;
		Double comisionTotal=0.0;
		Double monto_vendidoTotal=0.0;
		Double monto_ultima_ventaTotal=0.0;
	
		for(Vendedor vendedor: vendedors) {			
			if(vendedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_comisionTotal+=vendedor.getporcentaje_comision();
			comisionTotal+=vendedor.getcomision();
			monto_vendidoTotal+=vendedor.getmonto_vendido();
			monto_ultima_ventaTotal+=vendedor.getmonto_ultima_venta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.PORCENTAJECOMISION);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION);
		datoGeneral.setdValorDouble(porcentaje_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.COMISION);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_COMISION);
		datoGeneral.setdValorDouble(comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.MONTOVENDIDO);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOVENDIDO);
		datoGeneral.setdValorDouble(monto_vendidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.MONTOULTIMAVENTA);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA);
		datoGeneral.setdValorDouble(monto_ultima_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVendedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_ID, VendedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_VERSIONROW, VendedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDEMPRESA, VendedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDSUCURSAL, VendedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_CODIGO, VendedorConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_NOMBRE, VendedorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_RUC, VendedorConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_EMAIL, VendedorConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDEMPLEADO, VendedorConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_TELEFONO, VendedorConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDEMPLEADOSOPORTE, VendedorConstantesFunciones.IDEMPLEADOSOPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDVENDEDOR, VendedorConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDPAIS, VendedorConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDCIUDAD, VendedorConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_IDZONA, VendedorConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_REPRESENTANTE, VendedorConstantesFunciones.REPRESENTANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_ESSUPERVISOR, VendedorConstantesFunciones.ESSUPERVISOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_FECHACREACION, VendedorConstantesFunciones.FECHACREACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_DIRECCIONDOMICILIO, VendedorConstantesFunciones.DIRECCIONDOMICILIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_DIRECCIONREFERENCIA, VendedorConstantesFunciones.DIRECCIONREFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_DESCRIPCION, VendedorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION, VendedorConstantesFunciones.PORCENTAJECOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_COMISION, VendedorConstantesFunciones.COMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_MONTOVENDIDO, VendedorConstantesFunciones.MONTOVENDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_NUMEROFACTURAS, VendedorConstantesFunciones.NUMEROFACTURAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_FECHAULTIMAVENTA, VendedorConstantesFunciones.FECHAULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA, VendedorConstantesFunciones.MONTOULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_CONPRESUPUESTO, VendedorConstantesFunciones.CONPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorConstantesFunciones.LABEL_CONCOBERTURA, VendedorConstantesFunciones.CONCOBERTURA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVendedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDEMPLEADOSOPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.REPRESENTANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.ESSUPERVISOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.FECHACREACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.DIRECCIONDOMICILIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.DIRECCIONREFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.PORCENTAJECOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.COMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.MONTOVENDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.NUMEROFACTURAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.FECHAULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.MONTOULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.CONPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorConstantesFunciones.CONCOBERTURA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedor() throws Exception  {
		return VendedorConstantesFunciones.getTiposSeleccionarVendedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedor(Boolean conFk) throws Exception  {
		return VendedorConstantesFunciones.getTiposSeleccionarVendedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDEMPLEADOSOPORTE);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDEMPLEADOSOPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_REPRESENTANTE);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_REPRESENTANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_ESSUPERVISOR);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_ESSUPERVISOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_FECHACREACION);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_FECHACREACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_DIRECCIONDOMICILIO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_DIRECCIONDOMICILIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_DIRECCIONREFERENCIA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_DIRECCIONREFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_COMISION);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_COMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_MONTOVENDIDO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOVENDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_NUMEROFACTURAS);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_NUMEROFACTURAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_FECHAULTIMAVENTA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_FECHAULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_CONPRESUPUESTO);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_CONPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorConstantesFunciones.LABEL_CONCOBERTURA);
			reporte.setsDescripcion(VendedorConstantesFunciones.LABEL_CONCOBERTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVendedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVendedor(Vendedor vendedorAux) throws Exception {
		
			vendedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorAux.getEmpresa()));
			vendedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vendedorAux.getSucursal()));
			vendedorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vendedorAux.getEmpleado()));
			vendedorAux.setempleadosoporte_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vendedorAux.getEmpleadoSoporte()));
			vendedorAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorAux.getVendedor()));
			vendedorAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(vendedorAux.getPais()));
			vendedorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(vendedorAux.getCiudad()));
			vendedorAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(vendedorAux.getZona()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVendedor(List<Vendedor> vendedorsTemp) throws Exception {
		for(Vendedor vendedorAux:vendedorsTemp) {
			
			vendedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorAux.getEmpresa()));
			vendedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vendedorAux.getSucursal()));
			vendedorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vendedorAux.getEmpleado()));
			vendedorAux.setempleadosoporte_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vendedorAux.getEmpleadoSoporte()));
			vendedorAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorAux.getVendedor()));
			vendedorAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(vendedorAux.getPais()));
			vendedorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(vendedorAux.getCiudad()));
			vendedorAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(vendedorAux.getZona()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVendedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Vendedor.class));
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
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVendedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorConstantesFunciones.getClassesRelationshipsOfVendedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NotaCreditoSoli.class));
				classes.add(new Classe(ComisionVentaCobro.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ComisionGrupo.class));
				classes.add(new Classe(ComisionLinea.class));
				classes.add(new Classe(VendedorZona.class));
				classes.add(new Classe(ComisionCate.class));
				classes.add(new Classe(CajeroTurno.class));
				classes.add(new Classe(ComisionMarca.class));
				classes.add(new Classe(PresupuestoVentas.class));
				classes.add(new Classe(PresupuestoVentasLineas.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionVentaCobro.class)) {
						classes.add(new Classe(ComisionVentaCobro.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionGrupo.class)) {
						classes.add(new Classe(ComisionGrupo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionLinea.class)) {
						classes.add(new Classe(ComisionLinea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(VendedorZona.class)) {
						classes.add(new Classe(VendedorZona.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionCate.class)) {
						classes.add(new Classe(ComisionCate.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajeroTurno.class)) {
						classes.add(new Classe(CajeroTurno.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionMarca.class)) {
						classes.add(new Classe(ComisionMarca.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentas.class)) {
						classes.add(new Classe(PresupuestoVentas.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentasLineas.class)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorConstantesFunciones.getClassesRelationshipsFromStringsOfVendedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(ComisionVentaCobro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionVentaCobro.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(VendedorZona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VendedorZona.class)); continue;
					}

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(ComisionVentaCobro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionVentaCobro.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(VendedorZona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VendedorZona.class)); continue;
					}

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
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
	public static void actualizarLista(Vendedor vendedor,List<Vendedor> vendedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Vendedor vendedorEncontrado=null;
			
			for(Vendedor vendedorLocal:vendedors) {
				if(vendedorLocal.getId().equals(vendedor.getId())) {
					vendedorEncontrado=vendedorLocal;
					
					vendedorLocal.setIsChanged(vendedor.getIsChanged());
					vendedorLocal.setIsNew(vendedor.getIsNew());
					vendedorLocal.setIsDeleted(vendedor.getIsDeleted());
					
					vendedorLocal.setGeneralEntityOriginal(vendedor.getGeneralEntityOriginal());
					
					vendedorLocal.setId(vendedor.getId());	
					vendedorLocal.setVersionRow(vendedor.getVersionRow());	
					vendedorLocal.setid_empresa(vendedor.getid_empresa());	
					vendedorLocal.setid_sucursal(vendedor.getid_sucursal());	
					vendedorLocal.setcodigo(vendedor.getcodigo());	
					vendedorLocal.setnombre(vendedor.getnombre());	
					vendedorLocal.setruc(vendedor.getruc());	
					vendedorLocal.setemail(vendedor.getemail());	
					vendedorLocal.setid_empleado(vendedor.getid_empleado());	
					vendedorLocal.settelefono(vendedor.gettelefono());	
					vendedorLocal.setid_empleado_soporte(vendedor.getid_empleado_soporte());	
					vendedorLocal.setid_vendedor(vendedor.getid_vendedor());	
					vendedorLocal.setid_pais(vendedor.getid_pais());	
					vendedorLocal.setid_ciudad(vendedor.getid_ciudad());	
					vendedorLocal.setid_zona(vendedor.getid_zona());	
					vendedorLocal.setrepresentante(vendedor.getrepresentante());	
					vendedorLocal.setes_supervisor(vendedor.getes_supervisor());	
					vendedorLocal.setfecha_creacion(vendedor.getfecha_creacion());	
					vendedorLocal.setdireccion_domicilio(vendedor.getdireccion_domicilio());	
					vendedorLocal.setdireccion_referencia(vendedor.getdireccion_referencia());	
					vendedorLocal.setdescripcion(vendedor.getdescripcion());	
					vendedorLocal.setporcentaje_comision(vendedor.getporcentaje_comision());	
					vendedorLocal.setcomision(vendedor.getcomision());	
					vendedorLocal.setmonto_vendido(vendedor.getmonto_vendido());	
					vendedorLocal.setnumero_facturas(vendedor.getnumero_facturas());	
					vendedorLocal.setfecha_ultima_venta(vendedor.getfecha_ultima_venta());	
					vendedorLocal.setmonto_ultima_venta(vendedor.getmonto_ultima_venta());	
					vendedorLocal.setcon_presupuesto(vendedor.getcon_presupuesto());	
					vendedorLocal.setcon_cobertura(vendedor.getcon_cobertura());	
					
					
					vendedorLocal.setNotaCreditoSolis(vendedor.getNotaCreditoSolis());
					vendedorLocal.setComisionVentaCobros(vendedor.getComisionVentaCobros());
					vendedorLocal.setVendedors(vendedor.getVendedors());
					vendedorLocal.setClientes(vendedor.getClientes());
					vendedorLocal.setComisionGrupos(vendedor.getComisionGrupos());
					vendedorLocal.setComisionLineas(vendedor.getComisionLineas());
					vendedorLocal.setVendedorZonas(vendedor.getVendedorZonas());
					vendedorLocal.setComisionCates(vendedor.getComisionCates());
					vendedorLocal.setCajeroTurnos(vendedor.getCajeroTurnos());
					vendedorLocal.setComisionMarcas(vendedor.getComisionMarcas());
					vendedorLocal.setPresupuestoVentass(vendedor.getPresupuestoVentass());
					vendedorLocal.setPresupuestoVentasLineass(vendedor.getPresupuestoVentasLineass());
					
					existe=true;
					break;
				}
			}
			
			if(!vendedor.getIsDeleted()) {
				if(!existe) {
					vendedors.add(vendedor);
				}
			} else {
				if(vendedorEncontrado!=null && permiteQuitar)  {
					vendedors.remove(vendedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Vendedor vendedor,List<Vendedor> vendedors) throws Exception {
		try	{			
			for(Vendedor vendedorLocal:vendedors) {
				if(vendedorLocal.getId().equals(vendedor.getId())) {
					vendedorLocal.setIsSelected(vendedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVendedor(List<Vendedor> vendedorsAux) throws Exception {
		//this.vendedorsAux=vendedorsAux;
		
		for(Vendedor vendedorAux:vendedorsAux) {
			if(vendedorAux.getIsChanged()) {
				vendedorAux.setIsChanged(false);
			}		
			
			if(vendedorAux.getIsNew()) {
				vendedorAux.setIsNew(false);
			}	
			
			if(vendedorAux.getIsDeleted()) {
				vendedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVendedor(Vendedor vendedorAux) throws Exception {
		//this.vendedorAux=vendedorAux;
		
			if(vendedorAux.getIsChanged()) {
				vendedorAux.setIsChanged(false);
			}		
			
			if(vendedorAux.getIsNew()) {
				vendedorAux.setIsNew(false);
			}	
			
			if(vendedorAux.getIsDeleted()) {
				vendedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Vendedor vendedorAsignar,Vendedor vendedor) throws Exception {
		vendedorAsignar.setId(vendedor.getId());	
		vendedorAsignar.setVersionRow(vendedor.getVersionRow());	
		vendedorAsignar.setid_empresa(vendedor.getid_empresa());
		vendedorAsignar.setempresa_descripcion(vendedor.getempresa_descripcion());	
		vendedorAsignar.setid_sucursal(vendedor.getid_sucursal());
		vendedorAsignar.setsucursal_descripcion(vendedor.getsucursal_descripcion());	
		vendedorAsignar.setcodigo(vendedor.getcodigo());	
		vendedorAsignar.setnombre(vendedor.getnombre());	
		vendedorAsignar.setruc(vendedor.getruc());	
		vendedorAsignar.setemail(vendedor.getemail());	
		vendedorAsignar.setid_empleado(vendedor.getid_empleado());
		vendedorAsignar.setempleado_descripcion(vendedor.getempleado_descripcion());	
		vendedorAsignar.settelefono(vendedor.gettelefono());	
		vendedorAsignar.setid_empleado_soporte(vendedor.getid_empleado_soporte());
		vendedorAsignar.setempleadosoporte_descripcion(vendedor.getempleadosoporte_descripcion());	
		vendedorAsignar.setid_vendedor(vendedor.getid_vendedor());
		vendedorAsignar.setvendedor_descripcion(vendedor.getvendedor_descripcion());	
		vendedorAsignar.setid_pais(vendedor.getid_pais());
		vendedorAsignar.setpais_descripcion(vendedor.getpais_descripcion());	
		vendedorAsignar.setid_ciudad(vendedor.getid_ciudad());
		vendedorAsignar.setciudad_descripcion(vendedor.getciudad_descripcion());	
		vendedorAsignar.setid_zona(vendedor.getid_zona());
		vendedorAsignar.setzona_descripcion(vendedor.getzona_descripcion());	
		vendedorAsignar.setrepresentante(vendedor.getrepresentante());	
		vendedorAsignar.setes_supervisor(vendedor.getes_supervisor());	
		vendedorAsignar.setfecha_creacion(vendedor.getfecha_creacion());	
		vendedorAsignar.setdireccion_domicilio(vendedor.getdireccion_domicilio());	
		vendedorAsignar.setdireccion_referencia(vendedor.getdireccion_referencia());	
		vendedorAsignar.setdescripcion(vendedor.getdescripcion());	
		vendedorAsignar.setporcentaje_comision(vendedor.getporcentaje_comision());	
		vendedorAsignar.setcomision(vendedor.getcomision());	
		vendedorAsignar.setmonto_vendido(vendedor.getmonto_vendido());	
		vendedorAsignar.setnumero_facturas(vendedor.getnumero_facturas());	
		vendedorAsignar.setfecha_ultima_venta(vendedor.getfecha_ultima_venta());	
		vendedorAsignar.setmonto_ultima_venta(vendedor.getmonto_ultima_venta());	
		vendedorAsignar.setcon_presupuesto(vendedor.getcon_presupuesto());	
		vendedorAsignar.setcon_cobertura(vendedor.getcon_cobertura());	
	}
	
	public static void inicializarVendedor(Vendedor vendedor) throws Exception {
		try {
				vendedor.setId(0L);	
					
				vendedor.setid_empresa(-1L);	
				vendedor.setid_sucursal(-1L);	
				vendedor.setcodigo("");	
				vendedor.setnombre("");	
				vendedor.setruc("");	
				vendedor.setemail("");	
				vendedor.setid_empleado(-1L);	
				vendedor.settelefono("");	
				vendedor.setid_empleado_soporte(null);	
				vendedor.setid_vendedor(null);	
				vendedor.setid_pais(-1L);	
				vendedor.setid_ciudad(-1L);	
				vendedor.setid_zona(-1L);	
				vendedor.setrepresentante("");	
				vendedor.setes_supervisor(false);	
				vendedor.setfecha_creacion(new Date());	
				vendedor.setdireccion_domicilio("");	
				vendedor.setdireccion_referencia("");	
				vendedor.setdescripcion("");	
				vendedor.setporcentaje_comision(0.0);	
				vendedor.setcomision(0.0);	
				vendedor.setmonto_vendido(0.0);	
				vendedor.setnumero_facturas(0);	
				vendedor.setfecha_ultima_venta(new Date());	
				vendedor.setmonto_ultima_venta(0.0);	
				vendedor.setcon_presupuesto(false);	
				vendedor.setcon_cobertura(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVendedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDEMPLEADOSOPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_REPRESENTANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_ESSUPERVISOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_FECHACREACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_DIRECCIONDOMICILIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_DIRECCIONREFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_COMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_MONTOVENDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_NUMEROFACTURAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_FECHAULTIMAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_CONPRESUPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorConstantesFunciones.LABEL_CONCOBERTURA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVendedor(String sTipo,Row row,Workbook workbook,Vendedor vendedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getempleadosoporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getrepresentante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(vendedor.getes_supervisor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getfecha_creacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getdireccion_domicilio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getdireccion_referencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getporcentaje_comision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getcomision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getmonto_vendido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getnumero_facturas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getfecha_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedor.getmonto_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(vendedor.getcon_presupuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(vendedor.getcon_cobertura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVendedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVendedor() {
		return this.sFinalQueryVendedor;
	}
	
	public void setsFinalQueryVendedor(String sFinalQueryVendedor) {
		this.sFinalQueryVendedor= sFinalQueryVendedor;
	}
	
	public Border resaltarSeleccionarVendedor=null;
	
	public Border setResaltarSeleccionarVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVendedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVendedor() {
		return this.resaltarSeleccionarVendedor;
	}
	
	public void setResaltarSeleccionarVendedor(Border borderResaltarSeleccionarVendedor) {
		this.resaltarSeleccionarVendedor= borderResaltarSeleccionarVendedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVendedor=null;
	public Boolean mostraridVendedor=true;
	public Boolean activaridVendedor=true;

	public Border resaltarid_empresaVendedor=null;
	public Boolean mostrarid_empresaVendedor=true;
	public Boolean activarid_empresaVendedor=true;
	public Boolean cargarid_empresaVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVendedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalVendedor=null;
	public Boolean mostrarid_sucursalVendedor=true;
	public Boolean activarid_sucursalVendedor=true;
	public Boolean cargarid_sucursalVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVendedor=false;//ConEventDepend=true

	public Border resaltarcodigoVendedor=null;
	public Boolean mostrarcodigoVendedor=true;
	public Boolean activarcodigoVendedor=true;

	public Border resaltarnombreVendedor=null;
	public Boolean mostrarnombreVendedor=true;
	public Boolean activarnombreVendedor=true;

	public Border resaltarrucVendedor=null;
	public Boolean mostrarrucVendedor=true;
	public Boolean activarrucVendedor=true;

	public Border resaltaremailVendedor=null;
	public Boolean mostraremailVendedor=true;
	public Boolean activaremailVendedor=true;

	public Border resaltarid_empleadoVendedor=null;
	public Boolean mostrarid_empleadoVendedor=true;
	public Boolean activarid_empleadoVendedor=true;
	public Boolean cargarid_empleadoVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoVendedor=false;//ConEventDepend=true

	public Border resaltartelefonoVendedor=null;
	public Boolean mostrartelefonoVendedor=true;
	public Boolean activartelefonoVendedor=true;

	public Border resaltarid_empleado_soporteVendedor=null;
	public Boolean mostrarid_empleado_soporteVendedor=true;
	public Boolean activarid_empleado_soporteVendedor=true;
	public Boolean cargarid_empleado_soporteVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_soporteVendedor=false;//ConEventDepend=true

	public Border resaltarid_vendedorVendedor=null;
	public Boolean mostrarid_vendedorVendedor=true;
	public Boolean activarid_vendedorVendedor=true;
	public Boolean cargarid_vendedorVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorVendedor=false;//ConEventDepend=true

	public Border resaltarid_paisVendedor=null;
	public Boolean mostrarid_paisVendedor=true;
	public Boolean activarid_paisVendedor=true;
	public Boolean cargarid_paisVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisVendedor=false;//ConEventDepend=true

	public Border resaltarid_ciudadVendedor=null;
	public Boolean mostrarid_ciudadVendedor=true;
	public Boolean activarid_ciudadVendedor=true;
	public Boolean cargarid_ciudadVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadVendedor=true;//ConEventDepend=true

	public Border resaltarid_zonaVendedor=null;
	public Boolean mostrarid_zonaVendedor=true;
	public Boolean activarid_zonaVendedor=true;
	public Boolean cargarid_zonaVendedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaVendedor=false;//ConEventDepend=true

	public Border resaltarrepresentanteVendedor=null;
	public Boolean mostrarrepresentanteVendedor=true;
	public Boolean activarrepresentanteVendedor=true;

	public Border resaltares_supervisorVendedor=null;
	public Boolean mostrares_supervisorVendedor=true;
	public Boolean activares_supervisorVendedor=true;

	public Border resaltarfecha_creacionVendedor=null;
	public Boolean mostrarfecha_creacionVendedor=true;
	public Boolean activarfecha_creacionVendedor=false;

	public Border resaltardireccion_domicilioVendedor=null;
	public Boolean mostrardireccion_domicilioVendedor=true;
	public Boolean activardireccion_domicilioVendedor=true;

	public Border resaltardireccion_referenciaVendedor=null;
	public Boolean mostrardireccion_referenciaVendedor=true;
	public Boolean activardireccion_referenciaVendedor=true;

	public Border resaltardescripcionVendedor=null;
	public Boolean mostrardescripcionVendedor=true;
	public Boolean activardescripcionVendedor=true;

	public Border resaltarporcentaje_comisionVendedor=null;
	public Boolean mostrarporcentaje_comisionVendedor=true;
	public Boolean activarporcentaje_comisionVendedor=true;

	public Border resaltarcomisionVendedor=null;
	public Boolean mostrarcomisionVendedor=true;
	public Boolean activarcomisionVendedor=true;

	public Border resaltarmonto_vendidoVendedor=null;
	public Boolean mostrarmonto_vendidoVendedor=true;
	public Boolean activarmonto_vendidoVendedor=false;

	public Border resaltarnumero_facturasVendedor=null;
	public Boolean mostrarnumero_facturasVendedor=true;
	public Boolean activarnumero_facturasVendedor=false;

	public Border resaltarfecha_ultima_ventaVendedor=null;
	public Boolean mostrarfecha_ultima_ventaVendedor=true;
	public Boolean activarfecha_ultima_ventaVendedor=false;

	public Border resaltarmonto_ultima_ventaVendedor=null;
	public Boolean mostrarmonto_ultima_ventaVendedor=true;
	public Boolean activarmonto_ultima_ventaVendedor=false;

	public Border resaltarcon_presupuestoVendedor=null;
	public Boolean mostrarcon_presupuestoVendedor=true;
	public Boolean activarcon_presupuestoVendedor=true;

	public Border resaltarcon_coberturaVendedor=null;
	public Boolean mostrarcon_coberturaVendedor=true;
	public Boolean activarcon_coberturaVendedor=true;

	
	

	public Border setResaltaridVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltaridVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVendedor() {
		return this.resaltaridVendedor;
	}

	public void setResaltaridVendedor(Border borderResaltar) {
		this.resaltaridVendedor= borderResaltar;
	}

	public Boolean getMostraridVendedor() {
		return this.mostraridVendedor;
	}

	public void setMostraridVendedor(Boolean mostraridVendedor) {
		this.mostraridVendedor= mostraridVendedor;
	}

	public Boolean getActivaridVendedor() {
		return this.activaridVendedor;
	}

	public void setActivaridVendedor(Boolean activaridVendedor) {
		this.activaridVendedor= activaridVendedor;
	}

	public Border setResaltarid_empresaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVendedor() {
		return this.resaltarid_empresaVendedor;
	}

	public void setResaltarid_empresaVendedor(Border borderResaltar) {
		this.resaltarid_empresaVendedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaVendedor() {
		return this.mostrarid_empresaVendedor;
	}

	public void setMostrarid_empresaVendedor(Boolean mostrarid_empresaVendedor) {
		this.mostrarid_empresaVendedor= mostrarid_empresaVendedor;
	}

	public Boolean getActivarid_empresaVendedor() {
		return this.activarid_empresaVendedor;
	}

	public void setActivarid_empresaVendedor(Boolean activarid_empresaVendedor) {
		this.activarid_empresaVendedor= activarid_empresaVendedor;
	}

	public Boolean getCargarid_empresaVendedor() {
		return this.cargarid_empresaVendedor;
	}

	public void setCargarid_empresaVendedor(Boolean cargarid_empresaVendedor) {
		this.cargarid_empresaVendedor= cargarid_empresaVendedor;
	}

	public Border setResaltarid_sucursalVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVendedor() {
		return this.resaltarid_sucursalVendedor;
	}

	public void setResaltarid_sucursalVendedor(Border borderResaltar) {
		this.resaltarid_sucursalVendedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVendedor() {
		return this.mostrarid_sucursalVendedor;
	}

	public void setMostrarid_sucursalVendedor(Boolean mostrarid_sucursalVendedor) {
		this.mostrarid_sucursalVendedor= mostrarid_sucursalVendedor;
	}

	public Boolean getActivarid_sucursalVendedor() {
		return this.activarid_sucursalVendedor;
	}

	public void setActivarid_sucursalVendedor(Boolean activarid_sucursalVendedor) {
		this.activarid_sucursalVendedor= activarid_sucursalVendedor;
	}

	public Boolean getCargarid_sucursalVendedor() {
		return this.cargarid_sucursalVendedor;
	}

	public void setCargarid_sucursalVendedor(Boolean cargarid_sucursalVendedor) {
		this.cargarid_sucursalVendedor= cargarid_sucursalVendedor;
	}

	public Border setResaltarcodigoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarcodigoVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoVendedor() {
		return this.resaltarcodigoVendedor;
	}

	public void setResaltarcodigoVendedor(Border borderResaltar) {
		this.resaltarcodigoVendedor= borderResaltar;
	}

	public Boolean getMostrarcodigoVendedor() {
		return this.mostrarcodigoVendedor;
	}

	public void setMostrarcodigoVendedor(Boolean mostrarcodigoVendedor) {
		this.mostrarcodigoVendedor= mostrarcodigoVendedor;
	}

	public Boolean getActivarcodigoVendedor() {
		return this.activarcodigoVendedor;
	}

	public void setActivarcodigoVendedor(Boolean activarcodigoVendedor) {
		this.activarcodigoVendedor= activarcodigoVendedor;
	}

	public Border setResaltarnombreVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarnombreVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreVendedor() {
		return this.resaltarnombreVendedor;
	}

	public void setResaltarnombreVendedor(Border borderResaltar) {
		this.resaltarnombreVendedor= borderResaltar;
	}

	public Boolean getMostrarnombreVendedor() {
		return this.mostrarnombreVendedor;
	}

	public void setMostrarnombreVendedor(Boolean mostrarnombreVendedor) {
		this.mostrarnombreVendedor= mostrarnombreVendedor;
	}

	public Boolean getActivarnombreVendedor() {
		return this.activarnombreVendedor;
	}

	public void setActivarnombreVendedor(Boolean activarnombreVendedor) {
		this.activarnombreVendedor= activarnombreVendedor;
	}

	public Border setResaltarrucVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarrucVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucVendedor() {
		return this.resaltarrucVendedor;
	}

	public void setResaltarrucVendedor(Border borderResaltar) {
		this.resaltarrucVendedor= borderResaltar;
	}

	public Boolean getMostrarrucVendedor() {
		return this.mostrarrucVendedor;
	}

	public void setMostrarrucVendedor(Boolean mostrarrucVendedor) {
		this.mostrarrucVendedor= mostrarrucVendedor;
	}

	public Boolean getActivarrucVendedor() {
		return this.activarrucVendedor;
	}

	public void setActivarrucVendedor(Boolean activarrucVendedor) {
		this.activarrucVendedor= activarrucVendedor;
	}

	public Border setResaltaremailVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltaremailVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailVendedor() {
		return this.resaltaremailVendedor;
	}

	public void setResaltaremailVendedor(Border borderResaltar) {
		this.resaltaremailVendedor= borderResaltar;
	}

	public Boolean getMostraremailVendedor() {
		return this.mostraremailVendedor;
	}

	public void setMostraremailVendedor(Boolean mostraremailVendedor) {
		this.mostraremailVendedor= mostraremailVendedor;
	}

	public Boolean getActivaremailVendedor() {
		return this.activaremailVendedor;
	}

	public void setActivaremailVendedor(Boolean activaremailVendedor) {
		this.activaremailVendedor= activaremailVendedor;
	}

	public Border setResaltarid_empleadoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_empleadoVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoVendedor() {
		return this.resaltarid_empleadoVendedor;
	}

	public void setResaltarid_empleadoVendedor(Border borderResaltar) {
		this.resaltarid_empleadoVendedor= borderResaltar;
	}

	public Boolean getMostrarid_empleadoVendedor() {
		return this.mostrarid_empleadoVendedor;
	}

	public void setMostrarid_empleadoVendedor(Boolean mostrarid_empleadoVendedor) {
		this.mostrarid_empleadoVendedor= mostrarid_empleadoVendedor;
	}

	public Boolean getActivarid_empleadoVendedor() {
		return this.activarid_empleadoVendedor;
	}

	public void setActivarid_empleadoVendedor(Boolean activarid_empleadoVendedor) {
		this.activarid_empleadoVendedor= activarid_empleadoVendedor;
	}

	public Boolean getCargarid_empleadoVendedor() {
		return this.cargarid_empleadoVendedor;
	}

	public void setCargarid_empleadoVendedor(Boolean cargarid_empleadoVendedor) {
		this.cargarid_empleadoVendedor= cargarid_empleadoVendedor;
	}

	public Border setResaltartelefonoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltartelefonoVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoVendedor() {
		return this.resaltartelefonoVendedor;
	}

	public void setResaltartelefonoVendedor(Border borderResaltar) {
		this.resaltartelefonoVendedor= borderResaltar;
	}

	public Boolean getMostrartelefonoVendedor() {
		return this.mostrartelefonoVendedor;
	}

	public void setMostrartelefonoVendedor(Boolean mostrartelefonoVendedor) {
		this.mostrartelefonoVendedor= mostrartelefonoVendedor;
	}

	public Boolean getActivartelefonoVendedor() {
		return this.activartelefonoVendedor;
	}

	public void setActivartelefonoVendedor(Boolean activartelefonoVendedor) {
		this.activartelefonoVendedor= activartelefonoVendedor;
	}

	public Border setResaltarid_empleado_soporteVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_empleado_soporteVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_soporteVendedor() {
		return this.resaltarid_empleado_soporteVendedor;
	}

	public void setResaltarid_empleado_soporteVendedor(Border borderResaltar) {
		this.resaltarid_empleado_soporteVendedor= borderResaltar;
	}

	public Boolean getMostrarid_empleado_soporteVendedor() {
		return this.mostrarid_empleado_soporteVendedor;
	}

	public void setMostrarid_empleado_soporteVendedor(Boolean mostrarid_empleado_soporteVendedor) {
		this.mostrarid_empleado_soporteVendedor= mostrarid_empleado_soporteVendedor;
	}

	public Boolean getActivarid_empleado_soporteVendedor() {
		return this.activarid_empleado_soporteVendedor;
	}

	public void setActivarid_empleado_soporteVendedor(Boolean activarid_empleado_soporteVendedor) {
		this.activarid_empleado_soporteVendedor= activarid_empleado_soporteVendedor;
	}

	public Boolean getCargarid_empleado_soporteVendedor() {
		return this.cargarid_empleado_soporteVendedor;
	}

	public void setCargarid_empleado_soporteVendedor(Boolean cargarid_empleado_soporteVendedor) {
		this.cargarid_empleado_soporteVendedor= cargarid_empleado_soporteVendedor;
	}

	public Border setResaltarid_vendedorVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_vendedorVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorVendedor() {
		return this.resaltarid_vendedorVendedor;
	}

	public void setResaltarid_vendedorVendedor(Border borderResaltar) {
		this.resaltarid_vendedorVendedor= borderResaltar;
	}

	public Boolean getMostrarid_vendedorVendedor() {
		return this.mostrarid_vendedorVendedor;
	}

	public void setMostrarid_vendedorVendedor(Boolean mostrarid_vendedorVendedor) {
		this.mostrarid_vendedorVendedor= mostrarid_vendedorVendedor;
	}

	public Boolean getActivarid_vendedorVendedor() {
		return this.activarid_vendedorVendedor;
	}

	public void setActivarid_vendedorVendedor(Boolean activarid_vendedorVendedor) {
		this.activarid_vendedorVendedor= activarid_vendedorVendedor;
	}

	public Boolean getCargarid_vendedorVendedor() {
		return this.cargarid_vendedorVendedor;
	}

	public void setCargarid_vendedorVendedor(Boolean cargarid_vendedorVendedor) {
		this.cargarid_vendedorVendedor= cargarid_vendedorVendedor;
	}

	public Border setResaltarid_paisVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_paisVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisVendedor() {
		return this.resaltarid_paisVendedor;
	}

	public void setResaltarid_paisVendedor(Border borderResaltar) {
		this.resaltarid_paisVendedor= borderResaltar;
	}

	public Boolean getMostrarid_paisVendedor() {
		return this.mostrarid_paisVendedor;
	}

	public void setMostrarid_paisVendedor(Boolean mostrarid_paisVendedor) {
		this.mostrarid_paisVendedor= mostrarid_paisVendedor;
	}

	public Boolean getActivarid_paisVendedor() {
		return this.activarid_paisVendedor;
	}

	public void setActivarid_paisVendedor(Boolean activarid_paisVendedor) {
		this.activarid_paisVendedor= activarid_paisVendedor;
	}

	public Boolean getCargarid_paisVendedor() {
		return this.cargarid_paisVendedor;
	}

	public void setCargarid_paisVendedor(Boolean cargarid_paisVendedor) {
		this.cargarid_paisVendedor= cargarid_paisVendedor;
	}

	public Border setResaltarid_ciudadVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_ciudadVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadVendedor() {
		return this.resaltarid_ciudadVendedor;
	}

	public void setResaltarid_ciudadVendedor(Border borderResaltar) {
		this.resaltarid_ciudadVendedor= borderResaltar;
	}

	public Boolean getMostrarid_ciudadVendedor() {
		return this.mostrarid_ciudadVendedor;
	}

	public void setMostrarid_ciudadVendedor(Boolean mostrarid_ciudadVendedor) {
		this.mostrarid_ciudadVendedor= mostrarid_ciudadVendedor;
	}

	public Boolean getActivarid_ciudadVendedor() {
		return this.activarid_ciudadVendedor;
	}

	public void setActivarid_ciudadVendedor(Boolean activarid_ciudadVendedor) {
		this.activarid_ciudadVendedor= activarid_ciudadVendedor;
	}

	public Boolean getCargarid_ciudadVendedor() {
		return this.cargarid_ciudadVendedor;
	}

	public void setCargarid_ciudadVendedor(Boolean cargarid_ciudadVendedor) {
		this.cargarid_ciudadVendedor= cargarid_ciudadVendedor;
	}

	public Border setResaltarid_zonaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarid_zonaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaVendedor() {
		return this.resaltarid_zonaVendedor;
	}

	public void setResaltarid_zonaVendedor(Border borderResaltar) {
		this.resaltarid_zonaVendedor= borderResaltar;
	}

	public Boolean getMostrarid_zonaVendedor() {
		return this.mostrarid_zonaVendedor;
	}

	public void setMostrarid_zonaVendedor(Boolean mostrarid_zonaVendedor) {
		this.mostrarid_zonaVendedor= mostrarid_zonaVendedor;
	}

	public Boolean getActivarid_zonaVendedor() {
		return this.activarid_zonaVendedor;
	}

	public void setActivarid_zonaVendedor(Boolean activarid_zonaVendedor) {
		this.activarid_zonaVendedor= activarid_zonaVendedor;
	}

	public Boolean getCargarid_zonaVendedor() {
		return this.cargarid_zonaVendedor;
	}

	public void setCargarid_zonaVendedor(Boolean cargarid_zonaVendedor) {
		this.cargarid_zonaVendedor= cargarid_zonaVendedor;
	}

	public Border setResaltarrepresentanteVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarrepresentanteVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentanteVendedor() {
		return this.resaltarrepresentanteVendedor;
	}

	public void setResaltarrepresentanteVendedor(Border borderResaltar) {
		this.resaltarrepresentanteVendedor= borderResaltar;
	}

	public Boolean getMostrarrepresentanteVendedor() {
		return this.mostrarrepresentanteVendedor;
	}

	public void setMostrarrepresentanteVendedor(Boolean mostrarrepresentanteVendedor) {
		this.mostrarrepresentanteVendedor= mostrarrepresentanteVendedor;
	}

	public Boolean getActivarrepresentanteVendedor() {
		return this.activarrepresentanteVendedor;
	}

	public void setActivarrepresentanteVendedor(Boolean activarrepresentanteVendedor) {
		this.activarrepresentanteVendedor= activarrepresentanteVendedor;
	}

	public Border setResaltares_supervisorVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltares_supervisorVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_supervisorVendedor() {
		return this.resaltares_supervisorVendedor;
	}

	public void setResaltares_supervisorVendedor(Border borderResaltar) {
		this.resaltares_supervisorVendedor= borderResaltar;
	}

	public Boolean getMostrares_supervisorVendedor() {
		return this.mostrares_supervisorVendedor;
	}

	public void setMostrares_supervisorVendedor(Boolean mostrares_supervisorVendedor) {
		this.mostrares_supervisorVendedor= mostrares_supervisorVendedor;
	}

	public Boolean getActivares_supervisorVendedor() {
		return this.activares_supervisorVendedor;
	}

	public void setActivares_supervisorVendedor(Boolean activares_supervisorVendedor) {
		this.activares_supervisorVendedor= activares_supervisorVendedor;
	}

	public Border setResaltarfecha_creacionVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarfecha_creacionVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_creacionVendedor() {
		return this.resaltarfecha_creacionVendedor;
	}

	public void setResaltarfecha_creacionVendedor(Border borderResaltar) {
		this.resaltarfecha_creacionVendedor= borderResaltar;
	}

	public Boolean getMostrarfecha_creacionVendedor() {
		return this.mostrarfecha_creacionVendedor;
	}

	public void setMostrarfecha_creacionVendedor(Boolean mostrarfecha_creacionVendedor) {
		this.mostrarfecha_creacionVendedor= mostrarfecha_creacionVendedor;
	}

	public Boolean getActivarfecha_creacionVendedor() {
		return this.activarfecha_creacionVendedor;
	}

	public void setActivarfecha_creacionVendedor(Boolean activarfecha_creacionVendedor) {
		this.activarfecha_creacionVendedor= activarfecha_creacionVendedor;
	}

	public Border setResaltardireccion_domicilioVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltardireccion_domicilioVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_domicilioVendedor() {
		return this.resaltardireccion_domicilioVendedor;
	}

	public void setResaltardireccion_domicilioVendedor(Border borderResaltar) {
		this.resaltardireccion_domicilioVendedor= borderResaltar;
	}

	public Boolean getMostrardireccion_domicilioVendedor() {
		return this.mostrardireccion_domicilioVendedor;
	}

	public void setMostrardireccion_domicilioVendedor(Boolean mostrardireccion_domicilioVendedor) {
		this.mostrardireccion_domicilioVendedor= mostrardireccion_domicilioVendedor;
	}

	public Boolean getActivardireccion_domicilioVendedor() {
		return this.activardireccion_domicilioVendedor;
	}

	public void setActivardireccion_domicilioVendedor(Boolean activardireccion_domicilioVendedor) {
		this.activardireccion_domicilioVendedor= activardireccion_domicilioVendedor;
	}

	public Border setResaltardireccion_referenciaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltardireccion_referenciaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_referenciaVendedor() {
		return this.resaltardireccion_referenciaVendedor;
	}

	public void setResaltardireccion_referenciaVendedor(Border borderResaltar) {
		this.resaltardireccion_referenciaVendedor= borderResaltar;
	}

	public Boolean getMostrardireccion_referenciaVendedor() {
		return this.mostrardireccion_referenciaVendedor;
	}

	public void setMostrardireccion_referenciaVendedor(Boolean mostrardireccion_referenciaVendedor) {
		this.mostrardireccion_referenciaVendedor= mostrardireccion_referenciaVendedor;
	}

	public Boolean getActivardireccion_referenciaVendedor() {
		return this.activardireccion_referenciaVendedor;
	}

	public void setActivardireccion_referenciaVendedor(Boolean activardireccion_referenciaVendedor) {
		this.activardireccion_referenciaVendedor= activardireccion_referenciaVendedor;
	}

	public Border setResaltardescripcionVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltardescripcionVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionVendedor() {
		return this.resaltardescripcionVendedor;
	}

	public void setResaltardescripcionVendedor(Border borderResaltar) {
		this.resaltardescripcionVendedor= borderResaltar;
	}

	public Boolean getMostrardescripcionVendedor() {
		return this.mostrardescripcionVendedor;
	}

	public void setMostrardescripcionVendedor(Boolean mostrardescripcionVendedor) {
		this.mostrardescripcionVendedor= mostrardescripcionVendedor;
	}

	public Boolean getActivardescripcionVendedor() {
		return this.activardescripcionVendedor;
	}

	public void setActivardescripcionVendedor(Boolean activardescripcionVendedor) {
		this.activardescripcionVendedor= activardescripcionVendedor;
	}

	public Border setResaltarporcentaje_comisionVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_comisionVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_comisionVendedor() {
		return this.resaltarporcentaje_comisionVendedor;
	}

	public void setResaltarporcentaje_comisionVendedor(Border borderResaltar) {
		this.resaltarporcentaje_comisionVendedor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_comisionVendedor() {
		return this.mostrarporcentaje_comisionVendedor;
	}

	public void setMostrarporcentaje_comisionVendedor(Boolean mostrarporcentaje_comisionVendedor) {
		this.mostrarporcentaje_comisionVendedor= mostrarporcentaje_comisionVendedor;
	}

	public Boolean getActivarporcentaje_comisionVendedor() {
		return this.activarporcentaje_comisionVendedor;
	}

	public void setActivarporcentaje_comisionVendedor(Boolean activarporcentaje_comisionVendedor) {
		this.activarporcentaje_comisionVendedor= activarporcentaje_comisionVendedor;
	}

	public Border setResaltarcomisionVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarcomisionVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcomisionVendedor() {
		return this.resaltarcomisionVendedor;
	}

	public void setResaltarcomisionVendedor(Border borderResaltar) {
		this.resaltarcomisionVendedor= borderResaltar;
	}

	public Boolean getMostrarcomisionVendedor() {
		return this.mostrarcomisionVendedor;
	}

	public void setMostrarcomisionVendedor(Boolean mostrarcomisionVendedor) {
		this.mostrarcomisionVendedor= mostrarcomisionVendedor;
	}

	public Boolean getActivarcomisionVendedor() {
		return this.activarcomisionVendedor;
	}

	public void setActivarcomisionVendedor(Boolean activarcomisionVendedor) {
		this.activarcomisionVendedor= activarcomisionVendedor;
	}

	public Border setResaltarmonto_vendidoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarmonto_vendidoVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_vendidoVendedor() {
		return this.resaltarmonto_vendidoVendedor;
	}

	public void setResaltarmonto_vendidoVendedor(Border borderResaltar) {
		this.resaltarmonto_vendidoVendedor= borderResaltar;
	}

	public Boolean getMostrarmonto_vendidoVendedor() {
		return this.mostrarmonto_vendidoVendedor;
	}

	public void setMostrarmonto_vendidoVendedor(Boolean mostrarmonto_vendidoVendedor) {
		this.mostrarmonto_vendidoVendedor= mostrarmonto_vendidoVendedor;
	}

	public Boolean getActivarmonto_vendidoVendedor() {
		return this.activarmonto_vendidoVendedor;
	}

	public void setActivarmonto_vendidoVendedor(Boolean activarmonto_vendidoVendedor) {
		this.activarmonto_vendidoVendedor= activarmonto_vendidoVendedor;
	}

	public Border setResaltarnumero_facturasVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarnumero_facturasVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturasVendedor() {
		return this.resaltarnumero_facturasVendedor;
	}

	public void setResaltarnumero_facturasVendedor(Border borderResaltar) {
		this.resaltarnumero_facturasVendedor= borderResaltar;
	}

	public Boolean getMostrarnumero_facturasVendedor() {
		return this.mostrarnumero_facturasVendedor;
	}

	public void setMostrarnumero_facturasVendedor(Boolean mostrarnumero_facturasVendedor) {
		this.mostrarnumero_facturasVendedor= mostrarnumero_facturasVendedor;
	}

	public Boolean getActivarnumero_facturasVendedor() {
		return this.activarnumero_facturasVendedor;
	}

	public void setActivarnumero_facturasVendedor(Boolean activarnumero_facturasVendedor) {
		this.activarnumero_facturasVendedor= activarnumero_facturasVendedor;
	}

	public Border setResaltarfecha_ultima_ventaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_ventaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_ventaVendedor() {
		return this.resaltarfecha_ultima_ventaVendedor;
	}

	public void setResaltarfecha_ultima_ventaVendedor(Border borderResaltar) {
		this.resaltarfecha_ultima_ventaVendedor= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_ventaVendedor() {
		return this.mostrarfecha_ultima_ventaVendedor;
	}

	public void setMostrarfecha_ultima_ventaVendedor(Boolean mostrarfecha_ultima_ventaVendedor) {
		this.mostrarfecha_ultima_ventaVendedor= mostrarfecha_ultima_ventaVendedor;
	}

	public Boolean getActivarfecha_ultima_ventaVendedor() {
		return this.activarfecha_ultima_ventaVendedor;
	}

	public void setActivarfecha_ultima_ventaVendedor(Boolean activarfecha_ultima_ventaVendedor) {
		this.activarfecha_ultima_ventaVendedor= activarfecha_ultima_ventaVendedor;
	}

	public Border setResaltarmonto_ultima_ventaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarmonto_ultima_ventaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ultima_ventaVendedor() {
		return this.resaltarmonto_ultima_ventaVendedor;
	}

	public void setResaltarmonto_ultima_ventaVendedor(Border borderResaltar) {
		this.resaltarmonto_ultima_ventaVendedor= borderResaltar;
	}

	public Boolean getMostrarmonto_ultima_ventaVendedor() {
		return this.mostrarmonto_ultima_ventaVendedor;
	}

	public void setMostrarmonto_ultima_ventaVendedor(Boolean mostrarmonto_ultima_ventaVendedor) {
		this.mostrarmonto_ultima_ventaVendedor= mostrarmonto_ultima_ventaVendedor;
	}

	public Boolean getActivarmonto_ultima_ventaVendedor() {
		return this.activarmonto_ultima_ventaVendedor;
	}

	public void setActivarmonto_ultima_ventaVendedor(Boolean activarmonto_ultima_ventaVendedor) {
		this.activarmonto_ultima_ventaVendedor= activarmonto_ultima_ventaVendedor;
	}

	public Border setResaltarcon_presupuestoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarcon_presupuestoVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_presupuestoVendedor() {
		return this.resaltarcon_presupuestoVendedor;
	}

	public void setResaltarcon_presupuestoVendedor(Border borderResaltar) {
		this.resaltarcon_presupuestoVendedor= borderResaltar;
	}

	public Boolean getMostrarcon_presupuestoVendedor() {
		return this.mostrarcon_presupuestoVendedor;
	}

	public void setMostrarcon_presupuestoVendedor(Boolean mostrarcon_presupuestoVendedor) {
		this.mostrarcon_presupuestoVendedor= mostrarcon_presupuestoVendedor;
	}

	public Boolean getActivarcon_presupuestoVendedor() {
		return this.activarcon_presupuestoVendedor;
	}

	public void setActivarcon_presupuestoVendedor(Boolean activarcon_presupuestoVendedor) {
		this.activarcon_presupuestoVendedor= activarcon_presupuestoVendedor;
	}

	public Border setResaltarcon_coberturaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltar);
		
		this.resaltarcon_coberturaVendedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_coberturaVendedor() {
		return this.resaltarcon_coberturaVendedor;
	}

	public void setResaltarcon_coberturaVendedor(Border borderResaltar) {
		this.resaltarcon_coberturaVendedor= borderResaltar;
	}

	public Boolean getMostrarcon_coberturaVendedor() {
		return this.mostrarcon_coberturaVendedor;
	}

	public void setMostrarcon_coberturaVendedor(Boolean mostrarcon_coberturaVendedor) {
		this.mostrarcon_coberturaVendedor= mostrarcon_coberturaVendedor;
	}

	public Boolean getActivarcon_coberturaVendedor() {
		return this.activarcon_coberturaVendedor;
	}

	public void setActivarcon_coberturaVendedor(Boolean activarcon_coberturaVendedor) {
		this.activarcon_coberturaVendedor= activarcon_coberturaVendedor;
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
		
		
		this.setMostraridVendedor(esInicial);
		this.setMostrarid_empresaVendedor(esInicial);
		this.setMostrarid_sucursalVendedor(esInicial);
		this.setMostrarcodigoVendedor(esInicial);
		this.setMostrarnombreVendedor(esInicial);
		this.setMostrarrucVendedor(esInicial);
		this.setMostraremailVendedor(esInicial);
		this.setMostrarid_empleadoVendedor(esInicial);
		this.setMostrartelefonoVendedor(esInicial);
		this.setMostrarid_empleado_soporteVendedor(esInicial);
		this.setMostrarid_vendedorVendedor(esInicial);
		this.setMostrarid_paisVendedor(esInicial);
		this.setMostrarid_ciudadVendedor(esInicial);
		this.setMostrarid_zonaVendedor(esInicial);
		this.setMostrarrepresentanteVendedor(esInicial);
		this.setMostrares_supervisorVendedor(esInicial);
		this.setMostrarfecha_creacionVendedor(esInicial);
		this.setMostrardireccion_domicilioVendedor(esInicial);
		this.setMostrardireccion_referenciaVendedor(esInicial);
		this.setMostrardescripcionVendedor(esInicial);
		this.setMostrarporcentaje_comisionVendedor(esInicial);
		this.setMostrarcomisionVendedor(esInicial);
		this.setMostrarmonto_vendidoVendedor(esInicial);
		this.setMostrarnumero_facturasVendedor(esInicial);
		this.setMostrarfecha_ultima_ventaVendedor(esInicial);
		this.setMostrarmonto_ultima_ventaVendedor(esInicial);
		this.setMostrarcon_presupuestoVendedor(esInicial);
		this.setMostrarcon_coberturaVendedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorConstantesFunciones.ID)) {
				this.setMostraridVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.RUC)) {
				this.setMostrarrucVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.EMAIL)) {
				this.setMostraremailVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADOSOPORTE)) {
				this.setMostrarid_empleado_soporteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.REPRESENTANTE)) {
				this.setMostrarrepresentanteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.ESSUPERVISOR)) {
				this.setMostrares_supervisorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHACREACION)) {
				this.setMostrarfecha_creacionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setMostrardireccion_domicilioVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONREFERENCIA)) {
				this.setMostrardireccion_referenciaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.PORCENTAJECOMISION)) {
				this.setMostrarporcentaje_comisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.COMISION)) {
				this.setMostrarcomisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOVENDIDO)) {
				this.setMostrarmonto_vendidoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NUMEROFACTURAS)) {
				this.setMostrarnumero_facturasVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setMostrarfecha_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOULTIMAVENTA)) {
				this.setMostrarmonto_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONPRESUPUESTO)) {
				this.setMostrarcon_presupuestoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONCOBERTURA)) {
				this.setMostrarcon_coberturaVendedor(esAsigna);
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
		
		
		this.setActivaridVendedor(esInicial);
		this.setActivarid_empresaVendedor(esInicial);
		this.setActivarid_sucursalVendedor(esInicial);
		this.setActivarcodigoVendedor(esInicial);
		this.setActivarnombreVendedor(esInicial);
		this.setActivarrucVendedor(esInicial);
		this.setActivaremailVendedor(esInicial);
		this.setActivarid_empleadoVendedor(esInicial);
		this.setActivartelefonoVendedor(esInicial);
		this.setActivarid_empleado_soporteVendedor(esInicial);
		this.setActivarid_vendedorVendedor(esInicial);
		this.setActivarid_paisVendedor(esInicial);
		this.setActivarid_ciudadVendedor(esInicial);
		this.setActivarid_zonaVendedor(esInicial);
		this.setActivarrepresentanteVendedor(esInicial);
		this.setActivares_supervisorVendedor(esInicial);
		this.setActivarfecha_creacionVendedor(esInicial);
		this.setActivardireccion_domicilioVendedor(esInicial);
		this.setActivardireccion_referenciaVendedor(esInicial);
		this.setActivardescripcionVendedor(esInicial);
		this.setActivarporcentaje_comisionVendedor(esInicial);
		this.setActivarcomisionVendedor(esInicial);
		this.setActivarmonto_vendidoVendedor(esInicial);
		this.setActivarnumero_facturasVendedor(esInicial);
		this.setActivarfecha_ultima_ventaVendedor(esInicial);
		this.setActivarmonto_ultima_ventaVendedor(esInicial);
		this.setActivarcon_presupuestoVendedor(esInicial);
		this.setActivarcon_coberturaVendedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorConstantesFunciones.ID)) {
				this.setActivaridVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CODIGO)) {
				this.setActivarcodigoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.RUC)) {
				this.setActivarrucVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.EMAIL)) {
				this.setActivaremailVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADOSOPORTE)) {
				this.setActivarid_empleado_soporteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.REPRESENTANTE)) {
				this.setActivarrepresentanteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.ESSUPERVISOR)) {
				this.setActivares_supervisorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHACREACION)) {
				this.setActivarfecha_creacionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setActivardireccion_domicilioVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONREFERENCIA)) {
				this.setActivardireccion_referenciaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.PORCENTAJECOMISION)) {
				this.setActivarporcentaje_comisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.COMISION)) {
				this.setActivarcomisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOVENDIDO)) {
				this.setActivarmonto_vendidoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NUMEROFACTURAS)) {
				this.setActivarnumero_facturasVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setActivarfecha_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOULTIMAVENTA)) {
				this.setActivarmonto_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONPRESUPUESTO)) {
				this.setActivarcon_presupuestoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONCOBERTURA)) {
				this.setActivarcon_coberturaVendedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVendedor(esInicial);
		this.setResaltarid_empresaVendedor(esInicial);
		this.setResaltarid_sucursalVendedor(esInicial);
		this.setResaltarcodigoVendedor(esInicial);
		this.setResaltarnombreVendedor(esInicial);
		this.setResaltarrucVendedor(esInicial);
		this.setResaltaremailVendedor(esInicial);
		this.setResaltarid_empleadoVendedor(esInicial);
		this.setResaltartelefonoVendedor(esInicial);
		this.setResaltarid_empleado_soporteVendedor(esInicial);
		this.setResaltarid_vendedorVendedor(esInicial);
		this.setResaltarid_paisVendedor(esInicial);
		this.setResaltarid_ciudadVendedor(esInicial);
		this.setResaltarid_zonaVendedor(esInicial);
		this.setResaltarrepresentanteVendedor(esInicial);
		this.setResaltares_supervisorVendedor(esInicial);
		this.setResaltarfecha_creacionVendedor(esInicial);
		this.setResaltardireccion_domicilioVendedor(esInicial);
		this.setResaltardireccion_referenciaVendedor(esInicial);
		this.setResaltardescripcionVendedor(esInicial);
		this.setResaltarporcentaje_comisionVendedor(esInicial);
		this.setResaltarcomisionVendedor(esInicial);
		this.setResaltarmonto_vendidoVendedor(esInicial);
		this.setResaltarnumero_facturasVendedor(esInicial);
		this.setResaltarfecha_ultima_ventaVendedor(esInicial);
		this.setResaltarmonto_ultima_ventaVendedor(esInicial);
		this.setResaltarcon_presupuestoVendedor(esInicial);
		this.setResaltarcon_coberturaVendedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorConstantesFunciones.ID)) {
				this.setResaltaridVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.RUC)) {
				this.setResaltarrucVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.EMAIL)) {
				this.setResaltaremailVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDEMPLEADOSOPORTE)) {
				this.setResaltarid_empleado_soporteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.REPRESENTANTE)) {
				this.setResaltarrepresentanteVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.ESSUPERVISOR)) {
				this.setResaltares_supervisorVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHACREACION)) {
				this.setResaltarfecha_creacionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setResaltardireccion_domicilioVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DIRECCIONREFERENCIA)) {
				this.setResaltardireccion_referenciaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.PORCENTAJECOMISION)) {
				this.setResaltarporcentaje_comisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.COMISION)) {
				this.setResaltarcomisionVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOVENDIDO)) {
				this.setResaltarmonto_vendidoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.NUMEROFACTURAS)) {
				this.setResaltarnumero_facturasVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setResaltarfecha_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.MONTOULTIMAVENTA)) {
				this.setResaltarmonto_ultima_ventaVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONPRESUPUESTO)) {
				this.setResaltarcon_presupuestoVendedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorConstantesFunciones.CONCOBERTURA)) {
				this.setResaltarcon_coberturaVendedor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNotaCreditoSoliVendedor=null;

	public Border getResaltarNotaCreditoSoliVendedor() {
		return this.resaltarNotaCreditoSoliVendedor;
	}

	public void setResaltarNotaCreditoSoliVendedor(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliVendedor= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliVendedor= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliVendedor=true;

	public Boolean getMostrarNotaCreditoSoliVendedor() {
		return this.mostrarNotaCreditoSoliVendedor;
	}

	public void setMostrarNotaCreditoSoliVendedor(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliVendedor= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliVendedor=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliVendedor() {
		return this.activarNotaCreditoSoliVendedor;
	}

	public void setActivarNotaCreditoSoliVendedor(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliVendedor= habilitarResaltarNotaCreditoSoli;
	}


	public Border resaltarComisionVentaCobroVendedor=null;

	public Border getResaltarComisionVentaCobroVendedor() {
		return this.resaltarComisionVentaCobroVendedor;
	}

	public void setResaltarComisionVentaCobroVendedor(Border borderResaltarComisionVentaCobro) {
		if(borderResaltarComisionVentaCobro!=null) {
			this.resaltarComisionVentaCobroVendedor= borderResaltarComisionVentaCobro;
		}
	}

	public Border setResaltarComisionVentaCobroVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionVentaCobro=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarComisionVentaCobro);
			
		this.resaltarComisionVentaCobroVendedor= borderResaltarComisionVentaCobro;

		 return borderResaltarComisionVentaCobro;
	}



	public Boolean mostrarComisionVentaCobroVendedor=true;

	public Boolean getMostrarComisionVentaCobroVendedor() {
		return this.mostrarComisionVentaCobroVendedor;
	}

	public void setMostrarComisionVentaCobroVendedor(Boolean visibilidadResaltarComisionVentaCobro) {
		this.mostrarComisionVentaCobroVendedor= visibilidadResaltarComisionVentaCobro;
	}



	public Boolean activarComisionVentaCobroVendedor=true;

	public Boolean gethabilitarResaltarComisionVentaCobroVendedor() {
		return this.activarComisionVentaCobroVendedor;
	}

	public void setActivarComisionVentaCobroVendedor(Boolean habilitarResaltarComisionVentaCobro) {
		this.activarComisionVentaCobroVendedor= habilitarResaltarComisionVentaCobro;
	}


	public Border resaltarVendedorVendedor=null;

	public Border getResaltarVendedorVendedor() {
		return this.resaltarVendedorVendedor;
	}

	public void setResaltarVendedorVendedor(Border borderResaltarVendedor) {
		if(borderResaltarVendedor!=null) {
			this.resaltarVendedorVendedor= borderResaltarVendedor;
		}
	}

	public Border setResaltarVendedorVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarVendedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarVendedor);
			
		this.resaltarVendedorVendedor= borderResaltarVendedor;

		 return borderResaltarVendedor;
	}



	public Boolean mostrarVendedorVendedor=true;

	public Boolean getMostrarVendedorVendedor() {
		return this.mostrarVendedorVendedor;
	}

	public void setMostrarVendedorVendedor(Boolean visibilidadResaltarVendedor) {
		this.mostrarVendedorVendedor= visibilidadResaltarVendedor;
	}



	public Boolean activarVendedorVendedor=true;

	public Boolean gethabilitarResaltarVendedorVendedor() {
		return this.activarVendedorVendedor;
	}

	public void setActivarVendedorVendedor(Boolean habilitarResaltarVendedor) {
		this.activarVendedorVendedor= habilitarResaltarVendedor;
	}


	public Border resaltarClienteVendedor=null;

	public Border getResaltarClienteVendedor() {
		return this.resaltarClienteVendedor;
	}

	public void setResaltarClienteVendedor(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteVendedor= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarCliente);
			
		this.resaltarClienteVendedor= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteVendedor=true;

	public Boolean getMostrarClienteVendedor() {
		return this.mostrarClienteVendedor;
	}

	public void setMostrarClienteVendedor(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteVendedor= visibilidadResaltarCliente;
	}



	public Boolean activarClienteVendedor=true;

	public Boolean gethabilitarResaltarClienteVendedor() {
		return this.activarClienteVendedor;
	}

	public void setActivarClienteVendedor(Boolean habilitarResaltarCliente) {
		this.activarClienteVendedor= habilitarResaltarCliente;
	}


	public Border resaltarComisionGrupoVendedor=null;

	public Border getResaltarComisionGrupoVendedor() {
		return this.resaltarComisionGrupoVendedor;
	}

	public void setResaltarComisionGrupoVendedor(Border borderResaltarComisionGrupo) {
		if(borderResaltarComisionGrupo!=null) {
			this.resaltarComisionGrupoVendedor= borderResaltarComisionGrupo;
		}
	}

	public Border setResaltarComisionGrupoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionGrupo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarComisionGrupo);
			
		this.resaltarComisionGrupoVendedor= borderResaltarComisionGrupo;

		 return borderResaltarComisionGrupo;
	}



	public Boolean mostrarComisionGrupoVendedor=true;

	public Boolean getMostrarComisionGrupoVendedor() {
		return this.mostrarComisionGrupoVendedor;
	}

	public void setMostrarComisionGrupoVendedor(Boolean visibilidadResaltarComisionGrupo) {
		this.mostrarComisionGrupoVendedor= visibilidadResaltarComisionGrupo;
	}



	public Boolean activarComisionGrupoVendedor=true;

	public Boolean gethabilitarResaltarComisionGrupoVendedor() {
		return this.activarComisionGrupoVendedor;
	}

	public void setActivarComisionGrupoVendedor(Boolean habilitarResaltarComisionGrupo) {
		this.activarComisionGrupoVendedor= habilitarResaltarComisionGrupo;
	}


	public Border resaltarComisionLineaVendedor=null;

	public Border getResaltarComisionLineaVendedor() {
		return this.resaltarComisionLineaVendedor;
	}

	public void setResaltarComisionLineaVendedor(Border borderResaltarComisionLinea) {
		if(borderResaltarComisionLinea!=null) {
			this.resaltarComisionLineaVendedor= borderResaltarComisionLinea;
		}
	}

	public Border setResaltarComisionLineaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarComisionLinea);
			
		this.resaltarComisionLineaVendedor= borderResaltarComisionLinea;

		 return borderResaltarComisionLinea;
	}



	public Boolean mostrarComisionLineaVendedor=true;

	public Boolean getMostrarComisionLineaVendedor() {
		return this.mostrarComisionLineaVendedor;
	}

	public void setMostrarComisionLineaVendedor(Boolean visibilidadResaltarComisionLinea) {
		this.mostrarComisionLineaVendedor= visibilidadResaltarComisionLinea;
	}



	public Boolean activarComisionLineaVendedor=true;

	public Boolean gethabilitarResaltarComisionLineaVendedor() {
		return this.activarComisionLineaVendedor;
	}

	public void setActivarComisionLineaVendedor(Boolean habilitarResaltarComisionLinea) {
		this.activarComisionLineaVendedor= habilitarResaltarComisionLinea;
	}


	public Border resaltarVendedorZonaVendedor=null;

	public Border getResaltarVendedorZonaVendedor() {
		return this.resaltarVendedorZonaVendedor;
	}

	public void setResaltarVendedorZonaVendedor(Border borderResaltarVendedorZona) {
		if(borderResaltarVendedorZona!=null) {
			this.resaltarVendedorZonaVendedor= borderResaltarVendedorZona;
		}
	}

	public Border setResaltarVendedorZonaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarVendedorZona=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarVendedorZona);
			
		this.resaltarVendedorZonaVendedor= borderResaltarVendedorZona;

		 return borderResaltarVendedorZona;
	}



	public Boolean mostrarVendedorZonaVendedor=true;

	public Boolean getMostrarVendedorZonaVendedor() {
		return this.mostrarVendedorZonaVendedor;
	}

	public void setMostrarVendedorZonaVendedor(Boolean visibilidadResaltarVendedorZona) {
		this.mostrarVendedorZonaVendedor= visibilidadResaltarVendedorZona;
	}



	public Boolean activarVendedorZonaVendedor=true;

	public Boolean gethabilitarResaltarVendedorZonaVendedor() {
		return this.activarVendedorZonaVendedor;
	}

	public void setActivarVendedorZonaVendedor(Boolean habilitarResaltarVendedorZona) {
		this.activarVendedorZonaVendedor= habilitarResaltarVendedorZona;
	}


	public Border resaltarComisionCateVendedor=null;

	public Border getResaltarComisionCateVendedor() {
		return this.resaltarComisionCateVendedor;
	}

	public void setResaltarComisionCateVendedor(Border borderResaltarComisionCate) {
		if(borderResaltarComisionCate!=null) {
			this.resaltarComisionCateVendedor= borderResaltarComisionCate;
		}
	}

	public Border setResaltarComisionCateVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionCate=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarComisionCate);
			
		this.resaltarComisionCateVendedor= borderResaltarComisionCate;

		 return borderResaltarComisionCate;
	}



	public Boolean mostrarComisionCateVendedor=true;

	public Boolean getMostrarComisionCateVendedor() {
		return this.mostrarComisionCateVendedor;
	}

	public void setMostrarComisionCateVendedor(Boolean visibilidadResaltarComisionCate) {
		this.mostrarComisionCateVendedor= visibilidadResaltarComisionCate;
	}



	public Boolean activarComisionCateVendedor=true;

	public Boolean gethabilitarResaltarComisionCateVendedor() {
		return this.activarComisionCateVendedor;
	}

	public void setActivarComisionCateVendedor(Boolean habilitarResaltarComisionCate) {
		this.activarComisionCateVendedor= habilitarResaltarComisionCate;
	}


	public Border resaltarCajeroTurnoVendedor=null;

	public Border getResaltarCajeroTurnoVendedor() {
		return this.resaltarCajeroTurnoVendedor;
	}

	public void setResaltarCajeroTurnoVendedor(Border borderResaltarCajeroTurno) {
		if(borderResaltarCajeroTurno!=null) {
			this.resaltarCajeroTurnoVendedor= borderResaltarCajeroTurno;
		}
	}

	public Border setResaltarCajeroTurnoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarCajeroTurno=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarCajeroTurno);
			
		this.resaltarCajeroTurnoVendedor= borderResaltarCajeroTurno;

		 return borderResaltarCajeroTurno;
	}



	public Boolean mostrarCajeroTurnoVendedor=true;

	public Boolean getMostrarCajeroTurnoVendedor() {
		return this.mostrarCajeroTurnoVendedor;
	}

	public void setMostrarCajeroTurnoVendedor(Boolean visibilidadResaltarCajeroTurno) {
		this.mostrarCajeroTurnoVendedor= visibilidadResaltarCajeroTurno;
	}



	public Boolean activarCajeroTurnoVendedor=true;

	public Boolean gethabilitarResaltarCajeroTurnoVendedor() {
		return this.activarCajeroTurnoVendedor;
	}

	public void setActivarCajeroTurnoVendedor(Boolean habilitarResaltarCajeroTurno) {
		this.activarCajeroTurnoVendedor= habilitarResaltarCajeroTurno;
	}


	public Border resaltarComisionMarcaVendedor=null;

	public Border getResaltarComisionMarcaVendedor() {
		return this.resaltarComisionMarcaVendedor;
	}

	public void setResaltarComisionMarcaVendedor(Border borderResaltarComisionMarca) {
		if(borderResaltarComisionMarca!=null) {
			this.resaltarComisionMarcaVendedor= borderResaltarComisionMarca;
		}
	}

	public Border setResaltarComisionMarcaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionMarca=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarComisionMarca);
			
		this.resaltarComisionMarcaVendedor= borderResaltarComisionMarca;

		 return borderResaltarComisionMarca;
	}



	public Boolean mostrarComisionMarcaVendedor=true;

	public Boolean getMostrarComisionMarcaVendedor() {
		return this.mostrarComisionMarcaVendedor;
	}

	public void setMostrarComisionMarcaVendedor(Boolean visibilidadResaltarComisionMarca) {
		this.mostrarComisionMarcaVendedor= visibilidadResaltarComisionMarca;
	}



	public Boolean activarComisionMarcaVendedor=true;

	public Boolean gethabilitarResaltarComisionMarcaVendedor() {
		return this.activarComisionMarcaVendedor;
	}

	public void setActivarComisionMarcaVendedor(Boolean habilitarResaltarComisionMarca) {
		this.activarComisionMarcaVendedor= habilitarResaltarComisionMarca;
	}


	public Border resaltarPresupuestoVentasVendedor=null;

	public Border getResaltarPresupuestoVentasVendedor() {
		return this.resaltarPresupuestoVentasVendedor;
	}

	public void setResaltarPresupuestoVentasVendedor(Border borderResaltarPresupuestoVentas) {
		if(borderResaltarPresupuestoVentas!=null) {
			this.resaltarPresupuestoVentasVendedor= borderResaltarPresupuestoVentas;
		}
	}

	public Border setResaltarPresupuestoVentasVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarPresupuestoVentas);
			
		this.resaltarPresupuestoVentasVendedor= borderResaltarPresupuestoVentas;

		 return borderResaltarPresupuestoVentas;
	}



	public Boolean mostrarPresupuestoVentasVendedor=true;

	public Boolean getMostrarPresupuestoVentasVendedor() {
		return this.mostrarPresupuestoVentasVendedor;
	}

	public void setMostrarPresupuestoVentasVendedor(Boolean visibilidadResaltarPresupuestoVentas) {
		this.mostrarPresupuestoVentasVendedor= visibilidadResaltarPresupuestoVentas;
	}



	public Boolean activarPresupuestoVentasVendedor=true;

	public Boolean gethabilitarResaltarPresupuestoVentasVendedor() {
		return this.activarPresupuestoVentasVendedor;
	}

	public void setActivarPresupuestoVentasVendedor(Boolean habilitarResaltarPresupuestoVentas) {
		this.activarPresupuestoVentasVendedor= habilitarResaltarPresupuestoVentas;
	}


	public Border resaltarPresupuestoVentasLineasVendedor=null;

	public Border getResaltarPresupuestoVentasLineasVendedor() {
		return this.resaltarPresupuestoVentasLineasVendedor;
	}

	public void setResaltarPresupuestoVentasLineasVendedor(Border borderResaltarPresupuestoVentasLineas) {
		if(borderResaltarPresupuestoVentasLineas!=null) {
			this.resaltarPresupuestoVentasLineasVendedor= borderResaltarPresupuestoVentasLineas;
		}
	}

	public Border setResaltarPresupuestoVentasLineasVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentasLineas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vendedorBeanSwingJInternalFrame.jTtoolBarVendedor.setBorder(borderResaltarPresupuestoVentasLineas);
			
		this.resaltarPresupuestoVentasLineasVendedor= borderResaltarPresupuestoVentasLineas;

		 return borderResaltarPresupuestoVentasLineas;
	}



	public Boolean mostrarPresupuestoVentasLineasVendedor=true;

	public Boolean getMostrarPresupuestoVentasLineasVendedor() {
		return this.mostrarPresupuestoVentasLineasVendedor;
	}

	public void setMostrarPresupuestoVentasLineasVendedor(Boolean visibilidadResaltarPresupuestoVentasLineas) {
		this.mostrarPresupuestoVentasLineasVendedor= visibilidadResaltarPresupuestoVentasLineas;
	}



	public Boolean activarPresupuestoVentasLineasVendedor=true;

	public Boolean gethabilitarResaltarPresupuestoVentasLineasVendedor() {
		return this.activarPresupuestoVentasLineasVendedor;
	}

	public void setActivarPresupuestoVentasLineasVendedor(Boolean habilitarResaltarPresupuestoVentasLineas) {
		this.activarPresupuestoVentasLineasVendedor= habilitarResaltarPresupuestoVentasLineas;
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

		this.setMostrarNotaCreditoSoliVendedor(esInicial);
		this.setMostrarComisionVentaCobroVendedor(esInicial);
		this.setMostrarVendedorVendedor(esInicial);
		this.setMostrarClienteVendedor(esInicial);
		this.setMostrarComisionGrupoVendedor(esInicial);
		this.setMostrarComisionLineaVendedor(esInicial);
		this.setMostrarVendedorZonaVendedor(esInicial);
		this.setMostrarComisionCateVendedor(esInicial);
		this.setMostrarCajeroTurnoVendedor(esInicial);
		this.setMostrarComisionMarcaVendedor(esInicial);
		this.setMostrarPresupuestoVentasVendedor(esInicial);
		this.setMostrarPresupuestoVentasLineasVendedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionVentaCobro.class)) {
				this.setMostrarComisionVentaCobroVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setMostrarVendedorVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setMostrarComisionGrupoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setMostrarComisionLineaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setMostrarVendedorZonaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setMostrarComisionCateVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setMostrarCajeroTurnoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setMostrarComisionMarcaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setMostrarPresupuestoVentasVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setMostrarPresupuestoVentasLineasVendedor(esAsigna);
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

		this.setActivarNotaCreditoSoliVendedor(esInicial);
		this.setActivarComisionVentaCobroVendedor(esInicial);
		this.setActivarVendedorVendedor(esInicial);
		this.setActivarClienteVendedor(esInicial);
		this.setActivarComisionGrupoVendedor(esInicial);
		this.setActivarComisionLineaVendedor(esInicial);
		this.setActivarVendedorZonaVendedor(esInicial);
		this.setActivarComisionCateVendedor(esInicial);
		this.setActivarCajeroTurnoVendedor(esInicial);
		this.setActivarComisionMarcaVendedor(esInicial);
		this.setActivarPresupuestoVentasVendedor(esInicial);
		this.setActivarPresupuestoVentasLineasVendedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionVentaCobro.class)) {
				this.setActivarComisionVentaCobroVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setActivarVendedorVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setActivarComisionGrupoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setActivarComisionLineaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setActivarVendedorZonaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setActivarComisionCateVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setActivarCajeroTurnoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setActivarComisionMarcaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setActivarPresupuestoVentasVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setActivarPresupuestoVentasLineasVendedor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNotaCreditoSoliVendedor(esInicial);
		this.setResaltarComisionVentaCobroVendedor(esInicial);
		this.setResaltarVendedorVendedor(esInicial);
		this.setResaltarClienteVendedor(esInicial);
		this.setResaltarComisionGrupoVendedor(esInicial);
		this.setResaltarComisionLineaVendedor(esInicial);
		this.setResaltarVendedorZonaVendedor(esInicial);
		this.setResaltarComisionCateVendedor(esInicial);
		this.setResaltarCajeroTurnoVendedor(esInicial);
		this.setResaltarComisionMarcaVendedor(esInicial);
		this.setResaltarPresupuestoVentasVendedor(esInicial);
		this.setResaltarPresupuestoVentasLineasVendedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionVentaCobro.class)) {
				this.setResaltarComisionVentaCobroVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setResaltarVendedorVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setResaltarComisionGrupoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setResaltarComisionLineaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setResaltarVendedorZonaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setResaltarComisionCateVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setResaltarCajeroTurnoVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setResaltarComisionMarcaVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setResaltarPresupuestoVentasVendedor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setResaltarPresupuestoVentasLineasVendedor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoVendedor=true;

	public Boolean getMostrarBusquedaPorCodigoVendedor() {
		return this.mostrarBusquedaPorCodigoVendedor;
	}

	public void setMostrarBusquedaPorCodigoVendedor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoVendedor= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreVendedor=true;

	public Boolean getMostrarBusquedaPorNombreVendedor() {
		return this.mostrarBusquedaPorNombreVendedor;
	}

	public void setMostrarBusquedaPorNombreVendedor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreVendedor= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucVendedor=true;

	public Boolean getMostrarBusquedaPorRucVendedor() {
		return this.mostrarBusquedaPorRucVendedor;
	}

	public void setMostrarBusquedaPorRucVendedor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucVendedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVendedor=true;

	public Boolean getMostrarFK_IdEmpresaVendedor() {
		return this.mostrarFK_IdEmpresaVendedor;
	}

	public void setMostrarFK_IdEmpresaVendedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVendedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisVendedor=true;

	public Boolean getMostrarFK_IdPaisVendedor() {
		return this.mostrarFK_IdPaisVendedor;
	}

	public void setMostrarFK_IdPaisVendedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisVendedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalVendedor=true;

	public Boolean getMostrarFK_IdSucursalVendedor() {
		return this.mostrarFK_IdSucursalVendedor;
	}

	public void setMostrarFK_IdSucursalVendedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalVendedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorVendedor=true;

	public Boolean getMostrarFK_IdVendedorVendedor() {
		return this.mostrarFK_IdVendedorVendedor;
	}

	public void setMostrarFK_IdVendedorVendedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorVendedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaVendedor=true;

	public Boolean getMostrarFK_IdZonaVendedor() {
		return this.mostrarFK_IdZonaVendedor;
	}

	public void setMostrarFK_IdZonaVendedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaVendedor= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoVendedor=true;

	public Boolean getActivarBusquedaPorCodigoVendedor() {
		return this.activarBusquedaPorCodigoVendedor;
	}

	public void setActivarBusquedaPorCodigoVendedor(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoVendedor= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreVendedor=true;

	public Boolean getActivarBusquedaPorNombreVendedor() {
		return this.activarBusquedaPorNombreVendedor;
	}

	public void setActivarBusquedaPorNombreVendedor(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreVendedor= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucVendedor=true;

	public Boolean getActivarBusquedaPorRucVendedor() {
		return this.activarBusquedaPorRucVendedor;
	}

	public void setActivarBusquedaPorRucVendedor(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucVendedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVendedor=true;

	public Boolean getActivarFK_IdEmpresaVendedor() {
		return this.activarFK_IdEmpresaVendedor;
	}

	public void setActivarFK_IdEmpresaVendedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVendedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisVendedor=true;

	public Boolean getActivarFK_IdPaisVendedor() {
		return this.activarFK_IdPaisVendedor;
	}

	public void setActivarFK_IdPaisVendedor(Boolean habilitarResaltar) {
		this.activarFK_IdPaisVendedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalVendedor=true;

	public Boolean getActivarFK_IdSucursalVendedor() {
		return this.activarFK_IdSucursalVendedor;
	}

	public void setActivarFK_IdSucursalVendedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalVendedor= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorVendedor=true;

	public Boolean getActivarFK_IdVendedorVendedor() {
		return this.activarFK_IdVendedorVendedor;
	}

	public void setActivarFK_IdVendedorVendedor(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorVendedor= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaVendedor=true;

	public Boolean getActivarFK_IdZonaVendedor() {
		return this.activarFK_IdZonaVendedor;
	}

	public void setActivarFK_IdZonaVendedor(Boolean habilitarResaltar) {
		this.activarFK_IdZonaVendedor= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoVendedor=null;

	public Border getResaltarBusquedaPorCodigoVendedor() {
		return this.resaltarBusquedaPorCodigoVendedor;
	}

	public void setResaltarBusquedaPorCodigoVendedor(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoVendedor= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoVendedor= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreVendedor=null;

	public Border getResaltarBusquedaPorNombreVendedor() {
		return this.resaltarBusquedaPorNombreVendedor;
	}

	public void setResaltarBusquedaPorNombreVendedor(Border borderResaltar) {
		this.resaltarBusquedaPorNombreVendedor= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreVendedor= borderResaltar;
	}

	public Border resaltarBusquedaPorRucVendedor=null;

	public Border getResaltarBusquedaPorRucVendedor() {
		return this.resaltarBusquedaPorRucVendedor;
	}

	public void setResaltarBusquedaPorRucVendedor(Border borderResaltar) {
		this.resaltarBusquedaPorRucVendedor= borderResaltar;
	}

	public void setResaltarBusquedaPorRucVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucVendedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVendedor=null;

	public Border getResaltarFK_IdEmpresaVendedor() {
		return this.resaltarFK_IdEmpresaVendedor;
	}

	public void setResaltarFK_IdEmpresaVendedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVendedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVendedor= borderResaltar;
	}

	public Border resaltarFK_IdPaisVendedor=null;

	public Border getResaltarFK_IdPaisVendedor() {
		return this.resaltarFK_IdPaisVendedor;
	}

	public void setResaltarFK_IdPaisVendedor(Border borderResaltar) {
		this.resaltarFK_IdPaisVendedor= borderResaltar;
	}

	public void setResaltarFK_IdPaisVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisVendedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalVendedor=null;

	public Border getResaltarFK_IdSucursalVendedor() {
		return this.resaltarFK_IdSucursalVendedor;
	}

	public void setResaltarFK_IdSucursalVendedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalVendedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalVendedor= borderResaltar;
	}

	public Border resaltarFK_IdVendedorVendedor=null;

	public Border getResaltarFK_IdVendedorVendedor() {
		return this.resaltarFK_IdVendedorVendedor;
	}

	public void setResaltarFK_IdVendedorVendedor(Border borderResaltar) {
		this.resaltarFK_IdVendedorVendedor= borderResaltar;
	}

	public void setResaltarFK_IdVendedorVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorVendedor= borderResaltar;
	}

	public Border resaltarFK_IdZonaVendedor=null;

	public Border getResaltarFK_IdZonaVendedor() {
		return this.resaltarFK_IdZonaVendedor;
	}

	public void setResaltarFK_IdZonaVendedor(Border borderResaltar) {
		this.resaltarFK_IdZonaVendedor= borderResaltar;
	}

	public void setResaltarFK_IdZonaVendedor(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorBeanSwingJInternalFrame vendedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaVendedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}