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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.ModuloConstantesFunciones;
import com.bydan.erp.seguridad.util.ModuloParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ModuloParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ModuloConstantesFunciones extends ModuloConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Modulo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Modulo"+ModuloConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ModuloHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ModuloHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ModuloConstantesFunciones.SCHEMA+"_"+ModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ModuloConstantesFunciones.SCHEMA+"_"+ModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ModuloConstantesFunciones.SCHEMA+"_"+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ModuloConstantesFunciones.SCHEMA+"_"+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ModuloConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ModuloConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ModuloConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ModuloConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Modulos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Modulo";
	public static final String SCLASSWEBTITULO_LOWER="Modulo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Modulo";
	public static final String OBJECTNAME="modulo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="modulo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select modulo from "+ModuloConstantesFunciones.SPERSISTENCENAME+" modulo";
	public static String QUERYSELECTNATIVE="select "+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".id,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".version_row,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".id_sistema,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".id_paquete,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".codigo,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".nombre,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".id_tipo_tecla_mascara,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".tecla,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".estado,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".orden,"+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+".descripcion from "+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME;//+" as "+ModuloConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ModuloConstantesFuncionesAdditional moduloConstantesFuncionesAdditional=null;
	
	public ModuloConstantesFuncionesAdditional getModuloConstantesFuncionesAdditional() {
		return this.moduloConstantesFuncionesAdditional;
	}
	
	public void setModuloConstantesFuncionesAdditional(ModuloConstantesFuncionesAdditional moduloConstantesFuncionesAdditional) {
		try {
			this.moduloConstantesFuncionesAdditional=moduloConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String IDPAQUETE= "id_paquete";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOTECLAMASCARA= "id_tipo_tecla_mascara";
    public static final String TECLA= "tecla";
    public static final String ESTADO= "estado";
    public static final String ORDEN= "orden";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_IDPAQUETE= "Paquete";
		public static final String LABEL_IDPAQUETE_LOWER= "Paquete";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOTECLAMASCARA= "Tipo Tecla Mascara";
		public static final String LABEL_IDTIPOTECLAMASCARA_LOWER= "Tipo Tecla Mascara";
    	public static final String LABEL_TECLA= "Tecla";
		public static final String LABEL_TECLA_LOWER= "Tecla";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTECLA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTECLA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getModuloLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ModuloConstantesFunciones.IDSISTEMA)) {sLabelColumna=ModuloConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.IDPAQUETE)) {sLabelColumna=ModuloConstantesFunciones.LABEL_IDPAQUETE;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.CODIGO)) {sLabelColumna=ModuloConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.NOMBRE)) {sLabelColumna=ModuloConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.IDTIPOTECLAMASCARA)) {sLabelColumna=ModuloConstantesFunciones.LABEL_IDTIPOTECLAMASCARA;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.TECLA)) {sLabelColumna=ModuloConstantesFunciones.LABEL_TECLA;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.ESTADO)) {sLabelColumna=ModuloConstantesFunciones.LABEL_ESTADO;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.ORDEN)) {sLabelColumna=ModuloConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(ModuloConstantesFunciones.DESCRIPCION)) {sLabelColumna=ModuloConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getestadoDescripcion(Modulo modulo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!modulo.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Modulo modulo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(modulo.getId(),modulo.getestado());

		return sDescripcion;
	}	
			
			
	
	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(modulo !=null/* && modulo.getId()!=0*/) {
			sDescripcion=modulo.getnombre();//modulomodulo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getModuloDescripcionDetallado(Modulo modulo) {
		String sDescripcion="";
			
		sDescripcion+=ModuloConstantesFunciones.ID+"=";
		sDescripcion+=modulo.getId().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=modulo.getVersionRow().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=modulo.getid_sistema().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.IDPAQUETE+"=";
		sDescripcion+=modulo.getid_paquete().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.CODIGO+"=";
		sDescripcion+=modulo.getcodigo()+",";
		sDescripcion+=ModuloConstantesFunciones.NOMBRE+"=";
		sDescripcion+=modulo.getnombre()+",";
		sDescripcion+=ModuloConstantesFunciones.IDTIPOTECLAMASCARA+"=";
		sDescripcion+=modulo.getid_tipo_tecla_mascara().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.TECLA+"=";
		sDescripcion+=modulo.gettecla()+",";
		sDescripcion+=ModuloConstantesFunciones.ESTADO+"=";
		sDescripcion+=modulo.getestado().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.ORDEN+"=";
		sDescripcion+=modulo.getorden().toString()+",";
		sDescripcion+=ModuloConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=modulo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setModuloDescripcion(Modulo modulo,String sValor) throws Exception {			
		if(modulo !=null) {
			modulo.setnombre(sValor);;//modulomodulo.getnombre().trim();
		}		
	}
	
		

	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sistema!=null/*&&sistema.getId()>0*/) {
			sDescripcion=SistemaConstantesFunciones.getSistemaDescripcion(sistema);
		}

		return sDescripcion;
	}

	public static String getPaqueteDescripcion(Paquete paquete) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(paquete!=null/*&&paquete.getId()>0*/) {
			sDescripcion=PaqueteConstantesFunciones.getPaqueteDescripcion(paquete);
		}

		return sDescripcion;
	}

	public static String getTipoTeclaMascaraDescripcion(TipoTeclaMascara tipoteclamascara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoteclamascara!=null/*&&tipoteclamascara.getId()>0*/) {
			sDescripcion=TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(tipoteclamascara);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdSistemaPorNombre")) {
			sNombreIndice="Tipo=  Por Sistema Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPaquete")) {
			sNombreIndice="Tipo=  Por Paquete";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		} else if(sNombreIndice.equals("FK_IdTipoTeclaMascara")) {
			sNombreIndice="Tipo=  Por Tipo Tecla Mascara";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdSistemaPorNombre(Long id_sistema,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPaquete(Long id_paquete) {
		String sDetalleIndice=" Parametros->";
		if(id_paquete!=null) {sDetalleIndice+=" Codigo Unico De Paquete="+id_paquete.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTeclaMascara(Long id_tipo_tecla_mascara) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tecla_mascara!=null) {sDetalleIndice+=" Codigo Unico De Tipo Tecla Mascara="+id_tipo_tecla_mascara.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosModulo(Modulo modulo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		modulo.setcodigo(modulo.getcodigo().trim());
		modulo.setnombre(modulo.getnombre().trim());
		modulo.settecla(modulo.gettecla().trim());
		modulo.setdescripcion(modulo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosModulos(List<Modulo> modulos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Modulo modulo: modulos) {
			modulo.setcodigo(modulo.getcodigo().trim());
			modulo.setnombre(modulo.getnombre().trim());
			modulo.settecla(modulo.gettecla().trim());
			modulo.setdescripcion(modulo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModulo(Modulo modulo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && modulo.getConCambioAuxiliar()) {
			modulo.setIsDeleted(modulo.getIsDeletedAuxiliar());	
			modulo.setIsNew(modulo.getIsNewAuxiliar());	
			modulo.setIsChanged(modulo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			modulo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			modulo.setIsDeletedAuxiliar(false);	
			modulo.setIsNewAuxiliar(false);	
			modulo.setIsChangedAuxiliar(false);
			
			modulo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModulos(List<Modulo> modulos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Modulo modulo : modulos) {
			if(conAsignarBase && modulo.getConCambioAuxiliar()) {
				modulo.setIsDeleted(modulo.getIsDeletedAuxiliar());	
				modulo.setIsNew(modulo.getIsNewAuxiliar());	
				modulo.setIsChanged(modulo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				modulo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				modulo.setIsDeletedAuxiliar(false);	
				modulo.setIsNewAuxiliar(false);	
				modulo.setIsChangedAuxiliar(false);
				
				modulo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresModulo(Modulo modulo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			modulo.setorden(0);
		}
	}		
	
	public static void InicializarValoresModulos(List<Modulo> modulos,Boolean conEnteros) throws Exception  {
		
		for(Modulo modulo: modulos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				modulo.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaModulo(List<Modulo> modulos,Modulo moduloAux) throws Exception  {
		ModuloConstantesFunciones.InicializarValoresModulo(moduloAux,true);
		
		for(Modulo modulo: modulos) {
			if(modulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			moduloAux.setorden(moduloAux.getorden()+modulo.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ModuloConstantesFunciones.getArrayColumnasGlobalesModulo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesModulo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Modulo> modulos,Modulo modulo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Modulo moduloAux: modulos) {
			if(moduloAux!=null && modulo!=null) {
				if((moduloAux.getId()==null && modulo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(moduloAux.getId()!=null && modulo.getId()!=null){
					if(moduloAux.getId().equals(modulo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaModulo(List<Modulo> modulos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Modulo modulo: modulos) {			
			if(modulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaModulo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_ID, ModuloConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_VERSIONROW, ModuloConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_IDSISTEMA, ModuloConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_IDPAQUETE, ModuloConstantesFunciones.IDPAQUETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_CODIGO, ModuloConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_NOMBRE, ModuloConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_IDTIPOTECLAMASCARA, ModuloConstantesFunciones.IDTIPOTECLAMASCARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_TECLA, ModuloConstantesFunciones.TECLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_ESTADO, ModuloConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_ORDEN, ModuloConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModuloConstantesFunciones.LABEL_DESCRIPCION, ModuloConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasModulo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.IDPAQUETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.IDTIPOTECLAMASCARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.TECLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModuloConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModulo() throws Exception  {
		return ModuloConstantesFunciones.getTiposSeleccionarModulo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModulo(Boolean conFk) throws Exception  {
		return ModuloConstantesFunciones.getTiposSeleccionarModulo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModulo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_IDPAQUETE);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_IDPAQUETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_TECLA);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_TECLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModuloConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ModuloConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesModulo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesModulo(Modulo moduloAux) throws Exception {
		
			moduloAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(moduloAux.getSistema()));
			moduloAux.setpaquete_descripcion(PaqueteConstantesFunciones.getPaqueteDescripcion(moduloAux.getPaquete()));
			moduloAux.settipoteclamascara_descripcion(TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(moduloAux.getTipoTeclaMascara()));		
	}
	
	public static void refrescarForeignKeysDescripcionesModulo(List<Modulo> modulosTemp) throws Exception {
		for(Modulo moduloAux:modulosTemp) {
			
			moduloAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(moduloAux.getSistema()));
			moduloAux.setpaquete_descripcion(PaqueteConstantesFunciones.getPaqueteDescripcion(moduloAux.getPaquete()));
			moduloAux.settipoteclamascara_descripcion(TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(moduloAux.getTipoTeclaMascara()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				classes.add(new Classe(Paquete.class));
				classes.add(new Classe(TipoTeclaMascara.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sistema.class)) {
						classes.add(new Classe(Sistema.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Paquete.class)) {
						classes.add(new Classe(Paquete.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTeclaMascara.class)) {
						classes.add(new Classe(TipoTeclaMascara.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Paquete.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Paquete.class)); continue;
					}

					if(TipoTeclaMascara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTeclaMascara.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Paquete.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Paquete.class)); continue;
					}

					if(TipoTeclaMascara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTeclaMascara.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModuloConstantesFunciones.getClassesRelationshipsOfModulo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModuloConstantesFunciones.getClassesRelationshipsFromStringsOfModulo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Modulo modulo,List<Modulo> modulos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Modulo moduloEncontrado=null;
			
			for(Modulo moduloLocal:modulos) {
				if(moduloLocal.getId().equals(modulo.getId())) {
					moduloEncontrado=moduloLocal;
					
					moduloLocal.setIsChanged(modulo.getIsChanged());
					moduloLocal.setIsNew(modulo.getIsNew());
					moduloLocal.setIsDeleted(modulo.getIsDeleted());
					
					moduloLocal.setGeneralEntityOriginal(modulo.getGeneralEntityOriginal());
					
					moduloLocal.setId(modulo.getId());	
					moduloLocal.setVersionRow(modulo.getVersionRow());	
					moduloLocal.setid_sistema(modulo.getid_sistema());	
					moduloLocal.setid_paquete(modulo.getid_paquete());	
					moduloLocal.setcodigo(modulo.getcodigo());	
					moduloLocal.setnombre(modulo.getnombre());	
					moduloLocal.setid_tipo_tecla_mascara(modulo.getid_tipo_tecla_mascara());	
					moduloLocal.settecla(modulo.gettecla());	
					moduloLocal.setestado(modulo.getestado());	
					moduloLocal.setorden(modulo.getorden());	
					moduloLocal.setdescripcion(modulo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!modulo.getIsDeleted()) {
				if(!existe) {
					modulos.add(modulo);
				}
			} else {
				if(moduloEncontrado!=null && permiteQuitar)  {
					modulos.remove(moduloEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Modulo modulo,List<Modulo> modulos) throws Exception {
		try	{			
			for(Modulo moduloLocal:modulos) {
				if(moduloLocal.getId().equals(modulo.getId())) {
					moduloLocal.setIsSelected(modulo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesModulo(List<Modulo> modulosAux) throws Exception {
		//this.modulosAux=modulosAux;
		
		for(Modulo moduloAux:modulosAux) {
			if(moduloAux.getIsChanged()) {
				moduloAux.setIsChanged(false);
			}		
			
			if(moduloAux.getIsNew()) {
				moduloAux.setIsNew(false);
			}	
			
			if(moduloAux.getIsDeleted()) {
				moduloAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesModulo(Modulo moduloAux) throws Exception {
		//this.moduloAux=moduloAux;
		
			if(moduloAux.getIsChanged()) {
				moduloAux.setIsChanged(false);
			}		
			
			if(moduloAux.getIsNew()) {
				moduloAux.setIsNew(false);
			}	
			
			if(moduloAux.getIsDeleted()) {
				moduloAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Modulo moduloAsignar,Modulo modulo) throws Exception {
		moduloAsignar.setId(modulo.getId());	
		moduloAsignar.setVersionRow(modulo.getVersionRow());	
		moduloAsignar.setid_sistema(modulo.getid_sistema());
		moduloAsignar.setsistema_descripcion(modulo.getsistema_descripcion());	
		moduloAsignar.setid_paquete(modulo.getid_paquete());
		moduloAsignar.setpaquete_descripcion(modulo.getpaquete_descripcion());	
		moduloAsignar.setcodigo(modulo.getcodigo());	
		moduloAsignar.setnombre(modulo.getnombre());	
		moduloAsignar.setid_tipo_tecla_mascara(modulo.getid_tipo_tecla_mascara());
		moduloAsignar.settipoteclamascara_descripcion(modulo.gettipoteclamascara_descripcion());	
		moduloAsignar.settecla(modulo.gettecla());	
		moduloAsignar.setestado(modulo.getestado());	
		moduloAsignar.setorden(modulo.getorden());	
		moduloAsignar.setdescripcion(modulo.getdescripcion());	
	}
	
	public static void inicializarModulo(Modulo modulo) throws Exception {
		try {
				modulo.setId(0L);	
					
				modulo.setid_sistema(-1L);	
				modulo.setid_paquete(-1L);	
				modulo.setcodigo("");	
				modulo.setnombre("");	
				modulo.setid_tipo_tecla_mascara(-1L);	
				modulo.settecla("");	
				modulo.setestado(false);	
				modulo.setorden(0);	
				modulo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderModulo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_IDPAQUETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_TECLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModuloConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataModulo(String sTipo,Row row,Workbook workbook,Modulo modulo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getpaquete_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.gettipoteclamascara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.gettecla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(modulo.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modulo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryModulo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryModulo() {
		return this.sFinalQueryModulo;
	}
	
	public void setsFinalQueryModulo(String sFinalQueryModulo) {
		this.sFinalQueryModulo= sFinalQueryModulo;
	}
	
	public Border resaltarSeleccionarModulo=null;
	
	public Border setResaltarSeleccionarModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarModulo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarModulo() {
		return this.resaltarSeleccionarModulo;
	}
	
	public void setResaltarSeleccionarModulo(Border borderResaltarSeleccionarModulo) {
		this.resaltarSeleccionarModulo= borderResaltarSeleccionarModulo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridModulo=null;
	public Boolean mostraridModulo=true;
	public Boolean activaridModulo=true;

	public Border resaltarid_sistemaModulo=null;
	public Boolean mostrarid_sistemaModulo=true;
	public Boolean activarid_sistemaModulo=true;
	public Boolean cargarid_sistemaModulo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaModulo=false;//ConEventDepend=true

	public Border resaltarid_paqueteModulo=null;
	public Boolean mostrarid_paqueteModulo=true;
	public Boolean activarid_paqueteModulo=true;
	public Boolean cargarid_paqueteModulo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paqueteModulo=true;//ConEventDepend=true

	public Border resaltarcodigoModulo=null;
	public Boolean mostrarcodigoModulo=true;
	public Boolean activarcodigoModulo=true;

	public Border resaltarnombreModulo=null;
	public Boolean mostrarnombreModulo=true;
	public Boolean activarnombreModulo=true;

	public Border resaltarid_tipo_tecla_mascaraModulo=null;
	public Boolean mostrarid_tipo_tecla_mascaraModulo=true;
	public Boolean activarid_tipo_tecla_mascaraModulo=true;
	public Boolean cargarid_tipo_tecla_mascaraModulo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tecla_mascaraModulo=false;//ConEventDepend=true

	public Border resaltarteclaModulo=null;
	public Boolean mostrarteclaModulo=true;
	public Boolean activarteclaModulo=true;

	public Border resaltarestadoModulo=null;
	public Boolean mostrarestadoModulo=true;
	public Boolean activarestadoModulo=true;

	public Border resaltarordenModulo=null;
	public Boolean mostrarordenModulo=true;
	public Boolean activarordenModulo=true;

	public Border resaltardescripcionModulo=null;
	public Boolean mostrardescripcionModulo=true;
	public Boolean activardescripcionModulo=true;

	
	

	public Border setResaltaridModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltaridModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridModulo() {
		return this.resaltaridModulo;
	}

	public void setResaltaridModulo(Border borderResaltar) {
		this.resaltaridModulo= borderResaltar;
	}

	public Boolean getMostraridModulo() {
		return this.mostraridModulo;
	}

	public void setMostraridModulo(Boolean mostraridModulo) {
		this.mostraridModulo= mostraridModulo;
	}

	public Boolean getActivaridModulo() {
		return this.activaridModulo;
	}

	public void setActivaridModulo(Boolean activaridModulo) {
		this.activaridModulo= activaridModulo;
	}

	public Border setResaltarid_sistemaModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarid_sistemaModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaModulo() {
		return this.resaltarid_sistemaModulo;
	}

	public void setResaltarid_sistemaModulo(Border borderResaltar) {
		this.resaltarid_sistemaModulo= borderResaltar;
	}

	public Boolean getMostrarid_sistemaModulo() {
		return this.mostrarid_sistemaModulo;
	}

	public void setMostrarid_sistemaModulo(Boolean mostrarid_sistemaModulo) {
		this.mostrarid_sistemaModulo= mostrarid_sistemaModulo;
	}

	public Boolean getActivarid_sistemaModulo() {
		return this.activarid_sistemaModulo;
	}

	public void setActivarid_sistemaModulo(Boolean activarid_sistemaModulo) {
		this.activarid_sistemaModulo= activarid_sistemaModulo;
	}

	public Boolean getCargarid_sistemaModulo() {
		return this.cargarid_sistemaModulo;
	}

	public void setCargarid_sistemaModulo(Boolean cargarid_sistemaModulo) {
		this.cargarid_sistemaModulo= cargarid_sistemaModulo;
	}

	public Border setResaltarid_paqueteModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarid_paqueteModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paqueteModulo() {
		return this.resaltarid_paqueteModulo;
	}

	public void setResaltarid_paqueteModulo(Border borderResaltar) {
		this.resaltarid_paqueteModulo= borderResaltar;
	}

	public Boolean getMostrarid_paqueteModulo() {
		return this.mostrarid_paqueteModulo;
	}

	public void setMostrarid_paqueteModulo(Boolean mostrarid_paqueteModulo) {
		this.mostrarid_paqueteModulo= mostrarid_paqueteModulo;
	}

	public Boolean getActivarid_paqueteModulo() {
		return this.activarid_paqueteModulo;
	}

	public void setActivarid_paqueteModulo(Boolean activarid_paqueteModulo) {
		this.activarid_paqueteModulo= activarid_paqueteModulo;
	}

	public Boolean getCargarid_paqueteModulo() {
		return this.cargarid_paqueteModulo;
	}

	public void setCargarid_paqueteModulo(Boolean cargarid_paqueteModulo) {
		this.cargarid_paqueteModulo= cargarid_paqueteModulo;
	}

	public Border setResaltarcodigoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarcodigoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoModulo() {
		return this.resaltarcodigoModulo;
	}

	public void setResaltarcodigoModulo(Border borderResaltar) {
		this.resaltarcodigoModulo= borderResaltar;
	}

	public Boolean getMostrarcodigoModulo() {
		return this.mostrarcodigoModulo;
	}

	public void setMostrarcodigoModulo(Boolean mostrarcodigoModulo) {
		this.mostrarcodigoModulo= mostrarcodigoModulo;
	}

	public Boolean getActivarcodigoModulo() {
		return this.activarcodigoModulo;
	}

	public void setActivarcodigoModulo(Boolean activarcodigoModulo) {
		this.activarcodigoModulo= activarcodigoModulo;
	}

	public Border setResaltarnombreModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarnombreModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreModulo() {
		return this.resaltarnombreModulo;
	}

	public void setResaltarnombreModulo(Border borderResaltar) {
		this.resaltarnombreModulo= borderResaltar;
	}

	public Boolean getMostrarnombreModulo() {
		return this.mostrarnombreModulo;
	}

	public void setMostrarnombreModulo(Boolean mostrarnombreModulo) {
		this.mostrarnombreModulo= mostrarnombreModulo;
	}

	public Boolean getActivarnombreModulo() {
		return this.activarnombreModulo;
	}

	public void setActivarnombreModulo(Boolean activarnombreModulo) {
		this.activarnombreModulo= activarnombreModulo;
	}

	public Border setResaltarid_tipo_tecla_mascaraModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tecla_mascaraModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tecla_mascaraModulo() {
		return this.resaltarid_tipo_tecla_mascaraModulo;
	}

	public void setResaltarid_tipo_tecla_mascaraModulo(Border borderResaltar) {
		this.resaltarid_tipo_tecla_mascaraModulo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tecla_mascaraModulo() {
		return this.mostrarid_tipo_tecla_mascaraModulo;
	}

	public void setMostrarid_tipo_tecla_mascaraModulo(Boolean mostrarid_tipo_tecla_mascaraModulo) {
		this.mostrarid_tipo_tecla_mascaraModulo= mostrarid_tipo_tecla_mascaraModulo;
	}

	public Boolean getActivarid_tipo_tecla_mascaraModulo() {
		return this.activarid_tipo_tecla_mascaraModulo;
	}

	public void setActivarid_tipo_tecla_mascaraModulo(Boolean activarid_tipo_tecla_mascaraModulo) {
		this.activarid_tipo_tecla_mascaraModulo= activarid_tipo_tecla_mascaraModulo;
	}

	public Boolean getCargarid_tipo_tecla_mascaraModulo() {
		return this.cargarid_tipo_tecla_mascaraModulo;
	}

	public void setCargarid_tipo_tecla_mascaraModulo(Boolean cargarid_tipo_tecla_mascaraModulo) {
		this.cargarid_tipo_tecla_mascaraModulo= cargarid_tipo_tecla_mascaraModulo;
	}

	public Border setResaltarteclaModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarteclaModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarteclaModulo() {
		return this.resaltarteclaModulo;
	}

	public void setResaltarteclaModulo(Border borderResaltar) {
		this.resaltarteclaModulo= borderResaltar;
	}

	public Boolean getMostrarteclaModulo() {
		return this.mostrarteclaModulo;
	}

	public void setMostrarteclaModulo(Boolean mostrarteclaModulo) {
		this.mostrarteclaModulo= mostrarteclaModulo;
	}

	public Boolean getActivarteclaModulo() {
		return this.activarteclaModulo;
	}

	public void setActivarteclaModulo(Boolean activarteclaModulo) {
		this.activarteclaModulo= activarteclaModulo;
	}

	public Border setResaltarestadoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarestadoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoModulo() {
		return this.resaltarestadoModulo;
	}

	public void setResaltarestadoModulo(Border borderResaltar) {
		this.resaltarestadoModulo= borderResaltar;
	}

	public Boolean getMostrarestadoModulo() {
		return this.mostrarestadoModulo;
	}

	public void setMostrarestadoModulo(Boolean mostrarestadoModulo) {
		this.mostrarestadoModulo= mostrarestadoModulo;
	}

	public Boolean getActivarestadoModulo() {
		return this.activarestadoModulo;
	}

	public void setActivarestadoModulo(Boolean activarestadoModulo) {
		this.activarestadoModulo= activarestadoModulo;
	}

	public Border setResaltarordenModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltarordenModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenModulo() {
		return this.resaltarordenModulo;
	}

	public void setResaltarordenModulo(Border borderResaltar) {
		this.resaltarordenModulo= borderResaltar;
	}

	public Boolean getMostrarordenModulo() {
		return this.mostrarordenModulo;
	}

	public void setMostrarordenModulo(Boolean mostrarordenModulo) {
		this.mostrarordenModulo= mostrarordenModulo;
	}

	public Boolean getActivarordenModulo() {
		return this.activarordenModulo;
	}

	public void setActivarordenModulo(Boolean activarordenModulo) {
		this.activarordenModulo= activarordenModulo;
	}

	public Border setResaltardescripcionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//moduloBeanSwingJInternalFrame.jTtoolBarModulo.setBorder(borderResaltar);
		
		this.resaltardescripcionModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionModulo() {
		return this.resaltardescripcionModulo;
	}

	public void setResaltardescripcionModulo(Border borderResaltar) {
		this.resaltardescripcionModulo= borderResaltar;
	}

	public Boolean getMostrardescripcionModulo() {
		return this.mostrardescripcionModulo;
	}

	public void setMostrardescripcionModulo(Boolean mostrardescripcionModulo) {
		this.mostrardescripcionModulo= mostrardescripcionModulo;
	}

	public Boolean getActivardescripcionModulo() {
		return this.activardescripcionModulo;
	}

	public void setActivardescripcionModulo(Boolean activardescripcionModulo) {
		this.activardescripcionModulo= activardescripcionModulo;
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
		
		
		this.setMostraridModulo(esInicial);
		this.setMostrarid_sistemaModulo(esInicial);
		this.setMostrarid_paqueteModulo(esInicial);
		this.setMostrarcodigoModulo(esInicial);
		this.setMostrarnombreModulo(esInicial);
		this.setMostrarid_tipo_tecla_mascaraModulo(esInicial);
		this.setMostrarteclaModulo(esInicial);
		this.setMostrarestadoModulo(esInicial);
		this.setMostrarordenModulo(esInicial);
		this.setMostrardescripcionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModuloConstantesFunciones.ID)) {
				this.setMostraridModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDPAQUETE)) {
				this.setMostrarid_paqueteModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setMostrarid_tipo_tecla_mascaraModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.TECLA)) {
				this.setMostrarteclaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ESTADO)) {
				this.setMostrarestadoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ORDEN)) {
				this.setMostrarordenModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionModulo(esAsigna);
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
		
		
		this.setActivaridModulo(esInicial);
		this.setActivarid_sistemaModulo(esInicial);
		this.setActivarid_paqueteModulo(esInicial);
		this.setActivarcodigoModulo(esInicial);
		this.setActivarnombreModulo(esInicial);
		this.setActivarid_tipo_tecla_mascaraModulo(esInicial);
		this.setActivarteclaModulo(esInicial);
		this.setActivarestadoModulo(esInicial);
		this.setActivarordenModulo(esInicial);
		this.setActivardescripcionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModuloConstantesFunciones.ID)) {
				this.setActivaridModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDPAQUETE)) {
				this.setActivarid_paqueteModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.CODIGO)) {
				this.setActivarcodigoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.NOMBRE)) {
				this.setActivarnombreModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setActivarid_tipo_tecla_mascaraModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.TECLA)) {
				this.setActivarteclaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ESTADO)) {
				this.setActivarestadoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ORDEN)) {
				this.setActivarordenModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionModulo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridModulo(esInicial);
		this.setResaltarid_sistemaModulo(esInicial);
		this.setResaltarid_paqueteModulo(esInicial);
		this.setResaltarcodigoModulo(esInicial);
		this.setResaltarnombreModulo(esInicial);
		this.setResaltarid_tipo_tecla_mascaraModulo(esInicial);
		this.setResaltarteclaModulo(esInicial);
		this.setResaltarestadoModulo(esInicial);
		this.setResaltarordenModulo(esInicial);
		this.setResaltardescripcionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModuloConstantesFunciones.ID)) {
				this.setResaltaridModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDPAQUETE)) {
				this.setResaltarid_paqueteModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setResaltarid_tipo_tecla_mascaraModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.TECLA)) {
				this.setResaltarteclaModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ESTADO)) {
				this.setResaltarestadoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.ORDEN)) {
				this.setResaltarordenModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModuloConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionModulo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdSistemaPorNombreModulo=true;

	public Boolean getMostrarBusquedaPorIdSistemaPorNombreModulo() {
		return this.mostrarBusquedaPorIdSistemaPorNombreModulo;
	}

	public void setMostrarBusquedaPorIdSistemaPorNombreModulo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdSistemaPorNombreModulo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSistemaModulo=true;

	public Boolean getMostrarFK_IdSistemaModulo() {
		return this.mostrarFK_IdSistemaModulo;
	}

	public void setMostrarFK_IdSistemaModulo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSistemaModulo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTeclaMascaraModulo=true;

	public Boolean getMostrarFK_IdTipoTeclaMascaraModulo() {
		return this.mostrarFK_IdTipoTeclaMascaraModulo;
	}

	public void setMostrarFK_IdTipoTeclaMascaraModulo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTeclaMascaraModulo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdSistemaPorNombreModulo=true;

	public Boolean getActivarBusquedaPorIdSistemaPorNombreModulo() {
		return this.activarBusquedaPorIdSistemaPorNombreModulo;
	}

	public void setActivarBusquedaPorIdSistemaPorNombreModulo(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdSistemaPorNombreModulo= habilitarResaltar;
	}

	public Boolean activarFK_IdSistemaModulo=true;

	public Boolean getActivarFK_IdSistemaModulo() {
		return this.activarFK_IdSistemaModulo;
	}

	public void setActivarFK_IdSistemaModulo(Boolean habilitarResaltar) {
		this.activarFK_IdSistemaModulo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTeclaMascaraModulo=true;

	public Boolean getActivarFK_IdTipoTeclaMascaraModulo() {
		return this.activarFK_IdTipoTeclaMascaraModulo;
	}

	public void setActivarFK_IdTipoTeclaMascaraModulo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTeclaMascaraModulo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdSistemaPorNombreModulo=null;

	public Border getResaltarBusquedaPorIdSistemaPorNombreModulo() {
		return this.resaltarBusquedaPorIdSistemaPorNombreModulo;
	}

	public void setResaltarBusquedaPorIdSistemaPorNombreModulo(Border borderResaltar) {
		this.resaltarBusquedaPorIdSistemaPorNombreModulo= borderResaltar;
	}

	public void setResaltarBusquedaPorIdSistemaPorNombreModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdSistemaPorNombreModulo= borderResaltar;
	}

	public Border resaltarFK_IdSistemaModulo=null;

	public Border getResaltarFK_IdSistemaModulo() {
		return this.resaltarFK_IdSistemaModulo;
	}

	public void setResaltarFK_IdSistemaModulo(Border borderResaltar) {
		this.resaltarFK_IdSistemaModulo= borderResaltar;
	}

	public void setResaltarFK_IdSistemaModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSistemaModulo= borderResaltar;
	}

	public Border resaltarFK_IdTipoTeclaMascaraModulo=null;

	public Border getResaltarFK_IdTipoTeclaMascaraModulo() {
		return this.resaltarFK_IdTipoTeclaMascaraModulo;
	}

	public void setResaltarFK_IdTipoTeclaMascaraModulo(Border borderResaltar) {
		this.resaltarFK_IdTipoTeclaMascaraModulo= borderResaltar;
	}

	public void setResaltarFK_IdTipoTeclaMascaraModulo(ParametroGeneralUsuario parametroGeneralUsuario/*ModuloBeanSwingJInternalFrame moduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTeclaMascaraModulo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}