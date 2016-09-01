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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.BodegaConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BodegaConstantesFunciones extends BodegaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Bodega";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Bodega"+BodegaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BodegaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BodegaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BodegaConstantesFunciones.SCHEMA+"_"+BodegaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BodegaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BodegaConstantesFunciones.SCHEMA+"_"+BodegaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BodegaConstantesFunciones.SCHEMA+"_"+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BodegaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BodegaConstantesFunciones.SCHEMA+"_"+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BodegaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BodegaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BodegaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BodegaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bodegas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Bodega";
	public static final String SCLASSWEBTITULO_LOWER="Bodega";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Bodega";
	public static final String OBJECTNAME="bodega";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="bodega";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bodega from "+BodegaConstantesFunciones.SPERSISTENCENAME+" bodega";
	public static String QUERYSELECTNATIVE="select "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".version_row,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_empresa,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_grupo_bodega,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_calidad_producto,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".codigo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".nombre,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".siglas,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".direccion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".telefono,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".ruc,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".responsable_nombre,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".descripcion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_pais,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_ciudad,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_centro_costo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_empleado,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".es_multi_empresa,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".con_mostrar_stock,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".es_bodega_transito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".con_stock_negativo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME;//+" as "+BodegaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BodegaConstantesFuncionesAdditional bodegaConstantesFuncionesAdditional=null;
	
	public BodegaConstantesFuncionesAdditional getBodegaConstantesFuncionesAdditional() {
		return this.bodegaConstantesFuncionesAdditional;
	}
	
	public void setBodegaConstantesFuncionesAdditional(BodegaConstantesFuncionesAdditional bodegaConstantesFuncionesAdditional) {
		try {
			this.bodegaConstantesFuncionesAdditional=bodegaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDGRUPOBODEGA= "id_grupo_bodega";
    public static final String IDCALIDADPRODUCTO= "id_calidad_producto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String RESPONSABLENOMBRE= "responsable_nombre";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String ESMULTIEMPRESA= "es_multi_empresa";
    public static final String CONMOSTRARSTOCK= "con_mostrar_stock";
    public static final String ESBODEGATRANSITO= "es_bodega_transito";
    public static final String CONSTOCKNEGATIVO= "con_stock_negativo";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String IDCUENTACONTABLEBONIFICA= "id_cuenta_contable_bonifica";
    public static final String IDCUENTACONTABLEPRODUCCION= "id_cuenta_contable_produccion";
    public static final String IDCUENTACONTABLECOSTOBONIFICA= "id_cuenta_contable_costo_bonifica";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDGRUPOBODEGA= "Grupo Bodega";
		public static final String LABEL_IDGRUPOBODEGA_LOWER= "Grupo Bodega";
    	public static final String LABEL_IDCALIDADPRODUCTO= "Calidad Producto";
		public static final String LABEL_IDCALIDADPRODUCTO_LOWER= "Calidad Producto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_RESPONSABLENOMBRE= "Responsable Nombre";
		public static final String LABEL_RESPONSABLENOMBRE_LOWER= "Responsable Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_ESMULTIEMPRESA= "Multi Empresa";
		public static final String LABEL_ESMULTIEMPRESA_LOWER= "Es Multi Empresa";
    	public static final String LABEL_CONMOSTRARSTOCK= "Mostrar Stock";
		public static final String LABEL_CONMOSTRARSTOCK_LOWER= "Con Mostrar Stock";
    	public static final String LABEL_ESBODEGATRANSITO= "Bodega Transito";
		public static final String LABEL_ESBODEGATRANSITO_LOWER= "Es Bodega Transito";
    	public static final String LABEL_CONSTOCKNEGATIVO= "Stock Negativo";
		public static final String LABEL_CONSTOCKNEGATIVO_LOWER= "Con Stock Negativo";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIO= "Cuenta C. Inventario";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIO_LOWER= "Cuenta Contable Inventario";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "Cuenta C. Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "Cuenta C. Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_IDCUENTACONTABLEDESCUENTO= "Cuenta C. Descuento";
		public static final String LABEL_IDCUENTACONTABLEDESCUENTO_LOWER= "Cuenta Contable Descuento";
    	public static final String LABEL_IDCUENTACONTABLEDEVOLUCION= "Cuenta C. Devolucion";
		public static final String LABEL_IDCUENTACONTABLEDEVOLUCION_LOWER= "Cuenta Contable Devolucion";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta C. Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta C. Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_IDCUENTACONTABLEBONIFICA= "Cuenta C. Bonifica";
		public static final String LABEL_IDCUENTACONTABLEBONIFICA_LOWER= "Cuenta Contable Bonifica";
    	public static final String LABEL_IDCUENTACONTABLEPRODUCCION= "Cuenta C. Produccion";
		public static final String LABEL_IDCUENTACONTABLEPRODUCCION_LOWER= "Cuenta Contable Produccion";
    	public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA= "Cuenta C. Costo Bonifica";
		public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA_LOWER= "Cuenta Contable Costo Bonifica";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESPONSABLE_NOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE_NOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getBodegaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDEMPRESA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDGRUPOBODEGA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDGRUPOBODEGA;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCALIDADPRODUCTO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCALIDADPRODUCTO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.CODIGO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.NOMBRE)) {sLabelColumna=BodegaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.SIGLAS)) {sLabelColumna=BodegaConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.DIRECCION)) {sLabelColumna=BodegaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.TELEFONO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.RUC)) {sLabelColumna=BodegaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.RESPONSABLENOMBRE)) {sLabelColumna=BodegaConstantesFunciones.LABEL_RESPONSABLENOMBRE;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.DESCRIPCION)) {sLabelColumna=BodegaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDPAIS)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCIUDAD)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.ESMULTIEMPRESA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_ESMULTIEMPRESA;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.CONMOSTRARSTOCK)) {sLabelColumna=BodegaConstantesFunciones.LABEL_CONMOSTRARSTOCK;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.ESBODEGATRANSITO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_ESBODEGATRANSITO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.CONSTOCKNEGATIVO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_CONSTOCKNEGATIVO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION;}
		if(sNombreColumna.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {sLabelColumna=BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_multi_empresaDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodega.getes_multi_empresa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_multi_empresaHtmlDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodega.getId(),bodega.getes_multi_empresa());

		return sDescripcion;
	}	
		
	public static String getcon_mostrar_stockDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodega.getcon_mostrar_stock()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mostrar_stockHtmlDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodega.getId(),bodega.getcon_mostrar_stock());

		return sDescripcion;
	}	
		
	public static String getes_bodega_transitoDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodega.getes_bodega_transito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_bodega_transitoHtmlDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodega.getId(),bodega.getes_bodega_transito());

		return sDescripcion;
	}	
		
	public static String getcon_stock_negativoDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodega.getcon_stock_negativo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_stock_negativoHtmlDescripcion(Bodega bodega) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodega.getId(),bodega.getcon_stock_negativo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
	
	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bodega !=null/* && bodega.getId()!=0*/) {
			sDescripcion=bodega.getnombre();//bodegabodega.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getBodegaDescripcionDetallado(Bodega bodega) {
		String sDescripcion="";
			
		sDescripcion+=BodegaConstantesFunciones.ID+"=";
		sDescripcion+=bodega.getId().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bodega.getVersionRow().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bodega.getid_empresa().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDGRUPOBODEGA+"=";
		sDescripcion+=bodega.getid_grupo_bodega().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCALIDADPRODUCTO+"=";
		sDescripcion+=bodega.getid_calidad_producto().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.CODIGO+"=";
		sDescripcion+=bodega.getcodigo()+",";
		sDescripcion+=BodegaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=bodega.getnombre()+",";
		sDescripcion+=BodegaConstantesFunciones.SIGLAS+"=";
		sDescripcion+=bodega.getsiglas()+",";
		sDescripcion+=BodegaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=bodega.getdireccion()+",";
		sDescripcion+=BodegaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=bodega.gettelefono()+",";
		sDescripcion+=BodegaConstantesFunciones.RUC+"=";
		sDescripcion+=bodega.getruc()+",";
		sDescripcion+=BodegaConstantesFunciones.RESPONSABLENOMBRE+"=";
		sDescripcion+=bodega.getresponsable_nombre()+",";
		sDescripcion+=BodegaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=bodega.getdescripcion()+",";
		sDescripcion+=BodegaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=bodega.getid_pais().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=bodega.getid_ciudad().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=bodega.getid_centro_costo().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=bodega.getid_empleado().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.ESMULTIEMPRESA+"=";
		sDescripcion+=bodega.getes_multi_empresa().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.CONMOSTRARSTOCK+"=";
		sDescripcion+=bodega.getcon_mostrar_stock().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.ESBODEGATRANSITO+"=";
		sDescripcion+=bodega.getes_bodega_transito().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.CONSTOCKNEGATIVO+"=";
		sDescripcion+=bodega.getcon_stock_negativo().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=bodega.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=bodega.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=bodega.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=bodega.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=bodega.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=bodega.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=bodega.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA+"=";
		sDescripcion+=bodega.getid_cuenta_contable_bonifica().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION+"=";
		sDescripcion+=bodega.getid_cuenta_contable_produccion().toString()+",";
		sDescripcion+=BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA+"=";
		sDescripcion+=bodega.getid_cuenta_contable_costo_bonifica().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBodegaDescripcion(Bodega bodega,String sValor) throws Exception {			
		if(bodega !=null) {
			bodega.setnombre(sValor);;//bodegabodega.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getGrupoBodegaDescripcion(GrupoBodega grupobodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupobodega!=null/*&&grupobodega.getId()>0*/) {
			sDescripcion=GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(grupobodega);
		}

		return sDescripcion;
	}

	public static String getCalidadProductoDescripcion(CalidadProducto calidadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(calidadproducto!=null/*&&calidadproducto.getId()>0*/) {
			sDescripcion=CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(calidadproducto);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getCuentaContableInventarioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescuentoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDevolucionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableBonificaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableProduccionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoBonificaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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
		} else if(sNombreIndice.equals("BusquedaPorResponsableNombre")) {
			sNombreIndice="Tipo=  Por Responsable Nombre";
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("BusquedaPorTelefono")) {
			sNombreIndice="Tipo=  Por Telefono";
		} else if(sNombreIndice.equals("FK_IdCalidadProducto")) {
			sNombreIndice="Tipo=  Por Calidad Producto";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCuentaContableBonifica")) {
			sNombreIndice="Tipo=  Por Cuenta C. Bonifica";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoBonifica")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo Bonifica";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Debito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDescuento")) {
			sNombreIndice="Tipo=  Por Cuenta C. Descuento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDevolucion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Devolucion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventario")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario";
		} else if(sNombreIndice.equals("FK_IdCuentaContableProduccion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Produccion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Venta";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoBodega")) {
			sNombreIndice="Tipo=  Por Grupo Bodega";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
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

	public static String getDetalleIndiceBusquedaPorResponsableNombre(String responsable_nombre) {
		String sDetalleIndice=" Parametros->";
		if(responsable_nombre!=null) {sDetalleIndice+=" Responsable Nombre="+responsable_nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorRuc(String ruc) {
		String sDetalleIndice=" Parametros->";
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorTelefono(String telefono) {
		String sDetalleIndice=" Parametros->";
		if(telefono!=null) {sDetalleIndice+=" Telefono="+telefono;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCalidadProducto(Long id_calidad_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_calidad_producto!=null) {sDetalleIndice+=" Codigo Unico De Calidad Producto="+id_calidad_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableBonifica(Long id_cuenta_contable_bonifica) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_bonifica!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Bonifica="+id_cuenta_contable_bonifica.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCosto(Long id_cuenta_contable_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo="+id_cuenta_contable_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoBonifica(Long id_cuenta_contable_costo_bonifica) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_bonifica!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo Bonifica="+id_cuenta_contable_costo_bonifica.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDescuento(Long id_cuenta_contable_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_descuento!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Descuento="+id_cuenta_contable_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDevolucion(Long id_cuenta_contable_devolucion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_devolucion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Devolucion="+id_cuenta_contable_devolucion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventario(Long id_cuenta_contable_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario="+id_cuenta_contable_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableProduccion(Long id_cuenta_contable_produccion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_produccion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Produccion="+id_cuenta_contable_produccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Venta="+id_cuenta_contable_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoBodega(Long id_grupo_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_bodega!=null) {sDetalleIndice+=" Codigo Unico De Grupo Bodega="+id_grupo_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBodega(Bodega bodega,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bodega.setcodigo(bodega.getcodigo().trim());
		bodega.setnombre(bodega.getnombre().trim());
		bodega.setsiglas(bodega.getsiglas().trim());
		bodega.setdireccion(bodega.getdireccion().trim());
		bodega.settelefono(bodega.gettelefono().trim());
		bodega.setruc(bodega.getruc().trim());
		bodega.setresponsable_nombre(bodega.getresponsable_nombre().trim());
		bodega.setdescripcion(bodega.getdescripcion().trim());
	}
	
	public static void quitarEspaciosBodegas(List<Bodega> bodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Bodega bodega: bodegas) {
			bodega.setcodigo(bodega.getcodigo().trim());
			bodega.setnombre(bodega.getnombre().trim());
			bodega.setsiglas(bodega.getsiglas().trim());
			bodega.setdireccion(bodega.getdireccion().trim());
			bodega.settelefono(bodega.gettelefono().trim());
			bodega.setruc(bodega.getruc().trim());
			bodega.setresponsable_nombre(bodega.getresponsable_nombre().trim());
			bodega.setdescripcion(bodega.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodega(Bodega bodega,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bodega.getConCambioAuxiliar()) {
			bodega.setIsDeleted(bodega.getIsDeletedAuxiliar());	
			bodega.setIsNew(bodega.getIsNewAuxiliar());	
			bodega.setIsChanged(bodega.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bodega.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bodega.setIsDeletedAuxiliar(false);	
			bodega.setIsNewAuxiliar(false);	
			bodega.setIsChangedAuxiliar(false);
			
			bodega.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodegas(List<Bodega> bodegas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Bodega bodega : bodegas) {
			if(conAsignarBase && bodega.getConCambioAuxiliar()) {
				bodega.setIsDeleted(bodega.getIsDeletedAuxiliar());	
				bodega.setIsNew(bodega.getIsNewAuxiliar());	
				bodega.setIsChanged(bodega.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bodega.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bodega.setIsDeletedAuxiliar(false);	
				bodega.setIsNewAuxiliar(false);	
				bodega.setIsChangedAuxiliar(false);
				
				bodega.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBodega(Bodega bodega,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBodegas(List<Bodega> bodegas,Boolean conEnteros) throws Exception  {
		
		for(Bodega bodega: bodegas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBodega(List<Bodega> bodegas,Bodega bodegaAux) throws Exception  {
		BodegaConstantesFunciones.InicializarValoresBodega(bodegaAux,true);
		
		for(Bodega bodega: bodegas) {
			if(bodega.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBodega(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BodegaConstantesFunciones.getArrayColumnasGlobalesBodega(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBodega(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BodegaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BodegaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBodega(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Bodega> bodegas,Bodega bodega,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Bodega bodegaAux: bodegas) {
			if(bodegaAux!=null && bodega!=null) {
				if((bodegaAux.getId()==null && bodega.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bodegaAux.getId()!=null && bodega.getId()!=null){
					if(bodegaAux.getId().equals(bodega.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBodega(List<Bodega> bodegas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Bodega bodega: bodegas) {			
			if(bodega.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBodega() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_ID, BodegaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_VERSIONROW, BodegaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDEMPRESA, BodegaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDGRUPOBODEGA, BodegaConstantesFunciones.IDGRUPOBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCALIDADPRODUCTO, BodegaConstantesFunciones.IDCALIDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_CODIGO, BodegaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_NOMBRE, BodegaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_SIGLAS, BodegaConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_DIRECCION, BodegaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_TELEFONO, BodegaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_RUC, BodegaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_RESPONSABLENOMBRE, BodegaConstantesFunciones.RESPONSABLENOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_DESCRIPCION, BodegaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDPAIS, BodegaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCIUDAD, BodegaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCENTROCOSTO, BodegaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDEMPLEADO, BodegaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_ESMULTIEMPRESA, BodegaConstantesFunciones.ESMULTIEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_CONMOSTRARSTOCK, BodegaConstantesFunciones.CONMOSTRARSTOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_ESBODEGATRANSITO, BodegaConstantesFunciones.ESBODEGATRANSITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_CONSTOCKNEGATIVO, BodegaConstantesFunciones.CONSTOCKNEGATIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, BodegaConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, BodegaConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, BodegaConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA, BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION, BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA, BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBodega() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDGRUPOBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCALIDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.RESPONSABLENOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.ESMULTIEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.CONMOSTRARSTOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.ESBODEGATRANSITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.CONSTOCKNEGATIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodega() throws Exception  {
		return BodegaConstantesFunciones.getTiposSeleccionarBodega(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodega(Boolean conFk) throws Exception  {
		return BodegaConstantesFunciones.getTiposSeleccionarBodega(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodega(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDGRUPOBODEGA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDGRUPOBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCALIDADPRODUCTO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCALIDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_RESPONSABLENOMBRE);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_RESPONSABLENOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_ESMULTIEMPRESA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_ESMULTIEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_CONMOSTRARSTOCK);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_CONMOSTRARSTOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_ESBODEGATRANSITO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_ESBODEGATRANSITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_CONSTOCKNEGATIVO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_CONSTOCKNEGATIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
			reporte.setsDescripcion(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBodega(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBodega(Bodega bodegaAux) throws Exception {
		
			bodegaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegaAux.getEmpresa()));
			bodegaAux.setgrupobodega_descripcion(GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(bodegaAux.getGrupoBodega()));
			bodegaAux.setcalidadproducto_descripcion(CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(bodegaAux.getCalidadProducto()));
			bodegaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(bodegaAux.getPais()));
			bodegaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(bodegaAux.getCiudad()));
			bodegaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(bodegaAux.getCentroCosto()));
			bodegaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(bodegaAux.getEmpleado()));
			bodegaAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableInventario()));
			bodegaAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCosto()));
			bodegaAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableVenta()));
			bodegaAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDescuento()));
			bodegaAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDevolucion()));
			bodegaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDebito()));
			bodegaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCredito()));
			bodegaAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableBonifica()));
			bodegaAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableProduccion()));
			bodegaAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCostoBonifica()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBodega(List<Bodega> bodegasTemp) throws Exception {
		for(Bodega bodegaAux:bodegasTemp) {
			
			bodegaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegaAux.getEmpresa()));
			bodegaAux.setgrupobodega_descripcion(GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(bodegaAux.getGrupoBodega()));
			bodegaAux.setcalidadproducto_descripcion(CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(bodegaAux.getCalidadProducto()));
			bodegaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(bodegaAux.getPais()));
			bodegaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(bodegaAux.getCiudad()));
			bodegaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(bodegaAux.getCentroCosto()));
			bodegaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(bodegaAux.getEmpleado()));
			bodegaAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableInventario()));
			bodegaAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCosto()));
			bodegaAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableVenta()));
			bodegaAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDescuento()));
			bodegaAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDevolucion()));
			bodegaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableDebito()));
			bodegaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCredito()));
			bodegaAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableBonifica()));
			bodegaAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableProduccion()));
			bodegaAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaAux.getCuentaContableCostoBonifica()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(GrupoBodega.class));
				classes.add(new Classe(CalidadProducto.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoBodega.class)) {
						classes.add(new Classe(GrupoBodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CalidadProducto.class)) {
						classes.add(new Classe(CalidadProducto.class));
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoBodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoBodega.class)); continue;
					}

					if(CalidadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalidadProducto.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoBodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoBodega.class)); continue;
					}

					if(CalidadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalidadProducto.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaConstantesFunciones.getClassesRelationshipsOfBodega(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaConstantesFunciones.getClassesRelationshipsFromStringsOfBodega(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Bodega bodega,List<Bodega> bodegas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Bodega bodegaEncontrado=null;
			
			for(Bodega bodegaLocal:bodegas) {
				if(bodegaLocal.getId().equals(bodega.getId())) {
					bodegaEncontrado=bodegaLocal;
					
					bodegaLocal.setIsChanged(bodega.getIsChanged());
					bodegaLocal.setIsNew(bodega.getIsNew());
					bodegaLocal.setIsDeleted(bodega.getIsDeleted());
					
					bodegaLocal.setGeneralEntityOriginal(bodega.getGeneralEntityOriginal());
					
					bodegaLocal.setId(bodega.getId());	
					bodegaLocal.setVersionRow(bodega.getVersionRow());	
					bodegaLocal.setid_empresa(bodega.getid_empresa());	
					bodegaLocal.setid_grupo_bodega(bodega.getid_grupo_bodega());	
					bodegaLocal.setid_calidad_producto(bodega.getid_calidad_producto());	
					bodegaLocal.setcodigo(bodega.getcodigo());	
					bodegaLocal.setnombre(bodega.getnombre());	
					bodegaLocal.setsiglas(bodega.getsiglas());	
					bodegaLocal.setdireccion(bodega.getdireccion());	
					bodegaLocal.settelefono(bodega.gettelefono());	
					bodegaLocal.setruc(bodega.getruc());	
					bodegaLocal.setresponsable_nombre(bodega.getresponsable_nombre());	
					bodegaLocal.setdescripcion(bodega.getdescripcion());	
					bodegaLocal.setid_pais(bodega.getid_pais());	
					bodegaLocal.setid_ciudad(bodega.getid_ciudad());	
					bodegaLocal.setid_centro_costo(bodega.getid_centro_costo());	
					bodegaLocal.setid_empleado(bodega.getid_empleado());	
					bodegaLocal.setes_multi_empresa(bodega.getes_multi_empresa());	
					bodegaLocal.setcon_mostrar_stock(bodega.getcon_mostrar_stock());	
					bodegaLocal.setes_bodega_transito(bodega.getes_bodega_transito());	
					bodegaLocal.setcon_stock_negativo(bodega.getcon_stock_negativo());	
					bodegaLocal.setid_cuenta_contable_inventario(bodega.getid_cuenta_contable_inventario());	
					bodegaLocal.setid_cuenta_contable_costo(bodega.getid_cuenta_contable_costo());	
					bodegaLocal.setid_cuenta_contable_venta(bodega.getid_cuenta_contable_venta());	
					bodegaLocal.setid_cuenta_contable_descuento(bodega.getid_cuenta_contable_descuento());	
					bodegaLocal.setid_cuenta_contable_devolucion(bodega.getid_cuenta_contable_devolucion());	
					bodegaLocal.setid_cuenta_contable_debito(bodega.getid_cuenta_contable_debito());	
					bodegaLocal.setid_cuenta_contable_credito(bodega.getid_cuenta_contable_credito());	
					bodegaLocal.setid_cuenta_contable_bonifica(bodega.getid_cuenta_contable_bonifica());	
					bodegaLocal.setid_cuenta_contable_produccion(bodega.getid_cuenta_contable_produccion());	
					bodegaLocal.setid_cuenta_contable_costo_bonifica(bodega.getid_cuenta_contable_costo_bonifica());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bodega.getIsDeleted()) {
				if(!existe) {
					bodegas.add(bodega);
				}
			} else {
				if(bodegaEncontrado!=null && permiteQuitar)  {
					bodegas.remove(bodegaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Bodega bodega,List<Bodega> bodegas) throws Exception {
		try	{			
			for(Bodega bodegaLocal:bodegas) {
				if(bodegaLocal.getId().equals(bodega.getId())) {
					bodegaLocal.setIsSelected(bodega.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBodega(List<Bodega> bodegasAux) throws Exception {
		//this.bodegasAux=bodegasAux;
		
		for(Bodega bodegaAux:bodegasAux) {
			if(bodegaAux.getIsChanged()) {
				bodegaAux.setIsChanged(false);
			}		
			
			if(bodegaAux.getIsNew()) {
				bodegaAux.setIsNew(false);
			}	
			
			if(bodegaAux.getIsDeleted()) {
				bodegaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBodega(Bodega bodegaAux) throws Exception {
		//this.bodegaAux=bodegaAux;
		
			if(bodegaAux.getIsChanged()) {
				bodegaAux.setIsChanged(false);
			}		
			
			if(bodegaAux.getIsNew()) {
				bodegaAux.setIsNew(false);
			}	
			
			if(bodegaAux.getIsDeleted()) {
				bodegaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Bodega bodegaAsignar,Bodega bodega) throws Exception {
		bodegaAsignar.setId(bodega.getId());	
		bodegaAsignar.setVersionRow(bodega.getVersionRow());	
		bodegaAsignar.setid_empresa(bodega.getid_empresa());
		bodegaAsignar.setempresa_descripcion(bodega.getempresa_descripcion());	
		bodegaAsignar.setid_grupo_bodega(bodega.getid_grupo_bodega());
		bodegaAsignar.setgrupobodega_descripcion(bodega.getgrupobodega_descripcion());	
		bodegaAsignar.setid_calidad_producto(bodega.getid_calidad_producto());
		bodegaAsignar.setcalidadproducto_descripcion(bodega.getcalidadproducto_descripcion());	
		bodegaAsignar.setcodigo(bodega.getcodigo());	
		bodegaAsignar.setnombre(bodega.getnombre());	
		bodegaAsignar.setsiglas(bodega.getsiglas());	
		bodegaAsignar.setdireccion(bodega.getdireccion());	
		bodegaAsignar.settelefono(bodega.gettelefono());	
		bodegaAsignar.setruc(bodega.getruc());	
		bodegaAsignar.setresponsable_nombre(bodega.getresponsable_nombre());	
		bodegaAsignar.setdescripcion(bodega.getdescripcion());	
		bodegaAsignar.setid_pais(bodega.getid_pais());
		bodegaAsignar.setpais_descripcion(bodega.getpais_descripcion());	
		bodegaAsignar.setid_ciudad(bodega.getid_ciudad());
		bodegaAsignar.setciudad_descripcion(bodega.getciudad_descripcion());	
		bodegaAsignar.setid_centro_costo(bodega.getid_centro_costo());
		bodegaAsignar.setcentrocosto_descripcion(bodega.getcentrocosto_descripcion());	
		bodegaAsignar.setid_empleado(bodega.getid_empleado());
		bodegaAsignar.setempleado_descripcion(bodega.getempleado_descripcion());	
		bodegaAsignar.setes_multi_empresa(bodega.getes_multi_empresa());	
		bodegaAsignar.setcon_mostrar_stock(bodega.getcon_mostrar_stock());	
		bodegaAsignar.setes_bodega_transito(bodega.getes_bodega_transito());	
		bodegaAsignar.setcon_stock_negativo(bodega.getcon_stock_negativo());	
		bodegaAsignar.setid_cuenta_contable_inventario(bodega.getid_cuenta_contable_inventario());
		bodegaAsignar.setcuentacontableinventario_descripcion(bodega.getcuentacontableinventario_descripcion());	
		bodegaAsignar.setid_cuenta_contable_costo(bodega.getid_cuenta_contable_costo());
		bodegaAsignar.setcuentacontablecosto_descripcion(bodega.getcuentacontablecosto_descripcion());	
		bodegaAsignar.setid_cuenta_contable_venta(bodega.getid_cuenta_contable_venta());
		bodegaAsignar.setcuentacontableventa_descripcion(bodega.getcuentacontableventa_descripcion());	
		bodegaAsignar.setid_cuenta_contable_descuento(bodega.getid_cuenta_contable_descuento());
		bodegaAsignar.setcuentacontabledescuento_descripcion(bodega.getcuentacontabledescuento_descripcion());	
		bodegaAsignar.setid_cuenta_contable_devolucion(bodega.getid_cuenta_contable_devolucion());
		bodegaAsignar.setcuentacontabledevolucion_descripcion(bodega.getcuentacontabledevolucion_descripcion());	
		bodegaAsignar.setid_cuenta_contable_debito(bodega.getid_cuenta_contable_debito());
		bodegaAsignar.setcuentacontabledebito_descripcion(bodega.getcuentacontabledebito_descripcion());	
		bodegaAsignar.setid_cuenta_contable_credito(bodega.getid_cuenta_contable_credito());
		bodegaAsignar.setcuentacontablecredito_descripcion(bodega.getcuentacontablecredito_descripcion());	
		bodegaAsignar.setid_cuenta_contable_bonifica(bodega.getid_cuenta_contable_bonifica());
		bodegaAsignar.setcuentacontablebonifica_descripcion(bodega.getcuentacontablebonifica_descripcion());	
		bodegaAsignar.setid_cuenta_contable_produccion(bodega.getid_cuenta_contable_produccion());
		bodegaAsignar.setcuentacontableproduccion_descripcion(bodega.getcuentacontableproduccion_descripcion());	
		bodegaAsignar.setid_cuenta_contable_costo_bonifica(bodega.getid_cuenta_contable_costo_bonifica());
		bodegaAsignar.setcuentacontablecostobonifica_descripcion(bodega.getcuentacontablecostobonifica_descripcion());	
	}
	
	public static void inicializarBodega(Bodega bodega) throws Exception {
		try {
				bodega.setId(0L);	
					
				bodega.setid_empresa(-1L);	
				bodega.setid_grupo_bodega(-1L);	
				bodega.setid_calidad_producto(-1L);	
				bodega.setcodigo("");	
				bodega.setnombre("");	
				bodega.setsiglas("");	
				bodega.setdireccion("");	
				bodega.settelefono("");	
				bodega.setruc("");	
				bodega.setresponsable_nombre("");	
				bodega.setdescripcion("");	
				bodega.setid_pais(-1L);	
				bodega.setid_ciudad(-1L);	
				bodega.setid_centro_costo(null);	
				bodega.setid_empleado(-1L);	
				bodega.setes_multi_empresa(false);	
				bodega.setcon_mostrar_stock(false);	
				bodega.setes_bodega_transito(false);	
				bodega.setcon_stock_negativo(false);	
				bodega.setid_cuenta_contable_inventario(-1L);	
				bodega.setid_cuenta_contable_costo(-1L);	
				bodega.setid_cuenta_contable_venta(-1L);	
				bodega.setid_cuenta_contable_descuento(-1L);	
				bodega.setid_cuenta_contable_devolucion(-1L);	
				bodega.setid_cuenta_contable_debito(null);	
				bodega.setid_cuenta_contable_credito(null);	
				bodega.setid_cuenta_contable_bonifica(-1L);	
				bodega.setid_cuenta_contable_produccion(-1L);	
				bodega.setid_cuenta_contable_costo_bonifica(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBodega(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDGRUPOBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCALIDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_RESPONSABLENOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_ESMULTIEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_CONMOSTRARSTOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_ESBODEGATRANSITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_CONSTOCKNEGATIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBodega(String sTipo,Row row,Workbook workbook,Bodega bodega,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getgrupobodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcalidadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getresponsable_nombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodega.getes_multi_empresa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodega.getcon_mostrar_stock()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodega.getes_bodega_transito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodega.getcon_stock_negativo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontablebonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontableproduccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodega.getcuentacontablecostobonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBodega=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBodega() {
		return this.sFinalQueryBodega;
	}
	
	public void setsFinalQueryBodega(String sFinalQueryBodega) {
		this.sFinalQueryBodega= sFinalQueryBodega;
	}
	
	public Border resaltarSeleccionarBodega=null;
	
	public Border setResaltarSeleccionarBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBodega= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBodega() {
		return this.resaltarSeleccionarBodega;
	}
	
	public void setResaltarSeleccionarBodega(Border borderResaltarSeleccionarBodega) {
		this.resaltarSeleccionarBodega= borderResaltarSeleccionarBodega;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBodega=null;
	public Boolean mostraridBodega=true;
	public Boolean activaridBodega=true;

	public Border resaltarid_empresaBodega=null;
	public Boolean mostrarid_empresaBodega=true;
	public Boolean activarid_empresaBodega=true;
	public Boolean cargarid_empresaBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBodega=false;//ConEventDepend=true

	public Border resaltarid_grupo_bodegaBodega=null;
	public Boolean mostrarid_grupo_bodegaBodega=true;
	public Boolean activarid_grupo_bodegaBodega=true;
	public Boolean cargarid_grupo_bodegaBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_bodegaBodega=false;//ConEventDepend=true

	public Border resaltarid_calidad_productoBodega=null;
	public Boolean mostrarid_calidad_productoBodega=true;
	public Boolean activarid_calidad_productoBodega=true;
	public Boolean cargarid_calidad_productoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_calidad_productoBodega=false;//ConEventDepend=true

	public Border resaltarcodigoBodega=null;
	public Boolean mostrarcodigoBodega=true;
	public Boolean activarcodigoBodega=true;

	public Border resaltarnombreBodega=null;
	public Boolean mostrarnombreBodega=true;
	public Boolean activarnombreBodega=true;

	public Border resaltarsiglasBodega=null;
	public Boolean mostrarsiglasBodega=true;
	public Boolean activarsiglasBodega=true;

	public Border resaltardireccionBodega=null;
	public Boolean mostrardireccionBodega=true;
	public Boolean activardireccionBodega=true;

	public Border resaltartelefonoBodega=null;
	public Boolean mostrartelefonoBodega=true;
	public Boolean activartelefonoBodega=true;

	public Border resaltarrucBodega=null;
	public Boolean mostrarrucBodega=true;
	public Boolean activarrucBodega=true;

	public Border resaltarresponsable_nombreBodega=null;
	public Boolean mostrarresponsable_nombreBodega=true;
	public Boolean activarresponsable_nombreBodega=true;

	public Border resaltardescripcionBodega=null;
	public Boolean mostrardescripcionBodega=true;
	public Boolean activardescripcionBodega=true;

	public Border resaltarid_paisBodega=null;
	public Boolean mostrarid_paisBodega=true;
	public Boolean activarid_paisBodega=true;
	public Boolean cargarid_paisBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisBodega=false;//ConEventDepend=true

	public Border resaltarid_ciudadBodega=null;
	public Boolean mostrarid_ciudadBodega=true;
	public Boolean activarid_ciudadBodega=true;
	public Boolean cargarid_ciudadBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadBodega=true;//ConEventDepend=true

	public Border resaltarid_centro_costoBodega=null;
	public Boolean mostrarid_centro_costoBodega=true;
	public Boolean activarid_centro_costoBodega=true;
	public Boolean cargarid_centro_costoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoBodega=false;//ConEventDepend=true

	public Border resaltarid_empleadoBodega=null;
	public Boolean mostrarid_empleadoBodega=true;
	public Boolean activarid_empleadoBodega=true;
	public Boolean cargarid_empleadoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoBodega=false;//ConEventDepend=true

	public Border resaltares_multi_empresaBodega=null;
	public Boolean mostrares_multi_empresaBodega=true;
	public Boolean activares_multi_empresaBodega=true;

	public Border resaltarcon_mostrar_stockBodega=null;
	public Boolean mostrarcon_mostrar_stockBodega=true;
	public Boolean activarcon_mostrar_stockBodega=true;

	public Border resaltares_bodega_transitoBodega=null;
	public Boolean mostrares_bodega_transitoBodega=true;
	public Boolean activares_bodega_transitoBodega=true;

	public Border resaltarcon_stock_negativoBodega=null;
	public Boolean mostrarcon_stock_negativoBodega=true;
	public Boolean activarcon_stock_negativoBodega=true;

	public Border resaltarid_cuenta_contable_inventarioBodega=null;
	public Boolean mostrarid_cuenta_contable_inventarioBodega=true;
	public Boolean activarid_cuenta_contable_inventarioBodega=true;
	public Boolean cargarid_cuenta_contable_inventarioBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoBodega=null;
	public Boolean mostrarid_cuenta_contable_costoBodega=true;
	public Boolean activarid_cuenta_contable_costoBodega=true;
	public Boolean cargarid_cuenta_contable_costoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaBodega=null;
	public Boolean mostrarid_cuenta_contable_ventaBodega=true;
	public Boolean activarid_cuenta_contable_ventaBodega=true;
	public Boolean cargarid_cuenta_contable_ventaBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoBodega=null;
	public Boolean mostrarid_cuenta_contable_descuentoBodega=true;
	public Boolean activarid_cuenta_contable_descuentoBodega=true;
	public Boolean cargarid_cuenta_contable_descuentoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionBodega=null;
	public Boolean mostrarid_cuenta_contable_devolucionBodega=true;
	public Boolean activarid_cuenta_contable_devolucionBodega=true;
	public Boolean cargarid_cuenta_contable_devolucionBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoBodega=null;
	public Boolean mostrarid_cuenta_contable_debitoBodega=true;
	public Boolean activarid_cuenta_contable_debitoBodega=true;
	public Boolean cargarid_cuenta_contable_debitoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoBodega=null;
	public Boolean mostrarid_cuenta_contable_creditoBodega=true;
	public Boolean activarid_cuenta_contable_creditoBodega=true;
	public Boolean cargarid_cuenta_contable_creditoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_bonificaBodega=null;
	public Boolean mostrarid_cuenta_contable_bonificaBodega=true;
	public Boolean activarid_cuenta_contable_bonificaBodega=true;
	public Boolean cargarid_cuenta_contable_bonificaBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_bonificaBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_produccionBodega=null;
	public Boolean mostrarid_cuenta_contable_produccionBodega=true;
	public Boolean activarid_cuenta_contable_produccionBodega=true;
	public Boolean cargarid_cuenta_contable_produccionBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_produccionBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_bonificaBodega=null;
	public Boolean mostrarid_cuenta_contable_costo_bonificaBodega=true;
	public Boolean activarid_cuenta_contable_costo_bonificaBodega=true;
	public Boolean cargarid_cuenta_contable_costo_bonificaBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_bonificaBodega=false;//ConEventDepend=true

	
	

	public Border setResaltaridBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltaridBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBodega() {
		return this.resaltaridBodega;
	}

	public void setResaltaridBodega(Border borderResaltar) {
		this.resaltaridBodega= borderResaltar;
	}

	public Boolean getMostraridBodega() {
		return this.mostraridBodega;
	}

	public void setMostraridBodega(Boolean mostraridBodega) {
		this.mostraridBodega= mostraridBodega;
	}

	public Boolean getActivaridBodega() {
		return this.activaridBodega;
	}

	public void setActivaridBodega(Boolean activaridBodega) {
		this.activaridBodega= activaridBodega;
	}

	public Border setResaltarid_empresaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_empresaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBodega() {
		return this.resaltarid_empresaBodega;
	}

	public void setResaltarid_empresaBodega(Border borderResaltar) {
		this.resaltarid_empresaBodega= borderResaltar;
	}

	public Boolean getMostrarid_empresaBodega() {
		return this.mostrarid_empresaBodega;
	}

	public void setMostrarid_empresaBodega(Boolean mostrarid_empresaBodega) {
		this.mostrarid_empresaBodega= mostrarid_empresaBodega;
	}

	public Boolean getActivarid_empresaBodega() {
		return this.activarid_empresaBodega;
	}

	public void setActivarid_empresaBodega(Boolean activarid_empresaBodega) {
		this.activarid_empresaBodega= activarid_empresaBodega;
	}

	public Boolean getCargarid_empresaBodega() {
		return this.cargarid_empresaBodega;
	}

	public void setCargarid_empresaBodega(Boolean cargarid_empresaBodega) {
		this.cargarid_empresaBodega= cargarid_empresaBodega;
	}

	public Border setResaltarid_grupo_bodegaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_grupo_bodegaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_bodegaBodega() {
		return this.resaltarid_grupo_bodegaBodega;
	}

	public void setResaltarid_grupo_bodegaBodega(Border borderResaltar) {
		this.resaltarid_grupo_bodegaBodega= borderResaltar;
	}

	public Boolean getMostrarid_grupo_bodegaBodega() {
		return this.mostrarid_grupo_bodegaBodega;
	}

	public void setMostrarid_grupo_bodegaBodega(Boolean mostrarid_grupo_bodegaBodega) {
		this.mostrarid_grupo_bodegaBodega= mostrarid_grupo_bodegaBodega;
	}

	public Boolean getActivarid_grupo_bodegaBodega() {
		return this.activarid_grupo_bodegaBodega;
	}

	public void setActivarid_grupo_bodegaBodega(Boolean activarid_grupo_bodegaBodega) {
		this.activarid_grupo_bodegaBodega= activarid_grupo_bodegaBodega;
	}

	public Boolean getCargarid_grupo_bodegaBodega() {
		return this.cargarid_grupo_bodegaBodega;
	}

	public void setCargarid_grupo_bodegaBodega(Boolean cargarid_grupo_bodegaBodega) {
		this.cargarid_grupo_bodegaBodega= cargarid_grupo_bodegaBodega;
	}

	public Border setResaltarid_calidad_productoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_calidad_productoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_calidad_productoBodega() {
		return this.resaltarid_calidad_productoBodega;
	}

	public void setResaltarid_calidad_productoBodega(Border borderResaltar) {
		this.resaltarid_calidad_productoBodega= borderResaltar;
	}

	public Boolean getMostrarid_calidad_productoBodega() {
		return this.mostrarid_calidad_productoBodega;
	}

	public void setMostrarid_calidad_productoBodega(Boolean mostrarid_calidad_productoBodega) {
		this.mostrarid_calidad_productoBodega= mostrarid_calidad_productoBodega;
	}

	public Boolean getActivarid_calidad_productoBodega() {
		return this.activarid_calidad_productoBodega;
	}

	public void setActivarid_calidad_productoBodega(Boolean activarid_calidad_productoBodega) {
		this.activarid_calidad_productoBodega= activarid_calidad_productoBodega;
	}

	public Boolean getCargarid_calidad_productoBodega() {
		return this.cargarid_calidad_productoBodega;
	}

	public void setCargarid_calidad_productoBodega(Boolean cargarid_calidad_productoBodega) {
		this.cargarid_calidad_productoBodega= cargarid_calidad_productoBodega;
	}

	public Border setResaltarcodigoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarcodigoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoBodega() {
		return this.resaltarcodigoBodega;
	}

	public void setResaltarcodigoBodega(Border borderResaltar) {
		this.resaltarcodigoBodega= borderResaltar;
	}

	public Boolean getMostrarcodigoBodega() {
		return this.mostrarcodigoBodega;
	}

	public void setMostrarcodigoBodega(Boolean mostrarcodigoBodega) {
		this.mostrarcodigoBodega= mostrarcodigoBodega;
	}

	public Boolean getActivarcodigoBodega() {
		return this.activarcodigoBodega;
	}

	public void setActivarcodigoBodega(Boolean activarcodigoBodega) {
		this.activarcodigoBodega= activarcodigoBodega;
	}

	public Border setResaltarnombreBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarnombreBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreBodega() {
		return this.resaltarnombreBodega;
	}

	public void setResaltarnombreBodega(Border borderResaltar) {
		this.resaltarnombreBodega= borderResaltar;
	}

	public Boolean getMostrarnombreBodega() {
		return this.mostrarnombreBodega;
	}

	public void setMostrarnombreBodega(Boolean mostrarnombreBodega) {
		this.mostrarnombreBodega= mostrarnombreBodega;
	}

	public Boolean getActivarnombreBodega() {
		return this.activarnombreBodega;
	}

	public void setActivarnombreBodega(Boolean activarnombreBodega) {
		this.activarnombreBodega= activarnombreBodega;
	}

	public Border setResaltarsiglasBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarsiglasBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasBodega() {
		return this.resaltarsiglasBodega;
	}

	public void setResaltarsiglasBodega(Border borderResaltar) {
		this.resaltarsiglasBodega= borderResaltar;
	}

	public Boolean getMostrarsiglasBodega() {
		return this.mostrarsiglasBodega;
	}

	public void setMostrarsiglasBodega(Boolean mostrarsiglasBodega) {
		this.mostrarsiglasBodega= mostrarsiglasBodega;
	}

	public Boolean getActivarsiglasBodega() {
		return this.activarsiglasBodega;
	}

	public void setActivarsiglasBodega(Boolean activarsiglasBodega) {
		this.activarsiglasBodega= activarsiglasBodega;
	}

	public Border setResaltardireccionBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltardireccionBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionBodega() {
		return this.resaltardireccionBodega;
	}

	public void setResaltardireccionBodega(Border borderResaltar) {
		this.resaltardireccionBodega= borderResaltar;
	}

	public Boolean getMostrardireccionBodega() {
		return this.mostrardireccionBodega;
	}

	public void setMostrardireccionBodega(Boolean mostrardireccionBodega) {
		this.mostrardireccionBodega= mostrardireccionBodega;
	}

	public Boolean getActivardireccionBodega() {
		return this.activardireccionBodega;
	}

	public void setActivardireccionBodega(Boolean activardireccionBodega) {
		this.activardireccionBodega= activardireccionBodega;
	}

	public Border setResaltartelefonoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltartelefonoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoBodega() {
		return this.resaltartelefonoBodega;
	}

	public void setResaltartelefonoBodega(Border borderResaltar) {
		this.resaltartelefonoBodega= borderResaltar;
	}

	public Boolean getMostrartelefonoBodega() {
		return this.mostrartelefonoBodega;
	}

	public void setMostrartelefonoBodega(Boolean mostrartelefonoBodega) {
		this.mostrartelefonoBodega= mostrartelefonoBodega;
	}

	public Boolean getActivartelefonoBodega() {
		return this.activartelefonoBodega;
	}

	public void setActivartelefonoBodega(Boolean activartelefonoBodega) {
		this.activartelefonoBodega= activartelefonoBodega;
	}

	public Border setResaltarrucBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarrucBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucBodega() {
		return this.resaltarrucBodega;
	}

	public void setResaltarrucBodega(Border borderResaltar) {
		this.resaltarrucBodega= borderResaltar;
	}

	public Boolean getMostrarrucBodega() {
		return this.mostrarrucBodega;
	}

	public void setMostrarrucBodega(Boolean mostrarrucBodega) {
		this.mostrarrucBodega= mostrarrucBodega;
	}

	public Boolean getActivarrucBodega() {
		return this.activarrucBodega;
	}

	public void setActivarrucBodega(Boolean activarrucBodega) {
		this.activarrucBodega= activarrucBodega;
	}

	public Border setResaltarresponsable_nombreBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarresponsable_nombreBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsable_nombreBodega() {
		return this.resaltarresponsable_nombreBodega;
	}

	public void setResaltarresponsable_nombreBodega(Border borderResaltar) {
		this.resaltarresponsable_nombreBodega= borderResaltar;
	}

	public Boolean getMostrarresponsable_nombreBodega() {
		return this.mostrarresponsable_nombreBodega;
	}

	public void setMostrarresponsable_nombreBodega(Boolean mostrarresponsable_nombreBodega) {
		this.mostrarresponsable_nombreBodega= mostrarresponsable_nombreBodega;
	}

	public Boolean getActivarresponsable_nombreBodega() {
		return this.activarresponsable_nombreBodega;
	}

	public void setActivarresponsable_nombreBodega(Boolean activarresponsable_nombreBodega) {
		this.activarresponsable_nombreBodega= activarresponsable_nombreBodega;
	}

	public Border setResaltardescripcionBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltardescripcionBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionBodega() {
		return this.resaltardescripcionBodega;
	}

	public void setResaltardescripcionBodega(Border borderResaltar) {
		this.resaltardescripcionBodega= borderResaltar;
	}

	public Boolean getMostrardescripcionBodega() {
		return this.mostrardescripcionBodega;
	}

	public void setMostrardescripcionBodega(Boolean mostrardescripcionBodega) {
		this.mostrardescripcionBodega= mostrardescripcionBodega;
	}

	public Boolean getActivardescripcionBodega() {
		return this.activardescripcionBodega;
	}

	public void setActivardescripcionBodega(Boolean activardescripcionBodega) {
		this.activardescripcionBodega= activardescripcionBodega;
	}

	public Border setResaltarid_paisBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_paisBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisBodega() {
		return this.resaltarid_paisBodega;
	}

	public void setResaltarid_paisBodega(Border borderResaltar) {
		this.resaltarid_paisBodega= borderResaltar;
	}

	public Boolean getMostrarid_paisBodega() {
		return this.mostrarid_paisBodega;
	}

	public void setMostrarid_paisBodega(Boolean mostrarid_paisBodega) {
		this.mostrarid_paisBodega= mostrarid_paisBodega;
	}

	public Boolean getActivarid_paisBodega() {
		return this.activarid_paisBodega;
	}

	public void setActivarid_paisBodega(Boolean activarid_paisBodega) {
		this.activarid_paisBodega= activarid_paisBodega;
	}

	public Boolean getCargarid_paisBodega() {
		return this.cargarid_paisBodega;
	}

	public void setCargarid_paisBodega(Boolean cargarid_paisBodega) {
		this.cargarid_paisBodega= cargarid_paisBodega;
	}

	public Border setResaltarid_ciudadBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_ciudadBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadBodega() {
		return this.resaltarid_ciudadBodega;
	}

	public void setResaltarid_ciudadBodega(Border borderResaltar) {
		this.resaltarid_ciudadBodega= borderResaltar;
	}

	public Boolean getMostrarid_ciudadBodega() {
		return this.mostrarid_ciudadBodega;
	}

	public void setMostrarid_ciudadBodega(Boolean mostrarid_ciudadBodega) {
		this.mostrarid_ciudadBodega= mostrarid_ciudadBodega;
	}

	public Boolean getActivarid_ciudadBodega() {
		return this.activarid_ciudadBodega;
	}

	public void setActivarid_ciudadBodega(Boolean activarid_ciudadBodega) {
		this.activarid_ciudadBodega= activarid_ciudadBodega;
	}

	public Boolean getCargarid_ciudadBodega() {
		return this.cargarid_ciudadBodega;
	}

	public void setCargarid_ciudadBodega(Boolean cargarid_ciudadBodega) {
		this.cargarid_ciudadBodega= cargarid_ciudadBodega;
	}

	public Border setResaltarid_centro_costoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoBodega() {
		return this.resaltarid_centro_costoBodega;
	}

	public void setResaltarid_centro_costoBodega(Border borderResaltar) {
		this.resaltarid_centro_costoBodega= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoBodega() {
		return this.mostrarid_centro_costoBodega;
	}

	public void setMostrarid_centro_costoBodega(Boolean mostrarid_centro_costoBodega) {
		this.mostrarid_centro_costoBodega= mostrarid_centro_costoBodega;
	}

	public Boolean getActivarid_centro_costoBodega() {
		return this.activarid_centro_costoBodega;
	}

	public void setActivarid_centro_costoBodega(Boolean activarid_centro_costoBodega) {
		this.activarid_centro_costoBodega= activarid_centro_costoBodega;
	}

	public Boolean getCargarid_centro_costoBodega() {
		return this.cargarid_centro_costoBodega;
	}

	public void setCargarid_centro_costoBodega(Boolean cargarid_centro_costoBodega) {
		this.cargarid_centro_costoBodega= cargarid_centro_costoBodega;
	}

	public Border setResaltarid_empleadoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_empleadoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoBodega() {
		return this.resaltarid_empleadoBodega;
	}

	public void setResaltarid_empleadoBodega(Border borderResaltar) {
		this.resaltarid_empleadoBodega= borderResaltar;
	}

	public Boolean getMostrarid_empleadoBodega() {
		return this.mostrarid_empleadoBodega;
	}

	public void setMostrarid_empleadoBodega(Boolean mostrarid_empleadoBodega) {
		this.mostrarid_empleadoBodega= mostrarid_empleadoBodega;
	}

	public Boolean getActivarid_empleadoBodega() {
		return this.activarid_empleadoBodega;
	}

	public void setActivarid_empleadoBodega(Boolean activarid_empleadoBodega) {
		this.activarid_empleadoBodega= activarid_empleadoBodega;
	}

	public Boolean getCargarid_empleadoBodega() {
		return this.cargarid_empleadoBodega;
	}

	public void setCargarid_empleadoBodega(Boolean cargarid_empleadoBodega) {
		this.cargarid_empleadoBodega= cargarid_empleadoBodega;
	}

	public Border setResaltares_multi_empresaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltares_multi_empresaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_multi_empresaBodega() {
		return this.resaltares_multi_empresaBodega;
	}

	public void setResaltares_multi_empresaBodega(Border borderResaltar) {
		this.resaltares_multi_empresaBodega= borderResaltar;
	}

	public Boolean getMostrares_multi_empresaBodega() {
		return this.mostrares_multi_empresaBodega;
	}

	public void setMostrares_multi_empresaBodega(Boolean mostrares_multi_empresaBodega) {
		this.mostrares_multi_empresaBodega= mostrares_multi_empresaBodega;
	}

	public Boolean getActivares_multi_empresaBodega() {
		return this.activares_multi_empresaBodega;
	}

	public void setActivares_multi_empresaBodega(Boolean activares_multi_empresaBodega) {
		this.activares_multi_empresaBodega= activares_multi_empresaBodega;
	}

	public Border setResaltarcon_mostrar_stockBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarcon_mostrar_stockBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mostrar_stockBodega() {
		return this.resaltarcon_mostrar_stockBodega;
	}

	public void setResaltarcon_mostrar_stockBodega(Border borderResaltar) {
		this.resaltarcon_mostrar_stockBodega= borderResaltar;
	}

	public Boolean getMostrarcon_mostrar_stockBodega() {
		return this.mostrarcon_mostrar_stockBodega;
	}

	public void setMostrarcon_mostrar_stockBodega(Boolean mostrarcon_mostrar_stockBodega) {
		this.mostrarcon_mostrar_stockBodega= mostrarcon_mostrar_stockBodega;
	}

	public Boolean getActivarcon_mostrar_stockBodega() {
		return this.activarcon_mostrar_stockBodega;
	}

	public void setActivarcon_mostrar_stockBodega(Boolean activarcon_mostrar_stockBodega) {
		this.activarcon_mostrar_stockBodega= activarcon_mostrar_stockBodega;
	}

	public Border setResaltares_bodega_transitoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltares_bodega_transitoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_bodega_transitoBodega() {
		return this.resaltares_bodega_transitoBodega;
	}

	public void setResaltares_bodega_transitoBodega(Border borderResaltar) {
		this.resaltares_bodega_transitoBodega= borderResaltar;
	}

	public Boolean getMostrares_bodega_transitoBodega() {
		return this.mostrares_bodega_transitoBodega;
	}

	public void setMostrares_bodega_transitoBodega(Boolean mostrares_bodega_transitoBodega) {
		this.mostrares_bodega_transitoBodega= mostrares_bodega_transitoBodega;
	}

	public Boolean getActivares_bodega_transitoBodega() {
		return this.activares_bodega_transitoBodega;
	}

	public void setActivares_bodega_transitoBodega(Boolean activares_bodega_transitoBodega) {
		this.activares_bodega_transitoBodega= activares_bodega_transitoBodega;
	}

	public Border setResaltarcon_stock_negativoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarcon_stock_negativoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_stock_negativoBodega() {
		return this.resaltarcon_stock_negativoBodega;
	}

	public void setResaltarcon_stock_negativoBodega(Border borderResaltar) {
		this.resaltarcon_stock_negativoBodega= borderResaltar;
	}

	public Boolean getMostrarcon_stock_negativoBodega() {
		return this.mostrarcon_stock_negativoBodega;
	}

	public void setMostrarcon_stock_negativoBodega(Boolean mostrarcon_stock_negativoBodega) {
		this.mostrarcon_stock_negativoBodega= mostrarcon_stock_negativoBodega;
	}

	public Boolean getActivarcon_stock_negativoBodega() {
		return this.activarcon_stock_negativoBodega;
	}

	public void setActivarcon_stock_negativoBodega(Boolean activarcon_stock_negativoBodega) {
		this.activarcon_stock_negativoBodega= activarcon_stock_negativoBodega;
	}

	public Border setResaltarid_cuenta_contable_inventarioBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioBodega() {
		return this.resaltarid_cuenta_contable_inventarioBodega;
	}

	public void setResaltarid_cuenta_contable_inventarioBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioBodega() {
		return this.mostrarid_cuenta_contable_inventarioBodega;
	}

	public void setMostrarid_cuenta_contable_inventarioBodega(Boolean mostrarid_cuenta_contable_inventarioBodega) {
		this.mostrarid_cuenta_contable_inventarioBodega= mostrarid_cuenta_contable_inventarioBodega;
	}

	public Boolean getActivarid_cuenta_contable_inventarioBodega() {
		return this.activarid_cuenta_contable_inventarioBodega;
	}

	public void setActivarid_cuenta_contable_inventarioBodega(Boolean activarid_cuenta_contable_inventarioBodega) {
		this.activarid_cuenta_contable_inventarioBodega= activarid_cuenta_contable_inventarioBodega;
	}

	public Boolean getCargarid_cuenta_contable_inventarioBodega() {
		return this.cargarid_cuenta_contable_inventarioBodega;
	}

	public void setCargarid_cuenta_contable_inventarioBodega(Boolean cargarid_cuenta_contable_inventarioBodega) {
		this.cargarid_cuenta_contable_inventarioBodega= cargarid_cuenta_contable_inventarioBodega;
	}

	public Border setResaltarid_cuenta_contable_costoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoBodega() {
		return this.resaltarid_cuenta_contable_costoBodega;
	}

	public void setResaltarid_cuenta_contable_costoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoBodega() {
		return this.mostrarid_cuenta_contable_costoBodega;
	}

	public void setMostrarid_cuenta_contable_costoBodega(Boolean mostrarid_cuenta_contable_costoBodega) {
		this.mostrarid_cuenta_contable_costoBodega= mostrarid_cuenta_contable_costoBodega;
	}

	public Boolean getActivarid_cuenta_contable_costoBodega() {
		return this.activarid_cuenta_contable_costoBodega;
	}

	public void setActivarid_cuenta_contable_costoBodega(Boolean activarid_cuenta_contable_costoBodega) {
		this.activarid_cuenta_contable_costoBodega= activarid_cuenta_contable_costoBodega;
	}

	public Boolean getCargarid_cuenta_contable_costoBodega() {
		return this.cargarid_cuenta_contable_costoBodega;
	}

	public void setCargarid_cuenta_contable_costoBodega(Boolean cargarid_cuenta_contable_costoBodega) {
		this.cargarid_cuenta_contable_costoBodega= cargarid_cuenta_contable_costoBodega;
	}

	public Border setResaltarid_cuenta_contable_ventaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaBodega() {
		return this.resaltarid_cuenta_contable_ventaBodega;
	}

	public void setResaltarid_cuenta_contable_ventaBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaBodega() {
		return this.mostrarid_cuenta_contable_ventaBodega;
	}

	public void setMostrarid_cuenta_contable_ventaBodega(Boolean mostrarid_cuenta_contable_ventaBodega) {
		this.mostrarid_cuenta_contable_ventaBodega= mostrarid_cuenta_contable_ventaBodega;
	}

	public Boolean getActivarid_cuenta_contable_ventaBodega() {
		return this.activarid_cuenta_contable_ventaBodega;
	}

	public void setActivarid_cuenta_contable_ventaBodega(Boolean activarid_cuenta_contable_ventaBodega) {
		this.activarid_cuenta_contable_ventaBodega= activarid_cuenta_contable_ventaBodega;
	}

	public Boolean getCargarid_cuenta_contable_ventaBodega() {
		return this.cargarid_cuenta_contable_ventaBodega;
	}

	public void setCargarid_cuenta_contable_ventaBodega(Boolean cargarid_cuenta_contable_ventaBodega) {
		this.cargarid_cuenta_contable_ventaBodega= cargarid_cuenta_contable_ventaBodega;
	}

	public Border setResaltarid_cuenta_contable_descuentoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoBodega() {
		return this.resaltarid_cuenta_contable_descuentoBodega;
	}

	public void setResaltarid_cuenta_contable_descuentoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoBodega() {
		return this.mostrarid_cuenta_contable_descuentoBodega;
	}

	public void setMostrarid_cuenta_contable_descuentoBodega(Boolean mostrarid_cuenta_contable_descuentoBodega) {
		this.mostrarid_cuenta_contable_descuentoBodega= mostrarid_cuenta_contable_descuentoBodega;
	}

	public Boolean getActivarid_cuenta_contable_descuentoBodega() {
		return this.activarid_cuenta_contable_descuentoBodega;
	}

	public void setActivarid_cuenta_contable_descuentoBodega(Boolean activarid_cuenta_contable_descuentoBodega) {
		this.activarid_cuenta_contable_descuentoBodega= activarid_cuenta_contable_descuentoBodega;
	}

	public Boolean getCargarid_cuenta_contable_descuentoBodega() {
		return this.cargarid_cuenta_contable_descuentoBodega;
	}

	public void setCargarid_cuenta_contable_descuentoBodega(Boolean cargarid_cuenta_contable_descuentoBodega) {
		this.cargarid_cuenta_contable_descuentoBodega= cargarid_cuenta_contable_descuentoBodega;
	}

	public Border setResaltarid_cuenta_contable_devolucionBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionBodega() {
		return this.resaltarid_cuenta_contable_devolucionBodega;
	}

	public void setResaltarid_cuenta_contable_devolucionBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionBodega() {
		return this.mostrarid_cuenta_contable_devolucionBodega;
	}

	public void setMostrarid_cuenta_contable_devolucionBodega(Boolean mostrarid_cuenta_contable_devolucionBodega) {
		this.mostrarid_cuenta_contable_devolucionBodega= mostrarid_cuenta_contable_devolucionBodega;
	}

	public Boolean getActivarid_cuenta_contable_devolucionBodega() {
		return this.activarid_cuenta_contable_devolucionBodega;
	}

	public void setActivarid_cuenta_contable_devolucionBodega(Boolean activarid_cuenta_contable_devolucionBodega) {
		this.activarid_cuenta_contable_devolucionBodega= activarid_cuenta_contable_devolucionBodega;
	}

	public Boolean getCargarid_cuenta_contable_devolucionBodega() {
		return this.cargarid_cuenta_contable_devolucionBodega;
	}

	public void setCargarid_cuenta_contable_devolucionBodega(Boolean cargarid_cuenta_contable_devolucionBodega) {
		this.cargarid_cuenta_contable_devolucionBodega= cargarid_cuenta_contable_devolucionBodega;
	}

	public Border setResaltarid_cuenta_contable_debitoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoBodega() {
		return this.resaltarid_cuenta_contable_debitoBodega;
	}

	public void setResaltarid_cuenta_contable_debitoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoBodega() {
		return this.mostrarid_cuenta_contable_debitoBodega;
	}

	public void setMostrarid_cuenta_contable_debitoBodega(Boolean mostrarid_cuenta_contable_debitoBodega) {
		this.mostrarid_cuenta_contable_debitoBodega= mostrarid_cuenta_contable_debitoBodega;
	}

	public Boolean getActivarid_cuenta_contable_debitoBodega() {
		return this.activarid_cuenta_contable_debitoBodega;
	}

	public void setActivarid_cuenta_contable_debitoBodega(Boolean activarid_cuenta_contable_debitoBodega) {
		this.activarid_cuenta_contable_debitoBodega= activarid_cuenta_contable_debitoBodega;
	}

	public Boolean getCargarid_cuenta_contable_debitoBodega() {
		return this.cargarid_cuenta_contable_debitoBodega;
	}

	public void setCargarid_cuenta_contable_debitoBodega(Boolean cargarid_cuenta_contable_debitoBodega) {
		this.cargarid_cuenta_contable_debitoBodega= cargarid_cuenta_contable_debitoBodega;
	}

	public Border setResaltarid_cuenta_contable_creditoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoBodega() {
		return this.resaltarid_cuenta_contable_creditoBodega;
	}

	public void setResaltarid_cuenta_contable_creditoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoBodega() {
		return this.mostrarid_cuenta_contable_creditoBodega;
	}

	public void setMostrarid_cuenta_contable_creditoBodega(Boolean mostrarid_cuenta_contable_creditoBodega) {
		this.mostrarid_cuenta_contable_creditoBodega= mostrarid_cuenta_contable_creditoBodega;
	}

	public Boolean getActivarid_cuenta_contable_creditoBodega() {
		return this.activarid_cuenta_contable_creditoBodega;
	}

	public void setActivarid_cuenta_contable_creditoBodega(Boolean activarid_cuenta_contable_creditoBodega) {
		this.activarid_cuenta_contable_creditoBodega= activarid_cuenta_contable_creditoBodega;
	}

	public Boolean getCargarid_cuenta_contable_creditoBodega() {
		return this.cargarid_cuenta_contable_creditoBodega;
	}

	public void setCargarid_cuenta_contable_creditoBodega(Boolean cargarid_cuenta_contable_creditoBodega) {
		this.cargarid_cuenta_contable_creditoBodega= cargarid_cuenta_contable_creditoBodega;
	}

	public Border setResaltarid_cuenta_contable_bonificaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_bonificaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_bonificaBodega() {
		return this.resaltarid_cuenta_contable_bonificaBodega;
	}

	public void setResaltarid_cuenta_contable_bonificaBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_bonificaBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_bonificaBodega() {
		return this.mostrarid_cuenta_contable_bonificaBodega;
	}

	public void setMostrarid_cuenta_contable_bonificaBodega(Boolean mostrarid_cuenta_contable_bonificaBodega) {
		this.mostrarid_cuenta_contable_bonificaBodega= mostrarid_cuenta_contable_bonificaBodega;
	}

	public Boolean getActivarid_cuenta_contable_bonificaBodega() {
		return this.activarid_cuenta_contable_bonificaBodega;
	}

	public void setActivarid_cuenta_contable_bonificaBodega(Boolean activarid_cuenta_contable_bonificaBodega) {
		this.activarid_cuenta_contable_bonificaBodega= activarid_cuenta_contable_bonificaBodega;
	}

	public Boolean getCargarid_cuenta_contable_bonificaBodega() {
		return this.cargarid_cuenta_contable_bonificaBodega;
	}

	public void setCargarid_cuenta_contable_bonificaBodega(Boolean cargarid_cuenta_contable_bonificaBodega) {
		this.cargarid_cuenta_contable_bonificaBodega= cargarid_cuenta_contable_bonificaBodega;
	}

	public Border setResaltarid_cuenta_contable_produccionBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_produccionBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_produccionBodega() {
		return this.resaltarid_cuenta_contable_produccionBodega;
	}

	public void setResaltarid_cuenta_contable_produccionBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_produccionBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_produccionBodega() {
		return this.mostrarid_cuenta_contable_produccionBodega;
	}

	public void setMostrarid_cuenta_contable_produccionBodega(Boolean mostrarid_cuenta_contable_produccionBodega) {
		this.mostrarid_cuenta_contable_produccionBodega= mostrarid_cuenta_contable_produccionBodega;
	}

	public Boolean getActivarid_cuenta_contable_produccionBodega() {
		return this.activarid_cuenta_contable_produccionBodega;
	}

	public void setActivarid_cuenta_contable_produccionBodega(Boolean activarid_cuenta_contable_produccionBodega) {
		this.activarid_cuenta_contable_produccionBodega= activarid_cuenta_contable_produccionBodega;
	}

	public Boolean getCargarid_cuenta_contable_produccionBodega() {
		return this.cargarid_cuenta_contable_produccionBodega;
	}

	public void setCargarid_cuenta_contable_produccionBodega(Boolean cargarid_cuenta_contable_produccionBodega) {
		this.cargarid_cuenta_contable_produccionBodega= cargarid_cuenta_contable_produccionBodega;
	}

	public Border setResaltarid_cuenta_contable_costo_bonificaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaBeanSwingJInternalFrame.jTtoolBarBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_bonificaBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_bonificaBodega() {
		return this.resaltarid_cuenta_contable_costo_bonificaBodega;
	}

	public void setResaltarid_cuenta_contable_costo_bonificaBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_bonificaBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_bonificaBodega() {
		return this.mostrarid_cuenta_contable_costo_bonificaBodega;
	}

	public void setMostrarid_cuenta_contable_costo_bonificaBodega(Boolean mostrarid_cuenta_contable_costo_bonificaBodega) {
		this.mostrarid_cuenta_contable_costo_bonificaBodega= mostrarid_cuenta_contable_costo_bonificaBodega;
	}

	public Boolean getActivarid_cuenta_contable_costo_bonificaBodega() {
		return this.activarid_cuenta_contable_costo_bonificaBodega;
	}

	public void setActivarid_cuenta_contable_costo_bonificaBodega(Boolean activarid_cuenta_contable_costo_bonificaBodega) {
		this.activarid_cuenta_contable_costo_bonificaBodega= activarid_cuenta_contable_costo_bonificaBodega;
	}

	public Boolean getCargarid_cuenta_contable_costo_bonificaBodega() {
		return this.cargarid_cuenta_contable_costo_bonificaBodega;
	}

	public void setCargarid_cuenta_contable_costo_bonificaBodega(Boolean cargarid_cuenta_contable_costo_bonificaBodega) {
		this.cargarid_cuenta_contable_costo_bonificaBodega= cargarid_cuenta_contable_costo_bonificaBodega;
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
		
		
		this.setMostraridBodega(esInicial);
		this.setMostrarid_empresaBodega(esInicial);
		this.setMostrarid_grupo_bodegaBodega(esInicial);
		this.setMostrarid_calidad_productoBodega(esInicial);
		this.setMostrarcodigoBodega(esInicial);
		this.setMostrarnombreBodega(esInicial);
		this.setMostrarsiglasBodega(esInicial);
		this.setMostrardireccionBodega(esInicial);
		this.setMostrartelefonoBodega(esInicial);
		this.setMostrarrucBodega(esInicial);
		this.setMostrarresponsable_nombreBodega(esInicial);
		this.setMostrardescripcionBodega(esInicial);
		this.setMostrarid_paisBodega(esInicial);
		this.setMostrarid_ciudadBodega(esInicial);
		this.setMostrarid_centro_costoBodega(esInicial);
		this.setMostrarid_empleadoBodega(esInicial);
		this.setMostrares_multi_empresaBodega(esInicial);
		this.setMostrarcon_mostrar_stockBodega(esInicial);
		this.setMostrares_bodega_transitoBodega(esInicial);
		this.setMostrarcon_stock_negativoBodega(esInicial);
		this.setMostrarid_cuenta_contable_inventarioBodega(esInicial);
		this.setMostrarid_cuenta_contable_costoBodega(esInicial);
		this.setMostrarid_cuenta_contable_ventaBodega(esInicial);
		this.setMostrarid_cuenta_contable_descuentoBodega(esInicial);
		this.setMostrarid_cuenta_contable_devolucionBodega(esInicial);
		this.setMostrarid_cuenta_contable_debitoBodega(esInicial);
		this.setMostrarid_cuenta_contable_creditoBodega(esInicial);
		this.setMostrarid_cuenta_contable_bonificaBodega(esInicial);
		this.setMostrarid_cuenta_contable_produccionBodega(esInicial);
		this.setMostrarid_cuenta_contable_costo_bonificaBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaConstantesFunciones.ID)) {
				this.setMostraridBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDGRUPOBODEGA)) {
				this.setMostrarid_grupo_bodegaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setMostrarid_calidad_productoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RUC)) {
				this.setMostrarrucBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RESPONSABLENOMBRE)) {
				this.setMostrarresponsable_nombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESMULTIEMPRESA)) {
				this.setMostrares_multi_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONMOSTRARSTOCK)) {
				this.setMostrarcon_mostrar_stockBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESBODEGATRANSITO)) {
				this.setMostrares_bodega_transitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setMostrarcon_stock_negativoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setMostrarid_cuenta_contable_bonificaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setMostrarid_cuenta_contable_produccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setMostrarid_cuenta_contable_costo_bonificaBodega(esAsigna);
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
		
		
		this.setActivaridBodega(esInicial);
		this.setActivarid_empresaBodega(esInicial);
		this.setActivarid_grupo_bodegaBodega(esInicial);
		this.setActivarid_calidad_productoBodega(esInicial);
		this.setActivarcodigoBodega(esInicial);
		this.setActivarnombreBodega(esInicial);
		this.setActivarsiglasBodega(esInicial);
		this.setActivardireccionBodega(esInicial);
		this.setActivartelefonoBodega(esInicial);
		this.setActivarrucBodega(esInicial);
		this.setActivarresponsable_nombreBodega(esInicial);
		this.setActivardescripcionBodega(esInicial);
		this.setActivarid_paisBodega(esInicial);
		this.setActivarid_ciudadBodega(esInicial);
		this.setActivarid_centro_costoBodega(esInicial);
		this.setActivarid_empleadoBodega(esInicial);
		this.setActivares_multi_empresaBodega(esInicial);
		this.setActivarcon_mostrar_stockBodega(esInicial);
		this.setActivares_bodega_transitoBodega(esInicial);
		this.setActivarcon_stock_negativoBodega(esInicial);
		this.setActivarid_cuenta_contable_inventarioBodega(esInicial);
		this.setActivarid_cuenta_contable_costoBodega(esInicial);
		this.setActivarid_cuenta_contable_ventaBodega(esInicial);
		this.setActivarid_cuenta_contable_descuentoBodega(esInicial);
		this.setActivarid_cuenta_contable_devolucionBodega(esInicial);
		this.setActivarid_cuenta_contable_debitoBodega(esInicial);
		this.setActivarid_cuenta_contable_creditoBodega(esInicial);
		this.setActivarid_cuenta_contable_bonificaBodega(esInicial);
		this.setActivarid_cuenta_contable_produccionBodega(esInicial);
		this.setActivarid_cuenta_contable_costo_bonificaBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaConstantesFunciones.ID)) {
				this.setActivaridBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDGRUPOBODEGA)) {
				this.setActivarid_grupo_bodegaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setActivarid_calidad_productoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RUC)) {
				this.setActivarrucBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RESPONSABLENOMBRE)) {
				this.setActivarresponsable_nombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESMULTIEMPRESA)) {
				this.setActivares_multi_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONMOSTRARSTOCK)) {
				this.setActivarcon_mostrar_stockBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESBODEGATRANSITO)) {
				this.setActivares_bodega_transitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setActivarcon_stock_negativoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setActivarid_cuenta_contable_bonificaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setActivarid_cuenta_contable_produccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setActivarid_cuenta_contable_costo_bonificaBodega(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBodega(esInicial);
		this.setResaltarid_empresaBodega(esInicial);
		this.setResaltarid_grupo_bodegaBodega(esInicial);
		this.setResaltarid_calidad_productoBodega(esInicial);
		this.setResaltarcodigoBodega(esInicial);
		this.setResaltarnombreBodega(esInicial);
		this.setResaltarsiglasBodega(esInicial);
		this.setResaltardireccionBodega(esInicial);
		this.setResaltartelefonoBodega(esInicial);
		this.setResaltarrucBodega(esInicial);
		this.setResaltarresponsable_nombreBodega(esInicial);
		this.setResaltardescripcionBodega(esInicial);
		this.setResaltarid_paisBodega(esInicial);
		this.setResaltarid_ciudadBodega(esInicial);
		this.setResaltarid_centro_costoBodega(esInicial);
		this.setResaltarid_empleadoBodega(esInicial);
		this.setResaltares_multi_empresaBodega(esInicial);
		this.setResaltarcon_mostrar_stockBodega(esInicial);
		this.setResaltares_bodega_transitoBodega(esInicial);
		this.setResaltarcon_stock_negativoBodega(esInicial);
		this.setResaltarid_cuenta_contable_inventarioBodega(esInicial);
		this.setResaltarid_cuenta_contable_costoBodega(esInicial);
		this.setResaltarid_cuenta_contable_ventaBodega(esInicial);
		this.setResaltarid_cuenta_contable_descuentoBodega(esInicial);
		this.setResaltarid_cuenta_contable_devolucionBodega(esInicial);
		this.setResaltarid_cuenta_contable_debitoBodega(esInicial);
		this.setResaltarid_cuenta_contable_creditoBodega(esInicial);
		this.setResaltarid_cuenta_contable_bonificaBodega(esInicial);
		this.setResaltarid_cuenta_contable_produccionBodega(esInicial);
		this.setResaltarid_cuenta_contable_costo_bonificaBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaConstantesFunciones.ID)) {
				this.setResaltaridBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDGRUPOBODEGA)) {
				this.setResaltarid_grupo_bodegaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setResaltarid_calidad_productoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RUC)) {
				this.setResaltarrucBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.RESPONSABLENOMBRE)) {
				this.setResaltarresponsable_nombreBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESMULTIEMPRESA)) {
				this.setResaltares_multi_empresaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONMOSTRARSTOCK)) {
				this.setResaltarcon_mostrar_stockBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.ESBODEGATRANSITO)) {
				this.setResaltares_bodega_transitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setResaltarcon_stock_negativoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setResaltarid_cuenta_contable_bonificaBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setResaltarid_cuenta_contable_produccionBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setResaltarid_cuenta_contable_costo_bonificaBodega(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoBodega=true;

	public Boolean getMostrarBusquedaPorCodigoBodega() {
		return this.mostrarBusquedaPorCodigoBodega;
	}

	public void setMostrarBusquedaPorCodigoBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoBodega= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreBodega=true;

	public Boolean getMostrarBusquedaPorNombreBodega() {
		return this.mostrarBusquedaPorNombreBodega;
	}

	public void setMostrarBusquedaPorNombreBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreBodega= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorResponsableNombreBodega=true;

	public Boolean getMostrarBusquedaPorResponsableNombreBodega() {
		return this.mostrarBusquedaPorResponsableNombreBodega;
	}

	public void setMostrarBusquedaPorResponsableNombreBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorResponsableNombreBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCalidadProductoBodega=true;

	public Boolean getMostrarFK_IdCalidadProductoBodega() {
		return this.mostrarFK_IdCalidadProductoBodega;
	}

	public void setMostrarFK_IdCalidadProductoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCalidadProductoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoBodega=true;

	public Boolean getMostrarFK_IdCentroCostoBodega() {
		return this.mostrarFK_IdCentroCostoBodega;
	}

	public void setMostrarFK_IdCentroCostoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoBodega=true;

	public Boolean getMostrarFK_IdEmpleadoBodega() {
		return this.mostrarFK_IdEmpleadoBodega;
	}

	public void setMostrarFK_IdEmpleadoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBodega=true;

	public Boolean getMostrarFK_IdEmpresaBodega() {
		return this.mostrarFK_IdEmpresaBodega;
	}

	public void setMostrarFK_IdEmpresaBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoBodegaBodega=true;

	public Boolean getMostrarFK_IdGrupoBodegaBodega() {
		return this.mostrarFK_IdGrupoBodegaBodega;
	}

	public void setMostrarFK_IdGrupoBodegaBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoBodegaBodega= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoBodega=true;

	public Boolean getActivarBusquedaPorCodigoBodega() {
		return this.activarBusquedaPorCodigoBodega;
	}

	public void setActivarBusquedaPorCodigoBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoBodega= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreBodega=true;

	public Boolean getActivarBusquedaPorNombreBodega() {
		return this.activarBusquedaPorNombreBodega;
	}

	public void setActivarBusquedaPorNombreBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreBodega= habilitarResaltar;
	}

	public Boolean activarBusquedaPorResponsableNombreBodega=true;

	public Boolean getActivarBusquedaPorResponsableNombreBodega() {
		return this.activarBusquedaPorResponsableNombreBodega;
	}

	public void setActivarBusquedaPorResponsableNombreBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorResponsableNombreBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdCalidadProductoBodega=true;

	public Boolean getActivarFK_IdCalidadProductoBodega() {
		return this.activarFK_IdCalidadProductoBodega;
	}

	public void setActivarFK_IdCalidadProductoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdCalidadProductoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoBodega=true;

	public Boolean getActivarFK_IdCentroCostoBodega() {
		return this.activarFK_IdCentroCostoBodega;
	}

	public void setActivarFK_IdCentroCostoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoBodega=true;

	public Boolean getActivarFK_IdEmpleadoBodega() {
		return this.activarFK_IdEmpleadoBodega;
	}

	public void setActivarFK_IdEmpleadoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBodega=true;

	public Boolean getActivarFK_IdEmpresaBodega() {
		return this.activarFK_IdEmpresaBodega;
	}

	public void setActivarFK_IdEmpresaBodega(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoBodegaBodega=true;

	public Boolean getActivarFK_IdGrupoBodegaBodega() {
		return this.activarFK_IdGrupoBodegaBodega;
	}

	public void setActivarFK_IdGrupoBodegaBodega(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoBodegaBodega= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoBodega=null;

	public Border getResaltarBusquedaPorCodigoBodega() {
		return this.resaltarBusquedaPorCodigoBodega;
	}

	public void setResaltarBusquedaPorCodigoBodega(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoBodega= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreBodega=null;

	public Border getResaltarBusquedaPorNombreBodega() {
		return this.resaltarBusquedaPorNombreBodega;
	}

	public void setResaltarBusquedaPorNombreBodega(Border borderResaltar) {
		this.resaltarBusquedaPorNombreBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreBodega= borderResaltar;
	}

	public Border resaltarBusquedaPorResponsableNombreBodega=null;

	public Border getResaltarBusquedaPorResponsableNombreBodega() {
		return this.resaltarBusquedaPorResponsableNombreBodega;
	}

	public void setResaltarBusquedaPorResponsableNombreBodega(Border borderResaltar) {
		this.resaltarBusquedaPorResponsableNombreBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorResponsableNombreBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorResponsableNombreBodega= borderResaltar;
	}

	public Border resaltarFK_IdCalidadProductoBodega=null;

	public Border getResaltarFK_IdCalidadProductoBodega() {
		return this.resaltarFK_IdCalidadProductoBodega;
	}

	public void setResaltarFK_IdCalidadProductoBodega(Border borderResaltar) {
		this.resaltarFK_IdCalidadProductoBodega= borderResaltar;
	}

	public void setResaltarFK_IdCalidadProductoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCalidadProductoBodega= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoBodega=null;

	public Border getResaltarFK_IdCentroCostoBodega() {
		return this.resaltarFK_IdCentroCostoBodega;
	}

	public void setResaltarFK_IdCentroCostoBodega(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoBodega= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoBodega= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoBodega=null;

	public Border getResaltarFK_IdEmpleadoBodega() {
		return this.resaltarFK_IdEmpleadoBodega;
	}

	public void setResaltarFK_IdEmpleadoBodega(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoBodega= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoBodega= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBodega=null;

	public Border getResaltarFK_IdEmpresaBodega() {
		return this.resaltarFK_IdEmpresaBodega;
	}

	public void setResaltarFK_IdEmpresaBodega(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBodega= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBodega= borderResaltar;
	}

	public Border resaltarFK_IdGrupoBodegaBodega=null;

	public Border getResaltarFK_IdGrupoBodegaBodega() {
		return this.resaltarFK_IdGrupoBodegaBodega;
	}

	public void setResaltarFK_IdGrupoBodegaBodega(Border borderResaltar) {
		this.resaltarFK_IdGrupoBodegaBodega= borderResaltar;
	}

	public void setResaltarFK_IdGrupoBodegaBodega(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaBeanSwingJInternalFrame bodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoBodegaBodega= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}