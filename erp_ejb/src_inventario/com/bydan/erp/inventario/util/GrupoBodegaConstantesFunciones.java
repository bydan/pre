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


import com.bydan.erp.inventario.util.GrupoBodegaConstantesFunciones;
import com.bydan.erp.inventario.util.GrupoBodegaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.GrupoBodegaParameterGeneral;

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
final public class GrupoBodegaConstantesFunciones extends GrupoBodegaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoBodega";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoBodega"+GrupoBodegaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoBodegaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoBodegaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoBodegaConstantesFunciones.SCHEMA+"_"+GrupoBodegaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoBodegaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoBodegaConstantesFunciones.SCHEMA+"_"+GrupoBodegaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoBodegaConstantesFunciones.SCHEMA+"_"+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoBodegaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoBodegaConstantesFunciones.SCHEMA+"_"+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoBodegaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoBodegaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoBodegaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoBodegaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoBodegaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoBodegaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoBodegaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Bodegaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Grupo Bodega";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Bodega";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoBodega";
	public static final String OBJECTNAME="grupobodega";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="grupo_bodega";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupobodega from "+GrupoBodegaConstantesFunciones.SPERSISTENCENAME+" grupobodega";
	public static String QUERYSELECTNATIVE="select "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".version_row,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_empresa,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".codigo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".nombre,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".ruc,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".direccion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".telefono,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_pais,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_ciudad,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_centro_costo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_empleado,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".descripcion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME;//+" as "+GrupoBodegaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GrupoBodegaConstantesFuncionesAdditional grupobodegaConstantesFuncionesAdditional=null;
	
	public GrupoBodegaConstantesFuncionesAdditional getGrupoBodegaConstantesFuncionesAdditional() {
		return this.grupobodegaConstantesFuncionesAdditional;
	}
	
	public void setGrupoBodegaConstantesFuncionesAdditional(GrupoBodegaConstantesFuncionesAdditional grupobodegaConstantesFuncionesAdditional) {
		try {
			this.grupobodegaConstantesFuncionesAdditional=grupobodegaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String RUC= "ruc";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String IDCUENTACONTABLEPRODUCCION= "id_cuenta_contable_produccion";
    public static final String IDCUENTACONTABLEBONIFICA= "id_cuenta_contable_bonifica";
    public static final String IDCUENTACONTABLECOSTOBONIFICA= "id_cuenta_contable_costo_bonifica";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
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
    	public static final String LABEL_IDCUENTACONTABLEPRODUCCION= "Cuenta C. Produccion";
		public static final String LABEL_IDCUENTACONTABLEPRODUCCION_LOWER= "Cuenta Contable Produccion";
    	public static final String LABEL_IDCUENTACONTABLEBONIFICA= "Cuenta C. Bonifica";
		public static final String LABEL_IDCUENTACONTABLEBONIFICA_LOWER= "Cuenta Contable Bonifica";
    	public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA= "Cuenta C. Costo Bonifica";
		public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA_LOWER= "Cuenta Contable Costo Bonifica";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	
	public static String getGrupoBodegaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDEMPRESA)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.CODIGO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.NOMBRE)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.RUC)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.DIRECCION)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.TELEFONO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDPAIS)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCIUDAD)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.DESCRIPCION)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA;}
		if(sNombreColumna.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {sLabelColumna=GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGrupoBodegaDescripcion(GrupoBodega grupobodega) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupobodega !=null/* && grupobodega.getId()!=0*/) {
			sDescripcion=grupobodega.getcodigo();//grupobodegagrupobodega.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoBodegaDescripcionDetallado(GrupoBodega grupobodega) {
		String sDescripcion="";
			
		sDescripcion+=GrupoBodegaConstantesFunciones.ID+"=";
		sDescripcion+=grupobodega.getId().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupobodega.getVersionRow().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=grupobodega.getid_empresa().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.CODIGO+"=";
		sDescripcion+=grupobodega.getcodigo()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=grupobodega.getnombre()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.RUC+"=";
		sDescripcion+=grupobodega.getruc()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=grupobodega.getdireccion()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=grupobodega.gettelefono()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=grupobodega.getid_pais().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=grupobodega.getid_ciudad().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=grupobodega.getid_centro_costo().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=grupobodega.getid_empleado().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=grupobodega.getdescripcion()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_produccion().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_bonifica().toString()+",";
		sDescripcion+=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA+"=";
		sDescripcion+=grupobodega.getid_cuenta_contable_costo_bonifica().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoBodegaDescripcion(GrupoBodega grupobodega,String sValor) throws Exception {			
		if(grupobodega !=null) {
			grupobodega.setcodigo(sValor);;//grupobodegagrupobodega.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCuentaContableProduccionDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("BusquedaPorTelefono")) {
			sNombreIndice="Tipo=  Por Telefono";
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
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorIdEmpresaPorNombre")) {
			sNombreIndice="Tipo=  Por Empresa Por Nombre";
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

	public static String getDetalleIndiceBusquedaPorTelefono(String telefono) {
		String sDetalleIndice=" Parametros->";
		if(telefono!=null) {sDetalleIndice+=" Telefono="+telefono;} 

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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdEmpresaPorNombre(Long id_empresa,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGrupoBodega(GrupoBodega grupobodega,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		grupobodega.setcodigo(grupobodega.getcodigo().trim());
		grupobodega.setnombre(grupobodega.getnombre().trim());
		grupobodega.setruc(grupobodega.getruc().trim());
		grupobodega.setdireccion(grupobodega.getdireccion().trim());
		grupobodega.settelefono(grupobodega.gettelefono().trim());
		grupobodega.setdescripcion(grupobodega.getdescripcion().trim());
	}
	
	public static void quitarEspaciosGrupoBodegas(List<GrupoBodega> grupobodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoBodega grupobodega: grupobodegas) {
			grupobodega.setcodigo(grupobodega.getcodigo().trim());
			grupobodega.setnombre(grupobodega.getnombre().trim());
			grupobodega.setruc(grupobodega.getruc().trim());
			grupobodega.setdireccion(grupobodega.getdireccion().trim());
			grupobodega.settelefono(grupobodega.gettelefono().trim());
			grupobodega.setdescripcion(grupobodega.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoBodega(GrupoBodega grupobodega,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupobodega.getConCambioAuxiliar()) {
			grupobodega.setIsDeleted(grupobodega.getIsDeletedAuxiliar());	
			grupobodega.setIsNew(grupobodega.getIsNewAuxiliar());	
			grupobodega.setIsChanged(grupobodega.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupobodega.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupobodega.setIsDeletedAuxiliar(false);	
			grupobodega.setIsNewAuxiliar(false);	
			grupobodega.setIsChangedAuxiliar(false);
			
			grupobodega.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoBodegas(List<GrupoBodega> grupobodegas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoBodega grupobodega : grupobodegas) {
			if(conAsignarBase && grupobodega.getConCambioAuxiliar()) {
				grupobodega.setIsDeleted(grupobodega.getIsDeletedAuxiliar());	
				grupobodega.setIsNew(grupobodega.getIsNewAuxiliar());	
				grupobodega.setIsChanged(grupobodega.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupobodega.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupobodega.setIsDeletedAuxiliar(false);	
				grupobodega.setIsNewAuxiliar(false);	
				grupobodega.setIsChangedAuxiliar(false);
				
				grupobodega.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoBodega(GrupoBodega grupobodega,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGrupoBodegas(List<GrupoBodega> grupobodegas,Boolean conEnteros) throws Exception  {
		
		for(GrupoBodega grupobodega: grupobodegas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoBodega(List<GrupoBodega> grupobodegas,GrupoBodega grupobodegaAux) throws Exception  {
		GrupoBodegaConstantesFunciones.InicializarValoresGrupoBodega(grupobodegaAux,true);
		
		for(GrupoBodega grupobodega: grupobodegas) {
			if(grupobodega.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoBodega(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoBodegaConstantesFunciones.getArrayColumnasGlobalesGrupoBodega(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoBodega(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoBodegaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoBodegaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoBodega(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoBodega> grupobodegas,GrupoBodega grupobodega,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoBodega grupobodegaAux: grupobodegas) {
			if(grupobodegaAux!=null && grupobodega!=null) {
				if((grupobodegaAux.getId()==null && grupobodega.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupobodegaAux.getId()!=null && grupobodega.getId()!=null){
					if(grupobodegaAux.getId().equals(grupobodega.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoBodega(List<GrupoBodega> grupobodegas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoBodega grupobodega: grupobodegas) {			
			if(grupobodega.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoBodega() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_ID, GrupoBodegaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_VERSIONROW, GrupoBodegaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDEMPRESA, GrupoBodegaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_CODIGO, GrupoBodegaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_NOMBRE, GrupoBodegaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_RUC, GrupoBodegaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_DIRECCION, GrupoBodegaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_TELEFONO, GrupoBodegaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDPAIS, GrupoBodegaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCIUDAD, GrupoBodegaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCENTROCOSTO, GrupoBodegaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDEMPLEADO, GrupoBodegaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_DESCRIPCION, GrupoBodegaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA, GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA, GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoBodega() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoBodega() throws Exception  {
		return GrupoBodegaConstantesFunciones.getTiposSeleccionarGrupoBodega(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoBodega(Boolean conFk) throws Exception  {
		return GrupoBodegaConstantesFunciones.getTiposSeleccionarGrupoBodega(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoBodega(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
			reporte.setsDescripcion(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoBodega(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoBodega(GrupoBodega grupobodegaAux) throws Exception {
		
			grupobodegaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupobodegaAux.getEmpresa()));
			grupobodegaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(grupobodegaAux.getPais()));
			grupobodegaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(grupobodegaAux.getCiudad()));
			grupobodegaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(grupobodegaAux.getCentroCosto()));
			grupobodegaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(grupobodegaAux.getEmpleado()));
			grupobodegaAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableInventario()));
			grupobodegaAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCosto()));
			grupobodegaAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableVenta()));
			grupobodegaAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDescuento()));
			grupobodegaAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDevolucion()));
			grupobodegaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDebito()));
			grupobodegaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCredito()));
			grupobodegaAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableProduccion()));
			grupobodegaAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableBonifica()));
			grupobodegaAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCostoBonifica()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoBodega(List<GrupoBodega> grupobodegasTemp) throws Exception {
		for(GrupoBodega grupobodegaAux:grupobodegasTemp) {
			
			grupobodegaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupobodegaAux.getEmpresa()));
			grupobodegaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(grupobodegaAux.getPais()));
			grupobodegaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(grupobodegaAux.getCiudad()));
			grupobodegaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(grupobodegaAux.getCentroCosto()));
			grupobodegaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(grupobodegaAux.getEmpleado()));
			grupobodegaAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableInventario()));
			grupobodegaAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCosto()));
			grupobodegaAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableVenta()));
			grupobodegaAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDescuento()));
			grupobodegaAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDevolucion()));
			grupobodegaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableDebito()));
			grupobodegaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCredito()));
			grupobodegaAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableProduccion()));
			grupobodegaAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableBonifica()));
			grupobodegaAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupobodegaAux.getCuentaContableCostoBonifica()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoBodegaConstantesFunciones.getClassesRelationshipsOfGrupoBodega(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoBodegaConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoBodega(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoBodega(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	public static void actualizarLista(GrupoBodega grupobodega,List<GrupoBodega> grupobodegas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoBodega grupobodegaEncontrado=null;
			
			for(GrupoBodega grupobodegaLocal:grupobodegas) {
				if(grupobodegaLocal.getId().equals(grupobodega.getId())) {
					grupobodegaEncontrado=grupobodegaLocal;
					
					grupobodegaLocal.setIsChanged(grupobodega.getIsChanged());
					grupobodegaLocal.setIsNew(grupobodega.getIsNew());
					grupobodegaLocal.setIsDeleted(grupobodega.getIsDeleted());
					
					grupobodegaLocal.setGeneralEntityOriginal(grupobodega.getGeneralEntityOriginal());
					
					grupobodegaLocal.setId(grupobodega.getId());	
					grupobodegaLocal.setVersionRow(grupobodega.getVersionRow());	
					grupobodegaLocal.setid_empresa(grupobodega.getid_empresa());	
					grupobodegaLocal.setcodigo(grupobodega.getcodigo());	
					grupobodegaLocal.setnombre(grupobodega.getnombre());	
					grupobodegaLocal.setruc(grupobodega.getruc());	
					grupobodegaLocal.setdireccion(grupobodega.getdireccion());	
					grupobodegaLocal.settelefono(grupobodega.gettelefono());	
					grupobodegaLocal.setid_pais(grupobodega.getid_pais());	
					grupobodegaLocal.setid_ciudad(grupobodega.getid_ciudad());	
					grupobodegaLocal.setid_centro_costo(grupobodega.getid_centro_costo());	
					grupobodegaLocal.setid_empleado(grupobodega.getid_empleado());	
					grupobodegaLocal.setdescripcion(grupobodega.getdescripcion());	
					grupobodegaLocal.setid_cuenta_contable_inventario(grupobodega.getid_cuenta_contable_inventario());	
					grupobodegaLocal.setid_cuenta_contable_costo(grupobodega.getid_cuenta_contable_costo());	
					grupobodegaLocal.setid_cuenta_contable_venta(grupobodega.getid_cuenta_contable_venta());	
					grupobodegaLocal.setid_cuenta_contable_descuento(grupobodega.getid_cuenta_contable_descuento());	
					grupobodegaLocal.setid_cuenta_contable_devolucion(grupobodega.getid_cuenta_contable_devolucion());	
					grupobodegaLocal.setid_cuenta_contable_debito(grupobodega.getid_cuenta_contable_debito());	
					grupobodegaLocal.setid_cuenta_contable_credito(grupobodega.getid_cuenta_contable_credito());	
					grupobodegaLocal.setid_cuenta_contable_produccion(grupobodega.getid_cuenta_contable_produccion());	
					grupobodegaLocal.setid_cuenta_contable_bonifica(grupobodega.getid_cuenta_contable_bonifica());	
					grupobodegaLocal.setid_cuenta_contable_costo_bonifica(grupobodega.getid_cuenta_contable_costo_bonifica());	
					
					
					grupobodegaLocal.setBodegas(grupobodega.getBodegas());
					grupobodegaLocal.setParametroInventarioDefectos(grupobodega.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!grupobodega.getIsDeleted()) {
				if(!existe) {
					grupobodegas.add(grupobodega);
				}
			} else {
				if(grupobodegaEncontrado!=null && permiteQuitar)  {
					grupobodegas.remove(grupobodegaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoBodega grupobodega,List<GrupoBodega> grupobodegas) throws Exception {
		try	{			
			for(GrupoBodega grupobodegaLocal:grupobodegas) {
				if(grupobodegaLocal.getId().equals(grupobodega.getId())) {
					grupobodegaLocal.setIsSelected(grupobodega.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoBodega(List<GrupoBodega> grupobodegasAux) throws Exception {
		//this.grupobodegasAux=grupobodegasAux;
		
		for(GrupoBodega grupobodegaAux:grupobodegasAux) {
			if(grupobodegaAux.getIsChanged()) {
				grupobodegaAux.setIsChanged(false);
			}		
			
			if(grupobodegaAux.getIsNew()) {
				grupobodegaAux.setIsNew(false);
			}	
			
			if(grupobodegaAux.getIsDeleted()) {
				grupobodegaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoBodega(GrupoBodega grupobodegaAux) throws Exception {
		//this.grupobodegaAux=grupobodegaAux;
		
			if(grupobodegaAux.getIsChanged()) {
				grupobodegaAux.setIsChanged(false);
			}		
			
			if(grupobodegaAux.getIsNew()) {
				grupobodegaAux.setIsNew(false);
			}	
			
			if(grupobodegaAux.getIsDeleted()) {
				grupobodegaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoBodega grupobodegaAsignar,GrupoBodega grupobodega) throws Exception {
		grupobodegaAsignar.setId(grupobodega.getId());	
		grupobodegaAsignar.setVersionRow(grupobodega.getVersionRow());	
		grupobodegaAsignar.setid_empresa(grupobodega.getid_empresa());
		grupobodegaAsignar.setempresa_descripcion(grupobodega.getempresa_descripcion());	
		grupobodegaAsignar.setcodigo(grupobodega.getcodigo());	
		grupobodegaAsignar.setnombre(grupobodega.getnombre());	
		grupobodegaAsignar.setruc(grupobodega.getruc());	
		grupobodegaAsignar.setdireccion(grupobodega.getdireccion());	
		grupobodegaAsignar.settelefono(grupobodega.gettelefono());	
		grupobodegaAsignar.setid_pais(grupobodega.getid_pais());
		grupobodegaAsignar.setpais_descripcion(grupobodega.getpais_descripcion());	
		grupobodegaAsignar.setid_ciudad(grupobodega.getid_ciudad());
		grupobodegaAsignar.setciudad_descripcion(grupobodega.getciudad_descripcion());	
		grupobodegaAsignar.setid_centro_costo(grupobodega.getid_centro_costo());
		grupobodegaAsignar.setcentrocosto_descripcion(grupobodega.getcentrocosto_descripcion());	
		grupobodegaAsignar.setid_empleado(grupobodega.getid_empleado());
		grupobodegaAsignar.setempleado_descripcion(grupobodega.getempleado_descripcion());	
		grupobodegaAsignar.setdescripcion(grupobodega.getdescripcion());	
		grupobodegaAsignar.setid_cuenta_contable_inventario(grupobodega.getid_cuenta_contable_inventario());
		grupobodegaAsignar.setcuentacontableinventario_descripcion(grupobodega.getcuentacontableinventario_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_costo(grupobodega.getid_cuenta_contable_costo());
		grupobodegaAsignar.setcuentacontablecosto_descripcion(grupobodega.getcuentacontablecosto_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_venta(grupobodega.getid_cuenta_contable_venta());
		grupobodegaAsignar.setcuentacontableventa_descripcion(grupobodega.getcuentacontableventa_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_descuento(grupobodega.getid_cuenta_contable_descuento());
		grupobodegaAsignar.setcuentacontabledescuento_descripcion(grupobodega.getcuentacontabledescuento_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_devolucion(grupobodega.getid_cuenta_contable_devolucion());
		grupobodegaAsignar.setcuentacontabledevolucion_descripcion(grupobodega.getcuentacontabledevolucion_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_debito(grupobodega.getid_cuenta_contable_debito());
		grupobodegaAsignar.setcuentacontabledebito_descripcion(grupobodega.getcuentacontabledebito_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_credito(grupobodega.getid_cuenta_contable_credito());
		grupobodegaAsignar.setcuentacontablecredito_descripcion(grupobodega.getcuentacontablecredito_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_produccion(grupobodega.getid_cuenta_contable_produccion());
		grupobodegaAsignar.setcuentacontableproduccion_descripcion(grupobodega.getcuentacontableproduccion_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_bonifica(grupobodega.getid_cuenta_contable_bonifica());
		grupobodegaAsignar.setcuentacontablebonifica_descripcion(grupobodega.getcuentacontablebonifica_descripcion());	
		grupobodegaAsignar.setid_cuenta_contable_costo_bonifica(grupobodega.getid_cuenta_contable_costo_bonifica());
		grupobodegaAsignar.setcuentacontablecostobonifica_descripcion(grupobodega.getcuentacontablecostobonifica_descripcion());	
	}
	
	public static void inicializarGrupoBodega(GrupoBodega grupobodega) throws Exception {
		try {
				grupobodega.setId(0L);	
					
				grupobodega.setid_empresa(-1L);	
				grupobodega.setcodigo("");	
				grupobodega.setnombre("");	
				grupobodega.setruc("");	
				grupobodega.setdireccion("");	
				grupobodega.settelefono("");	
				grupobodega.setid_pais(-1L);	
				grupobodega.setid_ciudad(-1L);	
				grupobodega.setid_centro_costo(null);	
				grupobodega.setid_empleado(-1L);	
				grupobodega.setdescripcion("");	
				grupobodega.setid_cuenta_contable_inventario(-1L);	
				grupobodega.setid_cuenta_contable_costo(-1L);	
				grupobodega.setid_cuenta_contable_venta(-1L);	
				grupobodega.setid_cuenta_contable_descuento(-1L);	
				grupobodega.setid_cuenta_contable_devolucion(-1L);	
				grupobodega.setid_cuenta_contable_debito(null);	
				grupobodega.setid_cuenta_contable_credito(null);	
				grupobodega.setid_cuenta_contable_produccion(-1L);	
				grupobodega.setid_cuenta_contable_bonifica(-1L);	
				grupobodega.setid_cuenta_contable_costo_bonifica(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoBodega(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoBodegaConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoBodega(String sTipo,Row row,Workbook workbook,GrupoBodega grupobodega,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontableproduccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontablebonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupobodega.getcuentacontablecostobonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoBodega=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoBodega() {
		return this.sFinalQueryGrupoBodega;
	}
	
	public void setsFinalQueryGrupoBodega(String sFinalQueryGrupoBodega) {
		this.sFinalQueryGrupoBodega= sFinalQueryGrupoBodega;
	}
	
	public Border resaltarSeleccionarGrupoBodega=null;
	
	public Border setResaltarSeleccionarGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoBodega= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoBodega() {
		return this.resaltarSeleccionarGrupoBodega;
	}
	
	public void setResaltarSeleccionarGrupoBodega(Border borderResaltarSeleccionarGrupoBodega) {
		this.resaltarSeleccionarGrupoBodega= borderResaltarSeleccionarGrupoBodega;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoBodega=null;
	public Boolean mostraridGrupoBodega=true;
	public Boolean activaridGrupoBodega=true;

	public Border resaltarid_empresaGrupoBodega=null;
	public Boolean mostrarid_empresaGrupoBodega=true;
	public Boolean activarid_empresaGrupoBodega=true;
	public Boolean cargarid_empresaGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGrupoBodega=false;//ConEventDepend=true

	public Border resaltarcodigoGrupoBodega=null;
	public Boolean mostrarcodigoGrupoBodega=true;
	public Boolean activarcodigoGrupoBodega=true;

	public Border resaltarnombreGrupoBodega=null;
	public Boolean mostrarnombreGrupoBodega=true;
	public Boolean activarnombreGrupoBodega=true;

	public Border resaltarrucGrupoBodega=null;
	public Boolean mostrarrucGrupoBodega=true;
	public Boolean activarrucGrupoBodega=true;

	public Border resaltardireccionGrupoBodega=null;
	public Boolean mostrardireccionGrupoBodega=true;
	public Boolean activardireccionGrupoBodega=true;

	public Border resaltartelefonoGrupoBodega=null;
	public Boolean mostrartelefonoGrupoBodega=true;
	public Boolean activartelefonoGrupoBodega=true;

	public Border resaltarid_paisGrupoBodega=null;
	public Boolean mostrarid_paisGrupoBodega=true;
	public Boolean activarid_paisGrupoBodega=true;
	public Boolean cargarid_paisGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_ciudadGrupoBodega=null;
	public Boolean mostrarid_ciudadGrupoBodega=true;
	public Boolean activarid_ciudadGrupoBodega=true;
	public Boolean cargarid_ciudadGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_centro_costoGrupoBodega=null;
	public Boolean mostrarid_centro_costoGrupoBodega=true;
	public Boolean activarid_centro_costoGrupoBodega=true;
	public Boolean cargarid_centro_costoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_empleadoGrupoBodega=null;
	public Boolean mostrarid_empleadoGrupoBodega=true;
	public Boolean activarid_empleadoGrupoBodega=true;
	public Boolean cargarid_empleadoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoGrupoBodega=false;//ConEventDepend=true

	public Border resaltardescripcionGrupoBodega=null;
	public Boolean mostrardescripcionGrupoBodega=true;
	public Boolean activardescripcionGrupoBodega=true;

	public Border resaltarid_cuenta_contable_inventarioGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_inventarioGrupoBodega=true;
	public Boolean activarid_cuenta_contable_inventarioGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_inventarioGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_costoGrupoBodega=true;
	public Boolean activarid_cuenta_contable_costoGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_costoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_ventaGrupoBodega=true;
	public Boolean activarid_cuenta_contable_ventaGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_ventaGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_descuentoGrupoBodega=true;
	public Boolean activarid_cuenta_contable_descuentoGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_descuentoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_devolucionGrupoBodega=true;
	public Boolean activarid_cuenta_contable_devolucionGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_devolucionGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_debitoGrupoBodega=true;
	public Boolean activarid_cuenta_contable_debitoGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_debitoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_creditoGrupoBodega=true;
	public Boolean activarid_cuenta_contable_creditoGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_creditoGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_produccionGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_produccionGrupoBodega=true;
	public Boolean activarid_cuenta_contable_produccionGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_produccionGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_produccionGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_bonificaGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_bonificaGrupoBodega=true;
	public Boolean activarid_cuenta_contable_bonificaGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_bonificaGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_bonificaGrupoBodega=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_bonificaGrupoBodega=null;
	public Boolean mostrarid_cuenta_contable_costo_bonificaGrupoBodega=true;
	public Boolean activarid_cuenta_contable_costo_bonificaGrupoBodega=true;
	public Boolean cargarid_cuenta_contable_costo_bonificaGrupoBodega=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_bonificaGrupoBodega=false;//ConEventDepend=true

	
	

	public Border setResaltaridGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltaridGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoBodega() {
		return this.resaltaridGrupoBodega;
	}

	public void setResaltaridGrupoBodega(Border borderResaltar) {
		this.resaltaridGrupoBodega= borderResaltar;
	}

	public Boolean getMostraridGrupoBodega() {
		return this.mostraridGrupoBodega;
	}

	public void setMostraridGrupoBodega(Boolean mostraridGrupoBodega) {
		this.mostraridGrupoBodega= mostraridGrupoBodega;
	}

	public Boolean getActivaridGrupoBodega() {
		return this.activaridGrupoBodega;
	}

	public void setActivaridGrupoBodega(Boolean activaridGrupoBodega) {
		this.activaridGrupoBodega= activaridGrupoBodega;
	}

	public Border setResaltarid_empresaGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_empresaGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGrupoBodega() {
		return this.resaltarid_empresaGrupoBodega;
	}

	public void setResaltarid_empresaGrupoBodega(Border borderResaltar) {
		this.resaltarid_empresaGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_empresaGrupoBodega() {
		return this.mostrarid_empresaGrupoBodega;
	}

	public void setMostrarid_empresaGrupoBodega(Boolean mostrarid_empresaGrupoBodega) {
		this.mostrarid_empresaGrupoBodega= mostrarid_empresaGrupoBodega;
	}

	public Boolean getActivarid_empresaGrupoBodega() {
		return this.activarid_empresaGrupoBodega;
	}

	public void setActivarid_empresaGrupoBodega(Boolean activarid_empresaGrupoBodega) {
		this.activarid_empresaGrupoBodega= activarid_empresaGrupoBodega;
	}

	public Boolean getCargarid_empresaGrupoBodega() {
		return this.cargarid_empresaGrupoBodega;
	}

	public void setCargarid_empresaGrupoBodega(Boolean cargarid_empresaGrupoBodega) {
		this.cargarid_empresaGrupoBodega= cargarid_empresaGrupoBodega;
	}

	public Border setResaltarcodigoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarcodigoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoGrupoBodega() {
		return this.resaltarcodigoGrupoBodega;
	}

	public void setResaltarcodigoGrupoBodega(Border borderResaltar) {
		this.resaltarcodigoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarcodigoGrupoBodega() {
		return this.mostrarcodigoGrupoBodega;
	}

	public void setMostrarcodigoGrupoBodega(Boolean mostrarcodigoGrupoBodega) {
		this.mostrarcodigoGrupoBodega= mostrarcodigoGrupoBodega;
	}

	public Boolean getActivarcodigoGrupoBodega() {
		return this.activarcodigoGrupoBodega;
	}

	public void setActivarcodigoGrupoBodega(Boolean activarcodigoGrupoBodega) {
		this.activarcodigoGrupoBodega= activarcodigoGrupoBodega;
	}

	public Border setResaltarnombreGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarnombreGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreGrupoBodega() {
		return this.resaltarnombreGrupoBodega;
	}

	public void setResaltarnombreGrupoBodega(Border borderResaltar) {
		this.resaltarnombreGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarnombreGrupoBodega() {
		return this.mostrarnombreGrupoBodega;
	}

	public void setMostrarnombreGrupoBodega(Boolean mostrarnombreGrupoBodega) {
		this.mostrarnombreGrupoBodega= mostrarnombreGrupoBodega;
	}

	public Boolean getActivarnombreGrupoBodega() {
		return this.activarnombreGrupoBodega;
	}

	public void setActivarnombreGrupoBodega(Boolean activarnombreGrupoBodega) {
		this.activarnombreGrupoBodega= activarnombreGrupoBodega;
	}

	public Border setResaltarrucGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarrucGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucGrupoBodega() {
		return this.resaltarrucGrupoBodega;
	}

	public void setResaltarrucGrupoBodega(Border borderResaltar) {
		this.resaltarrucGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarrucGrupoBodega() {
		return this.mostrarrucGrupoBodega;
	}

	public void setMostrarrucGrupoBodega(Boolean mostrarrucGrupoBodega) {
		this.mostrarrucGrupoBodega= mostrarrucGrupoBodega;
	}

	public Boolean getActivarrucGrupoBodega() {
		return this.activarrucGrupoBodega;
	}

	public void setActivarrucGrupoBodega(Boolean activarrucGrupoBodega) {
		this.activarrucGrupoBodega= activarrucGrupoBodega;
	}

	public Border setResaltardireccionGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltardireccionGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionGrupoBodega() {
		return this.resaltardireccionGrupoBodega;
	}

	public void setResaltardireccionGrupoBodega(Border borderResaltar) {
		this.resaltardireccionGrupoBodega= borderResaltar;
	}

	public Boolean getMostrardireccionGrupoBodega() {
		return this.mostrardireccionGrupoBodega;
	}

	public void setMostrardireccionGrupoBodega(Boolean mostrardireccionGrupoBodega) {
		this.mostrardireccionGrupoBodega= mostrardireccionGrupoBodega;
	}

	public Boolean getActivardireccionGrupoBodega() {
		return this.activardireccionGrupoBodega;
	}

	public void setActivardireccionGrupoBodega(Boolean activardireccionGrupoBodega) {
		this.activardireccionGrupoBodega= activardireccionGrupoBodega;
	}

	public Border setResaltartelefonoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltartelefonoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoGrupoBodega() {
		return this.resaltartelefonoGrupoBodega;
	}

	public void setResaltartelefonoGrupoBodega(Border borderResaltar) {
		this.resaltartelefonoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrartelefonoGrupoBodega() {
		return this.mostrartelefonoGrupoBodega;
	}

	public void setMostrartelefonoGrupoBodega(Boolean mostrartelefonoGrupoBodega) {
		this.mostrartelefonoGrupoBodega= mostrartelefonoGrupoBodega;
	}

	public Boolean getActivartelefonoGrupoBodega() {
		return this.activartelefonoGrupoBodega;
	}

	public void setActivartelefonoGrupoBodega(Boolean activartelefonoGrupoBodega) {
		this.activartelefonoGrupoBodega= activartelefonoGrupoBodega;
	}

	public Border setResaltarid_paisGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_paisGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisGrupoBodega() {
		return this.resaltarid_paisGrupoBodega;
	}

	public void setResaltarid_paisGrupoBodega(Border borderResaltar) {
		this.resaltarid_paisGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_paisGrupoBodega() {
		return this.mostrarid_paisGrupoBodega;
	}

	public void setMostrarid_paisGrupoBodega(Boolean mostrarid_paisGrupoBodega) {
		this.mostrarid_paisGrupoBodega= mostrarid_paisGrupoBodega;
	}

	public Boolean getActivarid_paisGrupoBodega() {
		return this.activarid_paisGrupoBodega;
	}

	public void setActivarid_paisGrupoBodega(Boolean activarid_paisGrupoBodega) {
		this.activarid_paisGrupoBodega= activarid_paisGrupoBodega;
	}

	public Boolean getCargarid_paisGrupoBodega() {
		return this.cargarid_paisGrupoBodega;
	}

	public void setCargarid_paisGrupoBodega(Boolean cargarid_paisGrupoBodega) {
		this.cargarid_paisGrupoBodega= cargarid_paisGrupoBodega;
	}

	public Border setResaltarid_ciudadGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_ciudadGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadGrupoBodega() {
		return this.resaltarid_ciudadGrupoBodega;
	}

	public void setResaltarid_ciudadGrupoBodega(Border borderResaltar) {
		this.resaltarid_ciudadGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_ciudadGrupoBodega() {
		return this.mostrarid_ciudadGrupoBodega;
	}

	public void setMostrarid_ciudadGrupoBodega(Boolean mostrarid_ciudadGrupoBodega) {
		this.mostrarid_ciudadGrupoBodega= mostrarid_ciudadGrupoBodega;
	}

	public Boolean getActivarid_ciudadGrupoBodega() {
		return this.activarid_ciudadGrupoBodega;
	}

	public void setActivarid_ciudadGrupoBodega(Boolean activarid_ciudadGrupoBodega) {
		this.activarid_ciudadGrupoBodega= activarid_ciudadGrupoBodega;
	}

	public Boolean getCargarid_ciudadGrupoBodega() {
		return this.cargarid_ciudadGrupoBodega;
	}

	public void setCargarid_ciudadGrupoBodega(Boolean cargarid_ciudadGrupoBodega) {
		this.cargarid_ciudadGrupoBodega= cargarid_ciudadGrupoBodega;
	}

	public Border setResaltarid_centro_costoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoGrupoBodega() {
		return this.resaltarid_centro_costoGrupoBodega;
	}

	public void setResaltarid_centro_costoGrupoBodega(Border borderResaltar) {
		this.resaltarid_centro_costoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoGrupoBodega() {
		return this.mostrarid_centro_costoGrupoBodega;
	}

	public void setMostrarid_centro_costoGrupoBodega(Boolean mostrarid_centro_costoGrupoBodega) {
		this.mostrarid_centro_costoGrupoBodega= mostrarid_centro_costoGrupoBodega;
	}

	public Boolean getActivarid_centro_costoGrupoBodega() {
		return this.activarid_centro_costoGrupoBodega;
	}

	public void setActivarid_centro_costoGrupoBodega(Boolean activarid_centro_costoGrupoBodega) {
		this.activarid_centro_costoGrupoBodega= activarid_centro_costoGrupoBodega;
	}

	public Boolean getCargarid_centro_costoGrupoBodega() {
		return this.cargarid_centro_costoGrupoBodega;
	}

	public void setCargarid_centro_costoGrupoBodega(Boolean cargarid_centro_costoGrupoBodega) {
		this.cargarid_centro_costoGrupoBodega= cargarid_centro_costoGrupoBodega;
	}

	public Border setResaltarid_empleadoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_empleadoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoGrupoBodega() {
		return this.resaltarid_empleadoGrupoBodega;
	}

	public void setResaltarid_empleadoGrupoBodega(Border borderResaltar) {
		this.resaltarid_empleadoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_empleadoGrupoBodega() {
		return this.mostrarid_empleadoGrupoBodega;
	}

	public void setMostrarid_empleadoGrupoBodega(Boolean mostrarid_empleadoGrupoBodega) {
		this.mostrarid_empleadoGrupoBodega= mostrarid_empleadoGrupoBodega;
	}

	public Boolean getActivarid_empleadoGrupoBodega() {
		return this.activarid_empleadoGrupoBodega;
	}

	public void setActivarid_empleadoGrupoBodega(Boolean activarid_empleadoGrupoBodega) {
		this.activarid_empleadoGrupoBodega= activarid_empleadoGrupoBodega;
	}

	public Boolean getCargarid_empleadoGrupoBodega() {
		return this.cargarid_empleadoGrupoBodega;
	}

	public void setCargarid_empleadoGrupoBodega(Boolean cargarid_empleadoGrupoBodega) {
		this.cargarid_empleadoGrupoBodega= cargarid_empleadoGrupoBodega;
	}

	public Border setResaltardescripcionGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltardescripcionGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionGrupoBodega() {
		return this.resaltardescripcionGrupoBodega;
	}

	public void setResaltardescripcionGrupoBodega(Border borderResaltar) {
		this.resaltardescripcionGrupoBodega= borderResaltar;
	}

	public Boolean getMostrardescripcionGrupoBodega() {
		return this.mostrardescripcionGrupoBodega;
	}

	public void setMostrardescripcionGrupoBodega(Boolean mostrardescripcionGrupoBodega) {
		this.mostrardescripcionGrupoBodega= mostrardescripcionGrupoBodega;
	}

	public Boolean getActivardescripcionGrupoBodega() {
		return this.activardescripcionGrupoBodega;
	}

	public void setActivardescripcionGrupoBodega(Boolean activardescripcionGrupoBodega) {
		this.activardescripcionGrupoBodega= activardescripcionGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_inventarioGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioGrupoBodega() {
		return this.resaltarid_cuenta_contable_inventarioGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_inventarioGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioGrupoBodega() {
		return this.mostrarid_cuenta_contable_inventarioGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_inventarioGrupoBodega(Boolean mostrarid_cuenta_contable_inventarioGrupoBodega) {
		this.mostrarid_cuenta_contable_inventarioGrupoBodega= mostrarid_cuenta_contable_inventarioGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_inventarioGrupoBodega() {
		return this.activarid_cuenta_contable_inventarioGrupoBodega;
	}

	public void setActivarid_cuenta_contable_inventarioGrupoBodega(Boolean activarid_cuenta_contable_inventarioGrupoBodega) {
		this.activarid_cuenta_contable_inventarioGrupoBodega= activarid_cuenta_contable_inventarioGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_inventarioGrupoBodega() {
		return this.cargarid_cuenta_contable_inventarioGrupoBodega;
	}

	public void setCargarid_cuenta_contable_inventarioGrupoBodega(Boolean cargarid_cuenta_contable_inventarioGrupoBodega) {
		this.cargarid_cuenta_contable_inventarioGrupoBodega= cargarid_cuenta_contable_inventarioGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_costoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoGrupoBodega() {
		return this.resaltarid_cuenta_contable_costoGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_costoGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoGrupoBodega() {
		return this.mostrarid_cuenta_contable_costoGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_costoGrupoBodega(Boolean mostrarid_cuenta_contable_costoGrupoBodega) {
		this.mostrarid_cuenta_contable_costoGrupoBodega= mostrarid_cuenta_contable_costoGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_costoGrupoBodega() {
		return this.activarid_cuenta_contable_costoGrupoBodega;
	}

	public void setActivarid_cuenta_contable_costoGrupoBodega(Boolean activarid_cuenta_contable_costoGrupoBodega) {
		this.activarid_cuenta_contable_costoGrupoBodega= activarid_cuenta_contable_costoGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_costoGrupoBodega() {
		return this.cargarid_cuenta_contable_costoGrupoBodega;
	}

	public void setCargarid_cuenta_contable_costoGrupoBodega(Boolean cargarid_cuenta_contable_costoGrupoBodega) {
		this.cargarid_cuenta_contable_costoGrupoBodega= cargarid_cuenta_contable_costoGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_ventaGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaGrupoBodega() {
		return this.resaltarid_cuenta_contable_ventaGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_ventaGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaGrupoBodega() {
		return this.mostrarid_cuenta_contable_ventaGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_ventaGrupoBodega(Boolean mostrarid_cuenta_contable_ventaGrupoBodega) {
		this.mostrarid_cuenta_contable_ventaGrupoBodega= mostrarid_cuenta_contable_ventaGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_ventaGrupoBodega() {
		return this.activarid_cuenta_contable_ventaGrupoBodega;
	}

	public void setActivarid_cuenta_contable_ventaGrupoBodega(Boolean activarid_cuenta_contable_ventaGrupoBodega) {
		this.activarid_cuenta_contable_ventaGrupoBodega= activarid_cuenta_contable_ventaGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_ventaGrupoBodega() {
		return this.cargarid_cuenta_contable_ventaGrupoBodega;
	}

	public void setCargarid_cuenta_contable_ventaGrupoBodega(Boolean cargarid_cuenta_contable_ventaGrupoBodega) {
		this.cargarid_cuenta_contable_ventaGrupoBodega= cargarid_cuenta_contable_ventaGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_descuentoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoGrupoBodega() {
		return this.resaltarid_cuenta_contable_descuentoGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_descuentoGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoGrupoBodega() {
		return this.mostrarid_cuenta_contable_descuentoGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_descuentoGrupoBodega(Boolean mostrarid_cuenta_contable_descuentoGrupoBodega) {
		this.mostrarid_cuenta_contable_descuentoGrupoBodega= mostrarid_cuenta_contable_descuentoGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_descuentoGrupoBodega() {
		return this.activarid_cuenta_contable_descuentoGrupoBodega;
	}

	public void setActivarid_cuenta_contable_descuentoGrupoBodega(Boolean activarid_cuenta_contable_descuentoGrupoBodega) {
		this.activarid_cuenta_contable_descuentoGrupoBodega= activarid_cuenta_contable_descuentoGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_descuentoGrupoBodega() {
		return this.cargarid_cuenta_contable_descuentoGrupoBodega;
	}

	public void setCargarid_cuenta_contable_descuentoGrupoBodega(Boolean cargarid_cuenta_contable_descuentoGrupoBodega) {
		this.cargarid_cuenta_contable_descuentoGrupoBodega= cargarid_cuenta_contable_descuentoGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_devolucionGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionGrupoBodega() {
		return this.resaltarid_cuenta_contable_devolucionGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_devolucionGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionGrupoBodega() {
		return this.mostrarid_cuenta_contable_devolucionGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_devolucionGrupoBodega(Boolean mostrarid_cuenta_contable_devolucionGrupoBodega) {
		this.mostrarid_cuenta_contable_devolucionGrupoBodega= mostrarid_cuenta_contable_devolucionGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_devolucionGrupoBodega() {
		return this.activarid_cuenta_contable_devolucionGrupoBodega;
	}

	public void setActivarid_cuenta_contable_devolucionGrupoBodega(Boolean activarid_cuenta_contable_devolucionGrupoBodega) {
		this.activarid_cuenta_contable_devolucionGrupoBodega= activarid_cuenta_contable_devolucionGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_devolucionGrupoBodega() {
		return this.cargarid_cuenta_contable_devolucionGrupoBodega;
	}

	public void setCargarid_cuenta_contable_devolucionGrupoBodega(Boolean cargarid_cuenta_contable_devolucionGrupoBodega) {
		this.cargarid_cuenta_contable_devolucionGrupoBodega= cargarid_cuenta_contable_devolucionGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_debitoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoGrupoBodega() {
		return this.resaltarid_cuenta_contable_debitoGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_debitoGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoGrupoBodega() {
		return this.mostrarid_cuenta_contable_debitoGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_debitoGrupoBodega(Boolean mostrarid_cuenta_contable_debitoGrupoBodega) {
		this.mostrarid_cuenta_contable_debitoGrupoBodega= mostrarid_cuenta_contable_debitoGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_debitoGrupoBodega() {
		return this.activarid_cuenta_contable_debitoGrupoBodega;
	}

	public void setActivarid_cuenta_contable_debitoGrupoBodega(Boolean activarid_cuenta_contable_debitoGrupoBodega) {
		this.activarid_cuenta_contable_debitoGrupoBodega= activarid_cuenta_contable_debitoGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_debitoGrupoBodega() {
		return this.cargarid_cuenta_contable_debitoGrupoBodega;
	}

	public void setCargarid_cuenta_contable_debitoGrupoBodega(Boolean cargarid_cuenta_contable_debitoGrupoBodega) {
		this.cargarid_cuenta_contable_debitoGrupoBodega= cargarid_cuenta_contable_debitoGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_creditoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoGrupoBodega() {
		return this.resaltarid_cuenta_contable_creditoGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_creditoGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoGrupoBodega() {
		return this.mostrarid_cuenta_contable_creditoGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_creditoGrupoBodega(Boolean mostrarid_cuenta_contable_creditoGrupoBodega) {
		this.mostrarid_cuenta_contable_creditoGrupoBodega= mostrarid_cuenta_contable_creditoGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_creditoGrupoBodega() {
		return this.activarid_cuenta_contable_creditoGrupoBodega;
	}

	public void setActivarid_cuenta_contable_creditoGrupoBodega(Boolean activarid_cuenta_contable_creditoGrupoBodega) {
		this.activarid_cuenta_contable_creditoGrupoBodega= activarid_cuenta_contable_creditoGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_creditoGrupoBodega() {
		return this.cargarid_cuenta_contable_creditoGrupoBodega;
	}

	public void setCargarid_cuenta_contable_creditoGrupoBodega(Boolean cargarid_cuenta_contable_creditoGrupoBodega) {
		this.cargarid_cuenta_contable_creditoGrupoBodega= cargarid_cuenta_contable_creditoGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_produccionGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_produccionGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_produccionGrupoBodega() {
		return this.resaltarid_cuenta_contable_produccionGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_produccionGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_produccionGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_produccionGrupoBodega() {
		return this.mostrarid_cuenta_contable_produccionGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_produccionGrupoBodega(Boolean mostrarid_cuenta_contable_produccionGrupoBodega) {
		this.mostrarid_cuenta_contable_produccionGrupoBodega= mostrarid_cuenta_contable_produccionGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_produccionGrupoBodega() {
		return this.activarid_cuenta_contable_produccionGrupoBodega;
	}

	public void setActivarid_cuenta_contable_produccionGrupoBodega(Boolean activarid_cuenta_contable_produccionGrupoBodega) {
		this.activarid_cuenta_contable_produccionGrupoBodega= activarid_cuenta_contable_produccionGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_produccionGrupoBodega() {
		return this.cargarid_cuenta_contable_produccionGrupoBodega;
	}

	public void setCargarid_cuenta_contable_produccionGrupoBodega(Boolean cargarid_cuenta_contable_produccionGrupoBodega) {
		this.cargarid_cuenta_contable_produccionGrupoBodega= cargarid_cuenta_contable_produccionGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_bonificaGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_bonificaGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_bonificaGrupoBodega() {
		return this.resaltarid_cuenta_contable_bonificaGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_bonificaGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_bonificaGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_bonificaGrupoBodega() {
		return this.mostrarid_cuenta_contable_bonificaGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_bonificaGrupoBodega(Boolean mostrarid_cuenta_contable_bonificaGrupoBodega) {
		this.mostrarid_cuenta_contable_bonificaGrupoBodega= mostrarid_cuenta_contable_bonificaGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_bonificaGrupoBodega() {
		return this.activarid_cuenta_contable_bonificaGrupoBodega;
	}

	public void setActivarid_cuenta_contable_bonificaGrupoBodega(Boolean activarid_cuenta_contable_bonificaGrupoBodega) {
		this.activarid_cuenta_contable_bonificaGrupoBodega= activarid_cuenta_contable_bonificaGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_bonificaGrupoBodega() {
		return this.cargarid_cuenta_contable_bonificaGrupoBodega;
	}

	public void setCargarid_cuenta_contable_bonificaGrupoBodega(Boolean cargarid_cuenta_contable_bonificaGrupoBodega) {
		this.cargarid_cuenta_contable_bonificaGrupoBodega= cargarid_cuenta_contable_bonificaGrupoBodega;
	}

	public Border setResaltarid_cuenta_contable_costo_bonificaGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_bonificaGrupoBodega= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_bonificaGrupoBodega() {
		return this.resaltarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public void setResaltarid_cuenta_contable_costo_bonificaGrupoBodega(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_bonificaGrupoBodega= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_bonificaGrupoBodega() {
		return this.mostrarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public void setMostrarid_cuenta_contable_costo_bonificaGrupoBodega(Boolean mostrarid_cuenta_contable_costo_bonificaGrupoBodega) {
		this.mostrarid_cuenta_contable_costo_bonificaGrupoBodega= mostrarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public Boolean getActivarid_cuenta_contable_costo_bonificaGrupoBodega() {
		return this.activarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public void setActivarid_cuenta_contable_costo_bonificaGrupoBodega(Boolean activarid_cuenta_contable_costo_bonificaGrupoBodega) {
		this.activarid_cuenta_contable_costo_bonificaGrupoBodega= activarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public Boolean getCargarid_cuenta_contable_costo_bonificaGrupoBodega() {
		return this.cargarid_cuenta_contable_costo_bonificaGrupoBodega;
	}

	public void setCargarid_cuenta_contable_costo_bonificaGrupoBodega(Boolean cargarid_cuenta_contable_costo_bonificaGrupoBodega) {
		this.cargarid_cuenta_contable_costo_bonificaGrupoBodega= cargarid_cuenta_contable_costo_bonificaGrupoBodega;
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
		
		
		this.setMostraridGrupoBodega(esInicial);
		this.setMostrarid_empresaGrupoBodega(esInicial);
		this.setMostrarcodigoGrupoBodega(esInicial);
		this.setMostrarnombreGrupoBodega(esInicial);
		this.setMostrarrucGrupoBodega(esInicial);
		this.setMostrardireccionGrupoBodega(esInicial);
		this.setMostrartelefonoGrupoBodega(esInicial);
		this.setMostrarid_paisGrupoBodega(esInicial);
		this.setMostrarid_ciudadGrupoBodega(esInicial);
		this.setMostrarid_centro_costoGrupoBodega(esInicial);
		this.setMostrarid_empleadoGrupoBodega(esInicial);
		this.setMostrardescripcionGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_inventarioGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_costoGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_ventaGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_descuentoGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_devolucionGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_debitoGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_creditoGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_produccionGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_bonificaGrupoBodega(esInicial);
		this.setMostrarid_cuenta_contable_costo_bonificaGrupoBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.ID)) {
				this.setMostraridGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.RUC)) {
				this.setMostrarrucGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setMostrarid_cuenta_contable_produccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setMostrarid_cuenta_contable_bonificaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setMostrarid_cuenta_contable_costo_bonificaGrupoBodega(esAsigna);
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
		
		
		this.setActivaridGrupoBodega(esInicial);
		this.setActivarid_empresaGrupoBodega(esInicial);
		this.setActivarcodigoGrupoBodega(esInicial);
		this.setActivarnombreGrupoBodega(esInicial);
		this.setActivarrucGrupoBodega(esInicial);
		this.setActivardireccionGrupoBodega(esInicial);
		this.setActivartelefonoGrupoBodega(esInicial);
		this.setActivarid_paisGrupoBodega(esInicial);
		this.setActivarid_ciudadGrupoBodega(esInicial);
		this.setActivarid_centro_costoGrupoBodega(esInicial);
		this.setActivarid_empleadoGrupoBodega(esInicial);
		this.setActivardescripcionGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_inventarioGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_costoGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_ventaGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_descuentoGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_devolucionGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_debitoGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_creditoGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_produccionGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_bonificaGrupoBodega(esInicial);
		this.setActivarid_cuenta_contable_costo_bonificaGrupoBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.ID)) {
				this.setActivaridGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.RUC)) {
				this.setActivarrucGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setActivarid_cuenta_contable_produccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setActivarid_cuenta_contable_bonificaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setActivarid_cuenta_contable_costo_bonificaGrupoBodega(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoBodega(esInicial);
		this.setResaltarid_empresaGrupoBodega(esInicial);
		this.setResaltarcodigoGrupoBodega(esInicial);
		this.setResaltarnombreGrupoBodega(esInicial);
		this.setResaltarrucGrupoBodega(esInicial);
		this.setResaltardireccionGrupoBodega(esInicial);
		this.setResaltartelefonoGrupoBodega(esInicial);
		this.setResaltarid_paisGrupoBodega(esInicial);
		this.setResaltarid_ciudadGrupoBodega(esInicial);
		this.setResaltarid_centro_costoGrupoBodega(esInicial);
		this.setResaltarid_empleadoGrupoBodega(esInicial);
		this.setResaltardescripcionGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_inventarioGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_costoGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_ventaGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_descuentoGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_devolucionGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_debitoGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_creditoGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_produccionGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_bonificaGrupoBodega(esInicial);
		this.setResaltarid_cuenta_contable_costo_bonificaGrupoBodega(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.ID)) {
				this.setResaltaridGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.RUC)) {
				this.setResaltarrucGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setResaltarid_cuenta_contable_produccionGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setResaltarid_cuenta_contable_bonificaGrupoBodega(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setResaltarid_cuenta_contable_costo_bonificaGrupoBodega(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBodegaGrupoBodega=null;

	public Border getResaltarBodegaGrupoBodega() {
		return this.resaltarBodegaGrupoBodega;
	}

	public void setResaltarBodegaGrupoBodega(Border borderResaltarBodega) {
		if(borderResaltarBodega!=null) {
			this.resaltarBodegaGrupoBodega= borderResaltarBodega;
		}
	}

	public Border setResaltarBodegaGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltarBodega=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltarBodega);
			
		this.resaltarBodegaGrupoBodega= borderResaltarBodega;

		 return borderResaltarBodega;
	}



	public Boolean mostrarBodegaGrupoBodega=true;

	public Boolean getMostrarBodegaGrupoBodega() {
		return this.mostrarBodegaGrupoBodega;
	}

	public void setMostrarBodegaGrupoBodega(Boolean visibilidadResaltarBodega) {
		this.mostrarBodegaGrupoBodega= visibilidadResaltarBodega;
	}



	public Boolean activarBodegaGrupoBodega=true;

	public Boolean gethabilitarResaltarBodegaGrupoBodega() {
		return this.activarBodegaGrupoBodega;
	}

	public void setActivarBodegaGrupoBodega(Boolean habilitarResaltarBodega) {
		this.activarBodegaGrupoBodega= habilitarResaltarBodega;
	}


	public Border resaltarParametroInventarioDefectoGrupoBodega=null;

	public Border getResaltarParametroInventarioDefectoGrupoBodega() {
		return this.resaltarParametroInventarioDefectoGrupoBodega;
	}

	public void setResaltarParametroInventarioDefectoGrupoBodega(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoGrupoBodega= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupobodegaBeanSwingJInternalFrame.jTtoolBarGrupoBodega.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoGrupoBodega= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoGrupoBodega=true;

	public Boolean getMostrarParametroInventarioDefectoGrupoBodega() {
		return this.mostrarParametroInventarioDefectoGrupoBodega;
	}

	public void setMostrarParametroInventarioDefectoGrupoBodega(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoGrupoBodega= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoGrupoBodega=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoGrupoBodega() {
		return this.activarParametroInventarioDefectoGrupoBodega;
	}

	public void setActivarParametroInventarioDefectoGrupoBodega(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoGrupoBodega= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarBodegaGrupoBodega(esInicial);
		this.setMostrarParametroInventarioDefectoGrupoBodega(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setMostrarBodegaGrupoBodega(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoGrupoBodega(esAsigna);
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

		this.setActivarBodegaGrupoBodega(esInicial);
		this.setActivarParametroInventarioDefectoGrupoBodega(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setActivarBodegaGrupoBodega(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoGrupoBodega(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBodegaGrupoBodega(esInicial);
		this.setResaltarParametroInventarioDefectoGrupoBodega(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setResaltarBodegaGrupoBodega(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoGrupoBodega(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoGrupoBodega=true;

	public Boolean getMostrarBusquedaPorCodigoGrupoBodega() {
		return this.mostrarBusquedaPorCodigoGrupoBodega;
	}

	public void setMostrarBusquedaPorCodigoGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreGrupoBodega=true;

	public Boolean getMostrarBusquedaPorNombreGrupoBodega() {
		return this.mostrarBusquedaPorNombreGrupoBodega;
	}

	public void setMostrarBusquedaPorNombreGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucGrupoBodega=true;

	public Boolean getMostrarBusquedaPorRucGrupoBodega() {
		return this.mostrarBusquedaPorRucGrupoBodega;
	}

	public void setMostrarBusquedaPorRucGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorTelefonoGrupoBodega=true;

	public Boolean getMostrarBusquedaPorTelefonoGrupoBodega() {
		return this.mostrarBusquedaPorTelefonoGrupoBodega;
	}

	public void setMostrarBusquedaPorTelefonoGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorTelefonoGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoGrupoBodega=true;

	public Boolean getMostrarFK_IdCentroCostoGrupoBodega() {
		return this.mostrarFK_IdCentroCostoGrupoBodega;
	}

	public void setMostrarFK_IdCentroCostoGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoGrupoBodega=true;

	public Boolean getMostrarFK_IdEmpleadoGrupoBodega() {
		return this.mostrarFK_IdEmpleadoGrupoBodega;
	}

	public void setMostrarFK_IdEmpleadoGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoGrupoBodega= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisGrupoBodega=true;

	public Boolean getMostrarFK_IdPaisGrupoBodega() {
		return this.mostrarFK_IdPaisGrupoBodega;
	}

	public void setMostrarFK_IdPaisGrupoBodega(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisGrupoBodega= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoGrupoBodega=true;

	public Boolean getActivarBusquedaPorCodigoGrupoBodega() {
		return this.activarBusquedaPorCodigoGrupoBodega;
	}

	public void setActivarBusquedaPorCodigoGrupoBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoGrupoBodega= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreGrupoBodega=true;

	public Boolean getActivarBusquedaPorNombreGrupoBodega() {
		return this.activarBusquedaPorNombreGrupoBodega;
	}

	public void setActivarBusquedaPorNombreGrupoBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreGrupoBodega= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucGrupoBodega=true;

	public Boolean getActivarBusquedaPorRucGrupoBodega() {
		return this.activarBusquedaPorRucGrupoBodega;
	}

	public void setActivarBusquedaPorRucGrupoBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucGrupoBodega= habilitarResaltar;
	}

	public Boolean activarBusquedaPorTelefonoGrupoBodega=true;

	public Boolean getActivarBusquedaPorTelefonoGrupoBodega() {
		return this.activarBusquedaPorTelefonoGrupoBodega;
	}

	public void setActivarBusquedaPorTelefonoGrupoBodega(Boolean habilitarResaltar) {
		this.activarBusquedaPorTelefonoGrupoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoGrupoBodega=true;

	public Boolean getActivarFK_IdCentroCostoGrupoBodega() {
		return this.activarFK_IdCentroCostoGrupoBodega;
	}

	public void setActivarFK_IdCentroCostoGrupoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoGrupoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoGrupoBodega=true;

	public Boolean getActivarFK_IdEmpleadoGrupoBodega() {
		return this.activarFK_IdEmpleadoGrupoBodega;
	}

	public void setActivarFK_IdEmpleadoGrupoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoGrupoBodega= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisGrupoBodega=true;

	public Boolean getActivarFK_IdPaisGrupoBodega() {
		return this.activarFK_IdPaisGrupoBodega;
	}

	public void setActivarFK_IdPaisGrupoBodega(Boolean habilitarResaltar) {
		this.activarFK_IdPaisGrupoBodega= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoGrupoBodega=null;

	public Border getResaltarBusquedaPorCodigoGrupoBodega() {
		return this.resaltarBusquedaPorCodigoGrupoBodega;
	}

	public void setResaltarBusquedaPorCodigoGrupoBodega(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoGrupoBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoGrupoBodega= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreGrupoBodega=null;

	public Border getResaltarBusquedaPorNombreGrupoBodega() {
		return this.resaltarBusquedaPorNombreGrupoBodega;
	}

	public void setResaltarBusquedaPorNombreGrupoBodega(Border borderResaltar) {
		this.resaltarBusquedaPorNombreGrupoBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreGrupoBodega= borderResaltar;
	}

	public Border resaltarBusquedaPorRucGrupoBodega=null;

	public Border getResaltarBusquedaPorRucGrupoBodega() {
		return this.resaltarBusquedaPorRucGrupoBodega;
	}

	public void setResaltarBusquedaPorRucGrupoBodega(Border borderResaltar) {
		this.resaltarBusquedaPorRucGrupoBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorRucGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucGrupoBodega= borderResaltar;
	}

	public Border resaltarBusquedaPorTelefonoGrupoBodega=null;

	public Border getResaltarBusquedaPorTelefonoGrupoBodega() {
		return this.resaltarBusquedaPorTelefonoGrupoBodega;
	}

	public void setResaltarBusquedaPorTelefonoGrupoBodega(Border borderResaltar) {
		this.resaltarBusquedaPorTelefonoGrupoBodega= borderResaltar;
	}

	public void setResaltarBusquedaPorTelefonoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorTelefonoGrupoBodega= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoGrupoBodega=null;

	public Border getResaltarFK_IdCentroCostoGrupoBodega() {
		return this.resaltarFK_IdCentroCostoGrupoBodega;
	}

	public void setResaltarFK_IdCentroCostoGrupoBodega(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoGrupoBodega= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoGrupoBodega= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoGrupoBodega=null;

	public Border getResaltarFK_IdEmpleadoGrupoBodega() {
		return this.resaltarFK_IdEmpleadoGrupoBodega;
	}

	public void setResaltarFK_IdEmpleadoGrupoBodega(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoGrupoBodega= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoGrupoBodega= borderResaltar;
	}

	public Border resaltarFK_IdPaisGrupoBodega=null;

	public Border getResaltarFK_IdPaisGrupoBodega() {
		return this.resaltarFK_IdPaisGrupoBodega;
	}

	public void setResaltarFK_IdPaisGrupoBodega(Border borderResaltar) {
		this.resaltarFK_IdPaisGrupoBodega= borderResaltar;
	}

	public void setResaltarFK_IdPaisGrupoBodega(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoBodegaBeanSwingJInternalFrame grupobodegaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisGrupoBodega= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}