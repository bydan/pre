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


import com.bydan.erp.comisiones.util.ComisionConfigConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionConfigParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionConfigParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionConfigConstantesFunciones extends ComisionConfigConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionConfig";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionConfig"+ComisionConfigConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionConfigHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionConfigHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionConfigConstantesFunciones.SCHEMA+"_"+ComisionConfigConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionConfigConstantesFunciones.SCHEMA+"_"+ComisionConfigConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionConfigConstantesFunciones.SCHEMA+"_"+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionConfigConstantesFunciones.SCHEMA+"_"+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionConfigConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionConfigConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionConfigConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionConfigConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Configes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Comision Config";
	public static final String SCLASSWEBTITULO_LOWER="Comision Config";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionConfig";
	public static final String OBJECTNAME="comisionconfig";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_config";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisionconfig from "+ComisionConfigConstantesFunciones.SPERSISTENCENAME+" comisionconfig";
	public static String QUERYSELECTNATIVE="select "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".version_row,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_empresa,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_tipo_comision_config,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_nivel_linea,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_vendedor,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_ventas,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_cobros,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_remesa_transito,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_penalidad,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_abono from "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME;//+" as "+ComisionConfigConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionConfigConstantesFuncionesAdditional comisionconfigConstantesFuncionesAdditional=null;
	
	public ComisionConfigConstantesFuncionesAdditional getComisionConfigConstantesFuncionesAdditional() {
		return this.comisionconfigConstantesFuncionesAdditional;
	}
	
	public void setComisionConfigConstantesFuncionesAdditional(ComisionConfigConstantesFuncionesAdditional comisionconfigConstantesFuncionesAdditional) {
		try {
			this.comisionconfigConstantesFuncionesAdditional=comisionconfigConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOCOMISIONCONFIG= "id_tipo_comision_config";
    public static final String IDNIVELLINEA= "id_nivel_linea";
    public static final String CONVENDEDOR= "con_vendedor";
    public static final String CONVENTAS= "con_ventas";
    public static final String CONCOBROS= "con_cobros";
    public static final String CONREMESATRANSITO= "con_remesa_transito";
    public static final String CONPENALIDAD= "con_penalidad";
    public static final String CONABONO= "con_abono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOCOMISIONCONFIG= "Tipo Configuracion";
		public static final String LABEL_IDTIPOCOMISIONCONFIG_LOWER= "Tipo Comision Config";
    	public static final String LABEL_IDNIVELLINEA= "Nivel Linea";
		public static final String LABEL_IDNIVELLINEA_LOWER= "Nivel Linea";
    	public static final String LABEL_CONVENDEDOR= "Con Vendedor";
		public static final String LABEL_CONVENDEDOR_LOWER= "Con Vendedor";
    	public static final String LABEL_CONVENTAS= "Con Ventas";
		public static final String LABEL_CONVENTAS_LOWER= "Con Ventas";
    	public static final String LABEL_CONCOBROS= "Con Cobros";
		public static final String LABEL_CONCOBROS_LOWER= "Con Cobros";
    	public static final String LABEL_CONREMESATRANSITO= "Con Remesa Transito";
		public static final String LABEL_CONREMESATRANSITO_LOWER= "Con Remesa Transito";
    	public static final String LABEL_CONPENALIDAD= "Con Penalidad";
		public static final String LABEL_CONPENALIDAD_LOWER= "Con Penalidad";
    	public static final String LABEL_CONABONO= "Con Abono";
		public static final String LABEL_CONABONO_LOWER= "Con Abono";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getComisionConfigLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_IDTIPOCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.IDNIVELLINEA)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_IDNIVELLINEA;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONVENDEDOR)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONVENDEDOR;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONVENTAS)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONVENTAS;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONCOBROS)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONCOBROS;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONREMESATRANSITO)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONREMESATRANSITO;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONPENALIDAD)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONPENALIDAD;}
		if(sNombreColumna.equals(ComisionConfigConstantesFunciones.CONABONO)) {sLabelColumna=ComisionConfigConstantesFunciones.LABEL_CONABONO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getcon_vendedorDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_vendedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_vendedorHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_vendedor());

		return sDescripcion;
	}	
		
	public static String getcon_ventasDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_ventas()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_ventasHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_ventas());

		return sDescripcion;
	}	
		
	public static String getcon_cobrosDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_cobros()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cobrosHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_cobros());

		return sDescripcion;
	}	
		
	public static String getcon_remesa_transitoDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_remesa_transito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_remesa_transitoHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_remesa_transito());

		return sDescripcion;
	}	
		
	public static String getcon_penalidadDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_penalidad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_penalidadHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_penalidad());

		return sDescripcion;
	}	
		
	public static String getcon_abonoDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!comisionconfig.getcon_abono()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_abonoHtmlDescripcion(ComisionConfig comisionconfig) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(comisionconfig.getId(),comisionconfig.getcon_abono());

		return sDescripcion;
	}	
	
	public static String getComisionConfigDescripcion(ComisionConfig comisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisionconfig !=null/* && comisionconfig.getId()!=0*/) {
			if(comisionconfig.getId()!=null) {
				sDescripcion=comisionconfig.getId().toString();
			}//comisionconfigcomisionconfig.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionConfigDescripcionDetallado(ComisionConfig comisionconfig) {
		String sDescripcion="";
			
		sDescripcion+=ComisionConfigConstantesFunciones.ID+"=";
		sDescripcion+=comisionconfig.getId().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisionconfig.getVersionRow().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisionconfig.getid_empresa().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG+"=";
		sDescripcion+=comisionconfig.getid_tipo_comision_config().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.IDNIVELLINEA+"=";
		sDescripcion+=comisionconfig.getid_nivel_linea().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONVENDEDOR+"=";
		sDescripcion+=comisionconfig.getcon_vendedor().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONVENTAS+"=";
		sDescripcion+=comisionconfig.getcon_ventas().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONCOBROS+"=";
		sDescripcion+=comisionconfig.getcon_cobros().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONREMESATRANSITO+"=";
		sDescripcion+=comisionconfig.getcon_remesa_transito().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONPENALIDAD+"=";
		sDescripcion+=comisionconfig.getcon_penalidad().toString()+",";
		sDescripcion+=ComisionConfigConstantesFunciones.CONABONO+"=";
		sDescripcion+=comisionconfig.getcon_abono().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionConfigDescripcion(ComisionConfig comisionconfig,String sValor) throws Exception {			
		if(comisionconfig !=null) {
			//comisionconfigcomisionconfig.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoComisionConfigDescripcion(TipoComisionConfig tipocomisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomisionconfig!=null/*&&tipocomisionconfig.getId()>0*/) {
			sDescripcion=TipoComisionConfigConstantesFunciones.getTipoComisionConfigDescripcion(tipocomisionconfig);
		}

		return sDescripcion;
	}

	public static String getNivelLineaDescripcion(NivelLinea nivellinea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(nivellinea!=null/*&&nivellinea.getId()>0*/) {
			sDescripcion=NivelLineaConstantesFunciones.getNivelLineaDescripcion(nivellinea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdNivelLinea")) {
			sNombreIndice="Tipo=  Por Nivel Linea";
		} else if(sNombreIndice.equals("FK_IdTipoComisionConfig")) {
			sNombreIndice="Tipo=  Por Tipo Configuracion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNivelLinea(Long id_nivel_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_nivel_linea!=null) {sDetalleIndice+=" Codigo Unico De Nivel Linea="+id_nivel_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComisionConfig(Long id_tipo_comision_config) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comision_config!=null) {sDetalleIndice+=" Codigo Unico De Tipo Configuracion="+id_tipo_comision_config.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionConfig(ComisionConfig comisionconfig,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosComisionConfigs(List<ComisionConfig> comisionconfigs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionConfig comisionconfig: comisionconfigs) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionConfig(ComisionConfig comisionconfig,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisionconfig.getConCambioAuxiliar()) {
			comisionconfig.setIsDeleted(comisionconfig.getIsDeletedAuxiliar());	
			comisionconfig.setIsNew(comisionconfig.getIsNewAuxiliar());	
			comisionconfig.setIsChanged(comisionconfig.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisionconfig.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisionconfig.setIsDeletedAuxiliar(false);	
			comisionconfig.setIsNewAuxiliar(false);	
			comisionconfig.setIsChangedAuxiliar(false);
			
			comisionconfig.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionConfigs(List<ComisionConfig> comisionconfigs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionConfig comisionconfig : comisionconfigs) {
			if(conAsignarBase && comisionconfig.getConCambioAuxiliar()) {
				comisionconfig.setIsDeleted(comisionconfig.getIsDeletedAuxiliar());	
				comisionconfig.setIsNew(comisionconfig.getIsNewAuxiliar());	
				comisionconfig.setIsChanged(comisionconfig.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisionconfig.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisionconfig.setIsDeletedAuxiliar(false);	
				comisionconfig.setIsNewAuxiliar(false);	
				comisionconfig.setIsChangedAuxiliar(false);
				
				comisionconfig.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionConfig(ComisionConfig comisionconfig,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisionConfigs(List<ComisionConfig> comisionconfigs,Boolean conEnteros) throws Exception  {
		
		for(ComisionConfig comisionconfig: comisionconfigs) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionConfig(List<ComisionConfig> comisionconfigs,ComisionConfig comisionconfigAux) throws Exception  {
		ComisionConfigConstantesFunciones.InicializarValoresComisionConfig(comisionconfigAux,true);
		
		for(ComisionConfig comisionconfig: comisionconfigs) {
			if(comisionconfig.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionConfigConstantesFunciones.getArrayColumnasGlobalesComisionConfig(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionConfigConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionConfigConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionConfig> comisionconfigs,ComisionConfig comisionconfig,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionConfig comisionconfigAux: comisionconfigs) {
			if(comisionconfigAux!=null && comisionconfig!=null) {
				if((comisionconfigAux.getId()==null && comisionconfig.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionconfigAux.getId()!=null && comisionconfig.getId()!=null){
					if(comisionconfigAux.getId().equals(comisionconfig.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionConfig(List<ComisionConfig> comisionconfigs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ComisionConfig comisionconfig: comisionconfigs) {			
			if(comisionconfig.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionConfig() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_ID, ComisionConfigConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_VERSIONROW, ComisionConfigConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_IDEMPRESA, ComisionConfigConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_IDTIPOCOMISIONCONFIG, ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_IDNIVELLINEA, ComisionConfigConstantesFunciones.IDNIVELLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONVENDEDOR, ComisionConfigConstantesFunciones.CONVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONVENTAS, ComisionConfigConstantesFunciones.CONVENTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONCOBROS, ComisionConfigConstantesFunciones.CONCOBROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONREMESATRANSITO, ComisionConfigConstantesFunciones.CONREMESATRANSITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONPENALIDAD, ComisionConfigConstantesFunciones.CONPENALIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionConfigConstantesFunciones.LABEL_CONABONO, ComisionConfigConstantesFunciones.CONABONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionConfig() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.IDNIVELLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONVENTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONCOBROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONREMESATRANSITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONPENALIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionConfigConstantesFunciones.CONABONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionConfig() throws Exception  {
		return ComisionConfigConstantesFunciones.getTiposSeleccionarComisionConfig(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionConfig(Boolean conFk) throws Exception  {
		return ComisionConfigConstantesFunciones.getTiposSeleccionarComisionConfig(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionConfig(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_IDTIPOCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_IDTIPOCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_IDNIVELLINEA);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_IDNIVELLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONVENDEDOR);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONVENTAS);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONVENTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONCOBROS);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONCOBROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONREMESATRANSITO);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONREMESATRANSITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONPENALIDAD);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONPENALIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionConfigConstantesFunciones.LABEL_CONABONO);
			reporte.setsDescripcion(ComisionConfigConstantesFunciones.LABEL_CONABONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionConfig(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionConfig(ComisionConfig comisionconfigAux) throws Exception {
		
			comisionconfigAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionconfigAux.getEmpresa()));
			comisionconfigAux.settipocomisionconfig_descripcion(TipoComisionConfigConstantesFunciones.getTipoComisionConfigDescripcion(comisionconfigAux.getTipoComisionConfig()));
			comisionconfigAux.setnivellinea_descripcion(NivelLineaConstantesFunciones.getNivelLineaDescripcion(comisionconfigAux.getNivelLinea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionConfig(List<ComisionConfig> comisionconfigsTemp) throws Exception {
		for(ComisionConfig comisionconfigAux:comisionconfigsTemp) {
			
			comisionconfigAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionconfigAux.getEmpresa()));
			comisionconfigAux.settipocomisionconfig_descripcion(TipoComisionConfigConstantesFunciones.getTipoComisionConfigDescripcion(comisionconfigAux.getTipoComisionConfig()));
			comisionconfigAux.setnivellinea_descripcion(NivelLineaConstantesFunciones.getNivelLineaDescripcion(comisionconfigAux.getNivelLinea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoComisionConfig.class));
				classes.add(new Classe(NivelLinea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComisionConfig.class)) {
						classes.add(new Classe(TipoComisionConfig.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NivelLinea.class)) {
						classes.add(new Classe(NivelLinea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComisionConfig.class)); continue;
					}

					if(NivelLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelLinea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComisionConfig.class)); continue;
					}

					if(NivelLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelLinea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionConfigConstantesFunciones.getClassesRelationshipsOfComisionConfig(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ComisionCate.class));
				classes.add(new Classe(ComisionMarca.class));
				classes.add(new Classe(ComisionLinea.class));
				classes.add(new Classe(ComisionPena.class));
				classes.add(new Classe(ComisionGrupo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionCate.class)) {
						classes.add(new Classe(ComisionCate.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionMarca.class)) {
						classes.add(new Classe(ComisionMarca.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionLinea.class)) {
						classes.add(new Classe(ComisionLinea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionPena.class)) {
						classes.add(new Classe(ComisionPena.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionGrupo.class)) {
						classes.add(new Classe(ComisionGrupo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionConfigConstantesFunciones.getClassesRelationshipsFromStringsOfComisionConfig(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionPena.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionPena.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionPena.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionPena.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
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
	public static void actualizarLista(ComisionConfig comisionconfig,List<ComisionConfig> comisionconfigs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionConfig comisionconfigEncontrado=null;
			
			for(ComisionConfig comisionconfigLocal:comisionconfigs) {
				if(comisionconfigLocal.getId().equals(comisionconfig.getId())) {
					comisionconfigEncontrado=comisionconfigLocal;
					
					comisionconfigLocal.setIsChanged(comisionconfig.getIsChanged());
					comisionconfigLocal.setIsNew(comisionconfig.getIsNew());
					comisionconfigLocal.setIsDeleted(comisionconfig.getIsDeleted());
					
					comisionconfigLocal.setGeneralEntityOriginal(comisionconfig.getGeneralEntityOriginal());
					
					comisionconfigLocal.setId(comisionconfig.getId());	
					comisionconfigLocal.setVersionRow(comisionconfig.getVersionRow());	
					comisionconfigLocal.setid_empresa(comisionconfig.getid_empresa());	
					comisionconfigLocal.setid_tipo_comision_config(comisionconfig.getid_tipo_comision_config());	
					comisionconfigLocal.setid_nivel_linea(comisionconfig.getid_nivel_linea());	
					comisionconfigLocal.setcon_vendedor(comisionconfig.getcon_vendedor());	
					comisionconfigLocal.setcon_ventas(comisionconfig.getcon_ventas());	
					comisionconfigLocal.setcon_cobros(comisionconfig.getcon_cobros());	
					comisionconfigLocal.setcon_remesa_transito(comisionconfig.getcon_remesa_transito());	
					comisionconfigLocal.setcon_penalidad(comisionconfig.getcon_penalidad());	
					comisionconfigLocal.setcon_abono(comisionconfig.getcon_abono());	
					
					
					comisionconfigLocal.setComisionCates(comisionconfig.getComisionCates());
					comisionconfigLocal.setComisionMarcas(comisionconfig.getComisionMarcas());
					comisionconfigLocal.setComisionLineas(comisionconfig.getComisionLineas());
					comisionconfigLocal.setComisionPenas(comisionconfig.getComisionPenas());
					comisionconfigLocal.setComisionGrupos(comisionconfig.getComisionGrupos());
					
					existe=true;
					break;
				}
			}
			
			if(!comisionconfig.getIsDeleted()) {
				if(!existe) {
					comisionconfigs.add(comisionconfig);
				}
			} else {
				if(comisionconfigEncontrado!=null && permiteQuitar)  {
					comisionconfigs.remove(comisionconfigEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionConfig comisionconfig,List<ComisionConfig> comisionconfigs) throws Exception {
		try	{			
			for(ComisionConfig comisionconfigLocal:comisionconfigs) {
				if(comisionconfigLocal.getId().equals(comisionconfig.getId())) {
					comisionconfigLocal.setIsSelected(comisionconfig.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionConfig(List<ComisionConfig> comisionconfigsAux) throws Exception {
		//this.comisionconfigsAux=comisionconfigsAux;
		
		for(ComisionConfig comisionconfigAux:comisionconfigsAux) {
			if(comisionconfigAux.getIsChanged()) {
				comisionconfigAux.setIsChanged(false);
			}		
			
			if(comisionconfigAux.getIsNew()) {
				comisionconfigAux.setIsNew(false);
			}	
			
			if(comisionconfigAux.getIsDeleted()) {
				comisionconfigAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionConfig(ComisionConfig comisionconfigAux) throws Exception {
		//this.comisionconfigAux=comisionconfigAux;
		
			if(comisionconfigAux.getIsChanged()) {
				comisionconfigAux.setIsChanged(false);
			}		
			
			if(comisionconfigAux.getIsNew()) {
				comisionconfigAux.setIsNew(false);
			}	
			
			if(comisionconfigAux.getIsDeleted()) {
				comisionconfigAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionConfig comisionconfigAsignar,ComisionConfig comisionconfig) throws Exception {
		comisionconfigAsignar.setId(comisionconfig.getId());	
		comisionconfigAsignar.setVersionRow(comisionconfig.getVersionRow());	
		comisionconfigAsignar.setid_empresa(comisionconfig.getid_empresa());
		comisionconfigAsignar.setempresa_descripcion(comisionconfig.getempresa_descripcion());	
		comisionconfigAsignar.setid_tipo_comision_config(comisionconfig.getid_tipo_comision_config());
		comisionconfigAsignar.settipocomisionconfig_descripcion(comisionconfig.gettipocomisionconfig_descripcion());	
		comisionconfigAsignar.setid_nivel_linea(comisionconfig.getid_nivel_linea());
		comisionconfigAsignar.setnivellinea_descripcion(comisionconfig.getnivellinea_descripcion());	
		comisionconfigAsignar.setcon_vendedor(comisionconfig.getcon_vendedor());	
		comisionconfigAsignar.setcon_ventas(comisionconfig.getcon_ventas());	
		comisionconfigAsignar.setcon_cobros(comisionconfig.getcon_cobros());	
		comisionconfigAsignar.setcon_remesa_transito(comisionconfig.getcon_remesa_transito());	
		comisionconfigAsignar.setcon_penalidad(comisionconfig.getcon_penalidad());	
		comisionconfigAsignar.setcon_abono(comisionconfig.getcon_abono());	
	}
	
	public static void inicializarComisionConfig(ComisionConfig comisionconfig) throws Exception {
		try {
				comisionconfig.setId(0L);	
					
				comisionconfig.setid_empresa(-1L);	
				comisionconfig.setid_tipo_comision_config(-1L);	
				comisionconfig.setid_nivel_linea(-1L);	
				comisionconfig.setcon_vendedor(false);	
				comisionconfig.setcon_ventas(false);	
				comisionconfig.setcon_cobros(false);	
				comisionconfig.setcon_remesa_transito(false);	
				comisionconfig.setcon_penalidad(false);	
				comisionconfig.setcon_abono(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionConfig(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_IDTIPOCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_IDNIVELLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONVENTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONCOBROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONREMESATRANSITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONPENALIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionConfigConstantesFunciones.LABEL_CONABONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionConfig(String sTipo,Row row,Workbook workbook,ComisionConfig comisionconfig,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionconfig.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionconfig.gettipocomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionconfig.getnivellinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_vendedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_ventas()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_cobros()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_remesa_transito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_penalidad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(comisionconfig.getcon_abono()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionConfig=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionConfig() {
		return this.sFinalQueryComisionConfig;
	}
	
	public void setsFinalQueryComisionConfig(String sFinalQueryComisionConfig) {
		this.sFinalQueryComisionConfig= sFinalQueryComisionConfig;
	}
	
	public Border resaltarSeleccionarComisionConfig=null;
	
	public Border setResaltarSeleccionarComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionConfig= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionConfig() {
		return this.resaltarSeleccionarComisionConfig;
	}
	
	public void setResaltarSeleccionarComisionConfig(Border borderResaltarSeleccionarComisionConfig) {
		this.resaltarSeleccionarComisionConfig= borderResaltarSeleccionarComisionConfig;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionConfig=null;
	public Boolean mostraridComisionConfig=true;
	public Boolean activaridComisionConfig=true;

	public Border resaltarid_empresaComisionConfig=null;
	public Boolean mostrarid_empresaComisionConfig=true;
	public Boolean activarid_empresaComisionConfig=true;
	public Boolean cargarid_empresaComisionConfig=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionConfig=false;//ConEventDepend=true

	public Border resaltarid_tipo_comision_configComisionConfig=null;
	public Boolean mostrarid_tipo_comision_configComisionConfig=true;
	public Boolean activarid_tipo_comision_configComisionConfig=true;
	public Boolean cargarid_tipo_comision_configComisionConfig=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comision_configComisionConfig=false;//ConEventDepend=true

	public Border resaltarid_nivel_lineaComisionConfig=null;
	public Boolean mostrarid_nivel_lineaComisionConfig=true;
	public Boolean activarid_nivel_lineaComisionConfig=true;
	public Boolean cargarid_nivel_lineaComisionConfig=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nivel_lineaComisionConfig=false;//ConEventDepend=true

	public Border resaltarcon_vendedorComisionConfig=null;
	public Boolean mostrarcon_vendedorComisionConfig=true;
	public Boolean activarcon_vendedorComisionConfig=true;

	public Border resaltarcon_ventasComisionConfig=null;
	public Boolean mostrarcon_ventasComisionConfig=true;
	public Boolean activarcon_ventasComisionConfig=true;

	public Border resaltarcon_cobrosComisionConfig=null;
	public Boolean mostrarcon_cobrosComisionConfig=true;
	public Boolean activarcon_cobrosComisionConfig=true;

	public Border resaltarcon_remesa_transitoComisionConfig=null;
	public Boolean mostrarcon_remesa_transitoComisionConfig=true;
	public Boolean activarcon_remesa_transitoComisionConfig=true;

	public Border resaltarcon_penalidadComisionConfig=null;
	public Boolean mostrarcon_penalidadComisionConfig=true;
	public Boolean activarcon_penalidadComisionConfig=true;

	public Border resaltarcon_abonoComisionConfig=null;
	public Boolean mostrarcon_abonoComisionConfig=true;
	public Boolean activarcon_abonoComisionConfig=true;

	
	

	public Border setResaltaridComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltaridComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionConfig() {
		return this.resaltaridComisionConfig;
	}

	public void setResaltaridComisionConfig(Border borderResaltar) {
		this.resaltaridComisionConfig= borderResaltar;
	}

	public Boolean getMostraridComisionConfig() {
		return this.mostraridComisionConfig;
	}

	public void setMostraridComisionConfig(Boolean mostraridComisionConfig) {
		this.mostraridComisionConfig= mostraridComisionConfig;
	}

	public Boolean getActivaridComisionConfig() {
		return this.activaridComisionConfig;
	}

	public void setActivaridComisionConfig(Boolean activaridComisionConfig) {
		this.activaridComisionConfig= activaridComisionConfig;
	}

	public Border setResaltarid_empresaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionConfig() {
		return this.resaltarid_empresaComisionConfig;
	}

	public void setResaltarid_empresaComisionConfig(Border borderResaltar) {
		this.resaltarid_empresaComisionConfig= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionConfig() {
		return this.mostrarid_empresaComisionConfig;
	}

	public void setMostrarid_empresaComisionConfig(Boolean mostrarid_empresaComisionConfig) {
		this.mostrarid_empresaComisionConfig= mostrarid_empresaComisionConfig;
	}

	public Boolean getActivarid_empresaComisionConfig() {
		return this.activarid_empresaComisionConfig;
	}

	public void setActivarid_empresaComisionConfig(Boolean activarid_empresaComisionConfig) {
		this.activarid_empresaComisionConfig= activarid_empresaComisionConfig;
	}

	public Boolean getCargarid_empresaComisionConfig() {
		return this.cargarid_empresaComisionConfig;
	}

	public void setCargarid_empresaComisionConfig(Boolean cargarid_empresaComisionConfig) {
		this.cargarid_empresaComisionConfig= cargarid_empresaComisionConfig;
	}

	public Border setResaltarid_tipo_comision_configComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarid_tipo_comision_configComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comision_configComisionConfig() {
		return this.resaltarid_tipo_comision_configComisionConfig;
	}

	public void setResaltarid_tipo_comision_configComisionConfig(Border borderResaltar) {
		this.resaltarid_tipo_comision_configComisionConfig= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comision_configComisionConfig() {
		return this.mostrarid_tipo_comision_configComisionConfig;
	}

	public void setMostrarid_tipo_comision_configComisionConfig(Boolean mostrarid_tipo_comision_configComisionConfig) {
		this.mostrarid_tipo_comision_configComisionConfig= mostrarid_tipo_comision_configComisionConfig;
	}

	public Boolean getActivarid_tipo_comision_configComisionConfig() {
		return this.activarid_tipo_comision_configComisionConfig;
	}

	public void setActivarid_tipo_comision_configComisionConfig(Boolean activarid_tipo_comision_configComisionConfig) {
		this.activarid_tipo_comision_configComisionConfig= activarid_tipo_comision_configComisionConfig;
	}

	public Boolean getCargarid_tipo_comision_configComisionConfig() {
		return this.cargarid_tipo_comision_configComisionConfig;
	}

	public void setCargarid_tipo_comision_configComisionConfig(Boolean cargarid_tipo_comision_configComisionConfig) {
		this.cargarid_tipo_comision_configComisionConfig= cargarid_tipo_comision_configComisionConfig;
	}

	public Border setResaltarid_nivel_lineaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarid_nivel_lineaComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nivel_lineaComisionConfig() {
		return this.resaltarid_nivel_lineaComisionConfig;
	}

	public void setResaltarid_nivel_lineaComisionConfig(Border borderResaltar) {
		this.resaltarid_nivel_lineaComisionConfig= borderResaltar;
	}

	public Boolean getMostrarid_nivel_lineaComisionConfig() {
		return this.mostrarid_nivel_lineaComisionConfig;
	}

	public void setMostrarid_nivel_lineaComisionConfig(Boolean mostrarid_nivel_lineaComisionConfig) {
		this.mostrarid_nivel_lineaComisionConfig= mostrarid_nivel_lineaComisionConfig;
	}

	public Boolean getActivarid_nivel_lineaComisionConfig() {
		return this.activarid_nivel_lineaComisionConfig;
	}

	public void setActivarid_nivel_lineaComisionConfig(Boolean activarid_nivel_lineaComisionConfig) {
		this.activarid_nivel_lineaComisionConfig= activarid_nivel_lineaComisionConfig;
	}

	public Boolean getCargarid_nivel_lineaComisionConfig() {
		return this.cargarid_nivel_lineaComisionConfig;
	}

	public void setCargarid_nivel_lineaComisionConfig(Boolean cargarid_nivel_lineaComisionConfig) {
		this.cargarid_nivel_lineaComisionConfig= cargarid_nivel_lineaComisionConfig;
	}

	public Border setResaltarcon_vendedorComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_vendedorComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_vendedorComisionConfig() {
		return this.resaltarcon_vendedorComisionConfig;
	}

	public void setResaltarcon_vendedorComisionConfig(Border borderResaltar) {
		this.resaltarcon_vendedorComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_vendedorComisionConfig() {
		return this.mostrarcon_vendedorComisionConfig;
	}

	public void setMostrarcon_vendedorComisionConfig(Boolean mostrarcon_vendedorComisionConfig) {
		this.mostrarcon_vendedorComisionConfig= mostrarcon_vendedorComisionConfig;
	}

	public Boolean getActivarcon_vendedorComisionConfig() {
		return this.activarcon_vendedorComisionConfig;
	}

	public void setActivarcon_vendedorComisionConfig(Boolean activarcon_vendedorComisionConfig) {
		this.activarcon_vendedorComisionConfig= activarcon_vendedorComisionConfig;
	}

	public Border setResaltarcon_ventasComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_ventasComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_ventasComisionConfig() {
		return this.resaltarcon_ventasComisionConfig;
	}

	public void setResaltarcon_ventasComisionConfig(Border borderResaltar) {
		this.resaltarcon_ventasComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_ventasComisionConfig() {
		return this.mostrarcon_ventasComisionConfig;
	}

	public void setMostrarcon_ventasComisionConfig(Boolean mostrarcon_ventasComisionConfig) {
		this.mostrarcon_ventasComisionConfig= mostrarcon_ventasComisionConfig;
	}

	public Boolean getActivarcon_ventasComisionConfig() {
		return this.activarcon_ventasComisionConfig;
	}

	public void setActivarcon_ventasComisionConfig(Boolean activarcon_ventasComisionConfig) {
		this.activarcon_ventasComisionConfig= activarcon_ventasComisionConfig;
	}

	public Border setResaltarcon_cobrosComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_cobrosComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cobrosComisionConfig() {
		return this.resaltarcon_cobrosComisionConfig;
	}

	public void setResaltarcon_cobrosComisionConfig(Border borderResaltar) {
		this.resaltarcon_cobrosComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_cobrosComisionConfig() {
		return this.mostrarcon_cobrosComisionConfig;
	}

	public void setMostrarcon_cobrosComisionConfig(Boolean mostrarcon_cobrosComisionConfig) {
		this.mostrarcon_cobrosComisionConfig= mostrarcon_cobrosComisionConfig;
	}

	public Boolean getActivarcon_cobrosComisionConfig() {
		return this.activarcon_cobrosComisionConfig;
	}

	public void setActivarcon_cobrosComisionConfig(Boolean activarcon_cobrosComisionConfig) {
		this.activarcon_cobrosComisionConfig= activarcon_cobrosComisionConfig;
	}

	public Border setResaltarcon_remesa_transitoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_remesa_transitoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_remesa_transitoComisionConfig() {
		return this.resaltarcon_remesa_transitoComisionConfig;
	}

	public void setResaltarcon_remesa_transitoComisionConfig(Border borderResaltar) {
		this.resaltarcon_remesa_transitoComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_remesa_transitoComisionConfig() {
		return this.mostrarcon_remesa_transitoComisionConfig;
	}

	public void setMostrarcon_remesa_transitoComisionConfig(Boolean mostrarcon_remesa_transitoComisionConfig) {
		this.mostrarcon_remesa_transitoComisionConfig= mostrarcon_remesa_transitoComisionConfig;
	}

	public Boolean getActivarcon_remesa_transitoComisionConfig() {
		return this.activarcon_remesa_transitoComisionConfig;
	}

	public void setActivarcon_remesa_transitoComisionConfig(Boolean activarcon_remesa_transitoComisionConfig) {
		this.activarcon_remesa_transitoComisionConfig= activarcon_remesa_transitoComisionConfig;
	}

	public Border setResaltarcon_penalidadComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_penalidadComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_penalidadComisionConfig() {
		return this.resaltarcon_penalidadComisionConfig;
	}

	public void setResaltarcon_penalidadComisionConfig(Border borderResaltar) {
		this.resaltarcon_penalidadComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_penalidadComisionConfig() {
		return this.mostrarcon_penalidadComisionConfig;
	}

	public void setMostrarcon_penalidadComisionConfig(Boolean mostrarcon_penalidadComisionConfig) {
		this.mostrarcon_penalidadComisionConfig= mostrarcon_penalidadComisionConfig;
	}

	public Boolean getActivarcon_penalidadComisionConfig() {
		return this.activarcon_penalidadComisionConfig;
	}

	public void setActivarcon_penalidadComisionConfig(Boolean activarcon_penalidadComisionConfig) {
		this.activarcon_penalidadComisionConfig= activarcon_penalidadComisionConfig;
	}

	public Border setResaltarcon_abonoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcon_abonoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_abonoComisionConfig() {
		return this.resaltarcon_abonoComisionConfig;
	}

	public void setResaltarcon_abonoComisionConfig(Border borderResaltar) {
		this.resaltarcon_abonoComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcon_abonoComisionConfig() {
		return this.mostrarcon_abonoComisionConfig;
	}

	public void setMostrarcon_abonoComisionConfig(Boolean mostrarcon_abonoComisionConfig) {
		this.mostrarcon_abonoComisionConfig= mostrarcon_abonoComisionConfig;
	}

	public Boolean getActivarcon_abonoComisionConfig() {
		return this.activarcon_abonoComisionConfig;
	}

	public void setActivarcon_abonoComisionConfig(Boolean activarcon_abonoComisionConfig) {
		this.activarcon_abonoComisionConfig= activarcon_abonoComisionConfig;
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
		
		
		this.setMostraridComisionConfig(esInicial);
		this.setMostrarid_empresaComisionConfig(esInicial);
		this.setMostrarid_tipo_comision_configComisionConfig(esInicial);
		this.setMostrarid_nivel_lineaComisionConfig(esInicial);
		this.setMostrarcon_vendedorComisionConfig(esInicial);
		this.setMostrarcon_ventasComisionConfig(esInicial);
		this.setMostrarcon_cobrosComisionConfig(esInicial);
		this.setMostrarcon_remesa_transitoComisionConfig(esInicial);
		this.setMostrarcon_penalidadComisionConfig(esInicial);
		this.setMostrarcon_abonoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionConfigConstantesFunciones.ID)) {
				this.setMostraridComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG)) {
				this.setMostrarid_tipo_comision_configComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDNIVELLINEA)) {
				this.setMostrarid_nivel_lineaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENDEDOR)) {
				this.setMostrarcon_vendedorComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENTAS)) {
				this.setMostrarcon_ventasComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONCOBROS)) {
				this.setMostrarcon_cobrosComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONREMESATRANSITO)) {
				this.setMostrarcon_remesa_transitoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONPENALIDAD)) {
				this.setMostrarcon_penalidadComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONABONO)) {
				this.setMostrarcon_abonoComisionConfig(esAsigna);
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
		
		
		this.setActivaridComisionConfig(esInicial);
		this.setActivarid_empresaComisionConfig(esInicial);
		this.setActivarid_tipo_comision_configComisionConfig(esInicial);
		this.setActivarid_nivel_lineaComisionConfig(esInicial);
		this.setActivarcon_vendedorComisionConfig(esInicial);
		this.setActivarcon_ventasComisionConfig(esInicial);
		this.setActivarcon_cobrosComisionConfig(esInicial);
		this.setActivarcon_remesa_transitoComisionConfig(esInicial);
		this.setActivarcon_penalidadComisionConfig(esInicial);
		this.setActivarcon_abonoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionConfigConstantesFunciones.ID)) {
				this.setActivaridComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG)) {
				this.setActivarid_tipo_comision_configComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDNIVELLINEA)) {
				this.setActivarid_nivel_lineaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENDEDOR)) {
				this.setActivarcon_vendedorComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENTAS)) {
				this.setActivarcon_ventasComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONCOBROS)) {
				this.setActivarcon_cobrosComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONREMESATRANSITO)) {
				this.setActivarcon_remesa_transitoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONPENALIDAD)) {
				this.setActivarcon_penalidadComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONABONO)) {
				this.setActivarcon_abonoComisionConfig(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionConfig(esInicial);
		this.setResaltarid_empresaComisionConfig(esInicial);
		this.setResaltarid_tipo_comision_configComisionConfig(esInicial);
		this.setResaltarid_nivel_lineaComisionConfig(esInicial);
		this.setResaltarcon_vendedorComisionConfig(esInicial);
		this.setResaltarcon_ventasComisionConfig(esInicial);
		this.setResaltarcon_cobrosComisionConfig(esInicial);
		this.setResaltarcon_remesa_transitoComisionConfig(esInicial);
		this.setResaltarcon_penalidadComisionConfig(esInicial);
		this.setResaltarcon_abonoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionConfigConstantesFunciones.ID)) {
				this.setResaltaridComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG)) {
				this.setResaltarid_tipo_comision_configComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.IDNIVELLINEA)) {
				this.setResaltarid_nivel_lineaComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENDEDOR)) {
				this.setResaltarcon_vendedorComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONVENTAS)) {
				this.setResaltarcon_ventasComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONCOBROS)) {
				this.setResaltarcon_cobrosComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONREMESATRANSITO)) {
				this.setResaltarcon_remesa_transitoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONPENALIDAD)) {
				this.setResaltarcon_penalidadComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionConfigConstantesFunciones.CONABONO)) {
				this.setResaltarcon_abonoComisionConfig(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarComisionCateComisionConfig=null;

	public Border getResaltarComisionCateComisionConfig() {
		return this.resaltarComisionCateComisionConfig;
	}

	public void setResaltarComisionCateComisionConfig(Border borderResaltarComisionCate) {
		if(borderResaltarComisionCate!=null) {
			this.resaltarComisionCateComisionConfig= borderResaltarComisionCate;
		}
	}

	public Border setResaltarComisionCateComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionCate=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltarComisionCate);
			
		this.resaltarComisionCateComisionConfig= borderResaltarComisionCate;

		 return borderResaltarComisionCate;
	}



	public Boolean mostrarComisionCateComisionConfig=true;

	public Boolean getMostrarComisionCateComisionConfig() {
		return this.mostrarComisionCateComisionConfig;
	}

	public void setMostrarComisionCateComisionConfig(Boolean visibilidadResaltarComisionCate) {
		this.mostrarComisionCateComisionConfig= visibilidadResaltarComisionCate;
	}



	public Boolean activarComisionCateComisionConfig=true;

	public Boolean gethabilitarResaltarComisionCateComisionConfig() {
		return this.activarComisionCateComisionConfig;
	}

	public void setActivarComisionCateComisionConfig(Boolean habilitarResaltarComisionCate) {
		this.activarComisionCateComisionConfig= habilitarResaltarComisionCate;
	}


	public Border resaltarComisionMarcaComisionConfig=null;

	public Border getResaltarComisionMarcaComisionConfig() {
		return this.resaltarComisionMarcaComisionConfig;
	}

	public void setResaltarComisionMarcaComisionConfig(Border borderResaltarComisionMarca) {
		if(borderResaltarComisionMarca!=null) {
			this.resaltarComisionMarcaComisionConfig= borderResaltarComisionMarca;
		}
	}

	public Border setResaltarComisionMarcaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionMarca=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltarComisionMarca);
			
		this.resaltarComisionMarcaComisionConfig= borderResaltarComisionMarca;

		 return borderResaltarComisionMarca;
	}



	public Boolean mostrarComisionMarcaComisionConfig=true;

	public Boolean getMostrarComisionMarcaComisionConfig() {
		return this.mostrarComisionMarcaComisionConfig;
	}

	public void setMostrarComisionMarcaComisionConfig(Boolean visibilidadResaltarComisionMarca) {
		this.mostrarComisionMarcaComisionConfig= visibilidadResaltarComisionMarca;
	}



	public Boolean activarComisionMarcaComisionConfig=true;

	public Boolean gethabilitarResaltarComisionMarcaComisionConfig() {
		return this.activarComisionMarcaComisionConfig;
	}

	public void setActivarComisionMarcaComisionConfig(Boolean habilitarResaltarComisionMarca) {
		this.activarComisionMarcaComisionConfig= habilitarResaltarComisionMarca;
	}


	public Border resaltarComisionLineaComisionConfig=null;

	public Border getResaltarComisionLineaComisionConfig() {
		return this.resaltarComisionLineaComisionConfig;
	}

	public void setResaltarComisionLineaComisionConfig(Border borderResaltarComisionLinea) {
		if(borderResaltarComisionLinea!=null) {
			this.resaltarComisionLineaComisionConfig= borderResaltarComisionLinea;
		}
	}

	public Border setResaltarComisionLineaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltarComisionLinea);
			
		this.resaltarComisionLineaComisionConfig= borderResaltarComisionLinea;

		 return borderResaltarComisionLinea;
	}



	public Boolean mostrarComisionLineaComisionConfig=true;

	public Boolean getMostrarComisionLineaComisionConfig() {
		return this.mostrarComisionLineaComisionConfig;
	}

	public void setMostrarComisionLineaComisionConfig(Boolean visibilidadResaltarComisionLinea) {
		this.mostrarComisionLineaComisionConfig= visibilidadResaltarComisionLinea;
	}



	public Boolean activarComisionLineaComisionConfig=true;

	public Boolean gethabilitarResaltarComisionLineaComisionConfig() {
		return this.activarComisionLineaComisionConfig;
	}

	public void setActivarComisionLineaComisionConfig(Boolean habilitarResaltarComisionLinea) {
		this.activarComisionLineaComisionConfig= habilitarResaltarComisionLinea;
	}


	public Border resaltarComisionPenaComisionConfig=null;

	public Border getResaltarComisionPenaComisionConfig() {
		return this.resaltarComisionPenaComisionConfig;
	}

	public void setResaltarComisionPenaComisionConfig(Border borderResaltarComisionPena) {
		if(borderResaltarComisionPena!=null) {
			this.resaltarComisionPenaComisionConfig= borderResaltarComisionPena;
		}
	}

	public Border setResaltarComisionPenaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionPena=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltarComisionPena);
			
		this.resaltarComisionPenaComisionConfig= borderResaltarComisionPena;

		 return borderResaltarComisionPena;
	}



	public Boolean mostrarComisionPenaComisionConfig=true;

	public Boolean getMostrarComisionPenaComisionConfig() {
		return this.mostrarComisionPenaComisionConfig;
	}

	public void setMostrarComisionPenaComisionConfig(Boolean visibilidadResaltarComisionPena) {
		this.mostrarComisionPenaComisionConfig= visibilidadResaltarComisionPena;
	}



	public Boolean activarComisionPenaComisionConfig=true;

	public Boolean gethabilitarResaltarComisionPenaComisionConfig() {
		return this.activarComisionPenaComisionConfig;
	}

	public void setActivarComisionPenaComisionConfig(Boolean habilitarResaltarComisionPena) {
		this.activarComisionPenaComisionConfig= habilitarResaltarComisionPena;
	}


	public Border resaltarComisionGrupoComisionConfig=null;

	public Border getResaltarComisionGrupoComisionConfig() {
		return this.resaltarComisionGrupoComisionConfig;
	}

	public void setResaltarComisionGrupoComisionConfig(Border borderResaltarComisionGrupo) {
		if(borderResaltarComisionGrupo!=null) {
			this.resaltarComisionGrupoComisionConfig= borderResaltarComisionGrupo;
		}
	}

	public Border setResaltarComisionGrupoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionGrupo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//comisionconfigBeanSwingJInternalFrame.jTtoolBarComisionConfig.setBorder(borderResaltarComisionGrupo);
			
		this.resaltarComisionGrupoComisionConfig= borderResaltarComisionGrupo;

		 return borderResaltarComisionGrupo;
	}



	public Boolean mostrarComisionGrupoComisionConfig=true;

	public Boolean getMostrarComisionGrupoComisionConfig() {
		return this.mostrarComisionGrupoComisionConfig;
	}

	public void setMostrarComisionGrupoComisionConfig(Boolean visibilidadResaltarComisionGrupo) {
		this.mostrarComisionGrupoComisionConfig= visibilidadResaltarComisionGrupo;
	}



	public Boolean activarComisionGrupoComisionConfig=true;

	public Boolean gethabilitarResaltarComisionGrupoComisionConfig() {
		return this.activarComisionGrupoComisionConfig;
	}

	public void setActivarComisionGrupoComisionConfig(Boolean habilitarResaltarComisionGrupo) {
		this.activarComisionGrupoComisionConfig= habilitarResaltarComisionGrupo;
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

		this.setMostrarComisionCateComisionConfig(esInicial);
		this.setMostrarComisionMarcaComisionConfig(esInicial);
		this.setMostrarComisionLineaComisionConfig(esInicial);
		this.setMostrarComisionPenaComisionConfig(esInicial);
		this.setMostrarComisionGrupoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionCate.class)) {
				this.setMostrarComisionCateComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setMostrarComisionMarcaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setMostrarComisionLineaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionPena.class)) {
				this.setMostrarComisionPenaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setMostrarComisionGrupoComisionConfig(esAsigna);
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

		this.setActivarComisionCateComisionConfig(esInicial);
		this.setActivarComisionMarcaComisionConfig(esInicial);
		this.setActivarComisionLineaComisionConfig(esInicial);
		this.setActivarComisionPenaComisionConfig(esInicial);
		this.setActivarComisionGrupoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionCate.class)) {
				this.setActivarComisionCateComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setActivarComisionMarcaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setActivarComisionLineaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionPena.class)) {
				this.setActivarComisionPenaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setActivarComisionGrupoComisionConfig(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarComisionCateComisionConfig(esInicial);
		this.setResaltarComisionMarcaComisionConfig(esInicial);
		this.setResaltarComisionLineaComisionConfig(esInicial);
		this.setResaltarComisionPenaComisionConfig(esInicial);
		this.setResaltarComisionGrupoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionCate.class)) {
				this.setResaltarComisionCateComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setResaltarComisionMarcaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setResaltarComisionLineaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionPena.class)) {
				this.setResaltarComisionPenaComisionConfig(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setResaltarComisionGrupoComisionConfig(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaComisionConfig=true;

	public Boolean getMostrarFK_IdEmpresaComisionConfig() {
		return this.mostrarFK_IdEmpresaComisionConfig;
	}

	public void setMostrarFK_IdEmpresaComisionConfig(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionConfig= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNivelLineaComisionConfig=true;

	public Boolean getMostrarFK_IdNivelLineaComisionConfig() {
		return this.mostrarFK_IdNivelLineaComisionConfig;
	}

	public void setMostrarFK_IdNivelLineaComisionConfig(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNivelLineaComisionConfig= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComisionConfigComisionConfig=true;

	public Boolean getMostrarFK_IdTipoComisionConfigComisionConfig() {
		return this.mostrarFK_IdTipoComisionConfigComisionConfig;
	}

	public void setMostrarFK_IdTipoComisionConfigComisionConfig(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComisionConfigComisionConfig= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaComisionConfig=true;

	public Boolean getActivarFK_IdEmpresaComisionConfig() {
		return this.activarFK_IdEmpresaComisionConfig;
	}

	public void setActivarFK_IdEmpresaComisionConfig(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionConfig= habilitarResaltar;
	}

	public Boolean activarFK_IdNivelLineaComisionConfig=true;

	public Boolean getActivarFK_IdNivelLineaComisionConfig() {
		return this.activarFK_IdNivelLineaComisionConfig;
	}

	public void setActivarFK_IdNivelLineaComisionConfig(Boolean habilitarResaltar) {
		this.activarFK_IdNivelLineaComisionConfig= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComisionConfigComisionConfig=true;

	public Boolean getActivarFK_IdTipoComisionConfigComisionConfig() {
		return this.activarFK_IdTipoComisionConfigComisionConfig;
	}

	public void setActivarFK_IdTipoComisionConfigComisionConfig(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComisionConfigComisionConfig= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaComisionConfig=null;

	public Border getResaltarFK_IdEmpresaComisionConfig() {
		return this.resaltarFK_IdEmpresaComisionConfig;
	}

	public void setResaltarFK_IdEmpresaComisionConfig(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionConfig= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionConfig= borderResaltar;
	}

	public Border resaltarFK_IdNivelLineaComisionConfig=null;

	public Border getResaltarFK_IdNivelLineaComisionConfig() {
		return this.resaltarFK_IdNivelLineaComisionConfig;
	}

	public void setResaltarFK_IdNivelLineaComisionConfig(Border borderResaltar) {
		this.resaltarFK_IdNivelLineaComisionConfig= borderResaltar;
	}

	public void setResaltarFK_IdNivelLineaComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNivelLineaComisionConfig= borderResaltar;
	}

	public Border resaltarFK_IdTipoComisionConfigComisionConfig=null;

	public Border getResaltarFK_IdTipoComisionConfigComisionConfig() {
		return this.resaltarFK_IdTipoComisionConfigComisionConfig;
	}

	public void setResaltarFK_IdTipoComisionConfigComisionConfig(Border borderResaltar) {
		this.resaltarFK_IdTipoComisionConfigComisionConfig= borderResaltar;
	}

	public void setResaltarFK_IdTipoComisionConfigComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionConfigBeanSwingJInternalFrame comisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComisionConfigComisionConfig= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}