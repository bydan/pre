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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.VigenciaFueConstantesFunciones;
import com.bydan.erp.facturacion.util.VigenciaFueParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VigenciaFueParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VigenciaFueConstantesFunciones extends VigenciaFueConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VigenciaFue";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VigenciaFue"+VigenciaFueConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VigenciaFueHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VigenciaFueHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VigenciaFueConstantesFunciones.SCHEMA+"_"+VigenciaFueConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VigenciaFueHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VigenciaFueConstantesFunciones.SCHEMA+"_"+VigenciaFueConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VigenciaFueConstantesFunciones.SCHEMA+"_"+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VigenciaFueHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VigenciaFueConstantesFunciones.SCHEMA+"_"+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VigenciaFueHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VigenciaFueHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VigenciaFueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VigenciaFueConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VigenciaFueConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VigenciaFueConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VigenciaFueConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vigencia Fues";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vigencia Fue";
	public static final String SCLASSWEBTITULO_LOWER="Vigencia Fue";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VigenciaFue";
	public static final String OBJECTNAME="vigenciafue";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="vigencia_fue";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vigenciafue from "+VigenciaFueConstantesFunciones.SPERSISTENCENAME+" vigenciafue";
	public static String QUERYSELECTNATIVE="select "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".version_row,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id_pais,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id_ciudad,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_inicio,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_fin,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".numero_embarques,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fue,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_ultimo_embarque,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".valor,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".numero_cajas,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".esta_activo from "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME;//+" as "+VigenciaFueConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VigenciaFueConstantesFuncionesAdditional vigenciafueConstantesFuncionesAdditional=null;
	
	public VigenciaFueConstantesFuncionesAdditional getVigenciaFueConstantesFuncionesAdditional() {
		return this.vigenciafueConstantesFuncionesAdditional;
	}
	
	public void setVigenciaFueConstantesFuncionesAdditional(VigenciaFueConstantesFuncionesAdditional vigenciafueConstantesFuncionesAdditional) {
		try {
			this.vigenciafueConstantesFuncionesAdditional=vigenciafueConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NUMEROEMBARQUES= "numero_embarques";
    public static final String FUE= "fue";
    public static final String FECHAULTIMOEMBARQUE= "fecha_ultimo_embarque";
    public static final String VALOR= "valor";
    public static final String NUMEROCAJAS= "numero_cajas";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NUMEROEMBARQUES= "Numero Embarques";
		public static final String LABEL_NUMEROEMBARQUES_LOWER= "Numero Embarques";
    	public static final String LABEL_FUE= "Fue";
		public static final String LABEL_FUE_LOWER= "Fue";
    	public static final String LABEL_FECHAULTIMOEMBARQUE= "Fecha Ultimo Embarque";
		public static final String LABEL_FECHAULTIMOEMBARQUE_LOWER= "Fecha Ultimo Embarque";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROCAJAS= "Numero Cajas";
		public static final String LABEL_NUMEROCAJAS_LOWER= "Numero Cajas";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	public static final String SREGEXFUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getVigenciaFueLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.IDPAIS)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.IDCIUDAD)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.FECHAINICIO)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.FECHAFIN)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.NUMEROEMBARQUES)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_NUMEROEMBARQUES;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.FUE)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_FUE;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_FECHAULTIMOEMBARQUE;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.VALOR)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.NUMEROCAJAS)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_NUMEROCAJAS;}
		if(sNombreColumna.equals(VigenciaFueConstantesFunciones.ESTAACTIVO)) {sLabelColumna=VigenciaFueConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(VigenciaFue vigenciafue) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!vigenciafue.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(VigenciaFue vigenciafue) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(vigenciafue.getId(),vigenciafue.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getVigenciaFueDescripcion(VigenciaFue vigenciafue) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vigenciafue !=null/* && vigenciafue.getId()!=0*/) {
			sDescripcion=vigenciafue.getfecha_inicio().toString();//vigenciafuevigenciafue.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVigenciaFueDescripcionDetallado(VigenciaFue vigenciafue) {
		String sDescripcion="";
			
		sDescripcion+=VigenciaFueConstantesFunciones.ID+"=";
		sDescripcion+=vigenciafue.getId().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vigenciafue.getVersionRow().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.IDPAIS+"=";
		sDescripcion+=vigenciafue.getid_pais().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=vigenciafue.getid_ciudad().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=vigenciafue.getfecha_inicio().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=vigenciafue.getfecha_fin().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.NUMEROEMBARQUES+"=";
		sDescripcion+=vigenciafue.getnumero_embarques().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.FUE+"=";
		sDescripcion+=vigenciafue.getfue()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE+"=";
		sDescripcion+=vigenciafue.getfecha_ultimo_embarque().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.VALOR+"=";
		sDescripcion+=vigenciafue.getvalor().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.NUMEROCAJAS+"=";
		sDescripcion+=vigenciafue.getnumero_cajas().toString()+",";
		sDescripcion+=VigenciaFueConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=vigenciafue.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVigenciaFueDescripcion(VigenciaFue vigenciafue,String sValor) throws Exception {			
		if(vigenciafue !=null) {
			//vigenciafuevigenciafue.getId().toString();
		}		
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVigenciaFue(VigenciaFue vigenciafue,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vigenciafue.setfue(vigenciafue.getfue().trim());
	}
	
	public static void quitarEspaciosVigenciaFues(List<VigenciaFue> vigenciafues,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VigenciaFue vigenciafue: vigenciafues) {
			vigenciafue.setfue(vigenciafue.getfue().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVigenciaFue(VigenciaFue vigenciafue,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vigenciafue.getConCambioAuxiliar()) {
			vigenciafue.setIsDeleted(vigenciafue.getIsDeletedAuxiliar());	
			vigenciafue.setIsNew(vigenciafue.getIsNewAuxiliar());	
			vigenciafue.setIsChanged(vigenciafue.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vigenciafue.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vigenciafue.setIsDeletedAuxiliar(false);	
			vigenciafue.setIsNewAuxiliar(false);	
			vigenciafue.setIsChangedAuxiliar(false);
			
			vigenciafue.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVigenciaFues(List<VigenciaFue> vigenciafues,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VigenciaFue vigenciafue : vigenciafues) {
			if(conAsignarBase && vigenciafue.getConCambioAuxiliar()) {
				vigenciafue.setIsDeleted(vigenciafue.getIsDeletedAuxiliar());	
				vigenciafue.setIsNew(vigenciafue.getIsNewAuxiliar());	
				vigenciafue.setIsChanged(vigenciafue.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vigenciafue.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vigenciafue.setIsDeletedAuxiliar(false);	
				vigenciafue.setIsNewAuxiliar(false);	
				vigenciafue.setIsChangedAuxiliar(false);
				
				vigenciafue.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVigenciaFue(VigenciaFue vigenciafue,Boolean conEnteros) throws Exception  {
		vigenciafue.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			vigenciafue.setnumero_embarques(0);
			vigenciafue.setnumero_cajas(0);
		}
	}		
	
	public static void InicializarValoresVigenciaFues(List<VigenciaFue> vigenciafues,Boolean conEnteros) throws Exception  {
		
		for(VigenciaFue vigenciafue: vigenciafues) {
			vigenciafue.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				vigenciafue.setnumero_embarques(0);
				vigenciafue.setnumero_cajas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaVigenciaFue(List<VigenciaFue> vigenciafues,VigenciaFue vigenciafueAux) throws Exception  {
		VigenciaFueConstantesFunciones.InicializarValoresVigenciaFue(vigenciafueAux,true);
		
		for(VigenciaFue vigenciafue: vigenciafues) {
			if(vigenciafue.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vigenciafueAux.setnumero_embarques(vigenciafueAux.getnumero_embarques()+vigenciafue.getnumero_embarques());			
			vigenciafueAux.setvalor(vigenciafueAux.getvalor()+vigenciafue.getvalor());			
			vigenciafueAux.setnumero_cajas(vigenciafueAux.getnumero_cajas()+vigenciafue.getnumero_cajas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVigenciaFue(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VigenciaFueConstantesFunciones.getArrayColumnasGlobalesVigenciaFue(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVigenciaFue(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVigenciaFue(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VigenciaFue> vigenciafues,VigenciaFue vigenciafue,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VigenciaFue vigenciafueAux: vigenciafues) {
			if(vigenciafueAux!=null && vigenciafue!=null) {
				if((vigenciafueAux.getId()==null && vigenciafue.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vigenciafueAux.getId()!=null && vigenciafue.getId()!=null){
					if(vigenciafueAux.getId().equals(vigenciafue.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVigenciaFue(List<VigenciaFue> vigenciafues) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(VigenciaFue vigenciafue: vigenciafues) {			
			if(vigenciafue.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=vigenciafue.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VigenciaFueConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVigenciaFue() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_ID, VigenciaFueConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_VERSIONROW, VigenciaFueConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_IDPAIS, VigenciaFueConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_IDCIUDAD, VigenciaFueConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_FECHAINICIO, VigenciaFueConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_FECHAFIN, VigenciaFueConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_NUMEROEMBARQUES, VigenciaFueConstantesFunciones.NUMEROEMBARQUES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_FUE, VigenciaFueConstantesFunciones.FUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_FECHAULTIMOEMBARQUE, VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_VALOR, VigenciaFueConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_NUMEROCAJAS, VigenciaFueConstantesFunciones.NUMEROCAJAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VigenciaFueConstantesFunciones.LABEL_ESTAACTIVO, VigenciaFueConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVigenciaFue() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.NUMEROEMBARQUES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.FUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.NUMEROCAJAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VigenciaFueConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVigenciaFue() throws Exception  {
		return VigenciaFueConstantesFunciones.getTiposSeleccionarVigenciaFue(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVigenciaFue(Boolean conFk) throws Exception  {
		return VigenciaFueConstantesFunciones.getTiposSeleccionarVigenciaFue(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVigenciaFue(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_NUMEROEMBARQUES);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_NUMEROEMBARQUES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_FUE);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_FUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_FECHAULTIMOEMBARQUE);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_FECHAULTIMOEMBARQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_NUMEROCAJAS);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_NUMEROCAJAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VigenciaFueConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(VigenciaFueConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVigenciaFue(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVigenciaFue(VigenciaFue vigenciafueAux) throws Exception {
		
			vigenciafueAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(vigenciafueAux.getPais()));
			vigenciafueAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(vigenciafueAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVigenciaFue(List<VigenciaFue> vigenciafuesTemp) throws Exception {
		for(VigenciaFue vigenciafueAux:vigenciafuesTemp) {
			
			vigenciafueAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(vigenciafueAux.getPais()));
			vigenciafueAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(vigenciafueAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVigenciaFue(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVigenciaFue(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVigenciaFue(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VigenciaFueConstantesFunciones.getClassesRelationshipsOfVigenciaFue(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVigenciaFue(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVigenciaFue(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VigenciaFueConstantesFunciones.getClassesRelationshipsFromStringsOfVigenciaFue(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVigenciaFue(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VigenciaFue vigenciafue,List<VigenciaFue> vigenciafues,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VigenciaFue vigenciafueEncontrado=null;
			
			for(VigenciaFue vigenciafueLocal:vigenciafues) {
				if(vigenciafueLocal.getId().equals(vigenciafue.getId())) {
					vigenciafueEncontrado=vigenciafueLocal;
					
					vigenciafueLocal.setIsChanged(vigenciafue.getIsChanged());
					vigenciafueLocal.setIsNew(vigenciafue.getIsNew());
					vigenciafueLocal.setIsDeleted(vigenciafue.getIsDeleted());
					
					vigenciafueLocal.setGeneralEntityOriginal(vigenciafue.getGeneralEntityOriginal());
					
					vigenciafueLocal.setId(vigenciafue.getId());	
					vigenciafueLocal.setVersionRow(vigenciafue.getVersionRow());	
					vigenciafueLocal.setid_pais(vigenciafue.getid_pais());	
					vigenciafueLocal.setid_ciudad(vigenciafue.getid_ciudad());	
					vigenciafueLocal.setfecha_inicio(vigenciafue.getfecha_inicio());	
					vigenciafueLocal.setfecha_fin(vigenciafue.getfecha_fin());	
					vigenciafueLocal.setnumero_embarques(vigenciafue.getnumero_embarques());	
					vigenciafueLocal.setfue(vigenciafue.getfue());	
					vigenciafueLocal.setfecha_ultimo_embarque(vigenciafue.getfecha_ultimo_embarque());	
					vigenciafueLocal.setvalor(vigenciafue.getvalor());	
					vigenciafueLocal.setnumero_cajas(vigenciafue.getnumero_cajas());	
					vigenciafueLocal.setesta_activo(vigenciafue.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!vigenciafue.getIsDeleted()) {
				if(!existe) {
					vigenciafues.add(vigenciafue);
				}
			} else {
				if(vigenciafueEncontrado!=null && permiteQuitar)  {
					vigenciafues.remove(vigenciafueEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VigenciaFue vigenciafue,List<VigenciaFue> vigenciafues) throws Exception {
		try	{			
			for(VigenciaFue vigenciafueLocal:vigenciafues) {
				if(vigenciafueLocal.getId().equals(vigenciafue.getId())) {
					vigenciafueLocal.setIsSelected(vigenciafue.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVigenciaFue(List<VigenciaFue> vigenciafuesAux) throws Exception {
		//this.vigenciafuesAux=vigenciafuesAux;
		
		for(VigenciaFue vigenciafueAux:vigenciafuesAux) {
			if(vigenciafueAux.getIsChanged()) {
				vigenciafueAux.setIsChanged(false);
			}		
			
			if(vigenciafueAux.getIsNew()) {
				vigenciafueAux.setIsNew(false);
			}	
			
			if(vigenciafueAux.getIsDeleted()) {
				vigenciafueAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVigenciaFue(VigenciaFue vigenciafueAux) throws Exception {
		//this.vigenciafueAux=vigenciafueAux;
		
			if(vigenciafueAux.getIsChanged()) {
				vigenciafueAux.setIsChanged(false);
			}		
			
			if(vigenciafueAux.getIsNew()) {
				vigenciafueAux.setIsNew(false);
			}	
			
			if(vigenciafueAux.getIsDeleted()) {
				vigenciafueAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VigenciaFue vigenciafueAsignar,VigenciaFue vigenciafue) throws Exception {
		vigenciafueAsignar.setId(vigenciafue.getId());	
		vigenciafueAsignar.setVersionRow(vigenciafue.getVersionRow());	
		vigenciafueAsignar.setid_pais(vigenciafue.getid_pais());
		vigenciafueAsignar.setpais_descripcion(vigenciafue.getpais_descripcion());	
		vigenciafueAsignar.setid_ciudad(vigenciafue.getid_ciudad());
		vigenciafueAsignar.setciudad_descripcion(vigenciafue.getciudad_descripcion());	
		vigenciafueAsignar.setfecha_inicio(vigenciafue.getfecha_inicio());	
		vigenciafueAsignar.setfecha_fin(vigenciafue.getfecha_fin());	
		vigenciafueAsignar.setnumero_embarques(vigenciafue.getnumero_embarques());	
		vigenciafueAsignar.setfue(vigenciafue.getfue());	
		vigenciafueAsignar.setfecha_ultimo_embarque(vigenciafue.getfecha_ultimo_embarque());	
		vigenciafueAsignar.setvalor(vigenciafue.getvalor());	
		vigenciafueAsignar.setnumero_cajas(vigenciafue.getnumero_cajas());	
		vigenciafueAsignar.setesta_activo(vigenciafue.getesta_activo());	
	}
	
	public static void inicializarVigenciaFue(VigenciaFue vigenciafue) throws Exception {
		try {
				vigenciafue.setId(0L);	
					
				vigenciafue.setid_pais(-1L);	
				vigenciafue.setid_ciudad(-1L);	
				vigenciafue.setfecha_inicio(new Date());	
				vigenciafue.setfecha_fin(new Date());	
				vigenciafue.setnumero_embarques(0);	
				vigenciafue.setfue("");	
				vigenciafue.setfecha_ultimo_embarque(new Date());	
				vigenciafue.setvalor(0.0);	
				vigenciafue.setnumero_cajas(0);	
				vigenciafue.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVigenciaFue(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_NUMEROEMBARQUES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_FUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_FECHAULTIMOEMBARQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_NUMEROCAJAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VigenciaFueConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVigenciaFue(String sTipo,Row row,Workbook workbook,VigenciaFue vigenciafue,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getnumero_embarques());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getfue());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getfecha_ultimo_embarque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vigenciafue.getnumero_cajas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(vigenciafue.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVigenciaFue=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVigenciaFue() {
		return this.sFinalQueryVigenciaFue;
	}
	
	public void setsFinalQueryVigenciaFue(String sFinalQueryVigenciaFue) {
		this.sFinalQueryVigenciaFue= sFinalQueryVigenciaFue;
	}
	
	public Border resaltarSeleccionarVigenciaFue=null;
	
	public Border setResaltarSeleccionarVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVigenciaFue= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVigenciaFue() {
		return this.resaltarSeleccionarVigenciaFue;
	}
	
	public void setResaltarSeleccionarVigenciaFue(Border borderResaltarSeleccionarVigenciaFue) {
		this.resaltarSeleccionarVigenciaFue= borderResaltarSeleccionarVigenciaFue;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVigenciaFue=null;
	public Boolean mostraridVigenciaFue=true;
	public Boolean activaridVigenciaFue=true;

	public Border resaltarid_paisVigenciaFue=null;
	public Boolean mostrarid_paisVigenciaFue=true;
	public Boolean activarid_paisVigenciaFue=true;
	public Boolean cargarid_paisVigenciaFue=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisVigenciaFue=false;//ConEventDepend=true

	public Border resaltarid_ciudadVigenciaFue=null;
	public Boolean mostrarid_ciudadVigenciaFue=true;
	public Boolean activarid_ciudadVigenciaFue=true;
	public Boolean cargarid_ciudadVigenciaFue=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadVigenciaFue=false;//ConEventDepend=true

	public Border resaltarfecha_inicioVigenciaFue=null;
	public Boolean mostrarfecha_inicioVigenciaFue=true;
	public Boolean activarfecha_inicioVigenciaFue=false;

	public Border resaltarfecha_finVigenciaFue=null;
	public Boolean mostrarfecha_finVigenciaFue=true;
	public Boolean activarfecha_finVigenciaFue=false;

	public Border resaltarnumero_embarquesVigenciaFue=null;
	public Boolean mostrarnumero_embarquesVigenciaFue=true;
	public Boolean activarnumero_embarquesVigenciaFue=true;

	public Border resaltarfueVigenciaFue=null;
	public Boolean mostrarfueVigenciaFue=true;
	public Boolean activarfueVigenciaFue=true;

	public Border resaltarfecha_ultimo_embarqueVigenciaFue=null;
	public Boolean mostrarfecha_ultimo_embarqueVigenciaFue=true;
	public Boolean activarfecha_ultimo_embarqueVigenciaFue=false;

	public Border resaltarvalorVigenciaFue=null;
	public Boolean mostrarvalorVigenciaFue=true;
	public Boolean activarvalorVigenciaFue=true;

	public Border resaltarnumero_cajasVigenciaFue=null;
	public Boolean mostrarnumero_cajasVigenciaFue=true;
	public Boolean activarnumero_cajasVigenciaFue=true;

	public Border resaltaresta_activoVigenciaFue=null;
	public Boolean mostraresta_activoVigenciaFue=true;
	public Boolean activaresta_activoVigenciaFue=true;

	
	

	public Border setResaltaridVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltaridVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVigenciaFue() {
		return this.resaltaridVigenciaFue;
	}

	public void setResaltaridVigenciaFue(Border borderResaltar) {
		this.resaltaridVigenciaFue= borderResaltar;
	}

	public Boolean getMostraridVigenciaFue() {
		return this.mostraridVigenciaFue;
	}

	public void setMostraridVigenciaFue(Boolean mostraridVigenciaFue) {
		this.mostraridVigenciaFue= mostraridVigenciaFue;
	}

	public Boolean getActivaridVigenciaFue() {
		return this.activaridVigenciaFue;
	}

	public void setActivaridVigenciaFue(Boolean activaridVigenciaFue) {
		this.activaridVigenciaFue= activaridVigenciaFue;
	}

	public Border setResaltarid_paisVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarid_paisVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisVigenciaFue() {
		return this.resaltarid_paisVigenciaFue;
	}

	public void setResaltarid_paisVigenciaFue(Border borderResaltar) {
		this.resaltarid_paisVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarid_paisVigenciaFue() {
		return this.mostrarid_paisVigenciaFue;
	}

	public void setMostrarid_paisVigenciaFue(Boolean mostrarid_paisVigenciaFue) {
		this.mostrarid_paisVigenciaFue= mostrarid_paisVigenciaFue;
	}

	public Boolean getActivarid_paisVigenciaFue() {
		return this.activarid_paisVigenciaFue;
	}

	public void setActivarid_paisVigenciaFue(Boolean activarid_paisVigenciaFue) {
		this.activarid_paisVigenciaFue= activarid_paisVigenciaFue;
	}

	public Boolean getCargarid_paisVigenciaFue() {
		return this.cargarid_paisVigenciaFue;
	}

	public void setCargarid_paisVigenciaFue(Boolean cargarid_paisVigenciaFue) {
		this.cargarid_paisVigenciaFue= cargarid_paisVigenciaFue;
	}

	public Border setResaltarid_ciudadVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarid_ciudadVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadVigenciaFue() {
		return this.resaltarid_ciudadVigenciaFue;
	}

	public void setResaltarid_ciudadVigenciaFue(Border borderResaltar) {
		this.resaltarid_ciudadVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarid_ciudadVigenciaFue() {
		return this.mostrarid_ciudadVigenciaFue;
	}

	public void setMostrarid_ciudadVigenciaFue(Boolean mostrarid_ciudadVigenciaFue) {
		this.mostrarid_ciudadVigenciaFue= mostrarid_ciudadVigenciaFue;
	}

	public Boolean getActivarid_ciudadVigenciaFue() {
		return this.activarid_ciudadVigenciaFue;
	}

	public void setActivarid_ciudadVigenciaFue(Boolean activarid_ciudadVigenciaFue) {
		this.activarid_ciudadVigenciaFue= activarid_ciudadVigenciaFue;
	}

	public Boolean getCargarid_ciudadVigenciaFue() {
		return this.cargarid_ciudadVigenciaFue;
	}

	public void setCargarid_ciudadVigenciaFue(Boolean cargarid_ciudadVigenciaFue) {
		this.cargarid_ciudadVigenciaFue= cargarid_ciudadVigenciaFue;
	}

	public Border setResaltarfecha_inicioVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioVigenciaFue() {
		return this.resaltarfecha_inicioVigenciaFue;
	}

	public void setResaltarfecha_inicioVigenciaFue(Border borderResaltar) {
		this.resaltarfecha_inicioVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioVigenciaFue() {
		return this.mostrarfecha_inicioVigenciaFue;
	}

	public void setMostrarfecha_inicioVigenciaFue(Boolean mostrarfecha_inicioVigenciaFue) {
		this.mostrarfecha_inicioVigenciaFue= mostrarfecha_inicioVigenciaFue;
	}

	public Boolean getActivarfecha_inicioVigenciaFue() {
		return this.activarfecha_inicioVigenciaFue;
	}

	public void setActivarfecha_inicioVigenciaFue(Boolean activarfecha_inicioVigenciaFue) {
		this.activarfecha_inicioVigenciaFue= activarfecha_inicioVigenciaFue;
	}

	public Border setResaltarfecha_finVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarfecha_finVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finVigenciaFue() {
		return this.resaltarfecha_finVigenciaFue;
	}

	public void setResaltarfecha_finVigenciaFue(Border borderResaltar) {
		this.resaltarfecha_finVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarfecha_finVigenciaFue() {
		return this.mostrarfecha_finVigenciaFue;
	}

	public void setMostrarfecha_finVigenciaFue(Boolean mostrarfecha_finVigenciaFue) {
		this.mostrarfecha_finVigenciaFue= mostrarfecha_finVigenciaFue;
	}

	public Boolean getActivarfecha_finVigenciaFue() {
		return this.activarfecha_finVigenciaFue;
	}

	public void setActivarfecha_finVigenciaFue(Boolean activarfecha_finVigenciaFue) {
		this.activarfecha_finVigenciaFue= activarfecha_finVigenciaFue;
	}

	public Border setResaltarnumero_embarquesVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarnumero_embarquesVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_embarquesVigenciaFue() {
		return this.resaltarnumero_embarquesVigenciaFue;
	}

	public void setResaltarnumero_embarquesVigenciaFue(Border borderResaltar) {
		this.resaltarnumero_embarquesVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarnumero_embarquesVigenciaFue() {
		return this.mostrarnumero_embarquesVigenciaFue;
	}

	public void setMostrarnumero_embarquesVigenciaFue(Boolean mostrarnumero_embarquesVigenciaFue) {
		this.mostrarnumero_embarquesVigenciaFue= mostrarnumero_embarquesVigenciaFue;
	}

	public Boolean getActivarnumero_embarquesVigenciaFue() {
		return this.activarnumero_embarquesVigenciaFue;
	}

	public void setActivarnumero_embarquesVigenciaFue(Boolean activarnumero_embarquesVigenciaFue) {
		this.activarnumero_embarquesVigenciaFue= activarnumero_embarquesVigenciaFue;
	}

	public Border setResaltarfueVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarfueVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfueVigenciaFue() {
		return this.resaltarfueVigenciaFue;
	}

	public void setResaltarfueVigenciaFue(Border borderResaltar) {
		this.resaltarfueVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarfueVigenciaFue() {
		return this.mostrarfueVigenciaFue;
	}

	public void setMostrarfueVigenciaFue(Boolean mostrarfueVigenciaFue) {
		this.mostrarfueVigenciaFue= mostrarfueVigenciaFue;
	}

	public Boolean getActivarfueVigenciaFue() {
		return this.activarfueVigenciaFue;
	}

	public void setActivarfueVigenciaFue(Boolean activarfueVigenciaFue) {
		this.activarfueVigenciaFue= activarfueVigenciaFue;
	}

	public Border setResaltarfecha_ultimo_embarqueVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_embarqueVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_embarqueVigenciaFue() {
		return this.resaltarfecha_ultimo_embarqueVigenciaFue;
	}

	public void setResaltarfecha_ultimo_embarqueVigenciaFue(Border borderResaltar) {
		this.resaltarfecha_ultimo_embarqueVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_embarqueVigenciaFue() {
		return this.mostrarfecha_ultimo_embarqueVigenciaFue;
	}

	public void setMostrarfecha_ultimo_embarqueVigenciaFue(Boolean mostrarfecha_ultimo_embarqueVigenciaFue) {
		this.mostrarfecha_ultimo_embarqueVigenciaFue= mostrarfecha_ultimo_embarqueVigenciaFue;
	}

	public Boolean getActivarfecha_ultimo_embarqueVigenciaFue() {
		return this.activarfecha_ultimo_embarqueVigenciaFue;
	}

	public void setActivarfecha_ultimo_embarqueVigenciaFue(Boolean activarfecha_ultimo_embarqueVigenciaFue) {
		this.activarfecha_ultimo_embarqueVigenciaFue= activarfecha_ultimo_embarqueVigenciaFue;
	}

	public Border setResaltarvalorVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarvalorVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorVigenciaFue() {
		return this.resaltarvalorVigenciaFue;
	}

	public void setResaltarvalorVigenciaFue(Border borderResaltar) {
		this.resaltarvalorVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarvalorVigenciaFue() {
		return this.mostrarvalorVigenciaFue;
	}

	public void setMostrarvalorVigenciaFue(Boolean mostrarvalorVigenciaFue) {
		this.mostrarvalorVigenciaFue= mostrarvalorVigenciaFue;
	}

	public Boolean getActivarvalorVigenciaFue() {
		return this.activarvalorVigenciaFue;
	}

	public void setActivarvalorVigenciaFue(Boolean activarvalorVigenciaFue) {
		this.activarvalorVigenciaFue= activarvalorVigenciaFue;
	}

	public Border setResaltarnumero_cajasVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltarnumero_cajasVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cajasVigenciaFue() {
		return this.resaltarnumero_cajasVigenciaFue;
	}

	public void setResaltarnumero_cajasVigenciaFue(Border borderResaltar) {
		this.resaltarnumero_cajasVigenciaFue= borderResaltar;
	}

	public Boolean getMostrarnumero_cajasVigenciaFue() {
		return this.mostrarnumero_cajasVigenciaFue;
	}

	public void setMostrarnumero_cajasVigenciaFue(Boolean mostrarnumero_cajasVigenciaFue) {
		this.mostrarnumero_cajasVigenciaFue= mostrarnumero_cajasVigenciaFue;
	}

	public Boolean getActivarnumero_cajasVigenciaFue() {
		return this.activarnumero_cajasVigenciaFue;
	}

	public void setActivarnumero_cajasVigenciaFue(Boolean activarnumero_cajasVigenciaFue) {
		this.activarnumero_cajasVigenciaFue= activarnumero_cajasVigenciaFue;
	}

	public Border setResaltaresta_activoVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vigenciafueBeanSwingJInternalFrame.jTtoolBarVigenciaFue.setBorder(borderResaltar);
		
		this.resaltaresta_activoVigenciaFue= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoVigenciaFue() {
		return this.resaltaresta_activoVigenciaFue;
	}

	public void setResaltaresta_activoVigenciaFue(Border borderResaltar) {
		this.resaltaresta_activoVigenciaFue= borderResaltar;
	}

	public Boolean getMostraresta_activoVigenciaFue() {
		return this.mostraresta_activoVigenciaFue;
	}

	public void setMostraresta_activoVigenciaFue(Boolean mostraresta_activoVigenciaFue) {
		this.mostraresta_activoVigenciaFue= mostraresta_activoVigenciaFue;
	}

	public Boolean getActivaresta_activoVigenciaFue() {
		return this.activaresta_activoVigenciaFue;
	}

	public void setActivaresta_activoVigenciaFue(Boolean activaresta_activoVigenciaFue) {
		this.activaresta_activoVigenciaFue= activaresta_activoVigenciaFue;
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
		
		
		this.setMostraridVigenciaFue(esInicial);
		this.setMostrarid_paisVigenciaFue(esInicial);
		this.setMostrarid_ciudadVigenciaFue(esInicial);
		this.setMostrarfecha_inicioVigenciaFue(esInicial);
		this.setMostrarfecha_finVigenciaFue(esInicial);
		this.setMostrarnumero_embarquesVigenciaFue(esInicial);
		this.setMostrarfueVigenciaFue(esInicial);
		this.setMostrarfecha_ultimo_embarqueVigenciaFue(esInicial);
		this.setMostrarvalorVigenciaFue(esInicial);
		this.setMostrarnumero_cajasVigenciaFue(esInicial);
		this.setMostraresta_activoVigenciaFue(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ID)) {
				this.setMostraridVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROEMBARQUES)) {
				this.setMostrarnumero_embarquesVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FUE)) {
				this.setMostrarfueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE)) {
				this.setMostrarfecha_ultimo_embarqueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.VALOR)) {
				this.setMostrarvalorVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROCAJAS)) {
				this.setMostrarnumero_cajasVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoVigenciaFue(esAsigna);
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
		
		
		this.setActivaridVigenciaFue(esInicial);
		this.setActivarid_paisVigenciaFue(esInicial);
		this.setActivarid_ciudadVigenciaFue(esInicial);
		this.setActivarfecha_inicioVigenciaFue(esInicial);
		this.setActivarfecha_finVigenciaFue(esInicial);
		this.setActivarnumero_embarquesVigenciaFue(esInicial);
		this.setActivarfueVigenciaFue(esInicial);
		this.setActivarfecha_ultimo_embarqueVigenciaFue(esInicial);
		this.setActivarvalorVigenciaFue(esInicial);
		this.setActivarnumero_cajasVigenciaFue(esInicial);
		this.setActivaresta_activoVigenciaFue(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ID)) {
				this.setActivaridVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROEMBARQUES)) {
				this.setActivarnumero_embarquesVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FUE)) {
				this.setActivarfueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE)) {
				this.setActivarfecha_ultimo_embarqueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.VALOR)) {
				this.setActivarvalorVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROCAJAS)) {
				this.setActivarnumero_cajasVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoVigenciaFue(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVigenciaFue(esInicial);
		this.setResaltarid_paisVigenciaFue(esInicial);
		this.setResaltarid_ciudadVigenciaFue(esInicial);
		this.setResaltarfecha_inicioVigenciaFue(esInicial);
		this.setResaltarfecha_finVigenciaFue(esInicial);
		this.setResaltarnumero_embarquesVigenciaFue(esInicial);
		this.setResaltarfueVigenciaFue(esInicial);
		this.setResaltarfecha_ultimo_embarqueVigenciaFue(esInicial);
		this.setResaltarvalorVigenciaFue(esInicial);
		this.setResaltarnumero_cajasVigenciaFue(esInicial);
		this.setResaltaresta_activoVigenciaFue(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ID)) {
				this.setResaltaridVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROEMBARQUES)) {
				this.setResaltarnumero_embarquesVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FUE)) {
				this.setResaltarfueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE)) {
				this.setResaltarfecha_ultimo_embarqueVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.VALOR)) {
				this.setResaltarvalorVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.NUMEROCAJAS)) {
				this.setResaltarnumero_cajasVigenciaFue(esAsigna);
				continue;
			}

			if(campo.clase.equals(VigenciaFueConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoVigenciaFue(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadVigenciaFue=true;

	public Boolean getMostrarFK_IdCiudadVigenciaFue() {
		return this.mostrarFK_IdCiudadVigenciaFue;
	}

	public void setMostrarFK_IdCiudadVigenciaFue(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadVigenciaFue= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisVigenciaFue=true;

	public Boolean getMostrarFK_IdPaisVigenciaFue() {
		return this.mostrarFK_IdPaisVigenciaFue;
	}

	public void setMostrarFK_IdPaisVigenciaFue(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisVigenciaFue= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadVigenciaFue=true;

	public Boolean getActivarFK_IdCiudadVigenciaFue() {
		return this.activarFK_IdCiudadVigenciaFue;
	}

	public void setActivarFK_IdCiudadVigenciaFue(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadVigenciaFue= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisVigenciaFue=true;

	public Boolean getActivarFK_IdPaisVigenciaFue() {
		return this.activarFK_IdPaisVigenciaFue;
	}

	public void setActivarFK_IdPaisVigenciaFue(Boolean habilitarResaltar) {
		this.activarFK_IdPaisVigenciaFue= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadVigenciaFue=null;

	public Border getResaltarFK_IdCiudadVigenciaFue() {
		return this.resaltarFK_IdCiudadVigenciaFue;
	}

	public void setResaltarFK_IdCiudadVigenciaFue(Border borderResaltar) {
		this.resaltarFK_IdCiudadVigenciaFue= borderResaltar;
	}

	public void setResaltarFK_IdCiudadVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadVigenciaFue= borderResaltar;
	}

	public Border resaltarFK_IdPaisVigenciaFue=null;

	public Border getResaltarFK_IdPaisVigenciaFue() {
		return this.resaltarFK_IdPaisVigenciaFue;
	}

	public void setResaltarFK_IdPaisVigenciaFue(Border borderResaltar) {
		this.resaltarFK_IdPaisVigenciaFue= borderResaltar;
	}

	public void setResaltarFK_IdPaisVigenciaFue(ParametroGeneralUsuario parametroGeneralUsuario/*VigenciaFueBeanSwingJInternalFrame vigenciafueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisVigenciaFue= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}