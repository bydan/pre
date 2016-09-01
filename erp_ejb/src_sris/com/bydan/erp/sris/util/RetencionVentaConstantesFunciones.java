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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.RetencionVentaConstantesFunciones;
import com.bydan.erp.sris.util.RetencionVentaParameterReturnGeneral;
//import com.bydan.erp.sris.util.RetencionVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RetencionVentaConstantesFunciones extends RetencionVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RetencionVenta";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RetencionVenta"+RetencionVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RetencionVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RetencionVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RetencionVentaConstantesFunciones.SCHEMA+"_"+RetencionVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RetencionVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RetencionVentaConstantesFunciones.SCHEMA+"_"+RetencionVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RetencionVentaConstantesFunciones.SCHEMA+"_"+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RetencionVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RetencionVentaConstantesFunciones.SCHEMA+"_"+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RetencionVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RetencionVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RetencionVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RetencionVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retencion Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Retencion Venta";
	public static final String SCLASSWEBTITULO_LOWER="Retencion Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RetencionVenta";
	public static final String OBJECTNAME="retencionventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="retencion_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select retencionventa from "+RetencionVentaConstantesFunciones.SPERSISTENCENAME+" retencionventa";
	public static String QUERYSELECTNATIVE="select "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".version_row,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_empresa,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_periodo_declara,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_tipo_retencion,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".ruc,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".numero_retencion,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".base_imponible,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".porcentaje,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".valor,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".es_debito from "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME;//+" as "+RetencionVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RetencionVentaConstantesFuncionesAdditional retencionventaConstantesFuncionesAdditional=null;
	
	public RetencionVentaConstantesFuncionesAdditional getRetencionVentaConstantesFuncionesAdditional() {
		return this.retencionventaConstantesFuncionesAdditional;
	}
	
	public void setRetencionVentaConstantesFuncionesAdditional(RetencionVentaConstantesFuncionesAdditional retencionventaConstantesFuncionesAdditional) {
		try {
			this.retencionventaConstantesFuncionesAdditional=retencionventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String RUC= "ruc";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String ESDEBITO= "es_debito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NUMERORETENCION= "Nro Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ESDEBITO= "Es Debito";
		public static final String LABEL_ESDEBITO_LOWER= "Es Debito";
	
		
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getRetencionVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.RUC)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.NUMERORETENCION)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.PORCENTAJE)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.VALOR)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RetencionVentaConstantesFunciones.ESDEBITO)) {sLabelColumna=RetencionVentaConstantesFunciones.LABEL_ESDEBITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_debitoDescripcion(RetencionVenta retencionventa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!retencionventa.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(RetencionVenta retencionventa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(retencionventa.getId(),retencionventa.getes_debito());

		return sDescripcion;
	}	
	
	public static String getRetencionVentaDescripcion(RetencionVenta retencionventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(retencionventa !=null/* && retencionventa.getId()!=0*/) {
			if(retencionventa.getId()!=null) {
				sDescripcion=retencionventa.getId().toString();
			}//retencionventaretencionventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRetencionVentaDescripcionDetallado(RetencionVenta retencionventa) {
		String sDescripcion="";
			
		sDescripcion+=RetencionVentaConstantesFunciones.ID+"=";
		sDescripcion+=retencionventa.getId().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=retencionventa.getVersionRow().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=retencionventa.getid_empresa().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=retencionventa.getid_periodo_declara().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=retencionventa.getid_tipo_retencion().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.RUC+"=";
		sDescripcion+=retencionventa.getruc()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=retencionventa.getnumero_retencion()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=retencionventa.getbase_imponible().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=retencionventa.getporcentaje().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.VALOR+"=";
		sDescripcion+=retencionventa.getvalor().toString()+",";
		sDescripcion+=RetencionVentaConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=retencionventa.getes_debito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRetencionVentaDescripcion(RetencionVenta retencionventa,String sValor) throws Exception {			
		if(retencionventa !=null) {
			//retencionventaretencionventa.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
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
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
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

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRetencionVenta(RetencionVenta retencionventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencionventa.setruc(retencionventa.getruc().trim());
		retencionventa.setnumero_retencion(retencionventa.getnumero_retencion().trim());
	}
	
	public static void quitarEspaciosRetencionVentas(List<RetencionVenta> retencionventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionVenta retencionventa: retencionventas) {
			retencionventa.setruc(retencionventa.getruc().trim());
			retencionventa.setnumero_retencion(retencionventa.getnumero_retencion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionVenta(RetencionVenta retencionventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && retencionventa.getConCambioAuxiliar()) {
			retencionventa.setIsDeleted(retencionventa.getIsDeletedAuxiliar());	
			retencionventa.setIsNew(retencionventa.getIsNewAuxiliar());	
			retencionventa.setIsChanged(retencionventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			retencionventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			retencionventa.setIsDeletedAuxiliar(false);	
			retencionventa.setIsNewAuxiliar(false);	
			retencionventa.setIsChangedAuxiliar(false);
			
			retencionventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionVentas(List<RetencionVenta> retencionventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RetencionVenta retencionventa : retencionventas) {
			if(conAsignarBase && retencionventa.getConCambioAuxiliar()) {
				retencionventa.setIsDeleted(retencionventa.getIsDeletedAuxiliar());	
				retencionventa.setIsNew(retencionventa.getIsNewAuxiliar());	
				retencionventa.setIsChanged(retencionventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				retencionventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				retencionventa.setIsDeletedAuxiliar(false);	
				retencionventa.setIsNewAuxiliar(false);	
				retencionventa.setIsChangedAuxiliar(false);
				
				retencionventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRetencionVenta(RetencionVenta retencionventa,Boolean conEnteros) throws Exception  {
		retencionventa.setbase_imponible(0.0);
		retencionventa.setporcentaje(0.0);
		retencionventa.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRetencionVentas(List<RetencionVenta> retencionventas,Boolean conEnteros) throws Exception  {
		
		for(RetencionVenta retencionventa: retencionventas) {
			retencionventa.setbase_imponible(0.0);
			retencionventa.setporcentaje(0.0);
			retencionventa.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRetencionVenta(List<RetencionVenta> retencionventas,RetencionVenta retencionventaAux) throws Exception  {
		RetencionVentaConstantesFunciones.InicializarValoresRetencionVenta(retencionventaAux,true);
		
		for(RetencionVenta retencionventa: retencionventas) {
			if(retencionventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			retencionventaAux.setbase_imponible(retencionventaAux.getbase_imponible()+retencionventa.getbase_imponible());			
			retencionventaAux.setporcentaje(retencionventaAux.getporcentaje()+retencionventa.getporcentaje());			
			retencionventaAux.setvalor(retencionventaAux.getvalor()+retencionventa.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RetencionVentaConstantesFunciones.getArrayColumnasGlobalesRetencionVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionVentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRetencionVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionVenta> retencionventas,RetencionVenta retencionventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionVenta retencionventaAux: retencionventas) {
			if(retencionventaAux!=null && retencionventa!=null) {
				if((retencionventaAux.getId()==null && retencionventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(retencionventaAux.getId()!=null && retencionventa.getId()!=null){
					if(retencionventaAux.getId().equals(retencionventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionVenta(List<RetencionVenta> retencionventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double base_imponibleTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(RetencionVenta retencionventa: retencionventas) {			
			if(retencionventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			base_imponibleTotal+=retencionventa.getbase_imponible();
			porcentajeTotal+=retencionventa.getporcentaje();
			valorTotal+=retencionventa.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionVentaConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionVentaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionVentaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRetencionVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_ID, RetencionVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_VERSIONROW, RetencionVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_IDEMPRESA, RetencionVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_IDPERIODODECLARA, RetencionVentaConstantesFunciones.IDPERIODODECLARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_IDTIPORETENCION, RetencionVentaConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_RUC, RetencionVentaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_NUMERORETENCION, RetencionVentaConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE, RetencionVentaConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_PORCENTAJE, RetencionVentaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_VALOR, RetencionVentaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionVentaConstantesFunciones.LABEL_ESDEBITO, RetencionVentaConstantesFunciones.ESDEBITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRetencionVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.IDPERIODODECLARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionVentaConstantesFunciones.ESDEBITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionVenta() throws Exception  {
		return RetencionVentaConstantesFunciones.getTiposSeleccionarRetencionVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionVenta(Boolean conFk) throws Exception  {
		return RetencionVentaConstantesFunciones.getTiposSeleccionarRetencionVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionVentaConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(RetencionVentaConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRetencionVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionVenta(RetencionVenta retencionventaAux) throws Exception {
		
			retencionventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionventaAux.getEmpresa()));
			retencionventaAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(retencionventaAux.getPeriodoDeclara()));
			retencionventaAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionventaAux.getTipoRetencion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionVenta(List<RetencionVenta> retencionventasTemp) throws Exception {
		for(RetencionVenta retencionventaAux:retencionventasTemp) {
			
			retencionventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionventaAux.getEmpresa()));
			retencionventaAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(retencionventaAux.getPeriodoDeclara()));
			retencionventaAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionventaAux.getTipoRetencion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(TipoRetencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRetencionVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionVentaConstantesFunciones.getClassesRelationshipsOfRetencionVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionVentaConstantesFunciones.getClassesRelationshipsFromStringsOfRetencionVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RetencionVenta retencionventa,List<RetencionVenta> retencionventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RetencionVenta retencionventaEncontrado=null;
			
			for(RetencionVenta retencionventaLocal:retencionventas) {
				if(retencionventaLocal.getId().equals(retencionventa.getId())) {
					retencionventaEncontrado=retencionventaLocal;
					
					retencionventaLocal.setIsChanged(retencionventa.getIsChanged());
					retencionventaLocal.setIsNew(retencionventa.getIsNew());
					retencionventaLocal.setIsDeleted(retencionventa.getIsDeleted());
					
					retencionventaLocal.setGeneralEntityOriginal(retencionventa.getGeneralEntityOriginal());
					
					retencionventaLocal.setId(retencionventa.getId());	
					retencionventaLocal.setVersionRow(retencionventa.getVersionRow());	
					retencionventaLocal.setid_empresa(retencionventa.getid_empresa());	
					retencionventaLocal.setid_periodo_declara(retencionventa.getid_periodo_declara());	
					retencionventaLocal.setid_tipo_retencion(retencionventa.getid_tipo_retencion());	
					retencionventaLocal.setruc(retencionventa.getruc());	
					retencionventaLocal.setnumero_retencion(retencionventa.getnumero_retencion());	
					retencionventaLocal.setbase_imponible(retencionventa.getbase_imponible());	
					retencionventaLocal.setporcentaje(retencionventa.getporcentaje());	
					retencionventaLocal.setvalor(retencionventa.getvalor());	
					retencionventaLocal.setes_debito(retencionventa.getes_debito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!retencionventa.getIsDeleted()) {
				if(!existe) {
					retencionventas.add(retencionventa);
				}
			} else {
				if(retencionventaEncontrado!=null && permiteQuitar)  {
					retencionventas.remove(retencionventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RetencionVenta retencionventa,List<RetencionVenta> retencionventas) throws Exception {
		try	{			
			for(RetencionVenta retencionventaLocal:retencionventas) {
				if(retencionventaLocal.getId().equals(retencionventa.getId())) {
					retencionventaLocal.setIsSelected(retencionventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRetencionVenta(List<RetencionVenta> retencionventasAux) throws Exception {
		//this.retencionventasAux=retencionventasAux;
		
		for(RetencionVenta retencionventaAux:retencionventasAux) {
			if(retencionventaAux.getIsChanged()) {
				retencionventaAux.setIsChanged(false);
			}		
			
			if(retencionventaAux.getIsNew()) {
				retencionventaAux.setIsNew(false);
			}	
			
			if(retencionventaAux.getIsDeleted()) {
				retencionventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRetencionVenta(RetencionVenta retencionventaAux) throws Exception {
		//this.retencionventaAux=retencionventaAux;
		
			if(retencionventaAux.getIsChanged()) {
				retencionventaAux.setIsChanged(false);
			}		
			
			if(retencionventaAux.getIsNew()) {
				retencionventaAux.setIsNew(false);
			}	
			
			if(retencionventaAux.getIsDeleted()) {
				retencionventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RetencionVenta retencionventaAsignar,RetencionVenta retencionventa) throws Exception {
		retencionventaAsignar.setId(retencionventa.getId());	
		retencionventaAsignar.setVersionRow(retencionventa.getVersionRow());	
		retencionventaAsignar.setid_empresa(retencionventa.getid_empresa());
		retencionventaAsignar.setempresa_descripcion(retencionventa.getempresa_descripcion());	
		retencionventaAsignar.setid_periodo_declara(retencionventa.getid_periodo_declara());
		retencionventaAsignar.setperiododeclara_descripcion(retencionventa.getperiododeclara_descripcion());	
		retencionventaAsignar.setid_tipo_retencion(retencionventa.getid_tipo_retencion());
		retencionventaAsignar.settiporetencion_descripcion(retencionventa.gettiporetencion_descripcion());	
		retencionventaAsignar.setruc(retencionventa.getruc());	
		retencionventaAsignar.setnumero_retencion(retencionventa.getnumero_retencion());	
		retencionventaAsignar.setbase_imponible(retencionventa.getbase_imponible());	
		retencionventaAsignar.setporcentaje(retencionventa.getporcentaje());	
		retencionventaAsignar.setvalor(retencionventa.getvalor());	
		retencionventaAsignar.setes_debito(retencionventa.getes_debito());	
	}
	
	public static void inicializarRetencionVenta(RetencionVenta retencionventa) throws Exception {
		try {
				retencionventa.setId(0L);	
					
				retencionventa.setid_empresa(-1L);	
				retencionventa.setid_periodo_declara(-1L);	
				retencionventa.setid_tipo_retencion(-1L);	
				retencionventa.setruc("");	
				retencionventa.setnumero_retencion("");	
				retencionventa.setbase_imponible(0.0);	
				retencionventa.setporcentaje(0.0);	
				retencionventa.setvalor(0.0);	
				retencionventa.setes_debito(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRetencionVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionVentaConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRetencionVenta(String sTipo,Row row,Workbook workbook,RetencionVenta retencionventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionventa.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(retencionventa.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRetencionVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRetencionVenta() {
		return this.sFinalQueryRetencionVenta;
	}
	
	public void setsFinalQueryRetencionVenta(String sFinalQueryRetencionVenta) {
		this.sFinalQueryRetencionVenta= sFinalQueryRetencionVenta;
	}
	
	public Border resaltarSeleccionarRetencionVenta=null;
	
	public Border setResaltarSeleccionarRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRetencionVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRetencionVenta() {
		return this.resaltarSeleccionarRetencionVenta;
	}
	
	public void setResaltarSeleccionarRetencionVenta(Border borderResaltarSeleccionarRetencionVenta) {
		this.resaltarSeleccionarRetencionVenta= borderResaltarSeleccionarRetencionVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRetencionVenta=null;
	public Boolean mostraridRetencionVenta=true;
	public Boolean activaridRetencionVenta=true;

	public Border resaltarid_empresaRetencionVenta=null;
	public Boolean mostrarid_empresaRetencionVenta=true;
	public Boolean activarid_empresaRetencionVenta=true;
	public Boolean cargarid_empresaRetencionVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRetencionVenta=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraRetencionVenta=null;
	public Boolean mostrarid_periodo_declaraRetencionVenta=true;
	public Boolean activarid_periodo_declaraRetencionVenta=true;
	public Boolean cargarid_periodo_declaraRetencionVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraRetencionVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionRetencionVenta=null;
	public Boolean mostrarid_tipo_retencionRetencionVenta=true;
	public Boolean activarid_tipo_retencionRetencionVenta=true;
	public Boolean cargarid_tipo_retencionRetencionVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionRetencionVenta=false;//ConEventDepend=true

	public Border resaltarrucRetencionVenta=null;
	public Boolean mostrarrucRetencionVenta=true;
	public Boolean activarrucRetencionVenta=true;

	public Border resaltarnumero_retencionRetencionVenta=null;
	public Boolean mostrarnumero_retencionRetencionVenta=true;
	public Boolean activarnumero_retencionRetencionVenta=true;

	public Border resaltarbase_imponibleRetencionVenta=null;
	public Boolean mostrarbase_imponibleRetencionVenta=true;
	public Boolean activarbase_imponibleRetencionVenta=true;

	public Border resaltarporcentajeRetencionVenta=null;
	public Boolean mostrarporcentajeRetencionVenta=true;
	public Boolean activarporcentajeRetencionVenta=true;

	public Border resaltarvalorRetencionVenta=null;
	public Boolean mostrarvalorRetencionVenta=true;
	public Boolean activarvalorRetencionVenta=true;

	public Border resaltares_debitoRetencionVenta=null;
	public Boolean mostrares_debitoRetencionVenta=true;
	public Boolean activares_debitoRetencionVenta=true;

	
	

	public Border setResaltaridRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltaridRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRetencionVenta() {
		return this.resaltaridRetencionVenta;
	}

	public void setResaltaridRetencionVenta(Border borderResaltar) {
		this.resaltaridRetencionVenta= borderResaltar;
	}

	public Boolean getMostraridRetencionVenta() {
		return this.mostraridRetencionVenta;
	}

	public void setMostraridRetencionVenta(Boolean mostraridRetencionVenta) {
		this.mostraridRetencionVenta= mostraridRetencionVenta;
	}

	public Boolean getActivaridRetencionVenta() {
		return this.activaridRetencionVenta;
	}

	public void setActivaridRetencionVenta(Boolean activaridRetencionVenta) {
		this.activaridRetencionVenta= activaridRetencionVenta;
	}

	public Border setResaltarid_empresaRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRetencionVenta() {
		return this.resaltarid_empresaRetencionVenta;
	}

	public void setResaltarid_empresaRetencionVenta(Border borderResaltar) {
		this.resaltarid_empresaRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaRetencionVenta() {
		return this.mostrarid_empresaRetencionVenta;
	}

	public void setMostrarid_empresaRetencionVenta(Boolean mostrarid_empresaRetencionVenta) {
		this.mostrarid_empresaRetencionVenta= mostrarid_empresaRetencionVenta;
	}

	public Boolean getActivarid_empresaRetencionVenta() {
		return this.activarid_empresaRetencionVenta;
	}

	public void setActivarid_empresaRetencionVenta(Boolean activarid_empresaRetencionVenta) {
		this.activarid_empresaRetencionVenta= activarid_empresaRetencionVenta;
	}

	public Boolean getCargarid_empresaRetencionVenta() {
		return this.cargarid_empresaRetencionVenta;
	}

	public void setCargarid_empresaRetencionVenta(Boolean cargarid_empresaRetencionVenta) {
		this.cargarid_empresaRetencionVenta= cargarid_empresaRetencionVenta;
	}

	public Border setResaltarid_periodo_declaraRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraRetencionVenta() {
		return this.resaltarid_periodo_declaraRetencionVenta;
	}

	public void setResaltarid_periodo_declaraRetencionVenta(Border borderResaltar) {
		this.resaltarid_periodo_declaraRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraRetencionVenta() {
		return this.mostrarid_periodo_declaraRetencionVenta;
	}

	public void setMostrarid_periodo_declaraRetencionVenta(Boolean mostrarid_periodo_declaraRetencionVenta) {
		this.mostrarid_periodo_declaraRetencionVenta= mostrarid_periodo_declaraRetencionVenta;
	}

	public Boolean getActivarid_periodo_declaraRetencionVenta() {
		return this.activarid_periodo_declaraRetencionVenta;
	}

	public void setActivarid_periodo_declaraRetencionVenta(Boolean activarid_periodo_declaraRetencionVenta) {
		this.activarid_periodo_declaraRetencionVenta= activarid_periodo_declaraRetencionVenta;
	}

	public Boolean getCargarid_periodo_declaraRetencionVenta() {
		return this.cargarid_periodo_declaraRetencionVenta;
	}

	public void setCargarid_periodo_declaraRetencionVenta(Boolean cargarid_periodo_declaraRetencionVenta) {
		this.cargarid_periodo_declaraRetencionVenta= cargarid_periodo_declaraRetencionVenta;
	}

	public Border setResaltarid_tipo_retencionRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionRetencionVenta() {
		return this.resaltarid_tipo_retencionRetencionVenta;
	}

	public void setResaltarid_tipo_retencionRetencionVenta(Border borderResaltar) {
		this.resaltarid_tipo_retencionRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionRetencionVenta() {
		return this.mostrarid_tipo_retencionRetencionVenta;
	}

	public void setMostrarid_tipo_retencionRetencionVenta(Boolean mostrarid_tipo_retencionRetencionVenta) {
		this.mostrarid_tipo_retencionRetencionVenta= mostrarid_tipo_retencionRetencionVenta;
	}

	public Boolean getActivarid_tipo_retencionRetencionVenta() {
		return this.activarid_tipo_retencionRetencionVenta;
	}

	public void setActivarid_tipo_retencionRetencionVenta(Boolean activarid_tipo_retencionRetencionVenta) {
		this.activarid_tipo_retencionRetencionVenta= activarid_tipo_retencionRetencionVenta;
	}

	public Boolean getCargarid_tipo_retencionRetencionVenta() {
		return this.cargarid_tipo_retencionRetencionVenta;
	}

	public void setCargarid_tipo_retencionRetencionVenta(Boolean cargarid_tipo_retencionRetencionVenta) {
		this.cargarid_tipo_retencionRetencionVenta= cargarid_tipo_retencionRetencionVenta;
	}

	public Border setResaltarrucRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarrucRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucRetencionVenta() {
		return this.resaltarrucRetencionVenta;
	}

	public void setResaltarrucRetencionVenta(Border borderResaltar) {
		this.resaltarrucRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarrucRetencionVenta() {
		return this.mostrarrucRetencionVenta;
	}

	public void setMostrarrucRetencionVenta(Boolean mostrarrucRetencionVenta) {
		this.mostrarrucRetencionVenta= mostrarrucRetencionVenta;
	}

	public Boolean getActivarrucRetencionVenta() {
		return this.activarrucRetencionVenta;
	}

	public void setActivarrucRetencionVenta(Boolean activarrucRetencionVenta) {
		this.activarrucRetencionVenta= activarrucRetencionVenta;
	}

	public Border setResaltarnumero_retencionRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionRetencionVenta() {
		return this.resaltarnumero_retencionRetencionVenta;
	}

	public void setResaltarnumero_retencionRetencionVenta(Border borderResaltar) {
		this.resaltarnumero_retencionRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionRetencionVenta() {
		return this.mostrarnumero_retencionRetencionVenta;
	}

	public void setMostrarnumero_retencionRetencionVenta(Boolean mostrarnumero_retencionRetencionVenta) {
		this.mostrarnumero_retencionRetencionVenta= mostrarnumero_retencionRetencionVenta;
	}

	public Boolean getActivarnumero_retencionRetencionVenta() {
		return this.activarnumero_retencionRetencionVenta;
	}

	public void setActivarnumero_retencionRetencionVenta(Boolean activarnumero_retencionRetencionVenta) {
		this.activarnumero_retencionRetencionVenta= activarnumero_retencionRetencionVenta;
	}

	public Border setResaltarbase_imponibleRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleRetencionVenta() {
		return this.resaltarbase_imponibleRetencionVenta;
	}

	public void setResaltarbase_imponibleRetencionVenta(Border borderResaltar) {
		this.resaltarbase_imponibleRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleRetencionVenta() {
		return this.mostrarbase_imponibleRetencionVenta;
	}

	public void setMostrarbase_imponibleRetencionVenta(Boolean mostrarbase_imponibleRetencionVenta) {
		this.mostrarbase_imponibleRetencionVenta= mostrarbase_imponibleRetencionVenta;
	}

	public Boolean getActivarbase_imponibleRetencionVenta() {
		return this.activarbase_imponibleRetencionVenta;
	}

	public void setActivarbase_imponibleRetencionVenta(Boolean activarbase_imponibleRetencionVenta) {
		this.activarbase_imponibleRetencionVenta= activarbase_imponibleRetencionVenta;
	}

	public Border setResaltarporcentajeRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarporcentajeRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeRetencionVenta() {
		return this.resaltarporcentajeRetencionVenta;
	}

	public void setResaltarporcentajeRetencionVenta(Border borderResaltar) {
		this.resaltarporcentajeRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarporcentajeRetencionVenta() {
		return this.mostrarporcentajeRetencionVenta;
	}

	public void setMostrarporcentajeRetencionVenta(Boolean mostrarporcentajeRetencionVenta) {
		this.mostrarporcentajeRetencionVenta= mostrarporcentajeRetencionVenta;
	}

	public Boolean getActivarporcentajeRetencionVenta() {
		return this.activarporcentajeRetencionVenta;
	}

	public void setActivarporcentajeRetencionVenta(Boolean activarporcentajeRetencionVenta) {
		this.activarporcentajeRetencionVenta= activarporcentajeRetencionVenta;
	}

	public Border setResaltarvalorRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltarvalorRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRetencionVenta() {
		return this.resaltarvalorRetencionVenta;
	}

	public void setResaltarvalorRetencionVenta(Border borderResaltar) {
		this.resaltarvalorRetencionVenta= borderResaltar;
	}

	public Boolean getMostrarvalorRetencionVenta() {
		return this.mostrarvalorRetencionVenta;
	}

	public void setMostrarvalorRetencionVenta(Boolean mostrarvalorRetencionVenta) {
		this.mostrarvalorRetencionVenta= mostrarvalorRetencionVenta;
	}

	public Boolean getActivarvalorRetencionVenta() {
		return this.activarvalorRetencionVenta;
	}

	public void setActivarvalorRetencionVenta(Boolean activarvalorRetencionVenta) {
		this.activarvalorRetencionVenta= activarvalorRetencionVenta;
	}

	public Border setResaltares_debitoRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionventaBeanSwingJInternalFrame.jTtoolBarRetencionVenta.setBorder(borderResaltar);
		
		this.resaltares_debitoRetencionVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoRetencionVenta() {
		return this.resaltares_debitoRetencionVenta;
	}

	public void setResaltares_debitoRetencionVenta(Border borderResaltar) {
		this.resaltares_debitoRetencionVenta= borderResaltar;
	}

	public Boolean getMostrares_debitoRetencionVenta() {
		return this.mostrares_debitoRetencionVenta;
	}

	public void setMostrares_debitoRetencionVenta(Boolean mostrares_debitoRetencionVenta) {
		this.mostrares_debitoRetencionVenta= mostrares_debitoRetencionVenta;
	}

	public Boolean getActivares_debitoRetencionVenta() {
		return this.activares_debitoRetencionVenta;
	}

	public void setActivares_debitoRetencionVenta(Boolean activares_debitoRetencionVenta) {
		this.activares_debitoRetencionVenta= activares_debitoRetencionVenta;
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
		
		
		this.setMostraridRetencionVenta(esInicial);
		this.setMostrarid_empresaRetencionVenta(esInicial);
		this.setMostrarid_periodo_declaraRetencionVenta(esInicial);
		this.setMostrarid_tipo_retencionRetencionVenta(esInicial);
		this.setMostrarrucRetencionVenta(esInicial);
		this.setMostrarnumero_retencionRetencionVenta(esInicial);
		this.setMostrarbase_imponibleRetencionVenta(esInicial);
		this.setMostrarporcentajeRetencionVenta(esInicial);
		this.setMostrarvalorRetencionVenta(esInicial);
		this.setMostrares_debitoRetencionVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ID)) {
				this.setMostraridRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.RUC)) {
				this.setMostrarrucRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.VALOR)) {
				this.setMostrarvalorRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoRetencionVenta(esAsigna);
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
		
		
		this.setActivaridRetencionVenta(esInicial);
		this.setActivarid_empresaRetencionVenta(esInicial);
		this.setActivarid_periodo_declaraRetencionVenta(esInicial);
		this.setActivarid_tipo_retencionRetencionVenta(esInicial);
		this.setActivarrucRetencionVenta(esInicial);
		this.setActivarnumero_retencionRetencionVenta(esInicial);
		this.setActivarbase_imponibleRetencionVenta(esInicial);
		this.setActivarporcentajeRetencionVenta(esInicial);
		this.setActivarvalorRetencionVenta(esInicial);
		this.setActivares_debitoRetencionVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ID)) {
				this.setActivaridRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.RUC)) {
				this.setActivarrucRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.VALOR)) {
				this.setActivarvalorRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoRetencionVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRetencionVenta(esInicial);
		this.setResaltarid_empresaRetencionVenta(esInicial);
		this.setResaltarid_periodo_declaraRetencionVenta(esInicial);
		this.setResaltarid_tipo_retencionRetencionVenta(esInicial);
		this.setResaltarrucRetencionVenta(esInicial);
		this.setResaltarnumero_retencionRetencionVenta(esInicial);
		this.setResaltarbase_imponibleRetencionVenta(esInicial);
		this.setResaltarporcentajeRetencionVenta(esInicial);
		this.setResaltarvalorRetencionVenta(esInicial);
		this.setResaltares_debitoRetencionVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ID)) {
				this.setResaltaridRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.RUC)) {
				this.setResaltarrucRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.VALOR)) {
				this.setResaltarvalorRetencionVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionVentaConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoRetencionVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaRetencionVenta=true;

	public Boolean getMostrarFK_IdEmpresaRetencionVenta() {
		return this.mostrarFK_IdEmpresaRetencionVenta;
	}

	public void setMostrarFK_IdEmpresaRetencionVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRetencionVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDeclaraRetencionVenta=true;

	public Boolean getMostrarFK_IdPeriodoDeclaraRetencionVenta() {
		return this.mostrarFK_IdPeriodoDeclaraRetencionVenta;
	}

	public void setMostrarFK_IdPeriodoDeclaraRetencionVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDeclaraRetencionVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionRetencionVenta=true;

	public Boolean getMostrarFK_IdTipoRetencionRetencionVenta() {
		return this.mostrarFK_IdTipoRetencionRetencionVenta;
	}

	public void setMostrarFK_IdTipoRetencionRetencionVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionRetencionVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRetencionVenta=true;

	public Boolean getActivarFK_IdEmpresaRetencionVenta() {
		return this.activarFK_IdEmpresaRetencionVenta;
	}

	public void setActivarFK_IdEmpresaRetencionVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRetencionVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDeclaraRetencionVenta=true;

	public Boolean getActivarFK_IdPeriodoDeclaraRetencionVenta() {
		return this.activarFK_IdPeriodoDeclaraRetencionVenta;
	}

	public void setActivarFK_IdPeriodoDeclaraRetencionVenta(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDeclaraRetencionVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionRetencionVenta=true;

	public Boolean getActivarFK_IdTipoRetencionRetencionVenta() {
		return this.activarFK_IdTipoRetencionRetencionVenta;
	}

	public void setActivarFK_IdTipoRetencionRetencionVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionRetencionVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRetencionVenta=null;

	public Border getResaltarFK_IdEmpresaRetencionVenta() {
		return this.resaltarFK_IdEmpresaRetencionVenta;
	}

	public void setResaltarFK_IdEmpresaRetencionVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRetencionVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRetencionVenta= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDeclaraRetencionVenta=null;

	public Border getResaltarFK_IdPeriodoDeclaraRetencionVenta() {
		return this.resaltarFK_IdPeriodoDeclaraRetencionVenta;
	}

	public void setResaltarFK_IdPeriodoDeclaraRetencionVenta(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDeclaraRetencionVenta= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDeclaraRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDeclaraRetencionVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionRetencionVenta=null;

	public Border getResaltarFK_IdTipoRetencionRetencionVenta() {
		return this.resaltarFK_IdTipoRetencionRetencionVenta;
	}

	public void setResaltarFK_IdTipoRetencionRetencionVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionRetencionVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionRetencionVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionVentaBeanSwingJInternalFrame retencionventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionRetencionVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}