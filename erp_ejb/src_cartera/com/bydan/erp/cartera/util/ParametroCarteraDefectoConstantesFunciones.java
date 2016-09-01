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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.ParametroCarteraDefectoConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroCarteraDefectoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroCarteraDefectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroCarteraDefectoConstantesFunciones extends ParametroCarteraDefectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroCarteraDefecto";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroCarteraDefecto"+ParametroCarteraDefectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroCarteraDefectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroCarteraDefectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroCarteraDefectoConstantesFunciones.SCHEMA+"_"+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCarteraDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroCarteraDefectoConstantesFunciones.SCHEMA+"_"+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroCarteraDefectoConstantesFunciones.SCHEMA+"_"+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCarteraDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroCarteraDefectoConstantesFunciones.SCHEMA+"_"+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCarteraDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCarteraDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroCarteraDefectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroCarteraDefectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroCarteraDefectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroCarteraDefectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Cartera Defectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Cartera Defecto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Cartera Defecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroCarteraDefecto";
	public static final String OBJECTNAME="parametrocarteradefecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="parametro_cartera_defecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrocarteradefecto from "+ParametroCarteraDefectoConstantesFunciones.SPERSISTENCENAME+" parametrocarteradefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_pais,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_region,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_provincia,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_ciudad,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_zona,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_genero,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_estado_civil,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_estado_legal,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_vendedor,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_ruta,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_dia,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_precio,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_lista_precio from "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraDefectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroCarteraDefectoConstantesFuncionesAdditional parametrocarteradefectoConstantesFuncionesAdditional=null;
	
	public ParametroCarteraDefectoConstantesFuncionesAdditional getParametroCarteraDefectoConstantesFuncionesAdditional() {
		return this.parametrocarteradefectoConstantesFuncionesAdditional;
	}
	
	public void setParametroCarteraDefectoConstantesFuncionesAdditional(ParametroCarteraDefectoConstantesFuncionesAdditional parametrocarteradefectoConstantesFuncionesAdditional) {
		try {
			this.parametrocarteradefectoConstantesFuncionesAdditional=parametrocarteradefectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPAIS= "id_pais";
    public static final String IDREGION= "id_region";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDTIPOIDENTIFICACION= "id_tipo_identificacion";
    public static final String IDTIPONIVELEDU= "id_tipo_nivel_edu";
    public static final String IDPAISNACIONALIDAD= "id_pais_nacionalidad";
    public static final String IDTIPOGENERO= "id_tipo_genero";
    public static final String IDESTADOCIVIL= "id_estado_civil";
    public static final String IDESTADOLEGAL= "id_estado_legal";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDRUTA= "id_ruta";
    public static final String IDDIA= "id_dia";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDTIPOLISTAPRECIO= "id_tipo_lista_precio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDREGION= "Region";
		public static final String LABEL_IDREGION_LOWER= "Region";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
    	public static final String LABEL_IDTIPONIVELEDU= "Tipo Nivel Edu";
		public static final String LABEL_IDTIPONIVELEDU_LOWER= "Tipo Nivel Edu";
    	public static final String LABEL_IDPAISNACIONALIDAD= "Pais Nacionalad";
		public static final String LABEL_IDPAISNACIONALIDAD_LOWER= "Pais Nacionalidad";
    	public static final String LABEL_IDTIPOGENERO= "Tipo Genero";
		public static final String LABEL_IDTIPOGENERO_LOWER= "Tipo Genero";
    	public static final String LABEL_IDESTADOCIVIL= "Estado Civil";
		public static final String LABEL_IDESTADOCIVIL_LOWER= "Estado Civil";
    	public static final String LABEL_IDESTADOLEGAL= "Estado Legal";
		public static final String LABEL_IDESTADOLEGAL_LOWER= "Estado Legal";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDRUTA= "Ruta";
		public static final String LABEL_IDRUTA_LOWER= "Ruta";
    	public static final String LABEL_IDDIA= "Dia";
		public static final String LABEL_IDDIA_LOWER= "Dia";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDTIPOLISTAPRECIO= "Tipo Lista Precio";
		public static final String LABEL_IDTIPOLISTAPRECIO_LOWER= "Tipo Lista Precio";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroCarteraDefectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDPAIS)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDREGION)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDREGION;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDCIUDAD)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDZONA)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPONIVELEDU;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAISNACIONALIDAD;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOLEGAL;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDRUTA)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDRUTA;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDDIA)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDDIA;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO)) {sLabelColumna=ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOLISTAPRECIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroCarteraDefectoDescripcion(ParametroCarteraDefecto parametrocarteradefecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrocarteradefecto !=null/* && parametrocarteradefecto.getId()!=0*/) {
			if(parametrocarteradefecto.getId()!=null) {
				sDescripcion=parametrocarteradefecto.getId().toString();
			}//parametrocarteradefectoparametrocarteradefecto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroCarteraDefectoDescripcionDetallado(ParametroCarteraDefecto parametrocarteradefecto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.ID+"=";
		sDescripcion+=parametrocarteradefecto.getId().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrocarteradefecto.getVersionRow().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrocarteradefecto.getid_empresa().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrocarteradefecto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=parametrocarteradefecto.getid_pais().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDREGION+"=";
		sDescripcion+=parametrocarteradefecto.getid_region().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=parametrocarteradefecto.getid_provincia().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=parametrocarteradefecto.getid_ciudad().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDZONA+"=";
		sDescripcion+=parametrocarteradefecto.getid_zona().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=parametrocarteradefecto.getid_tipo_identificacion().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU+"=";
		sDescripcion+=parametrocarteradefecto.getid_tipo_nivel_edu().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD+"=";
		sDescripcion+=parametrocarteradefecto.getid_pais_nacionalidad().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=parametrocarteradefecto.getid_tipo_genero().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=parametrocarteradefecto.getid_estado_civil().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL+"=";
		sDescripcion+=parametrocarteradefecto.getid_estado_legal().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=parametrocarteradefecto.getid_cuenta_contable().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=parametrocarteradefecto.getid_vendedor().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDRUTA+"=";
		sDescripcion+=parametrocarteradefecto.getid_ruta().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDDIA+"=";
		sDescripcion+=parametrocarteradefecto.getid_dia().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=parametrocarteradefecto.getid_tipo_precio().toString()+",";
		sDescripcion+=ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO+"=";
		sDescripcion+=parametrocarteradefecto.getid_tipo_lista_precio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroCarteraDefectoDescripcion(ParametroCarteraDefecto parametrocarteradefecto,String sValor) throws Exception {			
		if(parametrocarteradefecto !=null) {
			//parametrocarteradefectoparametrocarteradefecto.getId().toString();
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

	public static String getRegionDescripcion(Region region) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(region!=null/*&&region.getId()>0*/) {
			sDescripcion=RegionConstantesFunciones.getRegionDescripcion(region);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
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

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}

	public static String getTipoNivelEduDescripcion(TipoNivelEdu tiponiveledu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiponiveledu!=null/*&&tiponiveledu.getId()>0*/) {
			sDescripcion=TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(tiponiveledu);
		}

		return sDescripcion;
	}

	public static String getPaisNacionalidadDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getTipoGeneroDescripcion(TipoGenero tipogenero) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogenero!=null/*&&tipogenero.getId()>0*/) {
			sDescripcion=TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(tipogenero);
		}

		return sDescripcion;
	}

	public static String getEstadoCivilDescripcion(EstadoCivil estadocivil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocivil!=null/*&&estadocivil.getId()>0*/) {
			sDescripcion=EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(estadocivil);
		}

		return sDescripcion;
	}

	public static String getEstadoLegalDescripcion(EstadoLegal estadolegal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadolegal!=null/*&&estadolegal.getId()>0*/) {
			sDescripcion=EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(estadolegal);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getRutaDescripcion(Ruta ruta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ruta!=null/*&&ruta.getId()>0*/) {
			sDescripcion=RutaConstantesFunciones.getRutaDescripcion(ruta);
		}

		return sDescripcion;
	}

	public static String getDiaDescripcion(Dia dia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(dia!=null/*&&dia.getId()>0*/) {
			sDescripcion=DiaConstantesFunciones.getDiaDescripcion(dia);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getTipoListaPrecioDescripcion(TipoListaPrecio tipolistaprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipolistaprecio!=null/*&&tipolistaprecio.getId()>0*/) {
			sDescripcion=TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(tipolistaprecio);
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
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDia")) {
			sNombreIndice="Tipo=  Por Dia";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoCivil")) {
			sNombreIndice="Tipo=  Por Estado Civil";
		} else if(sNombreIndice.equals("FK_IdEstadoLegal")) {
			sNombreIndice="Tipo=  Por Estado Legal";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPaisNacionalidad")) {
			sNombreIndice="Tipo=  Por Pais Nacionalad";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdRegion")) {
			sNombreIndice="Tipo=  Por Region";
		} else if(sNombreIndice.equals("FK_IdRuta")) {
			sNombreIndice="Tipo=  Por Ruta";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoGenero")) {
			sNombreIndice="Tipo=  Por Tipo Genero";
		} else if(sNombreIndice.equals("FK_IdTipoIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		} else if(sNombreIndice.equals("FK_IdTipoListaPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Lista Precio";
		} else if(sNombreIndice.equals("FK_IdTipoNivelEdu")) {
			sNombreIndice="Tipo=  Por Tipo Nivel Edu";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
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

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDia(Long id_dia) {
		String sDetalleIndice=" Parametros->";
		if(id_dia!=null) {sDetalleIndice+=" Codigo Unico De Dia="+id_dia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCivil(Long id_estado_civil) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_civil!=null) {sDetalleIndice+=" Codigo Unico De Estado Civil="+id_estado_civil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoLegal(Long id_estado_legal) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_legal!=null) {sDetalleIndice+=" Codigo Unico De Estado Legal="+id_estado_legal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPaisNacionalidad(Long id_pais_nacionalidad) {
		String sDetalleIndice=" Parametros->";
		if(id_pais_nacionalidad!=null) {sDetalleIndice+=" Codigo Unico De Pais Nacionalad="+id_pais_nacionalidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRegion(Long id_region) {
		String sDetalleIndice=" Parametros->";
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRuta(Long id_ruta) {
		String sDetalleIndice=" Parametros->";
		if(id_ruta!=null) {sDetalleIndice+=" Codigo Unico De Ruta="+id_ruta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGenero(Long id_tipo_genero) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_genero!=null) {sDetalleIndice+=" Codigo Unico De Tipo Genero="+id_tipo_genero.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIdentificacion(Long id_tipo_identificacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_identificacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+id_tipo_identificacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoListaPrecio(Long id_tipo_lista_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_lista_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Lista Precio="+id_tipo_lista_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoNivelEdu(Long id_tipo_nivel_edu) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_nivel_edu!=null) {sDetalleIndice+=" Codigo Unico De Tipo Nivel Edu="+id_tipo_nivel_edu.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroCarteraDefecto parametrocarteradefecto: parametrocarteradefectos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrocarteradefecto.getConCambioAuxiliar()) {
			parametrocarteradefecto.setIsDeleted(parametrocarteradefecto.getIsDeletedAuxiliar());	
			parametrocarteradefecto.setIsNew(parametrocarteradefecto.getIsNewAuxiliar());	
			parametrocarteradefecto.setIsChanged(parametrocarteradefecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrocarteradefecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrocarteradefecto.setIsDeletedAuxiliar(false);	
			parametrocarteradefecto.setIsNewAuxiliar(false);	
			parametrocarteradefecto.setIsChangedAuxiliar(false);
			
			parametrocarteradefecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroCarteraDefecto parametrocarteradefecto : parametrocarteradefectos) {
			if(conAsignarBase && parametrocarteradefecto.getConCambioAuxiliar()) {
				parametrocarteradefecto.setIsDeleted(parametrocarteradefecto.getIsDeletedAuxiliar());	
				parametrocarteradefecto.setIsNew(parametrocarteradefecto.getIsNewAuxiliar());	
				parametrocarteradefecto.setIsChanged(parametrocarteradefecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrocarteradefecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrocarteradefecto.setIsDeletedAuxiliar(false);	
				parametrocarteradefecto.setIsNewAuxiliar(false);	
				parametrocarteradefecto.setIsChangedAuxiliar(false);
				
				parametrocarteradefecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conEnteros) throws Exception  {
		
		for(ParametroCarteraDefecto parametrocarteradefecto: parametrocarteradefectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroCarteraDefecto(List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefecto parametrocarteradefectoAux) throws Exception  {
		ParametroCarteraDefectoConstantesFunciones.InicializarValoresParametroCarteraDefecto(parametrocarteradefectoAux,true);
		
		for(ParametroCarteraDefecto parametrocarteradefecto: parametrocarteradefectos) {
			if(parametrocarteradefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCarteraDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroCarteraDefectoConstantesFunciones.getArrayColumnasGlobalesParametroCarteraDefecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCarteraDefecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroCarteraDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefecto parametrocarteradefecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroCarteraDefecto parametrocarteradefectoAux: parametrocarteradefectos) {
			if(parametrocarteradefectoAux!=null && parametrocarteradefecto!=null) {
				if((parametrocarteradefectoAux.getId()==null && parametrocarteradefecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocarteradefectoAux.getId()!=null && parametrocarteradefecto.getId()!=null){
					if(parametrocarteradefectoAux.getId().equals(parametrocarteradefecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroCarteraDefecto(List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroCarteraDefecto parametrocarteradefecto: parametrocarteradefectos) {			
			if(parametrocarteradefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroCarteraDefecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_ID, ParametroCarteraDefectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_VERSIONROW, ParametroCarteraDefectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDEMPRESA, ParametroCarteraDefectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDSUCURSAL, ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAIS, ParametroCarteraDefectoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDREGION, ParametroCarteraDefectoConstantesFunciones.IDREGION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDPROVINCIA, ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDCIUDAD, ParametroCarteraDefectoConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDZONA, ParametroCarteraDefectoConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPONIVELEDU, ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAISNACIONALIDAD, ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOGENERO, ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOCIVIL, ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOLEGAL, ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDCUENTACONTABLE, ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDVENDEDOR, ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDRUTA, ParametroCarteraDefectoConstantesFunciones.IDRUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDDIA, ParametroCarteraDefectoConstantesFunciones.IDDIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOPRECIO, ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOLISTAPRECIO, ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroCarteraDefecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDREGION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDRUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDDIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCarteraDefecto() throws Exception  {
		return ParametroCarteraDefectoConstantesFunciones.getTiposSeleccionarParametroCarteraDefecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCarteraDefecto(Boolean conFk) throws Exception  {
		return ParametroCarteraDefectoConstantesFunciones.getTiposSeleccionarParametroCarteraDefecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCarteraDefecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDREGION);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPONIVELEDU);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPONIVELEDU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAISNACIONALIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOLEGAL);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOLEGAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDRUTA);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDRUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDDIA);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDDIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);
			reporte.setsDescripcion(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroCarteraDefecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefectoAux) throws Exception {
		
			parametrocarteradefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocarteradefectoAux.getEmpresa()));
			parametrocarteradefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrocarteradefectoAux.getSucursal()));
			parametrocarteradefectoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametrocarteradefectoAux.getPais()));
			parametrocarteradefectoAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(parametrocarteradefectoAux.getRegion()));
			parametrocarteradefectoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(parametrocarteradefectoAux.getProvincia()));
			parametrocarteradefectoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(parametrocarteradefectoAux.getCiudad()));
			parametrocarteradefectoAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(parametrocarteradefectoAux.getZona()));
			parametrocarteradefectoAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(parametrocarteradefectoAux.getTipoIdentificacion()));
			parametrocarteradefectoAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(parametrocarteradefectoAux.getTipoNivelEdu()));
			parametrocarteradefectoAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametrocarteradefectoAux.getPaisNacionalidad()));
			parametrocarteradefectoAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(parametrocarteradefectoAux.getTipoGenero()));
			parametrocarteradefectoAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(parametrocarteradefectoAux.getEstadoCivil()));
			parametrocarteradefectoAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(parametrocarteradefectoAux.getEstadoLegal()));
			parametrocarteradefectoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocarteradefectoAux.getCuentaContable()));
			parametrocarteradefectoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(parametrocarteradefectoAux.getVendedor()));
			parametrocarteradefectoAux.setruta_descripcion(RutaConstantesFunciones.getRutaDescripcion(parametrocarteradefectoAux.getRuta()));
			parametrocarteradefectoAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(parametrocarteradefectoAux.getDia()));
			parametrocarteradefectoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(parametrocarteradefectoAux.getTipoPrecio()));
			parametrocarteradefectoAux.settipolistaprecio_descripcion(TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(parametrocarteradefectoAux.getTipoListaPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCarteraDefecto(List<ParametroCarteraDefecto> parametrocarteradefectosTemp) throws Exception {
		for(ParametroCarteraDefecto parametrocarteradefectoAux:parametrocarteradefectosTemp) {
			
			parametrocarteradefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocarteradefectoAux.getEmpresa()));
			parametrocarteradefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrocarteradefectoAux.getSucursal()));
			parametrocarteradefectoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametrocarteradefectoAux.getPais()));
			parametrocarteradefectoAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(parametrocarteradefectoAux.getRegion()));
			parametrocarteradefectoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(parametrocarteradefectoAux.getProvincia()));
			parametrocarteradefectoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(parametrocarteradefectoAux.getCiudad()));
			parametrocarteradefectoAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(parametrocarteradefectoAux.getZona()));
			parametrocarteradefectoAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(parametrocarteradefectoAux.getTipoIdentificacion()));
			parametrocarteradefectoAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(parametrocarteradefectoAux.getTipoNivelEdu()));
			parametrocarteradefectoAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametrocarteradefectoAux.getPaisNacionalidad()));
			parametrocarteradefectoAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(parametrocarteradefectoAux.getTipoGenero()));
			parametrocarteradefectoAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(parametrocarteradefectoAux.getEstadoCivil()));
			parametrocarteradefectoAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(parametrocarteradefectoAux.getEstadoLegal()));
			parametrocarteradefectoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocarteradefectoAux.getCuentaContable()));
			parametrocarteradefectoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(parametrocarteradefectoAux.getVendedor()));
			parametrocarteradefectoAux.setruta_descripcion(RutaConstantesFunciones.getRutaDescripcion(parametrocarteradefectoAux.getRuta()));
			parametrocarteradefectoAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(parametrocarteradefectoAux.getDia()));
			parametrocarteradefectoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(parametrocarteradefectoAux.getTipoPrecio()));
			parametrocarteradefectoAux.settipolistaprecio_descripcion(TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(parametrocarteradefectoAux.getTipoListaPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCarteraDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Region.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(TipoIdentificacion.class));
				classes.add(new Classe(TipoNivelEdu.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(TipoGenero.class));
				classes.add(new Classe(EstadoCivil.class));
				classes.add(new Classe(EstadoLegal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Ruta.class));
				classes.add(new Classe(Dia.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(TipoListaPrecio.class));
				
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
					if(clas.clas.equals(Region.class)) {
						classes.add(new Classe(Region.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoNivelEdu.class)) {
						classes.add(new Classe(TipoNivelEdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGenero.class)) {
						classes.add(new Classe(TipoGenero.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCivil.class)) {
						classes.add(new Classe(EstadoCivil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoLegal.class)) {
						classes.add(new Classe(EstadoLegal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ruta.class)) {
						classes.add(new Classe(Ruta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Dia.class)) {
						classes.add(new Classe(Dia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoListaPrecio.class)) {
						classes.add(new Classe(TipoListaPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroCarteraDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(EstadoLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoLegal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(TipoListaPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoListaPrecio.class)); continue;
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

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(EstadoLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoLegal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(TipoListaPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoListaPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCarteraDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCarteraDefectoConstantesFunciones.getClassesRelationshipsOfParametroCarteraDefecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCarteraDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCarteraDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCarteraDefectoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroCarteraDefecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCarteraDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroCarteraDefecto parametrocarteradefecto,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroCarteraDefecto parametrocarteradefectoEncontrado=null;
			
			for(ParametroCarteraDefecto parametrocarteradefectoLocal:parametrocarteradefectos) {
				if(parametrocarteradefectoLocal.getId().equals(parametrocarteradefecto.getId())) {
					parametrocarteradefectoEncontrado=parametrocarteradefectoLocal;
					
					parametrocarteradefectoLocal.setIsChanged(parametrocarteradefecto.getIsChanged());
					parametrocarteradefectoLocal.setIsNew(parametrocarteradefecto.getIsNew());
					parametrocarteradefectoLocal.setIsDeleted(parametrocarteradefecto.getIsDeleted());
					
					parametrocarteradefectoLocal.setGeneralEntityOriginal(parametrocarteradefecto.getGeneralEntityOriginal());
					
					parametrocarteradefectoLocal.setId(parametrocarteradefecto.getId());	
					parametrocarteradefectoLocal.setVersionRow(parametrocarteradefecto.getVersionRow());	
					parametrocarteradefectoLocal.setid_empresa(parametrocarteradefecto.getid_empresa());	
					parametrocarteradefectoLocal.setid_sucursal(parametrocarteradefecto.getid_sucursal());	
					parametrocarteradefectoLocal.setid_pais(parametrocarteradefecto.getid_pais());	
					parametrocarteradefectoLocal.setid_region(parametrocarteradefecto.getid_region());	
					parametrocarteradefectoLocal.setid_provincia(parametrocarteradefecto.getid_provincia());	
					parametrocarteradefectoLocal.setid_ciudad(parametrocarteradefecto.getid_ciudad());	
					parametrocarteradefectoLocal.setid_zona(parametrocarteradefecto.getid_zona());	
					parametrocarteradefectoLocal.setid_tipo_identificacion(parametrocarteradefecto.getid_tipo_identificacion());	
					parametrocarteradefectoLocal.setid_tipo_nivel_edu(parametrocarteradefecto.getid_tipo_nivel_edu());	
					parametrocarteradefectoLocal.setid_pais_nacionalidad(parametrocarteradefecto.getid_pais_nacionalidad());	
					parametrocarteradefectoLocal.setid_tipo_genero(parametrocarteradefecto.getid_tipo_genero());	
					parametrocarteradefectoLocal.setid_estado_civil(parametrocarteradefecto.getid_estado_civil());	
					parametrocarteradefectoLocal.setid_estado_legal(parametrocarteradefecto.getid_estado_legal());	
					parametrocarteradefectoLocal.setid_cuenta_contable(parametrocarteradefecto.getid_cuenta_contable());	
					parametrocarteradefectoLocal.setid_vendedor(parametrocarteradefecto.getid_vendedor());	
					parametrocarteradefectoLocal.setid_ruta(parametrocarteradefecto.getid_ruta());	
					parametrocarteradefectoLocal.setid_dia(parametrocarteradefecto.getid_dia());	
					parametrocarteradefectoLocal.setid_tipo_precio(parametrocarteradefecto.getid_tipo_precio());	
					parametrocarteradefectoLocal.setid_tipo_lista_precio(parametrocarteradefecto.getid_tipo_lista_precio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrocarteradefecto.getIsDeleted()) {
				if(!existe) {
					parametrocarteradefectos.add(parametrocarteradefecto);
				}
			} else {
				if(parametrocarteradefectoEncontrado!=null && permiteQuitar)  {
					parametrocarteradefectos.remove(parametrocarteradefectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroCarteraDefecto parametrocarteradefecto,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {
		try	{			
			for(ParametroCarteraDefecto parametrocarteradefectoLocal:parametrocarteradefectos) {
				if(parametrocarteradefectoLocal.getId().equals(parametrocarteradefecto.getId())) {
					parametrocarteradefectoLocal.setIsSelected(parametrocarteradefecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroCarteraDefecto(List<ParametroCarteraDefecto> parametrocarteradefectosAux) throws Exception {
		//this.parametrocarteradefectosAux=parametrocarteradefectosAux;
		
		for(ParametroCarteraDefecto parametrocarteradefectoAux:parametrocarteradefectosAux) {
			if(parametrocarteradefectoAux.getIsChanged()) {
				parametrocarteradefectoAux.setIsChanged(false);
			}		
			
			if(parametrocarteradefectoAux.getIsNew()) {
				parametrocarteradefectoAux.setIsNew(false);
			}	
			
			if(parametrocarteradefectoAux.getIsDeleted()) {
				parametrocarteradefectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefectoAux) throws Exception {
		//this.parametrocarteradefectoAux=parametrocarteradefectoAux;
		
			if(parametrocarteradefectoAux.getIsChanged()) {
				parametrocarteradefectoAux.setIsChanged(false);
			}		
			
			if(parametrocarteradefectoAux.getIsNew()) {
				parametrocarteradefectoAux.setIsNew(false);
			}	
			
			if(parametrocarteradefectoAux.getIsDeleted()) {
				parametrocarteradefectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroCarteraDefecto parametrocarteradefectoAsignar,ParametroCarteraDefecto parametrocarteradefecto) throws Exception {
		parametrocarteradefectoAsignar.setId(parametrocarteradefecto.getId());	
		parametrocarteradefectoAsignar.setVersionRow(parametrocarteradefecto.getVersionRow());	
		parametrocarteradefectoAsignar.setid_empresa(parametrocarteradefecto.getid_empresa());
		parametrocarteradefectoAsignar.setempresa_descripcion(parametrocarteradefecto.getempresa_descripcion());	
		parametrocarteradefectoAsignar.setid_sucursal(parametrocarteradefecto.getid_sucursal());
		parametrocarteradefectoAsignar.setsucursal_descripcion(parametrocarteradefecto.getsucursal_descripcion());	
		parametrocarteradefectoAsignar.setid_pais(parametrocarteradefecto.getid_pais());
		parametrocarteradefectoAsignar.setpais_descripcion(parametrocarteradefecto.getpais_descripcion());	
		parametrocarteradefectoAsignar.setid_region(parametrocarteradefecto.getid_region());
		parametrocarteradefectoAsignar.setregion_descripcion(parametrocarteradefecto.getregion_descripcion());	
		parametrocarteradefectoAsignar.setid_provincia(parametrocarteradefecto.getid_provincia());
		parametrocarteradefectoAsignar.setprovincia_descripcion(parametrocarteradefecto.getprovincia_descripcion());	
		parametrocarteradefectoAsignar.setid_ciudad(parametrocarteradefecto.getid_ciudad());
		parametrocarteradefectoAsignar.setciudad_descripcion(parametrocarteradefecto.getciudad_descripcion());	
		parametrocarteradefectoAsignar.setid_zona(parametrocarteradefecto.getid_zona());
		parametrocarteradefectoAsignar.setzona_descripcion(parametrocarteradefecto.getzona_descripcion());	
		parametrocarteradefectoAsignar.setid_tipo_identificacion(parametrocarteradefecto.getid_tipo_identificacion());
		parametrocarteradefectoAsignar.settipoidentificacion_descripcion(parametrocarteradefecto.gettipoidentificacion_descripcion());	
		parametrocarteradefectoAsignar.setid_tipo_nivel_edu(parametrocarteradefecto.getid_tipo_nivel_edu());
		parametrocarteradefectoAsignar.settiponiveledu_descripcion(parametrocarteradefecto.gettiponiveledu_descripcion());	
		parametrocarteradefectoAsignar.setid_pais_nacionalidad(parametrocarteradefecto.getid_pais_nacionalidad());
		parametrocarteradefectoAsignar.setpaisnacionalidad_descripcion(parametrocarteradefecto.getpaisnacionalidad_descripcion());	
		parametrocarteradefectoAsignar.setid_tipo_genero(parametrocarteradefecto.getid_tipo_genero());
		parametrocarteradefectoAsignar.settipogenero_descripcion(parametrocarteradefecto.gettipogenero_descripcion());	
		parametrocarteradefectoAsignar.setid_estado_civil(parametrocarteradefecto.getid_estado_civil());
		parametrocarteradefectoAsignar.setestadocivil_descripcion(parametrocarteradefecto.getestadocivil_descripcion());	
		parametrocarteradefectoAsignar.setid_estado_legal(parametrocarteradefecto.getid_estado_legal());
		parametrocarteradefectoAsignar.setestadolegal_descripcion(parametrocarteradefecto.getestadolegal_descripcion());	
		parametrocarteradefectoAsignar.setid_cuenta_contable(parametrocarteradefecto.getid_cuenta_contable());
		parametrocarteradefectoAsignar.setcuentacontable_descripcion(parametrocarteradefecto.getcuentacontable_descripcion());	
		parametrocarteradefectoAsignar.setid_vendedor(parametrocarteradefecto.getid_vendedor());
		parametrocarteradefectoAsignar.setvendedor_descripcion(parametrocarteradefecto.getvendedor_descripcion());	
		parametrocarteradefectoAsignar.setid_ruta(parametrocarteradefecto.getid_ruta());
		parametrocarteradefectoAsignar.setruta_descripcion(parametrocarteradefecto.getruta_descripcion());	
		parametrocarteradefectoAsignar.setid_dia(parametrocarteradefecto.getid_dia());
		parametrocarteradefectoAsignar.setdia_descripcion(parametrocarteradefecto.getdia_descripcion());	
		parametrocarteradefectoAsignar.setid_tipo_precio(parametrocarteradefecto.getid_tipo_precio());
		parametrocarteradefectoAsignar.settipoprecio_descripcion(parametrocarteradefecto.gettipoprecio_descripcion());	
		parametrocarteradefectoAsignar.setid_tipo_lista_precio(parametrocarteradefecto.getid_tipo_lista_precio());
		parametrocarteradefectoAsignar.settipolistaprecio_descripcion(parametrocarteradefecto.gettipolistaprecio_descripcion());	
	}
	
	public static void inicializarParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto) throws Exception {
		try {
				parametrocarteradefecto.setId(0L);	
					
				parametrocarteradefecto.setid_empresa(-1L);	
				parametrocarteradefecto.setid_sucursal(-1L);	
				parametrocarteradefecto.setid_pais(-1L);	
				parametrocarteradefecto.setid_region(-1L);	
				parametrocarteradefecto.setid_provincia(-1L);	
				parametrocarteradefecto.setid_ciudad(-1L);	
				parametrocarteradefecto.setid_zona(-1L);	
				parametrocarteradefecto.setid_tipo_identificacion(-1L);	
				parametrocarteradefecto.setid_tipo_nivel_edu(-1L);	
				parametrocarteradefecto.setid_pais_nacionalidad(-1L);	
				parametrocarteradefecto.setid_tipo_genero(-1L);	
				parametrocarteradefecto.setid_estado_civil(-1L);	
				parametrocarteradefecto.setid_estado_legal(-1L);	
				parametrocarteradefecto.setid_cuenta_contable(-1L);	
				parametrocarteradefecto.setid_vendedor(-1L);	
				parametrocarteradefecto.setid_ruta(-1L);	
				parametrocarteradefecto.setid_dia(-1L);	
				parametrocarteradefecto.setid_tipo_precio(-1L);	
				parametrocarteradefecto.setid_tipo_lista_precio(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroCarteraDefecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPONIVELEDU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDESTADOLEGAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDRUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDDIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraDefectoConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroCarteraDefecto(String sTipo,Row row,Workbook workbook,ParametroCarteraDefecto parametrocarteradefecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getregion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.gettiponiveledu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getpaisnacionalidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getestadolegal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getruta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.getdia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocarteradefecto.gettipolistaprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroCarteraDefecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroCarteraDefecto() {
		return this.sFinalQueryParametroCarteraDefecto;
	}
	
	public void setsFinalQueryParametroCarteraDefecto(String sFinalQueryParametroCarteraDefecto) {
		this.sFinalQueryParametroCarteraDefecto= sFinalQueryParametroCarteraDefecto;
	}
	
	public Border resaltarSeleccionarParametroCarteraDefecto=null;
	
	public Border setResaltarSeleccionarParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroCarteraDefecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroCarteraDefecto() {
		return this.resaltarSeleccionarParametroCarteraDefecto;
	}
	
	public void setResaltarSeleccionarParametroCarteraDefecto(Border borderResaltarSeleccionarParametroCarteraDefecto) {
		this.resaltarSeleccionarParametroCarteraDefecto= borderResaltarSeleccionarParametroCarteraDefecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroCarteraDefecto=null;
	public Boolean mostraridParametroCarteraDefecto=true;
	public Boolean activaridParametroCarteraDefecto=true;

	public Border resaltarid_empresaParametroCarteraDefecto=null;
	public Boolean mostrarid_empresaParametroCarteraDefecto=true;
	public Boolean activarid_empresaParametroCarteraDefecto=true;
	public Boolean cargarid_empresaParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroCarteraDefecto=null;
	public Boolean mostrarid_sucursalParametroCarteraDefecto=true;
	public Boolean activarid_sucursalParametroCarteraDefecto=true;
	public Boolean cargarid_sucursalParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_paisParametroCarteraDefecto=null;
	public Boolean mostrarid_paisParametroCarteraDefecto=true;
	public Boolean activarid_paisParametroCarteraDefecto=true;
	public Boolean cargarid_paisParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_regionParametroCarteraDefecto=null;
	public Boolean mostrarid_regionParametroCarteraDefecto=true;
	public Boolean activarid_regionParametroCarteraDefecto=true;
	public Boolean cargarid_regionParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_regionParametroCarteraDefecto=true;//ConEventDepend=true

	public Border resaltarid_provinciaParametroCarteraDefecto=null;
	public Boolean mostrarid_provinciaParametroCarteraDefecto=true;
	public Boolean activarid_provinciaParametroCarteraDefecto=true;
	public Boolean cargarid_provinciaParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaParametroCarteraDefecto=true;//ConEventDepend=true

	public Border resaltarid_ciudadParametroCarteraDefecto=null;
	public Boolean mostrarid_ciudadParametroCarteraDefecto=true;
	public Boolean activarid_ciudadParametroCarteraDefecto=true;
	public Boolean cargarid_ciudadParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadParametroCarteraDefecto=true;//ConEventDepend=true

	public Border resaltarid_zonaParametroCarteraDefecto=null;
	public Boolean mostrarid_zonaParametroCarteraDefecto=true;
	public Boolean activarid_zonaParametroCarteraDefecto=true;
	public Boolean cargarid_zonaParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_identificacionParametroCarteraDefecto=null;
	public Boolean mostrarid_tipo_identificacionParametroCarteraDefecto=true;
	public Boolean activarid_tipo_identificacionParametroCarteraDefecto=true;
	public Boolean cargarid_tipo_identificacionParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_identificacionParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_nivel_eduParametroCarteraDefecto=null;
	public Boolean mostrarid_tipo_nivel_eduParametroCarteraDefecto=true;
	public Boolean activarid_tipo_nivel_eduParametroCarteraDefecto=true;
	public Boolean cargarid_tipo_nivel_eduParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_nivel_eduParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_pais_nacionalidadParametroCarteraDefecto=null;
	public Boolean mostrarid_pais_nacionalidadParametroCarteraDefecto=true;
	public Boolean activarid_pais_nacionalidadParametroCarteraDefecto=true;
	public Boolean cargarid_pais_nacionalidadParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pais_nacionalidadParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoParametroCarteraDefecto=null;
	public Boolean mostrarid_tipo_generoParametroCarteraDefecto=true;
	public Boolean activarid_tipo_generoParametroCarteraDefecto=true;
	public Boolean cargarid_tipo_generoParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_estado_civilParametroCarteraDefecto=null;
	public Boolean mostrarid_estado_civilParametroCarteraDefecto=true;
	public Boolean activarid_estado_civilParametroCarteraDefecto=true;
	public Boolean cargarid_estado_civilParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_estado_legalParametroCarteraDefecto=null;
	public Boolean mostrarid_estado_legalParametroCarteraDefecto=true;
	public Boolean activarid_estado_legalParametroCarteraDefecto=true;
	public Boolean cargarid_estado_legalParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_legalParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableParametroCarteraDefecto=null;
	public Boolean mostrarid_cuenta_contableParametroCarteraDefecto=true;
	public Boolean activarid_cuenta_contableParametroCarteraDefecto=true;
	public Boolean cargarid_cuenta_contableParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_vendedorParametroCarteraDefecto=null;
	public Boolean mostrarid_vendedorParametroCarteraDefecto=true;
	public Boolean activarid_vendedorParametroCarteraDefecto=true;
	public Boolean cargarid_vendedorParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_rutaParametroCarteraDefecto=null;
	public Boolean mostrarid_rutaParametroCarteraDefecto=true;
	public Boolean activarid_rutaParametroCarteraDefecto=true;
	public Boolean cargarid_rutaParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rutaParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_diaParametroCarteraDefecto=null;
	public Boolean mostrarid_diaParametroCarteraDefecto=true;
	public Boolean activarid_diaParametroCarteraDefecto=true;
	public Boolean cargarid_diaParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_diaParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioParametroCarteraDefecto=null;
	public Boolean mostrarid_tipo_precioParametroCarteraDefecto=true;
	public Boolean activarid_tipo_precioParametroCarteraDefecto=true;
	public Boolean cargarid_tipo_precioParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioParametroCarteraDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_lista_precioParametroCarteraDefecto=null;
	public Boolean mostrarid_tipo_lista_precioParametroCarteraDefecto=true;
	public Boolean activarid_tipo_lista_precioParametroCarteraDefecto=true;
	public Boolean cargarid_tipo_lista_precioParametroCarteraDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_lista_precioParametroCarteraDefecto=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltaridParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroCarteraDefecto() {
		return this.resaltaridParametroCarteraDefecto;
	}

	public void setResaltaridParametroCarteraDefecto(Border borderResaltar) {
		this.resaltaridParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostraridParametroCarteraDefecto() {
		return this.mostraridParametroCarteraDefecto;
	}

	public void setMostraridParametroCarteraDefecto(Boolean mostraridParametroCarteraDefecto) {
		this.mostraridParametroCarteraDefecto= mostraridParametroCarteraDefecto;
	}

	public Boolean getActivaridParametroCarteraDefecto() {
		return this.activaridParametroCarteraDefecto;
	}

	public void setActivaridParametroCarteraDefecto(Boolean activaridParametroCarteraDefecto) {
		this.activaridParametroCarteraDefecto= activaridParametroCarteraDefecto;
	}

	public Border setResaltarid_empresaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroCarteraDefecto() {
		return this.resaltarid_empresaParametroCarteraDefecto;
	}

	public void setResaltarid_empresaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_empresaParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroCarteraDefecto() {
		return this.mostrarid_empresaParametroCarteraDefecto;
	}

	public void setMostrarid_empresaParametroCarteraDefecto(Boolean mostrarid_empresaParametroCarteraDefecto) {
		this.mostrarid_empresaParametroCarteraDefecto= mostrarid_empresaParametroCarteraDefecto;
	}

	public Boolean getActivarid_empresaParametroCarteraDefecto() {
		return this.activarid_empresaParametroCarteraDefecto;
	}

	public void setActivarid_empresaParametroCarteraDefecto(Boolean activarid_empresaParametroCarteraDefecto) {
		this.activarid_empresaParametroCarteraDefecto= activarid_empresaParametroCarteraDefecto;
	}

	public Boolean getCargarid_empresaParametroCarteraDefecto() {
		return this.cargarid_empresaParametroCarteraDefecto;
	}

	public void setCargarid_empresaParametroCarteraDefecto(Boolean cargarid_empresaParametroCarteraDefecto) {
		this.cargarid_empresaParametroCarteraDefecto= cargarid_empresaParametroCarteraDefecto;
	}

	public Border setResaltarid_sucursalParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroCarteraDefecto() {
		return this.resaltarid_sucursalParametroCarteraDefecto;
	}

	public void setResaltarid_sucursalParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_sucursalParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroCarteraDefecto() {
		return this.mostrarid_sucursalParametroCarteraDefecto;
	}

	public void setMostrarid_sucursalParametroCarteraDefecto(Boolean mostrarid_sucursalParametroCarteraDefecto) {
		this.mostrarid_sucursalParametroCarteraDefecto= mostrarid_sucursalParametroCarteraDefecto;
	}

	public Boolean getActivarid_sucursalParametroCarteraDefecto() {
		return this.activarid_sucursalParametroCarteraDefecto;
	}

	public void setActivarid_sucursalParametroCarteraDefecto(Boolean activarid_sucursalParametroCarteraDefecto) {
		this.activarid_sucursalParametroCarteraDefecto= activarid_sucursalParametroCarteraDefecto;
	}

	public Boolean getCargarid_sucursalParametroCarteraDefecto() {
		return this.cargarid_sucursalParametroCarteraDefecto;
	}

	public void setCargarid_sucursalParametroCarteraDefecto(Boolean cargarid_sucursalParametroCarteraDefecto) {
		this.cargarid_sucursalParametroCarteraDefecto= cargarid_sucursalParametroCarteraDefecto;
	}

	public Border setResaltarid_paisParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_paisParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisParametroCarteraDefecto() {
		return this.resaltarid_paisParametroCarteraDefecto;
	}

	public void setResaltarid_paisParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_paisParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_paisParametroCarteraDefecto() {
		return this.mostrarid_paisParametroCarteraDefecto;
	}

	public void setMostrarid_paisParametroCarteraDefecto(Boolean mostrarid_paisParametroCarteraDefecto) {
		this.mostrarid_paisParametroCarteraDefecto= mostrarid_paisParametroCarteraDefecto;
	}

	public Boolean getActivarid_paisParametroCarteraDefecto() {
		return this.activarid_paisParametroCarteraDefecto;
	}

	public void setActivarid_paisParametroCarteraDefecto(Boolean activarid_paisParametroCarteraDefecto) {
		this.activarid_paisParametroCarteraDefecto= activarid_paisParametroCarteraDefecto;
	}

	public Boolean getCargarid_paisParametroCarteraDefecto() {
		return this.cargarid_paisParametroCarteraDefecto;
	}

	public void setCargarid_paisParametroCarteraDefecto(Boolean cargarid_paisParametroCarteraDefecto) {
		this.cargarid_paisParametroCarteraDefecto= cargarid_paisParametroCarteraDefecto;
	}

	public Border setResaltarid_regionParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_regionParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_regionParametroCarteraDefecto() {
		return this.resaltarid_regionParametroCarteraDefecto;
	}

	public void setResaltarid_regionParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_regionParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_regionParametroCarteraDefecto() {
		return this.mostrarid_regionParametroCarteraDefecto;
	}

	public void setMostrarid_regionParametroCarteraDefecto(Boolean mostrarid_regionParametroCarteraDefecto) {
		this.mostrarid_regionParametroCarteraDefecto= mostrarid_regionParametroCarteraDefecto;
	}

	public Boolean getActivarid_regionParametroCarteraDefecto() {
		return this.activarid_regionParametroCarteraDefecto;
	}

	public void setActivarid_regionParametroCarteraDefecto(Boolean activarid_regionParametroCarteraDefecto) {
		this.activarid_regionParametroCarteraDefecto= activarid_regionParametroCarteraDefecto;
	}

	public Boolean getCargarid_regionParametroCarteraDefecto() {
		return this.cargarid_regionParametroCarteraDefecto;
	}

	public void setCargarid_regionParametroCarteraDefecto(Boolean cargarid_regionParametroCarteraDefecto) {
		this.cargarid_regionParametroCarteraDefecto= cargarid_regionParametroCarteraDefecto;
	}

	public Border setResaltarid_provinciaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_provinciaParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaParametroCarteraDefecto() {
		return this.resaltarid_provinciaParametroCarteraDefecto;
	}

	public void setResaltarid_provinciaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_provinciaParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_provinciaParametroCarteraDefecto() {
		return this.mostrarid_provinciaParametroCarteraDefecto;
	}

	public void setMostrarid_provinciaParametroCarteraDefecto(Boolean mostrarid_provinciaParametroCarteraDefecto) {
		this.mostrarid_provinciaParametroCarteraDefecto= mostrarid_provinciaParametroCarteraDefecto;
	}

	public Boolean getActivarid_provinciaParametroCarteraDefecto() {
		return this.activarid_provinciaParametroCarteraDefecto;
	}

	public void setActivarid_provinciaParametroCarteraDefecto(Boolean activarid_provinciaParametroCarteraDefecto) {
		this.activarid_provinciaParametroCarteraDefecto= activarid_provinciaParametroCarteraDefecto;
	}

	public Boolean getCargarid_provinciaParametroCarteraDefecto() {
		return this.cargarid_provinciaParametroCarteraDefecto;
	}

	public void setCargarid_provinciaParametroCarteraDefecto(Boolean cargarid_provinciaParametroCarteraDefecto) {
		this.cargarid_provinciaParametroCarteraDefecto= cargarid_provinciaParametroCarteraDefecto;
	}

	public Border setResaltarid_ciudadParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_ciudadParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadParametroCarteraDefecto() {
		return this.resaltarid_ciudadParametroCarteraDefecto;
	}

	public void setResaltarid_ciudadParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_ciudadParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_ciudadParametroCarteraDefecto() {
		return this.mostrarid_ciudadParametroCarteraDefecto;
	}

	public void setMostrarid_ciudadParametroCarteraDefecto(Boolean mostrarid_ciudadParametroCarteraDefecto) {
		this.mostrarid_ciudadParametroCarteraDefecto= mostrarid_ciudadParametroCarteraDefecto;
	}

	public Boolean getActivarid_ciudadParametroCarteraDefecto() {
		return this.activarid_ciudadParametroCarteraDefecto;
	}

	public void setActivarid_ciudadParametroCarteraDefecto(Boolean activarid_ciudadParametroCarteraDefecto) {
		this.activarid_ciudadParametroCarteraDefecto= activarid_ciudadParametroCarteraDefecto;
	}

	public Boolean getCargarid_ciudadParametroCarteraDefecto() {
		return this.cargarid_ciudadParametroCarteraDefecto;
	}

	public void setCargarid_ciudadParametroCarteraDefecto(Boolean cargarid_ciudadParametroCarteraDefecto) {
		this.cargarid_ciudadParametroCarteraDefecto= cargarid_ciudadParametroCarteraDefecto;
	}

	public Border setResaltarid_zonaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_zonaParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaParametroCarteraDefecto() {
		return this.resaltarid_zonaParametroCarteraDefecto;
	}

	public void setResaltarid_zonaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_zonaParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_zonaParametroCarteraDefecto() {
		return this.mostrarid_zonaParametroCarteraDefecto;
	}

	public void setMostrarid_zonaParametroCarteraDefecto(Boolean mostrarid_zonaParametroCarteraDefecto) {
		this.mostrarid_zonaParametroCarteraDefecto= mostrarid_zonaParametroCarteraDefecto;
	}

	public Boolean getActivarid_zonaParametroCarteraDefecto() {
		return this.activarid_zonaParametroCarteraDefecto;
	}

	public void setActivarid_zonaParametroCarteraDefecto(Boolean activarid_zonaParametroCarteraDefecto) {
		this.activarid_zonaParametroCarteraDefecto= activarid_zonaParametroCarteraDefecto;
	}

	public Boolean getCargarid_zonaParametroCarteraDefecto() {
		return this.cargarid_zonaParametroCarteraDefecto;
	}

	public void setCargarid_zonaParametroCarteraDefecto(Boolean cargarid_zonaParametroCarteraDefecto) {
		this.cargarid_zonaParametroCarteraDefecto= cargarid_zonaParametroCarteraDefecto;
	}

	public Border setResaltarid_tipo_identificacionParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_identificacionParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_identificacionParametroCarteraDefecto() {
		return this.resaltarid_tipo_identificacionParametroCarteraDefecto;
	}

	public void setResaltarid_tipo_identificacionParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_tipo_identificacionParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_identificacionParametroCarteraDefecto() {
		return this.mostrarid_tipo_identificacionParametroCarteraDefecto;
	}

	public void setMostrarid_tipo_identificacionParametroCarteraDefecto(Boolean mostrarid_tipo_identificacionParametroCarteraDefecto) {
		this.mostrarid_tipo_identificacionParametroCarteraDefecto= mostrarid_tipo_identificacionParametroCarteraDefecto;
	}

	public Boolean getActivarid_tipo_identificacionParametroCarteraDefecto() {
		return this.activarid_tipo_identificacionParametroCarteraDefecto;
	}

	public void setActivarid_tipo_identificacionParametroCarteraDefecto(Boolean activarid_tipo_identificacionParametroCarteraDefecto) {
		this.activarid_tipo_identificacionParametroCarteraDefecto= activarid_tipo_identificacionParametroCarteraDefecto;
	}

	public Boolean getCargarid_tipo_identificacionParametroCarteraDefecto() {
		return this.cargarid_tipo_identificacionParametroCarteraDefecto;
	}

	public void setCargarid_tipo_identificacionParametroCarteraDefecto(Boolean cargarid_tipo_identificacionParametroCarteraDefecto) {
		this.cargarid_tipo_identificacionParametroCarteraDefecto= cargarid_tipo_identificacionParametroCarteraDefecto;
	}

	public Border setResaltarid_tipo_nivel_eduParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_nivel_eduParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_nivel_eduParametroCarteraDefecto() {
		return this.resaltarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public void setResaltarid_tipo_nivel_eduParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_tipo_nivel_eduParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_nivel_eduParametroCarteraDefecto() {
		return this.mostrarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public void setMostrarid_tipo_nivel_eduParametroCarteraDefecto(Boolean mostrarid_tipo_nivel_eduParametroCarteraDefecto) {
		this.mostrarid_tipo_nivel_eduParametroCarteraDefecto= mostrarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public Boolean getActivarid_tipo_nivel_eduParametroCarteraDefecto() {
		return this.activarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public void setActivarid_tipo_nivel_eduParametroCarteraDefecto(Boolean activarid_tipo_nivel_eduParametroCarteraDefecto) {
		this.activarid_tipo_nivel_eduParametroCarteraDefecto= activarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public Boolean getCargarid_tipo_nivel_eduParametroCarteraDefecto() {
		return this.cargarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public void setCargarid_tipo_nivel_eduParametroCarteraDefecto(Boolean cargarid_tipo_nivel_eduParametroCarteraDefecto) {
		this.cargarid_tipo_nivel_eduParametroCarteraDefecto= cargarid_tipo_nivel_eduParametroCarteraDefecto;
	}

	public Border setResaltarid_pais_nacionalidadParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_pais_nacionalidadParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pais_nacionalidadParametroCarteraDefecto() {
		return this.resaltarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public void setResaltarid_pais_nacionalidadParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_pais_nacionalidadParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_pais_nacionalidadParametroCarteraDefecto() {
		return this.mostrarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public void setMostrarid_pais_nacionalidadParametroCarteraDefecto(Boolean mostrarid_pais_nacionalidadParametroCarteraDefecto) {
		this.mostrarid_pais_nacionalidadParametroCarteraDefecto= mostrarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public Boolean getActivarid_pais_nacionalidadParametroCarteraDefecto() {
		return this.activarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public void setActivarid_pais_nacionalidadParametroCarteraDefecto(Boolean activarid_pais_nacionalidadParametroCarteraDefecto) {
		this.activarid_pais_nacionalidadParametroCarteraDefecto= activarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public Boolean getCargarid_pais_nacionalidadParametroCarteraDefecto() {
		return this.cargarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public void setCargarid_pais_nacionalidadParametroCarteraDefecto(Boolean cargarid_pais_nacionalidadParametroCarteraDefecto) {
		this.cargarid_pais_nacionalidadParametroCarteraDefecto= cargarid_pais_nacionalidadParametroCarteraDefecto;
	}

	public Border setResaltarid_tipo_generoParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoParametroCarteraDefecto() {
		return this.resaltarid_tipo_generoParametroCarteraDefecto;
	}

	public void setResaltarid_tipo_generoParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_tipo_generoParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoParametroCarteraDefecto() {
		return this.mostrarid_tipo_generoParametroCarteraDefecto;
	}

	public void setMostrarid_tipo_generoParametroCarteraDefecto(Boolean mostrarid_tipo_generoParametroCarteraDefecto) {
		this.mostrarid_tipo_generoParametroCarteraDefecto= mostrarid_tipo_generoParametroCarteraDefecto;
	}

	public Boolean getActivarid_tipo_generoParametroCarteraDefecto() {
		return this.activarid_tipo_generoParametroCarteraDefecto;
	}

	public void setActivarid_tipo_generoParametroCarteraDefecto(Boolean activarid_tipo_generoParametroCarteraDefecto) {
		this.activarid_tipo_generoParametroCarteraDefecto= activarid_tipo_generoParametroCarteraDefecto;
	}

	public Boolean getCargarid_tipo_generoParametroCarteraDefecto() {
		return this.cargarid_tipo_generoParametroCarteraDefecto;
	}

	public void setCargarid_tipo_generoParametroCarteraDefecto(Boolean cargarid_tipo_generoParametroCarteraDefecto) {
		this.cargarid_tipo_generoParametroCarteraDefecto= cargarid_tipo_generoParametroCarteraDefecto;
	}

	public Border setResaltarid_estado_civilParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilParametroCarteraDefecto() {
		return this.resaltarid_estado_civilParametroCarteraDefecto;
	}

	public void setResaltarid_estado_civilParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_estado_civilParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilParametroCarteraDefecto() {
		return this.mostrarid_estado_civilParametroCarteraDefecto;
	}

	public void setMostrarid_estado_civilParametroCarteraDefecto(Boolean mostrarid_estado_civilParametroCarteraDefecto) {
		this.mostrarid_estado_civilParametroCarteraDefecto= mostrarid_estado_civilParametroCarteraDefecto;
	}

	public Boolean getActivarid_estado_civilParametroCarteraDefecto() {
		return this.activarid_estado_civilParametroCarteraDefecto;
	}

	public void setActivarid_estado_civilParametroCarteraDefecto(Boolean activarid_estado_civilParametroCarteraDefecto) {
		this.activarid_estado_civilParametroCarteraDefecto= activarid_estado_civilParametroCarteraDefecto;
	}

	public Boolean getCargarid_estado_civilParametroCarteraDefecto() {
		return this.cargarid_estado_civilParametroCarteraDefecto;
	}

	public void setCargarid_estado_civilParametroCarteraDefecto(Boolean cargarid_estado_civilParametroCarteraDefecto) {
		this.cargarid_estado_civilParametroCarteraDefecto= cargarid_estado_civilParametroCarteraDefecto;
	}

	public Border setResaltarid_estado_legalParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_estado_legalParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_legalParametroCarteraDefecto() {
		return this.resaltarid_estado_legalParametroCarteraDefecto;
	}

	public void setResaltarid_estado_legalParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_estado_legalParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_estado_legalParametroCarteraDefecto() {
		return this.mostrarid_estado_legalParametroCarteraDefecto;
	}

	public void setMostrarid_estado_legalParametroCarteraDefecto(Boolean mostrarid_estado_legalParametroCarteraDefecto) {
		this.mostrarid_estado_legalParametroCarteraDefecto= mostrarid_estado_legalParametroCarteraDefecto;
	}

	public Boolean getActivarid_estado_legalParametroCarteraDefecto() {
		return this.activarid_estado_legalParametroCarteraDefecto;
	}

	public void setActivarid_estado_legalParametroCarteraDefecto(Boolean activarid_estado_legalParametroCarteraDefecto) {
		this.activarid_estado_legalParametroCarteraDefecto= activarid_estado_legalParametroCarteraDefecto;
	}

	public Boolean getCargarid_estado_legalParametroCarteraDefecto() {
		return this.cargarid_estado_legalParametroCarteraDefecto;
	}

	public void setCargarid_estado_legalParametroCarteraDefecto(Boolean cargarid_estado_legalParametroCarteraDefecto) {
		this.cargarid_estado_legalParametroCarteraDefecto= cargarid_estado_legalParametroCarteraDefecto;
	}

	public Border setResaltarid_cuenta_contableParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableParametroCarteraDefecto() {
		return this.resaltarid_cuenta_contableParametroCarteraDefecto;
	}

	public void setResaltarid_cuenta_contableParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_cuenta_contableParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableParametroCarteraDefecto() {
		return this.mostrarid_cuenta_contableParametroCarteraDefecto;
	}

	public void setMostrarid_cuenta_contableParametroCarteraDefecto(Boolean mostrarid_cuenta_contableParametroCarteraDefecto) {
		this.mostrarid_cuenta_contableParametroCarteraDefecto= mostrarid_cuenta_contableParametroCarteraDefecto;
	}

	public Boolean getActivarid_cuenta_contableParametroCarteraDefecto() {
		return this.activarid_cuenta_contableParametroCarteraDefecto;
	}

	public void setActivarid_cuenta_contableParametroCarteraDefecto(Boolean activarid_cuenta_contableParametroCarteraDefecto) {
		this.activarid_cuenta_contableParametroCarteraDefecto= activarid_cuenta_contableParametroCarteraDefecto;
	}

	public Boolean getCargarid_cuenta_contableParametroCarteraDefecto() {
		return this.cargarid_cuenta_contableParametroCarteraDefecto;
	}

	public void setCargarid_cuenta_contableParametroCarteraDefecto(Boolean cargarid_cuenta_contableParametroCarteraDefecto) {
		this.cargarid_cuenta_contableParametroCarteraDefecto= cargarid_cuenta_contableParametroCarteraDefecto;
	}

	public Border setResaltarid_vendedorParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_vendedorParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorParametroCarteraDefecto() {
		return this.resaltarid_vendedorParametroCarteraDefecto;
	}

	public void setResaltarid_vendedorParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_vendedorParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_vendedorParametroCarteraDefecto() {
		return this.mostrarid_vendedorParametroCarteraDefecto;
	}

	public void setMostrarid_vendedorParametroCarteraDefecto(Boolean mostrarid_vendedorParametroCarteraDefecto) {
		this.mostrarid_vendedorParametroCarteraDefecto= mostrarid_vendedorParametroCarteraDefecto;
	}

	public Boolean getActivarid_vendedorParametroCarteraDefecto() {
		return this.activarid_vendedorParametroCarteraDefecto;
	}

	public void setActivarid_vendedorParametroCarteraDefecto(Boolean activarid_vendedorParametroCarteraDefecto) {
		this.activarid_vendedorParametroCarteraDefecto= activarid_vendedorParametroCarteraDefecto;
	}

	public Boolean getCargarid_vendedorParametroCarteraDefecto() {
		return this.cargarid_vendedorParametroCarteraDefecto;
	}

	public void setCargarid_vendedorParametroCarteraDefecto(Boolean cargarid_vendedorParametroCarteraDefecto) {
		this.cargarid_vendedorParametroCarteraDefecto= cargarid_vendedorParametroCarteraDefecto;
	}

	public Border setResaltarid_rutaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_rutaParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rutaParametroCarteraDefecto() {
		return this.resaltarid_rutaParametroCarteraDefecto;
	}

	public void setResaltarid_rutaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_rutaParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_rutaParametroCarteraDefecto() {
		return this.mostrarid_rutaParametroCarteraDefecto;
	}

	public void setMostrarid_rutaParametroCarteraDefecto(Boolean mostrarid_rutaParametroCarteraDefecto) {
		this.mostrarid_rutaParametroCarteraDefecto= mostrarid_rutaParametroCarteraDefecto;
	}

	public Boolean getActivarid_rutaParametroCarteraDefecto() {
		return this.activarid_rutaParametroCarteraDefecto;
	}

	public void setActivarid_rutaParametroCarteraDefecto(Boolean activarid_rutaParametroCarteraDefecto) {
		this.activarid_rutaParametroCarteraDefecto= activarid_rutaParametroCarteraDefecto;
	}

	public Boolean getCargarid_rutaParametroCarteraDefecto() {
		return this.cargarid_rutaParametroCarteraDefecto;
	}

	public void setCargarid_rutaParametroCarteraDefecto(Boolean cargarid_rutaParametroCarteraDefecto) {
		this.cargarid_rutaParametroCarteraDefecto= cargarid_rutaParametroCarteraDefecto;
	}

	public Border setResaltarid_diaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_diaParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_diaParametroCarteraDefecto() {
		return this.resaltarid_diaParametroCarteraDefecto;
	}

	public void setResaltarid_diaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_diaParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_diaParametroCarteraDefecto() {
		return this.mostrarid_diaParametroCarteraDefecto;
	}

	public void setMostrarid_diaParametroCarteraDefecto(Boolean mostrarid_diaParametroCarteraDefecto) {
		this.mostrarid_diaParametroCarteraDefecto= mostrarid_diaParametroCarteraDefecto;
	}

	public Boolean getActivarid_diaParametroCarteraDefecto() {
		return this.activarid_diaParametroCarteraDefecto;
	}

	public void setActivarid_diaParametroCarteraDefecto(Boolean activarid_diaParametroCarteraDefecto) {
		this.activarid_diaParametroCarteraDefecto= activarid_diaParametroCarteraDefecto;
	}

	public Boolean getCargarid_diaParametroCarteraDefecto() {
		return this.cargarid_diaParametroCarteraDefecto;
	}

	public void setCargarid_diaParametroCarteraDefecto(Boolean cargarid_diaParametroCarteraDefecto) {
		this.cargarid_diaParametroCarteraDefecto= cargarid_diaParametroCarteraDefecto;
	}

	public Border setResaltarid_tipo_precioParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioParametroCarteraDefecto() {
		return this.resaltarid_tipo_precioParametroCarteraDefecto;
	}

	public void setResaltarid_tipo_precioParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_tipo_precioParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioParametroCarteraDefecto() {
		return this.mostrarid_tipo_precioParametroCarteraDefecto;
	}

	public void setMostrarid_tipo_precioParametroCarteraDefecto(Boolean mostrarid_tipo_precioParametroCarteraDefecto) {
		this.mostrarid_tipo_precioParametroCarteraDefecto= mostrarid_tipo_precioParametroCarteraDefecto;
	}

	public Boolean getActivarid_tipo_precioParametroCarteraDefecto() {
		return this.activarid_tipo_precioParametroCarteraDefecto;
	}

	public void setActivarid_tipo_precioParametroCarteraDefecto(Boolean activarid_tipo_precioParametroCarteraDefecto) {
		this.activarid_tipo_precioParametroCarteraDefecto= activarid_tipo_precioParametroCarteraDefecto;
	}

	public Boolean getCargarid_tipo_precioParametroCarteraDefecto() {
		return this.cargarid_tipo_precioParametroCarteraDefecto;
	}

	public void setCargarid_tipo_precioParametroCarteraDefecto(Boolean cargarid_tipo_precioParametroCarteraDefecto) {
		this.cargarid_tipo_precioParametroCarteraDefecto= cargarid_tipo_precioParametroCarteraDefecto;
	}

	public Border setResaltarid_tipo_lista_precioParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteradefectoBeanSwingJInternalFrame.jTtoolBarParametroCarteraDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_lista_precioParametroCarteraDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_lista_precioParametroCarteraDefecto() {
		return this.resaltarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public void setResaltarid_tipo_lista_precioParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarid_tipo_lista_precioParametroCarteraDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_lista_precioParametroCarteraDefecto() {
		return this.mostrarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public void setMostrarid_tipo_lista_precioParametroCarteraDefecto(Boolean mostrarid_tipo_lista_precioParametroCarteraDefecto) {
		this.mostrarid_tipo_lista_precioParametroCarteraDefecto= mostrarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public Boolean getActivarid_tipo_lista_precioParametroCarteraDefecto() {
		return this.activarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public void setActivarid_tipo_lista_precioParametroCarteraDefecto(Boolean activarid_tipo_lista_precioParametroCarteraDefecto) {
		this.activarid_tipo_lista_precioParametroCarteraDefecto= activarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public Boolean getCargarid_tipo_lista_precioParametroCarteraDefecto() {
		return this.cargarid_tipo_lista_precioParametroCarteraDefecto;
	}

	public void setCargarid_tipo_lista_precioParametroCarteraDefecto(Boolean cargarid_tipo_lista_precioParametroCarteraDefecto) {
		this.cargarid_tipo_lista_precioParametroCarteraDefecto= cargarid_tipo_lista_precioParametroCarteraDefecto;
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
		
		
		this.setMostraridParametroCarteraDefecto(esInicial);
		this.setMostrarid_empresaParametroCarteraDefecto(esInicial);
		this.setMostrarid_sucursalParametroCarteraDefecto(esInicial);
		this.setMostrarid_paisParametroCarteraDefecto(esInicial);
		this.setMostrarid_regionParametroCarteraDefecto(esInicial);
		this.setMostrarid_provinciaParametroCarteraDefecto(esInicial);
		this.setMostrarid_ciudadParametroCarteraDefecto(esInicial);
		this.setMostrarid_zonaParametroCarteraDefecto(esInicial);
		this.setMostrarid_tipo_identificacionParametroCarteraDefecto(esInicial);
		this.setMostrarid_tipo_nivel_eduParametroCarteraDefecto(esInicial);
		this.setMostrarid_pais_nacionalidadParametroCarteraDefecto(esInicial);
		this.setMostrarid_tipo_generoParametroCarteraDefecto(esInicial);
		this.setMostrarid_estado_civilParametroCarteraDefecto(esInicial);
		this.setMostrarid_estado_legalParametroCarteraDefecto(esInicial);
		this.setMostrarid_cuenta_contableParametroCarteraDefecto(esInicial);
		this.setMostrarid_vendedorParametroCarteraDefecto(esInicial);
		this.setMostrarid_rutaParametroCarteraDefecto(esInicial);
		this.setMostrarid_diaParametroCarteraDefecto(esInicial);
		this.setMostrarid_tipo_precioParametroCarteraDefecto(esInicial);
		this.setMostrarid_tipo_lista_precioParametroCarteraDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.ID)) {
				this.setMostraridParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDREGION)) {
				this.setMostrarid_regionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostrarid_tipo_identificacionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU)) {
				this.setMostrarid_tipo_nivel_eduParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setMostrarid_pais_nacionalidadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL)) {
				this.setMostrarid_estado_legalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDRUTA)) {
				this.setMostrarid_rutaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDDIA)) {
				this.setMostrarid_diaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setMostrarid_tipo_lista_precioParametroCarteraDefecto(esAsigna);
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
		
		
		this.setActivaridParametroCarteraDefecto(esInicial);
		this.setActivarid_empresaParametroCarteraDefecto(esInicial);
		this.setActivarid_sucursalParametroCarteraDefecto(esInicial);
		this.setActivarid_paisParametroCarteraDefecto(esInicial);
		this.setActivarid_regionParametroCarteraDefecto(esInicial);
		this.setActivarid_provinciaParametroCarteraDefecto(esInicial);
		this.setActivarid_ciudadParametroCarteraDefecto(esInicial);
		this.setActivarid_zonaParametroCarteraDefecto(esInicial);
		this.setActivarid_tipo_identificacionParametroCarteraDefecto(esInicial);
		this.setActivarid_tipo_nivel_eduParametroCarteraDefecto(esInicial);
		this.setActivarid_pais_nacionalidadParametroCarteraDefecto(esInicial);
		this.setActivarid_tipo_generoParametroCarteraDefecto(esInicial);
		this.setActivarid_estado_civilParametroCarteraDefecto(esInicial);
		this.setActivarid_estado_legalParametroCarteraDefecto(esInicial);
		this.setActivarid_cuenta_contableParametroCarteraDefecto(esInicial);
		this.setActivarid_vendedorParametroCarteraDefecto(esInicial);
		this.setActivarid_rutaParametroCarteraDefecto(esInicial);
		this.setActivarid_diaParametroCarteraDefecto(esInicial);
		this.setActivarid_tipo_precioParametroCarteraDefecto(esInicial);
		this.setActivarid_tipo_lista_precioParametroCarteraDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.ID)) {
				this.setActivaridParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDREGION)) {
				this.setActivarid_regionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivarid_tipo_identificacionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU)) {
				this.setActivarid_tipo_nivel_eduParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setActivarid_pais_nacionalidadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL)) {
				this.setActivarid_estado_legalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDRUTA)) {
				this.setActivarid_rutaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDDIA)) {
				this.setActivarid_diaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setActivarid_tipo_lista_precioParametroCarteraDefecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroCarteraDefecto(esInicial);
		this.setResaltarid_empresaParametroCarteraDefecto(esInicial);
		this.setResaltarid_sucursalParametroCarteraDefecto(esInicial);
		this.setResaltarid_paisParametroCarteraDefecto(esInicial);
		this.setResaltarid_regionParametroCarteraDefecto(esInicial);
		this.setResaltarid_provinciaParametroCarteraDefecto(esInicial);
		this.setResaltarid_ciudadParametroCarteraDefecto(esInicial);
		this.setResaltarid_zonaParametroCarteraDefecto(esInicial);
		this.setResaltarid_tipo_identificacionParametroCarteraDefecto(esInicial);
		this.setResaltarid_tipo_nivel_eduParametroCarteraDefecto(esInicial);
		this.setResaltarid_pais_nacionalidadParametroCarteraDefecto(esInicial);
		this.setResaltarid_tipo_generoParametroCarteraDefecto(esInicial);
		this.setResaltarid_estado_civilParametroCarteraDefecto(esInicial);
		this.setResaltarid_estado_legalParametroCarteraDefecto(esInicial);
		this.setResaltarid_cuenta_contableParametroCarteraDefecto(esInicial);
		this.setResaltarid_vendedorParametroCarteraDefecto(esInicial);
		this.setResaltarid_rutaParametroCarteraDefecto(esInicial);
		this.setResaltarid_diaParametroCarteraDefecto(esInicial);
		this.setResaltarid_tipo_precioParametroCarteraDefecto(esInicial);
		this.setResaltarid_tipo_lista_precioParametroCarteraDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.ID)) {
				this.setResaltaridParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDREGION)) {
				this.setResaltarid_regionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltarid_tipo_identificacionParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU)) {
				this.setResaltarid_tipo_nivel_eduParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setResaltarid_pais_nacionalidadParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL)) {
				this.setResaltarid_estado_legalParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDRUTA)) {
				this.setResaltarid_rutaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDDIA)) {
				this.setResaltarid_diaParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioParametroCarteraDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setResaltarid_tipo_lista_precioParametroCarteraDefecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdCiudadParametroCarteraDefecto() {
		return this.mostrarFK_IdCiudadParametroCarteraDefecto;
	}

	public void setMostrarFK_IdCiudadParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdCuentaContableParametroCarteraDefecto() {
		return this.mostrarFK_IdCuentaContableParametroCarteraDefecto;
	}

	public void setMostrarFK_IdCuentaContableParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDiaParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdDiaParametroCarteraDefecto() {
		return this.mostrarFK_IdDiaParametroCarteraDefecto;
	}

	public void setMostrarFK_IdDiaParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDiaParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdEmpresaParametroCarteraDefecto() {
		return this.mostrarFK_IdEmpresaParametroCarteraDefecto;
	}

	public void setMostrarFK_IdEmpresaParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCivilParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdEstadoCivilParametroCarteraDefecto() {
		return this.mostrarFK_IdEstadoCivilParametroCarteraDefecto;
	}

	public void setMostrarFK_IdEstadoCivilParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCivilParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoLegalParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdEstadoLegalParametroCarteraDefecto() {
		return this.mostrarFK_IdEstadoLegalParametroCarteraDefecto;
	}

	public void setMostrarFK_IdEstadoLegalParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoLegalParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdPaisParametroCarteraDefecto() {
		return this.mostrarFK_IdPaisParametroCarteraDefecto;
	}

	public void setMostrarFK_IdPaisParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisNacionalidadParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdPaisNacionalidadParametroCarteraDefecto() {
		return this.mostrarFK_IdPaisNacionalidadParametroCarteraDefecto;
	}

	public void setMostrarFK_IdPaisNacionalidadParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisNacionalidadParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdProvinciaParametroCarteraDefecto() {
		return this.mostrarFK_IdProvinciaParametroCarteraDefecto;
	}

	public void setMostrarFK_IdProvinciaParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRegionParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdRegionParametroCarteraDefecto() {
		return this.mostrarFK_IdRegionParametroCarteraDefecto;
	}

	public void setMostrarFK_IdRegionParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRegionParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRutaParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdRutaParametroCarteraDefecto() {
		return this.mostrarFK_IdRutaParametroCarteraDefecto;
	}

	public void setMostrarFK_IdRutaParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRutaParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdSucursalParametroCarteraDefecto() {
		return this.mostrarFK_IdSucursalParametroCarteraDefecto;
	}

	public void setMostrarFK_IdSucursalParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGeneroParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdTipoGeneroParametroCarteraDefecto() {
		return this.mostrarFK_IdTipoGeneroParametroCarteraDefecto;
	}

	public void setMostrarFK_IdTipoGeneroParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGeneroParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIdentificacionParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdTipoIdentificacionParametroCarteraDefecto() {
		return this.mostrarFK_IdTipoIdentificacionParametroCarteraDefecto;
	}

	public void setMostrarFK_IdTipoIdentificacionParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIdentificacionParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoListaPrecioParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdTipoListaPrecioParametroCarteraDefecto() {
		return this.mostrarFK_IdTipoListaPrecioParametroCarteraDefecto;
	}

	public void setMostrarFK_IdTipoListaPrecioParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoListaPrecioParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoNivelEduParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdTipoNivelEduParametroCarteraDefecto() {
		return this.mostrarFK_IdTipoNivelEduParametroCarteraDefecto;
	}

	public void setMostrarFK_IdTipoNivelEduParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoNivelEduParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdTipoPrecioParametroCarteraDefecto() {
		return this.mostrarFK_IdTipoPrecioParametroCarteraDefecto;
	}

	public void setMostrarFK_IdTipoPrecioParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdVendedorParametroCarteraDefecto() {
		return this.mostrarFK_IdVendedorParametroCarteraDefecto;
	}

	public void setMostrarFK_IdVendedorParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorParametroCarteraDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaParametroCarteraDefecto=true;

	public Boolean getMostrarFK_IdZonaParametroCarteraDefecto() {
		return this.mostrarFK_IdZonaParametroCarteraDefecto;
	}

	public void setMostrarFK_IdZonaParametroCarteraDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaParametroCarteraDefecto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdCiudadParametroCarteraDefecto() {
		return this.activarFK_IdCiudadParametroCarteraDefecto;
	}

	public void setActivarFK_IdCiudadParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdCuentaContableParametroCarteraDefecto() {
		return this.activarFK_IdCuentaContableParametroCarteraDefecto;
	}

	public void setActivarFK_IdCuentaContableParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdDiaParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdDiaParametroCarteraDefecto() {
		return this.activarFK_IdDiaParametroCarteraDefecto;
	}

	public void setActivarFK_IdDiaParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdDiaParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdEmpresaParametroCarteraDefecto() {
		return this.activarFK_IdEmpresaParametroCarteraDefecto;
	}

	public void setActivarFK_IdEmpresaParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCivilParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdEstadoCivilParametroCarteraDefecto() {
		return this.activarFK_IdEstadoCivilParametroCarteraDefecto;
	}

	public void setActivarFK_IdEstadoCivilParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCivilParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoLegalParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdEstadoLegalParametroCarteraDefecto() {
		return this.activarFK_IdEstadoLegalParametroCarteraDefecto;
	}

	public void setActivarFK_IdEstadoLegalParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoLegalParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdPaisParametroCarteraDefecto() {
		return this.activarFK_IdPaisParametroCarteraDefecto;
	}

	public void setActivarFK_IdPaisParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdPaisParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisNacionalidadParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdPaisNacionalidadParametroCarteraDefecto() {
		return this.activarFK_IdPaisNacionalidadParametroCarteraDefecto;
	}

	public void setActivarFK_IdPaisNacionalidadParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdPaisNacionalidadParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdProvinciaParametroCarteraDefecto() {
		return this.activarFK_IdProvinciaParametroCarteraDefecto;
	}

	public void setActivarFK_IdProvinciaParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdRegionParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdRegionParametroCarteraDefecto() {
		return this.activarFK_IdRegionParametroCarteraDefecto;
	}

	public void setActivarFK_IdRegionParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdRegionParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdRutaParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdRutaParametroCarteraDefecto() {
		return this.activarFK_IdRutaParametroCarteraDefecto;
	}

	public void setActivarFK_IdRutaParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdRutaParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdSucursalParametroCarteraDefecto() {
		return this.activarFK_IdSucursalParametroCarteraDefecto;
	}

	public void setActivarFK_IdSucursalParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGeneroParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdTipoGeneroParametroCarteraDefecto() {
		return this.activarFK_IdTipoGeneroParametroCarteraDefecto;
	}

	public void setActivarFK_IdTipoGeneroParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGeneroParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIdentificacionParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdTipoIdentificacionParametroCarteraDefecto() {
		return this.activarFK_IdTipoIdentificacionParametroCarteraDefecto;
	}

	public void setActivarFK_IdTipoIdentificacionParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIdentificacionParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoListaPrecioParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdTipoListaPrecioParametroCarteraDefecto() {
		return this.activarFK_IdTipoListaPrecioParametroCarteraDefecto;
	}

	public void setActivarFK_IdTipoListaPrecioParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoListaPrecioParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoNivelEduParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdTipoNivelEduParametroCarteraDefecto() {
		return this.activarFK_IdTipoNivelEduParametroCarteraDefecto;
	}

	public void setActivarFK_IdTipoNivelEduParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoNivelEduParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdTipoPrecioParametroCarteraDefecto() {
		return this.activarFK_IdTipoPrecioParametroCarteraDefecto;
	}

	public void setActivarFK_IdTipoPrecioParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdVendedorParametroCarteraDefecto() {
		return this.activarFK_IdVendedorParametroCarteraDefecto;
	}

	public void setActivarFK_IdVendedorParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorParametroCarteraDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaParametroCarteraDefecto=true;

	public Boolean getActivarFK_IdZonaParametroCarteraDefecto() {
		return this.activarFK_IdZonaParametroCarteraDefecto;
	}

	public void setActivarFK_IdZonaParametroCarteraDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdZonaParametroCarteraDefecto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadParametroCarteraDefecto=null;

	public Border getResaltarFK_IdCiudadParametroCarteraDefecto() {
		return this.resaltarFK_IdCiudadParametroCarteraDefecto;
	}

	public void setResaltarFK_IdCiudadParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdCiudadParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdCiudadParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableParametroCarteraDefecto=null;

	public Border getResaltarFK_IdCuentaContableParametroCarteraDefecto() {
		return this.resaltarFK_IdCuentaContableParametroCarteraDefecto;
	}

	public void setResaltarFK_IdCuentaContableParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdDiaParametroCarteraDefecto=null;

	public Border getResaltarFK_IdDiaParametroCarteraDefecto() {
		return this.resaltarFK_IdDiaParametroCarteraDefecto;
	}

	public void setResaltarFK_IdDiaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdDiaParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdDiaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDiaParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroCarteraDefecto=null;

	public Border getResaltarFK_IdEmpresaParametroCarteraDefecto() {
		return this.resaltarFK_IdEmpresaParametroCarteraDefecto;
	}

	public void setResaltarFK_IdEmpresaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCivilParametroCarteraDefecto=null;

	public Border getResaltarFK_IdEstadoCivilParametroCarteraDefecto() {
		return this.resaltarFK_IdEstadoCivilParametroCarteraDefecto;
	}

	public void setResaltarFK_IdEstadoCivilParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdEstadoCivilParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCivilParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCivilParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEstadoLegalParametroCarteraDefecto=null;

	public Border getResaltarFK_IdEstadoLegalParametroCarteraDefecto() {
		return this.resaltarFK_IdEstadoLegalParametroCarteraDefecto;
	}

	public void setResaltarFK_IdEstadoLegalParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdEstadoLegalParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEstadoLegalParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoLegalParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdPaisParametroCarteraDefecto=null;

	public Border getResaltarFK_IdPaisParametroCarteraDefecto() {
		return this.resaltarFK_IdPaisParametroCarteraDefecto;
	}

	public void setResaltarFK_IdPaisParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdPaisParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdPaisParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdPaisNacionalidadParametroCarteraDefecto=null;

	public Border getResaltarFK_IdPaisNacionalidadParametroCarteraDefecto() {
		return this.resaltarFK_IdPaisNacionalidadParametroCarteraDefecto;
	}

	public void setResaltarFK_IdPaisNacionalidadParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdPaisNacionalidadParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdPaisNacionalidadParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisNacionalidadParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaParametroCarteraDefecto=null;

	public Border getResaltarFK_IdProvinciaParametroCarteraDefecto() {
		return this.resaltarFK_IdProvinciaParametroCarteraDefecto;
	}

	public void setResaltarFK_IdProvinciaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdProvinciaParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdRegionParametroCarteraDefecto=null;

	public Border getResaltarFK_IdRegionParametroCarteraDefecto() {
		return this.resaltarFK_IdRegionParametroCarteraDefecto;
	}

	public void setResaltarFK_IdRegionParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdRegionParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdRegionParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRegionParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdRutaParametroCarteraDefecto=null;

	public Border getResaltarFK_IdRutaParametroCarteraDefecto() {
		return this.resaltarFK_IdRutaParametroCarteraDefecto;
	}

	public void setResaltarFK_IdRutaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdRutaParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdRutaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRutaParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroCarteraDefecto=null;

	public Border getResaltarFK_IdSucursalParametroCarteraDefecto() {
		return this.resaltarFK_IdSucursalParametroCarteraDefecto;
	}

	public void setResaltarFK_IdSucursalParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoGeneroParametroCarteraDefecto=null;

	public Border getResaltarFK_IdTipoGeneroParametroCarteraDefecto() {
		return this.resaltarFK_IdTipoGeneroParametroCarteraDefecto;
	}

	public void setResaltarFK_IdTipoGeneroParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoGeneroParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoGeneroParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGeneroParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoIdentificacionParametroCarteraDefecto=null;

	public Border getResaltarFK_IdTipoIdentificacionParametroCarteraDefecto() {
		return this.resaltarFK_IdTipoIdentificacionParametroCarteraDefecto;
	}

	public void setResaltarFK_IdTipoIdentificacionParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoIdentificacionParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoIdentificacionParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIdentificacionParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoListaPrecioParametroCarteraDefecto=null;

	public Border getResaltarFK_IdTipoListaPrecioParametroCarteraDefecto() {
		return this.resaltarFK_IdTipoListaPrecioParametroCarteraDefecto;
	}

	public void setResaltarFK_IdTipoListaPrecioParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoListaPrecioParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoListaPrecioParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoListaPrecioParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoNivelEduParametroCarteraDefecto=null;

	public Border getResaltarFK_IdTipoNivelEduParametroCarteraDefecto() {
		return this.resaltarFK_IdTipoNivelEduParametroCarteraDefecto;
	}

	public void setResaltarFK_IdTipoNivelEduParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoNivelEduParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoNivelEduParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoNivelEduParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioParametroCarteraDefecto=null;

	public Border getResaltarFK_IdTipoPrecioParametroCarteraDefecto() {
		return this.resaltarFK_IdTipoPrecioParametroCarteraDefecto;
	}

	public void setResaltarFK_IdTipoPrecioParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdVendedorParametroCarteraDefecto=null;

	public Border getResaltarFK_IdVendedorParametroCarteraDefecto() {
		return this.resaltarFK_IdVendedorParametroCarteraDefecto;
	}

	public void setResaltarFK_IdVendedorParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdVendedorParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdVendedorParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorParametroCarteraDefecto= borderResaltar;
	}

	public Border resaltarFK_IdZonaParametroCarteraDefecto=null;

	public Border getResaltarFK_IdZonaParametroCarteraDefecto() {
		return this.resaltarFK_IdZonaParametroCarteraDefecto;
	}

	public void setResaltarFK_IdZonaParametroCarteraDefecto(Border borderResaltar) {
		this.resaltarFK_IdZonaParametroCarteraDefecto= borderResaltar;
	}

	public void setResaltarFK_IdZonaParametroCarteraDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraDefectoBeanSwingJInternalFrame parametrocarteradefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaParametroCarteraDefecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}