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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SubGrupoActivoFijoConstantesFunciones extends SubGrupoActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SubGrupoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SubGrupoActivoFijo"+SubGrupoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SubGrupoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SubGrupoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SubGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SubGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SubGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SubGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SubGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SubGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SubGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SubGrupoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SubGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SubGrupoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sub Grupo Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sub Grupo Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Sub Grupo Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SubGrupoActivoFijo";
	public static final String OBJECTNAME="subgrupoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="sub_grupo_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select subgrupoactivofijo from "+SubGrupoActivoFijoConstantesFunciones.SPERSISTENCENAME+" subgrupoactivofijo";
	public static String QUERYSELECTNATIVE="select "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".nombre,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".siglas,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".es_vehiculo from "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+SubGrupoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SubGrupoActivoFijoConstantesFuncionesAdditional subgrupoactivofijoConstantesFuncionesAdditional=null;
	
	public SubGrupoActivoFijoConstantesFuncionesAdditional getSubGrupoActivoFijoConstantesFuncionesAdditional() {
		return this.subgrupoactivofijoConstantesFuncionesAdditional;
	}
	
	public void setSubGrupoActivoFijoConstantesFuncionesAdditional(SubGrupoActivoFijoConstantesFuncionesAdditional subgrupoactivofijoConstantesFuncionesAdditional) {
		try {
			this.subgrupoactivofijoConstantesFuncionesAdditional=subgrupoactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDDETALLEGRUPOACTIVOFIJO= "id_detalle_grupo_activo_fijo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String ESVEHICULO= "es_vehiculo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO= "Detalle Grupo Activo Fijo";
		public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO_LOWER= "Detalle Grupo Activo Fijo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_ESVEHICULO= "Es Vehiculo";
		public static final String LABEL_ESVEHICULO_LOWER= "Es Vehiculo";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getSubGrupoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO;}
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.CODIGO)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.SIGLAS)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(SubGrupoActivoFijoConstantesFunciones.ESVEHICULO)) {sLabelColumna=SubGrupoActivoFijoConstantesFunciones.LABEL_ESVEHICULO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getes_vehiculoDescripcion(SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!subgrupoactivofijo.getes_vehiculo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_vehiculoHtmlDescripcion(SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(subgrupoactivofijo.getId(),subgrupoactivofijo.getes_vehiculo());

		return sDescripcion;
	}	
	
	public static String getSubGrupoActivoFijoDescripcion(SubGrupoActivoFijo subgrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(subgrupoactivofijo !=null/* && subgrupoactivofijo.getId()!=0*/) {
			sDescripcion=subgrupoactivofijo.getcodigo();//subgrupoactivofijosubgrupoactivofijo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSubGrupoActivoFijoDescripcionDetallado(SubGrupoActivoFijo subgrupoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=subgrupoactivofijo.getId().toString()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=subgrupoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=subgrupoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO+"=";
		sDescripcion+=subgrupoactivofijo.getid_detalle_grupo_activo_fijo().toString()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.CODIGO+"=";
		sDescripcion+=subgrupoactivofijo.getcodigo()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=subgrupoactivofijo.getnombre()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.SIGLAS+"=";
		sDescripcion+=subgrupoactivofijo.getsiglas()+",";
		sDescripcion+=SubGrupoActivoFijoConstantesFunciones.ESVEHICULO+"=";
		sDescripcion+=subgrupoactivofijo.getes_vehiculo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSubGrupoActivoFijoDescripcion(SubGrupoActivoFijo subgrupoactivofijo,String sValor) throws Exception {			
		if(subgrupoactivofijo !=null) {
			subgrupoactivofijo.setcodigo(sValor);;//subgrupoactivofijosubgrupoactivofijo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallegrupoactivofijo!=null/*&&detallegrupoactivofijo.getId()>0*/) {
			sDescripcion=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detallegrupoactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleGrupoActivoFijo(Long id_detalle_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subgrupoactivofijo.setcodigo(subgrupoactivofijo.getcodigo().trim());
		subgrupoactivofijo.setnombre(subgrupoactivofijo.getnombre().trim());
		subgrupoactivofijo.setsiglas(subgrupoactivofijo.getsiglas().trim());
	}
	
	public static void quitarEspaciosSubGrupoActivoFijos(List<SubGrupoActivoFijo> subgrupoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubGrupoActivoFijo subgrupoactivofijo: subgrupoactivofijos) {
			subgrupoactivofijo.setcodigo(subgrupoactivofijo.getcodigo().trim());
			subgrupoactivofijo.setnombre(subgrupoactivofijo.getnombre().trim());
			subgrupoactivofijo.setsiglas(subgrupoactivofijo.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && subgrupoactivofijo.getConCambioAuxiliar()) {
			subgrupoactivofijo.setIsDeleted(subgrupoactivofijo.getIsDeletedAuxiliar());	
			subgrupoactivofijo.setIsNew(subgrupoactivofijo.getIsNewAuxiliar());	
			subgrupoactivofijo.setIsChanged(subgrupoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			subgrupoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			subgrupoactivofijo.setIsDeletedAuxiliar(false);	
			subgrupoactivofijo.setIsNewAuxiliar(false);	
			subgrupoactivofijo.setIsChangedAuxiliar(false);
			
			subgrupoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubGrupoActivoFijos(List<SubGrupoActivoFijo> subgrupoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SubGrupoActivoFijo subgrupoactivofijo : subgrupoactivofijos) {
			if(conAsignarBase && subgrupoactivofijo.getConCambioAuxiliar()) {
				subgrupoactivofijo.setIsDeleted(subgrupoactivofijo.getIsDeletedAuxiliar());	
				subgrupoactivofijo.setIsNew(subgrupoactivofijo.getIsNewAuxiliar());	
				subgrupoactivofijo.setIsChanged(subgrupoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				subgrupoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				subgrupoactivofijo.setIsDeletedAuxiliar(false);	
				subgrupoactivofijo.setIsNewAuxiliar(false);	
				subgrupoactivofijo.setIsChangedAuxiliar(false);
				
				subgrupoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSubGrupoActivoFijos(List<SubGrupoActivoFijo> subgrupoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(SubGrupoActivoFijo subgrupoactivofijo: subgrupoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSubGrupoActivoFijo(List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijo subgrupoactivofijoAux) throws Exception  {
		SubGrupoActivoFijoConstantesFunciones.InicializarValoresSubGrupoActivoFijo(subgrupoactivofijoAux,true);
		
		for(SubGrupoActivoFijo subgrupoactivofijo: subgrupoactivofijos) {
			if(subgrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SubGrupoActivoFijoConstantesFunciones.getArrayColumnasGlobalesSubGrupoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSubGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSubGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijo subgrupoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SubGrupoActivoFijo subgrupoactivofijoAux: subgrupoactivofijos) {
			if(subgrupoactivofijoAux!=null && subgrupoactivofijo!=null) {
				if((subgrupoactivofijoAux.getId()==null && subgrupoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(subgrupoactivofijoAux.getId()!=null && subgrupoactivofijo.getId()!=null){
					if(subgrupoactivofijoAux.getId().equals(subgrupoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSubGrupoActivoFijo(List<SubGrupoActivoFijo> subgrupoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SubGrupoActivoFijo subgrupoactivofijo: subgrupoactivofijos) {			
			if(subgrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSubGrupoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_ID, SubGrupoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_VERSIONROW, SubGrupoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, SubGrupoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO, SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_CODIGO, SubGrupoActivoFijoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE, SubGrupoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS, SubGrupoActivoFijoConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoActivoFijoConstantesFunciones.LABEL_ESVEHICULO, SubGrupoActivoFijoConstantesFunciones.ESVEHICULO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSubGrupoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoActivoFijoConstantesFunciones.ESVEHICULO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoActivoFijo() throws Exception  {
		return SubGrupoActivoFijoConstantesFunciones.getTiposSeleccionarSubGrupoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoActivoFijo(Boolean conFk) throws Exception  {
		return SubGrupoActivoFijoConstantesFunciones.getTiposSeleccionarSubGrupoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoActivoFijoConstantesFunciones.LABEL_ESVEHICULO);
			reporte.setsDescripcion(SubGrupoActivoFijoConstantesFunciones.LABEL_ESVEHICULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSubGrupoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijoAux) throws Exception {
		
			subgrupoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subgrupoactivofijoAux.getEmpresa()));
			subgrupoactivofijoAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(subgrupoactivofijoAux.getDetalleGrupoActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSubGrupoActivoFijo(List<SubGrupoActivoFijo> subgrupoactivofijosTemp) throws Exception {
		for(SubGrupoActivoFijo subgrupoactivofijoAux:subgrupoactivofijosTemp) {
			
			subgrupoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subgrupoactivofijoAux.getEmpresa()));
			subgrupoactivofijoAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(subgrupoactivofijoAux.getDetalleGrupoActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSubGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(DetalleGrupoActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSubGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfSubGrupoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubGrupoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfSubGrupoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	public static void actualizarLista(SubGrupoActivoFijo subgrupoactivofijo,List<SubGrupoActivoFijo> subgrupoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SubGrupoActivoFijo subgrupoactivofijoEncontrado=null;
			
			for(SubGrupoActivoFijo subgrupoactivofijoLocal:subgrupoactivofijos) {
				if(subgrupoactivofijoLocal.getId().equals(subgrupoactivofijo.getId())) {
					subgrupoactivofijoEncontrado=subgrupoactivofijoLocal;
					
					subgrupoactivofijoLocal.setIsChanged(subgrupoactivofijo.getIsChanged());
					subgrupoactivofijoLocal.setIsNew(subgrupoactivofijo.getIsNew());
					subgrupoactivofijoLocal.setIsDeleted(subgrupoactivofijo.getIsDeleted());
					
					subgrupoactivofijoLocal.setGeneralEntityOriginal(subgrupoactivofijo.getGeneralEntityOriginal());
					
					subgrupoactivofijoLocal.setId(subgrupoactivofijo.getId());	
					subgrupoactivofijoLocal.setVersionRow(subgrupoactivofijo.getVersionRow());	
					subgrupoactivofijoLocal.setid_empresa(subgrupoactivofijo.getid_empresa());	
					subgrupoactivofijoLocal.setid_detalle_grupo_activo_fijo(subgrupoactivofijo.getid_detalle_grupo_activo_fijo());	
					subgrupoactivofijoLocal.setcodigo(subgrupoactivofijo.getcodigo());	
					subgrupoactivofijoLocal.setnombre(subgrupoactivofijo.getnombre());	
					subgrupoactivofijoLocal.setsiglas(subgrupoactivofijo.getsiglas());	
					subgrupoactivofijoLocal.setes_vehiculo(subgrupoactivofijo.getes_vehiculo());	
					
					
					subgrupoactivofijoLocal.setDetalleActivoFijos(subgrupoactivofijo.getDetalleActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!subgrupoactivofijo.getIsDeleted()) {
				if(!existe) {
					subgrupoactivofijos.add(subgrupoactivofijo);
				}
			} else {
				if(subgrupoactivofijoEncontrado!=null && permiteQuitar)  {
					subgrupoactivofijos.remove(subgrupoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SubGrupoActivoFijo subgrupoactivofijo,List<SubGrupoActivoFijo> subgrupoactivofijos) throws Exception {
		try	{			
			for(SubGrupoActivoFijo subgrupoactivofijoLocal:subgrupoactivofijos) {
				if(subgrupoactivofijoLocal.getId().equals(subgrupoactivofijo.getId())) {
					subgrupoactivofijoLocal.setIsSelected(subgrupoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSubGrupoActivoFijo(List<SubGrupoActivoFijo> subgrupoactivofijosAux) throws Exception {
		//this.subgrupoactivofijosAux=subgrupoactivofijosAux;
		
		for(SubGrupoActivoFijo subgrupoactivofijoAux:subgrupoactivofijosAux) {
			if(subgrupoactivofijoAux.getIsChanged()) {
				subgrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(subgrupoactivofijoAux.getIsNew()) {
				subgrupoactivofijoAux.setIsNew(false);
			}	
			
			if(subgrupoactivofijoAux.getIsDeleted()) {
				subgrupoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijoAux) throws Exception {
		//this.subgrupoactivofijoAux=subgrupoactivofijoAux;
		
			if(subgrupoactivofijoAux.getIsChanged()) {
				subgrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(subgrupoactivofijoAux.getIsNew()) {
				subgrupoactivofijoAux.setIsNew(false);
			}	
			
			if(subgrupoactivofijoAux.getIsDeleted()) {
				subgrupoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SubGrupoActivoFijo subgrupoactivofijoAsignar,SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		subgrupoactivofijoAsignar.setId(subgrupoactivofijo.getId());	
		subgrupoactivofijoAsignar.setVersionRow(subgrupoactivofijo.getVersionRow());	
		subgrupoactivofijoAsignar.setid_empresa(subgrupoactivofijo.getid_empresa());
		subgrupoactivofijoAsignar.setempresa_descripcion(subgrupoactivofijo.getempresa_descripcion());	
		subgrupoactivofijoAsignar.setid_detalle_grupo_activo_fijo(subgrupoactivofijo.getid_detalle_grupo_activo_fijo());
		subgrupoactivofijoAsignar.setdetallegrupoactivofijo_descripcion(subgrupoactivofijo.getdetallegrupoactivofijo_descripcion());	
		subgrupoactivofijoAsignar.setcodigo(subgrupoactivofijo.getcodigo());	
		subgrupoactivofijoAsignar.setnombre(subgrupoactivofijo.getnombre());	
		subgrupoactivofijoAsignar.setsiglas(subgrupoactivofijo.getsiglas());	
		subgrupoactivofijoAsignar.setes_vehiculo(subgrupoactivofijo.getes_vehiculo());	
	}
	
	public static void inicializarSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		try {
				subgrupoactivofijo.setId(0L);	
					
				subgrupoactivofijo.setid_empresa(-1L);	
				subgrupoactivofijo.setid_detalle_grupo_activo_fijo(-1L);	
				subgrupoactivofijo.setcodigo("");	
				subgrupoactivofijo.setnombre("");	
				subgrupoactivofijo.setsiglas("");	
				subgrupoactivofijo.setes_vehiculo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSubGrupoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoActivoFijoConstantesFunciones.LABEL_ESVEHICULO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSubGrupoActivoFijo(String sTipo,Row row,Workbook workbook,SubGrupoActivoFijo subgrupoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoactivofijo.getdetallegrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoactivofijo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoactivofijo.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(subgrupoactivofijo.getes_vehiculo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySubGrupoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySubGrupoActivoFijo() {
		return this.sFinalQuerySubGrupoActivoFijo;
	}
	
	public void setsFinalQuerySubGrupoActivoFijo(String sFinalQuerySubGrupoActivoFijo) {
		this.sFinalQuerySubGrupoActivoFijo= sFinalQuerySubGrupoActivoFijo;
	}
	
	public Border resaltarSeleccionarSubGrupoActivoFijo=null;
	
	public Border setResaltarSeleccionarSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSubGrupoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSubGrupoActivoFijo() {
		return this.resaltarSeleccionarSubGrupoActivoFijo;
	}
	
	public void setResaltarSeleccionarSubGrupoActivoFijo(Border borderResaltarSeleccionarSubGrupoActivoFijo) {
		this.resaltarSeleccionarSubGrupoActivoFijo= borderResaltarSeleccionarSubGrupoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSubGrupoActivoFijo=null;
	public Boolean mostraridSubGrupoActivoFijo=true;
	public Boolean activaridSubGrupoActivoFijo=true;

	public Border resaltarid_empresaSubGrupoActivoFijo=null;
	public Boolean mostrarid_empresaSubGrupoActivoFijo=true;
	public Boolean activarid_empresaSubGrupoActivoFijo=true;
	public Boolean cargarid_empresaSubGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSubGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo=null;
	public Boolean mostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo=true;
	public Boolean activarid_detalle_grupo_activo_fijoSubGrupoActivoFijo=true;
	public Boolean cargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_grupo_activo_fijoSubGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarcodigoSubGrupoActivoFijo=null;
	public Boolean mostrarcodigoSubGrupoActivoFijo=true;
	public Boolean activarcodigoSubGrupoActivoFijo=true;

	public Border resaltarnombreSubGrupoActivoFijo=null;
	public Boolean mostrarnombreSubGrupoActivoFijo=true;
	public Boolean activarnombreSubGrupoActivoFijo=true;

	public Border resaltarsiglasSubGrupoActivoFijo=null;
	public Boolean mostrarsiglasSubGrupoActivoFijo=true;
	public Boolean activarsiglasSubGrupoActivoFijo=true;

	public Border resaltares_vehiculoSubGrupoActivoFijo=null;
	public Boolean mostrares_vehiculoSubGrupoActivoFijo=true;
	public Boolean activares_vehiculoSubGrupoActivoFijo=true;

	
	

	public Border setResaltaridSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSubGrupoActivoFijo() {
		return this.resaltaridSubGrupoActivoFijo;
	}

	public void setResaltaridSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltaridSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridSubGrupoActivoFijo() {
		return this.mostraridSubGrupoActivoFijo;
	}

	public void setMostraridSubGrupoActivoFijo(Boolean mostraridSubGrupoActivoFijo) {
		this.mostraridSubGrupoActivoFijo= mostraridSubGrupoActivoFijo;
	}

	public Boolean getActivaridSubGrupoActivoFijo() {
		return this.activaridSubGrupoActivoFijo;
	}

	public void setActivaridSubGrupoActivoFijo(Boolean activaridSubGrupoActivoFijo) {
		this.activaridSubGrupoActivoFijo= activaridSubGrupoActivoFijo;
	}

	public Border setResaltarid_empresaSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSubGrupoActivoFijo() {
		return this.resaltarid_empresaSubGrupoActivoFijo;
	}

	public void setResaltarid_empresaSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaSubGrupoActivoFijo() {
		return this.mostrarid_empresaSubGrupoActivoFijo;
	}

	public void setMostrarid_empresaSubGrupoActivoFijo(Boolean mostrarid_empresaSubGrupoActivoFijo) {
		this.mostrarid_empresaSubGrupoActivoFijo= mostrarid_empresaSubGrupoActivoFijo;
	}

	public Boolean getActivarid_empresaSubGrupoActivoFijo() {
		return this.activarid_empresaSubGrupoActivoFijo;
	}

	public void setActivarid_empresaSubGrupoActivoFijo(Boolean activarid_empresaSubGrupoActivoFijo) {
		this.activarid_empresaSubGrupoActivoFijo= activarid_empresaSubGrupoActivoFijo;
	}

	public Boolean getCargarid_empresaSubGrupoActivoFijo() {
		return this.cargarid_empresaSubGrupoActivoFijo;
	}

	public void setCargarid_empresaSubGrupoActivoFijo(Boolean cargarid_empresaSubGrupoActivoFijo) {
		this.cargarid_empresaSubGrupoActivoFijo= cargarid_empresaSubGrupoActivoFijo;
	}

	public Border setResaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo() {
		return this.resaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public void setResaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo() {
		return this.mostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public void setMostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(Boolean mostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo) {
		this.mostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo= mostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public Boolean getActivarid_detalle_grupo_activo_fijoSubGrupoActivoFijo() {
		return this.activarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public void setActivarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(Boolean activarid_detalle_grupo_activo_fijoSubGrupoActivoFijo) {
		this.activarid_detalle_grupo_activo_fijoSubGrupoActivoFijo= activarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public Boolean getCargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo() {
		return this.cargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public void setCargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(Boolean cargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo) {
		this.cargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo= cargarid_detalle_grupo_activo_fijoSubGrupoActivoFijo;
	}

	public Border setResaltarcodigoSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcodigoSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSubGrupoActivoFijo() {
		return this.resaltarcodigoSubGrupoActivoFijo;
	}

	public void setResaltarcodigoSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarcodigoSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcodigoSubGrupoActivoFijo() {
		return this.mostrarcodigoSubGrupoActivoFijo;
	}

	public void setMostrarcodigoSubGrupoActivoFijo(Boolean mostrarcodigoSubGrupoActivoFijo) {
		this.mostrarcodigoSubGrupoActivoFijo= mostrarcodigoSubGrupoActivoFijo;
	}

	public Boolean getActivarcodigoSubGrupoActivoFijo() {
		return this.activarcodigoSubGrupoActivoFijo;
	}

	public void setActivarcodigoSubGrupoActivoFijo(Boolean activarcodigoSubGrupoActivoFijo) {
		this.activarcodigoSubGrupoActivoFijo= activarcodigoSubGrupoActivoFijo;
	}

	public Border setResaltarnombreSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSubGrupoActivoFijo() {
		return this.resaltarnombreSubGrupoActivoFijo;
	}

	public void setResaltarnombreSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarnombreSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreSubGrupoActivoFijo() {
		return this.mostrarnombreSubGrupoActivoFijo;
	}

	public void setMostrarnombreSubGrupoActivoFijo(Boolean mostrarnombreSubGrupoActivoFijo) {
		this.mostrarnombreSubGrupoActivoFijo= mostrarnombreSubGrupoActivoFijo;
	}

	public Boolean getActivarnombreSubGrupoActivoFijo() {
		return this.activarnombreSubGrupoActivoFijo;
	}

	public void setActivarnombreSubGrupoActivoFijo(Boolean activarnombreSubGrupoActivoFijo) {
		this.activarnombreSubGrupoActivoFijo= activarnombreSubGrupoActivoFijo;
	}

	public Border setResaltarsiglasSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarsiglasSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasSubGrupoActivoFijo() {
		return this.resaltarsiglasSubGrupoActivoFijo;
	}

	public void setResaltarsiglasSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarsiglasSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarsiglasSubGrupoActivoFijo() {
		return this.mostrarsiglasSubGrupoActivoFijo;
	}

	public void setMostrarsiglasSubGrupoActivoFijo(Boolean mostrarsiglasSubGrupoActivoFijo) {
		this.mostrarsiglasSubGrupoActivoFijo= mostrarsiglasSubGrupoActivoFijo;
	}

	public Boolean getActivarsiglasSubGrupoActivoFijo() {
		return this.activarsiglasSubGrupoActivoFijo;
	}

	public void setActivarsiglasSubGrupoActivoFijo(Boolean activarsiglasSubGrupoActivoFijo) {
		this.activarsiglasSubGrupoActivoFijo= activarsiglasSubGrupoActivoFijo;
	}

	public Border setResaltares_vehiculoSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltares_vehiculoSubGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_vehiculoSubGrupoActivoFijo() {
		return this.resaltares_vehiculoSubGrupoActivoFijo;
	}

	public void setResaltares_vehiculoSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltares_vehiculoSubGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrares_vehiculoSubGrupoActivoFijo() {
		return this.mostrares_vehiculoSubGrupoActivoFijo;
	}

	public void setMostrares_vehiculoSubGrupoActivoFijo(Boolean mostrares_vehiculoSubGrupoActivoFijo) {
		this.mostrares_vehiculoSubGrupoActivoFijo= mostrares_vehiculoSubGrupoActivoFijo;
	}

	public Boolean getActivares_vehiculoSubGrupoActivoFijo() {
		return this.activares_vehiculoSubGrupoActivoFijo;
	}

	public void setActivares_vehiculoSubGrupoActivoFijo(Boolean activares_vehiculoSubGrupoActivoFijo) {
		this.activares_vehiculoSubGrupoActivoFijo= activares_vehiculoSubGrupoActivoFijo;
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
		
		
		this.setMostraridSubGrupoActivoFijo(esInicial);
		this.setMostrarid_empresaSubGrupoActivoFijo(esInicial);
		this.setMostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esInicial);
		this.setMostrarcodigoSubGrupoActivoFijo(esInicial);
		this.setMostrarnombreSubGrupoActivoFijo(esInicial);
		this.setMostrarsiglasSubGrupoActivoFijo(esInicial);
		this.setMostrares_vehiculoSubGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setMostrarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ESVEHICULO)) {
				this.setMostrares_vehiculoSubGrupoActivoFijo(esAsigna);
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
		
		
		this.setActivaridSubGrupoActivoFijo(esInicial);
		this.setActivarid_empresaSubGrupoActivoFijo(esInicial);
		this.setActivarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esInicial);
		this.setActivarcodigoSubGrupoActivoFijo(esInicial);
		this.setActivarnombreSubGrupoActivoFijo(esInicial);
		this.setActivarsiglasSubGrupoActivoFijo(esInicial);
		this.setActivares_vehiculoSubGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setActivarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ESVEHICULO)) {
				this.setActivares_vehiculoSubGrupoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSubGrupoActivoFijo(esInicial);
		this.setResaltarid_empresaSubGrupoActivoFijo(esInicial);
		this.setResaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esInicial);
		this.setResaltarcodigoSubGrupoActivoFijo(esInicial);
		this.setResaltarnombreSubGrupoActivoFijo(esInicial);
		this.setResaltarsiglasSubGrupoActivoFijo(esInicial);
		this.setResaltares_vehiculoSubGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setResaltarid_detalle_grupo_activo_fijoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasSubGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoActivoFijoConstantesFunciones.ESVEHICULO)) {
				this.setResaltares_vehiculoSubGrupoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoSubGrupoActivoFijo=null;

	public Border getResaltarDetalleActivoFijoSubGrupoActivoFijo() {
		return this.resaltarDetalleActivoFijoSubGrupoActivoFijo;
	}

	public void setResaltarDetalleActivoFijoSubGrupoActivoFijo(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoSubGrupoActivoFijo= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subgrupoactivofijoBeanSwingJInternalFrame.jTtoolBarSubGrupoActivoFijo.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoSubGrupoActivoFijo= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoSubGrupoActivoFijo=true;

	public Boolean getMostrarDetalleActivoFijoSubGrupoActivoFijo() {
		return this.mostrarDetalleActivoFijoSubGrupoActivoFijo;
	}

	public void setMostrarDetalleActivoFijoSubGrupoActivoFijo(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoSubGrupoActivoFijo= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoSubGrupoActivoFijo=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoSubGrupoActivoFijo() {
		return this.activarDetalleActivoFijoSubGrupoActivoFijo;
	}

	public void setActivarDetalleActivoFijoSubGrupoActivoFijo(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoSubGrupoActivoFijo= habilitarResaltarDetalleActivoFijo;
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

		this.setMostrarDetalleActivoFijoSubGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoSubGrupoActivoFijo(esAsigna);
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

		this.setActivarDetalleActivoFijoSubGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoSubGrupoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoSubGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoSubGrupoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaSubGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaSubGrupoActivoFijo() {
		return this.mostrarFK_IdEmpresaSubGrupoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaSubGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSubGrupoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaSubGrupoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaSubGrupoActivoFijo() {
		return this.activarFK_IdEmpresaSubGrupoActivoFijo;
	}

	public void setActivarFK_IdEmpresaSubGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSubGrupoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaSubGrupoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaSubGrupoActivoFijo() {
		return this.resaltarFK_IdEmpresaSubGrupoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaSubGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSubGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSubGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoActivoFijoBeanSwingJInternalFrame subgrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSubGrupoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}