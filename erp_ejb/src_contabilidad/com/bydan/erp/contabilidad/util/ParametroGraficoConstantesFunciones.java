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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.ParametroGraficoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroGraficoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroGraficoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroGraficoConstantesFunciones extends ParametroGraficoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroGrafico";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroGrafico"+ParametroGraficoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroGraficoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroGraficoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroGraficoConstantesFunciones.SCHEMA+"_"+ParametroGraficoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGraficoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroGraficoConstantesFunciones.SCHEMA+"_"+ParametroGraficoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroGraficoConstantesFunciones.SCHEMA+"_"+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGraficoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroGraficoConstantesFunciones.SCHEMA+"_"+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGraficoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGraficoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGraficoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroGraficoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroGraficoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroGraficoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroGraficoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Graficos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Grafico";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Grafico";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroGrafico";
	public static final String OBJECTNAME="parametrografico";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_grafico";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrografico from "+ParametroGraficoConstantesFunciones.SPERSISTENCENAME+" parametrografico";
	public static String QUERYSELECTNATIVE="select "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".version_row,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_activo,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_disponibilidad,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario_ini,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario_fin,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_cuenta_cobrar,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta_credito,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_activo_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".inventario_inicial from "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME;//+" as "+ParametroGraficoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroGraficoConstantesFuncionesAdditional parametrograficoConstantesFuncionesAdditional=null;
	
	public ParametroGraficoConstantesFuncionesAdditional getParametroGraficoConstantesFuncionesAdditional() {
		return this.parametrograficoConstantesFuncionesAdditional;
	}
	
	public void setParametroGraficoConstantesFuncionesAdditional(ParametroGraficoConstantesFuncionesAdditional parametrograficoConstantesFuncionesAdditional) {
		try {
			this.parametrograficoConstantesFuncionesAdditional=parametrograficoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLEACTIVO= "id_cuenta_contable_activo";
    public static final String IDCUENTACONTABLEPASIVO= "id_cuenta_contable_pasivo";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLEDISPONIBILIDAD= "id_cuenta_contable_disponibilidad";
    public static final String IDCUENTACONTABLECOSTOVENTA= "id_cuenta_contable_costo_venta";
    public static final String IDCUENTACONTABLEINVENTARIOINI= "id_cuenta_contable_inventario_ini";
    public static final String IDCUENTACONTABLEINVENTARIOFIN= "id_cuenta_contable_inventario_fin";
    public static final String IDCUENTACONTABLECUENTASCOBRAR= "id_cuenta_contable_cuenta_cobrar";
    public static final String IDCUENTACONTABLEVENTACREDITO= "id_cuenta_contable_venta_credito";
    public static final String IDCUENTACONTABLEACTIVOTOTAL= "id_cuenta_contable_activo_total";
    public static final String IDCUENTACONTABLEPASIVOTOTAL= "id_cuenta_contable_pasivo_total";
    public static final String IDCUENTACONTABLEPATRIMONIO= "id_cuenta_contable_patrimonio";
    public static final String IDCUENTACONTABLEPATRIMONIOTOTAL= "id_cuenta_contable_patrimonio_total";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String INVENTARIOINICIAL= "inventario_inicial";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLEACTIVO= "Cuenta C. Activo";
		public static final String LABEL_IDCUENTACONTABLEACTIVO_LOWER= "Cuenta Contable Activo";
    	public static final String LABEL_IDCUENTACONTABLEPASIVO= "Cuenta C. Pasivo";
		public static final String LABEL_IDCUENTACONTABLEPASIVO_LOWER= "Cuenta Contable Pasivo";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIO= "Cuenta C. Inventario";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIO_LOWER= "Cuenta Contable Inventario";
    	public static final String LABEL_IDCUENTACONTABLEDISPONIBILIDAD= "Cuenta C. Disponibilad";
		public static final String LABEL_IDCUENTACONTABLEDISPONIBILIDAD_LOWER= "Cuenta Contable Disponibilidad";
    	public static final String LABEL_IDCUENTACONTABLECOSTOVENTA= "Cuenta C. Costo Venta";
		public static final String LABEL_IDCUENTACONTABLECOSTOVENTA_LOWER= "Cuenta Contable Costo Venta";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIOINI= "Cuenta C. Inventario Ini";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIOINI_LOWER= "Cuenta Contable Inventario Ini";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIOFIN= "Cuenta C. Inventario Fin";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIOFIN_LOWER= "Cuenta Contable Inventario Fin";
    	public static final String LABEL_IDCUENTACONTABLECUENTASCOBRAR= "Cuenta C. Cuentas Cobrar";
		public static final String LABEL_IDCUENTACONTABLECUENTASCOBRAR_LOWER= "Cuenta Contable Cuentas Cobrar";
    	public static final String LABEL_IDCUENTACONTABLEVENTACREDITO= "Cuenta C. Venta Credito";
		public static final String LABEL_IDCUENTACONTABLEVENTACREDITO_LOWER= "Cuenta Contable Venta Credito";
    	public static final String LABEL_IDCUENTACONTABLEACTIVOTOTAL= "Cuenta C. Activo Total";
		public static final String LABEL_IDCUENTACONTABLEACTIVOTOTAL_LOWER= "Cuenta Contable Activo Total";
    	public static final String LABEL_IDCUENTACONTABLEPASIVOTOTAL= "Cuenta C. Pasivo Total";
		public static final String LABEL_IDCUENTACONTABLEPASIVOTOTAL_LOWER= "Cuenta Contable Pasivo Total";
    	public static final String LABEL_IDCUENTACONTABLEPATRIMONIO= "Cuenta C. Patrimonio";
		public static final String LABEL_IDCUENTACONTABLEPATRIMONIO_LOWER= "Cuenta Contable Patrimonio";
    	public static final String LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL= "Cuenta C. Patrimonio Total";
		public static final String LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL_LOWER= "Cuenta Contable Patrimonio Total";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "Cuenta C. Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_INVENTARIOINICIAL= "Inventario Inicial";
		public static final String LABEL_INVENTARIOINICIAL_LOWER= "Inventario Inicial";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroGraficoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEDISPONIBILIDAD;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOINI;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOFIN;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECUENTASCOBRAR;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTACREDITO;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVOTOTAL;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVOTOTAL;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(ParametroGraficoConstantesFunciones.INVENTARIOINICIAL)) {sLabelColumna=ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroGraficoDescripcion(ParametroGrafico parametrografico) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrografico !=null/* && parametrografico.getId()!=0*/) {
			if(parametrografico.getId()!=null) {
				sDescripcion=parametrografico.getId().toString();
			}//parametrograficoparametrografico.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroGraficoDescripcionDetallado(ParametroGrafico parametrografico) {
		String sDescripcion="";
			
		sDescripcion+=ParametroGraficoConstantesFunciones.ID+"=";
		sDescripcion+=parametrografico.getId().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrografico.getVersionRow().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrografico.getid_empresa().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_activo().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_pasivo().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_disponibilidad().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_costo_venta().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_inventario_ini().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_inventario_fin().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_cuenta_cobrar().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_venta_credito().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_activo_total().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_pasivo_total().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_patrimonio().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_patrimonio_total().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=parametrografico.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=ParametroGraficoConstantesFunciones.INVENTARIOINICIAL+"=";
		sDescripcion+=parametrografico.getinventario_inicial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroGraficoDescripcion(ParametroGrafico parametrografico,String sValor) throws Exception {			
		if(parametrografico !=null) {
			//parametrograficoparametrografico.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableActivoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePasivoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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

	public static String getCuentaContableDisponibilidadDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableInventarioIniDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableInventarioFinDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCuentasCobrarDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableVentaCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableActivoTotalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePasivoTotalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePatrimonioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePatrimonioTotalDescripcion(CuentaContable cuentacontable) {
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableActivo")) {
			sNombreIndice="Tipo=  Por Cuenta C. Activo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableActivoTotal")) {
			sNombreIndice="Tipo=  Por Cuenta C. Activo Total";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo Venta";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCuentasCobrar")) {
			sNombreIndice="Tipo=  Por Cuenta C. Cuentas Cobrar";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDisponibilad")) {
			sNombreIndice="Tipo=  Por Cuenta C. Disponibilad";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventario")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventarioFin")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario Fin";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventarioIni")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario Ini";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePasivo")) {
			sNombreIndice="Tipo=  Por Cuenta C. Pasivo";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePasivoTotal")) {
			sNombreIndice="Tipo=  Por Cuenta C. Pasivo Total";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePatrimonio")) {
			sNombreIndice="Tipo=  Por Cuenta C. Patrimonio";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePatrimonioTotal")) {
			sNombreIndice="Tipo=  Por Cuenta C. Patrimonio Total";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Venta";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVentaCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Venta Credito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableActivo(Long id_cuenta_contable_activo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_activo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Activo="+id_cuenta_contable_activo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableActivoTotal(Long id_cuenta_contable_activo_total) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_activo_total!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Activo Total="+id_cuenta_contable_activo_total.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoVenta(Long id_cuenta_contable_costo_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo Venta="+id_cuenta_contable_costo_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCuentasCobrar(Long id_cuenta_contable_cuenta_cobrar) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_cuenta_cobrar!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Cuentas Cobrar="+id_cuenta_contable_cuenta_cobrar.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDisponibilad(Long id_cuenta_contable_disponibilidad) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_disponibilidad!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Disponibilad="+id_cuenta_contable_disponibilidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventario(Long id_cuenta_contable_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario="+id_cuenta_contable_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventarioFin(Long id_cuenta_contable_inventario_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario_fin!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario Fin="+id_cuenta_contable_inventario_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventarioIni(Long id_cuenta_contable_inventario_ini) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario_ini!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario Ini="+id_cuenta_contable_inventario_ini.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePasivo(Long id_cuenta_contable_pasivo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_pasivo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Pasivo="+id_cuenta_contable_pasivo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePasivoTotal(Long id_cuenta_contable_pasivo_total) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_pasivo_total!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Pasivo Total="+id_cuenta_contable_pasivo_total.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePatrimonio(Long id_cuenta_contable_patrimonio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_patrimonio!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Patrimonio="+id_cuenta_contable_patrimonio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePatrimonioTotal(Long id_cuenta_contable_patrimonio_total) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_patrimonio_total!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Patrimonio Total="+id_cuenta_contable_patrimonio_total.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Venta="+id_cuenta_contable_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVentaCredito(Long id_cuenta_contable_venta_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Venta Credito="+id_cuenta_contable_venta_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroGrafico(ParametroGrafico parametrografico,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroGraficos(List<ParametroGrafico> parametrograficos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroGrafico parametrografico: parametrograficos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGrafico(ParametroGrafico parametrografico,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrografico.getConCambioAuxiliar()) {
			parametrografico.setIsDeleted(parametrografico.getIsDeletedAuxiliar());	
			parametrografico.setIsNew(parametrografico.getIsNewAuxiliar());	
			parametrografico.setIsChanged(parametrografico.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrografico.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrografico.setIsDeletedAuxiliar(false);	
			parametrografico.setIsNewAuxiliar(false);	
			parametrografico.setIsChangedAuxiliar(false);
			
			parametrografico.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGraficos(List<ParametroGrafico> parametrograficos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroGrafico parametrografico : parametrograficos) {
			if(conAsignarBase && parametrografico.getConCambioAuxiliar()) {
				parametrografico.setIsDeleted(parametrografico.getIsDeletedAuxiliar());	
				parametrografico.setIsNew(parametrografico.getIsNewAuxiliar());	
				parametrografico.setIsChanged(parametrografico.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrografico.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrografico.setIsDeletedAuxiliar(false);	
				parametrografico.setIsNewAuxiliar(false);	
				parametrografico.setIsChangedAuxiliar(false);
				
				parametrografico.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroGrafico(ParametroGrafico parametrografico,Boolean conEnteros) throws Exception  {
		parametrografico.setinventario_inicial(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroGraficos(List<ParametroGrafico> parametrograficos,Boolean conEnteros) throws Exception  {
		
		for(ParametroGrafico parametrografico: parametrograficos) {
			parametrografico.setinventario_inicial(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroGrafico(List<ParametroGrafico> parametrograficos,ParametroGrafico parametrograficoAux) throws Exception  {
		ParametroGraficoConstantesFunciones.InicializarValoresParametroGrafico(parametrograficoAux,true);
		
		for(ParametroGrafico parametrografico: parametrograficos) {
			if(parametrografico.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrograficoAux.setinventario_inicial(parametrograficoAux.getinventario_inicial()+parametrografico.getinventario_inicial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGrafico(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroGraficoConstantesFunciones.getArrayColumnasGlobalesParametroGrafico(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGrafico(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGraficoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGraficoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroGrafico(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroGrafico> parametrograficos,ParametroGrafico parametrografico,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroGrafico parametrograficoAux: parametrograficos) {
			if(parametrograficoAux!=null && parametrografico!=null) {
				if((parametrograficoAux.getId()==null && parametrografico.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrograficoAux.getId()!=null && parametrografico.getId()!=null){
					if(parametrograficoAux.getId().equals(parametrografico.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroGrafico(List<ParametroGrafico> parametrograficos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double inventario_inicialTotal=0.0;
	
		for(ParametroGrafico parametrografico: parametrograficos) {			
			if(parametrografico.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			inventario_inicialTotal+=parametrografico.getinventario_inicial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroGraficoConstantesFunciones.INVENTARIOINICIAL);
		datoGeneral.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL);
		datoGeneral.setdValorDouble(inventario_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroGrafico() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_ID, ParametroGraficoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_VERSIONROW, ParametroGraficoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDEMPRESA, ParametroGraficoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEDISPONIBILIDAD, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA, ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOINI, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOFIN, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECUENTASCOBRAR, ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTACREDITO, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVOTOTAL, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVOTOTAL, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL, ParametroGraficoConstantesFunciones.INVENTARIOINICIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroGrafico() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGraficoConstantesFunciones.INVENTARIOINICIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGrafico() throws Exception  {
		return ParametroGraficoConstantesFunciones.getTiposSeleccionarParametroGrafico(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGrafico(Boolean conFk) throws Exception  {
		return ParametroGraficoConstantesFunciones.getTiposSeleccionarParametroGrafico(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGrafico(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEDISPONIBILIDAD);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEDISPONIBILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOINI);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOINI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOFIN);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECUENTASCOBRAR);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECUENTASCOBRAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTACREDITO);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVOTOTAL);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVOTOTAL);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL);
			reporte.setsDescripcion(ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroGrafico(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGrafico(ParametroGrafico parametrograficoAux) throws Exception {
		
			parametrograficoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrograficoAux.getEmpresa()));
			parametrograficoAux.setcuentacontableactivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableActivo()));
			parametrograficoAux.setcuentacontablepasivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePasivo()));
			parametrograficoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventario()));
			parametrograficoAux.setcuentacontabledisponibilidad_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableDisponibilidad()));
			parametrograficoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableCostoVenta()));
			parametrograficoAux.setcuentacontableinventarioini_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventarioIni()));
			parametrograficoAux.setcuentacontableinventariofin_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventarioFin()));
			parametrograficoAux.setcuentacontablecuentascobrar_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableCuentasCobrar()));
			parametrograficoAux.setcuentacontableventacredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableVentaCredito()));
			parametrograficoAux.setcuentacontableactivototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableActivoTotal()));
			parametrograficoAux.setcuentacontablepasivototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePasivoTotal()));
			parametrograficoAux.setcuentacontablepatrimonio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePatrimonio()));
			parametrograficoAux.setcuentacontablepatrimoniototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePatrimonioTotal()));
			parametrograficoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableVenta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGrafico(List<ParametroGrafico> parametrograficosTemp) throws Exception {
		for(ParametroGrafico parametrograficoAux:parametrograficosTemp) {
			
			parametrograficoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrograficoAux.getEmpresa()));
			parametrograficoAux.setcuentacontableactivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableActivo()));
			parametrograficoAux.setcuentacontablepasivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePasivo()));
			parametrograficoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventario()));
			parametrograficoAux.setcuentacontabledisponibilidad_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableDisponibilidad()));
			parametrograficoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableCostoVenta()));
			parametrograficoAux.setcuentacontableinventarioini_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventarioIni()));
			parametrograficoAux.setcuentacontableinventariofin_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableInventarioFin()));
			parametrograficoAux.setcuentacontablecuentascobrar_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableCuentasCobrar()));
			parametrograficoAux.setcuentacontableventacredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableVentaCredito()));
			parametrograficoAux.setcuentacontableactivototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableActivoTotal()));
			parametrograficoAux.setcuentacontablepasivototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePasivoTotal()));
			parametrograficoAux.setcuentacontablepatrimonio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePatrimonio()));
			parametrograficoAux.setcuentacontablepatrimoniototal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContablePatrimonioTotal()));
			parametrograficoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrograficoAux.getCuentaContableVenta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGrafico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroGrafico(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGrafico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGraficoConstantesFunciones.getClassesRelationshipsOfParametroGrafico(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGrafico(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGrafico(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGraficoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroGrafico(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGrafico(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(ParametroGrafico parametrografico,List<ParametroGrafico> parametrograficos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroGrafico parametrograficoEncontrado=null;
			
			for(ParametroGrafico parametrograficoLocal:parametrograficos) {
				if(parametrograficoLocal.getId().equals(parametrografico.getId())) {
					parametrograficoEncontrado=parametrograficoLocal;
					
					parametrograficoLocal.setIsChanged(parametrografico.getIsChanged());
					parametrograficoLocal.setIsNew(parametrografico.getIsNew());
					parametrograficoLocal.setIsDeleted(parametrografico.getIsDeleted());
					
					parametrograficoLocal.setGeneralEntityOriginal(parametrografico.getGeneralEntityOriginal());
					
					parametrograficoLocal.setId(parametrografico.getId());	
					parametrograficoLocal.setVersionRow(parametrografico.getVersionRow());	
					parametrograficoLocal.setid_empresa(parametrografico.getid_empresa());	
					parametrograficoLocal.setid_cuenta_contable_activo(parametrografico.getid_cuenta_contable_activo());	
					parametrograficoLocal.setid_cuenta_contable_pasivo(parametrografico.getid_cuenta_contable_pasivo());	
					parametrograficoLocal.setid_cuenta_contable_inventario(parametrografico.getid_cuenta_contable_inventario());	
					parametrograficoLocal.setid_cuenta_contable_disponibilidad(parametrografico.getid_cuenta_contable_disponibilidad());	
					parametrograficoLocal.setid_cuenta_contable_costo_venta(parametrografico.getid_cuenta_contable_costo_venta());	
					parametrograficoLocal.setid_cuenta_contable_inventario_ini(parametrografico.getid_cuenta_contable_inventario_ini());	
					parametrograficoLocal.setid_cuenta_contable_inventario_fin(parametrografico.getid_cuenta_contable_inventario_fin());	
					parametrograficoLocal.setid_cuenta_contable_cuenta_cobrar(parametrografico.getid_cuenta_contable_cuenta_cobrar());	
					parametrograficoLocal.setid_cuenta_contable_venta_credito(parametrografico.getid_cuenta_contable_venta_credito());	
					parametrograficoLocal.setid_cuenta_contable_activo_total(parametrografico.getid_cuenta_contable_activo_total());	
					parametrograficoLocal.setid_cuenta_contable_pasivo_total(parametrografico.getid_cuenta_contable_pasivo_total());	
					parametrograficoLocal.setid_cuenta_contable_patrimonio(parametrografico.getid_cuenta_contable_patrimonio());	
					parametrograficoLocal.setid_cuenta_contable_patrimonio_total(parametrografico.getid_cuenta_contable_patrimonio_total());	
					parametrograficoLocal.setid_cuenta_contable_venta(parametrografico.getid_cuenta_contable_venta());	
					parametrograficoLocal.setinventario_inicial(parametrografico.getinventario_inicial());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrografico.getIsDeleted()) {
				if(!existe) {
					parametrograficos.add(parametrografico);
				}
			} else {
				if(parametrograficoEncontrado!=null && permiteQuitar)  {
					parametrograficos.remove(parametrograficoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroGrafico parametrografico,List<ParametroGrafico> parametrograficos) throws Exception {
		try	{			
			for(ParametroGrafico parametrograficoLocal:parametrograficos) {
				if(parametrograficoLocal.getId().equals(parametrografico.getId())) {
					parametrograficoLocal.setIsSelected(parametrografico.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroGrafico(List<ParametroGrafico> parametrograficosAux) throws Exception {
		//this.parametrograficosAux=parametrograficosAux;
		
		for(ParametroGrafico parametrograficoAux:parametrograficosAux) {
			if(parametrograficoAux.getIsChanged()) {
				parametrograficoAux.setIsChanged(false);
			}		
			
			if(parametrograficoAux.getIsNew()) {
				parametrograficoAux.setIsNew(false);
			}	
			
			if(parametrograficoAux.getIsDeleted()) {
				parametrograficoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroGrafico(ParametroGrafico parametrograficoAux) throws Exception {
		//this.parametrograficoAux=parametrograficoAux;
		
			if(parametrograficoAux.getIsChanged()) {
				parametrograficoAux.setIsChanged(false);
			}		
			
			if(parametrograficoAux.getIsNew()) {
				parametrograficoAux.setIsNew(false);
			}	
			
			if(parametrograficoAux.getIsDeleted()) {
				parametrograficoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroGrafico parametrograficoAsignar,ParametroGrafico parametrografico) throws Exception {
		parametrograficoAsignar.setId(parametrografico.getId());	
		parametrograficoAsignar.setVersionRow(parametrografico.getVersionRow());	
		parametrograficoAsignar.setid_empresa(parametrografico.getid_empresa());
		parametrograficoAsignar.setempresa_descripcion(parametrografico.getempresa_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_activo(parametrografico.getid_cuenta_contable_activo());
		parametrograficoAsignar.setcuentacontableactivo_descripcion(parametrografico.getcuentacontableactivo_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_pasivo(parametrografico.getid_cuenta_contable_pasivo());
		parametrograficoAsignar.setcuentacontablepasivo_descripcion(parametrografico.getcuentacontablepasivo_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_inventario(parametrografico.getid_cuenta_contable_inventario());
		parametrograficoAsignar.setcuentacontableinventario_descripcion(parametrografico.getcuentacontableinventario_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_disponibilidad(parametrografico.getid_cuenta_contable_disponibilidad());
		parametrograficoAsignar.setcuentacontabledisponibilidad_descripcion(parametrografico.getcuentacontabledisponibilidad_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_costo_venta(parametrografico.getid_cuenta_contable_costo_venta());
		parametrograficoAsignar.setcuentacontablecostoventa_descripcion(parametrografico.getcuentacontablecostoventa_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_inventario_ini(parametrografico.getid_cuenta_contable_inventario_ini());
		parametrograficoAsignar.setcuentacontableinventarioini_descripcion(parametrografico.getcuentacontableinventarioini_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_inventario_fin(parametrografico.getid_cuenta_contable_inventario_fin());
		parametrograficoAsignar.setcuentacontableinventariofin_descripcion(parametrografico.getcuentacontableinventariofin_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_cuenta_cobrar(parametrografico.getid_cuenta_contable_cuenta_cobrar());
		parametrograficoAsignar.setcuentacontablecuentascobrar_descripcion(parametrografico.getcuentacontablecuentascobrar_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_venta_credito(parametrografico.getid_cuenta_contable_venta_credito());
		parametrograficoAsignar.setcuentacontableventacredito_descripcion(parametrografico.getcuentacontableventacredito_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_activo_total(parametrografico.getid_cuenta_contable_activo_total());
		parametrograficoAsignar.setcuentacontableactivototal_descripcion(parametrografico.getcuentacontableactivototal_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_pasivo_total(parametrografico.getid_cuenta_contable_pasivo_total());
		parametrograficoAsignar.setcuentacontablepasivototal_descripcion(parametrografico.getcuentacontablepasivototal_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_patrimonio(parametrografico.getid_cuenta_contable_patrimonio());
		parametrograficoAsignar.setcuentacontablepatrimonio_descripcion(parametrografico.getcuentacontablepatrimonio_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_patrimonio_total(parametrografico.getid_cuenta_contable_patrimonio_total());
		parametrograficoAsignar.setcuentacontablepatrimoniototal_descripcion(parametrografico.getcuentacontablepatrimoniototal_descripcion());	
		parametrograficoAsignar.setid_cuenta_contable_venta(parametrografico.getid_cuenta_contable_venta());
		parametrograficoAsignar.setcuentacontableventa_descripcion(parametrografico.getcuentacontableventa_descripcion());	
		parametrograficoAsignar.setinventario_inicial(parametrografico.getinventario_inicial());	
	}
	
	public static void inicializarParametroGrafico(ParametroGrafico parametrografico) throws Exception {
		try {
				parametrografico.setId(0L);	
					
				parametrografico.setid_empresa(-1L);	
				parametrografico.setid_cuenta_contable_activo(-1L);	
				parametrografico.setid_cuenta_contable_pasivo(-1L);	
				parametrografico.setid_cuenta_contable_inventario(-1L);	
				parametrografico.setid_cuenta_contable_disponibilidad(-1L);	
				parametrografico.setid_cuenta_contable_costo_venta(-1L);	
				parametrografico.setid_cuenta_contable_inventario_ini(-1L);	
				parametrografico.setid_cuenta_contable_inventario_fin(-1L);	
				parametrografico.setid_cuenta_contable_cuenta_cobrar(-1L);	
				parametrografico.setid_cuenta_contable_venta_credito(-1L);	
				parametrografico.setid_cuenta_contable_activo_total(-1L);	
				parametrografico.setid_cuenta_contable_pasivo_total(-1L);	
				parametrografico.setid_cuenta_contable_patrimonio(-1L);	
				parametrografico.setid_cuenta_contable_patrimonio_total(-1L);	
				parametrografico.setid_cuenta_contable_venta(-1L);	
				parametrografico.setinventario_inicial(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroGrafico(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEDISPONIBILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOINI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIOFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLECUENTASCOBRAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGraficoConstantesFunciones.LABEL_INVENTARIOINICIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroGrafico(String sTipo,Row row,Workbook workbook,ParametroGrafico parametrografico,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableactivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablepasivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontabledisponibilidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablecostoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableinventarioini_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableinventariofin_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablecuentascobrar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableventacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableactivototal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablepasivototal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablepatrimonio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontablepatrimoniototal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrografico.getinventario_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroGrafico=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroGrafico() {
		return this.sFinalQueryParametroGrafico;
	}
	
	public void setsFinalQueryParametroGrafico(String sFinalQueryParametroGrafico) {
		this.sFinalQueryParametroGrafico= sFinalQueryParametroGrafico;
	}
	
	public Border resaltarSeleccionarParametroGrafico=null;
	
	public Border setResaltarSeleccionarParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroGrafico= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroGrafico() {
		return this.resaltarSeleccionarParametroGrafico;
	}
	
	public void setResaltarSeleccionarParametroGrafico(Border borderResaltarSeleccionarParametroGrafico) {
		this.resaltarSeleccionarParametroGrafico= borderResaltarSeleccionarParametroGrafico;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroGrafico=null;
	public Boolean mostraridParametroGrafico=true;
	public Boolean activaridParametroGrafico=true;

	public Border resaltarid_empresaParametroGrafico=null;
	public Boolean mostrarid_empresaParametroGrafico=true;
	public Boolean activarid_empresaParametroGrafico=true;
	public Boolean cargarid_empresaParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_activoParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_activoParametroGrafico=true;
	public Boolean activarid_cuenta_contable_activoParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_activoParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_activoParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_pasivoParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_pasivoParametroGrafico=true;
	public Boolean activarid_cuenta_contable_pasivoParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_pasivoParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_pasivoParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inventarioParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_inventarioParametroGrafico=true;
	public Boolean activarid_cuenta_contable_inventarioParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_inventarioParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_disponibilidadParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_disponibilidadParametroGrafico=true;
	public Boolean activarid_cuenta_contable_disponibilidadParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_disponibilidadParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_disponibilidadParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_ventaParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_costo_ventaParametroGrafico=true;
	public Boolean activarid_cuenta_contable_costo_ventaParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_costo_ventaParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_ventaParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inventario_iniParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_inventario_iniParametroGrafico=true;
	public Boolean activarid_cuenta_contable_inventario_iniParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_inventario_iniParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventario_iniParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inventario_finParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_inventario_finParametroGrafico=true;
	public Boolean activarid_cuenta_contable_inventario_finParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_inventario_finParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventario_finParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_cuenta_cobrarParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_cuenta_cobrarParametroGrafico=true;
	public Boolean activarid_cuenta_contable_cuenta_cobrarParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_cuenta_cobrarParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_cuenta_cobrarParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_venta_creditoParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_venta_creditoParametroGrafico=true;
	public Boolean activarid_cuenta_contable_venta_creditoParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_venta_creditoParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_venta_creditoParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_activo_totalParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_activo_totalParametroGrafico=true;
	public Boolean activarid_cuenta_contable_activo_totalParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_activo_totalParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_activo_totalParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_pasivo_totalParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_pasivo_totalParametroGrafico=true;
	public Boolean activarid_cuenta_contable_pasivo_totalParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_pasivo_totalParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_pasivo_totalParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_patrimonioParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_patrimonioParametroGrafico=true;
	public Boolean activarid_cuenta_contable_patrimonioParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_patrimonioParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_patrimonioParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_patrimonio_totalParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_patrimonio_totalParametroGrafico=true;
	public Boolean activarid_cuenta_contable_patrimonio_totalParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_patrimonio_totalParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_patrimonio_totalParametroGrafico=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaParametroGrafico=null;
	public Boolean mostrarid_cuenta_contable_ventaParametroGrafico=true;
	public Boolean activarid_cuenta_contable_ventaParametroGrafico=true;
	public Boolean cargarid_cuenta_contable_ventaParametroGrafico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaParametroGrafico=false;//ConEventDepend=true

	public Border resaltarinventario_inicialParametroGrafico=null;
	public Boolean mostrarinventario_inicialParametroGrafico=true;
	public Boolean activarinventario_inicialParametroGrafico=true;

	
	

	public Border setResaltaridParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltaridParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroGrafico() {
		return this.resaltaridParametroGrafico;
	}

	public void setResaltaridParametroGrafico(Border borderResaltar) {
		this.resaltaridParametroGrafico= borderResaltar;
	}

	public Boolean getMostraridParametroGrafico() {
		return this.mostraridParametroGrafico;
	}

	public void setMostraridParametroGrafico(Boolean mostraridParametroGrafico) {
		this.mostraridParametroGrafico= mostraridParametroGrafico;
	}

	public Boolean getActivaridParametroGrafico() {
		return this.activaridParametroGrafico;
	}

	public void setActivaridParametroGrafico(Boolean activaridParametroGrafico) {
		this.activaridParametroGrafico= activaridParametroGrafico;
	}

	public Border setResaltarid_empresaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroGrafico() {
		return this.resaltarid_empresaParametroGrafico;
	}

	public void setResaltarid_empresaParametroGrafico(Border borderResaltar) {
		this.resaltarid_empresaParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroGrafico() {
		return this.mostrarid_empresaParametroGrafico;
	}

	public void setMostrarid_empresaParametroGrafico(Boolean mostrarid_empresaParametroGrafico) {
		this.mostrarid_empresaParametroGrafico= mostrarid_empresaParametroGrafico;
	}

	public Boolean getActivarid_empresaParametroGrafico() {
		return this.activarid_empresaParametroGrafico;
	}

	public void setActivarid_empresaParametroGrafico(Boolean activarid_empresaParametroGrafico) {
		this.activarid_empresaParametroGrafico= activarid_empresaParametroGrafico;
	}

	public Boolean getCargarid_empresaParametroGrafico() {
		return this.cargarid_empresaParametroGrafico;
	}

	public void setCargarid_empresaParametroGrafico(Boolean cargarid_empresaParametroGrafico) {
		this.cargarid_empresaParametroGrafico= cargarid_empresaParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_activoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_activoParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_activoParametroGrafico() {
		return this.resaltarid_cuenta_contable_activoParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_activoParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_activoParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_activoParametroGrafico() {
		return this.mostrarid_cuenta_contable_activoParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_activoParametroGrafico(Boolean mostrarid_cuenta_contable_activoParametroGrafico) {
		this.mostrarid_cuenta_contable_activoParametroGrafico= mostrarid_cuenta_contable_activoParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_activoParametroGrafico() {
		return this.activarid_cuenta_contable_activoParametroGrafico;
	}

	public void setActivarid_cuenta_contable_activoParametroGrafico(Boolean activarid_cuenta_contable_activoParametroGrafico) {
		this.activarid_cuenta_contable_activoParametroGrafico= activarid_cuenta_contable_activoParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_activoParametroGrafico() {
		return this.cargarid_cuenta_contable_activoParametroGrafico;
	}

	public void setCargarid_cuenta_contable_activoParametroGrafico(Boolean cargarid_cuenta_contable_activoParametroGrafico) {
		this.cargarid_cuenta_contable_activoParametroGrafico= cargarid_cuenta_contable_activoParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_pasivoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_pasivoParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_pasivoParametroGrafico() {
		return this.resaltarid_cuenta_contable_pasivoParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_pasivoParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_pasivoParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_pasivoParametroGrafico() {
		return this.mostrarid_cuenta_contable_pasivoParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_pasivoParametroGrafico(Boolean mostrarid_cuenta_contable_pasivoParametroGrafico) {
		this.mostrarid_cuenta_contable_pasivoParametroGrafico= mostrarid_cuenta_contable_pasivoParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_pasivoParametroGrafico() {
		return this.activarid_cuenta_contable_pasivoParametroGrafico;
	}

	public void setActivarid_cuenta_contable_pasivoParametroGrafico(Boolean activarid_cuenta_contable_pasivoParametroGrafico) {
		this.activarid_cuenta_contable_pasivoParametroGrafico= activarid_cuenta_contable_pasivoParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_pasivoParametroGrafico() {
		return this.cargarid_cuenta_contable_pasivoParametroGrafico;
	}

	public void setCargarid_cuenta_contable_pasivoParametroGrafico(Boolean cargarid_cuenta_contable_pasivoParametroGrafico) {
		this.cargarid_cuenta_contable_pasivoParametroGrafico= cargarid_cuenta_contable_pasivoParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_inventarioParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioParametroGrafico() {
		return this.resaltarid_cuenta_contable_inventarioParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_inventarioParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioParametroGrafico() {
		return this.mostrarid_cuenta_contable_inventarioParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_inventarioParametroGrafico(Boolean mostrarid_cuenta_contable_inventarioParametroGrafico) {
		this.mostrarid_cuenta_contable_inventarioParametroGrafico= mostrarid_cuenta_contable_inventarioParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_inventarioParametroGrafico() {
		return this.activarid_cuenta_contable_inventarioParametroGrafico;
	}

	public void setActivarid_cuenta_contable_inventarioParametroGrafico(Boolean activarid_cuenta_contable_inventarioParametroGrafico) {
		this.activarid_cuenta_contable_inventarioParametroGrafico= activarid_cuenta_contable_inventarioParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_inventarioParametroGrafico() {
		return this.cargarid_cuenta_contable_inventarioParametroGrafico;
	}

	public void setCargarid_cuenta_contable_inventarioParametroGrafico(Boolean cargarid_cuenta_contable_inventarioParametroGrafico) {
		this.cargarid_cuenta_contable_inventarioParametroGrafico= cargarid_cuenta_contable_inventarioParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_disponibilidadParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_disponibilidadParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_disponibilidadParametroGrafico() {
		return this.resaltarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_disponibilidadParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_disponibilidadParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_disponibilidadParametroGrafico() {
		return this.mostrarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_disponibilidadParametroGrafico(Boolean mostrarid_cuenta_contable_disponibilidadParametroGrafico) {
		this.mostrarid_cuenta_contable_disponibilidadParametroGrafico= mostrarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_disponibilidadParametroGrafico() {
		return this.activarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public void setActivarid_cuenta_contable_disponibilidadParametroGrafico(Boolean activarid_cuenta_contable_disponibilidadParametroGrafico) {
		this.activarid_cuenta_contable_disponibilidadParametroGrafico= activarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_disponibilidadParametroGrafico() {
		return this.cargarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public void setCargarid_cuenta_contable_disponibilidadParametroGrafico(Boolean cargarid_cuenta_contable_disponibilidadParametroGrafico) {
		this.cargarid_cuenta_contable_disponibilidadParametroGrafico= cargarid_cuenta_contable_disponibilidadParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_costo_ventaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_ventaParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_ventaParametroGrafico() {
		return this.resaltarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_costo_ventaParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_ventaParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_ventaParametroGrafico() {
		return this.mostrarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_costo_ventaParametroGrafico(Boolean mostrarid_cuenta_contable_costo_ventaParametroGrafico) {
		this.mostrarid_cuenta_contable_costo_ventaParametroGrafico= mostrarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_costo_ventaParametroGrafico() {
		return this.activarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public void setActivarid_cuenta_contable_costo_ventaParametroGrafico(Boolean activarid_cuenta_contable_costo_ventaParametroGrafico) {
		this.activarid_cuenta_contable_costo_ventaParametroGrafico= activarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_costo_ventaParametroGrafico() {
		return this.cargarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public void setCargarid_cuenta_contable_costo_ventaParametroGrafico(Boolean cargarid_cuenta_contable_costo_ventaParametroGrafico) {
		this.cargarid_cuenta_contable_costo_ventaParametroGrafico= cargarid_cuenta_contable_costo_ventaParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_inventario_iniParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventario_iniParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventario_iniParametroGrafico() {
		return this.resaltarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_inventario_iniParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventario_iniParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventario_iniParametroGrafico() {
		return this.mostrarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_inventario_iniParametroGrafico(Boolean mostrarid_cuenta_contable_inventario_iniParametroGrafico) {
		this.mostrarid_cuenta_contable_inventario_iniParametroGrafico= mostrarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_inventario_iniParametroGrafico() {
		return this.activarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public void setActivarid_cuenta_contable_inventario_iniParametroGrafico(Boolean activarid_cuenta_contable_inventario_iniParametroGrafico) {
		this.activarid_cuenta_contable_inventario_iniParametroGrafico= activarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_inventario_iniParametroGrafico() {
		return this.cargarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public void setCargarid_cuenta_contable_inventario_iniParametroGrafico(Boolean cargarid_cuenta_contable_inventario_iniParametroGrafico) {
		this.cargarid_cuenta_contable_inventario_iniParametroGrafico= cargarid_cuenta_contable_inventario_iniParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_inventario_finParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventario_finParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventario_finParametroGrafico() {
		return this.resaltarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_inventario_finParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventario_finParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventario_finParametroGrafico() {
		return this.mostrarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_inventario_finParametroGrafico(Boolean mostrarid_cuenta_contable_inventario_finParametroGrafico) {
		this.mostrarid_cuenta_contable_inventario_finParametroGrafico= mostrarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_inventario_finParametroGrafico() {
		return this.activarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public void setActivarid_cuenta_contable_inventario_finParametroGrafico(Boolean activarid_cuenta_contable_inventario_finParametroGrafico) {
		this.activarid_cuenta_contable_inventario_finParametroGrafico= activarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_inventario_finParametroGrafico() {
		return this.cargarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public void setCargarid_cuenta_contable_inventario_finParametroGrafico(Boolean cargarid_cuenta_contable_inventario_finParametroGrafico) {
		this.cargarid_cuenta_contable_inventario_finParametroGrafico= cargarid_cuenta_contable_inventario_finParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_cuenta_cobrarParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_cuenta_cobrarParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_cuenta_cobrarParametroGrafico() {
		return this.resaltarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_cuenta_cobrarParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_cuenta_cobrarParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_cuenta_cobrarParametroGrafico() {
		return this.mostrarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_cuenta_cobrarParametroGrafico(Boolean mostrarid_cuenta_contable_cuenta_cobrarParametroGrafico) {
		this.mostrarid_cuenta_contable_cuenta_cobrarParametroGrafico= mostrarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_cuenta_cobrarParametroGrafico() {
		return this.activarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public void setActivarid_cuenta_contable_cuenta_cobrarParametroGrafico(Boolean activarid_cuenta_contable_cuenta_cobrarParametroGrafico) {
		this.activarid_cuenta_contable_cuenta_cobrarParametroGrafico= activarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_cuenta_cobrarParametroGrafico() {
		return this.cargarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public void setCargarid_cuenta_contable_cuenta_cobrarParametroGrafico(Boolean cargarid_cuenta_contable_cuenta_cobrarParametroGrafico) {
		this.cargarid_cuenta_contable_cuenta_cobrarParametroGrafico= cargarid_cuenta_contable_cuenta_cobrarParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_venta_creditoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_venta_creditoParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_venta_creditoParametroGrafico() {
		return this.resaltarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_venta_creditoParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_venta_creditoParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_venta_creditoParametroGrafico() {
		return this.mostrarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_venta_creditoParametroGrafico(Boolean mostrarid_cuenta_contable_venta_creditoParametroGrafico) {
		this.mostrarid_cuenta_contable_venta_creditoParametroGrafico= mostrarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_venta_creditoParametroGrafico() {
		return this.activarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public void setActivarid_cuenta_contable_venta_creditoParametroGrafico(Boolean activarid_cuenta_contable_venta_creditoParametroGrafico) {
		this.activarid_cuenta_contable_venta_creditoParametroGrafico= activarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_venta_creditoParametroGrafico() {
		return this.cargarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public void setCargarid_cuenta_contable_venta_creditoParametroGrafico(Boolean cargarid_cuenta_contable_venta_creditoParametroGrafico) {
		this.cargarid_cuenta_contable_venta_creditoParametroGrafico= cargarid_cuenta_contable_venta_creditoParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_activo_totalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_activo_totalParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_activo_totalParametroGrafico() {
		return this.resaltarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_activo_totalParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_activo_totalParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_activo_totalParametroGrafico() {
		return this.mostrarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_activo_totalParametroGrafico(Boolean mostrarid_cuenta_contable_activo_totalParametroGrafico) {
		this.mostrarid_cuenta_contable_activo_totalParametroGrafico= mostrarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_activo_totalParametroGrafico() {
		return this.activarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public void setActivarid_cuenta_contable_activo_totalParametroGrafico(Boolean activarid_cuenta_contable_activo_totalParametroGrafico) {
		this.activarid_cuenta_contable_activo_totalParametroGrafico= activarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_activo_totalParametroGrafico() {
		return this.cargarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public void setCargarid_cuenta_contable_activo_totalParametroGrafico(Boolean cargarid_cuenta_contable_activo_totalParametroGrafico) {
		this.cargarid_cuenta_contable_activo_totalParametroGrafico= cargarid_cuenta_contable_activo_totalParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_pasivo_totalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_pasivo_totalParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_pasivo_totalParametroGrafico() {
		return this.resaltarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_pasivo_totalParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_pasivo_totalParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_pasivo_totalParametroGrafico() {
		return this.mostrarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_pasivo_totalParametroGrafico(Boolean mostrarid_cuenta_contable_pasivo_totalParametroGrafico) {
		this.mostrarid_cuenta_contable_pasivo_totalParametroGrafico= mostrarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_pasivo_totalParametroGrafico() {
		return this.activarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public void setActivarid_cuenta_contable_pasivo_totalParametroGrafico(Boolean activarid_cuenta_contable_pasivo_totalParametroGrafico) {
		this.activarid_cuenta_contable_pasivo_totalParametroGrafico= activarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_pasivo_totalParametroGrafico() {
		return this.cargarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public void setCargarid_cuenta_contable_pasivo_totalParametroGrafico(Boolean cargarid_cuenta_contable_pasivo_totalParametroGrafico) {
		this.cargarid_cuenta_contable_pasivo_totalParametroGrafico= cargarid_cuenta_contable_pasivo_totalParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_patrimonioParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_patrimonioParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_patrimonioParametroGrafico() {
		return this.resaltarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_patrimonioParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_patrimonioParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_patrimonioParametroGrafico() {
		return this.mostrarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_patrimonioParametroGrafico(Boolean mostrarid_cuenta_contable_patrimonioParametroGrafico) {
		this.mostrarid_cuenta_contable_patrimonioParametroGrafico= mostrarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_patrimonioParametroGrafico() {
		return this.activarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public void setActivarid_cuenta_contable_patrimonioParametroGrafico(Boolean activarid_cuenta_contable_patrimonioParametroGrafico) {
		this.activarid_cuenta_contable_patrimonioParametroGrafico= activarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_patrimonioParametroGrafico() {
		return this.cargarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public void setCargarid_cuenta_contable_patrimonioParametroGrafico(Boolean cargarid_cuenta_contable_patrimonioParametroGrafico) {
		this.cargarid_cuenta_contable_patrimonioParametroGrafico= cargarid_cuenta_contable_patrimonioParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_patrimonio_totalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_patrimonio_totalParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_patrimonio_totalParametroGrafico() {
		return this.resaltarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_patrimonio_totalParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_patrimonio_totalParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_patrimonio_totalParametroGrafico() {
		return this.mostrarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_patrimonio_totalParametroGrafico(Boolean mostrarid_cuenta_contable_patrimonio_totalParametroGrafico) {
		this.mostrarid_cuenta_contable_patrimonio_totalParametroGrafico= mostrarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_patrimonio_totalParametroGrafico() {
		return this.activarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public void setActivarid_cuenta_contable_patrimonio_totalParametroGrafico(Boolean activarid_cuenta_contable_patrimonio_totalParametroGrafico) {
		this.activarid_cuenta_contable_patrimonio_totalParametroGrafico= activarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_patrimonio_totalParametroGrafico() {
		return this.cargarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public void setCargarid_cuenta_contable_patrimonio_totalParametroGrafico(Boolean cargarid_cuenta_contable_patrimonio_totalParametroGrafico) {
		this.cargarid_cuenta_contable_patrimonio_totalParametroGrafico= cargarid_cuenta_contable_patrimonio_totalParametroGrafico;
	}

	public Border setResaltarid_cuenta_contable_ventaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaParametroGrafico() {
		return this.resaltarid_cuenta_contable_ventaParametroGrafico;
	}

	public void setResaltarid_cuenta_contable_ventaParametroGrafico(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaParametroGrafico() {
		return this.mostrarid_cuenta_contable_ventaParametroGrafico;
	}

	public void setMostrarid_cuenta_contable_ventaParametroGrafico(Boolean mostrarid_cuenta_contable_ventaParametroGrafico) {
		this.mostrarid_cuenta_contable_ventaParametroGrafico= mostrarid_cuenta_contable_ventaParametroGrafico;
	}

	public Boolean getActivarid_cuenta_contable_ventaParametroGrafico() {
		return this.activarid_cuenta_contable_ventaParametroGrafico;
	}

	public void setActivarid_cuenta_contable_ventaParametroGrafico(Boolean activarid_cuenta_contable_ventaParametroGrafico) {
		this.activarid_cuenta_contable_ventaParametroGrafico= activarid_cuenta_contable_ventaParametroGrafico;
	}

	public Boolean getCargarid_cuenta_contable_ventaParametroGrafico() {
		return this.cargarid_cuenta_contable_ventaParametroGrafico;
	}

	public void setCargarid_cuenta_contable_ventaParametroGrafico(Boolean cargarid_cuenta_contable_ventaParametroGrafico) {
		this.cargarid_cuenta_contable_ventaParametroGrafico= cargarid_cuenta_contable_ventaParametroGrafico;
	}

	public Border setResaltarinventario_inicialParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrograficoBeanSwingJInternalFrame.jTtoolBarParametroGrafico.setBorder(borderResaltar);
		
		this.resaltarinventario_inicialParametroGrafico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinventario_inicialParametroGrafico() {
		return this.resaltarinventario_inicialParametroGrafico;
	}

	public void setResaltarinventario_inicialParametroGrafico(Border borderResaltar) {
		this.resaltarinventario_inicialParametroGrafico= borderResaltar;
	}

	public Boolean getMostrarinventario_inicialParametroGrafico() {
		return this.mostrarinventario_inicialParametroGrafico;
	}

	public void setMostrarinventario_inicialParametroGrafico(Boolean mostrarinventario_inicialParametroGrafico) {
		this.mostrarinventario_inicialParametroGrafico= mostrarinventario_inicialParametroGrafico;
	}

	public Boolean getActivarinventario_inicialParametroGrafico() {
		return this.activarinventario_inicialParametroGrafico;
	}

	public void setActivarinventario_inicialParametroGrafico(Boolean activarinventario_inicialParametroGrafico) {
		this.activarinventario_inicialParametroGrafico= activarinventario_inicialParametroGrafico;
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
		
		
		this.setMostraridParametroGrafico(esInicial);
		this.setMostrarid_empresaParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_activoParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_pasivoParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_inventarioParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_disponibilidadParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_costo_ventaParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_inventario_iniParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_inventario_finParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_cuenta_cobrarParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_venta_creditoParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_activo_totalParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_pasivo_totalParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_patrimonioParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_patrimonio_totalParametroGrafico(esInicial);
		this.setMostrarid_cuenta_contable_ventaParametroGrafico(esInicial);
		this.setMostrarinventario_inicialParametroGrafico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.ID)) {
				this.setMostraridParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setMostrarid_cuenta_contable_activoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setMostrarid_cuenta_contable_pasivoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD)) {
				this.setMostrarid_cuenta_contable_disponibilidadParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setMostrarid_cuenta_contable_costo_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI)) {
				this.setMostrarid_cuenta_contable_inventario_iniParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN)) {
				this.setMostrarid_cuenta_contable_inventario_finParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR)) {
				this.setMostrarid_cuenta_contable_cuenta_cobrarParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO)) {
				this.setMostrarid_cuenta_contable_venta_creditoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL)) {
				this.setMostrarid_cuenta_contable_activo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL)) {
				this.setMostrarid_cuenta_contable_pasivo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setMostrarid_cuenta_contable_patrimonioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL)) {
				this.setMostrarid_cuenta_contable_patrimonio_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.INVENTARIOINICIAL)) {
				this.setMostrarinventario_inicialParametroGrafico(esAsigna);
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
		
		
		this.setActivaridParametroGrafico(esInicial);
		this.setActivarid_empresaParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_activoParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_pasivoParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_inventarioParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_disponibilidadParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_costo_ventaParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_inventario_iniParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_inventario_finParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_cuenta_cobrarParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_venta_creditoParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_activo_totalParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_pasivo_totalParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_patrimonioParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_patrimonio_totalParametroGrafico(esInicial);
		this.setActivarid_cuenta_contable_ventaParametroGrafico(esInicial);
		this.setActivarinventario_inicialParametroGrafico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.ID)) {
				this.setActivaridParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setActivarid_cuenta_contable_activoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setActivarid_cuenta_contable_pasivoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD)) {
				this.setActivarid_cuenta_contable_disponibilidadParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setActivarid_cuenta_contable_costo_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI)) {
				this.setActivarid_cuenta_contable_inventario_iniParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN)) {
				this.setActivarid_cuenta_contable_inventario_finParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR)) {
				this.setActivarid_cuenta_contable_cuenta_cobrarParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO)) {
				this.setActivarid_cuenta_contable_venta_creditoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL)) {
				this.setActivarid_cuenta_contable_activo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL)) {
				this.setActivarid_cuenta_contable_pasivo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setActivarid_cuenta_contable_patrimonioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL)) {
				this.setActivarid_cuenta_contable_patrimonio_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.INVENTARIOINICIAL)) {
				this.setActivarinventario_inicialParametroGrafico(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroGrafico(esInicial);
		this.setResaltarid_empresaParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_activoParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_pasivoParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_inventarioParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_disponibilidadParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_costo_ventaParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_inventario_iniParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_inventario_finParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_cuenta_cobrarParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_venta_creditoParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_activo_totalParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_pasivo_totalParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_patrimonioParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_patrimonio_totalParametroGrafico(esInicial);
		this.setResaltarid_cuenta_contable_ventaParametroGrafico(esInicial);
		this.setResaltarinventario_inicialParametroGrafico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.ID)) {
				this.setResaltaridParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setResaltarid_cuenta_contable_activoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setResaltarid_cuenta_contable_pasivoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD)) {
				this.setResaltarid_cuenta_contable_disponibilidadParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setResaltarid_cuenta_contable_costo_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI)) {
				this.setResaltarid_cuenta_contable_inventario_iniParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN)) {
				this.setResaltarid_cuenta_contable_inventario_finParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR)) {
				this.setResaltarid_cuenta_contable_cuenta_cobrarParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO)) {
				this.setResaltarid_cuenta_contable_venta_creditoParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL)) {
				this.setResaltarid_cuenta_contable_activo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL)) {
				this.setResaltarid_cuenta_contable_pasivo_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setResaltarid_cuenta_contable_patrimonioParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL)) {
				this.setResaltarid_cuenta_contable_patrimonio_totalParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaParametroGrafico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGraficoConstantesFunciones.INVENTARIOINICIAL)) {
				this.setResaltarinventario_inicialParametroGrafico(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableActivoParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableActivoParametroGrafico() {
		return this.mostrarFK_IdCuentaContableActivoParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableActivoParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableActivoParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableActivoTotalParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableActivoTotalParametroGrafico() {
		return this.mostrarFK_IdCuentaContableActivoTotalParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableActivoTotalParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableActivoTotalParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoVentaParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableCostoVentaParametroGrafico() {
		return this.mostrarFK_IdCuentaContableCostoVentaParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableCostoVentaParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoVentaParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCuentasCobrarParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableCuentasCobrarParametroGrafico() {
		return this.mostrarFK_IdCuentaContableCuentasCobrarParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableCuentasCobrarParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentasCobrarParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDisponibiladParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableDisponibiladParametroGrafico() {
		return this.mostrarFK_IdCuentaContableDisponibiladParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableDisponibiladParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDisponibiladParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableInventarioParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableInventarioParametroGrafico() {
		return this.mostrarFK_IdCuentaContableInventarioParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableInventarioParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableInventarioParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableInventarioFinParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableInventarioFinParametroGrafico() {
		return this.mostrarFK_IdCuentaContableInventarioFinParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableInventarioFinParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableInventarioFinParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableInventarioIniParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableInventarioIniParametroGrafico() {
		return this.mostrarFK_IdCuentaContableInventarioIniParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableInventarioIniParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableInventarioIniParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePasivoParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContablePasivoParametroGrafico() {
		return this.mostrarFK_IdCuentaContablePasivoParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContablePasivoParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePasivoParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePasivoTotalParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContablePasivoTotalParametroGrafico() {
		return this.mostrarFK_IdCuentaContablePasivoTotalParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContablePasivoTotalParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePasivoTotalParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePatrimonioParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContablePatrimonioParametroGrafico() {
		return this.mostrarFK_IdCuentaContablePatrimonioParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContablePatrimonioParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePatrimonioParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePatrimonioTotalParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContablePatrimonioTotalParametroGrafico() {
		return this.mostrarFK_IdCuentaContablePatrimonioTotalParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContablePatrimonioTotalParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePatrimonioTotalParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableVentaParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableVentaParametroGrafico() {
		return this.mostrarFK_IdCuentaContableVentaParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableVentaParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableVentaParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableVentaCreditoParametroGrafico=true;

	public Boolean getMostrarFK_IdCuentaContableVentaCreditoParametroGrafico() {
		return this.mostrarFK_IdCuentaContableVentaCreditoParametroGrafico;
	}

	public void setMostrarFK_IdCuentaContableVentaCreditoParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableVentaCreditoParametroGrafico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroGrafico=true;

	public Boolean getMostrarFK_IdEmpresaParametroGrafico() {
		return this.mostrarFK_IdEmpresaParametroGrafico;
	}

	public void setMostrarFK_IdEmpresaParametroGrafico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroGrafico= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableActivoParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableActivoParametroGrafico() {
		return this.activarFK_IdCuentaContableActivoParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableActivoParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableActivoParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableActivoTotalParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableActivoTotalParametroGrafico() {
		return this.activarFK_IdCuentaContableActivoTotalParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableActivoTotalParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableActivoTotalParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoVentaParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableCostoVentaParametroGrafico() {
		return this.activarFK_IdCuentaContableCostoVentaParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableCostoVentaParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoVentaParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCuentasCobrarParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableCuentasCobrarParametroGrafico() {
		return this.activarFK_IdCuentaContableCuentasCobrarParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableCuentasCobrarParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentasCobrarParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDisponibiladParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableDisponibiladParametroGrafico() {
		return this.activarFK_IdCuentaContableDisponibiladParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableDisponibiladParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDisponibiladParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableInventarioParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableInventarioParametroGrafico() {
		return this.activarFK_IdCuentaContableInventarioParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableInventarioParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableInventarioParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableInventarioFinParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableInventarioFinParametroGrafico() {
		return this.activarFK_IdCuentaContableInventarioFinParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableInventarioFinParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableInventarioFinParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableInventarioIniParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableInventarioIniParametroGrafico() {
		return this.activarFK_IdCuentaContableInventarioIniParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableInventarioIniParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableInventarioIniParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePasivoParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContablePasivoParametroGrafico() {
		return this.activarFK_IdCuentaContablePasivoParametroGrafico;
	}

	public void setActivarFK_IdCuentaContablePasivoParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePasivoParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePasivoTotalParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContablePasivoTotalParametroGrafico() {
		return this.activarFK_IdCuentaContablePasivoTotalParametroGrafico;
	}

	public void setActivarFK_IdCuentaContablePasivoTotalParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePasivoTotalParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePatrimonioParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContablePatrimonioParametroGrafico() {
		return this.activarFK_IdCuentaContablePatrimonioParametroGrafico;
	}

	public void setActivarFK_IdCuentaContablePatrimonioParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePatrimonioParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePatrimonioTotalParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContablePatrimonioTotalParametroGrafico() {
		return this.activarFK_IdCuentaContablePatrimonioTotalParametroGrafico;
	}

	public void setActivarFK_IdCuentaContablePatrimonioTotalParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePatrimonioTotalParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableVentaParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableVentaParametroGrafico() {
		return this.activarFK_IdCuentaContableVentaParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableVentaParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableVentaParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableVentaCreditoParametroGrafico=true;

	public Boolean getActivarFK_IdCuentaContableVentaCreditoParametroGrafico() {
		return this.activarFK_IdCuentaContableVentaCreditoParametroGrafico;
	}

	public void setActivarFK_IdCuentaContableVentaCreditoParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableVentaCreditoParametroGrafico= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroGrafico=true;

	public Boolean getActivarFK_IdEmpresaParametroGrafico() {
		return this.activarFK_IdEmpresaParametroGrafico;
	}

	public void setActivarFK_IdEmpresaParametroGrafico(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroGrafico= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableActivoParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableActivoParametroGrafico() {
		return this.resaltarFK_IdCuentaContableActivoParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableActivoParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableActivoParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableActivoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableActivoParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableActivoTotalParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableActivoTotalParametroGrafico() {
		return this.resaltarFK_IdCuentaContableActivoTotalParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableActivoTotalParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableActivoTotalParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableActivoTotalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableActivoTotalParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoVentaParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableCostoVentaParametroGrafico() {
		return this.resaltarFK_IdCuentaContableCostoVentaParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableCostoVentaParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoVentaParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoVentaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoVentaParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCuentasCobrarParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableCuentasCobrarParametroGrafico() {
		return this.resaltarFK_IdCuentaContableCuentasCobrarParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableCuentasCobrarParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentasCobrarParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentasCobrarParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentasCobrarParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDisponibiladParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableDisponibiladParametroGrafico() {
		return this.resaltarFK_IdCuentaContableDisponibiladParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableDisponibiladParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDisponibiladParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDisponibiladParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDisponibiladParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableInventarioParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableInventarioParametroGrafico() {
		return this.resaltarFK_IdCuentaContableInventarioParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableInventarioParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableInventarioParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableInventarioParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableInventarioParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableInventarioFinParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableInventarioFinParametroGrafico() {
		return this.resaltarFK_IdCuentaContableInventarioFinParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableInventarioFinParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableInventarioFinParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableInventarioFinParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableInventarioFinParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableInventarioIniParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableInventarioIniParametroGrafico() {
		return this.resaltarFK_IdCuentaContableInventarioIniParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableInventarioIniParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableInventarioIniParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableInventarioIniParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableInventarioIniParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePasivoParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContablePasivoParametroGrafico() {
		return this.resaltarFK_IdCuentaContablePasivoParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContablePasivoParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePasivoParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePasivoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePasivoParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePasivoTotalParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContablePasivoTotalParametroGrafico() {
		return this.resaltarFK_IdCuentaContablePasivoTotalParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContablePasivoTotalParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePasivoTotalParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePasivoTotalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePasivoTotalParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePatrimonioParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContablePatrimonioParametroGrafico() {
		return this.resaltarFK_IdCuentaContablePatrimonioParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePatrimonioParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePatrimonioParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico() {
		return this.resaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePatrimonioTotalParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableVentaParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableVentaParametroGrafico() {
		return this.resaltarFK_IdCuentaContableVentaParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableVentaParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableVentaParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableVentaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableVentaParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableVentaCreditoParametroGrafico=null;

	public Border getResaltarFK_IdCuentaContableVentaCreditoParametroGrafico() {
		return this.resaltarFK_IdCuentaContableVentaCreditoParametroGrafico;
	}

	public void setResaltarFK_IdCuentaContableVentaCreditoParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableVentaCreditoParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableVentaCreditoParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableVentaCreditoParametroGrafico= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroGrafico=null;

	public Border getResaltarFK_IdEmpresaParametroGrafico() {
		return this.resaltarFK_IdEmpresaParametroGrafico;
	}

	public void setResaltarFK_IdEmpresaParametroGrafico(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroGrafico= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroGrafico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGraficoBeanSwingJInternalFrame parametrograficoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroGrafico= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}